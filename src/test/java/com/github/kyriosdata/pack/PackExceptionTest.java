package com.github.kyriosdata.pack;

import org.junit.jupiter.api.Test;

public class PackExceptionTest {

    @Test
    public void apenasCriaInstancia() {
        new PackException(new RuntimeException("a"));
    }
}

