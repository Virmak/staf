package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.dependencies.DependencyContainer;
import com.sparkit.staf.core.runtime.libs.dependencies.exceptions.DependencyTypeNotFoundException;
import com.sparkit.staf.core.runtime.libs.exceptions.JSONFileNotFoundException;
import com.sparkit.staf.core.runtime.interpreter.TestSuite;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import org.json.simple.JSONAware;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

@StafLibrary(name = "json", builtin = true)
public class JsonLibrary extends AbstractStafLibrary {
    private JSONParser parser;

    public JsonLibrary(DependencyContainer container) throws DependencyTypeNotFoundException {
        super(container);
        parser = (JSONParser) container.getDependency(JSONParser.class);
    }

    @Keyword(name = "read json")
    public AbstractStafObject loadJsonFile(AbstractStafObject filePath) throws JSONFileNotFoundException, DependencyTypeNotFoundException {
        TestSuite testSuite = (TestSuite) container.getDependency(TestSuite.class);
        File directory = new File(testSuite.getFullPath());
        File fullPath = new File(directory, filePath.getValue().toString());
        try (Reader reader = new FileReader(fullPath.getCanonicalFile())) {
            Object jsonObject = parser.parse(reader);
            return AbstractStafObject.fromObject(jsonObject);
        } catch (IOException | ParseException e) {
            throw new JSONFileNotFoundException();
        }
    }

    @Keyword(name = "write json")
    public void writeJsonFile(AbstractStafObject obj, AbstractStafObject filePath) throws DependencyTypeNotFoundException, IOException {
        TestSuite testSuite = (TestSuite) container.getDependency(TestSuite.class);
        File directory = new File(testSuite.getFullPath());
        String fullPath = new File(directory, filePath.getValue().toString()).getCanonicalPath();
        JSONAware jsonObject;

        try (FileWriter fileWriter = new FileWriter(fullPath)) {
            jsonObject = (JSONAware) obj.toJSON();
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException e) {

        }

    }
}
