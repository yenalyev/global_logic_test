import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TextFileReaderTest {

    @Test
    void testCountFromFile(){
        double actual = TextFileReader.countFromFile("src/main/resources/testData.txt");
        Assertions.assertEquals(268.83, actual);
    }

    //---------------------------------------------------------------

    @Test
    void convertStringIntoDouble() {
        TextFileReader textFileReader = new TextFileReader();
        double actual = textFileReader.convertStringIntoDouble("12");
        Assertions.assertEquals(12.0, actual);
    }

    @Test
    void convertStringIntoDoubleSharp() {
        TextFileReader textFileReader = new TextFileReader();
        double actual = textFileReader.convertStringIntoDouble("#12");
        Assertions.assertEquals(0.0, actual);
    }

    @Test
    void convertStringIntoDoublePlus() {
        TextFileReader textFileReader = new TextFileReader();
        double actual = textFileReader.convertStringIntoDouble("+12");
        Assertions.assertEquals(12.0, actual);
    }

    @Test
    void convertStringIntoDoubleMinus() {
        TextFileReader textFileReader = new TextFileReader();
        double actual = textFileReader.convertStringIntoDouble("-12");
        Assertions.assertEquals(-12.0, actual);
    }

    @Test
    void convertStringIntoDoubleZero() {
        TextFileReader textFileReader = new TextFileReader();
        double actual = textFileReader.convertStringIntoDouble("0000");
        Assertions.assertEquals(0.0, actual);
    }

    @Test
    void convertStringIntoDoubleString() {
        TextFileReader textFileReader = new TextFileReader();
        double actual = textFileReader.convertStringIntoDouble("asq");
        Assertions.assertEquals(0.0, actual);
    }

}