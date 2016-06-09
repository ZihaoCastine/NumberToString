import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zihaocastine on 6/9/16.
 */
public class App {
    HashMap<String, String> numberToString;

    App(){
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
    }

    public static void main(String[] args) {
        App app=new App();
        app.run();
    }

    public void run(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a integer: ");
        String sales=input.next();
        System.out.println(convertNumberToWord(sales));

    }

    public String convertNumberToWord(String s){
        Pattern millionPattern=Pattern.compile("(\\d{1,3})(\\d{3})(\\d{3})");//One Million To 999 Million
        Pattern thousandPattern=Pattern.compile("(\\d{1,3})(\\d{3})"); //1000 to 999999
        Pattern basePattern=Pattern.compile("(\\d{1,3})");//1 to 999
        Matcher millionMatcher=millionPattern.matcher(s);
        Matcher thousandMatcher=thousandPattern.matcher(s);
        Matcher baseMatcher=basePattern.matcher(s);

        if(millionMatcher.matches()){
            return parseMillion(millionMatcher)+"Dollars";
        }else if(thousandMatcher.matches()){
            return parseThousand(thousandMatcher)+"Dollars";
        }else{
            return parseBase(baseMatcher)+"Dollars";
        }
    }

    private String parseMillion(Matcher millionMatcher){
        StringBuilder result=new StringBuilder();
        String numberArray[]=millionMatcher.replaceAll("$1").split("");

        result.append(parseNumberToWord(numberArray,"Million"));
        result.append(parseThousand(millionMatcher));

        return result.toString();
    }

    private String parseThousand(Matcher thousandMatcher){
        StringBuilder result=new StringBuilder();
        String numberArray[];
        if(thousandMatcher.groupCount()==2){
            numberArray=thousandMatcher.replaceAll("$1").split("");
        }else {
            numberArray=thousandMatcher.replaceAll("$2").split("");
        }
        result.append(parseNumberToWord(numberArray,"Thousand"));
        result.append(parseBase(thousandMatcher));

        return result.toString();
    }

    private String parseBase(Matcher baseMatcher){
        String numberArray[];
        if(baseMatcher.groupCount()==1){
            numberArray=baseMatcher.replaceAll("$1").split("");
        }else if(baseMatcher.groupCount()==2){
            numberArray=baseMatcher.replaceAll("$2").split("");
        }else {
            numberArray=baseMatcher.replaceAll("$3").split("");
        }

        StringBuilder result=new StringBuilder();
        result.append(parseNumberToWord(numberArray,""));

        return result.toString();
    }

    private String parseNumberToWord(String [] numberArray, String name){
        StringBuilder result=new StringBuilder();

        int counter=0;
        int length=numberArray.length;
        if(length==3&&!numberArray[counter].equals("0")){
            result.append(numberToString.get(numberArray[counter++])).append("Hundred");
            length--;
        }

        if(length==2){
            String temp=convertLastTwoDigit(numberArray[counter++] + numberArray[counter++]);
            if(temp.equals("")&&result.length()!=0){
                result.append(name);
            }else{
                result.append(temp).append(name);
            }
            length-=2;
        }

        if(length==1){
            if(numberArray[counter]=="0"){
                result.append(name);
            }else {
                result.append(numberToString.get(numberArray[counter])).append(name);
            }
        }
        return result.toString();
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
