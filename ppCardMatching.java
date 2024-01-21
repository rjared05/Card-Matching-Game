// Jared Reese

/*
  Dr. Phelps/Liu has allowed students to discuss the algorithm 
  and/or general concepts about the assignment with other students
   and to receive limited help on specific topics. However, I 
	assume full responsibility for the content and integrity of 
	this assignment. I have developed my own solution to this 
	assigned project. I have not used or copied (by any means) 
	another’s work (or portions of it) in order to represent it 
	as my own including material from the internet. If I used a 
	common computer, I have remembered to delete the files and 
	empty the recycle bin. I have destroyed all extra printouts 
	of my code. I have not shared my code with anyone. I am sole 
	author of the assignment; however,

I received outside help from the following people:

 ......

These are the websites that I used as reference
*/

import com.phidget22.*;                   // Importing everything utilized.
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
import java.util.Timer;
import java.util.TimerTask;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.animation.*;
import java.util.Date;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.*;
import javafx.scene.robot.Robot;
import javax.swing.JButton.*;
import javafx.scene.input.MouseButton;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;

public class ppCardMatching extends Application
{
   Stage tempStage;           // Defining numerous variables used in the code!
   Stage primaryStage;
   Scene scene;

   Timer timer;

   Button b1;
   Button b2;
   Button b3;
   int matchCount = 0;
   
      boolean checkMatch = false;
      int c;
      int fCardRow = 10;
      int fCardCol = 10;
      int fCard = 10;
      boolean two = false;
      Button[] matchBts = new Button[18];
      int m = 0;
      Button testmB1, testmB2;
      int saveimg;
      ImageView[] spadeSview1 = new ImageView[18];
      ImageView[] spadeSview2 = new ImageView[18];
      ImageView[] spadeSview3 = new ImageView[18];
      int spadeimgnum1 = 0;
      int spadeimgnum2 = 0;
      boolean bothmatch1 = false;
      boolean bothmatch2 = false;
      boolean bm = false;

    ImageView[] ppV = new ImageView[18];
    ImageView ppViewer, ogPP;
    Button[][] buttons = new Button[3][6]; 
    Image[] ppCard = new Image[6];
    
    int[] flipRow = new int[18];
    int[] flipCol = new int[18];
    int[] flipCard = new int[18];
   
    Label score;
    String highScore = "Fastest Finish Time: 0:00";
    int lastMinutes = 0;
    int lastSeconds = 0;
   
    StringBuilder TIME;
    Timer timey;
    Label timerlabel;
    Timeline animation;
    final Integer startTime = 2;
    int minutes = startTime;
    int seconds;
   
    int randSong1;
    Random r1;
    File[] soundFiles1 = new File[5];
    Media media1;
    MediaPlayer player1;
   
    int randSong2;
    Random r2;
    File[] soundFiles2 = new File[5];
    Media media2;
    MediaPlayer player2;
   
    File[] soundFiles3 = new File[3];
    Media[] media3 = new Media[3];
    MediaPlayer[] player3 = new MediaPlayer[3];
    
    int randSong3;
    Random r3;
    File[] soundFiles4 = new File[5];
    Media media4;
    MediaPlayer player4;
    
      static ppCardMatchingSCENE newScene;
      Button newgame;
      
      StackPane root;
      
      double[][] xButtonPos = new double[3][6];
      double[][] yButtonPos = new double[3][6];
      
      static Robot robot = new Robot();
      
      static ppCardMatchingSCENE unstatic = new ppCardMatchingSCENE();     
      // A static object of the class ppCardMatchingSCENE is created here.
      // It's used to obtain all the card (and scene) data for the phidgets to utilize.
            
            int BProw = 0;
            int BPcol = 0;

