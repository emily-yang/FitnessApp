package edu.csulb.android.fitnessapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class FindBrowseAdapter extends BaseAdapter {

    List<EventCategory> browseEvents;
    View view;
    //Get the context
    Context mContext = null;
    BrowseViewHolder viewHolder;

    public FindBrowseAdapter(Context context, List<EventCategory> wList) {
        mContext = context;
        browseEvents = wList;
    }

    @Override
    public int getCount() {
        return browseEvents.size();
    }

    @Override
    public EventCategory getItem(int position) {
        return browseEvents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        EventCategory bEvents = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.find_events_browse_card, viewGroup, false);
        }
        // Lookup view for data population
        BrowseViewHolder bvh = new BrowseViewHolder(view);

        // Populate the data into the template view using the data object
        bvh.categoryName.setText(browseEvents.get(position).getCategoryName());
        bvh.catgoryImage.setImageResource(browseEvents.get(position).getPhoto());


        // Return the completed view to render on screen
        return view;
    }


    public class BrowseViewHolder {

        TextView categoryName;
        ImageView catgoryImage;


        public BrowseViewHolder(View itemView) {

            categoryName = (TextView) itemView.findViewById(R.id.sample_event_text);
            catgoryImage = (ImageView) itemView.findViewById(R.id.sample_event_image);

        }


    }
}