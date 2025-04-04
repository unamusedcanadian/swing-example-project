import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TODO clean up code, add ActionListener (different from MouseListener)
// maybe a button that upgrades the "Portable Generators"?
public class Project2Runner {

      /*
      * Name: Aidan Lee 
      * Student ID: 501321307 
      * 
      ******** Project Description ********
      * A little idle game made with swing components. Click the button to
      * make more energy! Spend that energy to make more energy!
      * 
      ******** Swing Requirement ********
      * My project utilizes four JComponents- a generic JComponent, a JButton,
      * a JPanel, and a JFrame. The JFrame can be found in this file at line
      * ~46, with the JPanel found in "ResourceButton.java" at line 7, JButton in
      * the latter file at line 25, and the JComponent also in the mentioned file
      * at line ~76.
      * TODO update the line numbers when done
      * 
      ******** 2D Graphics Requirement ********
      * My "ResourceButton.java" file has a "progress bar" made out of Graphics2D
      * drawn shapes. I use a JPanel to combine a JComponent and a JButton together
      * to make each other's size relative to the other. The Graphics2D shape can
      * be found at lines 96 to 113 of the aforementioned file.
      *
      ******** Event Listener Requirement ********
      * My "ResourceButton.java" file has events linked to clicking the button- causing
      * the bar to increase relative to the "max" set in the button. This makes use
      * of a custom class implementing a MouseListener interface. Said object is defined
      * on line 27 to 39 of the previously mentioned file.
      *
      * As for the ActionListener,
      */

      public static void main(String[] args) {
            App frame = new App("Project Idle"); 

      }
}
