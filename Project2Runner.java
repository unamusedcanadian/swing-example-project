import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project2Runner {

      /*
      * Name: Aidan Lee 
      * Student ID: 501321307 
      * 
      ******** Project Description ********
      * A little idle game made with swing components. Click the button to
      * make more energy! Spend that energy to make more energy! Want to change the
      * colours of the bars? Type in a hex code into the dialog in the upper left and
      * press enter! The world is yours!
      * 
      ******** Swing Requirement ********
      * My project utilizes six JComponents- a JLabel, JComponent, JButton, JTextField,
      * a JPanel, and a JFrame. 
      *
      * The JFrame can be found in "App.java" at line 7.
      * The JTextField can be found in "App.java" at line 31.
      * The JLabel can be found in "App.java" at line 54.
      * The JPanel can be found in "ResourceButton.java" at line 6.
      * The JButton can be found in "ResourceButton.java" at line 27.
      * The JComponent can be found in "ResourceButton.java" at line 78.
      *
      ******** 2D Graphics Requirement ********
      * My "ResourceButton.java" file has a "progress bar" made out of Graphics2D
      * drawn shapes. I use a JPanel to combine a JComponent and a JButton together
      * to make each other's size relative to the other. The Graphics2D shape is 
      * defined at line 78 of the aforementioned file.
      *
      ******** Event Listener Requirement ********
      * My "ResourceButton.java" file has events linked to clicking the button- causing
      * the bar to increase relative to the "max" set in the button. This makes use
      * of a custom class implementing a MouseListener interface. Said object is defined
      * on line 30 of the previously mentioned file.
      *
      * As for the ActionListener, the "App.java" file has a JTextField object with one 
      * implemented on line 32 of "App.java", which takes a hex code input and turns the 
      * bars of the ResourceButton objects that colour, if applicable.
      */

      // Runs the game
      public static void main(String[] args) {
            App frame = new App("Project Idle"); 
      }
}
