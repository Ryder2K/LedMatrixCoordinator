package com.example.leddriver_test1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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
    private int objectLength = 16;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    private Integer returnColor = 0; //returned hex color value from colorpicker
    private Integer selectedButton = 0;
    private Button[] buttons = new Button[objectLength];
    private static final String MQTT_BROKER_URI = "tcp://192.168.3.186:1883";
    private static final String MQTT_CLIENT_ID = "laka_swiatlowodowa";
    private static final String MQTT_TOPIC = "android/lightstring/data";
    public static String mqttTopic = "topic/for/data";
    public static String mqttMessage = "Hello, MQTT!";
    public static String mqttUsername = "";
    public static String mqttPassword = "";
    public static String mqttURL = "tcp://192.168.3.186:1883";
    public static String mqttClientId = "ledmatrix_app";


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

        TextView mqttUrltextView = (TextView) findViewById(R.id.mqtt_url);
        mqttUrltextView.setText("Broker URL:" + mqttURL);

        // Initialize mqtt
        mqttManager = new MqttManager(this, mqttURL, mqttClientId, mqttUsername, mqttPassword);

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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_led1:
                goToAnActivity(v);
                selectedButton = 0;
                break;
            case R.id.button_led2:
                selectedButton = 1;
                goToAnActivity(v);
                break;
            case R.id.button_led3:
                selectedButton = 2;
                goToAnActivity(v);
                break;
            case R.id.button_led4:
                selectedButton = 3;
                goToAnActivity(v);
                break;
            case R.id.button_led5:
                selectedButton = 4;
                goToAnActivity(v);
                break;
            case R.id.button_led6:
                selectedButton = 5;
                goToAnActivity(v);
                break;
            case R.id.button_led7:
                selectedButton = 6;
                goToAnActivity(v);
                break;
            case R.id.button_led8:
                selectedButton = 7;
                goToAnActivity(v);
                break;
            case R.id.button_led9:
                selectedButton = 8;
                goToAnActivity(v);
                break;
            case R.id.button_led10:
                selectedButton = 9;
                goToAnActivity(v);
                break;
            case R.id.button_led11:
                selectedButton = 10;
                goToAnActivity(v);
                break;
            case R.id.button_led12:
                selectedButton = 11;
                goToAnActivity(v);
                break;
            case R.id.button_led13:
                selectedButton = 12;
                goToAnActivity(v);
                break;
            case R.id.button_led14:
                selectedButton = 13;
                goToAnActivity(v);
                break;
            case R.id.button_led15:
                selectedButton = 14;
                goToAnActivity(v);
                break;
            case R.id.button_led16:
                selectedButton = 15;
                goToAnActivity(v);
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
                returnColor = data.getIntExtra("int_color_return", 0xFFFFFFF);

                System.out.println("Returned value: " + returnColor);
                setButtonColor();
                mqttManager.publish(mqttTopic, mqttMessage);
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText(convertToString(selectedButton, returnString));
            }
        }
    }
    // Set button background color based on the selected color
    protected void setButtonColor(){
        buttons[selectedButton].setBackgroundColor(returnColor);
    }
    private String convertToString(int value, String str){
        int i = value;
        String finalStr = "";
        finalStr = String.format(Locale.getDefault(), "%s ", i);
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
