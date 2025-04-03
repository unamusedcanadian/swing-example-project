import java.awt.*;
import javax.swing.*;

// Global variables and methods associated with them
final public class Data {
      private static int resource = 0;
      private static JLabel label = new JLabel();

      public static int getResource() {
            return resource;
      }

      public static void setResource(int input) {
            resource = input;
      }

      public static void addResource(int input) {
            resource += input;
      }

      public static boolean subResource(int input) {
            final boolean valid = (resource >= input);
            if (valid)
                  resource -= input;
            return valid; 
      }

      public static JLabel getLabel() {
            return label;
      }

      public static void updateLabel() {
            label.setText("Power: " + resource);
      }

      private Data() {}
}
