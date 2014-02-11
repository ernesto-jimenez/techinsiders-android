package com.espressocollective.techinsiders.base.module;


import com.espressocollective.techinsiders.base.logger.AndroidLog;
import com.espressocollective.techinsiders.base.logger.Logger;
import com.espressocollective.techinsiders.base.logger.LoggerProvider;

import dagger.Module;
import dagger.Provides;

@Module(staticInjections = {LoggerProvider.class}, complete = false)
public class GlobalModule {

    @Provides
    Logger provideLogger() {
        return AndroidLog.getLogger();
    }

}
