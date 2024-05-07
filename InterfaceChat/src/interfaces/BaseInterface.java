package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseInterface extends JFrame {

    private JPanel panel;
    private JTextField textField;
    private JButton sendButton;
    private JPanel chatPanel;

    public BaseInterface() {
        setTitle("Chat Interface");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(chatPanel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        textField = new JTextField(20);
        sendButton = new JButton("Enviar");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        inputPanel.add(textField);
        inputPanel.add(sendButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.SOUTH);
        getContentPane().add(panel);
    }

    private void sendMessage() {
        String message = textField.getText();
        if (!message.isEmpty()) {
            appendToChat("Kleber", message, "your_image.jpg");
            textField.setText("");
        }
    }

    public void appendToChat(String name, String message, String imagePath) {
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel(name);
        messagePanel.add(nameLabel);
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        messagePanel.add(imageLabel);
        JLabel messageLabel = new JLabel(message);
        messagePanel.add(messageLabel);
        chatPanel.add(messagePanel);
        chatPanel.revalidate(); 
        chatPanel.repaint(); 
    }
}
