package com.example.myapplicationmaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.Place.Field;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int AUTOCOMPLETE_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView locationTextView = findViewById(R.id.textView);
        locationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lanzar la actividad de autocompletado de Places
                List<Field> fields = Arrays.asList(Field.LAT_LNG, Field.NAME, Field.ADDRESS);
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                        .build(MainActivity.this);
                startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                // Obtener la información de la ubicación seleccionada
                String locationName = place.getName();
                String locationAddress = place.getAddress();
                // Actualizar el TextView con la ubicación seleccionada
                TextView locationTextView = findViewById(R.id.textView);
                locationTextView.setText(locationName + ", " + locationAddress);
            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // Manejar errores
            } else if (resultCode == RESULT_CANCELED) {
                // El usuario canceló la selección
            }
        }
    }


}