package parse;

import java.util.regex.Matcher;

/**
 * Created by zihaocastine on 6/10/16.
 */
public class ParseMillion {
    private Matcher millionMatcher;

    public ParseMillion(Matcher matcher){
        millionMatcher=matcher;
    }

    public String parse(){
        StringBuilder result=new StringBuilder();
        String numberArray[]=millionMatcher.replaceAll("$1").split("");

        result.append(new ParseNumberToWord(numberArray,"Million").parse());
        result.append(new ParseThousand(millionMatcher).parse());

        return result.toString();
    }
}
