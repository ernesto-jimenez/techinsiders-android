package com.espressocollective.techinsiders.details.view.ui;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.espressocollective.techinsiders.R;
import com.espressocollective.techinsiders.base.view.ui.BaseFragment;
import com.espressocollective.techinsiders.details.view.controller.DetailController;
import com.espressocollective.techinsiders.details.view.listener.InterviewReadyListener;
import com.espressocollective.techinsiders.details.view.viewModel.InterviewCompleteViewModel;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 *
 */
public class DetailFragment extends BaseFragment implements InterviewReadyListener {
    private static final int MSG_INTERVIEW_LOADED = 0;
    public static final String EXTRA_INTERVIEW_ID = "interview_id";


    @Inject
    DetailController controller;

    @InjectView(R.id.tv_body)
    TextView body;

    private String interviewId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.inject(this, rootView);



        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if ((getActivity().getIntent() != null) &&
                (getActivity().getIntent().getExtras() != null)) {
            interviewId = getActivity().getIntent().getExtras().getString(EXTRA_INTERVIEW_ID);
        }

        if(interviewId == null){
            //    getActivity().finish();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.obtainDetail(this, interviewId);
    }


    Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_INTERVIEW_LOADED:
                    fillInterviewData();
                    break;

            }
            return true;
        }

    });

    private void fillInterviewData() {
        InterviewCompleteViewModel interviewComplete = controller.getInterviewComplete();
        body.setText(Html.fromHtml(interviewComplete.getBody()));
    }

    @Override
    public void InterviewReady() {
        handler.sendEmptyMessage(MSG_INTERVIEW_LOADED);
    }
}


