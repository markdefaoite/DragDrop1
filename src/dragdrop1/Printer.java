/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragdrop1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        htmlTemplateFile = new File("template3.html");
        bw = new BufferedWriter(new FileWriter(htmlTemplateFile));

    }

    public void printObj(Object obj) {

    }

    public String readList(ArrayList<MyRectangle> list) {
        System.out.println("reading...");
        String s = "";
        for (int x = 0; x < list.size(); x++) {
            s += list.get(x).getIntId() + " X: " + list.get(x).getXcoord() + " Y: " + list.get(x).getYcoord();
        }
        return s;
    }

    void pushToFile(ArrayList<MyRectangle> list) {
        //File file = new File("template.html");
        System.out.println("pushToFile()");
        String content = "";
        int x = 0;
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader("template.html"));
            writer = new FileWriter("template2.html");
            String line = reader.readLine();
            String newContent = "";
//            bw.write(line);
            //newContent = "myGamePiece = new component(30, 30, \"red\", 10, 120);" + "\n";
            
            for(int i =0; i< list.size();i++){
                newContent += "myGamePiece = new component("+list.get(i).getWidth()+", "+list.get(i).getHeight()+",\"red\", "
                        +list.get(i).Xcoord +", "+ list.get(i).Ycoord+");" + "\n";
            }
            
            
            if (line == null) {
                System.out.println("NULL file");
            } else {
                while (line != null) {
                    x++;
                    System.out.println(x);
                    //System.out.println(line);
                    if (line.equals("<!-- Xcomponent --> ")) {
                        writer.append(newContent + "\n");
                        
                        System.out.println(line);
                    } else {
                        writer.append(line + "\n");
                        
                        //System.out.println(line);
                    }

                    line = reader.readLine();
                }
            }
            writer.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
