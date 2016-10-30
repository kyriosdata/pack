package com.github.kyriosdata.pack;

/**
 * Created by kyriosdata on 10/30/16.
 */
public interface Seguranca {
    byte[] encrypt(byte[] bytes, byte[] key);

    byte[] decrypt(byte[] encrypted, byte[] keyBytes);
}
