package com.example.surbhitrao.myapplication.viewmodel;
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.surbhitrao.myapplication.R;
import com.example.surbhitrao.myapplication.model.GridItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Surbhit Rao on 20-02-2016.
 */
public class GridViewAdapter extends ArrayAdapter<GridItem> {

    private Context mContext;
    private int layoutResourceId;
    private ArrayList<GridItem> mGridData = new ArrayList<GridItem>();

    public GridViewAdapter(Context mContext, int layoutResourceId, ArrayList<GridItem> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
    }


    /**
     * Updates grid data and refresh grid items.
     * @param mGridData
     */
    public void setGridData(ArrayList<GridItem> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.titleTextView = (TextView) row.findViewById(R.id.grid_item_title);
            holder.imageView = (ImageView) row.findViewById(R.id.grid_item_image);
            holder.detail= (TextView) row.findViewById(R.id.details);
            holder.rat= (TextView) row.findViewById(R.id.rati);
            holder.date= (TextView) row.findViewById(R.id.date);
            holder.lang= (TextView) row.findViewById(R.id.lan);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        GridItem item = mGridData.get(position);
        holder.titleTextView.setText(Html.fromHtml(item.getTitle()));
        holder.detail.setText(Html.fromHtml(item.getOverview()));
        holder.rat.setText(Html.fromHtml(item.getVotes()));
        holder.date.setText(Html.fromHtml(item.getR_date()));
        holder.lang.setText(Html.fromHtml(item.getLang()));


        Picasso.with(mContext).load(item.getImage()).into(holder.imageView);
        return row;
    }

    static class ViewHolder {
        TextView titleTextView;
        ImageView imageView;
        TextView detail;
        TextView rat;
        TextView date;
        TextView lang;


    }
}