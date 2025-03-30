import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Beginning {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Beginning");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            // Set the custom panel
            DrawingPanel drawingPanel = new DrawingPanel();
            frame.setContentPane(drawingPanel);

            frame.setVisible(true);
        });
    }
}

class DrawingPanel extends JPanel implements ActionListener {
    private String storyText = "Hi"; // The text that updates

    public DrawingPanel() {
        setLayout(new BorderLayout()); // Use BorderLayout
        setBackground(new Color(124, 44, 3)); // Background color

        // Panel for buttons (placed at the bottom)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center buttons
        buttonPanel.setOpaque(false); // Make sure it blends with the background

        // Buttons
        JButton projButton = new JButton("Project Only");
        JButton workButton = new JButton("Workshops Only");
        JButton bothButton = new JButton("Project and Workshops");

        // Add action listeners
        projButton.addActionListener(this);
        workButton.addActionListener(this);
        bothButton.addActionListener(this);

        // Add buttons to the panel
        buttonPanel.add(projButton);
        buttonPanel.add(workButton);
        buttonPanel.add(bothButton);

        // Add the button panel to the bottom
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set text color and font
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 20));

        // Draw text on screen (x, y coordinates)
        g.drawString("HooHacks: Choose Your Own Adventure", 50, 50);
        g.drawString(storyText, 50, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Project Only")) {
            storyText = "You chose Project Only.";
        } else if (s.equals("Workshops Only")) {
            storyText = "You chose Workshops Only.";
        } else if (s.equals("Project and Workshops")) {
            storyText = "You chose both Project and Workshops.";
        }

        // Refresh the panel to show updated text
        repaint();
    }
}
