package calcu.controller;

import calcu.model.Integrals;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class integralController {

    @FXML
    private TextField resultText;

    @FXML
    private TextField lowB;

    @FXML
    private TextField upB;

    @FXML
    private Label l0;

    @FXML
    private Label l1;

    @FXML
    private Label l4;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l5;

    @FXML
    private Label l6;

    @FXML
    private Label l7;

    @FXML
    private Label l8;

    @FXML
    private Label l9;

    @FXML
    private TextField f0;

    @FXML
    private TextField f7;

    @FXML
    private TextField f6;

    @FXML
    private TextField f4;

    @FXML
    private TextField f10;

    @FXML
    private TextField f8;

    @FXML
    private TextField f9;

    @FXML
    private TextField f5;

    @FXML
    private TextField f3;

    @FXML
    private TextField f2;

    @FXML
    private TextField f1;

    @FXML
    private Label l10;

    @FXML
    private Button equ;

    @FXML
    private MenuButton maxDegree;

    @FXML
    private Pane mainPane;

    @FXML
    private Button mode;


    private boolean isLightMode = true;

    @FXML
//changing theme
    private void changeMode(ActionEvent event) {

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
//for the x^n
    public void on0DegreeClick(ActionEvent ac){

        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(false);
        l1.setVisible(false);
        f2.setVisible(false);
        l2.setVisible(false);
        f3.setVisible(false);
        l3.setVisible(false);
        f4.setVisible(false);
        l4.setVisible(false);
        f5.setVisible(false);
        l5.setVisible(false);
        f6.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        f7.setVisible(false);
        f8.setVisible(false);
        l8.setVisible(false);
        f9.setVisible(false);
        l9.setVisible(false);
        f10.setVisible(false);
        l10.setVisible(false);
        maxDegree.setText("0");

    }
    public void on1DegreeClick(javafx.event.ActionEvent ac){

        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(true);
        l1.setVisible(true);
        f2.setVisible(false);
        l2.setVisible(false);
        f3.setVisible(false);
        l3.setVisible(false);
        f4.setVisible(false);
        l4.setVisible(false);
        f5.setVisible(false);
        l5.setVisible(false);
        f6.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        f7.setVisible(false);
        f8.setVisible(false);
        l8.setVisible(false);
        f9.setVisible(false);
        l9.setVisible(false);
        f10.setVisible(false);
        l10.setVisible(false);
        maxDegree.setText("1");

    }
    public void on2DegreeClick(javafx.event.ActionEvent ac){

        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(true);
        l1.setVisible(true);
        f2.setVisible(true);
        l2.setVisible(true);
        f3.setVisible(false);
        l3.setVisible(false);
        f4.setVisible(false);
        l4.setVisible(false);
        f5.setVisible(false);
        l5.setVisible(false);
        f6.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        f7.setVisible(false);
        f8.setVisible(false);
        l8.setVisible(false);
        f9.setVisible(false);
        l9.setVisible(false);
        f10.setVisible(false);
        l10.setVisible(false);
        maxDegree.setText("2");

    }
    public void on3DegreeClick(javafx.event.ActionEvent ac){

        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(true);
        l1.setVisible(true);
        f2.setVisible(true);
        l2.setVisible(true);
        f3.setVisible(true);
        l3.setVisible(true);
        f4.setVisible(false);
        l4.setVisible(false);
        f5.setVisible(false);
        l5.setVisible(false);
        f6.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        f7.setVisible(false);
        f8.setVisible(false);
        l8.setVisible(false);
        f9.setVisible(false);
        l9.setVisible(false);
        f10.setVisible(false);
        l10.setVisible(false);
        maxDegree.setText("3");

    }
    public void on4DegreeClick(javafx.event.ActionEvent ac){


        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(true);
        l1.setVisible(true);
        f2.setVisible(true);
        l2.setVisible(true);
        f3.setVisible(true);
        l3.setVisible(true);
        f4.setVisible(true);
        l4.setVisible(true);
        f5.setVisible(false);
        l5.setVisible(false);
        f6.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        f7.setVisible(false);
        f8.setVisible(false);
        l8.setVisible(false);
        f9.setVisible(false);
        l9.setVisible(false);
        f10.setVisible(false);
        l10.setVisible(false);
        maxDegree.setText("4");

    }
    public void on5DegreeClick(javafx.event.ActionEvent ac){

        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(true);
        l1.setVisible(true);
        f2.setVisible(true);
        l2.setVisible(true);
        f3.setVisible(true);
        l3.setVisible(true);
        f4.setVisible(true);
        l4.setVisible(true);
        f5.setVisible(true);
        l5.setVisible(true);
        f6.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        f7.setVisible(false);
        f8.setVisible(false);
        l8.setVisible(false);
        f9.setVisible(false);
        l9.setVisible(false);
        f10.setVisible(false);
        l10.setVisible(false);
        maxDegree.setText("5");

    }
    public void on6DegreeClick(javafx.event.ActionEvent ac){

        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(true);
        l1.setVisible(true);
        f2.setVisible(true);
        l2.setVisible(true);
        f3.setVisible(true);
        l3.setVisible(true);
        f4.setVisible(true);
        l4.setVisible(true);
        f5.setVisible(true);
        l5.setVisible(true);
        f6.setVisible(true);
        l6.setVisible(true);
        l7.setVisible(false);
        f7.setVisible(false);
        f8.setVisible(false);
        l8.setVisible(false);
        f9.setVisible(false);
        l9.setVisible(false);
        f10.setVisible(false);
        l10.setVisible(false);
        maxDegree.setText("6");

    }
    public void on7DegreeClick(javafx.event.ActionEvent ac){
        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(true);
        l1.setVisible(true);
        f2.setVisible(true);
        l2.setVisible(true);
        f3.setVisible(true);
        l3.setVisible(true);
        f4.setVisible(true);
        l4.setVisible(true);
        f5.setVisible(true);
        l5.setVisible(true);
        f6.setVisible(true);
        l6.setVisible(true);
        l7.setVisible(true);
        f7.setVisible(true);
        f8.setVisible(false);
        l8.setVisible(false);
        f9.setVisible(false);
        l9.setVisible(false);
        f10.setVisible(false);
        l10.setVisible(false);
        maxDegree.setText("7");

    }
    public void on8DegreeClick(javafx.event.ActionEvent ac){
        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(true);
        l1.setVisible(true);
        f2.setVisible(true);
        l2.setVisible(true);
        f3.setVisible(true);
        l3.setVisible(true);
        f4.setVisible(true);
        l4.setVisible(true);
        f5.setVisible(true);
        l5.setVisible(true);
        f6.setVisible(true);
        l6.setVisible(true);
        l7.setVisible(true);
        f7.setVisible(true);
        f8.setVisible(true);
        l8.setVisible(true);
        f9.setVisible(false);
        l9.setVisible(false);
        f10.setVisible(false);
        l10.setVisible(false);
        maxDegree.setText("8");

    }
    public void on9DegreeClick(javafx.event.ActionEvent ac){
        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(true);
        l1.setVisible(true);
        f2.setVisible(true);
        l2.setVisible(true);
        f3.setVisible(true);
        l3.setVisible(true);
        f4.setVisible(true);
        l4.setVisible(true);
        f5.setVisible(true);
        l5.setVisible(true);
        f6.setVisible(true);
        l6.setVisible(true);
        l7.setVisible(true);
        f7.setVisible(true);
        f8.setVisible(true);
        l8.setVisible(true);
        f9.setVisible(true);
        l9.setVisible(true);
        f10.setVisible(false);
        l10.setVisible(false);
        maxDegree.setText("9");

    }
    public void on10DegreeClick(javafx.event.ActionEvent ac){
        f0.setVisible(true);
        l0.setVisible(true);
        f1.setVisible(true);
        l1.setVisible(true);
        f2.setVisible(true);
        l2.setVisible(true);
        f3.setVisible(true);
        l3.setVisible(true);
        f4.setVisible(true);
        l4.setVisible(true);
        f5.setVisible(true);
        l5.setVisible(true);
        f6.setVisible(true);
        l6.setVisible(true);
        l7.setVisible(true);
        f7.setVisible(true);
        f8.setVisible(true);
        l8.setVisible(true);
        f9.setVisible(true);
        l9.setVisible(true);
        f10.setVisible(true);
        l10.setVisible(true);
        maxDegree.setText("10");
    }





    public void onFinalClick(ActionEvent ae) throws Exception {

        Integrals integral = new Integrals(Long.parseLong(upB.getText()),Long.parseLong(lowB.getText()),Long.parseLong(maxDegree.getText()));


        integral.factors.add (Integer.valueOf(f0.getText()));
        integral.factors.add (Integer.valueOf(f1.getText()));
        integral.factors.add (Integer.valueOf(f2.getText()));
        integral.factors.add (Integer.valueOf(f3.getText()));
        integral.factors.add (Integer.valueOf(f4.getText()));
        integral.factors.add (Integer.valueOf(f5.getText()));
        integral.factors.add (Integer.valueOf(f6.getText()));
        integral.factors.add (Integer.valueOf(f7.getText()));
        integral.factors.add (Integer.valueOf(f8.getText()));
        integral.factors.add (Integer.valueOf(f9.getText()));
        integral.factors.add (Integer.valueOf(f10.getText()));


        Double answer = functions.integral(integral);

        resultText.setText(String.valueOf(answer));

    }

}