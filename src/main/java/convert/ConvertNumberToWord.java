package convert;
import parse.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zihaocastine on 6/10/16.
 */
public class ConvertNumberToWord {
    private String number;

    public ConvertNumberToWord(String number){
        this.number=number;
    }

    public String convert(){
        Pattern millionPattern=Pattern.compile("(\\d{1,3})(\\d{3})(\\d{3})");//One Million To 999 Million
        Pattern thousandPattern=Pattern.compile("(\\d{1,3})(\\d{3})"); //1000 to 999999
        Pattern basePattern=Pattern.compile("(\\d{1,3})");//1 to 999
        Matcher millionMatcher=millionPattern.matcher(number);
        Matcher thousandMatcher=thousandPattern.matcher(number);
        Matcher baseMatcher=basePattern.matcher(number);

        if(millionMatcher.matches()){
            return  new ParseMillion(millionMatcher).parse()+"Dollars";
        }else if(thousandMatcher.matches()){
            return new ParseThousand(thousandMatcher).parse()+"Dollars";
        }else{
            return new ParseBaseNumber(baseMatcher).parse()+"Dollars";
        }
    }

}
