import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class Driver{
  public static void main(String[]args){
    try{
    Maze test=new Maze("data2.txt");
    test.setAnimate(true);
    System.out.println(test.solve());
    System.out.println(test);
  }
  catch(FileNotFoundException e){
    System.out.println("file doesn't exist");
  }
  }
}
