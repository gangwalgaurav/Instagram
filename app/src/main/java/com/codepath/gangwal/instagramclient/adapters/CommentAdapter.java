package com.codepath.gangwal.instagramclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.codepath.gangwal.instagramclient.R;

import java.util.List;

/**
 * Created by gangwal on 2/8/15.
 */
public class CommentAdapter extends ArrayAdapter<String> {
        private final Context context;

        public CommentAdapter(Context context, int resource, List<String> objects) {

            super(context, R.layout.comments_view );
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String  comment = getItem(position);

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.comments_feed, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.tvCComment);

//            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            textView.setText(comment);
            // change the icon for Windows and iPhone

            return rowView;
        }
    }


