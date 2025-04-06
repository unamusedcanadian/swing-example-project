import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

// Creates the application
public class App extends JFrame {
      // Static variables
      private static int resource;
      private static JLabel label;

      // Keeps track of created button objects
      private ArrayList buttons;

      // Creates and formats the JFrame and its components
      public App(String s) {
            // Creates and formats the JFrame
            super(s);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setLayout(new GridLayout(4,1));
            this.setPreferredSize(new Dimension(1280, 720));
            this.setMinimumSize(new Dimension(480, 270));

            // Formatting
            JPanel topLayerSplit = new JPanel(new GridLayout(1,3));
            JPanel gridBagPanel1 = new JPanel(new GridBagLayout());
            JPanel gridBagPanel2 = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            // Creates and formats JTextField
            JTextField textField = new JTextField(7);
            textField.addActionListener(new ActionListener() {
                  // Whenever enter is pressed
                  public void actionPerformed(ActionEvent evt) {
                        String s = textField.getText();
                        Color c = null;
                        // See if the input is a valid colour hex code
                        try {
                              c = new Color(Integer.parseInt(s, 16));
                        } catch(Exception e) {
                              // If not, do nothing
                              return;
                        }
                        // If so, make all the bars that colour
                        for (Object o : buttons) {
                              ResourceButton b = (ResourceButton) o;
                              b.setBarColour(c);
                        }
                  }
            });
            gridBagPanel1.add(textField, gbc);

            // Creates and formats JLabel
            label = new JLabel();
            label.setFont(new Font(label.getFont().getName(), Font.BOLD, 20));
            gbc.anchor = GridBagConstraints.CENTER;
            gridBagPanel2.add(label, gbc);

            // Adds objects to formatted JPanel
            topLayerSplit.add(gridBagPanel1);
            topLayerSplit.add(gridBagPanel2);
            topLayerSplit.add(new JLabel());

            // Make ResourceButtons
            ResourceButton b1 = makeButton(10, 10, 1); 
            b1.setLabel("Portable Generator");

            ResourceButton b2 = makeButton(5, 50, 5);
            b2.setLabel("Hydroelectric Dam");

            ResourceButton b3 = makeButton(1, 1000, 100);
            b3.setLabel("Nuclear Reactor");
            b3.setBarColour(Color.BLUE);

            // Add ResourceButtons to array
            buttons = new ArrayList<ResourceButton>();
            buttons.add(b1);
            buttons.add(b2);
            buttons.add(b3);

            // Add ResourceButtons and formatted JPanel to JFrame
            this.add(topLayerSplit);
            for (Object o : buttons) {
                  ResourceButton b = (ResourceButton) o;
                  this.add(b);
            }

            resource = 10; 
            label.setText("Power: " + resource);

            this.pack();
            this.setVisible(true);

            update();
      }

      // Makes the creation of ResourceButton objects a little more discreet
      private ResourceButton makeButton(int max, int cost, int income) {
            ResourceButton b = new ResourceButton();
            b.setMax(max);
            b.setCost(cost);
            b.setIncome(income);
            return b;
      }

      // Update loop for the game that runs every second
      private void update() {
            while (true) {
                  try { Thread.sleep(1000); }
                  catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                  }
                  for (Object o : buttons) {
                        ResourceButton b = (ResourceButton) o;
                        resource += b.getIncome();
                  }
                  label.setText("Power: " + resource);
            }
      }

      // API for other classes to interact with resource
      public static boolean subResource(int input) {
            boolean valid = (resource >= input);
            if (valid) {
                  resource -= input;
                  label.setText("Power: " + resource);
            }
            return valid;
      }
}

