package org.tarot.gui.swing.components.labels;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.tarot.gui.icons.Icons;

/**
 * 
 * @author Th�ophile Dano
 *
 */
public class SuggestionLabel extends JLabel {

    public SuggestionLabel(String text) {
        super(Icons.TIP);
        setText(text);
        setHorizontalAlignment(SwingUtilities.LEADING);
    }
}
