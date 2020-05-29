package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafVariable;

public interface IStafIterable extends IStatementBlock {
    AbstractStafObject getIterator();
    StafVariable getLoopVariable();
}
