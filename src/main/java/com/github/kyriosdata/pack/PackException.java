/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.pack;

/**
 * Indica situação excepcional com operação da
 * biblioteca pack.
 */
public class PackException extends RuntimeException {

    /**
     * Sinaliza situação excepcional com Pack.
     *
     * @param e Exceção original.
     */
    public PackException(Exception e) {
        super(e);
    }
}
