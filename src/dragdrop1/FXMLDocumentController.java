/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragdrop1;

import static java.awt.Color.BLUE;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.DODGERBLUE;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Mark
 */
public class FXMLDocumentController implements Initializable, Cloneable {

    @FXML
    private AnchorPane myCanvas;
    @FXML
    private Rectangle Square;
    @FXML
    private Circle Circle;
    @FXML
    private Polygon Triangle;
    @FXML
    private Button CButton;

    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

  
    @FXML
    private void createButton(ActionEvent event) {

        Rectangle x = new Rectangle();

        x.setHeight(Square.getHeight());
        x.setWidth(Square.getWidth());
        x.setFill(DODGERBLUE);

        x.setOnMouseReleased((MouseEvent e) -> {
            Node n = (Node) e.getSource();
            Bounds b = n.getBoundsInParent();

            System.out.println("X: " + b.getMaxX() + "Y: " + b.getMaxY());

            e.consume();
        });

        /*
        x.setOnMouseReleased((MouseEvent e) -> {
            System.out.println("X: " + e.getX() + "Y: " + e.getY());
        }); */
        x.setOnMouseDragged((MouseEvent e) -> {
            Node n = (Node) e.getSource();
            n.setTranslateX(n.getTranslateX() + e.getX());
            n.setTranslateY(n.getTranslateY() + e.getY());

            e.consume();
        });

        myCanvas.getChildren().add(x);

    }

    @FXML
    private void mouseDrag(MouseEvent event) {
        Node n = (Node) event.getSource();
        n.setTranslateX(n.getTranslateX() + event.getX());
        n.setTranslateY(n.getTranslateY() + event.getY());

    }

    @FXML
    private void PrintCoords(MouseEvent event) {

        System.out.println("X: " + event.getSceneX() + " Y: " + event.getSceneY());
        System.out.println();
        System.out.println("X: " + event.getScreenX() + " Y: " + event.getScreenY());

        Node n = (Node) event.getSource();
        System.out.println("X of N: " + n.getLayoutX() + " Y of N: " + n.getLayoutY() + "\n");

        Bounds b = n.getBoundsInParent();

        System.out.println("X Bounds: " + b.getMinX() + " Y Bounds: " + b.getMaxY() + "\n");

    }

    @FXML
    private void makeSquare(MouseEvent event) {
        System.out.println("makeSquare");
        Rectangle x = new Rectangle();

        x.setHeight(Square.getHeight());
        x.setWidth(Square.getWidth());
        x.setFill(DODGERBLUE);

        x.setOnMouseReleased((MouseEvent e) -> {
            Node n = (Node) e.getSource();
            Bounds b = n.getBoundsInParent();

            System.out.println("X: " + b.getMaxX() + "Y: " + b.getMaxY());

            e.consume();
        });

        /*
        x.setOnMouseReleased((MouseEvent e) -> {
            System.out.println("X: " + e.getX() + "Y: " + e.getY());
        }); */
        x.setOnMouseDragged((MouseEvent e) -> {
            Node n = (Node) e.getSource();
            n.setTranslateX(n.getTranslateX() + e.getX());
            n.setTranslateY(n.getTranslateY() + e.getY());

            e.consume();
        });

        myCanvas.getChildren().add(x);

    }

    @FXML
    private void printFile(ActionEvent event) throws IOException {
        Printer printer = new Printer();
        
        printer.createFile();
        
    }

    @FXML
    private void createOnClick(MouseEvent event) {
    }

    

}
