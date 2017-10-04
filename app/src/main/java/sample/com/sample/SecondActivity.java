package sample.com.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.directorypicker.R;
import com.sample.eventbus.Event;
import com.sample.eventbus.EventManager;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnEvent = findViewById(R.id.btnEvent);
        btnEvent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EventManager.getInstance().publishEvent(Event.FOLDER_UPDATE, null);
    }
}
