package GUI;

import com.sun.security.ntlm.Client;
import org.json.JSONObject;
import server.BasisStation;
import server.ClientServer;
import server.Node;
import server.TussenStation;
import timer.Random;
import timer.Time;
import timer.Timing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame {
    JScrollPane scrollPane;
    private JTable table;
    ArrayList list;
    DefaultTableModel tableModel;
    ClientServer client;
    drawPanel p;
    ArrayList<Node> nodes;
    ArrayList<Integer> simGereden;

    public GUI() {
        client = new ClientServer();
        list = new ArrayList();
        simGereden = new ArrayList<Integer>();
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());
        String col[] = {"Basisstation 1", "Tussenstation 1", "Tussenstation 2"};
        tableModel = new DefaultTableModel(col, 0);
        nodes = new ArrayList<Node>();
        nodes.add(new Node(170, 205));
        nodes.add(new Node(161, 197));
        nodes.add(new Node(127, 199));
        nodes.add(new Node(91, 206));
        nodes.add(new Node(56, 208));
        nodes.add(new Node(26, 183));
        nodes.add(new Node(15, 150));
        nodes.add(new Node(13, 101));
        nodes.add(new Node(20, 56));
        nodes.add(new Node(32, 26));
        nodes.add(new Node(50, 11));
        nodes.add(new Node(80, 12));
        nodes.add(new Node(106, 21));
        nodes.add(new Node(195, 57));
        nodes.add(new Node(268, 82));
        nodes.add(new Node(327, 103));
        nodes.add(new Node(386, 124));
        nodes.add(new Node(423, 129));
        nodes.add(new Node(450, 107));
        nodes.add(new Node(460, 75));
        nodes.add(new Node(456, 39));
        nodes.add(new Node(437, 17));
        nodes.add(new Node(437, 17));
        nodes.add(new Node(413, 13));
        nodes.add(new Node(393, 24));
        nodes.add(new TussenStation(394, 47));
        nodes.add(new Node(390, 81));
        nodes.add(new Node(360, 85));
        nodes.add(new Node(340, 72));
        nodes.add(new Node(333, 50));
        nodes.add(new Node(338, 19));
        nodes.add(new Node(315, 11));
        nodes.add(new Node(289, 25));
        nodes.add(new Node(270, 56));
        nodes.add(new Node(255, 82));
        nodes.add(new Node(209, 124));
        nodes.add(new Node(179, 111));
        nodes.add(new Node(146, 87));
        nodes.add(new Node(121, 65));
        nodes.add(new Node(79, 47));
        nodes.add(new Node(57, 52));
        nodes.add(new Node(52, 70));
        nodes.add(new Node(60, 82));
        nodes.add(new TussenStation(72, 92));
        nodes.add(new Node(94, 123));
        nodes.add(new Node(87, 143));
        nodes.add(new Node(64, 153));
        nodes.add(new Node(58, 165));
        nodes.add(new Node(74, 176));
        nodes.add(new Node(115, 160));
        nodes.add(new Node(135, 149));
        nodes.add(new Node(156, 142));
        nodes.add(new Node(179, 151));
        nodes.add(new Node(196, 159));
        nodes.add(new Node(220, 158));
        nodes.add(new Node(246, 157));
        nodes.add(new Node(264, 148));
        nodes.add(new Node(280, 138));
        nodes.add(new Node(306, 139));
        nodes.add(new Node(336, 146));
        nodes.add(new Node(363, 153));
        nodes.add(new Node(390, 159));
        nodes.add(new Node(417, 168));
        nodes.add(new Node(437, 178));
        nodes.add(new Node(451, 179));
        nodes.add(new Node(457, 185));
        nodes.add(new Node(439, 204));
        nodes.add(new Node(410, 212));
        nodes.add(new Node(391, 209));
        nodes.add(new Node(376, 209));
        nodes.add(new Node(357, 207));
        nodes.add(new Node(339, 207));
        nodes.add(new Node(322, 205));
        nodes.add(new Node(307, 204));
        nodes.add(new Node(284, 207));
        nodes.add(new Node(266, 204));
        nodes.add(new Node(253, 202));
        nodes.add(new Node(232, 198));
        nodes.add(new Node(211, 197));
        nodes.add(new Node(201, 196));
        nodes.add(new Node(189, 196));
        nodes.add(new BasisStation(170, 205));
        nodes.add(new Node(176, 195));

        // Create a new table instance
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JPanel a = new JPanel();
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new Simulate().start();
            }
        });
        JButton button2 = new JButton();
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JSONObject innerObject = new JSONObject();
                innerObject.put("mode", "0"); //0 - stop   1 - start   2 - battery
                innerObject.put("up", "0");
                innerObject.put("down", "0");
                innerObject.put("left", "1");
                innerObject.put("right", "0");
                client.sendMessage(innerObject.toString());
            }
        });
        a.add(button);
        a.add(button2);
        a.setLayout(new GridLayout(1, 1));


        tabbedPane.addTab("Tab1", scrollPane);
        tabbedPane.addTab("Tab2", a);
        tabbedPane.setFocusable(false);
       scrollPane.setFocusable(false);
        a.setFocusable(false);
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        p = new drawPanel(client);
        p.setFocusable(true);
        p.setRequestFocusEnabled(true);

        p.setLayout(new GridLayout(1, 1));
        p.setPreferredSize(new Dimension(500, 500));
        this.getContentPane().add(p, BorderLayout.WEST);

        this.pack();
        this.setLocationRelativeTo(null);
        p.repaint();


        //Update update = new Update();
        //update.start();


    }

    Timing timer = new Timing(50000);


    public class Simulate extends Thread {
        public void run() {
            while (true) {
                Object dataValues[] = {"N/A", "N/A", "N/A"};


                tableModel.addRow(dataValues);
                Timing timer = new Timing(50000);

                for (int i = 0; i < nodes.size() - 1; i++) {
                    if (nodes.get(i) instanceof TussenStation) {

                        if (nodes.get(i).getX() > 350) {
                            dataValues[0] = timer.toElapsedString();

                            tableModel.setValueAt(dataValues[0], tableModel.getRowCount() - 1, 0);
                            table.repaint();
                        } else {
                            dataValues[1] = timer.toElapsedString();

                            tableModel.setValueAt(dataValues[1], tableModel.getRowCount() - 1, 1);
                            table.repaint();
                        }
                    }
                    if (nodes.get(i) instanceof BasisStation) {
                        dataValues[2] = timer.toElapsedString();
                        simGereden.add((int) (long)timer.getElapsed());

                        tableModel.setValueAt(dataValues[2], tableModel.getRowCount() - 1, 2);
                        table.repaint();
                    }

                    int x1 = nodes.get(i).getX();
                    int x2 = nodes.get(i + 1).getX();
                    int y1 = nodes.get(i).getY();
                    int y2 = nodes.get(i + 1).getY();
                    int deltaX = x2 - x1;
                    int deltaY = y2 - y1;
                    if (deltaX != 0) {
                        //System.out.println(deltaX + "y" + deltaY);
                        float slope = (float) (deltaY) / (deltaX);
                        int xtemp = 0;
                        int ytemp = 0;
                        int random = Random.nextInt(5, 13);
                        double adding = 1;
                        if (Math.abs(deltaY)>Math.abs(deltaX)){
                            adding = 0.2;
                        }

                        for (double x = 0; x < Math.abs(deltaX); x=x+adding) {
                            xtemp = (int) x;
                            if (x1 < x2)
                                xtemp = (int) -x;
                            ytemp = (int) (slope * (xtemp) - y1);
                            ytemp = -ytemp;
                            //System.out.println(slope + "lol" + xtemp + "    " + ytemp);
                            p.drawNode(p.getGraphics(), nodes.get(i).getX() - xtemp, ytemp, random,simGereden.size(),average(),5);

                        }

                        //p.drawNode(p.getGraphics(), nodes.get(i).getX(), nodes.get(i).getY());
                    }
                }
            }
        }

    }


    public Integer average(){
        Integer sum = 0;
        if (!simGereden.isEmpty()){
            for(Integer l : simGereden){
                sum += l;
            }return sum/ simGereden.size();
        }return sum;
    }
    Object dataValues[] = {"0", "0", "0"};

    public void update() {
        tableModel.addRow(dataValues);
        table.repaint();
    }
int time;
    int id;
    float energy;

    public class Update extends Thread {
        public void run() {
            while (true) {
                String received = client.receiveMessage();
                if (received != null) {
                    JSONObject lol = new JSONObject(received);
                     time = (Integer) lol.get("time");
                     id = (Integer)lol.get("id");
                    energy = (Float) lol.get("energy");
                    System.out.println();
                }
            }
        }
    }
}