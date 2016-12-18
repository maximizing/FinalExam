package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.maximize.finalexam.R;


import java.util.ArrayList;

import model.member;

/**
 * Created by maximize on 12/18/2016 AD.
 */

public class MemberListAdapter extends ArrayAdapter<member> {

    private Context mContext;
    private int mLayoutResId;
    private ArrayList<member> mMemberList;

    public MemberListAdapter(Context context, int resource, ArrayList<member> memberList) {
        super(context, resource, memberList);

        this.mContext = context;
        this.mLayoutResId = resource;
        this.mMemberList = memberList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = View.inflate(mContext, mLayoutResId, null);
        }

        TextView item_text  = (TextView) convertView.findViewById(R.id.name);

        member m = mMemberList.get(position);
        item_text.setText(m.getNames());

        return convertView;
    }
}
