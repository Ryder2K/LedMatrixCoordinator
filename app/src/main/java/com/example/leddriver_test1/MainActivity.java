package com.example.leddriver_test1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import butterknife.BindView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MqttManager mqttManager;
    private int objectLength = 20;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    private Integer returnColor = 0; //returned hex color value from colorpicker
    private Integer selectedButton = 0;
    private Button[] buttons = new Button[objectLength];
    private String mqttTopic = "topic/for/data";
    private String mqttMessage = "Hello, MQTT!";
    private String mqttUsername = "mosquitto";
    private String mqttPassword = "lubieplacki";
    private String mqttURL = "tcp://192.168.3.186:1883";
    private String mqttClientId = "ledmatrix_app";
    @BindView(R.id.button_led1) Button button_led1;
    @BindView(R.id.button_led2) Button button_led2;
    @BindView(R.id.button_led3) Button button_led3;
    @BindView(R.id.button_led4) Button button_led4;
    @BindView(R.id.button_led5) Button button_led5;
    @BindView(R.id.button_led6) Button button_led6;
    @BindView(R.id.button_led7) Button button_led7;
    @BindView(R.id.button_led8) Button button_led8;
    @BindView(R.id.button_led9) Button button_led9;
    @BindView(R.id.button_led10) Button button_led10;
    @BindView(R.id.button_led11) Button button_led11;
    @BindView(R.id.button_led12) Button button_led12;
    @BindView(R.id.button_led13) Button button_led13;
    @BindView(R.id.button_led14) Button button_led14;
    @BindView(R.id.button_led15) Button button_led15;
    @BindView(R.id.button_led16) Button button_led16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // lock in portrait mode


        // Initialize mqtt
        mqttManager = MqttManager.getInstance(this, mqttURL, mqttClientId, mqttUsername, mqttPassword);
