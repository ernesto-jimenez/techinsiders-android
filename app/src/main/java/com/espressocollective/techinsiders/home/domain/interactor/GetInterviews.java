package com.espressocollective.techinsiders.home.domain.interactor;


import com.espressocollective.techinsiders.home.domain.interactor.callback.InterviewsCallback;

/**
 *
 */
public interface GetInterviews {

    public void getInterviews(int from, int to, InterviewsCallback allInterviewsCallback);

}
