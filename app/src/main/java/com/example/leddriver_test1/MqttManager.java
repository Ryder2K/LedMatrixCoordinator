package com.example.leddriver_test1;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttManager {
    private static MqttManager instance;
    private MqttClient mqttClient;
    private Context context;
    // Init mqtt manager
    private String brokerUrl;
    private String clientId;
    private String username;
    private String password;

    public MqttManager(Context context, String brokerUrl, String clientId, String username, String password) {
        this.context = context.getApplicationContext();
        this.brokerUrl = brokerUrl;
        this.clientId = clientId;
        this.username = username;
        this.password = password;
        connectToBroker(brokerUrl, clientId, username, password);
    }
    // Metoda, która zwraca instancję MqttManager lub tworzy ją, jeśli nie istnieje
    public static synchronized MqttManager getInstance(Context context, String brokerUrl, String clientId, String username, String password) {
        if (instance == null) {
            instance = new MqttManager(context, brokerUrl, clientId, username, password);
        }
        return instance;
    }

    private void connectToBroker(String brokerUrl, String clientId, String username, String password) {
        try {
            mqttClient = new MqttClient(brokerUrl, clientId, null);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            mqttClient.connect(options);
            showToast("Connected to broker!");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    // Publish mqtt message
    public void publish(String topic, String payload) {
        try {
            MqttMessage mqttMessage = new MqttMessage(payload.getBytes());
            mqttClient.publish(topic, mqttMessage);
            showToast("MQTT message published:" + payload);
        } catch (MqttException e) {
            showToast("Error publishing MQTT message!");
            e.printStackTrace();
        }
    }
    // Handler for toast messages
    private void showToast(final String message) {
        // Call toast in the main activity
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean isConnected() {
        return mqttClient != null && mqttClient.isConnected();
    }
    public void disconnect() {
        try {
            if (mqttClient != null && mqttClient.isConnected()) {
                mqttClient.disconnect();
                showToast("Disconnected from broker!");
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    public void reconnect() {
        if (!isConnected()) {
            connectToBroker(brokerUrl, clientId, username, password);
        }
        else if (isConnected()){
            disconnect();
            connectToBroker(brokerUrl, clientId, username, password);
        }
    }
}
