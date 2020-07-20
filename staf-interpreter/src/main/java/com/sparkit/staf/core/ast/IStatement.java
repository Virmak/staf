package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public interface IStatement {
    Object execute(MemoryMap globalMemory, MemoryMap localMemory, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable;
}
