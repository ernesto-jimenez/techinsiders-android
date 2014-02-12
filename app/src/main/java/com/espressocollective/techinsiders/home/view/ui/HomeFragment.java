package com.espressocollective.techinsiders.home.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.espressocollective.techinsiders.R;
import com.espressocollective.techinsiders.base.view.ui.BaseFragment;
import com.espressocollective.techinsiders.details.view.ui.DetailFragment;
import com.espressocollective.techinsiders.details.view.ui.phone.DetailActivity;
import com.espressocollective.techinsiders.home.domain.interactor.model.Interview;
import com.espressocollective.techinsiders.home.view.controller.HomeFragmentController;
import com.espressocollective.techinsiders.home.view.listener.InterviewSummaryListener;
import com.espressocollective.techinsiders.home.view.ui.adapter.InterviewSummaryAdapter;
import com.espressocollective.techinsiders.home.view.viewModel.InterviewSummaryViewModel;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;

/**
 *
 */
public class HomeFragment extends BaseFragment implements InterviewSummaryListener {

    public static final int REFRESH_LISTVIEW = 1;

    @InjectView(R.id.lv_main)
    ListView listViewMain;

    @Inject
    InterviewSummaryAdapter interviewSummaryAdapter;

    @Inject
    HomeFragmentController controller;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }



    @Override
    public void onResume() {
        super.onResume();
        controller.load(this);
    }

    @Override
    public void interviewsLoaded() {
        handler.sendEmptyMessage(REFRESH_LISTVIEW);
    }

    Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_LISTVIEW:
                    refreshListView();
                    break;
            }
            return true;
        }

    });

    private void refreshListView() {
        if (interviewSummaryAdapter.getInterviewSummary() == null) {
            interviewSummaryAdapter.setInterviewSummary(controller.getInterviewSummary());
            listViewMain.setAdapter(interviewSummaryAdapter);
        } else {
            interviewSummaryAdapter.notifyDataSetChanged();
        }

    }

    @OnItemClick(R.id.lv_main)
    public void openInterview(int position){
       InterviewSummaryViewModel interviewSummaryViewModel =
               (InterviewSummaryViewModel) interviewSummaryAdapter.getItem(position);

        String id = interviewSummaryViewModel.getId();

        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailFragment.EXTRA_INTERVIEW_ID, id);
        startActivity(intent);
    }

}