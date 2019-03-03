import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class Maze{

    private char[][]maze;
    private int[][]moves;
    private boolean animate;//false by default

    public Maze(String filename) throws FileNotFoundException{
    	animate=false;
        File text = new File(filename);
        String line="";
        Scanner inf = new Scanner(text);
        int length=0;// future rows of char
        int size=inf.nextLine().length();// future cols of char
        Scanner newInf= new Scanner(text);
        while(newInf.hasNextLine()){
            line+=newInf.nextLine();
            length++;
        }
        maze=new char[length][size];
        for(int i=0;i<maze.length;i++){
           for(int j=0;j<size;j++) {
        	   maze[i][j]=line.charAt(i*size+j);
           }
        }
        moves=new int[4][2];
        moves[0][0]=0;
        moves[0][1]=1;
        moves[1][0]=0;
        moves[1][1]=-1;
        moves[2][0]=1;
        moves[2][1]=0;
        moves[3][0]=-1;
        moves[3][1]=0;
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    public String toString(){
            String result="";
            for(int i=0;i<maze.length;i++) {
            	for(int j=0;j<maze[0].length;j++) {
            		result+=maze[i][j];
            	}
            	result+="\n";
            }
            return result;
    }



   public int solve(){
        int []result=find();
        maze[result[0]][result[1]]=' ';
        return solve(result[0],result[1],0,true);

   }



    private int[] find(){
      int[]result=new int[2];
      for(int i=0;i<maze.length;i++){
        for(int j=0;j<maze[0].length;j++){
          if(maze[i][j]=='S'){
            result[0]=i;
            result[1]=j;
            return result;
          }
        }
      }
      return result;
    }
    private int solve(int row,int col,int count,boolean go){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }
        if(maze[row][col]=='E'){
          return count;
        }
        else if(maze[row][col]=='#'|| maze[row][col]=='@'){
          go=false;
          return -1;
        }
        else if(maze[row][col]==' '){
          go=true;
        }
      if(go==true){
        maze[row][col]='@';
        for(int i=0;i<moves.length;i++){
          int result=solve(row+moves[i][0],col+moves[i][1],count+1,true);
           if(result>-1){
             return result;
           }
        }
      }
  maze[row][col]='.';
        return -1; //so it compiles
    }



}
