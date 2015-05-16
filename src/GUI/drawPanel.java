package GUI;

import javafx.scene.input.KeyCode;
import org.json.JSONObject;
import timer.Random;
import timer.Time;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class drawPanel extends JPanel implements KeyListener {
    Image img1 = null;

    JSONObject innerObject = new JSONObject();
    drawPanel(){
        this.addKeyListener(this);
        try {
            img1 = ImageIO.read(new File("C:\\Users\\Kristof\\IdeaProjects\\Polulu\\out\\production\\Polulu\\image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img1, 0, 0, this);
        }

    public void drawNode(Graphics g, int x,int y, int sleep){
        //this.repaint();
        g.drawImage(img1, 0, 0, this);
        g.setColor(Color.CYAN);
        g.fillOval(x, y, 30, 30);
        Time.sleep(sleep);
    }
    int up=0;
    int down=0;
    int left=0;
    int right=0;
    int mode;

    @Override
    public void keyTyped(KeyEvent e) {
        mode = 1;
        if (e.getKeyChar() == KeyEvent.VK_UP){
            up = 1;
        }if (e.getKeyChar() == KeyEvent.VK_DOWN){
            down = 1;
        }if (e.getKeyChar() == KeyEvent.VK_LEFT){
            left = 1;
        }if (e.getKeyChar() == KeyEvent.VK_RIGHT){
            right = 1;
        }if (e.getKeyChar() == KeyEvent.VK_SPACE){

        }if (e.getKeyChar() == KeyEvent.VK_S){

        }
        innerObject.put("mode", mode); //0 - stop   1 - manual   2 - start
        innerObject.put("up", up);
        innerObject.put("down", down);
        innerObject.put("left", left);
        innerObject.put("right", right);
        System.out.println(innerObject.toString());
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}