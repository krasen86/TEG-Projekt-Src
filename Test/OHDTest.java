import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.security.KeyStore;

import static org.junit.jupiter.api.Assertions.*;

class OHDTest {

    OHD ohd = new OHD ();
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


    @Test
    void initializeTestTheValues() {

        ohd.initialize (iad , iad, iad);
        rear     = false;
        left     = false;
        right    = false;
        forwardL = false;
        forwardR = false;
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