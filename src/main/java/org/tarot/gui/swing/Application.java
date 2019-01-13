package org.tarot.gui.swing;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.tree.DefaultTreeModel;

import org.tarot.gui.icons.Icons;
import org.tarot.gui.swing.components.buttons.IconButton;
import org.tarot.gui.swing.components.buttons.RadioButton;
import org.tarot.gui.swing.components.buttons.ToggleButton;
import org.tarot.gui.swing.components.panels.ToolbarPanel;
import org.tarot.gui.swing.components.panels.TreeViewPanel;
import org.tarot.gui.swing.components.trees.TreeNode;

import net.miginfocom.swing.MigLayout;

public class Application {

    private JFrame frame;
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("ToolTip.background", Color.WHITE);
            UIManager.put("ToolTip.border", new MatteBorder(1, 1, 1, 1, Color.GRAY));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Application window = new Application();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Application() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[grow][grow][25px]"));
        TreeViewPanel treeViewPanel = new TreeViewPanel(Icons.CATEGORY, "TreeView");
        TreeNode root = new TreeNode(Icons.PROJECT_CLOSED, Icons.PROJECT_OPEN, "Project");
        TreeNode folder = new TreeNode(Icons.FOLDER_CLOSED, Icons.FOLDER_OPEN, "Folder");
        folder.add(new TreeNode(Icons.FILE, "File"));
        root.add(folder);
        DefaultTreeModel model = new DefaultTreeModel(root);
        treeViewPanel.setTreeModel(model);
        treeViewPanel.registerToolbarComponent(new IconButton(Icons.PROJECT_OPEN));
        treeViewPanel.registerToolbarComponent(new ToggleButton(Icons.PROJECT_CLOSED));
        frame.getContentPane().add(treeViewPanel, "cell 0 0,grow");
        IconButton cnstbtnTest = new RadioButton("Exception");
        cnstbtnTest.addActionListener(e -> {
            // new ExceptionFrame(new Exception("Test")).setVisible(true);
        });
        frame.getContentPane().add(cnstbtnTest, "cell 1 0,alignx left,aligny top");
        ToolbarPanel toolbarPanel_1 = new ToolbarPanel(Icons.BUG, "Bugs");
        frame.getContentPane().add(toolbarPanel_1, "cell 0 1 1 2,grow");
    }
}
