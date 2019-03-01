
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class beta {
  public static void main(String args[]) throws FileNotFoundException {

        //instead of a try/catch, you can throw the FileNotFoundException.

        //This is generally bad behavior


        File text = new File("data.txt");
        // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"


        //inf stands for the input file
        String line="";
        Scanner inf = new Scanner(text);
        while(inf.hasNextLine()){
            line+=inf.nextLine()+"\n";
            //System.out.println(line);//hopefully you can do other things with the line
        }
        System.out.println(line);
        char[]data=new char[line.length()];
        for(int i=0;i<data.length;i++){
          data[i]=line.charAt(i);
        }
        for(int i=0;i<data.length;i++){
        System.out.print(data[i]);
        }
    }
}
