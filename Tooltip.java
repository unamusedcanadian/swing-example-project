import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Small and simple text panel
public class Tooltip extends JPanel {
      private JLabel label;

      public Tooltip() {
            super();
            label = new JLabel();
            add(label);
      }

      public void setText(String s) {
            label.setText(s);
      }
}
