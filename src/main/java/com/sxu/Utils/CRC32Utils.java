package com.sxu.Utils;

import java.util.zip.CRC32;

public class CRC32Utils {
    private static CRC32 crc32 = new CRC32();

    public static boolean crc32Check(String str, String checkResultStr) {
        crc32.update(str.getBytes());
        return checkResultStr.equals(Long.toHexString(crc32.getValue()).toUpperCase());
    }
}
