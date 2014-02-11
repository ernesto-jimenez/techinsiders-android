package com.espressocollective.techinsiders.home.domain.mapper;

import com.espressocollective.techinsiders.home.domain.boundaries.InterviewBasicInfoPojo;
import com.espressocollective.techinsiders.home.domain.interactor.model.Interview;

/**
 * map from Interview domain object to other classes
 */
public class InterviewMapper {
    public InterviewBasicInfoPojo parseToInterviewBasic(Interview interview) {
        InterviewBasicInfoPojo pojo = new InterviewBasicInfoPojo(interview.getTitle(),
                interview.getUrlAvatar(), interview.getShortDescription());
        return pojo;
    }
}
