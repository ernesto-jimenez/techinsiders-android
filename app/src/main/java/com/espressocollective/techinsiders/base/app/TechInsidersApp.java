package com.espressocollective.techinsiders.base.app;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import com.espressocollective.techinsiders.base.module.AndroidModule;
import com.espressocollective.techinsiders.base.module.GlobalDomainModule;
import com.espressocollective.techinsiders.base.module.GlobalModule;
import com.espressocollective.techinsiders.base.module.GlobalViewModule;
import com.espressocollective.techinsiders.details.domain.DetailDomainModule;
import com.espressocollective.techinsiders.details.view.DetailViewModule;
import com.espressocollective.techinsiders.home.datasource.HomeDataSourceModule;
import com.espressocollective.techinsiders.home.domain.HomeDomainModule;
import com.espressocollective.techinsiders.home.view.HomeViewModule;

/**
 *
 */
public class TechInsidersApp extends Application {

    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(getModules().toArray());
        graph.injectStatics();
    }

    protected List<Object> getModules() {
        return Arrays.asList(new AndroidModule(this), new GlobalModule(), new GlobalDomainModule(),
                new GlobalViewModule(), new HomeDataSourceModule(), new HomeDomainModule(),
                new HomeViewModule(), new DetailViewModule(), new DetailDomainModule());
    }

    public void inject(Object object) {
        graph.inject(object);
    }
}
