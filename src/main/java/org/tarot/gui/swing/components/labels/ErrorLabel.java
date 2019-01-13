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
public class ErrorLabel extends JLabel {

    public ErrorLabel(String text) {
        super(Icons.ERROR);
        setText(text);
        setForeground(new Color(255, 151, 151));
        setHorizontalAlignment(SwingUtilities.LEADING);
    }
}
