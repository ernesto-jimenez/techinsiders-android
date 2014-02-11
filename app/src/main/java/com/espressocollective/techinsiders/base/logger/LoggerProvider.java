package com.espressocollective.techinsiders.base.logger;

import javax.inject.Inject;


public class LoggerProvider {

    @Inject
    static Logger logger;

    public LoggerProvider() {

    }

    public static Logger getLogger() {
        return logger;
    }
}
