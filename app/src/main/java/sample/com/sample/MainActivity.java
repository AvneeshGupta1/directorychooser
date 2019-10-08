package sample.com.sample;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.directorypicker.R;

import net.rdrei.android.dirchooser.DirectoryChooserActivity;
import net.rdrei.android.dirchooser.DirectoryChooserConfig;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_DIRECTORY = 12;
    private Button btnPick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPick = findViewById(R.id.btnNext);
        btnPick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnPick) {
            final Intent chooserIntent = new Intent(
                    this,
                    DirectoryChooserActivity.class);
            final DirectoryChooserConfig config = DirectoryChooserConfig.builder()
                    .newDirectoryName("Choose Directory")
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


}
