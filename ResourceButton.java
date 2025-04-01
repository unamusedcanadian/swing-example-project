import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.IllegalArgumentException;

// Creates a button to the right of a loading bar
public class ResourceButton extends JPanel {
      // Objects
      private BarComp barComp;
      private JButton button;

      // Floating point variables
      private double margin;        // (0, 1) non-inclusive
      
      private int current;
      private int max;
      
      // Constructor
      public ResourceButton() {
            // Sets this component to use the box layout
            setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

            // Creates subcomponents
            barComp = new BarComp();
            button = new JButton();
            
            button.addMouseListener(new MouseListener() {
                  @Override
                  public void mouseClicked(MouseEvent e) {
                        if (current < max) 
                              current++;
                        repaint();
                  }

                  @Override public void mouseEntered(MouseEvent e) {}
                  @Override public void mouseExited(MouseEvent e) {}
                  @Override public void mousePressed(MouseEvent e) {}
                  @Override public void mouseReleased(MouseEvent e) {}
            });

            // adds it all together
            this.add(barComp);
            this.add(button);

            // sets some default variables
            margin = 0.66;
            max = 1;
      }

      // Sets preferred size of all components
      @Override
      public void setPreferredSize(Dimension d) {
            super.setPreferredSize(d);
            this.setMaximumSize(this.getPreferredSize());

            updateComponents();
      }

      // Updates the preferred size of the components
      private void updateComponents() {
            Dimension d = this.getPreferredSize();

            int width = (int) d.getWidth(); 
            int height = (int) d.getHeight();

            int mWidth = (int) (width * margin);

            barComp.setPreferredSize(new Dimension(mWidth, height));
            barComp.setMaximumSize(barComp.getPreferredSize());

            button.setPreferredSize(new Dimension(width-mWidth, height));
            button.setMaximumSize(button.getPreferredSize());
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
                  barColour = Color.BLACK;
                  barBackground = Color.WHITE;
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
            button.setLabel(s);
      }
      public void setButtonForeground(Color c) {
            button.setForeground(c);
      }
      public void setButtonBackground(Color c) {
            button.setBackground(c);
      }

      // Other setters 
      public void setMargin(double i) {
            if (i > 0 && i < 1) {
                  margin = i;
                  updateComponents();
            }
            else {
                  throw new IllegalArgumentException(
                        "Margin must be between 0 and 1 non-inclusive"
                  );
            }
      } 
      public void setMax(int i) {
            if (i > 0)
                  max = i;
      }

      // Getter
      public int getCurrent() {
            return current;
      }
}
