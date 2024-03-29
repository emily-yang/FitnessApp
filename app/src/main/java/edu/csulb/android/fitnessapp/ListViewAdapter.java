package edu.csulb.android.fitnessapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.RecyclerViewHolder>{

    private List<Event> eventList;

    public ListViewAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.event_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.eventItemName.setText(event.getEventName());
        holder.eventItemDate.setText(event.getEventDate().toString().substring(0,10));
        holder.eventItemResult.setText(event.getEventResult());
        holder.eventItemDetails.setText(event.getEventDetails());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void addEvents(List<Event> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView eventItemName;
        private TextView eventItemDate;
        private TextView eventItemResult;
        private TextView eventItemDetails;

        RecyclerViewHolder(View v){
            super(v);
            eventItemName = v.findViewById(R.id.event_item_name);
            eventItemDate = v.findViewById(R.id.event_item_date);
            eventItemResult = v.findViewById(R.id.event_item_result);
            eventItemDetails = v.findViewById(R.id.event_item_details);

        }

    }
}