   public static void main(String[]args) throws Exception
   {   
/*
      VoltageRatioInput voltageRatioInput0 = new VoltageRatioInput();
      voltageRatioInput0.setChannel(5);      
      // Creating the phidgets in the code.
      // I created objects for the VoltageRatioInput of the touch sensor and joystick.
      // I also set their channels. I also created an LCD object.
      
      VoltageRatioInput voltageRatioInput2 = new VoltageRatioInput();
      VoltageRatioInput voltageRatioInput3 = new VoltageRatioInput();
      LCD lcd0 = new LCD();
   
      voltageRatioInput2.setChannel(6);
      voltageRatioInput3.setChannel(7);
   
      voltageRatioInput0.addSensorChangeListener(
         new VoltageRatioInputSensorChangeListener()
         {
            public void onSensorChange(VoltageRatioInputSensorChangeEvent e)     
            // Here I created a method that would sense when the touch sensor is touched.
            
            {
               if(e.getSensorValue()>0.50)
               {
                  System.out.println("Clicked! " +e.getSensorValue());           
                  // When the touch sensor is touched, it flips a card in the matching game.
                  // It also makes "Card get!!!" appear on the LCD.
                  
                  try                                                            
                  {
                   lcd0.writeText(com.phidget22.LCDFont.DIMENSIONS_5X8, 0, 0, "Card get!!!");
                     lcd0.flush();
                  
                        Platform.runLater(new Runnable()
                        {
                           @Override
                           public void run()
                           {
                              unstatic.click(); 
                              // This method initiates the card flip through a Robot...
                              // ...object and mouse event. 
                              // The touch sensor simulates a mouse click.           
                           }                                      
                        });
                  }
                  
                  catch(Exception ex)
                  {
                     System.out.println("error");
                     // If an error were to occur, you...
                     // ...would see the console print out "error."                 
                  }
               }
            }
         });
      
      
      voltageRatioInput2.addSensorChangeListener(
         new VoltageRatioInputSensorChangeListener()
         {
            public void onSensorChange(VoltageRatioInputSensorChangeEvent e)     
            // Here I created a method that would sense when the joystick is...
            // ...pointed left or right.
            
            {
               if(e.getSensorValue()>0.8)
               {
                  System.out.println("Go left! " +e.getSensorValue());           
                  // When the joystick is pointed left, the...
                  // ...cursor moves to the card on the left.
                  // It also makes "Went left!!" appear on the LCD.
                  
                  try                                                            
                  {
                   lcd0.writeText(com.phidget22.LCDFont.DIMENSIONS_5X8, 0, 0, "Went left!!");
                     lcd0.flush();
                     
                        Platform.runLater(new Runnable()
                        {
                           @Override
                           public void run()
                           {
                              unstatic.goLEFT();                  
                             // This method initiates the cursor moving to the left through...
                              // ...a Robot object and mouse event.
                              // The joystick is used to simulate mouse movement.
                           }                                      
                        });
                  }
                  catch(Exception ex)
                  {
                     System.out.println("error");
                  }
               }
               else if(e.getSensorValue()<-0.8)
               {
                  System.out.println("Go right! " +e.getSensorValue());          
                  // When the joystick is pointed right, the cursor moves...
                  // ...to the card on the right.
                  // It also makes "Went right!" appear on the LCD.
                  
                  try                                                            
                  {
                   lcd0.writeText(com.phidget22.LCDFont.DIMENSIONS_5X8, 0, 0, "Went right!");
                     lcd0.flush();
                     
                        Platform.runLater(new Runnable()
                        {
                           @Override
                           public void run()
                           {
                              unstatic.goRIGHT();                 
                            // This method initiates the cursor moving to the left through a...
                            // ...Robot object and mouse event.
                           }
                        });
                  }
                  catch(Exception ex)
                  {
                     System.out.println("error");
                  }
               }
            }
         });
   
         voltageRatioInput3.addSensorChangeListener(
            new VoltageRatioInputSensorChangeListener()
            {
               public void onSensorChange(VoltageRatioInputSensorChangeEvent e)  
          // Here I created a method that would sense when the joystick is pointed up or down.
               
               {
                  if(e.getSensorValue()>0.8)
                  {
                     System.out.println("Go up! " +e.getSensorValue());          
                   // When the joystick is pointed up, the cursor moves to the card on the up.
                     // It also makes "Went up!!!!" appear on the LCD.
                     
                     try                                                         
                     {
                        lcd0.writeText(com.phidget22.LCDFont.DIMENSIONS_5X8, 0, 0, "Went up!!!!");
                        lcd0.flush();   

                        Platform.runLater(new Runnable()
                        {
                           @Override
                           public void run()
                           {
                              unstatic.goUP();                    
                             // This method initiates the cursor moving to the up through a...
                              // ...Robot object and mouse event.
                           }
                        });
                     }
                     catch(Exception ex)
                     {
                        System.out.println("error");
                     }
                  }
                  else if( e.getSensorValue()<-0.8)
                  {
                     System.out.println("Go down! " +e.getSensorValue());        
                  // When the joystick is pointed down, the cursor moves to the card on the up.
                     // It also makes "Went down!!" appear on the LCD.
                     
                     try                                                         
                     {
                    lcd0.writeText(com.phidget22.LCDFont.DIMENSIONS_5X8, 0, 0, "Went down!!");
                        lcd0.flush();
                        
                        Platform.runLater(new Runnable()
                        {
                           @Override
                           public void run()
                           {
                              unstatic.goDOWN();                  
                           // This method initiates the cursor moving to the down through a...
                              // ...Robot object and mouse event.
                           }
                        });
                     }
                     catch(Exception ex)
                     {
                        System.out.println("error");
                     } 
                  }
               }
            }
         );
   
         voltageRatioInput2.open(5000);                                       
         // Here the phidgets are further initialized. They are opened.
         
         voltageRatioInput3.open(5000);
         voltageRatioInput2.setSensorValueChangeTrigger(0.1);
         voltageRatioInput3.setSensorValueChangeTrigger(0.1);
         
         
         voltageRatioInput0.open(5000);
         voltageRatioInput0.setSensorValueChangeTrigger(0.1);
		   voltageRatioInput0.setSensorType(VoltageRatioSensorType.PN_1129);
         
   
         voltageRatioInput2.setSensorType(VoltageRatioSensorType.PN_1113);
         voltageRatioInput3.setSensorType(VoltageRatioSensorType.PN_1113);
         lcd0.open(5000);
         lcd0.setBacklight(1);
      
         lcd0.writeText(com.phidget22.LCDFont.DIMENSIONS_5X8, 0, 0, "GO!");
         // Here the LCD is set to say "GO!" when the program is ran.
         lcd0.flush();
*/
   
      launch(args);
      // The GUI and software is launched!
      
      unstatic.same();        
      // This method copies the contents of the Scene object holding all the card data over to 
      // ...this static object of the same class to be used.
   }
   
