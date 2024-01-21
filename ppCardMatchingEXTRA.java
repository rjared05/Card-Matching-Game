import com.phidget22.*;          // Imports everything used in the code.
import java.util.Scanner;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.*;
import javax.swing.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import java.io.*;
import java.util.Random;
import java.awt.Robot;

public class ppCardMatchingEXTRA
{
   private int row;     // Declare variables.
   private int column;
   
   private int rRow;
   private int rColumn;
   
   private boolean reused = false;
   private String Tt;
   private String[] Tests = new String[18];
   int t = 0;
   int bad = 0;
   
   public ppCardMatchingEXTRA()
   {
      row = 0;       // Creating an object of this class intializes these int values to 0.
      column = 0;
      
      rRow = 0;
      rColumn = 0;
   }
   
   public void rcRandom()
   // This method serves the purpose of creating random row and column values for the cards...
   // ... (without reusing the values created before).
   {
      reused = false;
      // 'reused' holds the boolean value of whether or not a row and column value has been...
      // ...initialized yet.
   
      Random r1, r2;       
      r1 = new Random();
      r2 = new Random();
      // Random objects for generating these numbers within the confines of the rows and...
      //...columns used in the GridPane.
   
      while(!reused)
      {
         rRow = r1.nextInt(row);       
         rColumn = r2.nextInt(column);
         // Creates random values...
      
         //
         System.out.println("rcRandom... rRow: "+rRow+", rColumn: "+rColumn);
         //
         
         reused = this.test();
         // Calls test() method.
      }
   }
   public boolean test()
   // This method tests whether or not a row and column value has been initialized yet...
   // ...while there are still card values to assign.
   {  
      if(t != 18)
      // 't' is an int value for keeping track of how many row and column values...
      // ...have been created. When the number is reached there are no more assignments.
      {
         Tt = " "+rRow+rColumn;
         // Takes the random row and column values and puts them in a string to be...
         ///...tested for being a repeat.
         
         for(int i = 0; i < 18; i++)
         // Goes through 'Tests[]', which stores the row and column values that...
         // ...aren't repeated, and compares it to the current...
         // ...row and column being tested for repetition.
         {                              
            if(Tt.equals(Tests[i]))    
            {
               bad = 1;
               // If the row and column are repeats. It sets 'bad' to 1, an...
               // ...indication that it's a repeat.
            }
         }
         
         if(bad != 1)
         // When 'bad' isn't 1, it adds the row and column to the...
         // ...test array, showing that it's not a repeat.
         // It then gets ready for the next array addition and returns test() as true.
         {                     
            Tests[t] = Tt;
            t++;
            
            return true;
         }
      }
      
      bad = 0;
      // Resets 'bad' for the next test of repetition.
      
      return false;
      // Returns test() as false.
   }
   
   public void setRow(int r)
   // This method sets the row amount for the rcRandom() method and general class. 
   // It is the row amount for the card game.
   {
      row = r;
   }
   public void setColumn(int c)
   // This method sets the column amount for the rcRandom() method and general class. 
   // It is the column amount for the card game.
   {
      column = c;
   }
   
   public int getRow()
   // Returns a good, non-repeated row value for a card.
   {
      return rRow;
   }
   public int getColumn()
   // Returns a good, non-repeated column value for a card.
   {
      return rColumn;
   }
   
}
