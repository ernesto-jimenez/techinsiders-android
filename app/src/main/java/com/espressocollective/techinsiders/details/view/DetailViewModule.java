package com.espressocollective.techinsiders.details.view;

import android.content.Context;
import android.view.LayoutInflater;

import com.espressocollective.techinsiders.base.daggerUtils.ForApplication;
import com.espressocollective.techinsiders.details.domain.interactor.GetFullInterview;
import com.espressocollective.techinsiders.details.view.controller.DetailController;
import com.espressocollective.techinsiders.details.view.mapper.FullInterviewMapper;
import com.espressocollective.techinsiders.details.view.ui.DetailFragment;
import com.espressocollective.techinsiders.details.view.ui.phone.DetailActivity;
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
@Module(injects = {DetailActivity.class, DetailFragment.class},
        complete = false,
        library = true)
public class DetailViewModule {


    @Provides
    public DetailController provideDetailController(GetFullInterview getFullInterview,
                                                                FullInterviewMapper mapper) {
        return new DetailController(getFullInterview, mapper);
    }


    @Provides
    @Singleton
    public FullInterviewMapper provideFullInterviewMapper(){
        return new FullInterviewMapper();
    }
}
