package com.espressocollective.techinsiders.home.view;

import android.content.Context;
import android.view.LayoutInflater;

import com.espressocollective.techinsiders.base.daggerUtils.ForApplication;
import com.espressocollective.techinsiders.home.domain.interactor.GetInterviews;
import com.espressocollective.techinsiders.home.view.controller.HomeFragmentController;
import com.espressocollective.techinsiders.home.view.mapper.InterviewSummaryMapper;
import com.espressocollective.techinsiders.home.view.ui.HomeFragment;
import com.espressocollective.techinsiders.home.view.ui.adapter.InterviewSummaryAdapter;
import com.espressocollective.techinsiders.home.view.ui.phone.HomeActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module(injects = {HomeActivity.class, HomeFragment.class},
        complete = false,
        library = true)
public class HomeViewModule {

    public final static int PHONE_SUMMARY_PAGE = 10;

    @Provides
    public HomeFragmentController provideHomeFragmentController(GetInterviews interviews,
                                                                InterviewSummaryMapper mapper) {
        return new HomeFragmentController(interviews, mapper , PHONE_SUMMARY_PAGE);
    }

    @Provides
    public InterviewSummaryAdapter provideInterviewSummaryAdapter(@ForApplication Context context,
                                                                  LayoutInflater layoutInflater,
                                                                  Picasso picasso){
        return new InterviewSummaryAdapter(context, layoutInflater, picasso);
    }

    @Provides
    @Singleton
    public InterviewSummaryMapper provideSummaryMapper(){
        return new InterviewSummaryMapper();
    }
}
