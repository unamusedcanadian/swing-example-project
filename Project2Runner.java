import javax.swing.*;
import java.awt.*;

public class Project2Runner {

      /*
      * Name: Aidan Lee 
      * Student ID: 501321307 
      * 
      ******** Project Description ********
      * A little idle game made with swing components. TODO make this longer
      *
      * 
      *
      * 
      ******** Swing Requirement ********
      * 
      * Describe in 1 paragraph how your program satisfies the requirement that
      * there is at least 3 unique components. Be clear to identify in what
      * files and the lines number (just the starting line is fine) that the
      * components are defined on.
      * 
      * 
      * 
      ******** 2D Graphics Requirement ********
      *
      * Describe in 1 paragraph how your program satisfies the requirement that
      * there is at least 1 JPanel used for drawing something. Be clear to
      * identify in what files and the line numbers that this panel is defined on.
      * 
      * 
      * 
      ******** Event Listener Requirement ********
      *
      * Describe in 1 paragraph how your program satisfies the requirement that
      * there is at least one ActionListener, and there is additionally at least
      * one MouseListener or ActionListener. Be clear to identify in what file
      * and the line numbers that these listeners are defined in.
      */

      public static void main(String[] args) {
            // Constant
            final Dimension SIZE = new Dimension(1280, 720);

            // JFrame with default layout
            JFrame f = new JFrame("Project Idle");  
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setLayout(new GridLayout(1,1));
            f.setPreferredSize(SIZE);

            PanelManager a = new PanelManager();
            a.setPreferredSize(SIZE);
            f.add(a);

            // one instance of button class
            ResourceButton button = new ResourceButton();
            button.setPreferredSize(new Dimension(680, 300));
            button.setBarColour(Color.BLUE);
            button.setBarBackground(Color.RED);
            button.setBorderColour(Color.BLACK);
            button.setLabel("Testing");

            // one instance of button class
            ResourceButton button2 = new ResourceButton();
            button2.setPreferredSize(new Dimension(200, 50));
            button2.setBarColour(Color.RED);
            button2.setBarBackground(Color.BLUE);
            button2.setBorderColour(Color.GREEN);
            button2.setMargin(0.5);
            button2.setLabel("Small");

            a.addComp(button);
            a.addComp(button2);

            f.pack();
            f.setVisible(true);
      }
}
