

/**
 *
 * @author Simonster
 */
public class UnitTests {
    //Assert.assertEquals(actual, expected);
    public static final String ANSI_CYAN  = "\u001B[36m"; //Used for output
    public static final String ANSI_RESET = "\u001B[00m"; //Used for output
    public static final String ANSI_RED   = "\u001B[31m"; //Use in test?
    public static final String ANSI_GREEN = "\u001B[32m"; //Use in test?

    public static void testPassed(){
        System.out.println(ANSI_GREEN+"Passed"+ANSI_RESET);
    }

    public static void testFailed(){
        System.out.println(ANSI_RED+"Failed"+ANSI_RESET);
    }




    public static void run(){

        Projekt_IHD_UnitTests testIHD = new Projekt_IHD_UnitTests();

        Projekt_OHD_UnitTests testOHD = new Projekt_OHD_UnitTests();


        testIHD.setUp();

        if (testIHD.test_initialized() == true){
            testPassed();
        }else{
            testFailed();
        }

        testIHD.tearDown();


        testIHD.setUp();

        if (testIHD.test_execute() == true){
            testPassed();
        }else{
            testFailed();
        }

        testIHD.tearDown();


        testIHD.setUp();

        if (testIHD.test_startSensor() == true){
            testPassed();
        }else{
            testFailed();
        }

        testIHD.tearDown();

        testIHD.setUp();

        if (testIHD.test_readSensor() == true){
            testPassed();
        }else{
            testFailed();
        }

        testIHD.tearDown();

//      testIHD.setUp();
//
//      if (testIHD.test_getOutput_with_default_zero() == true){
//      testPassed();
//      }else{
//      testFailed();
//      }
//
//      testIHD.tearDown();
//

//
//      testIHD.setUp();
//
//      if (testIHD.test_getInputFromSensor_by_calling_getOutput() == true){
//      testPassed();
//      }else{
//      testFailed();
//      }
//
//      testIHD.tearDown();

        testOHD.setUp();

        if (testOHD.test_output_independence_with_testMatrix() == true){
            testPassed();
        }else{
            testFailed();
        }

        testOHD.tearDown();

        testIHD.setUp();

        if (testIHD.test_input_boundaries() == true){
            testPassed();
        }else{
            testFailed();
        }

        testIHD.tearDown();

        System.out.println("Test session ended.");

    } // end of run




}
