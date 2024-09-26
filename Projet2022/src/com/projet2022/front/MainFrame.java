
package com.projet2022.front;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame {
    public static void main(String[] args) {
        Components comp = new Components();
        final JFrame frame = new JFrame("JFrame Example");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Titre principal avec phrase de bienvenue
        JLabel labelBienvenue = new JLabel("Bienvenue à la Bibliothèque de l'Université de la Renaissance d'Haïti", JLabel.CENTER);
        labelBienvenue.setFont(new Font("Arial", Font.BOLD, 24));
        labelBienvenue.setForeground(Color.WHITE);
        labelBienvenue.setOpaque(true);
        labelBienvenue.setBackground(Color.decode("#000066"));
        labelBienvenue.setPreferredSize(new Dimension(screenSize.width, 60)); // Hauteur définie

        // Créer un panel pour la disposition
        JPanel contentPanel = new JPanel(new BorderLayout());
        
        // Menu à gauche
        JPanel leftMenuPanel = new JPanel(new GridLayout(0, 1)); // Une colonne pour le menu
        leftMenuPanel.setBackground(Color.decode("#000066"));
        leftMenuPanel.setPreferredSize(new Dimension(200, screenSize.height)); // Largeur fixe pour le menu

        // Boutons du menu
        JButton btnAdherent = new JButton("Adhérent");
        JButton btnLivres = new JButton("Livres");
        JButton btnPrets = new JButton("Prêts");

        // Style des boutons de menu
        StyleButton(btnAdherent);
        StyleButton(btnLivres);
        StyleButton(btnPrets);

        // Ajout des boutons au menu à gauche
        leftMenuPanel.add(btnAdherent);
        leftMenuPanel.add(btnLivres);
        leftMenuPanel.add(btnPrets);
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
        
        // Zone principale (partie droite) en blanc
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);

        // Ajouter les éléments dans le panel principal
        contentPanel.add(leftMenuPanel, BorderLayout.WEST); // Menu à gauche
        contentPanel.add(rightPanel, BorderLayout.CENTER); // Zone principale à droite

        // Ajout des éléments dans le frame
        frame.setLayout(new BorderLayout());
        frame.add(labelBienvenue, BorderLayout.NORTH); // Phrase de bienvenue en haut
        frame.add(contentPanel, BorderLayout.CENTER); // Contenu principal avec menu et zone blanche

        // Paramètres de la fenêtre
        frame.setSize(screenSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Méthode pour appliquer le style aux boutons
    private static void StyleButton(JButton button) {
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#003366"));
        button.setFocusPainted(false); // Enlever le contour bleu du focus
        button.setFont(new Font("Arial", Font.PLAIN, 18));
    }
}
