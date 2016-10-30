/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.pack;

/**
 * Essa classe oferece dois serviços: "lacra" e
 * "deslacra" o conteúdo de um vetor de bytes.
 *
 * <p>Lacrar significa comprimir o vetor de bytes,
 * usando ZIP e criptografar usando AES com senha
 * de 16 bytes.
 */
public class PackPadrao implements Pack {

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
            byte[] comprime = compressao.comprime(data);
            retorno = seguranca.encrypt(comprime, password);
        } catch (Exception e) {
            throw new PackException(e);
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
            byte[] decrypt = seguranca.decrypt(data, password);
            retorno = compressao.descomprime(decrypt);
        } catch (Exception e) {
            throw new PackException(e);
        }

        return retorno;
    }
}
