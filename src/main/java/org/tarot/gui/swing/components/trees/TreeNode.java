package org.tarot.gui.swing.components.trees;

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * 
 * @author Théophile Dano
 *
 */
public class TreeNode extends DefaultMutableTreeNode {

    private String text;
    private Icon collapsedIcon;
    private Icon expandedIcon;

    public TreeNode(Icon icon, String text) {
        this.collapsedIcon = icon;
        this.expandedIcon = icon;
        this.text = text;
    }

    public TreeNode(Icon collapsedIcon, Icon expandedIcon, String text) {
        this.collapsedIcon = collapsedIcon;
        this.expandedIcon = expandedIcon;
        this.text = text;
    }

    public Icon getCollapsedIcon() {
        return collapsedIcon;
    }

    public Icon getExpandedIcon() {
        return expandedIcon;
    }

    public String getText() {
        return text;
    }
}
