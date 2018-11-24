/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragdrop1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.shape.Shape;

/**
 *
 * @author Mark
 */
public class Printer {

    File htmlTemplateFile;
    BufferedWriter bw;

    public Printer() {

    }

    public void createFile() throws IOException {
        htmlTemplateFile = new File("template.html");
        bw = new BufferedWriter(new FileWriter(htmlTemplateFile));

    }

    public void printObj(Object obj) {

    }

    void readList(ArrayList<MyRectangle> list) {
        System.out.println("reading...");
        for(int x =0; x<list.size();x++)
        {
            System.out.println(list.get(x).toString() + ", " + list.get(x).getIntId()+" X: "+ list.get(x).getXcoord()+ " Y: "+ list.get(x).getYcoord());
        }
    }

}
