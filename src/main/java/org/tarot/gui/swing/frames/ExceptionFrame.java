package org.tarot.gui.swing.frames;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import org.tarot.gui.icons.Icons;
import org.tarot.gui.swing.components.buttons.ToggleButton;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Théophile Dano
 *
 */
public class ExceptionFrame extends JFrame {

    public ExceptionFrame(Exception exception) {
        Image exceptionImage = null;
        try {
            exceptionImage = ImageIO.read(ClassLoader.getSystemResource("exception_large.png"));
            setIconImage(exceptionImage);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(420, 172);
        setTitle(exception.getClass().getSimpleName());
        getContentPane().setLayout(new MigLayout("hidemode 3", "[][grow][][]", "[][25px][grow]"));
        JLabel label = new JLabel(new ImageIcon(exceptionImage));
        getContentPane().add(label, "cell 0 0,alignx left,aligny top");
        JTextPane text = new JTextPane();
        text.setText("Unhandled exception occured in your application. If you click Continue, the application will ignore this error and attempt to continue. If you click Terminate, the application will terminate the current task and resume to normal state.\n\n"
                        + exception.getMessage());
        text.setEditable(false);
        text.setBackground(UIManager.getColor("Panel.background"));
        getContentPane().add(text, "cell 1 0 3 1,grow");
        ToggleButton button = new ToggleButton(Icons.DOWN, Icons.UP, "Details");
        getContentPane().add(button, "cell 0 1,grow");
        JButton btnContinue = new JButton("Continue");
        btnContinue.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        btnContinue.setIcon(Icons.RESUME);
        getContentPane().add(btnContinue, "cell 2 1,grow");
        JButton btnQuit = new JButton("Terminate");
        btnQuit.setIcon(Icons.STOP);
        btnQuit.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        btnQuit.addActionListener(e -> dispose());
        getContentPane().add(btnQuit, "cell 3 1,grow");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        getContentPane().add(scrollPane, "cell 0 2 4 1,grow");
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textPane.setBackground(new Color(240, 240, 240));
        textPane.setText(getStackTrace(exception));
        scrollPane.setViewportView(textPane);
        scrollPane.setVisible(false);
        button.addActionListener(e -> {
            scrollPane.setVisible(!scrollPane.isVisible());
            if (scrollPane.isVisible()) {
                setSize(420, 480);
            } else {
                setSize(420, 172);
            }
            invalidate();
            revalidate();
        });
    }

    public static String getStackTrace(Exception e) {
        StringBuilder sb = new StringBuilder(e.getClass().getCanonicalName() + ": " + e.getMessage() + "\n");
        StackTraceElement[] trace = e.getStackTrace();
        for (StackTraceElement traceElement : trace) {
            sb.append("\tat " + traceElement + "\n");
        }
        return sb.toString();
    }
}
