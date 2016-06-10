package parse;

import java.util.regex.Matcher;

/**
 * Created by zihaocastine on 6/10/16.
 */
public class ParseBaseNumber {
    private Matcher baseMatcher;

    public ParseBaseNumber(Matcher baseMatcher){
        this.baseMatcher=baseMatcher;
    }

    public String parse(){
        String numberArray[];
        if(baseMatcher.groupCount()==1){
            numberArray=baseMatcher.replaceAll("$1").split("");
        }else if(baseMatcher.groupCount()==2){
            numberArray=baseMatcher.replaceAll("$2").split("");
        }else {
            numberArray=baseMatcher.replaceAll("$3").split("");
        }

        StringBuilder result=new StringBuilder();
        result.append(new ParseNumberToWord(numberArray,"").parse());

        return result.toString();
    }
}
