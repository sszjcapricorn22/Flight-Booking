package sszj.s.flightbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FlightsActivity extends AppCompatActivity implements FlightAdapter.OnBookClickListener {
    TextView date, destination;

    String selectedDate, selectedDestination, name, email, data;
    private ListView listView;

    //    private List<Flight> flightList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
        date = findViewById(R.id.date);
        destination = findViewById(R.id.destination);

        Bundle b = getIntent().getExtras();
        selectedDate = b.getString("date");
        selectedDestination = b.getString("destination");
        name = b.getString("name");
        email = b.getString("email");
        data = b.getString("data");
        date.setText(selectedDate);
        destination.setText(selectedDestination);


        // Initialize ListView and populate list items
        listView = findViewById(R.id.listView);
        List<Flight> flights = new ArrayList<>();
        // Populate the flightList with some example flights
        flights.add(new Flight("A320", "10:00 AM", "2:00 PM", R.drawable.aeroplane, "DUBAI (DXB) to JEDDAH (JED)\n" +
                "PF-145\n" +
                "Economy (budget), Etihad Airways\n" +
                "Sharjah Airport\n" +
                "Total: 20kg Pcs: 1", 600.0));
        flights.add(new Flight("A320", "12:00 PM", "5:00 PM", R.drawable.aeroplane, "DUBAI (DXB) to JEDDAH (JED)\n" +
                "PF-145\n" +
                "Economy (budget), Emirates Airways\n" +
                "Total: 20kg Pcs: 1", 640.0));
        flights.add(new Flight("A310", "2:00 PM", "7:00 PM", R.drawable.aeroplane, "DUBAI (DXB) to JEDDAH (JED)\n" +
                "PF-145\n" +
                "Economy (budget), Emirates Airways\n" +
                "DXB Airport\n" +
                "Total: 20kg Pcs: 1", 600.0));
        flights.add(new Flight("Boing 777", "4:00 PM", "9:00 PM", R.drawable.aeroplane, "DUBAI (DXB) to JEDDAH (JED)\n" +
                "PF-145\n" +
                "Economy (budget), Etihad Airways\n" +
                "DXB Airport\n" +
                "Total: 20kg Pcs: 1", 650.0));
        flights.add(new Flight("Boing 777", "6:00 PM", "11:00 PM", R.drawable.aeroplane, "DUBAI (DXB) to JEDDAH (JED)\n" +
                "PK-304\n" +
                "Economy (O), Emirates Airways\n" +
                "Abu Dhabi Airport\n" +
                "Total: 40kg Pcs: 1", 600.0));
        // Create the adapter and set it to the listView

        FlightAdapter adapter = new FlightAdapter(this, R.layout.flight_item, flights, this::onBookClick);
        listView.setAdapter(adapter);

    }


    @Override
    public void onBookClick(Flight flight) {
        String flightName = flight.getFlight();
        String flightDesc = flight.getDescription();
        String flightDepartureTime = flight.getDepartureDate();
        String flightArrivalTime = flight.getReturnDate();
        String flightPrice = String.valueOf(flight.getPrice());
        String Flight_Details = "Flight Name: " + flightName + "\n" +
                "Flight Desc: " + flightDesc + "\n" +
                "Departure Time: " + flightDepartureTime + "\n" +
                "Arrival Time: " + flightArrivalTime + "\n" +
                "Ticket Price: AED " + flightPrice;

        Intent intent = new Intent(FlightsActivity.this, TicketActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("date", selectedDate);
        intent.putExtra("destination", selectedDestination);
        intent.putExtra("flight", Flight_Details);
        startActivity(intent);
//        Toast.makeText(this,email., Toast.LENGTH_SHORT).show();
        Log.d("click123", Flight_Details.toString());

    }
}