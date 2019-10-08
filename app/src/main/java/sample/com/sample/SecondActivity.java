package sample.com.sample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import com.directorypicker.R;

public class SecondActivity extends AppCompatActivity {

    private Button btnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnEvent = findViewById(R.id.btnEvent);
    }

}
