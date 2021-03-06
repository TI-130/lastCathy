package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
class CustomerUI extends JFrame {

    private final int WIDTH = 250, HEIGHT = 130;
    CustomerUI() {
        setSize(WIDTH, HEIGHT);
        setTitle("Member");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        draw();
    }

    private JLabel friendly, value;
    private JTextField memberID;
    private JButton checkout, quit;
    private JPanel north;
    void draw() {
        setLayout(new BorderLayout());
        north = new JPanel();
        north.setLayout(new BorderLayout());
        friendly = new JLabel("Your available points are...", SwingConstants.CENTER);
        friendly.setForeground(Color.BLUE);
        north.add(friendly, BorderLayout.NORTH);
        memberID = new JTextField();
        memberID.setForeground(Color.BLUE);
        checkout = new JButton("Enter");
        checkout.addActionListener(new buttonHandler());
        north.add(memberID, BorderLayout.CENTER);
        north.add(checkout, BorderLayout.EAST);
        value = new JLabel("", SwingConstants.CENTER);
        Font font = new Font("Arial", Font.BOLD, 50);
        value.setFont(font);
        quit = new JButton("to main menu");
        quit.addActionListener(new buttonHandler());
        add(north, BorderLayout.NORTH);
        add(value, BorderLayout.CENTER);
        add(quit, BorderLayout.SOUTH);
    }

    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == quit) {
                BranchUI ui = new BranchUI();
                ui.setVisible(true);
                setVisible(false);
                dispose();
            } else if (source == checkout) {
                // todo if successful
                // todo extraction happens
                int membershipPoints = 1111;
                value.setText(membershipPoints+"");
            }
            repaint();
        }
    }
}
