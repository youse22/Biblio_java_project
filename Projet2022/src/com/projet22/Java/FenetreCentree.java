/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet22.Java;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Marie-Vonise LORDEUS
 */
public class FenetreCentree extends JFrame{
    public FenetreCentree() {
        super("Fenêtre Centrée");

        // Créer un JPanel pour le contenu
        JPanel contenu = new JPanel();
        contenu.setBackground(Color.WHITE);

        // Créer un GridBagLayout pour le JPanel
        GridBagLayout layout = new GridBagLayout();
        contenu.setLayout(layout);

        // Créer un composant à centrer (par exemple, un JLabel)
        JLabel label = new JLabel("Contenu centré");
        label.setFont(new Font("Arial", Font.BOLD, 18));

        // Créer un objet GridBagConstraints pour définir les contraintes de positionnement
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10); // Marge autour du composant

        // Ajouter le composant au JPanel avec les contraintes
        contenu.add(label, gbc);

        // Ajouter le JPanel à la fenêtre principale
        add(contenu);

        // Centrer la fenêtre sur l'écran
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        FenetreCentree fenetre = new FenetreCentree();
    }
}

