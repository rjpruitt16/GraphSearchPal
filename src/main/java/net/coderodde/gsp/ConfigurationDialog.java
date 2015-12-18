package net.coderodde.gsp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import net.coderodde.gsp.model.support.DijkstraPathFinder;

/**
 * This class implements a dialog window for configuring the visualization.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 18, 2015)
 */
public class ConfigurationDialog extends JDialog {
   
    private GraphPal pal;
    private final JButton searchButton = new JButton("Search");
    
    public ConfigurationDialog() {
        this.setTitle("Configuration");
        this.getContentPane().add(searchButton);
        searchButton.addActionListener(new SearchActionListener());
    }
    
    public void setGraphPal(GraphPal pal) {
        this.pal = pal;
    }
    
    private final class SearchActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pal.runShortestPathFinder(
                    new DijkstraPathFinder<>(pal.getWeightFunction()));
        }
    }
}
