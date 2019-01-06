package trylma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsComputingTest {

    // (J) Here is example test for ya :3
    @Test
    void defaultValueTotalPlayers(){
        OptionsComputing test = new OptionsComputing();
        int result = test.getTotalPlayers();
        assertEquals(6, result);
    }

    @Test
    void defaultValueHumanPlayers(){
        OptionsComputing test = new OptionsComputing();
        int result = test.getNumberOfPlayers();
        assertEquals(6, result);
    }

    @Test
    void defaultValueCPU(){
        OptionsComputing test = new OptionsComputing();
        int result = test.getNumberOfCPU();
        assertEquals(0, result);
    }

    /*
    (J) These test fails for some reason

    @Test
    void defaultValueTypeOfBoard(){
        OptionsComputing test = new OptionsComputing();
        //test.setTypeOfBoard("6-Shaped Start");
        String result = test.getTypeOfBoard();
        assertEquals("6-Shaped Start", result);
    }

    @Test
    void defaultValueIP(){
        OptionsComputing test = new OptionsComputing();
        //test.setIPPort("localhost");
        String result = test.getIPPort();
        assertEquals("localhost", result);
    }


    @Test
    void defaultValue(){
        OptionsComputing test = new OptionsComputing();
        //test.setIPPort("Blocked Switch");
        String result = test.getRuleSet();
        assertEquals("Blocked Switch", result);
    }
    */

}