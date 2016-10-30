/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.pack;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Essa classe oferece dois serviços: "lacra" e
 * "deslacra" o conteúdo de um vetor de bytes.
 *
 * <p>Lacrar significa comprimir o vetor de bytes,
 * usando ZIP e criptografar usando AES com senha
 * de 16 bytes.
 */
public class PackPadrao extends SegurancaAes implements Pack {

    private Compressao compressao;
    private Seguranca seguranca;

    public PackPadrao(Compressao compressao, Seguranca seguranca) {
        this.compressao = compressao;
        this.seguranca = seguranca;
    }

    @Override
    public byte[] lacra(byte[] data, char[] password) {
        if (data == null || password == null) {
            throw new IllegalArgumentException("data ou password null");
        }

        byte[] retorno;

        try {
            byte[] senha = digest(toBytes(password));
            byte[] comprime = compressao.comprime(data);
            retorno = seguranca.encrypt(comprime, senha);
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
            byte[] decrypt = seguranca.decrypt(data, senha);
            retorno = compressao.descomprime(decrypt);
            Arrays.fill(senha, (byte)0);
        } catch (Exception e) {
            retorno = null;
        }

        return retorno;
    }

    private byte[] digest(byte[] dados) throws Exception {

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
