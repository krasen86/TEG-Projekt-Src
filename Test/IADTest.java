import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;


class IADTest {
    IHD ihd1 = new IHD ();
    IHD ihd2 = new IHD ();
    IAD iad = new IAD (ihd1,ihd2,5,10,true,false,30);

    Sensor sensor= new Sensor ();


    @Test
    void initialize_testingInitializeMethod_expectFalse () {
iad.initialize(ihd1,ihd2);
IAD iad2 = new IAD(ihd1,ihd2,0,0,false,false,30);

        assertEquals(iad2,iad);
    }


    @Test
    void execute_testingLotsOfBoundaryValues () {

// initiate two ihd to be able to initialize one iad
        ihd2.initialize(sensor);
        ihd1.initialize(sensor);
        iad.initialize(ihd1, ihd2);


// here i create array with data that i send in to test
        int testData[] = {0, -23, 45, 290, 50, -123, 200, 199, 201, -200, 5, 1, -1, 29};

        // in this test the output is two booleans, the output might change for each loop, so i must create an array of arrays that i
        // store the expected results in. so here for example when value zero which is the first value in the testData array is sent
        // to the for loop, once it passed the system and analyze has given it two booleans,
        // it will be compared to the test0 array in the array of arrays called expectedResults.
        boolean test0[] = {false, false};
        boolean test1[] = {false, false};
        boolean test2[] = {true, true};
        boolean test3[] = {true, true};
        boolean test4[] = {true, true};
        boolean test5[] = {false, false};
        boolean test6[] = {true, true};
        boolean test7[] = {true, true};
        boolean test8[] = {true, true};
        boolean test9[] = {false, false};
        boolean test10[] = {false, false};
        boolean test11[] = {false, false};
        boolean test12[] = {false, false};
        boolean test13[] = {true, true};


        boolean[] expectedResult[] = {test0,test1, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11, test12, test13};





        // after initialize inputs are set to zero, here inputs is changed with array content at index t
        for (int t = 0; t < testData.length; t++) {
            sensor.safetyOutput = testData[t];
            sensor.originalOutput = testData[t];

            // then i must run both ihd so that the safety and original output is transferred to read1 and read2 which is used in
            // iad execute that does the analyze
            ihd1.execute();
            ihd2.execute();

            // then i run the execute which analyze the data
            iad.execute();



            // then i take the result and store it in an array.
            boolean[] booleansProducedByAnalyzeMethod = iad.getData();
// here i store the expectedResultvalue on position t in the testet array
                boolean testet[] = expectedResult[t];
// and last but not the least i compare both arrays and print out result.

                if (Arrays.equals(testet, booleansProducedByAnalyzeMethod))
                    System.out.println("Pass boundaryvaluestest"+ t);
                else
                    System.out.println("Fail boundaryvaluestest"+ t);


            }
        }

    @Test
    void analyzeData () {
    }

    @Test
    void sendData () {
    }

        }

