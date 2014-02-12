package com.espressocollective.techinsiders.details.domain.interactor.impl;


import com.espressocollective.techinsiders.base.domain.interactor.impl.InteractorJob;
import com.espressocollective.techinsiders.details.domain.boundaries.FullInterviewPojo;
import com.espressocollective.techinsiders.details.domain.interactor.GetFullInterview;
import com.espressocollective.techinsiders.details.domain.interactor.callback.FullInterviewCallback;
import com.espressocollective.techinsiders.home.datasource.InterviewDataSource;
import com.espressocollective.techinsiders.home.domain.interactor.model.Interview;
import com.espressocollective.techinsiders.home.domain.mapper.InterviewMapper;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.Params;

import javax.inject.Inject;

/**
 *
 */
public class GetFullInterviewFromDataSources extends InteractorJob implements GetFullInterview {

    private final InterviewDataSource interviewDataSource;
    private final InterviewMapper interviewMapper;
    private FullInterviewCallback callback;
    private String idInterview;

    @Inject
    public GetFullInterviewFromDataSources(InterviewDataSource interviewDataSource,
                                           InterviewMapper mapper,
                                           JobManager jobManager) {
        super(new Params(PRIORITY_HIGH).requireNetwork(), jobManager);
        this.interviewDataSource = interviewDataSource;
        this.interviewMapper  = mapper;

    }


    @Override
    public void getFullInterview(String id, FullInterviewCallback callback) {
        this.callback = callback;
        this.idInterview = id;
        jobManager.addJob(this);

    }


    @Override
    public void onRun() throws Throwable {
        Interview interview = interviewDataSource.getInterviewById(idInterview);

        FullInterviewPojo interviewPojo = interviewMapper.parseToFullInterview(interview);

        callback.fullInterviewReady(interviewPojo);

    }
}
