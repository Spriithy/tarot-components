package org.tarot.gui.swing.components.buttons;

import org.tarot.gui.icons.Icons;

/**
 * 
 * @author Théophile Dano
 *
 */
public class CheckBox extends IconButton {

    private boolean checked;

    public CheckBox(String text) {
        super(Icons.DISABLED, text);
        addActionListener(e -> switchState());
        checked = false;
    }

    public CheckBox(String text, boolean checked) {
        super(checked ? Icons.ENABLED : Icons.DISABLED, text);
        addActionListener(e -> switchState());
        this.checked = checked;
    }

    private void switchState() {
        checked = !checked;
        if (checked) {
            setIcon(Icons.ENABLED);
        } else {
            setIcon(Icons.DISABLED);
        }
    }
}
