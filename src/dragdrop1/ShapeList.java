/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragdrop1;

/**
 *
 * @author Mark
 */


import java.util.ArrayList;
import javafx.scene.shape.Shape;

public class ShapeList {
    
     private ArrayList<Shape> list;
     
     public ShapeList(){
        this.list = new ArrayList<>();
         
     }
     
     public void add(Shape s){
         list.add(s);
     }
     
     public void update(Shape s){
         
     }
     
    
}
