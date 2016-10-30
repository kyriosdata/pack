/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.pack;

/**
 * Cria uma instância de {@link Pack}.
 */
public final class PackFactory {

    private PackFactory() {
        // Evita criação desnecessária de instância.
    }

    /**
     * Obtém instância padrão para compressão e
     * criptografia de dados.
     *
     * @return Instância de {@link Pack} que faz uso
     * de algoritmos padrão.
     */
    public static Pack newInstance() {
        Compressao c = new CompressaoZip();
        Seguranca s = new SegurancaAes();
        return new PackPadrao(c, s);
    }
}
