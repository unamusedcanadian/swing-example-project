import javax.swing.*;
import java.awt.*;

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
      */

      public static void main(String[] args) {
            // Constant TODO program all components to not need these (except JFrame)
            final Dimension SIZE = new Dimension(1280, 720);
            final Dimension BIG = new Dimension(1920, 1080);

            // JFrame with default layout
            JFrame f = new JFrame("Project Idle");  
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setLayout(new GridLayout(4,1));
            f.setPreferredSize(SIZE); 

            // Juryrigged centering of JPanel TODO make this actually centered
            JPanel lPanel = new JPanel();
            lPanel.setLayout(new GridLayout(1,2));
            lPanel.setPreferredSize(BIG);
            lPanel.add(new JPanel());

            // TODO unjuryrig the label updating code
            JLabel label = new JLabel();
            label.setPreferredSize(BIG);

            Data.setLabel(label);
            lPanel.add(label);

            // one instance of button class
            ResourceButton button = new ResourceButton();
            button.setPreferredSize(BIG);
            button.setMax(10);
            button.setLabel("Portable Generator");

            // one instance of button class
            ResourceButton button2 = new ResourceButton();
            button2.setPreferredSize(BIG);
            button2.setMax(5);
            button2.setCost(50);
            button2.setIncome(5);
            button2.setLabel("Hydroelectric Dam");

            // one instance of button class
            ResourceButton button3 = new ResourceButton();
            button3.setPreferredSize(BIG);
            button3.setBarColour(Color.BLUE);
            button3.setCost(1000);
            button3.setIncome(100);
            button3.setLabel("Nuclear Reactor");

            f.add(lPanel);
            f.add(button);
            f.add(button2);
            f.add(button3);

            Data.setResource(10);

            f.pack();
            f.setVisible(true);

            while (true) {
                  try { Thread.sleep(1000); }
                  catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                  }
                  Data.addResource(button.getIncome());
                  Data.addResource(button2.getIncome());
                  Data.addResource(button3.getIncome());
            }
      }
}
