package Chapter12.Practice;

import java.io.*;

public class FilteringData {
    static void main() throws FileNotFoundException {
        try(BufferedReader b1 = new BufferedReader(new FileReader("src/Chapter12/Practice/sales.txt"));){
            String Line;
            while ((Line = b1.readLine())!=null){
                String [] revert = Line.split(",");
                String name = revert[0];
                int value = Integer.parseInt(revert[1]);
                if (value>=1000){
                    System.out.println(name+" -> "+value);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
