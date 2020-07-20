package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Inject;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.exceptions.JSONFileNotFoundException;
import org.json.simple.JSONAware;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

@StafLibrary(name = "Json Library", builtin = true)
public class JsonLibrary extends AbstractStafLibrary {
    @Autowired
    private JSONParser jsonParser;

    @Keyword(name = "read json")
    public AbstractStafObject loadJsonFile(@Inject(name = "__keyword__") KeywordCall keywordCall, @KeywordArgument(name = "filePath") StafString filePath) {
        File directory = new File(keywordCall.getPosition().getFilePath()).getParentFile();
        File fullPath = new File(directory, filePath.getValue().toString());
        try (Reader reader = new FileReader(fullPath.getCanonicalFile())) {
            Object jsonObject = jsonParser.parse(reader);
            return AbstractStafObject.fromObject(jsonObject);
        } catch (IOException | ParseException e) {
            throw new JSONFileNotFoundException();
        }
    }

    @Keyword(name = "write json")
    public void writeJsonFile(@Inject(name = "__keyword__") KeywordCall keywordCall, @KeywordArgument(name = "object") AbstractStafObject stafObject,
                              @KeywordArgument(name = "filePath") StafString filePath) throws IOException {
        File directory = new File(keywordCall.getPosition().getFilePath()).getParentFile();
        String fullPath = new File(directory, filePath.getValue().toString()).getCanonicalPath();
        JSONAware jsonObject;

        try (FileWriter fileWriter = new FileWriter(fullPath)) {
            jsonObject = (JSONAware) stafObject.toJSON();
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException ignored) {

        }
    }

    @Keyword(name = "parse json")
    public AbstractStafObject parseJsonString(@KeywordArgument(name = "jsonString") StafString jsonString) throws ParseException {
        Object jsonObject = jsonParser.parse(jsonString.getValue());
        return AbstractStafObject.fromObject(jsonObject);
    }
}