   public void goUP()   
   // This method is initiated when the joystick phidget is pointed upwards.
   {                    
      BProw--;          
      // This variable is responsible for keeping track of where the cursor should go next.
      // It subtracts 1 from its initial value as it's going upwards on the row...
      // ...towards 0, being the first row.
      
      if((BProw != -1) && (BProw != 3))                                             
      // Here it is checked that the variable won't go out of bounds of the amount of rows.
         robot.mouseMove(xButtonPos[BProw][BPcol], yButtonPos[BProw][BPcol]);       
      // Now, a Robot object moves the cursor to the coordinates of the next card, which is...
      // ...stored in the variables xButtonPos[][] and yButtonPos[][].
      
      else                                                                             
         BProw++;                                                                   
      //BProw and BPcol hold the values of where the cursor is before this method is called.
     // If BProw is out of bounds, it won't move the cursor and set the value...
     // ...back to it was initially.
   }
   
   public void goDOWN()
   // This method is initiated when the joystick phidget is pointed downwards.
   {   
      BProw++;          
      // This variable is responsible for keeping track of where the cursor should go next.
      // It adds 1 to its initial value as it's going downwards on the row...
      // ...towards 2, being the last row.
      
      if((BProw != -1) && (BProw != 3))
      // Here it is checked that the variable won't go out of bounds of the amount of rows.
         robot.mouseMove(xButtonPos[BProw][BPcol], yButtonPos[BProw][BPcol]);
      else
         BProw--;
   }
   
   public void goRIGHT()
   // This method is initiated when the joystick phidget is pointed right.
   {   
      BPcol++;           
      // This variable is responsible for keeping track of where the cursor should go next.
      // It adds 1 to its initial value as it's going right on the column towards...
      // ...5, being the last column.
      
      if((BPcol != -1) && (BPcol != 6))                                          
      // Here it is checked that the variable won't go out of bounds of the amount of columns.
         robot.mouseMove(xButtonPos[BProw][BPcol], yButtonPos[BProw][BPcol]);
      
      else
         BPcol--;
     // If BPcol is out of bounds, it won't move the cursor and set the value back...
     // ...to it was initially.
   }
   
   public void goLEFT() 
   // This method is initiated when the joystick phidget is pointed left.
   {   
      BPcol--;
      // This variable is responsible for keeping track of where the cursor should go next.
      // It subtracts 1 from its initial value as it's going left on the column...
      // ...towards 0, being the first column.
      
      if((BPcol != -1) && (BPcol != 6))
      // Here it is checked that the variable won't go out of bounds of the amount of columns.
         robot.mouseMove(xButtonPos[BProw][BPcol], yButtonPos[BProw][BPcol]);
      else
         BPcol++;
   }
   
   public void same()
   // This method copies the contents of the Scene object holding all the card data over...
   // ...to this static object of the same class to be used.
   {
      this.xButtonPos = newScene.xButtonPos;
      // yButtonPos[][] holds the X coordinates of each card.
      
      this.yButtonPos = newScene.yButtonPos;
      // yButtonPos[][] holds the Y coordinates of each card.
      
      this.flipRow = newScene.flipRow;
      // flipRow[] holds the row of what card is on the other side.
      
      this.flipCol = newScene.flipCol;
      // flipCol[] holds the column of what card is on the other side.
      
      this.saveimg = newScene.saveimg;
      // saveimg holds the current number value of what card is on the other...
      // ...side, based on the arrays flipRow and flipCol.
   }
   
   public void click()
   // This method uses a Robot object to simulate a mouse click with the touch sensor phidget.
   // It also initiates a mouse event.
   { 
      robot.mousePress(MouseButton.PRIMARY);
      robot.mouseRelease(MouseButton.PRIMARY);
   }
   
