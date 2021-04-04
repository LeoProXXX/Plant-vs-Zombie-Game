package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class LoginScreen {
    public void show_overview(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Overview.fxml"));
        loader.setController(new Overview());
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void show_resume(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Resume_Game.fxml"));
        loader.setController(new Resume());
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void show_almanac(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Almanac.fxml"));
        loader.setController(new Almanac());
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void show_Helpmenu(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Help.fxml"));
        loader.setController(new Help());
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void exit_game(ActionEvent e) throws IOException {

        Main.serialize();
        System.exit(0);
    }

    public void show_level(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Choose_level.fxml"));
        loader.setController(new ChooseLevel());
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }
}
