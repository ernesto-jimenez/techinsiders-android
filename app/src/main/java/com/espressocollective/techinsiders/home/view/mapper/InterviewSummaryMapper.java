package com.espressocollective.techinsiders.home.view.mapper;

import com.espressocollective.techinsiders.home.domain.boundaries.InterviewBasicInfoPojo;
import com.espressocollective.techinsiders.home.view.viewModel.InterviewSummaryViewModel;

/**
 *
 */
public class InterviewSummaryMapper {


    public InterviewSummaryViewModel parseFrom(InterviewBasicInfoPojo interviewBasicInfoPojo) {

        InterviewSummaryViewModel summary = new InterviewSummaryViewModel(
                interviewBasicInfoPojo.getAvatarUrl(),interviewBasicInfoPojo.getTitle(),
                interviewBasicInfoPojo.getSmallDescription(), null,
                interviewBasicInfoPojo.getIdInterview());

        return summary;
    }
}
