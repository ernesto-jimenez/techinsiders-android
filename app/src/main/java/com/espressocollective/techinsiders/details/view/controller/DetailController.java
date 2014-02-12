package com.espressocollective.techinsiders.details.view.controller;

import com.espressocollective.techinsiders.details.domain.boundaries.FullInterviewPojo;
import com.espressocollective.techinsiders.details.domain.interactor.GetFullInterview;
import com.espressocollective.techinsiders.details.domain.interactor.callback.FullInterviewCallback;
import com.espressocollective.techinsiders.details.view.listener.InterviewReadyListener;
import com.espressocollective.techinsiders.details.view.mapper.FullInterviewMapper;
import com.espressocollective.techinsiders.details.view.viewModel.InterviewCompleteViewModel;

/**
 *
 */
public class DetailController implements FullInterviewCallback {
    private final GetFullInterview getFullInterview;
    private final FullInterviewMapper mapper;
    private InterviewCompleteViewModel interviewComplete;
    private InterviewReadyListener interviewReadyListener;

    public DetailController(GetFullInterview getFullInterview, FullInterviewMapper mapper) {
        this.getFullInterview = getFullInterview;
        this.mapper = mapper;
    }


    public void obtainDetail(InterviewReadyListener interviewReadyListener, String id) {
        this.interviewReadyListener = interviewReadyListener;
        getFullInterview.getFullInterview(id, this);


    }

    @Override
    public void fullInterviewReady(FullInterviewPojo fullInterviewPojo) {
        interviewComplete = mapper.convert(fullInterviewPojo);
        interviewReadyListener.InterviewReady();
    }

    public InterviewCompleteViewModel getInterviewComplete() {
        return interviewComplete;
    }
}
