import java.awt.*;
import javax.swing.*;

// This class stores game data
// TODO clean up this code
final public class Data {
      private static int resource;
      private static JLabel label;

      public static int getResource() {
            return resource;
      }

      public static void setResource(int input) {
            resource = input;
            label.setText("Power: " + resource);
      }

      public static void addResource(int input) {
            resource += input;
            label.setText("Power: " + resource);
      }

      public static boolean subResource(int input) {
            final boolean valid = (resource >= input);
            if (valid)
                  resource -= input;
            label.setText("Power: " + resource);
            return valid; 
      }

      public static void setLabel(JLabel in) {
            label = in;
      }

      private Data() {}
}
