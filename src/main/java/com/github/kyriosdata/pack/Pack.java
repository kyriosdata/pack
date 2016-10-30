/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.pack;

/**
 * Serviços de compressão e criptografia de dados.
 *
 * <p>Observe que o uso do método {@link #deslacra(byte[], char[])}
 * deve ser realizado sobre dados que foram lacrados com o método
 * {@link #lacra(byte[], char[])}.
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
     * @see #deslacra(byte[], char[])
     */
    byte[] lacra(byte[] data, char[] chars);

    /**
     * Descriptografa e descomprime o vetor de bytes fornecido
     * usando os algoritmos padrão. Os dados DEVEM estar
     * comprimidos e criptografados pelo método
     * {@link #lacra(byte[], char[])}.
     *
     * @param data Dados a serem descriptografados e descomprimidos.
     *
     * @param chars
     * @return Dados conforme fornecidos ao método
     * {@link #lacra(byte[], char[])} juntamente com a senha indicada
     * acima.
     *
     * @see #lacra(byte[], char[])
     */
    byte[] deslacra(byte[] data, char[] chars);
}
