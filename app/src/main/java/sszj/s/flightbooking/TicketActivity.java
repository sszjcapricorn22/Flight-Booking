package sszj.s.flightbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TicketActivity extends AppCompatActivity {
    String selectedDate, selectedDestination, name, email, flight;
    TextView UName, UEmail, Date, Destination, Flight_desc;
// it will generate ticket

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        Bundle b = getIntent().getExtras();
        selectedDate = b.getString("date");
        selectedDestination = b.getString("destination");
        name = b.getString("name");
        email = b.getString("email");
        flight = b.getString("flight");

        UName = findViewById(R.id.cname);
        UEmail = findViewById(R.id.cemail);
        Date = findViewById(R.id.cdate);
        Destination = findViewById(R.id.cdestination);
        Flight_desc = findViewById(R.id.flight_details);

        UName.setText(name);
        UEmail.setText("Email: " + email);
        Date.setText(selectedDate);
        Destination.setText(selectedDestination);
        Flight_desc.setText(flight);


    }
}