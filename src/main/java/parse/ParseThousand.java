package parse;

import java.util.regex.Matcher;

/**
 * Created by zihaocastine on 6/10/16.
 */
public class ParseThousand {
    private Matcher thousandMatcher;

    public ParseThousand(Matcher matcher){
        thousandMatcher=matcher;
    }

    public String parse(){
        StringBuilder result=new StringBuilder();
        String numberArray[];
        if(thousandMatcher.groupCount()==2){
            numberArray=thousandMatcher.replaceAll("$1").split("");
        }else {
            numberArray=thousandMatcher.replaceAll("$2").split("");
        }
        result.append(new ParseNumberToWord(numberArray,"Thousand").parse());
        result.append(new ParseBaseNumber(thousandMatcher).parse());

        return result.toString();
    }
}
