package global;

import java.util.ArrayList;
import java.util.List;

import pivtrum.PivtrumPeerData;

/**
 * Created by furszy on 7/2/17.
 */

public class PivtrumGlobalData {

    public static final String[] TRUSTED_NODES = new String[]{"seed.lightpaycasht.net"};

    public static final List<PivtrumPeerData> listTrustedHosts(){
        List<PivtrumPeerData> list = new ArrayList<>();
        for (String trustedNode : TRUSTED_NODES) {
            list.add(new PivtrumPeerData(trustedNode, 51572, 51443));
        }
        return list;
    }

}
