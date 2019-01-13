package org.tarot.gui.swing.components.trees;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTreeUI;

import org.tarot.gui.icons.Icons;

/**
 * 
 * @author Théophile Dano
 *
 */
public class TreeView extends JTree {

    static {
        UIManager.put("Tree.collapsedIcon", Icons.COMPONENT_COLLAPSED);
        UIManager.put("Tree.expandedIcon", Icons.COMPONENT_EXPANDED);
        UIManager.put("Tree.leafIcon", Icons.FILE);
        UIManager.put("Tree.openIcon", Icons.FOLDER_OPEN);
        UIManager.put("Tree.closedIcon", Icons.FOLDER_CLOSED);
        UIManager.put("Tree.selectionBackground", new Color(221, 238, 255));
        UIManager.put("Tree.selectionForeground", Color.BLACK);
        UIManager.put("Tree.selectionBorderColor", new Color(206, 221, 237));
    }

    public TreeView(boolean showLines) {
        super();
        setShowsRootHandles(true);
        setUI(new BasicTreeUI() {

            @Override
            protected void paintHorizontalLine(Graphics g, JComponent c, int y, int left, int right) {
                if (showLines) {
                    super.paintHorizontalLine(g, c, y, left, right);
                }
            }

            @Override
            protected void paintVerticalLine(Graphics g, JComponent c, int x, int top, int bottom) {
                if (showLines) {
                    super.paintVerticalLine(g, c, x, top, bottom);
                }
            }
        });
    }
}
