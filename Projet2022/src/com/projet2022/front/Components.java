package com.projet2022.front;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Components {

    // Panel principal de connexion
    public JPanel panel(final JFrame frame, final JPanel panelCon) {
        JPanel panel = new JPanel();
        panel.setLayout(null); // Important pour que les composants aient leurs positions personnalisées
        panel.setBounds(450, 250, 450, 250);
        panel.setBackground(Color.decode("#2C3E50"));

        Font labelFont = new Font("Arial", Font.BOLD, 24);

        JLabel auth = new JLabel("Veuillez vous connecter");
        auth.setForeground(Color.WHITE);
        auth.setFont(labelFont);
        auth.setBounds(100, 25, 300, 20);

        JLabel label1 = new JLabel("Username");
        Font labelUser = new Font("Arial", Font.BOLD, 17);
        label1.setFont(labelUser);
        label1.setForeground(Color.WHITE);
        label1.setBounds(10, 70, 100, 10);

        JLabel label2 = new JLabel("Password");
        Font labelPass = new Font("Arial", Font.BOLD, 17);
        label2.setFont(labelPass);
        label2.setForeground(Color.WHITE);
        label2.setBounds(10, 110, 100, 10);

        final JTextField text = new JTextField();
        text.setBounds(100, 68, 250, 20);

        final JPasswordField text1 = new JPasswordField();
        text1.setBounds(100, 108, 250, 20);

        JButton saveButton = new JButton("Login");
        saveButton.setForeground(Color.WHITE);
        saveButton.setBackground(Color.decode("#5DADE2"));
        saveButton.setFont(labelFont);
        saveButton.setBounds(100, 170, 250, 30);

        panel.add(auth);
        panel.add(label1);
        panel.add(label2);
        panel.add(text);
        panel.add(text1);
        panel.add(saveButton);

        // Action Listener pour le bouton "Login"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAction(text.getText(), new String(text1.getPassword()), frame, panelCon);
            }
        });

        return panel;
    }

    // Fonction de gestion du login
    public void loginAction(String username, String password, JFrame frame, JPanel panelCon) {
        if (username.equals("marx") && password.equals("admin")) {
            System.out.println("Login réussi");
            frame.setContentPane(panelCon); // Change le panel après connexion
            frame.revalidate(); // Force la mise à jour du contenu
        } else {
            JOptionPane.showMessageDialog(frame, "Nom d'utilisateur ou mot de passe incorrect");
        }
    }

    // Panel de gestion de la navigation
    public JPanel panelCon(JPanel left) {
        JPanel panelMain = new JPanel();
        panelMain.setLayout(null); // Important pour positionner les composants

        // Premier panel horizontal (Header)
        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 1450, 100);
        panel1.setBackground(Color.decode("#34495E"));

        // Deuxième panel vertical (Menu de gauche)
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 101, 200, 650);
        panel2.setBackground(Color.decode("#34495E"));
        panel2.add(left);

        // Troisième panel vertical (Contenu principal)
        JPanel panel3 = new JPanel();
        panel3.setBounds(200, 101, 1250, 650);
        panel3.setBackground(Color.decode("#ECF0F1"));

        panelMain.add(panel1);
        panelMain.add(panel2);
        panelMain.add(panel3);

        return panelMain;
    }

    // Panel pour le menu de gauche avec les boutons
    public JPanel leftPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 200, 650);
        panel.setBackground(Color.decode("#34495E"));

        Font fontButton = new Font("Arial", Font.BOLD, 17);

        JButton menuPrinc = new JButton("MENU");
        menuPrinc.setBounds(5, 20, 190, 25);
        menuPrinc.setFont(fontButton);
        menuPrinc.setForeground(Color.WHITE);
        menuPrinc.setBackground(Color.decode("#5DADE2"));

        JButton student = new JButton("ADHÉRENT");
        student.setBounds(5, 50, 190, 25);
        student.setFont(fontButton);
        student.setForeground(Color.WHITE);
        student.setBackground(Color.decode("#5DADE2"));

        JButton book = new JButton("LIVRES");
        book.setBounds(5, 80, 190, 25);
        book.setFont(fontButton);
        book.setForeground(Color.WHITE);
        book.setBackground(Color.decode("#5DADE2"));

        JButton pret = new JButton("PRÊTS");
        pret.setBounds(5, 110, 190, 25);
        pret.setFont(fontButton);
        pret.setForeground(Color.WHITE);
        pret.setBackground(Color.decode("#5DADE2"));

        panel.add(menuPrinc);
        panel.add(student);
        panel.add(book);
        panel.add(pret);

        // Ajout des événements pour chaque bouton
        menuPrinc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAction();
            }
        });

        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdherentFrame(); // Ouvre la fenêtre d'adhérents
            }
        });

        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LivresFrame(); // Ouvre la fenêtre des livres
            }
        });

        pret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PretsFrame(); // Ouvre la fenêtre des prêts
            }
        });

        return panel;
    }

    // Ajout d'un menu bar dans le JFrame
    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Menu "Fichier"
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Ajout d'actions aux éléments de menu
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ouvrir un fichier");
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sauvegarder un fichier");
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Ajouter les éléments de menu dans le menu "Fichier"
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Ligne séparatrice
        fileMenu.add(exitItem);

        // Ajouter "Fichier" dans la barre de menu
        menuBar.add(fileMenu);

        // Menu "Aide"
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Version 1.0\nCréé par ChatGPT");
            }
        });

        // Ajouter les éléments de menu dans le menu "Aide"
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);

        return menuBar;
    }

    // Fonction qui gère l'événement du bouton MENU
    public void menuAction() {
        System.out.println("Action du bouton MENU exécutée.");
    }

    // Fonction qui gère l'événement du bouton STUDENT
    public void studentAction() {
        System.out.println("Action du bouton STUDENT exécutée.");
    }

    // Fonction qui gère l'événement du bouton BOOK
    public void bookAction() {
        System.out.println("Action du bouton BOOK exécutée.");
    }

    // Fonction qui gère l'événement du bouton LEND
    public void lendAction() {
        System.out.println("Action du bouton LEND exécutée.");
    }

    // Méthode main pour tester le programme
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Login Panel");

        Components comp = new Components();
        JPanel loginPanel = comp.panel(frame, comp.panelCon(comp.leftPanel()));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1450, 800);
        frame.setContentPane(loginPanel);
        frame.setVisible(true);
    }
}
