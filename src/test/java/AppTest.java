import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zihaocastine on 6/9/16.
 */
public class AppTest {
    App app=new App();

    @Test
    public void testConvertNumberToWord(){

        String expected="OneThousandTwoHundredThirtyFourDollars";
        String actual=app.convertNumberToWord("1234");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testWithTwoThousandTwoHundredDollars(){
        String expected="TwoThousandTwoHundredDollars";
        String actual=app.convertNumberToWord("2200");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testWithOneHundredFiftyThousandDollars(){
        String expected="OneHundredFiftyThousandDollars";
        String actual=app.convertNumberToWord("150000");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testWithOneHundredThousandDollars(){
        String expected="OneHundredThousandDollars";
        String actual=app.convertNumberToWord("100000");
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void testWithOneMillionDollars(){
        String expected="OneMillionDollars";
        String actual=app.convertNumberToWord("1000000");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testWithFiftyMillionDollars(){
        String expected="FiftyMillionDollars";
        String actual=app.convertNumberToWord("50000000");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testWithOneHundredFiftyMillionDollars(){
        String expected="OneHundredFiftyMillionDollars";
        String actual=app.convertNumberToWord("150000000");
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void testWithTwentyNineThousandEightHundredTwentyOneDollars(){
        String expected="TwentyNineThousandEightHundredTwentyOneDollars";
        String actual=app.convertNumberToWord("29821");
        Assert.assertEquals(expected,actual);
    }

}
