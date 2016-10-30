package com.github.kyriosdata.pack;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegurancaAesTest {

    private SegurancaAes aes = new SegurancaAes();

    @Test
    public void criptografaDescriptografa() throws UnsupportedEncodingException {

        final String msg = "A vida é bela, não tenha dúvida!";
        byte[] dados = msg.getBytes("UTF-8");

        char[] senha = "açaí".toCharArray();

        byte[] protegido = aes.encrypt(dados, senha);
        byte[] obtido = aes.decrypt(protegido, senha);

        String msgRecuperada = new String(obtido, "UTF-8");
        
        assertEquals(msg, msgRecuperada);
    }
}

