import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IADTest {
    IHD mock_ihd1 = mock(IHD.class);
    IHD mock_ihd2 = mock(IHD.class);
    IAD iad = new IAD();


    @Test
    void AnalysesIAD2BothForwardLeftAndLeft29() throws Exception {
        doReturn(29).when(mock_ihd1).getOutput();
        doReturn(29).when(mock_ihd2).getOutput();
        boolean[] expect = {false, false};
        iad.initialize(mock_ihd1, mock_ihd2);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }
    @Test
    void AnalysesIAD2ForwardLeft31andLeft29 () {
        doReturn(31).when(mock_ihd1).getOutput();
        doReturn(29).when(mock_ihd2).getOutput();
        boolean[] expect = {true, false};
        iad.initialize(mock_ihd1, mock_ihd2);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }

    @Test
    void AnalysesIAD2ForwardLeft29andLeft31 () {
        doReturn(29).when(mock_ihd1).getOutput();
        doReturn(31).when(mock_ihd2).getOutput();
        boolean[] expect = {false, true};
        iad.initialize(mock_ihd1, mock_ihd2);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }

    @Test
    void AnalysesIAD2BothForwardLeftAndLeft31 () {
        doReturn(31).when(mock_ihd1).getOutput();
        doReturn(31).when(mock_ihd2).getOutput();
        boolean[] expect = {true, true};
        iad.initialize(mock_ihd1, mock_ihd2);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }

    @Test
    void AnalysesIAD3BothForwardRightAndRight29 () {
        doReturn(29).when(mock_ihd1).getOutput();
        doReturn(29).when(mock_ihd2).getOutput();
        boolean[] expect = {false, false};
        iad.initialize(mock_ihd1, mock_ihd2);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }

    @Test
    void AnalysesIAD3ForwardRight31AndRight29 () {
        doReturn(31).when(mock_ihd1).getOutput();
        doReturn(29).when(mock_ihd2).getOutput();
        boolean[] expect = {true, false};
        iad.initialize(mock_ihd1, mock_ihd2);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }

    @Test
    void AnalysesIAD3ForwardRight29AndRight31 () {
        doReturn(29).when(mock_ihd1).getOutput();
        doReturn(31).when(mock_ihd2).getOutput();
        boolean[] expect = {false, true};
        iad.initialize(mock_ihd1, mock_ihd2);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }
    @Test
    void AnalysesIAD3BothForwardRightAndRight31 () {
        doReturn(31).when(mock_ihd1).getOutput();
        doReturn(31).when(mock_ihd2).getOutput();
        boolean[] expect = {true, true};
        iad.initialize(mock_ihd1, mock_ihd2);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }
    @Test
    void AnalysesIAD1Input4 () {
        doReturn(4).when(mock_ihd1).getOutput();
        boolean[] expect = {false, false};
        iad.initialize(mock_ihd1);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }
    @Test
    void AnalysesIAD1Input5 () {
        doReturn(5).when(mock_ihd1).getOutput();
        boolean[] expect = {false, false};
        iad.initialize(mock_ihd1);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }
    @Test
    void AnalysesIAD1Input6 () {
        doReturn(6).when(mock_ihd1).getOutput();
        boolean[] expect = {true, true};
        iad.initialize(mock_ihd1);
        iad.execute();
        assertArrayEquals(expect, iad.getData());
    }
//
}