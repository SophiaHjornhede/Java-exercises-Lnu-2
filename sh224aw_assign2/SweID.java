package sh224aw_assign2;

/**
 * Assignment-2, exercise-2
 *
 * @author Sophia Hjörnhede
 * @version 1.10 30 June 2020
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SweID {

    private static Pattern regexPattern = null;
    final String regex = "^(\\d{6})([-])(\\d{4})$"; //use regex to fix the digits format
    private String firstPart = "";
    private String secondPart= "";
    private String fullPn;

    public SweID(String fullPn) {
        this.fullPn = fullPn;
    }

    public SweID() {
    }

    public String getRegex() {
        return regex;
    }

    public String getFullPn() {
        return fullPn;
    }

    public void setFullPn(String fullPn) {
        this.fullPn = fullPn;
    }

    //method to get the first 6 digits
    public String getFirstPart(String sweID) {
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(sweID);

        while (matcher.find()) {
            firstPart = matcher.group(1); //in this regex group(1) is the first 6 digits, the group(3) is the second 4 digits
        }
        return firstPart;
    }

    //method to get the second 4 digits
    public String getSecondPart(String sweID) {
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(sweID);

        while (matcher.find()) {
            secondPart = matcher.group(3);
        }
        return secondPart;
    }

    public boolean isFemaleNumber(String sweID) {
        int secondP = 0;
        int gender = 0;

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(sweID);
        while (matcher.find()) {
            secondP = Integer.parseInt(matcher.group(3));
        }

        gender = (secondP/10)%10;
        if (gender%2 == 1){
            System.out.println("This is a male number. ");
            return false;
        }
        else{
            System.out.println("This is a female number. ");
            return true;
        }
    }

    public Boolean areEqual(String id1, String id2){

        if(id1.equals(id2)){
            System.out.println(id1 + " and " + id2 + " are equal. ");
            return true;
        }else {
            System.out.println(id1 + " and " + id2 + " are not equal. ");
            return false;
        }
    };

    public boolean isCorrectMonthDate(String sweID) {
        int firstP = 0;
        int month = 0;
        int day = 0;
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(sweID);
        while (matcher.find()) {
            firstP = Integer.parseInt(matcher.group(1));
        }
        month = (firstP / 100) % 100;
        day = firstP % 100;
        if (month < 0 || month > 12) {
            System.out.print("(unvalid month)");
        }
        else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31){
            System.out.print("(unvalid date)");
        }
        else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            System.out.print("(unvalid date)");
        }
        else if ((month == 2) && day > 28) {
            System.out.print("(unvalid date)");
        }
        else {
            System.out.println("The first part of the number is correct.");
        }
        return true;
    }

    //get the last control number by Luhn algorithm
    public String getControlNumber(String sweID){
        int controlNumber=0;
        int secondP=0;
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(sweID);
        while (matcher.find()) {
            secondP = Integer.parseInt(matcher.group(3));
        }
        controlNumber = secondP%10;
        return String.valueOf(controlNumber);
    }

    public String calControlNumber(String sweID){
        String controlNumber;
        int numberTemp=0;
        int secondP=0;
        int firstP=0;
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(sweID);
        while (matcher.find()) {
            secondP = Integer.parseInt(matcher.group(3));
            firstP = Integer.parseInt(matcher.group(1));
        }
        numberTemp = (firstP*1000)+(secondP/10);        //get the 9 digits without the control number
        String nTemp = String.valueOf(numberTemp);

        //fill in the 9 digits into an array
        int[] a = new int[9];
            for(int i=0; i<a.length;i++){
            a[i] = Integer.parseInt(nTemp.substring(i,i+1));
            }

        //calculate the sum of the odd digits
        int OddSum = 0;
            for(int j=7;j>=0;j=j-2){
                int n = a[j];
                OddSum = OddSum+n;
            }

            //find the even digits of the numbers, each digit times two and if the result is bigger than 9, will minus 9, and calculate the even sum.
        int EvenSum = 0;
            for(int j=8;j>=0;j=j-2){
                int m = a[j];
                m = m*2;
                if(m>9){
                   m=m-9;
                }
                a[j] = m;
                EvenSum = EvenSum+a[j];
            }

            //calculate the control number
            int conCal = 10 - (OddSum + EvenSum)%10;
            controlNumber = String.valueOf(conCal);
            return controlNumber;
        }

    public boolean isCorrectControlN(String sweID){
        String g = getControlNumber(sweID);
        String c = calControlNumber(sweID);
        if(!g.equals(c)){
            System.out.println("The control number is not correct.");
            return false;
        }
        System.out.println("The control number is a correct.");
        return true;
    }

    public boolean isCorrectNumber(String sweID){
        if(isCorrectMonthDate(sweID)&&isCorrectControlN(sweID)){
            System.out.println(sweID + " is a correct number.");
            return true;
        }else {
            System.out.println(sweID + " is not a correct number.");
            return false;
        }
    }
}
