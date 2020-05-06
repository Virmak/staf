package com.sparkit.interpreter.runtime;

import com.sparkit.interpreter.compiler.ast.statement.StafCallable;
import com.sparkit.staf.domain.report.StatementReport;
import lombok.Data;

import java.util.Stack;

public class CallStack {
    private Stack<CallStackItem> callStack = new Stack<>();

    public void push(StafCallable callable) {
        callStack.push(new CallStackItem(callable));
    }
    public void push(StafCallable callable,  StatementReport statementReport) {
        callStack.push(new CallStackItem(callable, statementReport));
    }

    public CallStackItem pop() {
        return callStack.pop();
    }

    public CallStackItem peek() {
        return callStack.peek();
    }

    public void init() {
        callStack = new Stack<>();
    }

    @Data
    public class CallStackItem {
        StafCallable callable;
        StatementReport statementReport;

        public CallStackItem(StafCallable callable) {
            this.callable = callable;
        }

        public CallStackItem(StafCallable callable, StatementReport statementReport) {
            this.callable = callable;
            this.statementReport = statementReport;
        }
    }
}
