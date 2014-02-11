package com.espressocollective.techinsiders.home.domain.interactor.impl;

import com.espressocollective.techinsiders.base.domain.interactor.impl.InteractorJob;
import com.espressocollective.techinsiders.home.datasource.InterviewDataSource;
import com.espressocollective.techinsiders.home.domain.boundaries.InterviewBasicInfoPojo;
import com.espressocollective.techinsiders.home.domain.interactor.GetInterviews;
import com.espressocollective.techinsiders.home.domain.interactor.callback.InterviewsCallback;
import com.espressocollective.techinsiders.home.domain.interactor.model.Interview;
import com.espressocollective.techinsiders.home.domain.mapper.InterviewMapper;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.Params;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 *
 */
public class GetInterviewsFromDataSources extends InteractorJob implements GetInterviews {

    private int from;
    private int to;
    private InterviewsCallback allInterviewsCallback;
    private InterviewMapper interviewMapper;
    private InterviewDataSource interviewDatasource;

    @Inject
    public GetInterviewsFromDataSources(JobManager jobManager, InterviewMapper interviewMapper,
                                        InterviewDataSource interviewDataSource) {

        super(new Params(PRIORITY_HIGH).requireNetwork(), jobManager);

        this.interviewDatasource = interviewDataSource;
        this.interviewMapper = interviewMapper;

    }

    // @Override
    public void getInterviews(int from, int to, InterviewsCallback allInterviewsCallback) {
        this.from = from;
        this.to = to;
        this.allInterviewsCallback = allInterviewsCallback;

        jobManager.addJob(this);
    }

    @Override
    public void onRun() throws Throwable {
        List<Interview> interviews = interviewDatasource.getInterviews(from,to);
        boolean complete  = interviewDatasource.isComplete();

        List<InterviewBasicInfoPojo>  interviewBasicInfoPojoList = new
                ArrayList<InterviewBasicInfoPojo>();
        for (Interview interview : interviews) {
            InterviewBasicInfoPojo pojo = interviewMapper.parseToInterviewBasic(interview);
            interviewBasicInfoPojoList.add(pojo);
        }

        allInterviewsCallback.interviewsReady(interviewBasicInfoPojoList,complete,from);

    }
}
