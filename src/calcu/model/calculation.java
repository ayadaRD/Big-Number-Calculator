package calcu.model;

public class calculation {

    public Number number1;
    public Number number2;
    public String operation;
    public String answerSign;
    public boolean addPermission;  //if two number had a same sign, this boolean would be true
    //it means like "yeah you have the permission to add this two number
    public boolean powerMark = false;  //this is for when we want use division function in other processes


    public calculation(Number number1, Number number2, String operation){   //constructor

        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public void setAnswerSign(String sign){
        this.answerSign = sign;
    }

    public void setAddPermission(boolean permission){
        this.addPermission = permission;
    }

    public void setPowerMark(boolean powerMark) {
        this.powerMark = powerMark;
    }
}