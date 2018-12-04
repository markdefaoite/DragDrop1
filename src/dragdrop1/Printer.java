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
        
        System.out.println("pushToFile()");
        
        int subIdentifierCounter = 0;
        char identifier = 'A', subIdentifier = 'A';
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader("template.html"));
            writer = new FileWriter("template2.html");
            String line = reader.readLine();
            String componentIntialize = "", componentDeclare = "", componentUpdate = "";


            for (int i = 0; i < list.size(); i++) {
                componentDeclare += " var myGamePiece" + identifier + subIdentifier + "; \n";

                componentIntialize += "myGamePiece" + identifier + subIdentifier + " = new component(" + list.get(i).getWidth() + ", " + list.get(i).getHeight() + ",\"red\", "
                        + list.get(i).Xcoord + ", " + list.get(i).Ycoord + ");" + "\n";

                componentUpdate += "myGamePiece" + identifier + subIdentifier + ".update(); \n";
                
                subIdentifierCounter++;
                if(subIdentifierCounter > 25)
                {
                    subIdentifierCounter = 0;
                    subIdentifier = 'A';
                    identifier++;
                }
                else
                    subIdentifier++;
            }

            if (line == null) {
                System.out.println("NULL file");
            } else {
                while (line != null) {
                    
                    if (line.equals("<!-- component declare -->")) {
                        System.out.println(line + "\n" + componentDeclare);
                        writer.append(componentDeclare + "\n");

                    } else if (line.equals("<!-- component intialize --> ")) {
                        System.out.println(line + "\n" + componentIntialize);

                        writer.append(componentIntialize + "\n");

                        
                    } else if (line.equals("<!-- component update -->")) {
                        System.out.println(line + "\n" + componentUpdate);
                        writer.append(componentUpdate + "\n");
                    } else {
                        writer.append(line + "\n");
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
