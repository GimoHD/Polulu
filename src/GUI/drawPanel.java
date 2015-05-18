package GUI;

import javafx.scene.input.KeyCode;
import org.json.JSONObject;
import server.ClientServer;
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
    ClientServer server;
    drawPanel(ClientServer server){
        this.server = server;
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
int gereden = 0;
    public void drawNode(Graphics g, int x,int y, int sleep, int gereden, int gemiddeld, float batterij){
        //this.repaint();
if (this.gereden != gereden) {
    this.gereden = gereden;
    g.setColor(Color.white);
    g.fillRect(0, 280, 555, 555);
    g.setColor(Color.black);
    g.drawString("Gereden ronden:" + gereden, 15, 300);
    g.drawString("Gemiddelde tijd:" + Time.format(gemiddeld), 15, 315);
    g.drawString("Batterijspanning:" + batterij, 15, 330);
}
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
        System.out.println("lel");
        mode = 0;
        if (e.getKeyChar() == KeyEvent.VK_M){
            mode = 1;
            innerObject.put("mode", mode); //0 - stop   1 - manual   2 - start
            innerObject.put("up", up);
            innerObject.put("down", down);
            innerObject.put("left", left);
            innerObject.put("right", right);
            System.out.println(innerObject.toString());
            server.sendMessage(innerObject.toString());
        }if (e.getKeyChar() == KeyEvent.VK_DOWN){
            down = 1;
        }if (e.getKeyChar() == KeyEvent.VK_LEFT){
            left = 1;
        }if (e.getKeyChar() == KeyEvent.VK_RIGHT){
            right = 1;
        }if (e.getKeyChar() == KeyEvent.VK_SPACE){

        }if (e.getKeyChar() == KeyEvent.VK_S){

        }



    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}