package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.types.KeywordCall;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Component
public class KeywordCallStack {
    // Map each session id (thread) to callstack
    private final Map<Integer, Stack<KeywordCall>> callStacksMap = new HashMap<>();

    public void create(int sessionId) {
        callStacksMap.put(sessionId, new Stack<>());
    }

    public void push(KeywordCall keywordCall, int sessionId) {
        if (!callStacksMap.containsKey(sessionId)) {
            create(sessionId);
        }
        callStacksMap.get(sessionId).push(keywordCall);
    }

    public KeywordCall peek(int sessionId) {
        return callStacksMap.get(sessionId).peek();
    }

    public KeywordCall pop(int sessionId) {
        return callStacksMap.get(sessionId).pop();
    }
}
