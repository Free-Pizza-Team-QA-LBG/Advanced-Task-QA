package com.ims.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MorseTranslatorTest {

    MorseTranslator morseTranslator;

    @Before
    public void setup() {

        morseTranslator = new MorseTranslator();

    }


    @Test
    public void morseTestStream() {

        assertTrue(
                morseTranslator.translate("... --- ...").equalsIgnoreCase(
                        "SOS"
                )
        );

        assertTrue(
                morseTranslator.translate(".--- .- ...- .- / .. ... / -.-. --- --- .-.. / --- -.-").equalsIgnoreCase(
                        "Java is cool ok"
                )
        );

    }


    @Test
    public void morseTestNoStream() {

        assertTrue(
                morseTranslator.noStreamTranslate("... --- ...").equalsIgnoreCase(
                        "SOS"
                )
        );

        assertTrue(
                morseTranslator.noStreamTranslate(".--- .- ...- .- / .. ... / -.-. --- --- .-.. / --- -.-").equalsIgnoreCase(
                        "Java is cool ok"
                )
        );

    }

}
