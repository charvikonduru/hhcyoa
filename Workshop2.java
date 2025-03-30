import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Workshop2 extends JFrame {
    public Workshop2() {
        setTitle("Workshop 2");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);

        // Set the custom panel
        DrawingPanel drawingPanel = new DrawingPanel();
        setContentPane(drawingPanel);

        setVisible(true);
    }

    // Inner JPanel class for drawing content
    class DrawingPanel extends JPanel {
        private String story1 = "Welcome to Workshop 2! In this session, you will learn new coding techniques " +
                "and collaborate with fellow participants. Get ready for an engaging experience!";

        public DrawingPanel() {
            setBackground(new Color(169, 117, 156)); // Set background color
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.drawString("Welcome to Workshop 2!", 10, 40);

            g.setFont(new Font("Serif", Font.PLAIN, 15));

            int x = 10;
            int y = 80;
            int maxWidth = getWidth() - 50; // Adjust text width

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
                    lines.add(line.toString());
                    line = new StringBuilder(word);
                } else {
                    if (!line.isEmpty()) {
                        line.append(" ");
                    }
                    line.append(word);
                }
            }
            lines.add(line.toString());

            return lines;
        }
    }
}
