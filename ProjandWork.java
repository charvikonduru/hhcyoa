import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        private String story1 = "You can't give up either one, so why not do both? They're both available " +
                "as opportunities after all. You work on your project, and attend a couple workshops. Your " +
                "project was great, but unfortunately didn't win any prizes. That's okay though! You had a lot " +
                "of fun making the project, and you really enjoyed the workshops you attended. You made some new " +
                "friends, and a lot of wonderful memories. But, all that being said, what workshops DID you attend?";

        public DrawingPanel() {
            setLayout(new BorderLayout()); // Ensure proper layout
            setBackground(new Color(169, 117, 156));
            // Panel for buttons (placed at the bottom)
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.setOpaque(false);

            JButton workshop1Button = new JButton("Workshop 1");
            JButton workshop2Button = new JButton("Workshop 2");

            // Add ActionListener to button
            workshop1Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Workshop1(); // Open Workshop1 window
                }
            });
            workshop2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Workshop2(); // Open Workshop1 window
                }
            });

            // Add button to panel and panel to layout
            buttonPanel.add(workshop1Button);
            buttonPanel.add(workshop2Button);
            add(buttonPanel, BorderLayout.SOUTH);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.drawString("You chose to do both.", 10, 40);

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
