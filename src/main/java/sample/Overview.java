package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class Overview {
    public void back(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../LoginScreen.fxml"));
        loader.setController(new LoginScreen());
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }
}
