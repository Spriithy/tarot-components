package org.tarot.gui.swing.components.buttons;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.StringUtils;
import org.tarot.gui.icons.Icons;

/**
 * 
 * @author Théophile Dano
 *
 */
public class IconButton extends JButton {

    protected static final Color FREE_BACKGROUND_COLOR = new Color(0, 0, 0, 0);
    protected static final Color FREE_BORDER_COLOR = new Color(0, 0, 0, 0);
    protected static final Color ROLLOVER_BACKGROUND_COLOR = new Color(126, 201, 253, 89);
    protected static final Color ROLLOVER_BORDER_COLOR = new Color(126, 201, 253, 206);
    protected static final Color PRESSED_BACKGROUND_COLOR = new Color(126, 201, 253, 147);
    protected static final Color PRESSED_BORDER_COLOR = new Color(84, 170, 232, 249);

    public IconButton() {
        setBorder(new EmptyBorder(2, 2, 2, 2));
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    public IconButton(String text) {
        this();
        setText(text);
    }

    public IconButton(ImageIcon icon) {
        this();
        setIcon(icon);
    }

    public IconButton(ImageIcon icon, String text) {
        this(icon);
        setText(text);
    }

    @Override
    public void setText(String text) {
        if (StringUtils.isBlank(text)) {
            setBorder(new EmptyBorder(2, 2, 2, 2));
        } else {
            setBorder(new EmptyBorder(2, 2, 2, 6));
        }
        super.setText(text);
    }

    public void setIcon(ImageIcon icon) {
        super.setIcon(icon);
        setRolloverIcon(icon);
        setPressedIcon(icon);
        setDisabledIcon(Icons.disabled(icon));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color bgColor = FREE_BACKGROUND_COLOR;
        Color borderColor = FREE_BORDER_COLOR;
        if (getModel().isPressed()) {
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
