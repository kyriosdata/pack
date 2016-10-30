package com.github.kyriosdata.pack;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

public class PackTest {

    private Pack pack = PackFactory.newInstance();

    @Test
    public void vetorNemSenhaPodeSerNull() {
        Class<IllegalArgumentException> iae = IllegalArgumentException.class;

        assertThrows(iae, () -> pack.lacra(new byte[0], null));
        assertThrows(iae, () -> pack.lacra(null, "ok".toCharArray()));
        assertThrows(iae, () -> pack.deslacra(new byte[0], null));
        assertThrows(iae, () -> pack.deslacra(null, "ok".toCharArray()));
    }

    @Test
    public void vaiVolta() throws UnsupportedEncodingException {

        // Compressão de texto curto
        final String msg = "um simples texto, ok?";

        // Bytes a serem comprimidos
        byte[] dados = msg.getBytes("UTF-8");

        // Senha
        char[] senha = "ok".toCharArray();

        byte[] protegido = pack.lacra(dados, senha);
        byte[] obtido = pack.deslacra(protegido, senha);

        String msgRecuperada = new String(obtido, "UTF-8");

        assertEquals(msg, msgRecuperada);
    }

    @Test
    public void situacoesExcepcionais() {
        Compressao c = new Compressao() {
            @Override
            public byte[] descomprime(byte[] entrada) throws IOException {
                throw new IOException("possivel");
            }

            @Override
            public byte[] comprime(byte[] entrada) throws IOException {
                throw new IOException("possivel");
            }
        };

        Seguranca s = new Seguranca() {
            @Override
            public byte[] encrypt(byte[] bytes, char[] key) {
                return new byte[0];
            }

            @Override
            public byte[] decrypt(byte[] encrypted, char[] key) {
                return new byte[0];
            }
        };

        Pack p = new PackPadrao(c, s);
        byte[] dados = new byte[5];
        char[] senha = "ok".toCharArray();

        assertNull(p.lacra(dados, senha));
        assertNull(p.deslacra(dados, senha));
    }
}

