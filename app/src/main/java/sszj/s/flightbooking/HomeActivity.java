package sszj.s.flightbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {
    TextView userName, userEmail, tv;
    String name, email;
    EditText To, From;
    CheckBox checkboxOneWay, checkboxRoundTrip, checkboxFirst, checkboxBusiness, checkboxEconomy, checkboxAdult, checkboxChild;
    Button searchFlight;
    String date, destination, selected, selectedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CalendarView calendarView = findViewById(R.id.calendarView);
        userName = findViewById(R.id.UserName);
        userEmail = findViewById(R.id.UserEmail);
        tv = findViewById(R.id.tv);
        To = findViewById(R.id.to);
        From = findViewById(R.id.from);
        checkboxOneWay = findViewById(R.id.checkbox_one_way);
        checkboxRoundTrip = findViewById(R.id.checkbox_round_trip);
        checkboxFirst = findViewById(R.id.checkbox_first);
        checkboxBusiness = findViewById(R.id.checkbox_business);
        checkboxEconomy = findViewById(R.id.checkbox_economy);
        checkboxAdult = findViewById(R.id.checkbox_adult);
        checkboxChild = findViewById(R.id.checkbox_child);

        Bundle b = getIntent().getExtras();
        name = b.getString("name");
        email = b.getString("email");
        userName.setText(name.toString());
        userEmail.setText(email.toString());
        calendarView.setDate(System.currentTimeMillis());
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                // Get the selected date
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, month, dayOfMonth);

                // Get the current date
                Calendar currentDate = Calendar.getInstance();

                // Check if the selected date is before today
                if (selectedDate.before(currentDate)) {
                    // Show a toast message
                    Toast.makeText(getApplicationContext(), "Please select a future date", Toast.LENGTH_SHORT).show();
                    // Set the calendar view to the current date
                    calendarView.setDate(currentDate.getTimeInMillis());
                    return;
                }
                date = year + "-" + month + 1 + "-" + dayOfMonth + "";
                // Do something with the selected date
                Toast.makeText(getApplicationContext(), "Selected date: " + year + "-" + (month + 1) + "-" + dayOfMonth, Toast.LENGTH_SHORT).show();
            }
        });

        Button searchFlight = findViewById(R.id.search_flight);
        searchFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String from = From.getText().toString();
                String to = To.getText().toString();
                // Check if either 'From' or 'To' fields are empty
                if (TextUtils.isEmpty(from) || TextUtils.isEmpty(to)) {
                    Toast.makeText(HomeActivity.this, "Please enter both destination cities", Toast.LENGTH_LONG).show();
                    return;
                } else if (TextUtils.isEmpty(date)) {
                    Toast.makeText(HomeActivity.this, "Please Select Date", Toast.LENGTH_LONG).show();
                    return;
                } else {

                    boolean isOneWayChecked = checkboxOneWay.isChecked();
                    boolean isRoundTripChecked = checkboxRoundTrip.isChecked();
                    boolean isFirstChecked = checkboxFirst.isChecked();
                    boolean isBusinessChecked = checkboxBusiness.isChecked();
                    boolean isEconomyChecked = checkboxEconomy.isChecked();
                    boolean isAdultChecked = checkboxAdult.isChecked();
                    boolean isChildChecked = checkboxChild.isChecked();

                    selected = "From: " + from + "  To: " + to.toString() + "\n";
                    selectedData =
                            "One way: " + isOneWayChecked + "\n" +
                                    "Round trip: " + isRoundTripChecked + "\n" +
                                    "First class: " + isFirstChecked + "\n" +
                                    "Business class: " + isBusinessChecked + "\n" +
                                    "Economy class: " + isEconomyChecked + "\n" +
                                    "Adult: " + isAdultChecked + "\n" +
                                    "Child: " + isChildChecked;

//                Toast.makeText(HomeActivity.this, selected, Toast.LENGTH_LONG).show();
//                tv.setText(selectedData);
                    Intent intent = new Intent(HomeActivity.this, FlightsActivity.class);
                    intent.putExtra("date", date.toString());
                    intent.putExtra("destination", selected.toString());
                    intent.putExtra("name", name.toString());
                    intent.putExtra("email", email.toString());
                    intent.putExtra("data", selectedData);
                    startActivity(intent);
                }
            }
        });

    }
}