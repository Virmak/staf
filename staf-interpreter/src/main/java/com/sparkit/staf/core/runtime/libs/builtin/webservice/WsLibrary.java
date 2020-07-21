package com.sparkit.staf.core.runtime.libs.builtin.webservice;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDictionary;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.builtin.webservice.exceptions.WebServiceTestFailedException;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@StafLibrary(name = "API testing library")
public class WsLibrary extends AbstractStafLibrary {

    private static final Logger logger = LoggerFactory.getLogger(WsLibrary.class);

    @Keyword(name = "get")
    public void getRequest(@KeywordArgument(name = "path") StafString path, @KeywordArgument(name = "jsonPath") StafString jsonPath,
                           @KeywordArgument(name = "condition") StafString condition,
                           @KeywordArgument(name = "expected") AbstractStafObject expected,
                           @KeywordArgument(name = "statusCode") StafInteger statusCode) throws WebServiceTestFailedException {
        try {
            get(path.getValue())
                    .then()
                    .assertThat()
                    .body(jsonPath.getValue(), getMatcher(condition, expected))
                    .statusCode((Integer) statusCode.getValue());
        } catch (Exception e) {
            throw new WebServiceTestFailedException(path.getValue(), e.getMessage());
        }
        logger.info("WS GET test passed : {}", path.getValue());
    }

    @Keyword(name = "post")
    public void postRequest(@KeywordArgument(name = "path") StafString path, @KeywordArgument(name = "params") StafDictionary parametersDict,
                            @KeywordArgument(name = "jsonPath") StafString jsonPath,
                            @KeywordArgument(name = "condition") AbstractStafObject condition,
                            @KeywordArgument(name = "expected") AbstractStafObject expected,
                            @KeywordArgument(name = "statusCode") StafInteger statusCode) throws WebServiceTestFailedException {
        try {
            given()
                    .contentType(ContentType.JSON)
                    .body(parametersDict.toJSON().toJSONString())
                    .post(path.getValue())
                    .then()
                    .assertThat()
                    .statusCode((Integer) statusCode.getValue())
                    .body(jsonPath.getValue(), getMatcher(condition, expected));
            logger.info("WS POST passed : {}", path.getValue());
        } catch (Exception e) {
            throw new WebServiceTestFailedException(path.getValue(), e.getMessage());
        }
    }

    public Matcher<?> getMatcher(AbstractStafObject condition, AbstractStafObject expected) {
        if (condition.getValue().equals("equalTo")) {
            return equalTo(expected.getValue());
        }
        return null;
    }
}
