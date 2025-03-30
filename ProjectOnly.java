import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectOnly extends JFrame {
    public ProjectOnly() {
        setTitle("Project Only");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);

        // Set the custom panel
        DrawingPanel drawingPanel = new DrawingPanel();
        setContentPane(drawingPanel);

        setVisible(true);
    }

    class DrawingPanel extends JPanel {
        private String story1 = "You really badly want to win a prize, more so than you want to attend the " +
                "workshops. You fill yourself up with food and caffeine, and get to work. With the 24 hours that " +
                "you have, you manage to create a project so amazing that you win Best Overall. You get an " +
                "amazing prize, and go home with a grin from ear to ear, proud of yourself for what you've accomplished. THE END";

        public DrawingPanel() {
            setBackground(new Color(55, 98, 14));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.drawString("You chose to only work on the project.", 10, 40);

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
