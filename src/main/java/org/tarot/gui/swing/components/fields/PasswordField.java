package org.tarot.gui.swing.components.fields;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;

/**
 * 
 * @author Théophile Dano
 *
 */
public class PasswordField extends JPasswordField {

    public PasswordField() {
        super();
        setBorder(TextField.DEFAULT_BORDER);
        addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(TextField.DEFAULT_BORDER);
            }

            @Override
            public void focusGained(FocusEvent e) {
                setBorder(TextField.FOCUSED_BORDER);
            }
        });
    }
}
