package com.example.leddriver_test1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.defaults.colorpicker.ColorPickerPopup;
import top.defaults.colorpicker.ColorPickerView;
public class LightSettings extends AppCompatActivity {
    private static final String SAVED_STATE_KEY_COLOR = "key_color";
    private static final int INITIAL_COLOR = 0xFFFFFFFF;
    private String COLOR_TO_RETURN_STRING = "";
    private int COLOR_TO_RETURN_INT = 0;
    @BindView(R.id.colorPicker) ColorPickerView colorPickerView;
    @BindView(R.id.pickedColor) View pickedColor;
    @BindView(R.id.colorHex) TextView colorHex;

    // View colorpicker
    @OnClick({R.id.pickedColor, R.id.colorHex})
    void popup(View v) {
        new ColorPickerPopup.Builder(this)
                .initialColor(colorPickerView.getColor())
                .enableAlpha(true)
                .okTitle("Choose")
                .cancelTitle("Cancel")
                .showIndicator(true)
                .showValue(true)
                .onlyUpdateOnTouchEventUp(true)
                .build()
                .show(new ColorPickerPopup.ColorPickerObserver() {
                    @Override
                    public void onColorPicked(int color) {
                        colorPickerView.setInitialColor(color);
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_settings);
        Button color_apply = findViewById(R.id.color_apply);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ButterKnife.bind(this);
        // OnClick listener for Zatwierdz button
        color_apply.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("int_color_return", COLOR_TO_RETURN_INT);
            intent.putExtra("string_color_return", COLOR_TO_RETURN_STRING);
            setResult(RESULT_OK, intent);
            finish(); // End & leave activity
        });

        colorPickerView.subscribe((color, fromUser, shouldPropagate) -> {
            pickedColor.setBackgroundColor(color);
            colorHex.setText(colorHex(color));

            color_apply.setBackgroundColor(color);

            COLOR_TO_RETURN_STRING = colorHex(color);
            COLOR_TO_RETURN_INT = color;
        });

        int color = INITIAL_COLOR;
        if (savedInstanceState != null) {
            color = savedInstanceState.getInt(SAVED_STATE_KEY_COLOR, INITIAL_COLOR);
        }
        colorPickerView.setInitialColor(color);
    }
    // Parameters to pass from this activity
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVED_STATE_KEY_COLOR, colorPickerView.getColor());
    }
    // Convert Hex to String
    private String colorHex(int color) {
        int a = Color.alpha(color);
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        return String.format(Locale.getDefault(), "0x%02X%02X%02X%02X", a, r, g, b);
    }
}