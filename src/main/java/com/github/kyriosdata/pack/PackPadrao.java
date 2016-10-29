/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.pack;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Essa classe oferece dois serviços: "lacra" e
 * "deslacra" o conteúdo de um vetor de bytes.
 *
 * <p>Lacrar significa comprimir o vetor de bytes,
 * usando ZIP e criptografar usando AES com senha
 * de 16 bytes.
 */
public class PackPadrao implements Pack {

    private byte[] salt = { 1, 3, 5, 7, 9, 11, 3, 17, 3, 7, 9, 7, 5, 3, 1, 7 };

    public byte[] encrypt(byte[] bytes, byte[] key) {
        try {
            IvParameterSpec iv = new IvParameterSpec(salt);

            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            return cipher.doFinal(bytes);
        } catch (Exception ex) {
            return null;
        }
    }

    public byte[] decrypt(byte[] encrypted, byte[] keyBytes) {
        try {
            IvParameterSpec iv = new IvParameterSpec(salt);

            SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            return cipher.doFinal(encrypted);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public byte[] lacra(byte[] data, char[] password) {
        if (data == null || password == null) {
            throw new IllegalArgumentException("data ou password null");
        }

        byte[] retorno;

        try {
            byte[] senha = digest(toBytes(password));
            retorno = encrypt(comprime(data), senha);
            Arrays.fill(senha, (byte)0);
        } catch (Exception e) {
            retorno = null;
        }

        return retorno;
    }

    @Override
    public byte[] deslacra(byte[] data, char[] password) {
        if (data == null || password == null) {
            throw new IllegalArgumentException("data ou password null");
        }

        byte[] retorno;

        try {
            byte[] senha = digest(toBytes(password));
            retorno = descomprime(decrypt(data, senha));
            Arrays.fill(senha, (byte)0);
        } catch (Exception e) {
            retorno = null;
        }

        return retorno;
    }

    public byte[] descomprime(byte[] entrada) throws IOException {

        // INPUT
        ByteArrayInputStream bis = new ByteArrayInputStream(entrada);
        ZipInputStream zis = new ZipInputStream(bis);
        zis.getNextEntry();

        // OUTPUT
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final int MAX = 2048;
        byte[] localBuffer = new byte[2048];

        int count = 0;
        while ((count = zis.read(localBuffer, 0, MAX)) != -1) {
            bos.write(localBuffer, 0, count);
        }

        bos.flush();

        return bos.toByteArray();
    }

    public byte[] comprime(byte[] entrada) throws IOException {

        // OUTPUT
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(bos);
        zos.putNextEntry(new ZipEntry("x"));

        // WRITE
        zos.write(entrada, 0, entrada.length);

        // FECHA
        zos.closeEntry();
        zos.flush();

        return bos.toByteArray();
    }

    public byte[] digest(byte[] dados) throws Exception {

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
        Arrays.fill(charBuffer.array(), '\u0000');
        Arrays.fill(byteBuffer.array(), (byte) 0);

        return bytes;
    }
}
