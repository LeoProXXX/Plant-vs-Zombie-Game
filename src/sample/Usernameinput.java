package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Usernameinput {
    @FXML
    public TextField username;
    @FXML
    public Button proceed;
    @FXML
    public Label label;
    public void onAction(ActionEvent e)throws Exception{
        if(e.getSource()==proceed){
            String name=username.getText();
            if(name.length()>0){
                Main.changeScene("Ingame.fxml");
            }
            else{
                label.setText("Name Can't be empty");
                label.setTextFill(Color.web("#ff0000",0.8));
            }

        }
    }
}
