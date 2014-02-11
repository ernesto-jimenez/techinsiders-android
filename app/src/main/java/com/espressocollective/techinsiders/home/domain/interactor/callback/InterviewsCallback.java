package com.espressocollective.techinsiders.home.domain.interactor.callback;

import com.espressocollective.techinsiders.home.domain.boundaries.InterviewBasicInfoPojo;

import java.util.List;

/**
 *
 */
public interface InterviewsCallback {

    public void interviewsReady(List<InterviewBasicInfoPojo> interviews, boolean complete,
                                int from);
}
