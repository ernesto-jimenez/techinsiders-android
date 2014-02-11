package com.espressocollective.techinsiders.base.view.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.espressocollective.techinsiders.base.app.TechInsidersApp;

import butterknife.ButterKnife;

/**
 *
 */
public class BaseActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        inject(this);
    }

    public void inject(Object object) {
        // Perform injection so that when this call returns all dependencies will be available for use.
        ((TechInsidersApp) getApplication()).inject(object);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }
}
