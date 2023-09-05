package com.example.leddriver_test1;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainSettings extends AppCompatActivity { //implement onoptionclick from settingsAdapter /implements SettingsAdapter.OnOptionClickListener/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);
        EditText editTextURL = findViewById(R.id.editTextURL);
        EditText editTextClientID = findViewById(R.id.editTextClientID);
        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        EditText editTextTopic = findViewById(R.id.editTextTopic);
        Button confirmSettings = findViewById(R.id.settings_confirm_button);
        // Listeners for text input
        editTextURL.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.mqttURL = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editTextClientID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.mqttClientId = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editTextUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.mqttUsername = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.mqttPassword = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editTextTopic.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.mqttTopic = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
//        RecyclerView recyclerView = findViewById(R.id.settingsRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Lista opcji w menu ustawień
//        List<String> optionsList = new ArrayList<>();
//        optionsList.add("Zmiana koloru tła");
        // Pozostałe opcje

//        SettingsAdapter settingsAdapter = new SettingsAdapter(optionsList, this); // Inicjalizacja adaptera
//        recyclerView.setAdapter(settingsAdapter);
    }

//    @Override
//    public void onOptionClick(String option) {
//        if (option.equals("Zmiana koloru tła")) {
//            AssistStructure.ViewNode toggleSwitch = null; //create and initialize toggleswitch object
//            handleToggleSwitch(toggleSwitch.isChecked());
//        } else {
//            // Obsługa pozostałych opcji
//        }
//    }

//    public void handleToggleSwitch(boolean isChecked) {
//        // Obsługa zmiany stanu Toggle Switch
//        if (isChecked) {
//            // Ustaw kolor tła na czarny
//            getWindow().getDecorView().setBackgroundColor(Color.BLACK);
//        } else {
//            // Ustaw kolor tła na biały
//            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
//        }
//    }

}
