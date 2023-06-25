package com.example.travelguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Circle;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class AttractionActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_attraction);
        mapView = (MapView) findViewById(R.id.mapView);

        TextView textViewName = findViewById(R.id.textView6);
        TextView textViewFullDescription = findViewById(R.id.textView7);
        Attraction attraction = getIntent().getParcelableExtra("attraction");
        textViewName.setText(attraction.getName());
        textViewFullDescription.setText(attraction.getFullDescription());

        mapView.getMap().move(
                new CameraPosition(attraction.getCoordinates(), 16.2f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);
        mapView.getMap().getMapObjects().addCircle(new Circle(attraction.getCoordinates(), 15), Color.RED, 2, Color.RED);
    }

    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
}