   public void moveInitial()
   // This method sets the cursor to be on the first card when the program is launched...
   // ...and when the game is reset.
   {
      robot.mouseMove(xButtonPos[BProw][BPcol], yButtonPos[BProw][BPcol]);
   }
   
private static class ppCardMatchingSCENE extends ppCardMatching
// This private class primarily holds what is needed to create the card game Scene object.
{
   int donebefore = 0;

   public Scene create()
   // This method creates and returns a card game Scene object.
   {  
      xButtonPos = xbuttonpos();    
      yButtonPos = ybuttonpos();
      // These call the xbuttonpos and ybuttonpos methods to retrieve the...
      // ...coordinates of each card.
   
      if(donebefore == 1)  
      // This keeps track of whether or not the Play Again? button has been pressed before.
      // If it has, the music is stopped, amount of matched cards is...
      // ...reset, and fastest time label is set to...
      // ...the previous time the game was completed by.
      {                    
         player1.stop();      
         player2.stop();
         player4.stop();
         
         matchCount = 0;
         
         score.setText(highScore);
      }
   
      r1 = new Random();               
      randSong1 = r1.nextInt(3);
      // These next lines of code create Random objects to be used to pull a random number.
      // The random number is then used to initiate File, Media, and... 
      // ...MediaPlayer methods with a song to be played over the program.
      
      soundFiles1[randSong1] = new File("cardMatchSong"+randSong1+".mp3");
      // This creates a song to be played throughout the playing of the game.
      media1 = new Media(soundFiles1[randSong1].toURI().toString());
      player1 = new MediaPlayer(media1);
      player1.setOnEndOfMedia(() ->
      {
         player1.play();
      });
      player1.play();
      
      r2 = new Random();
      randSong2 = r2.nextInt(2);
      
      soundFiles2[randSong2] = new File("cardMatchWin"+randSong2+".mp3");
      // This creates a song to be played when the game is won.
      media2 = new Media(soundFiles2[randSong2].toURI().toString());
      player2 = new MediaPlayer(media2);
      player2.setOnEndOfMedia(() ->
      {
         player2.play();
      });
      
      for(int i = 0; i < 3; i++)
      {
         soundFiles3[i] = new File("cardMatchSelect"+i+".mp3");
         // This creates sound effects to be played when a card is selected, card match is...
         // ...failed, and card match is achieved.
         media3[i] = new Media(soundFiles3[i].toURI().toString());
         player3[i] = new MediaPlayer(media3[i]);
      }
      player3[0].setOnEndOfMedia(() ->
      {
         player3[0].play();
      });
      player3[1].setOnEndOfMedia(() ->
      {
         player3[1].play();
      });
      player3[2].setOnEndOfMedia(() ->
      {
         player3[2].play();
      });

      r3 = new Random();
      randSong3 = r2.nextInt(2);
      
      soundFiles4[randSong3] = new File("cardMatchLose"+randSong3+".mp3");
      // This creates a song to be played when the game is lost.
      media4 = new Media(soundFiles4[randSong3].toURI().toString());
      player4 = new MediaPlayer(media4);
      player4.setOnEndOfMedia(() ->
      {
         player4.play();
      });

   
      for(int i = 0; i < 18; i++)
      // This creates numerous ImageView[]s to be displayed when a card isn't revealed.
      // There are multiple to avoid conflict when the same Image is already being displayed.
      {                                                        
         spadeSview1[i] = new ImageView("file:ppCardA.png");
         spadeSview2[i] = new ImageView("file:ppCardA.png");
         spadeSview3[i] = new ImageView("file:ppCardA.png");
      }
   
      Image ogPp = new Image("file:ppCardA.png");
   
      for(int i = 0; i < 6; i++)
      // The flipped card images are initialized here.
      {
         ppCard[i] = new Image("file:ppCard"+i+".png");
      }
   
      GridPane cards = new GridPane();    
      cards.setAlignment(Pos.CENTER); 
      // Here the GridPane object to hold the cards is created.
      // It is aligned and spaced out correctly too.
      
      for(int i = 0; i < 3; i++)
      {
         RowConstraints row = new RowConstraints(165);
         cards.getRowConstraints().add(row);
      }
      for(int i = 0; i < 6; i++)
      {
         ColumnConstraints column = new ColumnConstraints(240);
         cards.getColumnConstraints().add(column);
      }
      cards.setVgap(20);

      ppCardMatchingEXTRA pMethod = new ppCardMatchingEXTRA();     
      pMethod.setRow(3);                                          
      pMethod.setColumn(6);                                       
      // An object is created from the ppCardMatchingEXTRA class.
      // The class is used to set the cards in a random order on the GridPane in the program.
      // The class is used to set the cards in a random order on the GridPane in the program.
      // Here, with setRow and setColumn, the amount of rows and columns in...
      // ...the card game is set for the object and class to follow.
                                                                     
      if(donebefore == 0)
         score = new Label("Fastest Finish Time: 0:00");
      // If the Play Again? button hasn't been pressed, the fastest time label is set to 0:00.
         
      score.setTextFill(Color.RED);
      // The fastest time label is changed to the color red.
      
      cards.setHalignment(score, HPos.CENTER);  
      cards.setValignment(score, VPos.CENTER);
      // The GridPane object holding all the cards is alligned.
      
      int row, col;                    
      int rRow, rCol;
      for(row = 0; row < 3; row++)
      {
         for(col = 0; col < 6; col++)
         {  
            buttons[row][col] = new Button("");
            
            buttons[row][col].setMaxWidth(110);
            buttons[row][col].setMaxHeight(260);
            
            buttons[row][col].setOnAction(new ButtonEventHandler(row, col));
            
            cards.add(buttons[row][col], col, row);
         }
      }
      // Here the card buttons are initialized and added to the GridPane.
      
      int p = 0;
      // This int value keeps track of if all the cards are created yet.

      int p0c = 0;      
      int p1c = 0;
      int p2c = 0;
      int p3c = 0;
      int p4c = 0;
      int p5c = 0;
     // These int values keep track of what flipped cards are present and initialized already.
      
      for(int i = 0; i < 18; i++)
      {
         pMethod.rcRandom();
         // This method randomly generates row and column values for the cards to assigned to.
         
         rRow = pMethod.getRow();      
         rCol = pMethod.getColumn();
         // These methods obtain the aforementioned values.
         
         //
         System.out.println("rRow: "+rRow+", rCol: "+rCol);
         //
         
         if(p != 6)     
         // If p = 6, it means that all the cards have been created.
         {
            if(p == 5 && p5c != 2)
            // The value of p keeps track of the cards that are ready to be created...
            // ...next, based on the number in their image file.
            // the value of p#c keeps track of how many cards have been made.
            // For this card, only two must be made.
            // So if it reaches 2, that card is created no more.
            {                          
               ppViewer = new ImageView(ppCard[p]);   
               ppV[i] = new ImageView(ppCard[p]);
               // Here the card images are put into ImageView objects.
               
               p5c++;
               // The value of p#c goes up due to a card being created.

               flipRow[i] = rRow;
               flipCol[i] = rCol;
               flipCard[i] = p;
               // These assign the row and column of the card and what the card is...
               // ...to arrays to be used later.

               if(p5c == 2)      
               {
                  p++;
               }
               // When p#c reaches 2 here, it increases p to make sure to move onto...
               // ...the next cards to be created or for the card creation to stop.
            }
         
            if(p == 4 && p4c != 4)
            {
               ppViewer = new ImageView(ppCard[p]);
               ppV[i] = new ImageView(ppCard[p]);
               p4c++;
               
               flipRow[i] = rRow;
               flipCol[i] = rCol;
               flipCard[i] = p;
               
               if(p4c == 4)
               {
                  p++;
               }
            }

            if(p == 3 && p3c != 2)
            {
               ppViewer = new ImageView(ppCard[p]);
               ppV[i] = new ImageView(ppCard[p]);
               p3c++;
               
               flipRow[i] = rRow;
               flipCol[i] = rCol;
               flipCard[i] = p;
               
               if(p3c == 2)
               {
                  p++;
               }
            }
         
            if(p == 2 && p2c != 2)
            {
               ppViewer = new ImageView(ppCard[p]);
               ppV[i] = new ImageView(ppCard[p]);
               p2c++;
               
               flipRow[i] = rRow;
               flipCol[i] = rCol;
               flipCard[i] = p;
               
               if(p2c == 2)
               {
                  p++;
               }
            }
            
            if(p == 1 && p1c != 4)
            {
               ppViewer = new ImageView(ppCard[p]);
               ppV[i] = new ImageView(ppCard[p]);
               p1c++;
               
               flipRow[i] = rRow;
               flipCol[i] = rCol;
               flipCard[i] = p;

               if(p1c == 4)
               {
                  p++;
               }
            }

            if(p == 0 && p0c != 4)
            {
               ppViewer = new ImageView(ppCard[p]);
               ppV[i] = new ImageView(ppCard[p]);
               p0c++;
               
               flipRow[i] = rRow;
               flipCol[i] = rCol;
               flipCard[i] = p;
               
               if(p0c == 4)
               {
                  p++;
               }
            }
         }
         
         //
         System.out.println("flipRow["+i+"]: "+flipRow[i]+", flipCol["+i+"]: "
                           +flipCol[i]+", flipCard["+i+"]: "+flipCard[i]);
         //
         
         ogPP = new ImageView(ogPp);
         buttons[rRow][rCol].setGraphic(ogPP);     
         // The non-flipped card button images are set here.
         
         cards.setHalignment(buttons[rRow][rCol], HPos.CENTER);   
         cards.setValignment(buttons[rRow][rCol], VPos.CENTER);
         // The cards are aligned and centered.
      }
   
      score.setFont(Font.loadFont("file:DTM-Sans.otf", 35));
      // The fastest time label is set to a font.
      
      TIME = new StringBuilder("Time: 0:00");                        
      timerlabel = new Label("Time: "+startTime+":00");              
      timerlabel.setFont(Font.loadFont("file:DTM-Sans.otf", 35));
      timerlabel.setTextFill(Color.RED);
      // Here a timer is being created.
      // The timer label is initialized.
      
      animation = new Timeline(new KeyFrame(Duration.seconds(1), e -> CountDown()));
      animation.setCycleCount(Timeline.INDEFINITE);
      animation.play();
      // The timer is fully created.
      
      newgame = new Button("Play again?");                        
      newgame.setFont(Font.loadFont("file:DTM-Sans.otf", 15));
      // A button for playing the game again is created.
      
      /*TextArea card = new TextArea("Card Matching!");
      card.setEditable(false);*/
      
      VBox c = new VBox(/*card,*/ timerlabel, cards, score, newgame);      
      c.setAlignment(Pos.CENTER);                                           
      c.setSpacing(20);
      // A VBox containing the timer label, all the cards, fastest time...
      // label, and play again button is created, centered, and spaced.
      
         Image bg = new Image("file:bgColor.jpg", 1920, 1080, false, false);
         // An image for the background of the program is made.
      
               root = new StackPane(c);
               root.setAlignment(Pos.CENTER);
               // The VBox is put into a StackPane object that will be put in the scene.
               
               root.setBorder
               (new Border(new BorderStroke(Color.RED,                                  
               BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10))));
               // A border for the StackPane is created.
               
               BackgroundImage bgImg = new BackgroundImage(bg,
                                          BackgroundRepeat.NO_REPEAT,
                                          BackgroundRepeat.NO_REPEAT,
                                          BackgroundPosition.DEFAULT,
                                          BackgroundSize.DEFAULT);
               Background bG = new Background(bgImg);
               root.setBackground(bG); 
               // The background image for the program/StackPane is finally initialized.
               
      Scene scene = new Scene(root, 1500, 760);          
      // The scene is done, consisting of the StackPane object!
      
      donebefore = 1;                              
      // Now, the donebefore variable is set to 1, showing that a...
      // ...Scene object has been made previously.
      
      return scene;                               
       // The new scene is returned.
   }
   
