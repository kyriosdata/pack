package com.github.kyriosdata.pack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PackTest {

    private Pack pack = PackFactory.newInstance();

    @Test
    public void vetorNemSenhaPodeSerNull() {
        Class<IllegalArgumentException> iae = IllegalArgumentException.class;

        assertThrows(iae, () -> pack.cc(new byte[0], null));
        assertThrows(iae, () -> pack.cc(null, "ok"));
    }

    @Test
    public void vaiVolta() {
        byte[] dados = new byte[] { 1 };
        String senha = "ok";

        byte[] protegido = pack.cc(dados, senha);
        byte[] obtido = pack.dd(protegido, senha);

        assertArrayEquals(dados, obtido);
    }
}

