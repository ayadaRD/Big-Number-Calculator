package calcu.controller;


import calcu.model.calculation;
import calcu.model.Number;
import calcu.model.Integrals;


import java.text.DecimalFormat;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class functions {

//this function make an object of number

    public static Number numberMaker(String str) {                                                        //completed

        //first variable checks if is there any sign in the first index of input string
        char first = str.charAt(0);

        Number num;  //creating an object

        if (first == '+') {    //if user input a number with "+" sign
            num = new Number("+", str.substring(1));
        } else if (first == '-') {   //if user input a number with "-" sign
            num = new Number("-", str.substring(1));
        } else {    //if user input a number without sign
            num = new Number("+", str);
        }
        return num; //returning created number
    }
//----------------------------------------------------------------------------
//this function convert a string into a int array

    public static int[] toIntArray(String str) {                                                        //completed
        //create an array of integer
        int[] array = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {

            array[i] = str.charAt(i) - '0';      // converting string to int using ASCII codes
        }

        return array;
    }
//-----------------------------------------------------------------------------------------
//this function compare two number and determinate which one is bigger (it's important in subtraction)

    public static boolean biggerNumberFinder(int[] array1, int[] array2, int arrayLength) {                          //completed

        boolean number1IsBigger = true;   //creating a boolean var to return in the end

        // if    number1 >> number2  -->  true
        //if     number1 << number2  -->  false

        for (int i = 0; i < arrayLength; i++) {

            if (array1[i] > array2[i]) {
                number1IsBigger = true;
                break;
            } else if (array1[i] < array2[i]) {
                number1IsBigger = false;
                break;
            }
        }
        return number1IsBigger;
    }
//---------------------------------------------------------------------------------------------------
//this function determine the sign of our calculation

    public static void signDetermining(calculation cal, int[] array1, int[] array2, int arrayLength) {                         //completed

        boolean number1IsBigger = biggerNumberFinder(array1, array2, arrayLength);

        switch (cal.operation) {   // defining the sign of answer based on the operation of calculation

            case "+":
                //when both number are positive
                if (cal.number1.sign.equals("+") && cal.number2.sign.equals("+")) {
                    cal.setAddPermission(true);  //the permission of adding is given in here
                    cal.setAnswerSign("+");    // defining the sign of final answer
                }
                //when both are negative
                else if (cal.number1.sign.equals("-") && cal.number2.sign.equals("-")) {
                    cal.setAddPermission(true);  //two number would add together
                    cal.setAnswerSign("-");     //with negative sign
                }
                // when number 1 is positive and number 2 is negative
                else if (cal.number1.sign.equals("+") && cal.number2.sign.equals("-")) {
                    if (number1IsBigger) {       //if number1 > number2
                        cal.setAnswerSign("+");  //the sign of subtraction would be +
                    } else {                     //if number1 < number2
                        cal.setAnswerSign("-");  //the sign of subtraction would be -
                    }
                    cal.setAddPermission(false);  //because of the difference of sign of two number, they cannot be added
                }
                //when number1 is negative and number2 is positive
                else if (cal.number1.sign.equals("-") && cal.number2.sign.equals("+")) {
                    if (number1IsBigger) {       //if number1 > number2
                        cal.setAnswerSign("-");  //the sign of subtraction would be -
                    } else {                       //if number1 < number2
                        cal.setAnswerSign("+");  //the sign of subtraction would be +
                    }
                    cal.setAddPermission(false); //because of the difference of sign of two number, they cannot be added
                }
                break;

            case "-":
                //when both number are positive
                if (cal.number1.sign.equals("+") && cal.number2.sign.equals("+")) {   // both numbers are +
                    if (number1IsBigger) {        //if number1 > number2
                        cal.setAnswerSign("+");   //subtraction would be +
                    } else {
                        cal.setAnswerSign("-");   //else would be -
                    }
                    cal.setAddPermission(false);    //in subtraction the - would  multiply in the sign of second number
                }
                // when both are negative
                else if (cal.number1.sign.equals("-") && cal.number2.sign.equals("-")) {
                    if (number1IsBigger) {       //if number1 > number2
                        cal.setAnswerSign("-");  //subtraction would be -
                    } else {
                        cal.setAnswerSign("+");  //else would be +
                    }
                    cal.setAddPermission(false);
                }
                // when number1 is + and number2 is -
                else if (cal.number1.sign.equals("+") && cal.number2.sign.equals("-")) {
                    cal.setAnswerSign("+");      // (-)*(sign of second number) = +
                    cal.setAddPermission(true);
                }
                // when number1 is - and number2 is +
                else if (cal.number1.sign.equals("-") && cal.number2.sign.equals("+")) {
                    cal.setAnswerSign("-");     // (-)*(sign of second number) = -
                    cal.setAddPermission(true);
                }
                break;

            case "*":
            case "/": {
                // when two number have the same sign
                if ((cal.number1.sign.equals("+") && cal.number2.sign.equals("+")) || (cal.number1.sign.equals("-") && cal.number2.sign.equals("-"))) {
                    cal.setAnswerSign("+");   //sign of final answer would be +
                } else {
                    cal.setAnswerSign("-");  // if the sign be different answer sign would be -
                }
                //cal.number1.setSign("+");   //after determining the sign of final answer , we set the sign of
                //cal.number2.setSign("+");   //two number as + (for easier calculation)
                break;
            }
        }
    }
//----------------------------------------------------------
//this function uses to equal two string

    public static void stringEqualizer(calculation cal) {                                                         //completed

        //here we analyze the length of our two number
        //if one of them was smaller we put 0 before that until the length of two string become the same

        //this is for when the length of number1 is bigger
        if (cal.number1.amount.length() >= cal.number2.amount.length()) {

            int extra = cal.number1.amount.length() - cal.number2.amount.length();  //the amount of 0 we should put

            for (int i = 1; i <= extra; i++) {
                cal.number2.setAmount("0" + cal.number2.amount);
            }
        }
        //this is for when the length of number2 is bigger
        else if (cal.number2.amount.length() > cal.number1.amount.length()) {

            int extra = cal.number2.amount.length() - cal.number1.amount.length();   //the amount of 0 we should put

            for (int i = 1; i <= extra; i++) {
                cal.number1.setAmount("0" + cal.number1.amount);
            }
        }
    }

//---------------------------------------------------------------------------------------------
//this function prepare two number for addition or subtraction or ...(is more useful for + & -)

    public static Number preparation(calculation cal) throws Exception {                                //completed

        //deleting extra 0 before number
        cal.number1.setAmount(cal.number1.amount.replaceAll("^0+(?!$)", ""));
        cal.number2.setAmount(cal.number2.amount.replaceAll("^0+(?!$)", ""));

        //equalize the length of two number
        stringEqualizer(cal);

        //then we convert our strings into an array of integer

        int[] array1 = toIntArray(cal.number1.amount);
        int[] array2 = toIntArray(cal.number2.amount);

        //let's determine the signs and the permission to add or subtract
        signDetermining(cal, array1, array2, array2.length);

        if (cal.operation.equals("+") || cal.operation.equals("-")) {

            if (cal.addPermission) {
                return addition(cal, array1, array2);
            } else {
                return subtraction(cal, array1, array2);
            }
        } else if (cal.operation.equals("*")) {
            return multiplication(cal);
        } else if (cal.operation.equals("/")) {
            return division(cal);
        }

        return null;
    }

//--------------------------------------------------------
// this function is for adding two number with big digits

    public static Number addition(calculation cal, int[] array1, int[] array2) {    //done

        try {

            int[] result = new int[array1.length];  //this array is for result

            //and here we start adding two arrays from the last index
            for (int i = array1.length - 1; i >= 0; i--) {
                //when the sum of two number has no carrier number
                if (((array1[i] + array2[i] < 10) && i != 0) || (i == 0)) {
                    result[i] = array1[i] + array2[i];
                } else if ((array1[i] + array2[i] >= 10) && i != 0) {
                    //if the addition of two digit was more than 9, then the previous index increases 1 unit
                    result[i] = array1[i] + array2[i] - 10;
                    array1[i - 1]++;
                }
            }
            //the result array now has the correct answer, all we should do is to convert it to a string and return

            String answer = "";

            //converting integer array to string
            for (int i = 0; i < result.length; i++) {
                answer += Integer.toString(result[i]);
            }

            //answer is ready to return!

            return numberMaker(cal.answerSign + answer);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

//----------------------------------------------------------------------------------
//this function is for subtracting two number

    public static Number subtraction(calculation cal, int[] array1, int[] array2) {     //done

        try {

            //finding bigger number
            boolean number1IsBigger = biggerNumberFinder(array1, array2, array2.length);

            int[] result = new int[array2.length];  //this array is for result

            //start subtracting
            if (!cal.addPermission) {

                if (number1IsBigger) { // number1 >> number2

                    for (int i = array1.length - 1; i >= 0; i--) {

                        if (array1[i] < array2[i]) {
                            array1[i] = array1[i] + 10;
                            array1[i - 1]--;
                            result[i] = array1[i] - array2[i];
                        } else if (array1[i] > array2[i]) {
                            result[i] = array1[i] - array2[i];
                        }
                    }
                } else {   //number1 << number2

                    for (int i = array1.length - 1; i >= 0; i--) {

                        if (array2[i] < array1[i]) {
                            array2[i] = array2[i] + 10;
                            array2[i - 1]--;
                            result[i] = array2[i] - array1[i];
                        } else if (array2[i] > array1[i]) {
                            result[i] = array2[i] - array1[i];
                        }
                    }
                }
            }

            //the result array now has the correct answer, all we should do is to convert it to a string and return

            String answer = "";

            //converting integer array to string
            for (int i = 0; i < result.length; i++) {
                answer += Integer.toString(result[i]);
            }

            //answer is ready to return!

            return numberMaker(cal.answerSign + answer);

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
//---------------------------------------------------------------
//this function is for multiplying two number

    public static Number multiplication(calculation cal) throws Exception {         //done

        if (cal.number1.amount.equals("1")) return cal.number2;
        if (cal.number2.amount.equals("1")) return cal.number1;

        //first of all we determine the sign of the answer of our numbers
        //in "signDetermining()" function, after finding answer sign, we set the sign of our both as "+"
        //so it won't bother us in the future processes
        signDetermining(cal, toIntArray(cal.number1.amount), toIntArray(cal.number2.amount), toIntArray(cal.number2.amount).length);
        //(calculation, integerArrayOfNumber1 , integerArrayOfNumber2 , lengthOfOneOfTheArrays)  sorry if it's confusing :)

        //first we save the first amount of number1 in another Number variable
        Number fakeNumber1 = (Number) cal.number1.clone();
        fakeNumber1.setSign("+");
        Number fakeNumber2 = (Number) cal.number2.clone();
        fakeNumber2.setSign("+");

        //let's think that given numbers are 256 and 28
        //to get the answer of this, we should (256 + 256) for (28 - 1) times!
        //so we need two extra calculation variable to calculate separately for number1 and number2
        calculation cal1 = new calculation(fakeNumber1, numberMaker("+" + cal.number1.amount), "+");
        calculation cal2 = new calculation(fakeNumber2, new Number("+", "1"), "-");

        //as i said earlier, we need to do this for (number2 - "1")
        //so before entering to while loop, lets decrease number2 for 1 unit
        fakeNumber2.setAmount(preparation(cal2).amount);
        //also i used substring() function because "preparation()" function returns a number with it's sign
        //and we don't need the sign

        boolean empty;  //this var help us to know if number2 reached 0 or not


        while (true) {

            //(256+256)
            fakeNumber1.setAmount(preparation(cal1).amount);
            //(28-1)
            fakeNumber2.setAmount(preparation(cal2).amount);

            empty = isEmpty(fakeNumber2.amount);
            //if number2 reached to 0 , then get out of while loop, else continue
            if (empty) break;
        }

        return numberMaker(cal.answerSign + fakeNumber1.amount);
    }
//---------------------------------------------------------------
    //this function checks if a number string is empty or full

    public static boolean isEmpty(String string) {   //done

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
//----------------------------------------------------------------------
// this function is for calculating the division of two number

    public static Number division(calculation cal) throws Exception {   //completed


        //if number2 is 0 then is not defined
        boolean empty2 = isEmpty(cal.number2.amount);
        if (empty2) return numberMaker("not defined!");

        //if number 1 is 0 then answer is 0
        boolean empty1 = isEmpty(cal.number1.amount);
        if (empty1) {
            Number numb = numberMaker("0");
            numb.setRemain("0");
            return numb;
        }

        //let's make a copy of our numbers
        Number fakeNumber1 = (Number) cal.number1.clone();
        fakeNumber1.setSign("+");
        Number fakeNumber2 = (Number) cal.number2.clone();
        fakeNumber2.setSign("+");

        boolean number1IsBigger = biggerNumberFinder(toIntArray(fakeNumber1.amount), toIntArray(fakeNumber2.amount), toIntArray(fakeNumber2.amount).length);

        if (number1IsBigger) {
            //let's think that given numbers are 256 and 28
            //to get the answer of this, we should (256 - 28) until number1 become smaller than number2
            //so we need two extra calculation variable to calculate separately for number1 and number2

            //the calculation of (number1 - number2)
            calculation cal1 = new calculation(fakeNumber1, fakeNumber2, "-");

            // this number would be our quotient
            Number counter = new Number("+", "0");

            // counter++
            calculation cal2 = new calculation(counter, new Number("+", "1"), "+");

            //this number would be the decimal remain of division
            double decimal ;

            //this boolean checks if number 1 is less than number 2 or not
            boolean fakeNumber1Bigger;

            while (true) {

                //(256-28)
                fakeNumber1.setAmount(preparation(cal1).amount);

                //counter++
                counter.setAmount(preparation(cal2).amount);

                //if number1 is less than number2 then break, else continue
                fakeNumber1Bigger = biggerNumberFinder(toIntArray(fakeNumber1.amount), toIntArray(fakeNumber2.amount), toIntArray(fakeNumber2.amount).length);
                if (!fakeNumber1Bigger) break;

            }
            //the amount of our fakeNumber1 would be the remaining of division
            //if number 1 and 2 doesn't have same sign --> number2 - fakeNumber1
            if (!cal.number1.sign.equals(cal.number2.sign)) {
                //calculation cal3 = new calculation(fakeNumber2, fakeNumber1, "+");
                fakeNumber1.setAmount(fakeNumber1.amount.replaceAll("^0+(?!$)", ""));
                counter.setRemain(fakeNumber1.amount);
                counter.setSign("-");
            }
            else {
                //counter.setRemainSign("+");
                fakeNumber1.setAmount(fakeNumber1.amount.replaceAll("^0+(?!$)", ""));
                counter.setRemain( fakeNumber1.amount);
                counter.setSign("+");
            }


            //for some calculation we need to have the decimal part too
            //so first let's fix the times that the remaining is not 0
            boolean empt = isEmpty(counter.remain);
            if(cal.powerMark){  //in this calculator we only used decimal in factorial
                if (!empt) {


                //dividing the remaining to number2 and saving in a double var
                decimal = (double) Integer.parseInt(counter.remain) / Integer.parseInt(cal.number2.amount);

                //making clear that we want 2 place decimal
                DecimalFormat df = new DecimalFormat("#.##");
                String decimal2 = df.format(decimal);  //and save it to a string

                decimal2 = decimal2.substring(2);   //we don't want the 0 and . in the first of that   0.25 --> 25

                if (decimal2.length() == 1) {  //if decimal2 had only 1 digit, we put a zero in front of that
                    decimal2 = decimal2 + "0";
                }

                counter.setDecimal(decimal2);  //and now setting into it's own place
            } else //if remaining was equal to 0, it's decimal would be zero too
                counter.setDecimal("00");}

            return counter;
        } else {   //this else statement is for when number1 is less than number two

            //we do like as we did a while ago

                Number num = numberMaker("0");
                num.setRemain(cal.number1.amount);
                num.setRemain(cal.number1.amount.replaceAll("^0+(?!$)", ""));

            if (cal.powerMark) {
                double decimal = (double) Integer.parseInt(num.remain) / Integer.parseInt(cal.number2.amount);
                DecimalFormat df = new DecimalFormat("#.##");
                String decimal2 = df.format(decimal);

                decimal2 = decimal2.replace(".","");

                if (decimal2.length() == 1)
                    decimal2 = decimal2 + "0";

                num.setDecimal(decimal2);
            }
                return num;

        }

    }
//-------------------------------------------------------------
//this function is for power of two big number

    public static Number power(Number number, Number pow) throws Exception {  //completed

        number.setAmount(number.amount.replaceAll("^0+(?!$)", ""));
        pow.setAmount(pow.amount.replaceAll("^0+(?!$)", ""));


        if (pow.amount.equals("1")) return number;

        if (pow.amount.equals("0") && number.amount.equals("0")) return numberMaker("1");

        //let's copy number and it's  power into new object
        //then make them positive for less trouble in process
        Number fakeNumber = (Number) number.clone();
        fakeNumber.setSign("+");
        Number fakePow = (Number) pow.clone();
        fakePow.setSign("+");

        //number should multiply in itself
        calculation cal1 = new calculation(fakeNumber, number, "*");
        //until power become 0
        calculation cal2 = new calculation(fakePow, numberMaker("1"), "-");

        //for answer to be accurate, before entering while loop we pow--
        fakePow.setAmount(preparation(cal2).amount);  //doing well

        boolean empty;  //this checks if power is 0 or not
        long counter = 1;  //this counts the times that while loop repeats
        boolean powIsEven;  //and this tell us that power is even or odd

        while (true) {
            //number*number
            fakeNumber.setAmount(preparation(cal1).amount);

            //power*power
            fakePow.setAmount(preparation(cal2).amount);  //doing well

            counter++;

            if (counter % 2 == 0) powIsEven = true;
            else powIsEven = false;

            empty = isEmpty(fakePow.amount);
            if (empty) break;
        }
        //this if condition checks that number is + or -
        if (number.sign.equals("-")) {
            if (powIsEven) {  //if the power was even, the sign of answer would be +
                fakeNumber.setSign("+");
            } else {   //and if power was odd , the final sign would be -
                fakeNumber.setSign("-");
            }
        }
        //this checks if power was - , the answer would be like this -->  1/fakeNumber
        if (pow.sign.equals("-")) {

            calculation cal3 = new calculation(numberMaker("1"), fakeNumber, "/");
            cal3.setPowerMark(true);
            return numberMaker(fakeNumber.sign + "0." + preparation(cal3).decimal);
        }

        return fakeNumber;
    }

//-------------------------------------------------------------
//this function calculates certain integral

    public static double integral(Integrals integral) throws Exception {   //completed

        double sum = 0;

        for (int i = 0; i <= integral.polynomialsDegree ; i++) {

            if (integral.factors.get(i) != 0) {

                double ans1 =  pow(integral.upperBound, i + 1) * integral.factors.get(i) / (i + 1);

                double ans2 =  pow(integral.lowerBound, i + 1) * integral.factors.get(i) / (i + 1);

                sum += ans1 - ans2;
            }
        }

        return sum;

    }

    //------------------------------------------------------------------------------------
//this function calculates the factorial of a big number
    public static Number factorial(Number number) throws Exception {    //completed

        Number fakeNumber1 = (Number) number.clone();
        fakeNumber1.setSign("+");
        Number fakeNumber2 = (Number) number.clone();
        fakeNumber2.setSign("+");
        number.setAmount(number.amount.replaceAll("^0+(?!$)", ""));


        calculation cal1 = new calculation(fakeNumber2, numberMaker("1"), "-");
        fakeNumber2.setAmount(preparation(cal1).amount);
        calculation cal2 = new calculation(fakeNumber1, fakeNumber2, "*");

        while (true) {

            fakeNumber1.setAmount(preparation(cal2).amount);
            fakeNumber2.setAmount(preparation(cal1).amount);
            if (fakeNumber2.amount.equals("1")) break;
        }

        if (number.sign.equals("-"))
            fakeNumber1.setSign("-");

        return fakeNumber1;
    }


    public static Number sinAndCos(Number number) throws Exception {

        String nn = "600000000000000";
        Number piNum = numberMaker(nn);
        boolean number1IsBigger ;
        calculation cal = new calculation(number,piNum,"-");
        stringEqualizer(cal);
        int ln = number.amount.length();

        if(ln > 15) {
            while (true) {

                number1IsBigger = biggerNumberFinder(toIntArray(number.amount), toIntArray(piNum.amount), toIntArray(number.amount).length);
                if (!number1IsBigger) {
                    break;
                }
                number.setAmount(preparation(cal).amount);
            }
        }
        return number;
    }
}