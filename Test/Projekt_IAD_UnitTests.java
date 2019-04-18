//Tabell 4: krav på IAD.
//
//IAD_001 Input boundaries
// - Kan ta emot två heltal mellan 0 och 200.
//IAD_002 Input lower limit
// - Input mindre än 0 hanteras som 0.
//IAD_003 Input upper limit
// - Input större än 200 hanteras som 200.
//IAD_004 Output independence
// - Kan skicka ut två booleaner som kan vara true eller false oberoende av varandra.
//
//IAD_005 Analyses IAD_1
// - Kan göra bedömning baserat på storlek av mottaget heltal. Om heltalet är större än 5, är färdriktning
//   rear godkänd (boolean sätts till true), annars icke godkänd.
//
//IAD_006 Analyses IAD_2
// - Kan göra bedömning baserat på storlek av mottagna heltal. Färdriktningarna forwardL och left är
//   godkända om respektive mottaget heltal är större än 30, annars är de icke godkända.
//
//IAD_007 Analyses IAD_3
// - Kan göra bedömning baserat på storlek av mottagna heltal. Färdriktningarna forwardR och right är
//   godkända om respektive mottaget heltal är större än 30, annars är de icke godkända.



import java.util.ArrayList;


/**
 *
 *
 *
 * @author Simonster
 */
public class Projekt_IAD_UnitTests {

    private IAD tIAD;



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

    // @BeforeMethod
    public void setUp() {
        textOutput = new ArrayList();
        tIAD = new IAD();
    }

    //@Test
    public boolean test_func1(){
        if(verbose == true) { System.out.println("Running: test_StartSensor()");}

        final boolean expected = true;

        final boolean actual = false;

        if(verbose == true) {
            textOutput.add(expected);
            textOutput.add(actual);
            printVerbose();
        }

        if(expected == actual){ return true; }
        else{ return false; }
    }

    //@AfterMethod
    public void tearDown() {
        textOutput = null;
        tIAD = null;
    }



}
