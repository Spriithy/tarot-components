package org.tarot.gui.swing.components.labels;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.tarot.gui.icons.Icons;

/**
 * 
 * @author Th�ophile Dano
 *
 */
public class WarningLabel extends JLabel {

    public WarningLabel(String text) {
        super(Icons.WARNING);
        setText(text);
        setHorizontalAlignment(SwingUtilities.LEADING);
    }
}
