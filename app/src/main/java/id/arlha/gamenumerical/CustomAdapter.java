package id.arlha.gamenumerical;

/**
 * Created by Gentong on 14/03/2018.
 */

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import id.arlha.gamenumerical.R;

import java.util.ArrayList;

import id.arlha.gamenumerical.Model.Data;

public class CustomAdapter extends ArrayAdapter<Data> implements View.OnClickListener{

    private Context mContext;

    // View lookup cache
    private static class ViewHolder {
        Button btnSoal;
        ImageView info;
    }

    public CustomAdapter(ArrayList<Data> data, Context context) {
        super(context, R.layout.custom_row, data);
        ArrayList<Data> dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Data dataModel=(Data)object;

        switch (v.getId())
        {
            case R.id.btnSoal:
                Snackbar.make(v, "Release date " +dataModel.getSoal(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Data dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_row, parent, false);
            viewHolder.btnSoal = (Button) convertView.findViewById(R.id.btnSoal);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.btnSoal.setText(dataModel.getSoal());
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
