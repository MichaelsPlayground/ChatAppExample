package de.androidcrypto.chatappexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<ChatData> {
    private Activity activity;
    private List<ChatData> messages;
    public ChatAdapter(Activity context, int resource, List<ChatData> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.messages = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        int layoutResource = 0; // determined by view type
        ChatData chatData = getItem(position);
        int viewType = getItemViewType(position);
        if (chatData.isMine()) {
            layoutResource = R.layout.left;
        } else {
            layoutResource = R.layout.right;
        }
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        //set message content
        holder.msg.setText(chatData.getContent());
        return convertView;
    }
    @Override
    public int getViewTypeCount() {
        // return the total number of view types. this value should never change
        // at runtime
        return 2;
    }
    @Override
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        return position % 2;
    }
    private class ViewHolder {
        private TextView msg;
        public ViewHolder(View v) {
            msg = (TextView) v.findViewById(R.id.txt_msg);
        }
    }
}