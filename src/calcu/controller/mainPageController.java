package calcu.controller;

import calcu.Main;
import calcu.model.Number;
import calcu.model.calculation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.cos;
import static java.lang.Math.sin;


public class mainPageController implements Initializable {

    //this boolean checks if user clicked on a operator or not
    boolean isOperatorPressed;

    //this string saves the type of operator
    String operatorPressed = "";
    static String op;

    Number number2;
    Number number1=null;

    @FXML
    public Button mode;

    @FXML
    private Button cos;

    @FXML
    private Button factorial;

    @FXML
    private ToggleButton mult;

    @FXML
    private ToggleButton plus;

    @FXML
    private ToggleButton mines;

    @FXML
    private ToggleButton divide;

    @FXML
    private Button ax;

    @FXML
    private Button pow;

    @FXML
    private Button clear;

    @FXML
    private Button integral;

    @FXML
    private TextField resultText;

    @FXML
    private Pane mainPane;

    @FXML
    private Pane topCal;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private TextArea myTextField;


//when user click on integral button , this function handles
    public void integralClicks(ActionEvent ae) throws IOException {

        //loading
        Parent root2 = FXMLLoader.load(Main.class.getResource("view/IntegralPage.fxml"));

        //creating stage and staffs on it
        Scene scene2 = new Scene(root2);
        Stage stage2 = new Stage();

        //sizing
        stage2.setWidth(570);
        stage2.setHeight(800);

        //setting light mode as default
        scene2.getStylesheets().add("calcu/styles/lightMode.css");
        stage2.getIcons().add(new Image("calcu/icon.jfif"));

        //disable maximize button
        stage2.resizableProperty().setValue(Boolean.FALSE);

        //set title
        stage2.setTitle("INTEGRAL");

        //connecting
        stage2.setScene(scene2);

        //show
        stage2.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
                myTextField.textProperty().addListener(new ChangeListener<String>() {
                    Button mode = new Button();

                 @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                     //this just say us what are we allowed to put in text field
                     if (newValue.matches( "T(-?[0-9]+)")) {
                        myTextField.setText(oldValue);
                    }
                }
            });
    }


