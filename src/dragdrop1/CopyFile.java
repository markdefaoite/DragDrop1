/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragdrop1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * @author Mark
 */
public class CopyFile {
    
    FileChannel src;
    FileChannel dest;
    public CopyFile()
    {
        
    }
    
    /**
     *
     * @param sfile1
     * @param sfile2
     * @throws FileNotFoundException
     */
    public void copy(String sfile1, String sfile2) throws FileNotFoundException, IOException
    {
        File file1 = new File(sfile1);
        File file2 = new File(sfile2);
        
        
        src = new FileInputStream(file1).getChannel();
        dest = new FileOutputStream(file2).getChannel();
         dest.transferFrom(src, 0, src.size());
    }
    
    
}
