package sample;


import javafx.animation.*;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
    public static int[] gridy= new int[]{90, 190, 300, 400, 500};
    public static int[] gridx= new int[]{320, 400, 480, 560, 640, 720, 800, 880, 960};
    public static Timeline suntokentimeline;
    public static Timeline zombietimertimeline;
    public static Timeline zombietimeline;
    public static PathTransition zombietimertransition;

    @FXML
    public Pane canvas;
    public static Pane canvas1;

    @FXML
    public Label points;
    public static Label points1;

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

    public static ImageView grid[][];

    public int dragcase=-1;


    public void setimageonimageview(ImageView dest, DragEvent event){
        switch (dragcase){
            case 1:
                PeaShooter p=new PeaShooter((int)dest.getLayoutX(),(int)dest.getLayoutY());
                Game.gameobjects.add(p);
                dest.setImage(p.gifimage.getImage());

            break;
            case 2:
                Sunflower s=new Sunflower((int)dest.getLayoutX(),(int)dest.getLayoutY());
                Game.gameobjects.add(s);
                dest.setImage(s.gifimage.getImage());
            break;
            case 3:
                Walnut w=new Walnut((int)dest.getLayoutX(),(int)dest.getLayoutY());
                Game.gameobjects.add(w);
                dest.setImage(w.gifimage.getImage());
            break;
            case 4:
                CherryBomb c=new CherryBomb((int)dest.getLayoutX(),(int)dest.getLayoutY());
                Game.gameobjects.add(c);
                dest.setImage(c.gifimage.getImage());
            break;
            default:
                System.out.println("no Object found");
        }
//        System.out.println(dest.getLayoutX()+" "+dest.getLayoutX());

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvas1=canvas;
        points.setText("0");
        points1=points;

        grid= new ImageView[][]{{dest00, dest01, dest02, dest03, dest04},{dest10,dest11,dest12,dest13,dest14},{dest20,dest21,dest22,dest23,dest24},{dest30,dest31,dest32,dest33,dest34},{
                dest40,dest41,dest42,dest43,dest44},{dest50,dest51,dest52,dest53,dest54},{dest60,dest61,dest62,dest63,dest64},{dest70,dest71,dest72,dest73,dest74},{dest80,dest81,dest82,dest83,dest84}};

        for(ImageView[] i: grid){
            for(ImageView j : i){
                j.setOnDragDropped(event -> {
                    setimageonimageview(j,event);
                });
            }
        }


        suntokentimeline= new Timeline(new KeyFrame(Duration.seconds(15),e-> Game.dropsuntoken()));
        suntokentimeline.setCycleCount(Animation.INDEFINITE);
        suntokentimeline.play();

        zombietimertimeline=new Timeline(new KeyFrame(Duration.seconds(10), e-> zombietimer()));
        zombietimertimeline.setCycleCount(1);
        zombietimertimeline.play();

        zombietimeline=new Timeline(new KeyFrame(Duration.seconds(5),e->{
            NormalZombie n=new NormalZombie(850,gridy[rand.nextInt(5)]-50);
            n.gifimage.relocate(900,gridy[rand.nextInt(5)]-50);
            canvas.getChildren().add(n.gifimage);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05),z->{
                n.animate();
            } ));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }));
        zombietimeline.setCycleCount(1);
        zombietimeline.play();

    }

    public static boolean checkcollision(ImageView z,ImageView p)
    {
        if(z.getBoundsInParent().getMaxX()-p.getBoundsInParent().getMaxX()<=15)
            return true;
        return false;
    }

    public void shoot() {

        /*ImageView pea =new ImageView(new Image("/Photos/Pea.png"));
        pea.relocate(640, 90);
        canvas.getChildren().add(pea);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(100), new KeyValue(pea.layoutXProperty(), zombie.getLayoutX())));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();*/
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

        zombietimertransition=new PathTransition();
        zombietimertransition.setNode(zombiehead);
        zombietimertransition.setDuration(Duration.seconds(120));
        zombietimertransition.setPath(line);
        zombietimertransition.setCycleCount(1);
        zombietimertransition.play();
    }


    public void showAlertWithDefaultHeaderText() throws Exception {
        zombietimertimeline.stop();
        suntokentimeline.stop();
        zombietimertransition.stop();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select");
        alert.setHeaderText("what do you want to do :");

        ButtonType exitbutton = new ButtonType("Exit");
        ButtonType resumebutton = new ButtonType("Resume");
        ButtonType mainmenubutton = new ButtonType("Main Menu");
        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(exitbutton, resumebutton, mainmenubutton);

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null|| option.get()==resumebutton) {
            this.gamepause.setText("Pause");
//            zombietimertimeline.play();
            suntokentimeline.play();
            zombietimertransition.play();
            
        } else if (option.get() == exitbutton) {
            System.exit(0);
        }  else if (option.get() == mainmenubutton) {
            Main.changeScene("LoginScreen.fxml");
        }
    }




    @FXML
    public void handledragdetection_plant(MouseEvent event){
        dragcase=1;
        Dragboard db= source1.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb=new ClipboardContent();
        cb.putImage(source1.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    public void handledragdetection_sunflower(MouseEvent event){
        dragcase=2;
        Dragboard db= source2.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb=new ClipboardContent();
        cb.putImage(source2.getImage());
        db.setContent(cb);
        event.consume();
    }
    @FXML
    public void handledragdetection_walnut(MouseEvent event){
        dragcase=3;
        Dragboard db= source3.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb=new ClipboardContent();
        cb.putImage(source3.getImage());
        db.setContent(cb);
        event.consume();
    }
    @FXML
    public void handledragdetection_bomb(MouseEvent event){
        dragcase=4;
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