//this, handles when user click on a number
    @FXML
    private void onNumberClick(ActionEvent event) {
            //if clicked item was a button
            if (event.getSource() instanceof Button) {

                //then save it to a var of button
                Button btn = (Button) event.getSource();

                //after clicking on this button show a hand instead of cursor
                btn.setCursor(Cursor.HAND);

                //if this button was an operator
                if (isOperatorPressed) {
                    //clear text field
                    myTextField.setText(btn.getText().trim());
                }
                else {
                    //else add the name of number to text field
                        myTextField.setText(myTextField.getText().trim() + btn.getText().trim());
                }

                isOperatorPressed = false;
            }
    }

    //for knowing now is in light mod or dark mode
    private boolean isLightMode = true;

    @FXML  //changing modes
    private void changeMode(ActionEvent event) {
        //mode would change, so boolean would be revers
            isLightMode = !isLightMode;

            if(isLightMode){
                setLightMode();
            }
            else{
                setDarkMode();
            }
    }

    private void setLightMode(){
        mainPane.getStylesheets().remove("calcu/styles/darkMode.css");
        mainPane.getStylesheets().add("calcu/styles/lightMode.css");
        mode.setText("☽");
    }

    private void setDarkMode(){
        mainPane.getStylesheets().remove("calcu/styles/lightMode.css");
        mainPane.getStylesheets().add("calcu/styles/darkMode.css");
        mode.setText("☼");
    }

    //when user click on a operator
    @FXML
    private void onOperatorClick(ActionEvent event) throws Exception {

        if(event.getSource() instanceof Button) {

            Button btn = (Button)event.getSource();

            btn.setCursor(Cursor.HAND);

            if (!myTextField.getText().isEmpty()) {
                //save type of operator
                op = operatorPressed;

            }
            if (btn.getText().equals("=")){

                number2 = functions.numberMaker(myTextField.getText());
                calculation cal = new calculation(number1,number2,op);

                for(int i=0 ; i<number1.amount.length() ; i++){
                    if(number1.amount.charAt(i) == '0' ||
                       number1.amount.charAt(i) == '1' ||
                       number1.amount.charAt(i) == '2' ||
                       number1.amount.charAt(i) == '3' ||
                       number1.amount.charAt(i) == '4' ||
                       number1.amount.charAt(i) == '5' ||
                       number1.amount.charAt(i) == '6' ||
                       number1.amount.charAt(i) == '7' ||
                       number1.amount.charAt(i) == '8' ||
                       number1.amount.charAt(i) == '9' ||
                       number1.amount.charAt(i) == '+' ||
                       number1.amount.charAt(i) == '-'){
                           continue;
                    }
                    else{
                        myTextField.setText("please enter numbers!");
                        throw new Exception("out");
                    }
                }
                for(int i=0 ; i<number2.amount.length() ; i++){
                    if(number2.amount.charAt(i) == '0' ||
                            number2.amount.charAt(i) == '1' ||
                            number2.amount.charAt(i) == '2' ||
                            number2.amount.charAt(i) == '3' ||
                            number2.amount.charAt(i) == '4' ||
                            number2.amount.charAt(i) == '5' ||
                            number2.amount.charAt(i) == '6' ||
                            number2.amount.charAt(i) == '7' ||
                            number2.amount.charAt(i) == '8' ||
                            number2.amount.charAt(i) == '9' ||
                            number2.amount.charAt(i) == '+' ||
                            number2.amount.charAt(i) == '-'){
                        continue;
                    }
                    else{
                        myTextField.setText("please enter numbers!");
                        throw new Exception("out");
                    }
                }

                //showing process to user
                myTextField.setText(cal.number1.sign+cal.number1.amount + "\n" + cal.operation + "\n" + cal.number2.sign + cal.number2.amount);


                switch (cal.operation) {
                    case "/":
                        Number ans1 = functions.preparation(cal);
                        resultText.setText( ans1 + "     Remain: " + ans1.remain);
                        break;

                    case "X":
                        Number ans2 = functions.multiplication(cal);
                        if(cal.number1.sign.equals(cal.number2.sign))
                            ans2.setSign("+");
                        else
                            ans2.setSign("-");

                            resultText.setText(ans2.sign + ans2.amount);
                            resultText.setText(resultText.getText().replace("null",""));
                        break;

                    case "+":
                    case "-":{
                        Number ans3 = functions.preparation(cal);
                        resultText.setText(ans3.sign + ans3.amount);
                        break;
                    }

                    case "x^y":
                        Number ans4 = functions.power(number1,number2);
                        resultText.setText(ans4.sign + ans4.amount);
                        break;
                }

                operatorPressed = "";
            }
            else if(btn.getText().equals("x!")){
                number1 = functions.numberMaker(myTextField.getText());
                Number ans4 = functions.factorial(number1);
                resultText.setText(ans4.sign + ans4.amount);
            }

            else if(btn.getText().equals("+/-")){

                if(myTextField.getText().charAt(0) == '+'){
                    myTextField.setText("-" + myTextField.getText().substring(1));

                }
                else if(myTextField.getText().charAt(0) == '-'){
                    myTextField.setText("+" + myTextField.getText().substring(1));
                }
                else{
                    myTextField.setText("-" + myTextField.getText());
                }

            }
            else if (btn.getText().equals("sin(x)")){
                number1 = functions.numberMaker(myTextField.getText());
                Number ans4 = functions.sinAndCos(number1);
                resultText.setText(String.valueOf(sin(Double.parseDouble( ans4.amount))));

            }

            else if (btn.getText().equals("cos(x)")){
                number1 = functions.numberMaker(myTextField.getText());
                Number ans5 = functions.sinAndCos(number1);
                resultText.setText(String.valueOf(cos(Double.parseDouble( ans5.amount))));

            }

            else {
                number1 = functions.numberMaker(myTextField.getText());
                myTextField.setText("");
                operatorPressed = btn.getText().trim();
            }
            isOperatorPressed = true;
        }
    }

    //clearing everything
    @FXML
    private void onCEClick(ActionEvent event) {
        myTextField.setText("");
        resultText.setText("");
        isOperatorPressed = false;
        operatorPressed = "";
    }

    //clearing only one number
    @FXML
    private void onDELClick(ActionEvent event) {
        if(myTextField.getText().length() > 0) {
            myTextField.setText(myTextField.getText(0, myTextField.getText().length() - 1));
        }
    }

}
