package com.espressocollective.techinsiders.details.view.mapper;

import com.espressocollective.techinsiders.details.domain.boundaries.FullInterviewPojo;
import com.espressocollective.techinsiders.details.view.viewModel.InterviewCompleteViewModel;

/**
 *
 */
public class FullInterviewMapper {

    public InterviewCompleteViewModel convert(FullInterviewPojo fullInterviewPojo) {
        InterviewCompleteViewModel interviewCompleteViewModel = new InterviewCompleteViewModel
                (fullInterviewPojo.getTitle(), fullInterviewPojo.getBody());

        return interviewCompleteViewModel;
    }
}
