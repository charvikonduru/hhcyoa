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
            "You are extremely excited, and are eagerly awaiting the time that the hackathon begins. " +
            "Once the hackathon begins, you look at the " +
            "schedule on the HooHacks website, and notice that there are many fun workshops being offered! " +
            "You can just work on the project for the competition, or you can attend the workshops as well. " +
            "You continue looking through the list of workshops, and realize that a lot of them look very " +
            "exciting. But, you have to work on the project, right? You can't attend them all. However, your " +
            "friend then comes and tells you that if you wanted, you can just attend the workshops if you didn't mind " +
            "losing your chance to win prizes for the project. But, winning a prize sure sounds nice. Now, you " +
            "have three options: you can dedicate all " +
            "your time to the project to maximize your chances of winning a prize, you can skip the project " +
            "and only go for the workshops (after all, you can always just do a personal project later), " +
            "or you can work on the project and attend some workshops while you're at it. What will you choose?";

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
        g.setFont(new Font("Serif", Font.PLAIN, 12));
        g.drawString("Note: Expand to full screen to play.", 10, 60);
        g.setFont(new Font("Serif", Font.PLAIN, 15));

        int x = 10;
        int y = 100;
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
            // Open ProjectOnly window
            SwingUtilities.invokeLater(() -> {
                new ProjectOnly(); // Assuming ProjectOnly extends JFrame
            });
        } else if (s.equals("Workshops Only")) {
            // Open Workshops Only window
            SwingUtilities.invokeLater(() -> {
                new WorkshopsOnly();
            });
        } else if (s.equals("Project and Workshops")) {
            // Open ProjandandWork window
            SwingUtilities.invokeLater(() -> {
                new ProjandWork();
            });
        }

        repaint(); // Refresh panel to show new text
    }
}
