package GUI;

import org.json.JSONObject;
import server.ClientServer;
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
    int gereden = 0;
    int up = 0;
    int down = 0;
    int left = 0;
    int right = 0;
    int mode;
    drawPanel(ClientServer server) {
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

    public void drawNode(Graphics g, int x, int y, int sleep, int gereden, int gemiddeld, String batterij) {
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

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("lel");
        mode = 0;
        if (e.getKeyChar() == KeyEvent.VK_Z) {
            innerObject.put("mode", "" + 0); //0 - stop   1 - manual   2 - start
            innerObject.put("up", "" + 1);
            innerObject.put("down", "" + 0);
            innerObject.put("left", "" + 0);
            innerObject.put("right", "" + 0);
            System.out.println(innerObject.toString());
            server.sendMessage(innerObject.toString());
            //server.sendMessage("1");
        }
        if (e.getKeyChar() == KeyEvent.VK_S) {

            innerObject.put("mode", "" + 0); //0 - stop   1 - manual   2 - start
            innerObject.put("up", "" + 0);
            innerObject.put("down", "" + 1);
            innerObject.put("left", "" + 0);
            innerObject.put("right", "" + 0);
            System.out.println(innerObject.toString());
            server.sendMessage(innerObject.toString());
        }
        if (e.getKeyChar() == KeyEvent.VK_Q) {
            innerObject.put("mode", "" + 0); //0 - stop   1 - manual   2 - start
            innerObject.put("up", "" + 0);
            innerObject.put("down", "" + 0);
            innerObject.put("left", "" + 1);
            innerObject.put("right", "" + 0);
            System.out.println(innerObject.toString());
            server.sendMessage(innerObject.toString());
        }
        if (e.getKeyChar() == KeyEvent.VK_D) {
            innerObject.put("mode", "" + 0); //0 - stop   1 - manual   2 - start
            innerObject.put("up", "" + 0);
            innerObject.put("down", "" + 0);
            innerObject.put("left", "" + 0);
            innerObject.put("right", "" + 1);
            System.out.println(innerObject.toString());
            server.sendMessage(innerObject.toString());
        }
        if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            innerObject.put("mode", "" + 1); //0 - stop   1 - manual   2 - start
            innerObject.put("up", "" + 0);
            innerObject.put("down", "" + 0);
            innerObject.put("left", "" + 0);
            innerObject.put("right", "" + 0);
            System.out.println(innerObject.toString());
            server.sendMessage(innerObject.toString());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}