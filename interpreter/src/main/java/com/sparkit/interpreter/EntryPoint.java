package com.sparkit.interpreter;

import com.sparkit.interpreter.compiler.parser.SyntaxErrorException;
import com.sparkit.interpreter.runtime.StafInterpreter;
import com.sparkit.interpreter.runtime.libs.KeywordLibrariesRepository;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EntryPoint implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        StafInterpreter interpreter = applicationContext.getBean(StafInterpreter.class);
        try {
            interpreter.run("test.staf");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SyntaxErrorException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
