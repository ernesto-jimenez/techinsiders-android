package com.espressocollective.techinsiders.home.view.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.espressocollective.techinsiders.R;
import com.espressocollective.techinsiders.home.view.viewModel.InterviewSummaryViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 *
 */
public class InterviewSummaryAdapter extends BaseAdapter {

    private final Context context;
    private final LayoutInflater inflater;
    private final Picasso picasso;

    List<InterviewSummaryViewModel> interviewSummary;

    public InterviewSummaryAdapter(Context context, LayoutInflater inflater, Picasso picasso) {
        this.context = context;
        this.inflater = inflater;
        this.picasso = picasso;

    }

    @Override
    public int getCount() {
        if (interviewSummary == null) {
            return 0;
        } else {
            return interviewSummary.size();
        }
    }

    @Override
    public Object getItem(int position) {
        if (interviewSummary == null) {
            return null;
        }

        return interviewSummary.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_interview_summary, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.tv_title);
        ImageView avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
        TextView summary = (TextView) convertView.findViewById(R.id.tv_summary);

        InterviewSummaryViewModel interview = interviewSummary.get(position);

        title.setText(interview.getTitle());
        summary.setText(interview.getSummary());

        picasso.load(interview.getAvatarUrl()).into(avatar);

        return convertView;
    }

    public List<InterviewSummaryViewModel> getInterviewSummary() {
        return interviewSummary;
    }

    public void setInterviewSummary(List<InterviewSummaryViewModel> interviewSummary) {
        this.interviewSummary = interviewSummary;
    }
}
