import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.*;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.text.*;
import javafx.scene.input.MouseEvent;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



public class GuiLabyrint extends Application implements EventHandler<KeyEvent>{
  private Labyrint lab = null;
  private Scene scene;
  private BorderPane pane;
  private GridPane grid;
  private int index;
  private int size;
  private Text utekst, indekstekst, langtekst;
  private MediaPlayer player;
  GuiRute[][] rects;
  ArrayList<Stabel<Rute>> utveier;
  public static void main(String[] args) {
    launch();
  }

  public void start(Stage vindu) throws Exception{
    index = 0;
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    fileChooser.setTitle("Choose which maze you want to solve!");
    fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
    while(true) {
      try {
        File selectedFile = fileChooser.showOpenDialog(vindu);
        lab = Labyrint.lesFraFil(selectedFile);
        break;
      }
      catch(Exception e) {
        System.out.println("ulk");
      }
    }
      rects = new GuiRute[lab.getHeight()][lab.getWidth()];
      pane = new BorderPane();
      pane.setStyle("-fx-background-color: #336699;");
      grid = addGridPane(lab);
      pane.setCenter(grid);
      pane.setLeft(addVBox());
      pane.setTop(addHBox());
      scene = new Scene(pane, 1000, 1000, Color.RED);
      vindu.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> handle(event));
      vindu.setScene(scene);
      String path = GuiLabyrint.class.getResource("/Snow.mp3").toString();
      player = new MediaPlayer(new Media(path));
      player.setAutoPlay(true);
      vindu.show();
    }

    //lager HBoxen som holder tekstene til programmet
    private HBox addHBox() {
      HBox hbox = new HBox();
      hbox.setPadding(new Insets(5, 0, 0, 5)); // t, r b, l
      hbox.setStyle("-fx-background-color: #336699;");
      hbox.setSpacing(40);
      utekst = new Text("Antall utveier: ");
      utekst.setFont(new Font(38));
      indekstekst = new Text("");
      indekstekst.setFont(new Font(38));
      langtekst = new Text("");
      langtekst.setFont(new Font(38));
      hbox.getChildren().addAll(utekst,indekstekst,langtekst);
      return hbox;
    }

    //lager VBox som holder knappene til programmet
      private VBox addVBox() {
      BackgroundSize backgroundSize = new BackgroundSize(size, size, true, true, true, false);
      VBox vbox = new VBox();
      vbox.setPadding(new Insets(30, 0, 30,10)); // t, r b, l
      vbox.setSpacing(25);
      Button nestevei = new Button("Neste utvei");
      nestevei.setPrefSize(100, 20);
      Button forrigevei = new Button("Forrige utvei");
      forrigevei.setPrefSize(100, 20);
      Button visKorteste = new Button("Korteste utvei");
      visKorteste.setPrefSize(100, 20);
      Button visLengste = new Button("Lengste utvei");
      visLengste.setPrefSize(100, 20);
      Button visTilfeldig = new Button("Tilfeldig utvei");
      visTilfeldig.setPrefSize(100, 20);
      Button butwhy = new Button("...");
      visTilfeldig.setPrefSize(100, 20);
      vbox.getChildren().addAll(nestevei, forrigevei, visKorteste, visLengste, visTilfeldig, butwhy);

      nestevei.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        if (utveier == null || index + 1 >= utveier.size() || utveier.size() == 0) {
          return;
        }
        index++;
        tegnUtveier();
      }
      });

      visKorteste.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        if (utveier == null || utveier.size() == 0) {
          return;
        }
        int teller = utveier.get(0).storrelse();
        for (Stabel<Rute> stabel: utveier) {
          if (stabel.storrelse() <= teller) {
            teller = stabel.storrelse();
            index = utveier.indexOf(stabel);
          }
        }
        tegnUtveier();
      }
      });

      visLengste.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        if (utveier == null || utveier.size() == 0) {
          return;
        }
        int teller = utveier.get(0).storrelse();
        for (Stabel<Rute> stabel: utveier) {
          if (stabel.storrelse() > teller) {
            teller = stabel.storrelse();
            index = utveier.indexOf(stabel);
          }
        }
        tegnUtveier();
      }
      });

      butwhy.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        ArrayList<Image> bilder = getWaifus();
        // new Image(url)
        int ran = (int) (Math.random() * (bilder.size()));
        BackgroundImage backgroundImage = new BackgroundImage(bilder.get(ran), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // new Background(images...)
        Background background = new Background(backgroundImage);
        if (utveier == null || index  >= utveier.size() || utveier.size() == 0) {
          return;
        }

        for (Rute r: utveier.get(index)) {
          rects[r.getY() - 1][r.getX() - 1].setbakgrunn(background);
        }
      }
      });

      forrigevei.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        if (utveier == null || index - 1 < 0 || utveier.size() == 0) {
          return;
        }
        index--;
        tegnUtveier();
      }
      });

      visTilfeldig.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        if (utveier == null || utveier.size() == 0) {
          return;
        }
        index = (int) (Math.random() * (utveier.size()));
        tegnUtveier();
      }
      });

      return vbox;
    }

    //lager et gridpane, lagrer rutene og putter dem inn i et 2d Array
    private GridPane addGridPane(Labyrint lab) {
        GridPane grid = new GridPane();
        if (lab.getHeight() == lab.getWidth() || lab.getHeight() > lab.getWidth()) {
          size = 800/lab.getHeight();
        }
        else  {
          size = 800/lab.getWidth();
        }
        grid.setPadding(new Insets(30, 10, 10, 10));
        Rute rute = null;
        for(int i = 0; i < lab.getHeight(); i++){
          for(int j = 0; j < lab.getWidth(); j++){
            rute = lab.hentRute(j + 1,i +1);
            GuiRute rect;
            if (rute instanceof SortRute) {
              rect = new GuiRute(size,false,j,i);
            }
            else{
              rect = new GuiRute(size,true,j,i);

            }
            grid.add(rect,j,i);
            rects[i][j] = rect;
          }
        }
        return grid;
      }

      //lukker programmet naar brukeren presser esc
      @Override
    	public void handle(KeyEvent event) {
    		KeyCode code = event.getCode();
    		if (code == KeyCode.ESCAPE) {
    			System.exit(0);
    		}
    	}

      public void tegnUtveier() {

        //setter rutenes farge til den originale fargen
        for (GuiRute[]  rad: rects) {
          for (GuiRute rute: rad) {
            rute.nullstillFarge();
          }
        }

        if (utveier.size() == 0) {
          utekst.setText("Ingen Utveier");
          indekstekst.setText("");
          langtekst.setText("");
          return;
        }

        utekst.setText("Antall utveier " + utveier.size());
        indekstekst.setText("Viser vei nr " + (index + 1));
        langtekst.setText("Veien er " + utveier.get(index).storrelse() + " ruter lang");
        for (Rute r: utveier.get(index)) {
          rects[r.getY() - 1][r.getX() - 1].setRed();
        }
      }

      private class GuiRute extends Pane {
        boolean hvit = true;
        int x,y;
        public GuiRute(int storrelse, boolean hvit, int x, int y) {
          setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
            null, new BorderWidths(1))));
          setMinWidth(storrelse);
          setMinHeight(storrelse);
          this.hvit = hvit;
            if(hvit) {
              setBackground(new Background(
                  new BackgroundFill(Color.WHEAT, null, null)));
                addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                  utveier = lab.finnUtveiFra(x + 1,y + 1);
                  index = 0;
                  tegnUtveier();
                }
                });
            }

            else {
              setBackground(new Background(
                  new BackgroundFill(Color.BLACK, null, null)));
               }

        }

        public void nullstillFarge() {

            if(hvit) {
                setBackground(new Background(
                    new BackgroundFill(Color.WHEAT, null, null)));
            }

            else {
                setBackground(new Background(
                    new BackgroundFill(Color.BLACK, null, null)));
            }
        }

        public void setRed() {
          setBackground(new Background(
              new BackgroundFill(Color.web("0x990000"), null, null)));
        }

        public void setbakgrunn(Background background) {
          setBackground(background);
        }
    }

    public ArrayList<Image> getWaifus() {
      ArrayList<Image> waifs = new ArrayList<Image>();
      String s;
      for (int w = 1;w < 4 ; w++) {

        waifs.add(new Image("waif" + w + ".jpg"));
      }
      return waifs;
    }

}
