package com.example.travelguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class TourActivity extends AppCompatActivity {

    private EditText Startdate, Enddate;
    private TextView yourTour;
    private ListView listView;
    private Button createTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        ArrayList<Attraction> attractions = getIntent().getParcelableArrayListExtra("attractions");

        Startdate = findViewById(R.id.StyleField);
        Enddate = findViewById(R.id.timeField);

        yourTour = findViewById(R.id.textView11);

        listView = findViewById(R.id.listView2);

        createTour = findViewById(R.id.createTourButton);

        createTour.setOnClickListener(v -> {
            if (!Startdate.getText().toString().equals("") && !Enddate.getText().toString().equals("")) {
                yourTour.setText("Достопримечательности:");

                ArrayList<Attraction> tour = new ArrayList<>();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
                String cal1 = Startdate.getText().toString();
                String cal2 = Enddate.getText().toString();
                Calendar calendar = Calendar.getInstance();
                try {
                    calendar.setTime(dateFormat.parse(cal1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    calendar.setTime(dateFormat.parse(cal2));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < attractions.size(); i++) {
                    if (!(cal2.compareTo(attractions.get(i).getStart())<=0  || cal1.compareTo(attractions.get(i).getEnd())>=0)) {
                        tour.add(attractions.get(i));
                    }
                }

                ArrayAdapter<Attraction> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tour);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                        Intent intent = new Intent(TourActivity.this, AttractionActivity.class);
                        intent.putExtra("attraction", tour.get(position));
                        startActivity(intent);
                    }
                });
            } else
                Toast.makeText(TourActivity.this, "Введите данные.", Toast.LENGTH_LONG).show();
        });
    }
}