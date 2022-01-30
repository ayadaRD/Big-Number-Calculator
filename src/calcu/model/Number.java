package calcu.model;


import calcu.model.calculation;
import calcu.model.Number;
import calcu.controller.functions;


public class Number implements Cloneable{

    public String sign;   //the sign of number
    public String amount;  //the amount of number
    public String remain;  //the remain amount of division
    public String decimal;

    public Object clone() throws CloneNotSupportedException   //for special cases
    {                                                         //when we want copy this object into another object
        return super.clone();
    }

    public Number(String sign, String amount) {    //constructor
        this.sign = sign;
        this.amount = amount;
    }

    public String toString() {
        return sign + amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setRemain(String remain) { this.remain = remain; }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }
}