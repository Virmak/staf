package com.sparkit.staf.core.runtime.libs.builtin;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.sparkit.staf.core.ast.KeyValuePair;
import com.sparkit.staf.core.ast.types.*;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Inject;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@StafLibrary(name = "Csv Library")
public class CsvLibrary extends AbstractStafLibrary {

    @Keyword(name = "read csv")
    public StafList readCsv(@Inject(name = "__keyword__") KeywordCall keywordCall, @KeywordArgument(name = "filePath") StafString filePath)
            throws IOException {
        Reader reader = Files.newBufferedReader(getCSVFilePath(keywordCall.getPosition().getFilePath(), (String) filePath.getValue()));
        List<String[]> list;
        StafList stafList = new StafList();
        try (CSVReader csvReader = new CSVReader(reader)) {
            list = csvReader.readAll();
            reader.close();
            for (int i = 1; i < list.size(); i++) {
                stafList.addListItem(createDictionaryFromCsvLine(list.get(0), list.get(i)));
            }
        }
        return stafList;
    }

    @Keyword(name = "write csv")
    public void writeCsv(@Inject(name = "__keyword__") KeywordCall keywordCall, @KeywordArgument(name = "filePath") StafString filePath,
                         @KeywordArgument(name = "list") StafList stafList) throws IOException {
        Path csvFilePath = getCSVFilePath(keywordCall.getPosition().getFilePath(), (String) filePath.getValue());
        List<String[]> lines = new ArrayList<>();
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath.toString()),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.RFC4180_LINE_END)) {
            StafDictionary firstDict = (StafDictionary) stafList.getStafList().get(0);
            String[] firstLine = firstDict.getObjectMap().keySet().toArray(new String[0]); // first line for dictionaries keys
            lines.add(firstLine);
            for (int i = 1; i < stafList.getStafList().size(); i++) {
                lines.add(getStringArrayFromDictionary((StafDictionary) stafList.getStafList().get(i)));
            }
            writer.writeAll(lines);
        }

    }

    private String[] getStringArrayFromDictionary(StafDictionary dictionary) {
        return dictionary.getObjectMap().values().stream().map(v -> v.getValue().toString()).toArray(String[]::new);
    }

    private StafDictionary createDictionaryFromCsvLine(String[] headerLine, String[] line) {
        StafDictionary dictionary = new StafDictionary();
        for (int i = 0; i < headerLine.length; i++) {
            KeyValuePair keyValuePair = new KeyValuePair(headerLine[i], AbstractStafObject.fromObject(line[i]));
            dictionary.putKeyValuePair(keyValuePair);
        }
        return dictionary;
    }

    private Path getCSVFilePath(String keywordDeclarationFilePath, String csvFilePath) {
        Path csvFile = Paths.get(csvFilePath);
        if (csvFile.isAbsolute()) {
            return csvFile;
        }
        File scriptFile = new File(keywordDeclarationFilePath);
        return Paths.get(scriptFile.getParentFile().getPath(), csvFilePath);
    }

}
