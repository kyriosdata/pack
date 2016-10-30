package com.github.kyriosdata.pack;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

public class PackTest {

    private Pack pack = PackFactory.newInstance();

    @Test
    public void vetorNemSenhaPodeSerNull() {
        Class<IllegalArgumentException> iae = IllegalArgumentException.class;

        assertThrows(iae, () -> pack.lacra(new byte[0], null));
        assertThrows(iae, () -> pack.lacra(null, "ok".toCharArray()));
    }

    @Test
    public void vaiVolta() throws UnsupportedEncodingException {

        // Compressão de texto curto
        final String msg = "um simples texto, ok?";

        // Bytes a serem comprimidos
        byte[] dados = msg.getBytes("UTF-8");

        // Senha
        String senha = "ok";

        byte[] protegido = pack.lacra(dados, senha.toCharArray());
        byte[] obtido = pack.deslacra(protegido, senha.toCharArray());

        String msgRecuperada = new String(obtido, "UTF-8");
        assertEquals(msg, msgRecuperada);
    }

    @Test
    public void vaiVolta2() throws UnsupportedEncodingException {

        // Bytes a serem comprimidos
        byte[] dados = new byte[10 * 1024];

        // Senha
        String senha = "a senha pode ser imensa, sem problemas";

        byte[] protegido = pack.lacra(dados, senha.toCharArray());
        byte[] obtido = pack.deslacra(protegido, senha.toCharArray());

        assertArrayEquals(dados, obtido);
    }
}

