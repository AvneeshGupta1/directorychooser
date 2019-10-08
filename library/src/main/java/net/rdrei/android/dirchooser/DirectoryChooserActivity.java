package net.rdrei.android.dirchooser;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * Let's the user choose a directory on the storage device. The selected folder
 * will be sent back to the starting activity as an activity result.
 */
public class DirectoryChooserActivity extends AppCompatActivity implements
        DirectoryChooserFragment.OnFragmentInteractionListener {
    public static final String EXTRA_CONFIG = "config";
    public static final String RESULT_SELECTED_DIR = "selected_dir";
    public static final int RESULT_CODE_DIR_SELECTED = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.directory_chooser_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeButtonEnabled(true);
        }
        final DirectoryChooserConfig config = getIntent().getParcelableExtra(EXTRA_CONFIG);

        if (config == null) {
            throw new IllegalArgumentException(
                    "You must provide EXTRA_CONFIG when starting the DirectoryChooserActivity.");
        }

        if (savedInstanceState == null) {
            final FragmentManager fragmentManager = getFragmentManager();
            final DirectoryChooserFragment fragment = DirectoryChooserFragment.newInstance(config);
            fragmentManager.beginTransaction()
                    .add(R.id.main, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int itemId = item.getItemId();

        if (itemId == android.R.id.home) {
            setResult(RESULT_CANCELED);
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelectDirectory(@NonNull String path) {
        final Intent intent = new Intent();
        intent.putExtra(RESULT_SELECTED_DIR, path);
        setResult(RESULT_CODE_DIR_SELECTED, intent);
        finish();
    }

    @Override
    public void onCancelChooser() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
