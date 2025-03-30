import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class WorkshopsOnly extends JFrame {
    public WorkshopsOnly() {
        setTitle("Workshops Only");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);

        // Set the custom panel
        DrawingPanel drawingPanel = new DrawingPanel();
        setContentPane(drawingPanel);

        setVisible(true);
    }

    class DrawingPanel extends JPanel {
        private String story1 = "You are now in the Workshops Only zone! ";

        public DrawingPanel() {
            setLayout(new BorderLayout()); // Ensure proper layout
            setBackground(new Color(210, 136, 76));

            // Panel for buttons (placed at the bottom)
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.setOpaque(false);

            JButton workshop1Button = new JButton("Workshop 1");
            JButton workshop2Button = new JButton("Workshop 2");
            JButton workshop3Button = new JButton("Workshop 3");
            JButton workshop4Button = new JButton("Workshop 4");
            JButton workshop5Button = new JButton("Workshop 5");

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
            workshop3Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Workshop3(); // Open Workshop1 window
                }
            });
            workshop4Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Workshop4(); // Open Workshop1 window
                }
            });
            workshop5Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Workshop5(); // Open Workshop1 window
                }
            });

            // Add button to panel and panel to layout
            buttonPanel.add(workshop1Button);
            buttonPanel.add(workshop2Button);
            buttonPanel.add(workshop3Button);
            buttonPanel.add(workshop4Button);
            buttonPanel.add(workshop5Button);
            add(buttonPanel, BorderLayout.SOUTH);
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
