package com.example.leddriver_test1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class MainSettings extends AppCompatActivity {
    private MqttManager mqttManager;
    private String mqttTopic = "topic/for/data";
    private String mqttUsername = "mosquitto";
    private String mqttPassword = "lubieplacki";
    private String mqttURL = "tcp://192.168.3.186:1883";
    private String mqttClientId = "ledmatrix_app";

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
        confirmSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntent();
            }
        });

        mqttManager = MqttManager.getInstance(this, mqttURL, mqttClientId, mqttUsername, mqttPassword);
        mqttManager.disconnect();
        // Listeners for text input
        editTextURL.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mqttURL = s.toString();
                //Toast.makeText(getBaseContext(), MainActivity.mqttURL, Toast.LENGTH_SHORT).show();
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
                mqttClientId = s.toString();
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
                mqttUsername = s.toString();
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
                mqttPassword = s.toString();
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
                mqttTopic = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        }
        protected void startIntent (){
            Intent myIntent = new Intent(MainSettings.this, MainActivity.class);
            myIntent.putExtra("url", mqttURL); //Optional parameters
            MainSettings.this.startActivity(myIntent);
        }

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

