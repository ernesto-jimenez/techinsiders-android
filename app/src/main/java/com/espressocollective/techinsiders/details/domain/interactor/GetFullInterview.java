package com.espressocollective.techinsiders.details.domain.interactor;

import com.espressocollective.techinsiders.details.domain.interactor.callback.FullInterviewCallback;

/**
 *
 */
public interface GetFullInterview {


    void getFullInterview(String id, FullInterviewCallback callback);
}
