import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WorkshopsOnly extends JFrame{
    public WorkshopsOnly() {
        setTitle("Workshops Only");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);

        // Set the custom panel
        WorkshopsOnly.DrawingPanel drawingPanel = new WorkshopsOnly.DrawingPanel();
        setContentPane(drawingPanel);

        setVisible(true);
    }

    class DrawingPanel extends JPanel {
        private String story1 = "You are now in the Workshops Only zone! ";

        public DrawingPanel() {
            setBackground(new Color(210, 136, 76));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.drawString("Welcome to the Workshops-Only path!", 10, 40);

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
