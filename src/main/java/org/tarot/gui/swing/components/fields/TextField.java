package org.tarot.gui.swing.components.fields;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 * 
 * @author Théophile Dano
 *
 */
public class TextField extends JTextField {

    public static final Border FOCUSED_BORDER = new CompoundBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 120, 215)),
                    new EmptyBorder(2, 2, 2, 2));
    public static final Border DEFAULT_BORDER = new CompoundBorder(
                    new MatteBorder(1, 1, 1, 1, new Color(139, 150, 171)), new EmptyBorder(2, 2, 2, 2));

    public TextField() {
        super();
        setBorder(DEFAULT_BORDER);
        addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(DEFAULT_BORDER);
            }

            @Override
            public void focusGained(FocusEvent e) {
                setBorder(FOCUSED_BORDER);
            }
        });
    }

    public TextField(String text) {
        this();
        setText(text);
    }
}
