import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    private String story1 = "You are a college student participating in the HooHacks 2025 Hackathon. " +
            "You are extremely excited, and are eagerly awaiting for the time when you can work on your " +
            "very own project to submit for the competition.";

    public DrawingPanel() {
        setLayout(new BorderLayout()); // Use BorderLayout
        setBackground(new Color(124, 44, 3)); // Background color

        // Panel for buttons (placed at the bottom)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);

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

        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 20));
        g.drawString("Choose Your Own Adventure: HooHacks", 10, 40);
        g.setFont(new Font("Serif", Font.PLAIN, 15));

        int x = 10;
        int y = 80;
        int maxWidth = getWidth() - 50; // Max width for text wrapping

        List<String> lines = wrapText(story1, g, maxWidth);

        for (String line : lines) {
            g.drawString(line, x, y);
            y += g.getFontMetrics().getHeight(); // Move down for next line
        }
    }

    private List<String> wrapText(String text, Graphics g, int maxWidth) {
        FontMetrics fm = g.getFontMetrics();
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();

        for (String word : text.split(" ")) {
            if (fm.stringWidth(line + word) > maxWidth) {
                lines.add(line.toString()); // Add current line to list
                line = new StringBuilder(word); // Start new line
            } else {
                if (!line.isEmpty()) {
                    line.append(" ");
                }
                line.append(word);
            }
        }
        lines.add(line.toString()); // Add the last line

        return lines;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Project Only")) {
            story1 = "You chose Project Only. This text should automatically wrap to fit within the window.";
        } else if (s.equals("Workshops Only")) {
            story1 = "You chose Workshops Only. If the text is long enough, it will wrap to the next line.";
        } else if (s.equals("Project and Workshops")) {
            story1 = "You chose both Project and Workshops. The text-wrapping method makes sure all text stays within the window.";
        }

        repaint(); // Refresh panel to show new text
    }
}
