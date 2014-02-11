package com.espressocollective.techinsiders.base.module;

import android.content.Context;

import com.espressocollective.techinsiders.base.daggerUtils.ForApplication;
import com.path.android.jobqueue.JobManager;

import dagger.Module;
import dagger.Provides;

/**
 * This module provide global dependencies for all domain objects.
 */
@Module(complete = false,
        library = true)
public class GlobalDomainModule {

    @Provides
    public JobManager provideJobManager(@ForApplication Context context){
        return new JobManager(context);
    }

}
