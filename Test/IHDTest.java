import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class IHDTest {
    Sensor sensor_test=new Sensor();
    IHD ihd=new IHD();
    
    @Test
    void executeLisenToSensor () {
        ihd.execute();
        assertEquals(0,ihd.outputToSensor);
    }

    @Test
    void initializSensor() {
        ihd.initialize(sensor_test);
        assertEquals(3,ihd.outputToSensor);
    }

    @Test
    void getOriginalOutput() {
        sensor_test.originalOutput=135;
        assertEquals(135, ihd.getRead1());
    }

    @Test
    void getSaftyOutput() {
        sensor_test.originalOutput=45;
        assertEquals(45, ihd.getRead2());
    }

    @Test
    void MeanIntergerSumEven() {
        sensor_test.originalOutput= 149;
        sensor_test.safetyOutput=59;
        assertEquals(103,ihd.getMean());
    }
    @Test
    void MeanIntergerSumOdd() {
        sensor_test.originalOutput= 149;
        sensor_test.safetyOutput=59;
        assertEquals(103,ihd.getMean());
    }
    @Test
    void MeanIntergerBoundaryBothOutputZero() {
        sensor_test.originalOutput= 0;
        sensor_test.safetyOutput=0;
        assertEquals(0,ihd.getMean());
        }

    @Test
    void MeanIntergerBoundaryBothOutput200() {
        sensor_test.originalOutput= 200;
        sensor_test.safetyOutput=200;
        assertEquals(200,ihd.getMean());
    }

    @Test
    void MeanIntergerBoundaryOneOutput200() {
        sensor_test.originalOutput= 200;
        sensor_test.safetyOutput=135;
        assertEquals(167,ihd.getMean());
    }
    @Test
    void MeanIntergerBoundaryOneOutputZero() {
        sensor_test.originalOutput= 0;
        sensor_test.safetyOutput=135;
        assertEquals(67,ihd.getMean());
    }
}
