package org.tarot.gui.swing.components.panels;

import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.TreeModel;

import org.tarot.gui.swing.components.trees.TreeNodeRenderer;
import org.tarot.gui.swing.components.trees.TreeView;

/**
 * 
 * @author Théophile Dano
 *
 */
public class TreeViewPanel extends ToolbarPanel {

    private TreeView tree;
    private JScrollPane scrollPane;

    /**
     * @wbp.parser.constructor
     */
    public TreeViewPanel(String title) {
        super(title);
        initialize();
    }

    public TreeViewPanel(Icon icon, String title) {
        super(icon, title);
        initialize();
    }

    public void setTreeModel(TreeModel model) {
        tree.setModel(model);
    }

    private void initialize() {
        tree = new TreeView(false);
        tree.setCellRenderer(new TreeNodeRenderer());
        scrollPane = new JScrollPane(tree);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        getContentPanel().add(scrollPane);
    }
}
