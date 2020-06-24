package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafList;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Inject;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;

@StafLibrary(name = "csv")
public class CsvLibrary extends AbstractStafLibrary {

    @Keyword(name = "read csv")
    public StafList readCsv(@Inject(name = "__keyword__") KeywordCall keywordCall, StafString filePath) {
        System.out.println(keywordCall.getFilePath());
        return null;
    }

}
