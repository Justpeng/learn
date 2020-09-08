package com.just.swing.jframe.service;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description
 *
 * @author = peng.li
 * @since 01/07/2019-21:53
 */
@Slf4j
public class MacSystem extends AbstractSystemService {
    @Override
    public String getAddress() {
        BufferedReader br = null;
        String result = null;
        try {
            Process process = Runtime.getRuntime().exec("ifconfig en0");
            process.waitFor();

            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuffer.append(line);
            }
            String str1 = stringBuffer.toString();
            String str2 = str1.split("ether")[1].trim();
            result = str2.substring(0,14);
            log.info("MAC MACAddress:{}", result);
        } catch (Exception e) {
            log.error("获取异常,",e);
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
