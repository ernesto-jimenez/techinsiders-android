package com.espressocollective.techinsiders.details.domain;

import com.espressocollective.techinsiders.details.domain.interactor.GetFullInterview;
import com.espressocollective.techinsiders.details.domain.interactor.impl.GetFullInterviewFromDataSources;
import com.espressocollective.techinsiders.home.domain.interactor.GetInterviews;
import com.espressocollective.techinsiders.home.domain.interactor.impl.GetInterviewsFromDataSources;
import com.espressocollective.techinsiders.home.domain.mapper.InterviewMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module(complete = false,
        library = true)
public class DetailDomainModule {

    @Provides
    public GetFullInterview provideFullInterviews(GetFullInterviewFromDataSources
                                                          getFullInterviewFromDataSources) {
        return getFullInterviewFromDataSources;

    }

}
