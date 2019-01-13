package org.tarot.gui.swing.components.buttons;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * 
 * @author Théophile Dano
 *
 */
public class ToggleButton extends IconButton {

    private ImageIcon iconOff;
    private ImageIcon iconOn;
    private String textOff;
    private String textOn;
    private boolean on;

    public ToggleButton(String text) {
        this(null, null, text, text);
    }

    public ToggleButton(String textOff, String textOn) {
        this(null, null, textOff, textOn);
    }

    public ToggleButton(ImageIcon icon) {
        this(icon, icon, null, null);
    }

    public ToggleButton(ImageIcon iconOff, ImageIcon iconOn) {
        this(iconOff, iconOn, null, null);
    }

    public ToggleButton(ImageIcon icon, String text) {
        this(icon, icon, text, text);
    }

    public ToggleButton(ImageIcon iconOff, ImageIcon iconOn, String text) {
        this(iconOff, iconOn, text, text);
    }

    public ToggleButton(ImageIcon iconOff, ImageIcon iconOn, String textOff, String textOn) {
        super();
        this.iconOff = iconOff;
        this.iconOn = iconOn;
        this.textOff = textOff;
        this.textOn = textOn;
        on = false;
        setIcon(iconOff);
        setText(textOff);
        addActionListener(e -> toggle());
    }

    public void toggle() {
        on = !on;
        setIcon(on ? iconOn : iconOff);
        setText(on ? textOn : textOff);
    }

    @Override
    public void setSelected(boolean b) {
        if (b ^ on) {
            toggle();
        }
    }

    @Override
    public boolean isSelected() {
        return on;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color bgColor = FREE_BACKGROUND_COLOR;
        Color borderColor = FREE_BORDER_COLOR;
        if (getModel().isPressed() || on) {
            bgColor = PRESSED_BACKGROUND_COLOR;
            borderColor = PRESSED_BORDER_COLOR;
        } else if (getModel().isRollover()) {
            bgColor = ROLLOVER_BACKGROUND_COLOR;
            borderColor = ROLLOVER_BORDER_COLOR;
        }
        g.setColor(bgColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(borderColor);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        super.paintComponent(g);
    }
}
