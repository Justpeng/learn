package com.just.swing.jframe.selector;

import com.just.swing.jframe.SystemEnum;
import com.just.swing.jframe.service.AbstractSystemService;
import com.just.swing.jframe.service.MacSystem;
import lombok.extern.slf4j.Slf4j;

/**
 * Description
 *
 * @author = peng.li
 * @since 01/07/2019-21:56
 */
@Slf4j
public class MacAddressUtil {


    public static String getAddress() {
        return getService().getAddress();
    }

    private static SystemEnum getSystem() {
        String os = System.getProperty("os.name");
        log.info("os.name:{}",os);
        String lower = os.toLowerCase();
        if (lower.startsWith("win")) {
            return SystemEnum.WIN;
        }
        if (lower.startsWith("mac")) {
            return SystemEnum.MAC;
        }
        return SystemEnum.LINUX;
    }

    private static AbstractSystemService getService() {
        SystemEnum systemEnum = getSystem();
        switch (systemEnum) {
            case MAC:
                return new MacSystem();
            default:
                return null;
        }
    }
}
