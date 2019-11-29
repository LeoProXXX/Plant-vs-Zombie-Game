package sample;


import javafx.animation.*;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.Optional;
import java.util.ResourceBundle;

public class animated implements Initializable {
    Random rand=new Random();

    @FXML
    public Pane canvas;

    public static Pane canvas1;

    @FXML
    public Button gamepause;

    @FXML
    public ImageView source1;
    @FXML
    public ImageView source2;
    @FXML
    public ImageView source3;
    @FXML
    public ImageView source4;

    @FXML
    public ImageView dest00;
    @FXML
    public ImageView dest01;
    @FXML
    public ImageView dest02;
    @FXML
    public ImageView dest03;
    @FXML
    public ImageView dest04;
    @FXML
    public ImageView dest10;
    @FXML
    public ImageView dest11;
    @FXML
    public ImageView dest12;
    @FXML
    public ImageView dest13;
    @FXML
    public ImageView dest14;
    @FXML
    public ImageView dest20;
    @FXML
    public ImageView dest21;
    @FXML
    public ImageView dest22;
    @FXML
    public ImageView dest23;
    @FXML
    public ImageView dest24;
    @FXML
    public ImageView dest30;
    @FXML
    public ImageView dest31;
    @FXML
    public ImageView dest32;
    @FXML
    public ImageView dest33;
    @FXML
    public ImageView dest34;
    @FXML
    public ImageView dest40;
    @FXML
    public ImageView dest41;
    @FXML
    public ImageView dest42;
    @FXML
    public ImageView dest43;
    @FXML
    public ImageView dest44;
    @FXML
    public ImageView dest50;
    @FXML
    public ImageView dest51;
    @FXML
    public ImageView dest52;
    @FXML
    public ImageView dest53;
    @FXML
    public ImageView dest54;
    @FXML
    public ImageView dest60;
    @FXML
    public ImageView dest61;
    @FXML
    public ImageView dest62;
    @FXML
    public ImageView dest63;
    @FXML
    public ImageView dest64;
    @FXML
    public ImageView dest70;
    @FXML
    public ImageView dest71;
    @FXML
    public ImageView dest72;
    @FXML
    public ImageView dest73;
    @FXML
    public ImageView dest74;
    @FXML
    public ImageView dest80;
    @FXML
    public ImageView dest81;
    @FXML
    public ImageView dest82;
    @FXML
    public ImageView dest83;
    @FXML
    public ImageView dest84;


    public void setimageonimageview(ImageView dest, DragEvent event){
        Image im=event.getDragboard().getImage();
        dest.setImage(im);
        System.out.println(dest.getLayoutX()+" "+dest.getLayoutX());
        shoot();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvas1=canvas;

        zombietimer();

        dest00.setOnDragDropped(event -> {
            setimageonimageview(dest00,event);
        });
        dest01.setOnDragDropped(event -> {
            setimageonimageview(dest01,event);
        });
        dest02.setOnDragDropped(event -> {
            setimageonimageview(dest02,event);
        });
        dest03.setOnDragDropped(event -> {
            setimageonimageview(dest03,event);
        });
        dest04.setOnDragDropped(event -> {
            setimageonimageview(dest04,event);
        });
        dest10.setOnDragDropped(event -> {
            setimageonimageview(dest10,event);
        });
        dest11.setOnDragDropped(event -> {
            setimageonimageview(dest11,event);
        });
        dest12.setOnDragDropped(event -> {
            setimageonimageview(dest12,event);
        });
        dest13.setOnDragDropped(event -> {
            setimageonimageview(dest13,event);
        });
        dest14.setOnDragDropped(event -> {
            setimageonimageview(dest14,event);
        });
        dest20.setOnDragDropped(event -> {
            setimageonimageview(dest20,event);
        });
        dest21.setOnDragDropped(event -> {
            setimageonimageview(dest21,event);
        });
        dest22.setOnDragDropped(event -> {
            setimageonimageview(dest22,event);
        });
        dest23.setOnDragDropped(event -> {
            setimageonimageview(dest23,event);
        });
        dest24.setOnDragDropped(event -> {
            setimageonimageview(dest24,event);
        });
        dest30.setOnDragDropped(event -> {
            setimageonimageview(dest30,event);
        });
        dest31.setOnDragDropped(event -> {
            setimageonimageview(dest31,event);
        });
        dest32.setOnDragDropped(event -> {
            setimageonimageview(dest32,event);
        });
        dest33.setOnDragDropped(event -> {
            setimageonimageview(dest33,event);
        });
        dest34.setOnDragDropped(event -> {
            setimageonimageview(dest34,event);
        });
        dest40.setOnDragDropped(event -> {
            setimageonimageview(dest40,event);
        });
        dest41.setOnDragDropped(event -> {
            setimageonimageview(dest41,event);
        });
        dest42.setOnDragDropped(event -> {
            setimageonimageview(dest42,event);
        });
        dest43.setOnDragDropped(event -> {
            setimageonimageview(dest43,event);
        });
        dest44.setOnDragDropped(event -> {
            setimageonimageview(dest44,event);
        });
        dest50.setOnDragDropped(event -> {
            setimageonimageview(dest50,event);
        });
        dest51.setOnDragDropped(event -> {
            setimageonimageview(dest51,event);
        });
        dest52.setOnDragDropped(event -> {
            setimageonimageview(dest52,event);
        });
        dest53.setOnDragDropped(event -> {
            setimageonimageview(dest53,event);
        });
        dest54.setOnDragDropped(event -> {
            setimageonimageview(dest54,event);
        });
        dest60.setOnDragDropped(event -> {
            setimageonimageview(dest60,event);
        });
        dest61.setOnDragDropped(event -> {
            setimageonimageview(dest61,event);
        });
        dest62.setOnDragDropped(event -> {
            setimageonimageview(dest62,event);
        });
        dest63.setOnDragDropped(event -> {
            setimageonimageview(dest63,event);
        });
        dest64.setOnDragDropped(event -> {
            setimageonimageview(dest64,event);
        });
        dest70.setOnDragDropped(event -> {
            setimageonimageview(dest70,event);
        });
        dest71.setOnDragDropped(event -> {
            setimageonimageview(dest71,event);
        });
        dest72.setOnDragDropped(event -> {
            setimageonimageview(dest72,event);
        });
        dest73.setOnDragDropped(event -> {
            setimageonimageview(dest73,event);
        });
        dest74.setOnDragDropped(event -> {
            setimageonimageview(dest74,event);
        });
        dest80.setOnDragDropped(event -> {
            setimageonimageview(dest80,event);
        });
        dest81.setOnDragDropped(event -> {
            setimageonimageview(dest81,event);
        });
        dest82.setOnDragDropped(event -> {
            setimageonimageview(dest82,event);
        });
        dest83.setOnDragDropped(event -> {
            setimageonimageview(dest83,event);
        });
        dest84.setOnDragDropped(event -> {
            setimageonimageview(dest84,event);
        });

    }

