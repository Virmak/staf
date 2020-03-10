package com.sparkit.staf.runtime.libs.builtin.webservice;

import com.sparkit.staf.Main;
import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.ast.types.StafDictionary;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.runtime.libs.builtin.webservice.exceptions.WebServiceTestFailedException;
import com.sparkit.staf.runtime.libs.dependencies.DependencyContainer;
import com.sparkit.staf.runtime.libs.dependencies.exceptions.DependencyTypeNotFoundException;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@StafLibrary(name = "ws")
public class WsLibrary extends AbstractStafLibrary {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public WsLibrary(DependencyContainer container) throws DependencyTypeNotFoundException {
        super(container);
    }

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
        LOG.info("WS GET test passed : " + path.getValue());
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
            LOG.info("WS POST passed : " + path.getValue());
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
