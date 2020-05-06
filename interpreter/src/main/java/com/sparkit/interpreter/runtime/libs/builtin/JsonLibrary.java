package com.sparkit.interpreter.runtime.libs.builtin;

import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.libs.AbstractStafLibrary;
import com.sparkit.interpreter.runtime.libs.annotations.Keyword;
import com.sparkit.interpreter.runtime.libs.annotations.StafLibrary;
import com.sparkit.interpreter.runtime.libs.exceptions.JSONFileNotFoundException;
import junit.framework.TestSuite;
import org.json.simple.JSONAware;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

@StafLibrary(name = "json", builtin = true)
public class JsonLibrary extends AbstractStafLibrary {
    @Autowired
    private JSONParser parser;

    @Keyword(name = "read json")
    public AbstractStafObject loadJsonFile(AbstractStafObject filePath) throws JSONFileNotFoundException {
        /*** Refactor ***/
        /*TestSuite testSuite = container.getTestSuite();
        File directory = new File(testSuite.getFullPath());*/
        File fullPath = new File(filePath.getValue().toString());
        try (Reader reader = new FileReader(fullPath.getCanonicalFile())) {
            Object jsonObject = parser.parse(reader);
            return AbstractStafObject.fromObject(jsonObject);
        } catch (IOException | ParseException e) {
            throw new JSONFileNotFoundException();
        }
    }

    @Keyword(name = "write json")
    public void writeJsonFile(AbstractStafObject obj, AbstractStafObject filePath) throws IOException {
        /*** Refactor ***/
        /*TestSuite testSuite = container.getTestSuite();
        File directory = new File(testSuite.getFullPath());*/
        String fullPath = new File(filePath.getValue().toString()).getCanonicalPath();
        JSONAware jsonObject;

        try (FileWriter fileWriter = new FileWriter(fullPath)) {
            jsonObject = (JSONAware) obj.toJSON();
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException e) {

        }

    }
}
