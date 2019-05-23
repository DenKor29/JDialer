package jdialer.client;


import jdialer.core.ConfigurationSettings;
import jdialer.jtapi.makecall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame  {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
    private JButton buttonstartServer ;
    private JButton buttonstopServer;
    private JTextArea log;

    private makecall call;


    private boolean Running = false;

    private int appserverstart;
    private static final int WIDTH = 350;
    private static final int HEIGHT = 95;

    private MainWindow(){


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        JPanel button_panel = new JPanel();
        button_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Сервер"));
        button_panel.setLayout(new BorderLayout());

        buttonstartServer = new JButton("Старт");
        button_panel.add(buttonstartServer, BorderLayout.NORTH);

        buttonstopServer = new JButton("Стоп");
        button_panel.add(buttonstopServer,BorderLayout.CENTER);


        add(button_panel,BorderLayout.WEST);

        JPanel text_panel = new JPanel();
        text_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Мониторинг"));
        text_panel.setLayout(new BorderLayout());

        log = new JTextArea();
        log.setEnabled(false);
        log.setLineWrap(true);
        JScrollPane scroll= new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setSize(250, 150);
        scroll.setLocation(10,10);
        text_panel.add(scroll,BorderLayout.CENTER);

        add(text_panel,BorderLayout.CENTER);

        enableButtonServer(true);


        setVisible(true);
        pack();
        setIconImage(getImage("icon"));
        setLocationRelativeTo(null);

        ConfigurationSettings configurationSettings = new ConfigurationSettings("application.xml", "jtapi");

         String user = configurationSettings.get("user");
         String password = configurationSettings.get("password");
         String server = ""+ configurationSettings.get("server")+"";


         appserverstart = configurationSettings.getInt("appserverstart",1);

         call = new makecall(server,user,password,0,"7352","7390");


        buttonstartServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (!Running) {
                   MainWindow.this.enableButtonServer(false);
                   Running = true;


               }
            }
        });

        buttonstopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (Running) {
                   Running = false;
               }
            }
        });

            if (appserverstart == 1)  buttonstartServer.doClick();


    }
    private void enableButtonServer(boolean status){

        buttonstartServer.setEnabled(status);
        buttonstopServer.setEnabled(!status);

    }

    private synchronized  void printMessage(String value){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(value+"\r\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }
    private Image getImage (String name){
        String filename = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(filename)));
        return icon.getImage();

    }



}
