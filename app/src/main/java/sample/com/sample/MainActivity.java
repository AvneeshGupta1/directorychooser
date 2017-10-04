package sample.com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.directorypicker.R;
import com.sample.eventbus.Event;
import com.sample.eventbus.EventManager;
import com.sample.eventbus.OnEventListener;

import net.rdrei.android.dirchooser.DirectoryChooserActivity;
import net.rdrei.android.dirchooser.DirectoryChooserConfig;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnEventListener {

    private static final int REQUEST_DIRECTORY = 12;
    private String[] event = {Event.FOLDER_UPDATE};
    private Button btnPick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPick = findViewById(R.id.btnNext);
        btnPick.setOnClickListener(this);
        EventManager.getInstance().addOnEventListener(this, event);
    }

    @Override
    public void onClick(View view) {
        if (view == btnPick) {
            final Intent chooserIntent = new Intent(
                    this,
                    DirectoryChooserActivity.class);
            final DirectoryChooserConfig config = DirectoryChooserConfig.builder()
                    .newDirectoryName("Choose Directory")
                    .allowReadOnlyDirectory(true)
                    .allowNewDirectoryNameModification(true)
                    .build();

            chooserIntent.putExtra(
                    DirectoryChooserActivity.EXTRA_CONFIG,
                    config);

            startActivityForResult(chooserIntent, REQUEST_DIRECTORY);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DIRECTORY) {
            if (resultCode == DirectoryChooserActivity.RESULT_CODE_DIR_SELECTED) {
                String selectedDir = data.getStringExtra(DirectoryChooserActivity.RESULT_SELECTED_DIR);
                if (selectedDir != null) {
                    Log.d("", "");
                }
            }
        }
    }

    @Override
    public void onEvent(String event, Object object) {
        if (event.equals(Event.FOLDER_UPDATE)) {
            Toast.makeText(this, "Event Occured", Toast.LENGTH_SHORT).show();
        }
    }
}
