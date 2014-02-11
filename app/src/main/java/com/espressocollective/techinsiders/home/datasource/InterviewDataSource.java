package com.espressocollective.techinsiders.home.datasource;

import com.espressocollective.techinsiders.home.domain.interactor.model.Interview;

import java.util.List;

/**
 *
 */
public interface InterviewDataSource {

    List<Interview> getInterviews(int from, int to);

    boolean isComplete();
}
