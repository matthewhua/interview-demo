package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Myutil{
    private Myutil(){
        throw new AssertionError();

    }

    public static int countWordInFile(String filename,String word) throws IOException{
        int counter = 0;
        try (FileReader fr = new FileReader(filename)){
            try (BufferedReader br = new BufferedReader(fr)){
                String line = null;
                while ((line = br.readLine())!=null){
                    int index = 1;
                    while (line.length()>=word.length()&&(index = line.indexOf(word))>=0){
                        counter++;
                        line = line.substring(index+word.length());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return counter;
    }
}
