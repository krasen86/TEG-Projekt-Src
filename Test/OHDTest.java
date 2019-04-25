import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OHDTest {

    OHD ohd;

    boolean[] array1 = new boolean[1];
    boolean[] array2 = new boolean[2];
    boolean[] array3 = new boolean[2];
    boolean[] arrayExpectedOutput = new boolean[5];
    IAD iad = new IAD ();
    boolean[] output = new boolean[5];
    boolean rear;
    boolean left;
    boolean right;
    boolean forwardL;
    boolean forwardR;


    void initializeWithAllFalseArrayDataTest () {
        rear = false;
        left = false;
        right = false;
        forwardL = false;
        forwardR = false;
        arrayExpectedOutput = new boolean[]{false, false, false, false, false};
        ohd = new OHD ();
        array1[0] = rear;
        array2[0] = left;
        array2[1] = forwardL;
        array3[0] = right;
        array3[1] = forwardR;

    }

    void initializeWithAllTrueArrayDataTest () {
        rear = true;
        left = true;
        right = true;
        forwardL = true;
        forwardR = true;
        arrayExpectedOutput = new boolean[]{true, true, true, true, true};
        ohd = new OHD ();
        array1[0] = rear;
        array2[0] = left;
        array2[1] = forwardL;
        array3[0] = right;
        array3[1] = forwardR;
    }
    void initializeWithNormalArrayDataTest () {
        rear = false;
        left = false;
        right = false;
        forwardL = true;
        forwardR = false;
        arrayExpectedOutput = new boolean[]{false, false, true, false, false};
        ohd = new OHD ();
        array1[0] = rear;
        array2[0] = left;
        array2[1] = forwardL;
        array3[0] = right;
        array3[1] = forwardR;
    }

    @Test
    void arrayOutputValidator () {

        initializeWithAllFalseArrayDataTest ();
        ohd.initialize (iad, iad, iad);
        ohd.execute ();
        output = initializeArrayExpectedOutput(ohd.getOutput ());
        System.out.println ("Testing with All False array values.");
        assertArrayEquals (arrayExpectedOutput, output);
        System.out.println ("Test passed.");

        initializeWithAllTrueArrayDataTest ();
        ohd.initialize (iad, iad, iad);
        ohd.execute ();
        output = initializeArrayExpectedOutput (ohd.getOutput ());
        System.out.println ("Testing with All True array values.");
        assertArrayEquals (arrayExpectedOutput, output );
        System.out.println ("Test passed.");

        initializeWithNormalArrayDataTest ();
        ohd.initialize (iad, iad, iad);
        ohd.execute ();
        output = initializeArrayExpectedOutput (ohd.getOutput ());
        System.out.println ("Testing with All Normal array values.");
        assertArrayEquals (arrayExpectedOutput, output );
        System.out.println ("Test passed.");


    }



    private boolean[] initializeArrayExpectedOutput (boolean[] output) {

        rear     = array1[0];
        left     = array2[0];
        forwardL = array2[1];
        right    = array3[0];
        forwardR = array3[1];
        output[0] = rear;
        output[1] = left;
        output[2] = forwardL;
        output[3] = right;
        output[4] = forwardR;
        return output;
    }


}
