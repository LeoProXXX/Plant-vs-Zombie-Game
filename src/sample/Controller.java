package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML
    private Button clear;
    @FXML
    private TextField second;
    @FXML
    private Label operator;
    @FXML
    private Pane LayoutPane;
    @FXML
    private ImageView loginbackground;
    private int option=-1;
    public void handlebutton(ActionEvent e){


        if(e.getSource()==clear){
            operator.setText("?");
            second.setText("");

        }
    }
}
