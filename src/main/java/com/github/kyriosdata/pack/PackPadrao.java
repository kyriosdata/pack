/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.pack;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Cria uma instância de {@link Pack}.
 */
public class PackPadrao implements Pack {

    @Override
    public byte[] cc(byte[] data, String password) {
        if (data == null || password == null) {
            throw new IllegalArgumentException("data ou password null");
        }

        return new byte[0];
    }

    @Override
    public byte[] dd(byte[] data, String password) {
        return new byte[0];
    }

    public void comprime(byte[] entrada) throws IOException {
        ByteInputStream bis = new ByteInputStream(entrada, entrada.length);
        ZipInputStream zis = new ZipInputStream(bis);
        ZipEntry ze = zis.getNextEntry();
    }
}
