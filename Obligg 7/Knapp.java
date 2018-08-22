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

public class Knapp extends Rectangle {

  private int x,y;
  public Knapp(int x, int y, Double height, double width) {
    super(height, width);
    this.x = x;
    this.y = y;
  }
}
