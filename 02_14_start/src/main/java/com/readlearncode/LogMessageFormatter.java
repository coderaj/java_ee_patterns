package com.readlearncode;


import com.readlearncode.thirdpartylogger.LogMessage;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.time.LocalDate;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */

@Priority(10)
@Decorator
public abstract class LogMessageFormatter implements LogMessage {

    @Any
    @Delegate
    @Inject
    private LogMessage logMessage;

    @Override
    public void printMessage() {
        String message = logMessage.getMessage();
        message = LocalDate.now().toString().concat(message);
        logMessage.setMessage(message);
    }

}