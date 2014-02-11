package com.espressocollective.techinsiders.base.domain.interactor.impl;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.Params;

/**
 *
 */
public abstract class InteractorJob extends Job{

    public final static int PRIORITY_HIGH = 1;
    protected final JobManager jobManager;

    protected InteractorJob(Params params, JobManager jobManager) {
        super(params);
        this.jobManager = jobManager;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public abstract void onRun() throws Throwable;

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
