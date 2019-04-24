


//Tabell 5: krav på testOHD.
//
//testOHD_001 Input independence
// - Kan ta emot fem booleaner som kan vara true eller  false oberoende av varandra.
//testOHD_002 Output independence
// - Ger som output en Array innehållande fem booleaner som kan vara true eller false oberoende av varandra


// False, False
// True, True
// False , True
// True, False



import java.util.ArrayList;
import java.util.Arrays;



/**
 *
 * @author Simonster
 */
public class Projekt_OHD_UnitTests {

    private OHD testOHD;

    private IAD testIAD = new IAD ();


    // When this is set to true, test will give more information about the test executed
    private boolean verbose = true;

    private ArrayList textOutput;

    boolean [][][] createTestMatrix(){

        int input[][][] = new int [5][5][5];

        boolean boolinput[][][] = new boolean [5][5][5];

        int pop0 [][] =
                {
                        {1,0,0,0,0},
                        {0,1,0,0,0},
                        {0,0,1,0,0},
                        {0,0,0,1,0},
                        {0,0,0,0,1},
                };

        int pop1 [][] =
                {
                        {1,1,0,0,0},
                        {0,1,1,0,0},
                        {0,0,1,1,0},
                        {0,0,0,1,1},
                        {1,0,0,0,1},
                };
        int pop2 [][] =
                {
                        {1,1,1,0,0},
                        {0,1,1,1,0},
                        {0,0,1,1,1},
                        {1,0,0,1,1},
                        {1,1,0,0,1},
                };

        int pop3 [][] =
                {
                        {1,1,1,1,0},
                        {0,1,1,1,1},
                        {1,0,1,1,1},
                        {1,1,0,1,1},
                        {0,1,1,1,1},
                };

        int pop4 [][] =
                {
                        {1,1,1,1,1},
                        {0,0,0,0,0},

                        {0,0,0,0,0},
                        {0,0,0,0,0},
                        {0,0,0,0,0},
                };

        input[0] = pop0;
        input[1] = pop1;
        input[2] = pop2;
        input[3] = pop3;
        input[4] = pop4;

//                for (int matrix = 0; matrix < 5; matrix++) {
//                   System.out.println("-----------------------");
//
//                for (int row = 0; row < 5; row++) {
//                for (int col = 0; col < 5; col++) {
//
//                         System.out.print(input[matrix][row][col] + " ");
//                        }
//                     System.out.println();
//                    }

//                }


        for (int matrix = 0; matrix < 5; matrix++) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {

                    if(input[matrix][row][col] == 1){
                        boolinput[matrix][row][col] = true;
                    }else{
                        boolinput[matrix][row][col] = false;
                    }

                }
            }
        }

        return boolinput;
    }





    public void setVerboseOutput(){
        verbose = true;
    }

    public void printVerbose(){

        System.out.println("Expected: " + textOutput.get(0));
        System.out.println("Actual:   " + textOutput.get(1) );
        System.out.print("Result:   ");

    }

    // @BeforeMethod
    public void setUp() {
        if(verbose == true) { System.out.println("Testing: Projekt_testOHD");}
        textOutput = new ArrayList();
        testOHD = new OHD ();
    }

    //@test
    public boolean test_initialized(){

        if(verbose == true) { System.out.println("Running: test_initialized");}

        boolean init = false;

        testOHD.initialize(testIAD,testIAD,testIAD);

        final boolean expected = true;

        final boolean actual = init;

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
    public boolean test_execute(){

        if(verbose == true) { System.out.println("Running: test_execute");}

        testOHD.initialize(testIAD,testIAD,testIAD);

        boolean init = false;

        final boolean expected = true;

        final boolean actual = init;

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
    public boolean test_output_default_as_FFFFF(){

        if(verbose == true) { System.out.println("Running: test_output_default_as_FFFFF");}


        final boolean expected [] = {false, false, false , false ,false};

        final boolean actual [] = testOHD.dataIAD1;

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

    public boolean test_output_independence_with_testMatrix(){
        if(verbose == true) { System.out.println("Running: test_output_independence");}


        final boolean expected  = true;

        boolean actual = false;

        boolean test [];


        boolean input [][][] = createTestMatrix();
        int n = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                test = input[i][j];

                // System.out.println(Arrays.toString(test));

                actual = (test[0] == true || test[1] == false || test[2] == false || test[3] == false || test[4] == false);


                if(actual == true){
                    n++;
                }

            }
        }

        // System.out.println("Actual: true, " + n + " times");


        if(verbose == true) {

            textOutput.add(expected);
            textOutput.add(actual);

            // textOutput.add(Arrays.toString(expected));
            //  textOutput.add(Arrays.toString(actual));
            printVerbose();
        }

        if(expected == actual){

            return true;

        }
        else{
            return false;
        }

    }




    //@AfterMethod
    public void tearDown() {
        textOutput = null;
        testOHD = null;
    }



}

