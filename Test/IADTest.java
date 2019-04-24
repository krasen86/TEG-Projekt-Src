import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class IADTest {

    IAD iad = new IAD ();
    IHD ihd1 = new IHD ();
    IHD ihd2 = new IHD ();
    Sensor sensor= new Sensor ();

    @Test
    void initialize () {



    }

    @Test
    void execute_testingInputBelowZeroWithTwoIHD_expectFalse () {
        // initiate two ihd to be able to initialize one iad
        ihd2.initialize(sensor);
        ihd1.initialize(sensor);
        iad.initialize(ihd1,ihd2);

        // after initialize inputs are set to zero, here i change input to whatever we want to test,
        // for first test its -1
        sensor.safetyOutput= -1;
        sensor.originalOutput= -1;

        // then i must run both ihd so that the safety and original output is transferred to read1 and read2 which is used in
        // iad execute that does the analyze
        ihd1.execute();
        ihd2.execute();

        // then i run the execute which analyze the data
        iad.execute();

        // then i take the result and store it in an array.
         boolean[] checkIfMinusReturnsFalse = iad.getData();

        //then i create an array here locally that i store two false values in
         boolean one = false;
         boolean two = false;
         boolean[] twoFalseBooleansInArray = new boolean[2];
             twoFalseBooleansInArray[0]= one;
             twoFalseBooleansInArray[1]= two;


// and then i check that the booleans from iad getdata function returns two false values as it should by comparing it to the
// two false values i created locally.
        assertArrayEquals(twoFalseBooleansInArray,checkIfMinusReturnsFalse);
    }


    @Test
    void analyzeData () {
    }

    @Test
    void sendData () {
    }
}