package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class StartScreen {
    private boolean newgame;

    public void newGame(ActionEvent e) throws Exception {
        newgame = true;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Input.fxml"));
        loader.setController(new Input(newgame));
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void loadGame(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Input.fxml"));
        loader.setController(new Input(newgame));
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }
}
