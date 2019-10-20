package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button add;
    @FXML
    private Button subtract;
    @FXML
    private Button divide;
    @FXML
    private Button multiply;
    @FXML
    private Button calculate;
    @FXML
    private Button clear;
    @FXML
    private TextField first;
    @FXML
    private TextField second;
    @FXML
    private Label operator;
    @FXML
    private Label answer;
    private float ans;
    private int option=-1;
    public void handlebutton(ActionEvent e){
        if(e.getSource()==add){
            operator.setText("+");
            option=1;

        }
        else if(e.getSource()==subtract){
            operator.setText("-");
            option=2;

        }
        else if (e.getSource()==divide){
            operator.setText("/");
            option=3;


        }
        else if(e.getSource()==multiply){
            operator.setText("*");
            option=4;
        }
        else if(e.getSource()==clear){
            operator.setText("?");
            first.setText("");
            second.setText("");
            answer.setText("?");
        }
        else if(e.getSource()==calculate){
            try {
                switch (option) {
                    case 1:
                        answer.setText("+");
                        ans = Float.parseFloat(first.getText()) + Float.parseFloat(second.getText());
                        answer.setText(String.valueOf(ans));
                        break;
                    case 2:
                        answer.setText("-");
                        ans = Float.parseFloat(first.getText()) - Float.parseFloat(second.getText());
                        answer.setText(String.valueOf(ans));
                        break;
                    case 3:
                        answer.setText("/");

                        ans = Float.parseFloat(first.getText()) / Float.parseFloat(second.getText());
                        answer.setText(String.valueOf(ans));
                        break;
                    case 4:
                        answer.setText("*");
                        ans = Float.parseFloat(first.getText()) * Float.parseFloat(second.getText());
                        answer.setText(String.valueOf(ans));
                        break;
                    default:
                        answer.setText("Please select operator");
                        break;
                }
            }
            catch (Exception ex){
                answer.setText("please write only integers");
            }

        }

    }
}
