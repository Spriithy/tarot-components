package org.tarot.gui.swing.components.labels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.tarot.gui.icons.Icons;

/**
 * 
 * @author Théophile Dano
 *
 */
public class HelpLabel extends JLabel {

    public HelpLabel(String text) {
        super(Icons.HELP);
        setText(text);
        setForeground(new Color(0, 51, 153));
        setHorizontalAlignment(SwingUtilities.LEADING);
    }
}
