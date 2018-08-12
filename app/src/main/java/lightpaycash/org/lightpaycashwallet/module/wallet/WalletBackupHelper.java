package lightpaycash.org.lightpaycashwallet.module.wallet;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import lightpaycash.org.lightpaycashwallet.ColxApplication;
import lightpaycash.org.lightpaycashwallet.module.PivxContext;
import global.utils.Iso8601Format;

import static com.google.common.base.Preconditions.checkState;

/**
 * Created by furszy on 6/29/17.
 */

public class WalletBackupHelper {

    public File determineBackupFile(String extraData) {
        PivxContext.Files.EXTERNAL_WALLET_BACKUP_DIR.mkdirs();
        checkState(PivxContext.Files.EXTERNAL_WALLET_BACKUP_DIR.isDirectory(), "%s is not a directory", PivxContext.Files.EXTERNAL_WALLET_BACKUP_DIR);

        final DateFormat dateFormat = Iso8601Format.newDateFormat();
        dateFormat.setTimeZone(TimeZone.getDefault());

        String appName = ColxApplication.getInstance().getVersionName();

        for (int i = 0; true; i++) {
            final StringBuilder filename = new StringBuilder(PivxContext.Files.getExternalWalletBackupFileName(appName));
            filename.append('-');
            filename.append(dateFormat.format(new Date()));
            if (extraData!=null){
                filename.append("-"+extraData);
            }
            if (i > 0)
                filename.append(" (").append(i).append(')');

            final File file = new File(PivxContext.Files.EXTERNAL_WALLET_BACKUP_DIR, filename.toString());
            if (!file.exists())
                return file;
        }
    }

}