//        mqttManager = new MqttManager(this, mqttURL, mqttClientId, mqttUsername, mqttPassword);
        //boolean mqttConnected = mqttManager.isConnected(); //check mqtt connection state
        updateStatus();
        // Call mqtt publish
        mqttManager.publish(mqttTopic, "Hello there");
        // Initialize buttons
        Button button_led1 = findViewById(R.id.button_led1);
        Button button_led2 = findViewById(R.id.button_led2);
        Button button_led3 = findViewById(R.id.button_led3);
        Button button_led4 = findViewById(R.id.button_led4);
        Button button_led5 = findViewById(R.id.button_led5);
        Button button_led6 = findViewById(R.id.button_led6);
        Button button_led7 = findViewById(R.id.button_led7);
        Button button_led8 = findViewById(R.id.button_led8);
        Button button_led9 = findViewById(R.id.button_led9);
        Button button_led10 = findViewById(R.id.button_led10);
        Button button_led11 = findViewById(R.id.button_led11);
        Button button_led12 = findViewById(R.id.button_led12);
        Button button_led13 = findViewById(R.id.button_led13);
        Button button_led14 = findViewById(R.id.button_led14);
        Button button_led15 = findViewById(R.id.button_led15);
        Button button_led16 = findViewById(R.id.button_led16);
        Button reconnectMqtt = findViewById(R.id.mqtt_reconnect);
        // add initialized buttons to array
        buttons[0] = button_led1;
        buttons[1] = button_led2;
        buttons[2] = button_led3;
        buttons[3] = button_led4;
        buttons[4] = button_led5;
        buttons[5] = button_led6;
        buttons[6] = button_led7;
        buttons[7] = button_led8;
        buttons[8] = button_led9;
        buttons[9] = button_led10;
        buttons[10] = button_led11;
        buttons[11] = button_led12;
        buttons[12] = button_led13;
        buttons[13] = button_led14;
        buttons[14] = button_led15;
        buttons[15] = button_led16;
        buttons[16] = reconnectMqtt;
        // set onClick listeners
        button_led1.setOnClickListener(this);
        button_led2.setOnClickListener(this);
        button_led3.setOnClickListener(this);
        button_led4.setOnClickListener(this);
        button_led5.setOnClickListener(this);
        button_led6.setOnClickListener(this);
        button_led7.setOnClickListener(this);
        button_led8.setOnClickListener(this);
        button_led9.setOnClickListener(this);
        button_led10.setOnClickListener(this);
        button_led11.setOnClickListener(this);
        button_led12.setOnClickListener(this);
        button_led13.setOnClickListener(this);
        button_led14.setOnClickListener(this);
        button_led15.setOnClickListener(this);
        button_led16.setOnClickListener(this);
        reconnectMqtt.setOnClickListener(this);
        buttonsColorInit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // Init context menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // Context menu actions
        switch (item.getItemId()) {
            case R.id.action_settings:
                // Call "Settings" activity
                Intent settingsIntent = new Intent(this, MainSettings.class);
                startActivity(settingsIntent);
                return true;
            case R.id.action_about:
                // Call "About" activity
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void goToAnActivity(View view) {
        Intent light_settings = new Intent(MainActivity.this, LightSettings.class);
        //light_settings.putExtra(Intent.EXTRA_TEXT, textToPass);
        startActivityForResult(light_settings, SECOND_ACTIVITY_REQUEST_CODE);
    }
    private void buttonsColorInit(){
        for(int l=0; l<=16; l++){
            setButtonColor(l,0xFFFFFFFF);
        }

    }
    protected void mqttConnectionState(){
        boolean mqttConnected = mqttManager.isConnected();
        TextView mqttState = (TextView) findViewById(R.id.mqtt_state);
        if (mqttConnected) {
            mqttState.setText("Connected");
            mqttState.setTextColor(Color.parseColor("#4ef542"));
        } else {
            mqttState.setText("Not connected");
            mqttState.setTextColor(Color.parseColor("#f54242"));
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_led1:
                goToAnActivity(v);
                selectedButton = 1;
                break;
            case R.id.button_led2:
                selectedButton = 2;
                goToAnActivity(v);
                break;
            case R.id.button_led3:
                selectedButton = 3;
                goToAnActivity(v);
                break;
            case R.id.button_led4:
                selectedButton = 4;
                goToAnActivity(v);
                break;
            case R.id.button_led5:
                selectedButton = 5;
                goToAnActivity(v);
                break;
            case R.id.button_led6:
                selectedButton = 6;
                goToAnActivity(v);
                break;
            case R.id.button_led7:
                selectedButton = 7;
                goToAnActivity(v);
                break;
            case R.id.button_led8:
                selectedButton = 8;
                goToAnActivity(v);
                break;
            case R.id.button_led9:
                selectedButton = 9;
                goToAnActivity(v);
                break;
            case R.id.button_led10:
                selectedButton = 10;
                goToAnActivity(v);
                break;
            case R.id.button_led11:
                selectedButton = 11;
                goToAnActivity(v);
                break;
            case R.id.button_led12:
                selectedButton = 12;
                goToAnActivity(v);
                break;
            case R.id.button_led13:
                selectedButton = 13;
                goToAnActivity(v);
                break;
            case R.id.button_led14:
                selectedButton = 14;
                goToAnActivity(v);
                break;
            case R.id.button_led15:
                selectedButton = 15;
                goToAnActivity(v);
                break;
            case R.id.button_led16:
                selectedButton = 16;
                goToAnActivity(v);
                break;
            case R.id.mqtt_reconnect:
                getNewSettings();
                updateStatus();
                mqttManager.reconnect();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check if previous activity returned "OK" code
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // Grab data from previous activity
                String returnString = data.getStringExtra("string_color_return");
                TextView textView = (TextView) findViewById(R.id.textView2);
                returnColor = data.getIntExtra("int_color_return", 0xFFFFFFF);
                returnString = convertToString(selectedButton, returnString);
                System.out.println("Returned value: " + returnColor);
                setButtonColor(selectedButton - 1, returnColor);
                textView.setText(returnString); //convertToString(selectedButton, returnString)
                mqttMessage = returnString;
                mqttManager.publish(mqttTopic, mqttMessage);
            }
        }
    }
    protected void getNewSettings(){
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            mqttURL = extras.getString("url");
        }
    }
    // Set button background color based on the selected color
    protected void setButtonColor(int button, int color){
        buttons[button].setBackgroundColor(color);
    }
    protected void updateStatus(){
        TextView mqttUrltextView = (TextView) findViewById(R.id.mqtt_url);
        mqttConnectionState();
        mqttUrltextView.setText("Broker: " + mqttURL);
    }
    private String convertToString(int value, String str){
        String finalStr = "";
        finalStr = String.format(Locale.getDefault(), "%s ", value);
        finalStr += str;
        return finalStr;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Disconnect MQTT
        mqttManager.disconnect();
    }
}
