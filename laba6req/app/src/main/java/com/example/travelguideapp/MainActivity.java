package com.example.travelguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yandex.mapkit.MapKitFactory;
public class MainActivity extends AppCompatActivity {

    private EditText userSurname, userName, userEmail;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapKitFactory.setApiKey("8d94bbd0-82a9-4dae-b5f2-04236d3ce6ab");

        userSurname = findViewById(R.id.userSurnameField);
        userName = findViewById(R.id.userNameField);
        userEmail= findViewById(R.id.userEmailField);


        next = findViewById(R.id.nextButton);
        next.setOnClickListener(v -> {
            if (!userName.getText().toString().equals("")) {
                User user = new User(userName.getText().toString(), userSurname.getText().toString(), userEmail.getText().toString());
                Intent intent = new Intent(MainActivity.this, ListOfAttractionsActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            } else
                Toast.makeText(MainActivity.this, "Введите имя, пожалуйста.", Toast.LENGTH_LONG).show();
        });

    }
}
