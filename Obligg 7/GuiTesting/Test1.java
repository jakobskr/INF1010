//package buttonsample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;


public class Test1 extends Application {

  public static void main(String[] a) {
    launch(a);
  }

   @Override
 public void start(Stage vindu) throws Exception {
   BorderPane ting = new BorderPane();
   Scene scene = new Scene(ting, 900, 700, Color.BLACK);
   vindu.setScene(scene);
   vindu.show();
   Text topTekst = new Text("Hola");
   topTekst.setFont(new Font(50));
   vindu.setTitle("Et tomt 900 x 700-vindu");
   ting.setCenter(topTekst);
   ting.setLeft(vBoxMedTekst());
   ting.setTop(nyHBox());

 }


 public HBox nyHBox() {
 HBox hbox = new HBox();
 hbox.setPadding(new Insets(15, 12, 15, 12)); // t, r b, l
 hbox.setSpacing(10); // Avstand mellom nodene
 hbox.setStyle("-fx-background-color: #336699;");
 Button knapp1 = new Button("Forelest");
 knapp1.setPrefSize(100, 20);
 Button knapp2 = new Button("Gjenstår");
 knapp2.setPrefSize(100, 20);
 Button knapp3 = new Button("Trixoppgaver");
 knapp3.setPrefSize(130, 20);
 Button knapp4 = new Button("Innleveringsoppgaver");
 knapp4.setPrefSize(200, 20);
 hbox.getChildren().addAll(knapp1, knapp2, knapp3, knapp4);

 return hbox;
}

private VBox vBoxMedTekst() {

VBox vbox = new VBox();
vbox.setPadding(new Insets(10)); // Setter alle sider til 10
vbox.setSpacing(8); // Avstand mellom nodene (elementene)
Text title = new Text("INF1010 temaer");
title.setFont(Font.font("Comic Sans", FontWeight.BOLD, 14));
vbox.getChildren().add(title);

Text t = new Text("JavaFX is a software platform");
vbox.getChildren().add(t);
t = new Text("for creating and delivering desktop");
vbox.getChildren().add(t);
t = new Text("applications, as well as rich internet");
vbox.getChildren().add(t);
t = new Text("applications (RIAs) that can run");
vbox.getChildren().add(t);
t = new Text("across a wide variety of devices.");
vbox.getChildren().add(t);
t = new Text("JavaFX is intended to replace");
vbox.getChildren().add(t);
t = new Text("Swing as the standard GUI library");
vbox.getChildren().add(t);
t = new Text("for Java SE, but both will be included");
vbox.getChildren().add(t);
t = new Text("for the foreseeable future.");
vbox.getChildren().add(t);

return vbox;
}
}
