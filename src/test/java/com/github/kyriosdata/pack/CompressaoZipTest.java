package com.github.kyriosdata.pack;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompressaoZipTest {

    @Test
    public void compressUncompress() throws IOException {

        Compressao zip = new CompressaoZip();

        final String msg = "A vida é bela!";
        byte[] dados = msg.getBytes("UTF-8");

        byte[] compressed = zip.comprime(dados);
        byte[] uncompressed = zip.descomprime(compressed);

        String msgRecuperada = new String(uncompressed, "UTF-8");
        
        assertEquals(msg, msgRecuperada);
    }
}

