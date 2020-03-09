package com.sparkit.staf.runtime.libs.builtin;

import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.runtime.interpreter.TestSuite;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.runtime.libs.dependencies.DependencyContainer;
import com.sparkit.staf.runtime.libs.dependencies.exceptions.DependencyTypeNotFoundException;
import com.sparkit.staf.runtime.libs.exceptions.JSONFileNotFoundException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@StafLibrary(name = "json", builtin = true)
public class JsonLibrary extends AbstractStafLibrary {
    private JSONParser parser;

    public JsonLibrary(DependencyContainer container) throws DependencyTypeNotFoundException {
        super(container);
        parser = (JSONParser) container.getDependency(JSONParser.class);
    }

    @Keyword(name = "load json")
    public AbstractStafObject loadJsonFile(AbstractStafObject filePath) throws JSONFileNotFoundException, DependencyTypeNotFoundException {
        TestSuite testSuite = (TestSuite) container.getDependency(TestSuite.class);
        try (Reader reader = new FileReader(testSuite.getFullPath() + "/" + filePath.getValue())) {
            Object jsonObject = parser.parse(reader);
            return AbstractStafObject.fromObject(jsonObject);
        } catch (IOException | ParseException e) {
            throw new JSONFileNotFoundException();
        }
    }
}
