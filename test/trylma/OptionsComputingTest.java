package trylma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsComputingTest {

    // (J) Here is example test for ya :3

    

    @Test
    void defaultValueCPU(){
        OptionsComputing test = new OptionsComputing();
        int result = test.getNumberOfCPU();
        assertEquals(0, result);
    }
    
}