    public void shoot() {
        ImageView pea =new ImageView(new Image("/Photos/Pea.png"));
        pea.relocate(400, 460);

        ImageView zombie=new ImageView(new Image("/Photos/normal_zombie_moving.gif",100,100,false,false));
        zombie.relocate(850,rand.nextInt(450)+30);

        ImageView sunToken = new ImageView(new Image("/Photos/sunnysmile.gif", 60, 60, false, false));
        sunToken.relocate(rand.nextInt(600) + 260,10);

        canvas.getChildren().add(sunToken);
        canvas.getChildren().add(pea);
        canvas.getChildren().add(zombie);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(pea.layoutXProperty(), zombie.getLayoutX())));
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(40), new KeyValue(zombie.layoutXProperty(), 300)));
        Timeline timeline3=new Timeline(new KeyFrame(Duration.seconds(5), new KeyValue(sunToken.layoutYProperty(), 500)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        timeline2.setCycleCount(1);
        timeline2.play();
        timeline3.setCycleCount(1);
        timeline3.play();
    }

    public void zombietimer(){

        ImageView zombiehead=new ImageView(new Image("/Photos/zombiehead.png",40,40,false,false));
        canvas.getChildren().add(zombiehead);
        Line line=new Line();
        int y=20;
        int x=700;
        int xend=550;
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(xend);
        line.setEndY(y);

        PathTransition transition=new PathTransition();
        transition.setNode(zombiehead);
        transition.setDuration(Duration.seconds(60));
        transition.setPath(line);
        transition.setCycleCount(1);
        transition.play();


    }


    public void showAlertWithDefaultHeaderText() throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select");
        alert.setHeaderText("what do you want to do :");

        ButtonType exitbutton = new ButtonType("Exit");
        ButtonType resumebutton = new ButtonType("Resume");
        ButtonType mainmenubutton = new ButtonType("Main Menu");
        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(exitbutton, resumebutton, mainmenubutton);

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null) {
            this.gamepause.setText("Pause");
        } else if (option.get() == exitbutton) {
            System.exit(0);
        }  else if (option.get() == mainmenubutton) {
            Main.changeScene("LoginScreen.fxml");
        }
    }




    @FXML
    public void handledragdetection_plant(MouseEvent event){
        Dragboard db= source1.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb=new ClipboardContent();
        cb.putImage(source1.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    public void handledragdetection_sunflower(MouseEvent event){
        Dragboard db= source2.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb=new ClipboardContent();
        cb.putImage(source2.getImage());
        db.setContent(cb);
        event.consume();
    }
    @FXML
    public void handledragdetection_walnut(MouseEvent event){
        Dragboard db= source3.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb=new ClipboardContent();
        cb.putImage(source3.getImage());
        db.setContent(cb);
        event.consume();
    }
    @FXML
    public void handledragdetection_bomb(MouseEvent event){
        Dragboard db= source4.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb=new ClipboardContent();
        cb.putImage(source4.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    public void handledragover(DragEvent event){
        if(event.getDragboard().hasImage()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
}
