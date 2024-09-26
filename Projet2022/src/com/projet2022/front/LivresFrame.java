
package com.projet2022.front;

import javax.swing.*; // Pour utiliser Swing
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import projet2022.GestionLivre;
import projet2022.Livre;

public class LivresFrame extends JFrame {
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private GestionLivre gestionLivre;

    // Déclaration des boutons
    private JButton addLivreButton;
    private JButton updateLivreButton;
    private JButton listLivreButton;
    private JButton deleteLivreButton;

    public LivresFrame() {
        // Initialisation de l'instance GestionLivre pour gérer les livres
        gestionLivre = new GestionLivre();

        // Configuration de la fenêtre principale
        setTitle("Gestion des Livres");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création du layout principal
        setLayout(new BorderLayout());

        // Panneau de contenu avec CardLayout pour changer de panneau
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        // Ajout des différents panneaux
        contentPanel.add(createAddLivrePanel(), "ADD");
        contentPanel.add(createUpdateLivrePanel(), "UPDATE");
        contentPanel.add(createListLivrePanel(), "LIST");

        // Panneau gauche avec les boutons du menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1));

        // Initialiser les boutons
        addLivreButton = new JButton("Ajouter Livre");
        updateLivreButton = new JButton("Mettre à jour Livre");
        listLivreButton = new JButton("Lister Livres");
        deleteLivreButton = new JButton("Supprimer Livre");

        // Action pour les boutons du menu
        addLivreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel("ADD"); // Afficher le panneau pour ajouter un livre
            }
        });

        updateLivreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel("UPDATE"); // Afficher le panneau pour mettre à jour un livre
            }
        });

        listLivreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel("LIST"); // Afficher le panneau pour lister les livres
            }
        });

        deleteLivreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLivre(); // Appel à la méthode pour supprimer un livre
            }
        });

        // Ajout des boutons dans le panneau du menu
        menuPanel.add(addLivreButton);
        menuPanel.add(updateLivreButton);
        menuPanel.add(listLivreButton);
        menuPanel.add(deleteLivreButton);

        // Ajout du panneau gauche et du panneau principal au JFrame
        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        // Rendre la fenêtre visible
        setVisible(true);
    }

    // Méthode pour afficher le bon panneau
    private void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }
        
