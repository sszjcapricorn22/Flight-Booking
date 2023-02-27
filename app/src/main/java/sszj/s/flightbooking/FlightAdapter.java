package sszj.s.flightbooking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FlightAdapter extends ArrayAdapter<Flight> {
    //Adapter for flights

    private Context context;
    private int resource;
    private List<Flight> flights;

    public interface OnBookClickListener {
        void onBookClick(Flight flight);
    }

    private OnBookClickListener onBookClickListener;

    public FlightAdapter(Context context, int resource, List<Flight> flights, OnBookClickListener listener) {
        super(context, resource, flights);
        this.context = context;
        this.resource = resource;
        this.flights = flights;
        this.onBookClickListener = listener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Flight flight = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.flight_item, parent, false);
        }

        // Lookup view for data population
        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView tvFlight = convertView.findViewById(R.id.item_name);
        TextView tvDeparture = convertView.findViewById(R.id.item_time);
        TextView tvReturn = convertView.findViewById(R.id.item_return);
        TextView tvDesc = convertView.findViewById(R.id.item_description);
        TextView tvPrice = convertView.findViewById(R.id.item_price);
        Button book = convertView.findViewById(R.id.item_button);

        // Populate the data into the template view using the data object
        imageView.setImageResource(flight.getImage());
        tvFlight.setText(flight.getFlight());
        tvDeparture.setText(flight.getDepartureDate());
        tvReturn.setText(flight.getReturnDate());
        tvDesc.setText("Description: " + flight.getDescription());
        tvPrice.setText("AED: " + String.valueOf(flight.getPrice()));

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onBookClickListener != null) {
                    onBookClickListener.onBookClick(flight);
                }
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}