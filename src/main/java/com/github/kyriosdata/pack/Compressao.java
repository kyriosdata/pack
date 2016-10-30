/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.pack;

import java.io.IOException;

public interface Compressao {

    byte[] descomprime(byte[] entrada) throws IOException;

    byte[] comprime(byte[] entrada) throws IOException;

}
