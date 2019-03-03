import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.
      When the file is not found then:
         throw a FileNotFoundException

      You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      You ma also assume the maze has a border of '#' around the edges.
      So you don't have to check for out of bounds!
    */
    public Maze(String filename) throws FileNotFoundException{
    	animate=false;
        File text = new File(filename);
        String line="";
        Scanner inf = new Scanner(text);
        int length=0;// future rows of char
        int size=inf.nextLine().length();// future cols of char
        while(inf.hasNextLine()){
            line+=inf.nextLine();
            length++;
        }
        maze=new char[length][size];
        for(int i=0;i<maze.length;i++){
           for(int j=0;j<size;j++) {
        	   maze[i][j]=line.charAt(i*size+j);
           }
        }
        //System.out.println(Arrays.deepToString(maze));

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





   /*Return the string that represents the maze.
     It should look like the text file with some characters replaced.
    */
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


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
 //   public int solve(){
            //find the location of the S.

            //erase the S

            //and start solving at the location of the s.
            //return solve(???,???);
   // }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        return -1; //so it compiles
    }
    public static void main(String[]args) {
    	try {
    	Maze mazes=new Maze("data.txt");

    	System.out.println(mazes);
    	}
    	catch(FileNotFoundException e) {
    		System.out.println("yeah");
    	}
    }


}
