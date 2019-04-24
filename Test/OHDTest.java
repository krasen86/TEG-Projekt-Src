import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.security.KeyStore;

import static org.junit.jupiter.api.Assertions.*;

class OHDTest {

    OHD ohd;
    boolean[] array1 = new boolean[1];
    boolean[] array2 = new boolean[2];
    boolean[] array3 = new boolean[2];
    boolean[] arrayOutput = new boolean[5];
    IAD iad;
    boolean rear;
    boolean left;
    boolean right;
    boolean forwardL;
    boolean forwardR;

    //@BeforeEach
    void initializeWithAllFalseArrayDataTest(){
        rear     = false;
        left     = false;
        right    = false;
        forwardL = false;
        forwardR = false;
        ohd = new OHD();
    }


    @Test
    void arrayOutputValidator() {
        initializeWithAllFalseArrayDataTest();
        ohd.initialize (iad , iad, iad);

        arrayOutput[0] = rear;
        arrayOutput[1] = left;
        arrayOutput[2] = forwardL;
        arrayOutput[3] = right;
        arrayOutput[4] = forwardR;
        assertArrayEquals (arrayOutput,ohd.getOutput ());

    }

    @Test
    void execute () {
    }

    @Test
    void getData () {
    }

}