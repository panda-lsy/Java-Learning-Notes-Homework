package Chapter12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args){
    //open file to write using Filewriter class
    //write meesage into the text file.
        String s1 ="ABC";
        try(FileWriter fw = new FileWriter("src/Chapter12/output2.txt")){
            fw.write(s1);
    }
        catch(IOException e){
        System.out.println("File write error");
    }

}
} 