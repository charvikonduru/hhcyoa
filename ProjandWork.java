import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProjandWork extends JFrame{
    public ProjandWork() {
        setTitle("Project and Workshops");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);

        // Set the custom panel
        ProjandWork.DrawingPanel drawingPanel = new ProjandWork.DrawingPanel();
        setContentPane(drawingPanel);

        setVisible(true);
    }

    class DrawingPanel extends JPanel {
        private String story1 = "You are now in the Projects and Workshops zone! ";

        public DrawingPanel() {
            setBackground(new Color(169, 117, 156));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.drawString("Welcome to the Projects and Workshops path!", 10, 40);

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
