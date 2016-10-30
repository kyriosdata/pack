package com.github.kyriosdata.pack;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Implementação de segurança usando AES.
 */
public class SegurancaAes implements Seguranca {

    private byte[] salt = { 1, 3, 5, 7, 9, 11, 3, 17, 3, 7, 9, 7, 5, 3, 1, 7 };

    @Override
    public byte[] encrypt(byte[] bytes, byte[] key) {
        return crypt(bytes, key, Cipher.ENCRYPT_MODE);
    }

    @Override
    public byte[] decrypt(byte[] encrypted, byte[] keyBytes) {
        return crypt(encrypted, keyBytes, Cipher.DECRYPT_MODE);
    }

    public byte[] crypt(byte[] encrypted, byte[] keyBytes, int mode) {
        try {
            IvParameterSpec iv = new IvParameterSpec(salt);

            SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(mode, skeySpec, iv);

            return cipher.doFinal(encrypted);
        } catch (Exception ex) {
            return null;
        }
    }
}
