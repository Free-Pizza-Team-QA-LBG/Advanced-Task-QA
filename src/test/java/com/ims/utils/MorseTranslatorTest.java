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

        System.out.println("==================");
        System.out.println("morseTestStream");
        System.out.println(morseTranslator.translate("... --- ..."));
        assertTrue(
                morseTranslator.translate("... --- ...").equalsIgnoreCase(
                        "sos"
                )
        );



    }

    @Test
    public void morseTestStreamInefficient() throws Exception {


        assertTrue(
                morseTranslator.jankyTranslate("... --- ...").equalsIgnoreCase(
                        "sos"
                )
        );

        assertTrue(
                morseTranslator.translateBackwardsInnefficient("hello").equals(
                        ".... . .-.. .-.. ---"
                )
        );

    }




    @Test
    public void morseTestReverse() {

        System.out.println(morseTranslator.translate("sos"));
        assertTrue(
                morseTranslator.translate("sos").equalsIgnoreCase(
                        "... --- ..."
                )
        );

        assertTrue(
                morseTranslator.translate("java is cool ok").equalsIgnoreCase(
                        ".--- .- ...- .- / .. ... / -.-. --- --- .-.. / --- -.-"
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



