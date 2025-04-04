import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Creates a button to the right of a loading bar
// TODO add an actionlistener (NOT mouselistener) 
public class ResourceButton extends JPanel {
      // JComponents 
      private BarComp barComp;
      private JButton button;

      // Interface with data
      private int current;
      private int max;
      private int cost;
      private int income;

      // Keeps button names intact while swapping
      private String str;
      
      // Constructor
      public ResourceButton() {
            // Sets this component to use the GridBagLayout
            this.setLayout(new GridBagLayout());

            // Creates subcomponents
            barComp = new BarComp();
            button = new JButton();
            
            // Adds a discreet mouse listener to the button
            button.addMouseListener(new MouseListener() {
                  @Override
                  public void mouseClicked(MouseEvent e) {
                        increment();
                  }

                  @Override public void mouseEntered(MouseEvent e) {
                        button.setLabel("Cost: " + cost);
                  }
                  @Override public void mouseExited(MouseEvent e) {
                        button.setLabel(str);
                  }
                  @Override public void mousePressed(MouseEvent e) {}
                  @Override public void mouseReleased(MouseEvent e) {}
            });

            // prevents dotted lines from appearing
            button.setFocusable(false);

            // keeps button size rigid in the GridBagLayout
            final Dimension d = new Dimension(100, 100);
            button.setMinimumSize(d);
            button.setPreferredSize(d);
            button.setMaximumSize(d);

            // adds subcomponents to layout with specified size and constraints
            GridBagConstraints c = gbcMaker(0, 0, 1, 1, 0.8, 1);
            c.fill = GridBagConstraints.BOTH;
            this.add(barComp, c);

            c = gbcMaker(1, 0, 1, 1, 0.2, 1);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.EAST;
            this.add(button, c);
      } 

      // creates and returns a new GridBagConstraints object
      private static GridBagConstraints gbcMaker(
            int gx, int gy, int gw, int gh, double wx, double wy
      ) {
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = gx; c.gridy = gy;
            c.gridwidth = gw; c.gridheight = gh;
            c.weightx = wx; c.weighty = wy;
            return c;
      }

      // The visual for the loading bar
      private class BarComp extends JComponent {
            // Variables for the bar
            private Color barColour;
            private Color barBackground;
            private Color borderColour;
            private int borderWidth;
            private int borderRad;

            // Only the superclass can call this
            private BarComp() {
                  super();
                  barColour = Color.GREEN;
                  barBackground = Color.GRAY;
                  borderColour = Color.BLACK;
                  borderWidth = 4;
                  borderRad = 0;
            }

            @Override
            public void paintComponent(Graphics g) {
                  super.paintComponent(g);

                  int width = this.getWidth();
                  int height = this.getHeight();

                  int pWidth = (int) (width * current / max);
                  
                  Graphics2D g2d = (Graphics2D) g;

                  g2d.setColor(barBackground);
                  g2d.fillRoundRect(0, 0, width, height, borderRad, borderRad);

                  g2d.setColor(barColour);
                  g2d.fillRoundRect(0, 0, pWidth, height, borderRad, borderRad);

                  g2d.setStroke(new BasicStroke(borderWidth));
                  g2d.setColor(borderColour);
                  g2d.drawRoundRect(0, 0, width, height, borderRad, borderRad);
            }
      }

      // Allows me to increment the 'current' counter from anywhere else in the code
      public void increment() {
            // If the first condition fails, the second doesn't get tested
            // preventing unfair deductions
            if ((current < max) && (App.subResource(cost))) {
                  current++;
            }
            this.repaint(); // updates the loading bar
      }

      // Setters
      // BarComponent options
      public void setBarColour(Color colour) {
            barComp.barColour = colour;
      }
      public void setBarBackground(Color colour) {
            barComp.barBackground = colour;
      }
      public void setBorderColour(Color colour) {
            barComp.borderColour = colour;
      }
      public void setBorderWidth(int i) {
            barComp.borderWidth = i;
      }
      public void setBarRadius(int i) {
            barComp.borderRad = i;
      }

      // Button options
      public void setLabel(String s) {
            str = s;
            button.setLabel(str);
      }
      public void setButtonForeground(Color c) {
            button.setForeground(c);
      }
      public void setButtonBackground(Color c) {
            button.setBackground(c);
      }

      // Other setters 
      public void setMax(int i) {
            if (i > 0)
                  max = i;
      }
      public void setCost(int i) {
            if (i >= 0) 
                  cost = i;
      }
      public void setIncome(int i) {
            if (i > 0)
                  income = i;
      }

      // Getters
      public int getIncome() {
            return current*income;
      }
}
