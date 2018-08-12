package lightpaycash.org.lightpaycashwallet.ui.settings_restore_activity;

import android.os.Bundle;
import android.view.ViewGroup;

import lightpaycash.org.lightpaycashwallet.R;
import lightpaycash.org.lightpaycashwallet.ui.base.BaseActivity;

/**
 * Created by Neoperol on 5/18/17.
 */

public class SettingsRestoreActivity extends BaseActivity {

    @Override
    protected void onCreateView(Bundle savedInstanceState,ViewGroup container) {
        getLayoutInflater().inflate(R.layout.fragment_settings_restore, container);
        setTitle("Restore Wallet");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}