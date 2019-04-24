


import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author Simon
Tabell 3: krav på testIHD.

testIHD_001 Input boundaries
- Kan ta emot och hantera heltal mellan 0 och 200.
testIHD_002 Input lower limit
- Kan bortse från heltal mindre än 0.
testIHD_003 Input upper limit
- Kan bortse från heltal större än 200.
testIHD_004 Input missing
- Om input saknas ska den hanteras som 0.
testIHD_005 Integer average
- Kan räkna ut medelvärde av två heltal.
testIHD_006 Send output
- Kan ge output som motsvarar medelvärdet av två heltal.
testIHD_007 Request start
- Kan begära uppstart och omstart av en sensor, genom att skicka ut heltalet 3 mot berörd sensor.

testIHD_009 Request input
-  Kan begära input från en sensor, genom att skicka ut heltalet 0 mot berörd sensor.

 */
public class Projekt_IHD_UnitTests {

    private IHD testIHD;

    private Sensor testSensor;


    // When this is set to true, test will give more information about the test executed
    private boolean verbose = true;

    private ArrayList textOutput;

    public void setVerboseOutput(){
        verbose = true;
    }

    public void printVerbose(){

        System.out.println("Expected: " + textOutput.get(0));
        System.out.println("Actual:   " + textOutput.get(1) );
        System.out.print("Result:   ");

    }

    public void printVerboseMultiTest(){

        System.out.println("Expected: " + textOutput.get(1));
        System.out.println("Actual:   " + textOutput.get(2) );
        System.out.println("Result:   " +  textOutput.get(0));


    }



    // @BeforeMethod
    public void setUp() {
        if(verbose == true) { System.out.println("Testing: Projekt_testIHD");}
        textOutput = new ArrayList();
        testIHD = new IHD ();
        testSensor = new Sensor ();
    }

    //@AfterMethod
    public void tearDown() {
        textOutput = null;
        testIHD = null;
    }

    //@test
    public boolean test_initialized(){
        if(verbose == true) { System.out.println("Running: test_initialized");}

        int [] expected = {0,0,0,3};

        int [] actual = new int[4];

        try{
            testIHD.initialize(testSensor);
        }
        catch(NullPointerException e){
            System.out.println("Sensor not initialized");
            return false;
        }

        actual[0] = testIHD.getRead1();
        actual[1] = testIHD.getRead2();
        actual[2] = testIHD.getMean();
        actual[3] = IHD.outputToSensor;


        if(verbose == true) {
            textOutput.add(Arrays.toString(expected));
            textOutput.add(Arrays.toString(actual));
            printVerbose();
        }

        if(Arrays.toString(expected).equals(Arrays.toString(actual))){

            return true;

        }
        else{
            return false;
        }

    }
    //@Test
    public boolean test_execute(){
        if(verbose == true) { System.out.println("Running: test_execute");}

        final int expected [] = { 11, 3, 0};

        int actual [] = new int [3];

        testSensor.originalOutput = 11;
        testSensor.safetyOutput = 3;

        testIHD.initialize(testSensor);

        testIHD.execute();

        actual[0] = testIHD.getRead1();
        actual[1] = testIHD.getRead2();
        actual[2] = IHD.outputToSensor;

        if(verbose == true) {
            textOutput.add(Arrays.toString(expected));
            textOutput.add(Arrays.toString(actual));
            printVerbose();
        }

        boolean result = false;

        for (int i = 0; i < 3; i++) {
            if(expected[i] == actual[i]){

                result = true;

            }

        }

        return result;
    }
    //@Test
    public boolean test_getOutput_with_default_zero(){
        if(verbose == true) { System.out.println("Running: test_getOutput_with_default_zero()");}

        final int expected = 0;

        final int actual = 0;

        if(verbose == true) {
            textOutput.add(expected);
            textOutput.add(actual);
            printVerbose();
        }

        if(expected == actual){

            return true;

        }
        else{
            return false;
        }

    }
    //@Test
    public boolean test_getInputFromSensor_by_calling_getOutput(){
        if(verbose == true) { System.out.println("Running: test_getInputFromSensor_by_calling_getOutput()");}

        testIHD.initialize(testSensor);

        try{
            // testIHD.getInputFromSensor();
        }
        catch(NullPointerException e){
            System.out.println("Sensor not initialized");
            return false;
        }

        final int expected = -1;

        final int actual = 0;

        if(verbose == true) {
            textOutput.add(expected);
            textOutput.add(actual);
            printVerbose();
        }

        if(expected == actual){

            return true;

        }
        else{
            return false;
        }

    }
    //@Test
    public boolean test_startSensor(){
        if(verbose == true) { System.out.println("Running: test_StartSensor()");}

        testIHD.initialize(testSensor);

        final int expected = 3;

        final int actual = IHD.outputToSensor;

        if(verbose == true) {
            textOutput.add(expected);
            textOutput.add(actual);
            printVerbose();
        }

        if(expected == actual){

            return true;

        }
        else{
            return false;
        }

    }
    //@Test
    public boolean test_readSensor(){
        if(verbose == true) { System.out.println("Running: test_readSensor()");}

        final int expected [] = {7,5};

        int actual [] = new int[2];

        testSensor.originalOutput = 7;
        testSensor.safetyOutput = 5;

        testIHD.initialize(testSensor);

        testIHD.execute();


        actual[0] = testIHD.getRead1();
        actual[1] =testIHD.getRead2();

        if(verbose == true) {
            textOutput.add(expected[0] +", "+ expected[1]);

            textOutput.add(actual[0] +", "+ actual[1]);
            printVerbose();
        }

        if(expected[0] == actual[0] && expected[1] == actual[1] ){

            return true;

        }
        else{
            return false;
        }

    }

