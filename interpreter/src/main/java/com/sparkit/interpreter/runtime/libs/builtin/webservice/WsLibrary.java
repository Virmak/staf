package com.sparkit.interpreter.runtime.libs.builtin.webservice;

import com.sparkit.interpreter.Main;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.types.StafDictionary;
import com.sparkit.interpreter.runtime.libs.AbstractStafLibrary;
import com.sparkit.interpreter.runtime.libs.annotations.Keyword;
import com.sparkit.interpreter.runtime.libs.annotations.StafLibrary;
import com.sparkit.interpreter.runtime.libs.builtin.webservice.exceptions.WebServiceTestFailedException;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@StafLibrary(name = "ws")
public class WsLibrary extends AbstractStafLibrary {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Keyword(name = "get")
    public void getRequest(AbstractStafObject path, AbstractStafObject jsonPath, AbstractStafObject condition,
                           AbstractStafObject expected, AbstractStafObject statusCode) throws WebServiceTestFailedException {
        try {
            get((String) path.getValue())
                    .then()
                    .assertThat()
                    .body(jsonPath.getValue().toString(), getMatcher(condition, expected))
                    .statusCode((Integer) statusCode.getValue());
            ;
        } catch (Exception e) {
            throw new WebServiceTestFailedException(path.getValue().toString(), e.getMessage());
        }
        logger.info("WS GET test passed : " + path.getValue());
    }

    @Keyword(name = "post")
    public void postRequest(AbstractStafObject path, StafDictionary parametersDict, AbstractStafObject jsonPath,
                            AbstractStafObject condition, AbstractStafObject expected, AbstractStafObject statusCode) throws WebServiceTestFailedException {
        try {
            given()
                    .contentType(ContentType.JSON)
                    .body(parametersDict.toJSON().toJSONString())
                    .post(path.getValue().toString())
                    .then()
                    .assertThat()
                    .statusCode((Integer) statusCode.getValue())
                    .body(jsonPath.getValue().toString(), getMatcher(condition, expected));
            logger.info("WS POST passed : " + path.getValue());
        } catch (Exception e) {
            throw new WebServiceTestFailedException(path.getValue().toString(), e.getMessage());
        }
    }

    public Matcher<?> getMatcher(AbstractStafObject condition, AbstractStafObject expected) {
        if (condition.getValue().equals("equalTo")) {
            return equalTo(expected.getValue());
        }
        return null;
    }
}
