package com.grishalyullin.utils;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashHelper {

    /**
     * Hash algorithm name.
     */
    private static final String HASH_ALG = "MD5";

    /**
     * Logger for UserService class.
     */
    private static final Logger LOG = Logger.getLogger(HashHelper.class.getName());

    /**
     * Generates hash string.
     *
     * @param input - input string
     * @return Hash string
     */
    public static String generateHash(String input) {
        String generateHash = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance(HASH_ALG);
            md5.update(input.getBytes());
            byte inputStrData[] = md5.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : inputStrData) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            generateHash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            LOG.warn("Algorithm \"" + HASH_ALG + "\" was not found.", e);
        }
        return generateHash;
    }
}
