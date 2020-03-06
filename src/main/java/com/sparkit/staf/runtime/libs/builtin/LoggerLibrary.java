package com.sparkit.staf.runtime.libs.builtin;

import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@StafLibrary(name = "logger", builtin = true)
public class LoggerLibrary extends AbstractStafLibrary {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String logData = "\n\nTEST STARTED AT : " +  formatter.format(new Date())  + "\n\n";

    @Keyword(name = "log")
    public void log(@KeywordArgument AbstractStafObject data) {
        System.out.println("LOG : " + data.getValue());
        logData = logData.concat("LOG : " + data.getValue() + "\n");
    }

    @Keyword(name = "log info")
    public void logInfo(@KeywordArgument AbstractStafObject data) {
        System.out.println("INFO : " + data.getValue());
        logData = logData.concat("INFO : " + data.getValue() + "\n");
    }

    @Keyword(name = "log warn")
    public void logWarn(@KeywordArgument AbstractStafObject data) {
        System.out.println("WARN : " + data.getValue());
        logData = logData.concat("WARN : " + data.getValue() + "\n");
    }

    @Keyword(name = "log error")
    public void logErr(@KeywordArgument AbstractStafObject data) {
        System.out.println("ERROR : " + data.getValue());
        logData = logData.concat("ERROR : " + data.getValue() + "\n");
    }


    @Keyword(name = "save log")
    public void writeToFile(@KeywordArgument AbstractStafObject path) throws IOException {
        System.out.println("Saving log to : " + path.getValue());

        File file = new File(System.getProperty("user.dir") + "/" + path.getValue().toString());
        FileWriter fr = new FileWriter(file, true);
        fr.write(logData + "\n\nTEST ENDED AT : " + formatter.format(new Date()));
        fr.close();

        System.out.println(logData);
    }

}
