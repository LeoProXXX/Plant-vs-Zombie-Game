package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Resume implements Initializable {

    @FXML
    ChoiceBox games;

    public void back_login(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../LoginScreen.fxml"));
        loader.setController(new LoginScreen());
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    public void show_ingame() throws Exception {
        String x = games.getValue().toString();
        ArrayList<PlayGame> y = Main.getPlayer().getList();
        PlayGame p = null;
        for (PlayGame t : y) {
            if (t.equals(x))
                p = t;
        }
        Level.setLevel(p.getLevel());
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Ingame.fxml"));
        loader.setController(new Animated(p));
        Main.root = loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<PlayGame> x = Main.getPlayer().getList();
        String a[] = new String[x.size()];
        for (int i = 0; i < x.size(); i++)
            a[i] = x.get(i).toString();
        games.setItems(FXCollections.observableArrayList(a));
    }
}
