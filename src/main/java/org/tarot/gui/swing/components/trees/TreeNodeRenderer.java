package org.tarot.gui.swing.components.trees;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * 
 * @author Théophile Dano
 *
 */
public class TreeNodeRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
                    int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        TreeNode node = (TreeNode) value;
        if (expanded) {
            setIcon(node.getExpandedIcon());
        } else {
            setIcon(node.getCollapsedIcon());
        }
        setText(node.getText());
        return this;
    }
}