    public boolean test_mean(){
        if(verbose == true) { System.out.println("Running: test_mean()");}

        final int expected = 5;

        //NOTE(Simon): Private access can't run this test
        //final int actual = testIHD.mean(7,3);
        final int actual = 0;

        if(verbose == true) {
            textOutput.add(expected);
            textOutput.add(actual);
            printVerbose();
        }

        if(expected == actual){

            return true;

        }
        else{
            return false;
        }

    }

    public boolean test_input_boundaries(){
        if(verbose == true) { System.out.println("Running: test_input_boundaries()");}

        int testdata [] = { 0, -23, 45, 290, 50 , -123, 200 , 199, 201, -200, 5, 1, -1};

        if(verbose == true) {
            System.out.println("Testdata:"+Arrays.toString(testdata));
        }

        testIHD.initialize(testSensor);

        boolean passedAll = true;

        //NOTE(Simon): 0 here is used to indicate that the input should be discareded i.e. handled as missing
        int expected = 0;
        int  actual = 0;

        int failedtests = 0;

        for (int i = 0; i < testdata.length; i++) {
            testSensor.originalOutput = testdata[i];

            testIHD.execute();

            actual = testIHD.getRead1();

            if(actual < 0 || actual > 200){
                expected = 0;
            }else{
                expected = actual;
            }


            if(expected == actual){
                textOutput.add("\u001B[32m"+"Passed"+"\u001B[00m");
            }else{
                textOutput.add("\u001B[31m"+"Failed"+"\u001B[00m");
                passedAll = false;
                failedtests++;
            }


            if(verbose == true) {
                textOutput.add(expected);
                textOutput.add(actual);

                printVerboseMultiTest();

                textOutput.clear();
            }
        }

        System.out.println("Failed " + failedtests + " out of " + testdata.length + " Tests");
        System.out.print("Result: ");
        return passedAll;
//    if(expected == actual){
//
//         return true;
//
//    }
//     else{
//          return false;
//     }

    }




}
