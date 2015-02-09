package com.codepath.gangwal.instagramclient.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.codepath.gangwal.instagramclient.R;
import com.codepath.gangwal.instagramclient.adapters.CommentAdapter;
import com.codepath.gangwal.instagramclient.pojo.InstagramPhoto;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class TaskDialog extends DialogFragment {

    private EditText mTitle;
    private static TextView mDatePicker;
    private static TextView mTimePicker;
    private ItemAddListener mCallback;

    private Spinner mPriority;

    private static InstagramPhoto sTask;
    private static JSONArray sComments;
//    private ItemAddListener mCallback;
    private ImageButton mSubmit;
    private ImageButton mDateButton;
    private ImageButton mTimeButton;

    private ImageButton mDatePickerButton;
    private ImageButton mReset;
    private TextView mDescription;
    private static FragmentManager sFragmentManager;
    private EditText mEditText;
    CommentAdapter cAdapter;
    public static TaskDialog getInstance(InstagramPhoto item, JSONArray comments, FragmentManager fragmentManager){
        TaskDialog frag = new TaskDialog();
        Bundle args = new Bundle();
        args.putString("title", "Title");
        frag.setArguments(args);
        sTask = item;
        sComments = comments;
        sFragmentManager = fragmentManager;
        return frag;
    }



    public interface ItemAddListener {
        public void generateList();
    }

    //@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

//        try {
//            mCallback = (ItemAddListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement ItemAddListener");
//        }
    }

    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.comments_view, container);
        getDialog().setTitle(("Comments"));

        ListView lvComments = (ListView)v.findViewById(R.id.lvComments);

//        ImageView imageView = (ImageView)v.findViewById(R.id.ivCProfiePhoto);
        TextView comment = (TextView)v.findViewById(R.id.tvCComment);
        ArrayList<String> commentsList = new ArrayList<String>();

        for(int i=0;i<sComments.length();i++)
        {
//            imageView.setImageResource(R.drawable.icon);
            try {
//                comment.setText(sComments.getJSONObject(i).getString("text"));
                commentsList.add(sComments.getJSONObject(i).getString("text"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        cAdapter = new CommentAdapter(getActivity().getApplicationContext(), 0, commentsList);

        lvComments.setAdapter(cAdapter);

        return v;
    }



}
