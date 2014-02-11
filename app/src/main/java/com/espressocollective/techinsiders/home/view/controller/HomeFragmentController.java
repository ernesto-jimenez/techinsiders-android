package com.espressocollective.techinsiders.home.view.controller;

import com.espressocollective.techinsiders.home.domain.boundaries.InterviewBasicInfoPojo;
import com.espressocollective.techinsiders.home.domain.interactor.GetInterviews;
import com.espressocollective.techinsiders.home.domain.interactor.callback.InterviewsCallback;
import com.espressocollective.techinsiders.home.view.listener.InterviewSummaryListener;
import com.espressocollective.techinsiders.home.view.mapper.InterviewSummaryMapper;
import com.espressocollective.techinsiders.home.view.viewModel.InterviewSummaryViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HomeFragmentController implements InterviewsCallback {

    private final GetInterviews getInterviews;

    private final int pageSize;

    private List<InterviewSummaryViewModel> interviewSummary =
            new ArrayList<InterviewSummaryViewModel>();

    private boolean allInterviewLoaded = false;
    private boolean isLoadingInteviews = false;
    private int from = 0;
    private InterviewSummaryListener interviewSummaryListener;
    private InterviewSummaryMapper interviewSummaryMapper;

    public HomeFragmentController(GetInterviews getInterviews,
                                  InterviewSummaryMapper interviewSummaryMapper,
                                  int pageSize) {
        this.getInterviews = getInterviews;
        this.interviewSummaryMapper = interviewSummaryMapper;
        this.pageSize = pageSize;
    }


    public void load(InterviewSummaryListener listener) {
        from = 0;
        this.interviewSummaryListener = listener;
        obtainPage();

    }

    public void nextPage(InterviewSummaryListener listener) {
        this.interviewSummaryListener = listener;
        obtainPage();

    }

    private void obtainPage() {
        if (allInterviewLoaded || isLoadingInteviews) {
            return;
        }

        isLoadingInteviews = true;
        getInterviews.getInterviews(from, from + pageSize, this);

    }

    public List<InterviewSummaryViewModel> getInterviewSummary() {
        return interviewSummary;
    }

    public boolean isAllInterviewLoaded() {
        return allInterviewLoaded;
    }

    public void setAllInterviewLoaded(boolean allInterviewLoaded) {


        this.allInterviewLoaded = allInterviewLoaded;
    }

    public boolean isLoadingInteviews() {
        return isLoadingInteviews;
    }

    public void setLoadingInteviews(boolean isLoadingInteviews) {


        this.isLoadingInteviews = isLoadingInteviews;
    }

    @Override
    public void interviewsReady(List<InterviewBasicInfoPojo> interviews, boolean complete,
                                int from) {
        allInterviewLoaded = complete;

        for (InterviewBasicInfoPojo interviewBasicInfoPojo : interviews) {
            interviewSummary.add(interviewSummaryMapper.parseFrom(interviewBasicInfoPojo));
        }

        interviewSummaryListener.interviewsLoaded();

        this.from += interviews.size();

        isLoadingInteviews = false;
    }
}

