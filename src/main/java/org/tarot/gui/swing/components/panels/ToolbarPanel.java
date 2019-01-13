package org.tarot.gui.swing.components.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Théophile Dano
 *
 */
public class ToolbarPanel extends JPanel {

    private JPanel toolbar;
    private JLabel toolbarTitle;
    private JPanel toolbarIconGroup;
    private JPanel contentPanel;

    /**
     * @wbp.parser.constructor
     */
    public ToolbarPanel(String title) {
        setBackground(Color.WHITE);
        setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        setLayout(new MigLayout("insets 0 0 0 1, gapy 1", "[grow]", "[][grow]"));
        toolbar = new JPanel();
        toolbar.setBorder(new MatteBorder(0, 0, 1, 0, new Color(150, 150, 150)));
        toolbar.setBackground(new Color(206, 221, 237));
        add(toolbar, "cell 0 0,grow");
        toolbar.setLayout(new MigLayout("insets 1", "[][][grow]", "[grow]"));
        toolbarTitle = new JLabel(title);
        toolbarTitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
        toolbarTitle.setBorder(new EmptyBorder(2, 2, 2, 2));
        toolbar.add(toolbarTitle, "cell 0 0,alignx left,aligny baseline");
        toolbarIconGroup = new JPanel();
        toolbarIconGroup.setBackground(toolbar.getBackground());
        toolbar.add(toolbarIconGroup, "cell 2 0,grow");
        toolbarIconGroup.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        add(contentPanel, "cell 0 1,grow");
        contentPanel.setLayout(new BorderLayout(0, 0));
    }

    public ToolbarPanel(Icon icon, String title) {
        this(title);
        toolbarTitle.setIcon(icon);
    }

    public JPanel getToolBar() {
        return toolbar;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void registerToolbarComponent(Component component) {
        toolbarIconGroup.add(component, 0);
    }
}
