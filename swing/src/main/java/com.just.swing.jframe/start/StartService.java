package com.just.swing.jframe.start;

import com.just.swing.jframe.selector.MacAddressUtil;

/**
 * Description
 *
 * @author = peng.li
 * @since 01/07/2019-21:59
 */
public class StartService {
    private static final String MAC_ADDRESS = "8c:85:90:5a:14";

    public boolean isAuthor() {
        String address = MacAddressUtil.getAddress();
        if (MAC_ADDRESS.equalsIgnoreCase(address)) {
            return true;
        } else {
            return false;
        }
    }
}
