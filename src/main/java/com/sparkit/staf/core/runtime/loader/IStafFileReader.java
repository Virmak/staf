package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.ast.StafFile;

import java.io.IOException;

public interface IStafFileReader {
    public StafFile compile(String filePath) throws IOException;
}
