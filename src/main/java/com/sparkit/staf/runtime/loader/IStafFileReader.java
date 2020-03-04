package com.sparkit.staf.runtime.loader;

import com.sparkit.staf.ast.StafFile;

import java.io.IOException;

public interface IStafFileReader {
    public StafFile compile(String filePath) throws IOException;
}