   public Button getnewgame()    
   // This method returns the Play Again? button to an object that calls it.
   {
      return newgame;
   }
   
   public double[][] xbuttonpos()   
   // Here the card button coordinates are initialized manually in arrays for use later.
   {
      double[][] xbuttonpos = new double[3][6];
      
      xbuttonpos[0][0] = 167.59999084472656;
      xbuttonpos[0][1] = 406.0;
      xbuttonpos[0][2] = 645.2000122070312;
      xbuttonpos[0][3] = 886.800048828125;
      xbuttonpos[0][4] = 1127.5999755859375;
      xbuttonpos[0][5] = 1365.2000732421875;
      xbuttonpos[1][0] = 168.40000915527344;
      xbuttonpos[1][1] = 405.20001220703125;
      xbuttonpos[1][2] = 646.800048828125;
      xbuttonpos[1][3] = 883.5999755859375;
      xbuttonpos[1][4] = 1126.0;
      xbuttonpos[1][5] = 1365.2000732421875;
      xbuttonpos[2][0] = 163.60000610351562;
      xbuttonpos[2][1] = 403.60003662109375;
      xbuttonpos[2][2] = 642.7999877929688;
      xbuttonpos[2][3] = 883.5999755859375;
      xbuttonpos[2][4] = 1123.5999755859375;
      xbuttonpos[2][5] = 1364.39990234375;
      
      return xbuttonpos;
   }
   public double[][] ybuttonpos()
   {
      double[][] ybuttonpos = new double[3][6];
      
      ybuttonpos[0][0] = 219.59999084472656;
      ybuttonpos[0][1] = 219.59999084472656;
      ybuttonpos[0][2] = 222.0;
      ybuttonpos[0][3] = 222.8000030517578;
      ybuttonpos[0][4] = 227.59999084472656;
      ybuttonpos[0][5] = 225.20001220703125;
      ybuttonpos[1][0] = 406.0;
      ybuttonpos[1][1] = 408.3999938964844;
      ybuttonpos[1][2] = 409.20001220703125;
      ybuttonpos[1][3] = 407.6000061035156;
      ybuttonpos[1][4] = 407.6000061035156;
      ybuttonpos[1][5] = 405.1999816894531;
      ybuttonpos[2][0] = 590.7999877929688;
      ybuttonpos[2][1] = 589.2000122070312;
      ybuttonpos[2][2] = 589.2000122070312;
      ybuttonpos[2][3] = 586.7999877929688;
      ybuttonpos[2][4] = 587.5999755859375;
      ybuttonpos[2][5] = 588.4000244140625;
      
      return ybuttonpos;
   }
}

   @Override
   public void start(Stage primaryStage)        
   // The program and stage is launched!
   {
      this.primaryStage = primaryStage;
   
      newScene = new ppCardMatchingSCENE();     
      scene = newScene.create();
      // The scene and card game is created.
      
      Image cursor = new Image("file:ppCursor.png");  
      scene.setCursor(new ImageCursor(cursor));
      // A cursor for the game is made.
      
      unstatic.same();           
      unstatic.moveInitial();
      // The same() and moveInitial() methods are called.
      
         newgame = new Button("Play again?");
         // The Play Again? button is created.
         newgame = newScene.getnewgame();       
         // The button is retrieved from the scene itself.
         newgame.setOnAction(e ->               
         // The button's function is set. If pressed, it will reset the game...
         // ...through created a new Scene object to display.
         {
            Scene sceneA = newScene.create();
            sceneA.setCursor(new ImageCursor(cursor));
         
            unstatic.moveInitial();
         
            primaryStage.setScene(sceneA);
            primaryStage.setFullScreen(true);
         });
      
      primaryStage.setTitle("Card Matching");
      primaryStage.setScene(scene);
      primaryStage.setFullScreen(true);
      
      primaryStage.show();    
      // The stage is shown!
   }
   
   void CountDown()     
   // This counts down the minutes left in the game.
   {
      if(seconds == 0)
      {
         minutes--;
         seconds = 59;
      }
      else
      {
         seconds--;
      }
      
      if(seconds < 10)
         TIME.replace(6, 10, minutes+":0"+seconds);   
      else
         TIME.replace(6, 10, minutes+":"+seconds);
      // Every time it counts down, the time is changed in the StringBuilder...
      // ...to be displayed in the timer label.
         
      if(minutes == 0 && seconds == 0)          
      {                                         
         animation.stop();                      
      
            for(int i = 0; i < 18; i++)
            {
               buttons[flipRow[i]][flipCol[i]].setDisable(true);
            }
         
         player1.stop();
         player4.play();
         
         bothmatch1 = false;
         bothmatch2 = false;
         bm = false;
         checkMatch = false;
         fCardRow = 10;
         fCardCol = 10;
         fCard = 10;
         two = false;
         m = 0;
            
         Integer startTime = 2;
         minutes = startTime;
         seconds = 0;
         
         JOptionPane.showMessageDialog(null, "Time's Up!");
      }
      // When time runs out, the card buttons are disabled, music is turned...
      // ...off, and many values used for tracking are reset for usage again.
      // A popup saying "Time's up!" also shows up.
      
      timerlabel.setText(TIME.toString());
      // The timer label is set to the new time.
   }
   
   class ButtonEventHandler implements EventHandler<ActionEvent>
   {
      Robot robot = new Robot();                      
      // A Robot object is created...
      
      Image ogPp = new Image("file:ppCardA.png");     
      ImageView ogPP = new ImageView(ogPp);
      
      Image ogPp2 = new Image("file:ppCardA.png");
      ImageView ogPP2 = new ImageView(ogPp2);
      // ImageViews holding the unflipped card image are created.
      
      private int row, col;

      public ButtonEventHandler(int r, int c)      
      {
         row = r;
         col = c;
      }
      // When the cards were created, it called this constructor, keeping...
      // ...track of what row and column each were in.
   
      @Override
      public void handle(ActionEvent event)
      // When the button is pressed!
      {
         player3[0].stop();      
         player3[0].play();
         // This plays the card selection sound effect.
               
         b1 = (Button)event.getSource();
         // Gets the source of the button pressed.
         
         for(int i = 0; i < 18; i++)
         // Goes through and checks what card was pressed based on the row and column values.
         {
            if((row == flipRow[i]) && (col == flipCol[i]))
            {
               //
               System.out.println("flipRow["+i+"]: "+flipRow[i]+
                                 ", flipCol["+i+"]: "+flipCol[i]);
               //
            
               b1.setGraphic(ppV[i]);  
               // Sets the graphic to the right flipped card assigned to the button.
               c = flipCard[i];
               // Backs up what specific card is present.
               
               saveimg = i;            
               // Saves the value where the flipped card is at.
               
               unstatic.same();           
               // Calls the same method to backup.
            }
         }

         if(fCard != 10)    
            b3 = b2;          
         // fCard is a comparison value for the specific card present.
         // b3 furthers backs up a the first button pressed for a match test.
         // It's to make sure no repeats occur.

         if(fCard == 10)
         {
            fCard = c;
            // Gives fCard the value of the first card that was selected.
            
            fCardRow = row;
            fCardCol = col;
            // It also takes the row and column of this card.
            
            two = false;      
            // the 'two' value tells if two cards have been selected or not.
            
            b2 = b1;          
            // Backs up the source button.
         }
         else
            two = true;       
            // If fCard is already backed up, it sets 'two' to true, indicating...
            // ...that a card has already been selected.
            
         for(int p = 0; p < 18; p++)   // This checks if a card selected has already been 
         {                             // ...matched with another card.
            if(b1 == matchBts[p])      // matchBts[p] stores the already matched cards.
            {
               testmB1 = matchBts[p];
               bothmatch1 = true;
            }
            if(b2 == matchBts[p])
            {
               testmB2 = matchBts[p];
               bothmatch2 = true;
            }
         }
         if(bothmatch1 && bothmatch2)
            bm = true;
            
         
         if(fCard != 10 && two == true && b3 != b1)   
         // fCard not being 10 means that another card value has been sent to...
         // ...it, meaning that this is a second card selected.
         // 'two' being true means that this is the second card selected to test for a match.
         
         {                                            
            if(b1 != testmB1 && b2 != testmB2)
            // testmB1 and testmB2 are values testing if the cards are either that...
            // ...have been matched before.
            {
               checkMatch = check();
               // If neither have been matched before the check() method is...
               // ...called, checking for a match.
               
               if(checkMatch == true)
               // If the check() method comes back true, it's a match!
               {
                  matchBts[matchCount + m] = b1;      
                  matchBts[matchCount + (m + 1)] = b2;
                  // The buttons are added to the array of matched buttons.
            
                  matchCount++;     
                  m++;
                  // The amount of matched buttons increase.
               
                  checkMatch = false;     
                  // Sets the check() results back to false for the next card sslections.
               }
            }
               else if(bothmatch1 && !bothmatch2)  
               // Called if one of the buttons are already a matched one.
               // Sets the unmatched card back to unflipped.
               
               {
                  b2.setGraphic(spadeSview3[spadeimgnum2]);
                  
                  spadeimgnum2++;            
                  if(spadeimgnum2 == 18)
                     spadeimgnum2 = 0;
                  // Increases the image value in the ImageView for the...
                  // ...unflipped cards to avoid conflicting images.
                     
                  bothmatch1 = false;     
                  bothmatch2 = false;
              // Sets the variable checking for matched cards back to false for the next check.
               }
               else if(bothmatch2 && !bothmatch1)  
               // Same as the method above.
               
               {
                  b1.setGraphic(spadeSview3[spadeimgnum2]);
                  
                  spadeimgnum2++;
                  if(spadeimgnum2 == 18)
                     spadeimgnum2 = 0;
                     
                  bothmatch1 = false;
                  bothmatch2 = false;
               }
               else if(bm == true)
               // If both buttons clicked are matched cards, nothing happens.
               // The test variables are reset.
               {
                  bothmatch1 = false;
                  bothmatch2 = false;
                  bm = false;
               }
         
            fCard = 10;
            fCardRow = 10;
            fCardCol = 10;
            two = false;
            // Test variables are reset for the next card match tests.
         }
         else if(b3 == b1)
         // Tests for another button conflict.
         
         {
            if(b1 != testmB1 && b2 != testmB2)
            {
               b1.setGraphic(spadeSview3[spadeimgnum2]);
               
               spadeimgnum2++;
               if(spadeimgnum2 == 18)
                  spadeimgnum2 = 0;
            }
            
               fCard = 10;
               fCardRow = 10;
               fCardCol = 10;
               two = false;
         }
         
         bothmatch1 = false;
         bothmatch2 = false;
         bm = false;
         
         if(matchCount == 9)
         // When all the matches are done!
         {
            animation.stop();    
               for(int i = 0; i < 18; i++)
               {
                  buttons[flipRow[i]][flipCol[i]].setDisable(true);
               }
            // The timer stops, and the card buttons are disabled.
            
            player1.stop();      
            player2.play();
            // The in-game music stops and the victory music begins.
            
            if(seconds < 10)
            // This if-else statement sets the fastest time label to...
            // ...the amount on the timer if it is the fastest time.
            {
               if(lastMinutes < minutes || lastMinutes == minutes && lastSeconds < seconds)
               {
                  lastMinutes = minutes;
                  lastSeconds = seconds;
               
                  highScore = "Fastest Finish Time: "+minutes+":0"+seconds;
                  score.setText(highScore);
               }
            }
            else
            {
               if(lastMinutes < minutes || lastMinutes == minutes && lastSeconds < seconds)
               {
                  lastMinutes = minutes;
                  lastSeconds = seconds;

                  highScore = "Fastest Finish Time: "+minutes+":"+seconds;
                  score.setText(highScore);
               }
            }
            
            bothmatch1 = false;     
            bothmatch2 = false;
            bm = false;
            checkMatch = false;
            fCardRow = 10;
            fCardCol = 10;
            fCard = 10;
            two = false;
            m = 0;
            // Test variables are reset for the next game.
            
            Integer startTime = 2;
            minutes = startTime;
            seconds = 0;
            // Timer variables are reset too.
            
            JOptionPane.showMessageDialog(null, "You Win!");
            // A popup window pops up too, saying "You Win!"
         }

      }

      public boolean check()  
      // Checks if a card match is found.
      {
         if(fCard == c)
         {
            player3[1].stop();
            player3[1].play();   
            
            return true;
            // If the same card value is found in both...
            // ...variables, the 'correct' jingle plays and check() is returned true.
         }
         else
         {
            player3[2].stop();   
            player3[2].play();
            // If they are not the same, the 'wrong' jingle plays.
            
            for(int i = 0; i < 18; i++)   
            {
               buttons[flipRow[i]][flipCol[i]].setDisable(true);
               buttons[flipRow[i]][flipCol[i]].setStyle("-fx-opacity: 1");
            }
            // It then sets all the cards to disabled for a brief moment to avoid conflict.
            
            timer5();
            // Timer method is called.

            spadeimgnum1++;     
            if(spadeimgnum1 == 18)
               spadeimgnum1 = 0;
            // Unflipped image conflict avoidance again.
            
            return false;
            // check() returned false here.
         }
      }

      public void timer5()
      // Timer!
      {
         Timeline time = new Timeline(new KeyFrame(Duration.seconds(0.7), ev ->
         // Timer is created for less than a second.
         
         // When the time is up...
         {              
            setspade();
            // Method is called for changing the images of the cards back to unflipped.
            
            for(int i = 0; i < 18; i++)
            {
               buttons[flipRow[i]][flipCol[i]].setDisable(false);    
               buttons[flipRow[i]][flipCol[i]].setStyle("-fx-opacity: 1");
            }
            // All the card buttons are enabled again.
         }));
      
         time.setCycleCount(1);
         time.play();
      }
      
      public void setspade()
      {
         b2.setGraphic(spadeSview1[spadeimgnum1]);    
         b1.setGraphic(spadeSview2[spadeimgnum1]);
         // Set the buttons back to unflipped.
      }
   }
}