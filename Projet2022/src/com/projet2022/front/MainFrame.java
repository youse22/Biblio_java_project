package com.projet2022.front;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame {
    public static void main(String[] args) {
        Components comp = new Components();
        final JFrame frame = new JFrame("JFrame Example");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Titre principal
        JLabel labelTet = new JLabel("BIBLIOTHÈQUE DE L'UNIVERSITÉ DE LA RENAISSANCE D'HAÏTI", JLabel.CENTER);
        Font labelTetFont = new Font("Arial", Font.BOLD, 37);
        labelTet.setForeground(Color.WHITE);
        labelTet.setFont(labelTetFont);
        labelTet.setOpaque(true);
        labelTet.setBackground(Color.decode("#000066"));
        labelTet.setPreferredSize(new Dimension(screenSize.width, 60)); // Largeur de la fenêtre entière

        JLabel labelTet1 = new JLabel("BURH", JLabel.CENTER);
        labelTet1.setForeground(Color.WHITE);
        labelTet1.setFont(labelTetFont);
        labelTet1.setOpaque(true);
        labelTet1.setBackground(Color.decode("#000066"));
        labelTet1.setPreferredSize(new Dimension(screenSize.width, 50)); // Largeur de la fenêtre entière

        // Créer une barre de menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.decode("#000066"));

        // Ajouter des éléments au menu
        JMenu menu = new JMenu("Menu");
        JMenuItem btnAdherent = new JMenuItem("Adhérent");
        JMenuItem btnLivres = new JMenuItem("Livres");
        JMenuItem btnPrets = new JMenuItem("Prêts");

        // Style des boutons
        StyleMenuItem(btnAdherent);
        StyleMenuItem(btnLivres);
        StyleMenuItem(btnPrets);

        // Actions des boutons avec classes anonymes
        btnAdherent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new AdherentFrame(); // Ouvrir la fenêtre adhérent
            }
        });

        btnLivres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new LivresFrame(); // Ouvrir la fenêtre livres
            }
        });

        btnPrets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new PretsFrame(); // Ouvrir la fenêtre prêts
            }
        });

        // Ajouter les éléments de menu
        menu.add(btnAdherent);
        menu.add(btnLivres);
        menu.add(btnPrets);
        menuBar.add(menu);

        // Panel principal de contenu
        JPanel mainPanel = comp.panel(frame, comp.leftPanel()); // Créez le panel principal et le panel gauche

        // Ajout des éléments dans le frame
        frame.setLayout(new BorderLayout());
        frame.add(labelTet, BorderLayout.NORTH);
        frame.add(labelTet1, BorderLayout.CENTER);
        frame.setJMenuBar(menuBar); // Ajouter la barre de menu
        frame.add(mainPanel, BorderLayout.CENTER); // Zone principale pour afficher les composants

        // Paramètres de la fenêtre
        frame.setSize(screenSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Méthode pour appliquer le style aux éléments de menu
    private static void StyleMenuItem(JMenuItem menuItem) {
        menuItem.setForeground(Color.WHITE);
        menuItem.setBackground(Color.decode("#003366"));
        menuItem.setFocusPainted(false); // Enlever le contour bleu du focus
    }
}
