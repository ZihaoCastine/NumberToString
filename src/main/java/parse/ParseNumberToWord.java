package parse;

import java.util.HashMap;

/**
 * Created by zihaocastine on 6/10/16.
 */
public class ParseNumberToWord {
    private String [] numberArray;
    private String name;
    private HashMap<String, String> numberToString;
    private int counter, length;
    private StringBuilder result;

    ParseNumberToWord(String [] numberArray, String name){
        this.numberArray=numberArray;
        this.name=name;
        numberToString=new HashMap<String, String>();
        numberToString.put("1","One");
        numberToString.put("2","Two");
        numberToString.put("3","Three");
        numberToString.put("4","Four");
        numberToString.put("5","Five");
        numberToString.put("6","Six");
        numberToString.put("7","Seven");
        numberToString.put("8","Eight");
        numberToString.put("9","Nine");
        numberToString.put("10","Ten");
        numberToString.put("11","Eleven");
        numberToString.put("12","Twelve");
        numberToString.put("13","Thirteen");
        numberToString.put("14","Fourteen");
        numberToString.put("15","Fifteen");
        numberToString.put("16","Sixteen");
        numberToString.put("17","Seventeen");
        numberToString.put("18","Eighteen");
        numberToString.put("19","Nineteen");
        numberToString.put("20","Twenty");
        numberToString.put("30","Thirty");
        numberToString.put("40","Forty");
        numberToString.put("50","Fifty");
        numberToString.put("60","Sixty");
        numberToString.put("70","Seventy");
        numberToString.put("80","Eighty");
        numberToString.put("90","Ninety");
        this.result=new StringBuilder();
        this.counter=0;
        this.length=numberArray.length;
    }

    public String parse(){
        parseWhenLengthEqualThree();
        parseWhenLengthEqualTwo();
        parseWhenLengthEqualOne();

        return result.toString();
    }

    private void parseWhenLengthEqualThree(){
        if(length==3&&!numberArray[counter].equals("0")){
            result.append(numberToString.get(numberArray[counter++])).append("Hundred");
            length--;
        }
    }

    private void parseWhenLengthEqualTwo(){
        if(length==2){
            String temp=convertLastTwoDigit(numberArray[counter++] + numberArray[counter++]);
            if(temp.equals("")&&result.length()!=0){
                result.append(name);
            }else{
                result.append(temp).append(name);
            }
            length-=2;
        }
    }

    private void parseWhenLengthEqualOne(){
        if(length==1){
            if(numberArray[counter]=="0"){
                result.append(name);
            }else {
                result.append(numberToString.get(numberArray[counter])).append(name);
            }
        }
    }

    private String convertLastTwoDigit(String s){
        if(s.equals("00")){
            return "";
        }else {
            if (s.charAt(0)=='0'){
                return s.substring(1);
            }else {
                if(s.charAt(1)=='0'||s.charAt(0)=='1'){
                    return numberToString.get(s);
                }else {
                    StringBuilder result=new StringBuilder();
                    String wholeNumber=s.charAt(0)+"0";
                    result.append(numberToString.get(wholeNumber)).append(numberToString.get(s.substring(1)));
                    return result.toString();
                }
            }
        }
    }
}
