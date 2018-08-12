package lightpaycash.org.lightpaycashwallet.ui.base;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import lightpaycash.org.lightpaycashwallet.ColxApplication;
import lightpaycash.org.lightpaycashwallet.module.PivxModule;

/**
 * Created by furszy on 6/29/17.
 */

public class BaseFragment extends Fragment {

    protected ColxApplication pivxApplication;
    protected PivxModule pivxModule;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pivxApplication = ColxApplication.getInstance();
        pivxModule = pivxApplication.getModule();
    }

    protected boolean checkPermission(String permission) {
        int result = ContextCompat.checkSelfPermission(getActivity(),permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
