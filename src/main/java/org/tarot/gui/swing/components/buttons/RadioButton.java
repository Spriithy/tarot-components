package org.tarot.gui.swing.components.buttons;

import org.tarot.gui.icons.Icons;

/**
 * 
 * @author Théophile Dano
 *
 */
public class RadioButton extends IconButton {

    private boolean checked;

    public RadioButton(String text) {
        super(Icons.RADIO_DISABLED, text);
        addActionListener(e -> switchState());
        checked = false;
    }

    public RadioButton(String text, boolean checked) {
        super(checked ? Icons.RADIO_ENABLED : Icons.RADIO_DISABLED, text);
        addActionListener(e -> switchState());
        this.checked = checked;
    }

    private void switchState() {
        checked = !checked;
        if (checked) {
            setIcon(Icons.RADIO_ENABLED);
        } else {
            setIcon(Icons.RADIO_DISABLED);
        }
    }
}
