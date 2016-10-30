package com.github.kyriosdata.pack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Implementação de compressão usando Zip.
 */
public class CompressaoZip implements Compressao {

    public byte[] descomprime(byte[] entrada) throws IOException {

        // INPUT
        ByteArrayInputStream bis = new ByteArrayInputStream(entrada);
        ZipInputStream zis = new ZipInputStream(bis);
        zis.getNextEntry();

        // OUTPUT
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final int MAX = 1024;
        byte[] localBuffer = new byte[MAX];

        int count;
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
}
