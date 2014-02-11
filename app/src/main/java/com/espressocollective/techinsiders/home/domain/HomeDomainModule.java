package com.espressocollective.techinsiders.home.domain;

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
public class HomeDomainModule  {

    @Provides
    public GetInterviews provideGetInterviews(GetInterviewsFromDataSources
                                                          getInterviewsFromDataSources) {
        return getInterviewsFromDataSources;

    }

    @Provides
    @Singleton
    public InterviewMapper provideInterviewMapper (){
        return new InterviewMapper();
    }
}
