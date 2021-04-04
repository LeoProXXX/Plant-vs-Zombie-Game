package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseLevel implements Initializable {
    @FXML
    VBox level1;
    @FXML
    VBox level2;
    @FXML
    VBox level3;
    @FXML
    VBox level4;
    @FXML
    VBox level5;

    public void back_login(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../LoginScreen.fxml"));
        loader.setController(new LoginScreen());
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void level1() throws Exception {
        Level.setLevel(1);
        PlayGame p = new PlayGame(1);
        Main.getPlayer().add(p);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Ingame.fxml"));
        loader.setController(new Animated(p));
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void level2() throws Exception {
        Level.setLevel(2);
        PlayGame p = new PlayGame(2);
        Main.getPlayer().add(p);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Ingame.fxml"));
        loader.setController(new Animated(p));
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void level3() throws Exception {
        Level.setLevel(3);
        PlayGame p = new PlayGame(3);
        Main.getPlayer().add(p);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Ingame.fxml"));
        loader.setController(new Animated(p));
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void level4() throws Exception {
        Level.setLevel(4);
        PlayGame p = new PlayGame(4);
        Main.getPlayer().add(p);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Ingame.fxml"));
        loader.setController(new Animated(p));
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void level5() throws Exception {
        Level.setLevel(5);
        PlayGame p = new PlayGame(5);
        Main.getPlayer().add(p);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Ingame.fxml"));
        loader.setController(new Animated(p));
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        level1.setDisable(true);
        level2.setDisable(true);
        level3.setDisable(true);
        level4.setDisable(true);
        level5.setDisable(true);
        int x = Main.getPlayer().getmLevel();
        if (x >= 1)
            level1.setDisable(false);
        if (x >= 2)
            level2.setDisable(false);
        if (x >= 3)
            level3.setDisable(false);
        if (x >= 4)
            level4.setDisable(false);
        if (x >= 5)
            level5.setDisable(false);
    }
}
