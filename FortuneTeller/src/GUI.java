import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @class GUI
 * @brief UI for Fortune Teller
 * @author Harshini Bellamkonda
 */
public class GUI implements ActionListener {
    static JTextField textField;
    static JFrame frame;
    static JButton button;
    static JLabel output;
    static JLabel title;
    static JButton anotherButton;
    static JPanel panel;

    GUI(){}

    public static void main(String[] args) {
        title = new JLabel("Please enter a number.");
        frame = new JFrame("Fortune Teller");
        output = new JLabel("Waiting for user response... :)");
        button = new JButton("Submit");
        anotherButton = new JButton("Select for another fortune!");
        GUI te = new GUI();

        button.addActionListener(te);
        anotherButton.addActionListener(te);

        textField = new JTextField(16);
        panel = new JPanel();

        panel.add(title);
        panel.add(textField);
        panel.add(button);
        panel.add(output);

        frame.add(panel);

        frame.setSize(500, 500);

        frame.show();
    }


    /**
     * @brief action performed for JButton
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e)
    {
        FortuneTeller f = new FortuneTeller();
        String s = e.getActionCommand();
        if (s.equals("Submit")) {
            try {
                Integer.parseInt(textField.getText());
            }
            catch (Exception ex){
                output.setText("Error: Please enter a number.");
                textField.setText("");
            }
            output.setText("YOUR FORTUNE: " + f.tellFortune(Integer.parseInt(textField.getText())));
            textField.setText("");
            panel.add(anotherButton);
        }
        if (s.equals("Select for another fortune!")) {
            output.setText("");
            textField.setText("");

        }
    }
}
