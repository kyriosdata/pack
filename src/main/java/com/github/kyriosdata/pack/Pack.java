/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.pack;

/**
 * Serviços de compressão e criptografia de dados.
 */
public interface Pack {

    /**
     * Comprime e criptografa o vetor de bytes fornecido
     * usando os algoritmos padrão.
     *
     * @param data Dados a serem comprimidos e criptografados.
     *
     * @param chars
     * @return Vetor de bytes produzido a partir da entrada
     * fornecida.
     *
     * @see #dd(byte[], String)
     */
    byte[] lacra(byte[] data, char[] chars);

    /**
     * Descriptografa e descomprime o vetor de bytes fornecido
     * usando os algoritmos padrão. Os dados DEVEM estar
     * comprimidos e criptografados pelo método
     * {@link #cc(byte[], String)}.
     *
     * @param data Dados a serem descriptografados e descomprimidos.
     *
     * @param chars
     * @return Dados conforme fornecidos ao método
     * {@link #cc(byte[], String)} juntamente com a senha indicada
     * acima.
     *
     * @see #cc(byte[], String)
     */
    byte[] deslacra(byte[] data, char[] chars);
}
