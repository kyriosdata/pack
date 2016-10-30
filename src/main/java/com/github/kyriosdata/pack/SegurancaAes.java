package com.github.kyriosdata.pack;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Implementação de segurança usando AES.
 */
public class SegurancaAes implements Seguranca {

    private byte[] salt = { 1, 3, 5, 7, 9, 11, 3, 17, 3, 7, 9, 7, 5, 3, 1, 7 };

    @Override
    public byte[] encrypt(byte[] bytes, char[] key) {
        return crypt(bytes, key, Cipher.ENCRYPT_MODE);
    }

    @Override
    public byte[] decrypt(byte[] bytes, char[] key) {
        return crypt(bytes, key, Cipher.DECRYPT_MODE);
    }

    private byte[] crypt(byte[] bytes, char[] key, int mode) {
        try {
            IvParameterSpec iv = new IvParameterSpec(salt);

            byte[] senha = digest(toBytes(key));

            SecretKeySpec skeySpec = new SecretKeySpec(senha, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(mode, skeySpec, iv);

            byte[] buffer = cipher.doFinal(bytes);

            Arrays.fill(senha, (byte)0);

            return buffer;
        } catch (Exception ex) {
            throw new PackException(ex.getMessage());
        }
    }

    private byte[] digest(byte[] dados) throws NoSuchAlgorithmException {

        // 128 bits = 16 bytes
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update(dados);

        return messageDigest.digest();
    }

    private byte[] toBytes(char[] chars) {
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
                byteBuffer.position(), byteBuffer.limit());

        // Limpa dados sensíveis
        Arrays.fill(byteBuffer.array(), (byte) 0);

        return bytes;
    }
}
