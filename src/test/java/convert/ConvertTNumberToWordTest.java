package convert;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zihaocastine on 6/10/16.
 */
public class ConvertTNumberToWordTest {
    @Test
    public void testConvertNumberToWord(){

        String expected="OneThousandTwoHundredThirtyFourDollars";
        String actual=new ConvertNumberToWord("1234").convert();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testWithTwoThousandTwoHundredDollars(){
        String expected="TwoThousandTwoHundredDollars";
        String actual=new ConvertNumberToWord("2200").convert();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testWithOneHundredFiftyThousandDollars(){
        String expected="OneHundredFiftyThousandDollars";
        String actual=new ConvertNumberToWord("150000").convert();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testWithOneHundredThousandDollars(){
        String expected="OneHundredThousandDollars";
        String actual=new ConvertNumberToWord("100000").convert();
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void testWithOneMillionDollars(){
        String expected="OneMillionDollars";
        String actual=new ConvertNumberToWord("1000000").convert();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testWithFiftyMillionDollars(){
        String expected="FiftyMillionDollars";
        String actual=new ConvertNumberToWord("50000000").convert();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testWithOneHundredFiftyMillionDollars(){
        String expected="OneHundredFiftyMillionDollars";
        String actual=new ConvertNumberToWord("150000000").convert();
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void testWithTwentyNineThousandEightHundredTwentyOneDollars(){
        String expected="TwentyNineThousandEightHundredTwentyOneDollars";
        String actual=new ConvertNumberToWord("29821").convert();
        Assert.assertEquals(expected,actual);
    }

}
