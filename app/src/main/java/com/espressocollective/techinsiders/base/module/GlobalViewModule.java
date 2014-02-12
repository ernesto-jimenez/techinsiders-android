package com.espressocollective.techinsiders.base.module;



import android.content.Context;

import com.espressocollective.techinsiders.base.daggerUtils.ForApplication;
import com.espressocollective.techinsiders.details.view.ui.DetailFragment;
import com.espressocollective.techinsiders.details.view.ui.phone.DetailActivity;
import com.espressocollective.techinsiders.home.view.ui.HomeFragment;
import com.espressocollective.techinsiders.home.view.ui.phone.HomeActivity;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module(injects = {HomeActivity.class, HomeFragment.class,
        DetailActivity.class, DetailFragment.class
},
        complete = false,
        library = true)
public class GlobalViewModule {

    @Provides
    public Picasso providePicasso(@ForApplication Context context){
        return Picasso.with(context);
    }
}
