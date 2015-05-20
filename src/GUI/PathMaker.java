package GUI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PathMaker {

    public static void main(String[] args) {
        new PathMaker();
    }

    public PathMaker() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel implements MouseListener {

        public TestPane() {

this.addMouseListener(this);

        }
        Image img1 = null;
        public void drawPanel(){
            try {
                img1 = ImageIO.read(new File("C:\\Users\\Kristof\\IdeaProjects\\Polulu\\out\\production\\Polulu\\image.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
drawPanel();

            g.drawImage(img1, 0, 0, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 800);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            e.getPoint();
            System.out.println("nodes.add(new Node("+(e.getX()-15)+","+(e.getY()-15)+");");

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }



    }

}