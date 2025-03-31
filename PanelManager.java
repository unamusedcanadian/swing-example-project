import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.util.ArrayList;

public class PanelManager extends JLayeredPane /* implements MouseListener */ {
      private JPanel mainPanel;
      private GridBagConstraints GBConst;
      private Tooltip tooltip;

      public PanelManager() {
            super();
            this.setLayout(new GridBagLayout());
            GBConst = new GridBagConstraints();
            
            mainPanel = new JPanel();
            mainPanel.setBackground(Color.GREEN); // Testing code
            tooltip = new Tooltip();

            this.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
            // this.add(tooltip, JLayeredPane.MODAL_LAYER);
      }

      // Keeps the PanelManager size and mainPanel size synced
      @Override
      public void setPreferredSize(Dimension d) {
            super.setPreferredSize(d);
            mainPanel.setPreferredSize(d);
      }

      // Adds component to the mainPanel
      public void addComp(Component c) {
            if (c instanceof TooltipAPI) {
                  TooltipAPI t = (TooltipAPI) c;
                  t.setTooltip(tooltip);
            }
            mainPanel.add(c);
      }
}
