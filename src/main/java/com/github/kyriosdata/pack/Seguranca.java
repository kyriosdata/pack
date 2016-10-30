package com.github.kyriosdata.pack;

/**
 * Serviço de segurança (sigilo).
 */
public interface Seguranca {

    /**
     * Criptografa o vetor de bytes usando a chave.
     *
     * @param bytes Vetor de bytes a ser criptografado.
     * @param key Chave a ser empregada.
     *
     * @return Vetor de bytes criptografados com a chave.
     */
    byte[] encrypt(byte[] bytes, char[] key);

    /**
     * Descriptografa o vetor de bytes com a chave.
     *
     * @param encrypted Dados criptografados a serem
     *                  descriptografados.
     * @param key Chave a ser utilizada para descriptografar
     *            os dados.
     *
     * @return Dados descriptografados.
     */
    byte[] decrypt(byte[] encrypted, char[] key);
}