private void addLivreAction(String isbn, String titre, String auteur, String anneeStr,
                             JTextField txtIsbn, JTextField txtTitre, JTextField txtAuteur, JTextField txtAnnee) {
    // Vérification si les champs ne sont pas vides
    if (isbn.isEmpty() || titre.isEmpty() || auteur.isEmpty() || anneeStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
        return;
    }

    try {
        int annee = Integer.parseInt(anneeStr);
        Livre livre = new Livre(isbn, titre, auteur, annee);

        if (gestionLivre.addLivre(livre)) {
            // Réinitialiser les champs après l'ajout
            txtIsbn.setText("");
            txtTitre.setText("");
            txtAuteur.setText("");
            txtAnnee.setText("");
            JOptionPane.showMessageDialog(null, "Livre ajouté avec succès !");
        } else {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du livre. Vérifiez les données.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Veuillez entrer une année valide !");
    }
}


    // Panneau pour ajouter un livre
    private JPanel createAddLivrePanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(6, 2));

    JLabel lblIsbn = new JLabel("ISBN:");
    final JTextField txtIsbn = new JTextField();
    JLabel lblTitre = new JLabel("Titre:");
    final JTextField txtTitre = new JTextField();
    JLabel lblAuteur = new JLabel("Auteur:");
    final JTextField txtAuteur = new JTextField();
    JLabel lblAnnee = new JLabel("Année de publication:");
    final JTextField txtAnnee = new JTextField();

    JButton btnAddLivre = new JButton("Ajouter Livre");
    btnAddLivre.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addLivreAction(txtIsbn.getText(), txtTitre.getText(), txtAuteur.getText(), txtAnnee.getText(), txtIsbn, txtTitre, txtAuteur, txtAnnee);
        }
    });

    panel.add(lblIsbn);
    panel.add(txtIsbn);
    panel.add(lblTitre);
    panel.add(txtTitre);
    panel.add(lblAuteur);
    panel.add(txtAuteur);
    panel.add(lblAnnee);
    panel.add(txtAnnee);
    panel.add(new JLabel()); // Pour aligner le bouton à droite
    panel.add(btnAddLivre);

    return panel;
}
//    private JPanel createAddLivrePanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(6, 2));
//
//        JLabel lblIsbn = new JLabel("ISBN:");
//        final JTextField txtIsbn = new JTextField();
//        JLabel lblTitre = new JLabel("Titre:");
//        final JTextField txtTitre = new JTextField();
//        JLabel lblAuteur = new JLabel("Auteur:");
//        final JTextField txtAuteur = new JTextField();
//        JLabel lblAnnee = new JLabel("Année de publication:");
//        final JTextField txtAnnee = new JTextField();
//
//        JButton btnAddLivre = new JButton("Ajouter Livre");
//        btnAddLivre.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Récupération des valeurs des champs de texte
//                String isbn = txtIsbn.getText();
//                String titre = txtTitre.getText();
//                String auteur = txtAuteur.getText();
//                String anneeStr = txtAnnee.getText();
//
//                // Vérification si les champs ne sont pas vides
//                if (isbn.isEmpty() || titre.isEmpty() || auteur.isEmpty() || anneeStr.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
//                    return;
//                }
//
//                try {
//                    int annee = Integer.parseInt(anneeStr);
//                    Livre livre = new Livre(isbn, titre, auteur, annee);
//                    gestionLivre.addLivre(livre);
//
//                    // Réinitialiser les champs après l'ajout
//                    txtIsbn.setText("");
//                    txtTitre.setText("");
//                    txtAuteur.setText("");
//                    txtAnnee.setText("");
//                    JOptionPane.showMessageDialog(null, "Livre ajouté avec succès !");
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(null, "Veuillez entrer une année valide !");
//                }
//            }
//        });
//
//        panel.add(lblIsbn);
//        panel.add(txtIsbn);
//        panel.add(lblTitre);
//        panel.add(txtTitre);
//        panel.add(lblAuteur);
//        panel.add(txtAuteur);
//        panel.add(lblAnnee);
//        panel.add(txtAnnee);
//        panel.add(new JLabel()); // Pour aligner le bouton à droite
//        panel.add(btnAddLivre);
//
//        return panel;
//    }

    // Panneau pour mettre à jour un livre
    private JPanel createUpdateLivrePanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2));
        final JTextField txtIsbn = new JTextField();
        final JTextField txtTitre = new JTextField();
        final JTextField txtAuteur = new JTextField();
        final JTextField txtAnnee = new JTextField();

        panel.add(new JLabel("ISBN (pour mise à jour):"));
        panel.add(txtIsbn);
        panel.add(new JLabel("Nouveau Titre:"));
        panel.add(txtTitre);
        panel.add(new JLabel("Nouvel Auteur:"));
        panel.add(txtAuteur);
        panel.add(new JLabel("Nouvelle Année de publication:"));
        panel.add(txtAnnee);

        JButton btnUpdateLivre = new JButton("Mettre à jour Livre");
        btnUpdateLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupération des valeurs des champs de texte
                String isbn = txtIsbn.getText();
                String titre = txtTitre.getText();
                String auteur = txtAuteur.getText();
                String anneeStr = txtAnnee.getText();

                // Vérification si les champs ne sont pas vides
                if (isbn.isEmpty() || titre.isEmpty() || auteur.isEmpty() || anneeStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
                    return;
                }

                try {
                    int annee = Integer.parseInt(anneeStr);
                    // Appel de la méthode pour mettre à jour le livre
                    Livre livre = new Livre(isbn, titre, auteur, annee);
                    gestionLivre.updateLivre(livre);

                    // Réinitialiser les champs après la mise à jour
                    txtIsbn.setText("");
                    txtTitre.setText("");
                    txtAuteur.setText("");
                    txtAnnee.setText("");
                    JOptionPane.showMessageDialog(null, "Livre mis à jour avec succès !");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer une année valide !");
                }
            }
        });

        panel.add(btnUpdateLivre);

        return panel;
    }

    // Panneau pour lister les livres
    private JPanel createListLivrePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"ISBN", "Titre", "Auteur", "Année"};
        final DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Bouton pour actualiser la liste des livres
        JButton btnRefresh = new JButton("Actualiser");
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshBookList(tableModel); // Appel de la méthode pour actualiser la liste des livres
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(btnRefresh, BorderLayout.SOUTH);

        return panel;
    }

    private void refreshBookList(DefaultTableModel tableModel) {
        // Effacer les lignes existantes
        tableModel.setRowCount(0);

        // Récupérer les livres et les afficher dans le tableau
        List<Livre> livres = gestionLivre.getAllLivre();
        for (Livre livre : livres) {
            Object[] rowData = {livre.getIsbn(), livre.getTitre(), livre.getAuteur(), livre.getAnneePublication()};
            tableModel.addRow(rowData);
        }
    }

    private void deleteLivre() {
        String isbn = JOptionPane.showInputDialog("Entrez l'ISBN du livre à supprimer:");
        if (isbn != null && !isbn.isEmpty()) {
            if (gestionLivre.deleteLivre(isbn)) {
                JOptionPane.showMessageDialog(null, "Livre supprimé avec succès !");
            } else {
                JOptionPane.showMessageDialog(null, "Livre non trouvé !");
            }
        }
    }

    public static void main(String[] args) {
        LivresFrame livresFrame = new LivresFrame();
    }
}
