import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.IllegalArgumentException;

// Creates a button to the right of a loading bar
public class ResourceButton extends JPanel {
      // Objects
      private BarComp barComp;
      private JButton button;

      // Interface with data
      private int current;
      private int max;
      private int cost;
      private int income;

      // Keeps button names intact
      private String str;
      
      // Constructor
      public ResourceButton() {
            // Sets this component to use the GridBagLayout
            this.setLayout(new GridBagLayout());

            // Creates subcomponents
            barComp = new BarComp();
            button = new JButton();
            
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

            // adds subcomponents to layout with specified size and constraints
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.weightx = 0.66; 
            c.weighty = 1;
            c.fill = GridBagConstraints.BOTH;

            this.add(barComp, c);

            // TODO make the button not manipulate the gridbag
            GridBagConstraints c2 = new GridBagConstraints();
            c.gridx = 1;
            c.gridwidth = 1;
            c.weightx = 0.33;

            this.add(button, c);

            // sets some default variables
            max = 1;
            cost = 10;
            income = 1;
      }

      // The visual for the loading bar
      private class BarComp extends JComponent {
            // Variables for the bar
            private Color barColour;
            private Color barBackground;
            private Color borderColour;
            private int borderWidth;
            private int borderRad;

            public BarComp() {
                  super();
                  barColour = Color.GREEN;
                  barBackground = Color.GRAY;
                  borderColour = Color.BLACK;
                  borderWidth = 4;
                  borderRad = 0;
            }

            @Override
            public void paintComponent(Graphics g) {
                  // TODO make this a progressive loading bar
                  super.paintComponent(g);

                  int width = this.getWidth();
                  int height = this.getHeight();

                  int pWidth = (int) (width * current / max);
                  
                  Graphics2D g2d = (Graphics2D) g;

                  g2d.setColor(barBackground);
                  g2d.fillRoundRect(pWidth, 0, width-pWidth, height, borderRad, borderRad);

                  g2d.setColor(barColour);
                  g2d.fillRoundRect(0, 0, pWidth, height, borderRad, borderRad);

                  g2d.setStroke(new BasicStroke(borderWidth));
                  g2d.setColor(borderColour);
                  g2d.drawRoundRect(0, 0, width, height, borderRad, borderRad);
            }
      }

      // Allows me to increment the 'current' counter from anywhere else in the code
      public void increment() {
            if ((current < max) && (Data.subResource(cost)))
                  current++;
            repaint();
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
