/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.pack;

import java.io.IOException;

/**
 * Serviços de compressão e descompressão de dados.
 */
public interface Compressao {

    /**
     * Comprime entrada.
     *
     * @param entrada Vetor de bytes a ser comprimido.
     * @return Sequência de bytes comprimida.
     *
     * @throws IOException Várias situações podem
     * causar essa exceção.
     */
    byte[] descomprime(byte[] entrada) throws IOException;

    /**
     * Descomprime a entrada fornecida.
     *
     * @param entrada Vetor de bytes a ser descomprimida.
     *
     * @return Sequência de bytes não comprimida.
     *
     * @throws IOException Várias situações podem causar
     * essa exceção.
     */
    byte[] comprime(byte[] entrada) throws IOException;

}
