package bin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leddriver_test1.MainSettings;
import com.example.leddriver_test1.R;

import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {
    private List<String> optionsList;
    private MainSettings mainSettings;
    public interface OnOptionClickListener {
        void onOptionClick(String option);
    }
    public SettingsAdapter(List<String> optionsList, MainSettings mainSettings) { // Interfejs dla kliknięcia opcji
        this.optionsList = optionsList;
        this.mainSettings = mainSettings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Tworzenie widoku pojedynczej pozycji w RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_option, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Powiązanie danych z pozycją RecyclerView
        String option = optionsList.get(position);
        holder.optionTextView.setText(option);

        // Zerowa pozycja w RecyclerView
//        if (position == 0) {
//            holder.toggleSwitch.setVisibility(View.VISIBLE);
//            holder.toggleSwitch.setChecked(isDarkModeEnabled()); // Stan Toggle Switch na podstawie aktualnego trybu tła (jasnego/ciemnego)
//            // Obsługa zmiany stanu Toggle Switch
//            holder.toggleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    mainSettings.handleToggleSwitch(isChecked);
//                }
//            });
//        } else {
//            holder.toggleSwitch.setVisibility(View.GONE); // Ukrycie Toggle Switcha dla pozostałych pozycji
//        }
        //
    }

    @Override
    public int getItemCount() {
        return optionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView optionTextView;
        SwitchCompat toggleSwitch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            optionTextView = itemView.findViewById(R.id.optionTextView);
//            toggleSwitch = itemView.findViewById(R.id.toggleSwitch);
        }
    }
    // Sprawdzenie, czy tryb ciemny jest włączony
//    private boolean isDarkModeEnabled() {
//        int nightMode = AppCompatDelegate.getDefaultNightMode();
//        return nightMode == AppCompatDelegate.MODE_NIGHT_YES;
//    }



}
