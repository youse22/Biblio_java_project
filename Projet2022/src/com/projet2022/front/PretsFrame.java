package com.projet2022.front;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import projet2022.GestionPret;
import projet2022.Pret;

public class PretsFrame extends JFrame {
    
    private GestionPret gestionPret;
    private JTable table; // Table pour afficher les prêts
    private DefaultTableModel tableModel; // Modèle de la table

    public PretsFrame() {
        gestionPret = new GestionPret();
        
        setTitle("Gestion des Prêts");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Créer le panneau du menu à gauche
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 1)); // Layout en colonne

        // Ajouter des boutons au menu
        JButton btnNewPret = new JButton("Nouvelle Demande de Prêt");
        JButton btnViewPrets = new JButton("Voir les Prêts");
        JButton btnDeletePret = new JButton("Supprimer un Prêt");
        JButton btnUpdatePret = new JButton("Mettre à Jour un Prêt");

        // Ajouter des actions aux boutons
        btnNewPret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewPret();
            }
        });

        btnViewPrets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPrets();
            }
        });

        btnDeletePret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePret();
            }
        });

        btnUpdatePret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePret();
            }
        });

        // Ajouter les boutons au menu
        menuPanel.add(btnNewPret);
        menuPanel.add(btnViewPrets);
        menuPanel.add(btnDeletePret);
        menuPanel.add(btnUpdatePret);
        
        // Ajouter le panneau de menu à gauche de la fenêtre
        add(menuPanel, BorderLayout.WEST);

        // Créer le modèle de table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Code Livre");
        tableModel.addColumn("Code Étudiant");
        tableModel.addColumn("Description");

        // Créer la table avec le modèle
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        
        // Ajouter un JScrollPane pour la table
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

//    private void createNewPret() {
//        // Logique pour créer un nouveau prêt
//        JOptionPane.showMessageDialog(this, "Créer un nouveau prêt.");
//        // Ajoutez ici la logique pour obtenir les détails du prêt et mettre à jour la table
//    }
private void createNewPret() {
    // Afficher une boîte de dialogue pour obtenir les détails du prêt
    JPanel panel = new JPanel(new GridLayout(0, 2)); // Créer un panneau avec un GridLayout

    // Ajouter des champs de texte pour chaque détail du prêt
    JTextField codeLivreField = new JTextField();
    JTextField codeEtuField = new JTextField();
    JTextField descriptionField = new JTextField();

    panel.add(new JLabel("Code Livre :"));
    panel.add(codeLivreField);
    panel.add(new JLabel("Code Étudiant :"));
    panel.add(codeEtuField);
    panel.add(new JLabel("Description :"));
    panel.add(descriptionField);

    // Afficher la boîte de dialogue pour entrer les détails
    int result = JOptionPane.showConfirmDialog(this, panel, "Créer un nouveau prêt", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
        // Récupérer les valeurs saisies
        String codeLivre = codeLivreField.getText();
        String codeEtu = codeEtuField.getText();
        String description = descriptionField.getText();

        // Créer un nouvel objet Pret
        Pret newPret = new Pret(); // Assurez-vous que votre classe Pret a un constructeur par défaut
        newPret.setCodeLivre(codeLivre);
        newPret.setCodeEtu(codeEtu);
        newPret.setDescription(description);

        // Ajouter le nouveau prêt à la gestion des prêts
        boolean success = gestionPret.addPret(newPret); // Assurez-vous que vous avez une méthode addPret

        if (success) {
            JOptionPane.showMessageDialog(this, "Prêt créé avec succès.");
            viewPrets(); // Mettre à jour la vue des prêts
        } else {
            JOptionPane.showMessageDialog(this, "Échec de la création du prêt.");
        }
    }
}


    private void viewPrets() {
        // Logique pour afficher tous les prêts
        ArrayList<Pret> prets = gestionPret.getAllPret();
        
        // Vider le modèle de table avant d'ajouter les nouveaux prêts
        tableModel.setRowCount(0); 

        // Remplir le modèle de table avec les prêts
        for (Pret p : prets) {
            tableModel.addRow(new Object[]{p.getId(), p.getCodeLivre(), p.getCodeEtu(), p.getDescription()});
        }
    }

    private void deletePret() {
        String id = JOptionPane.showInputDialog(this, "Entrez l'ID du prêt à supprimer :");
        if (id != null && !id.trim().isEmpty()) {
            boolean success = gestionPret.deleteBook(id);
            if (success) {
                JOptionPane.showMessageDialog(this, "Prêt supprimé avec succès.");
                viewPrets(); // Actualiser la vue des prêts
            } else {
                JOptionPane.showMessageDialog(this, "Échec de la suppression du prêt.");
            }
        }
    }

    private void updatePret() {
        String id = JOptionPane.showInputDialog(this, "Entrez l'ID du prêt à mettre à jour :");
        if (id != null && !id.trim().isEmpty()) {
            Pret pret = gestionPret.getPretById(id);
            if (pret != null) {
                String newCodeLivre = JOptionPane.showInputDialog(this, "Nouveau Code Livre :", pret.getCodeLivre());
                String newCodeEtu = JOptionPane.showInputDialog(this, "Nouveau Code Étudiant :", pret.getCodeEtu());
                String newDescription = JOptionPane.showInputDialog(this, "Nouvelle Description :", pret.getDescription());
                
                pret.setCodeLivre(newCodeLivre);
                pret.setCodeEtu(newCodeEtu);
                pret.setDescription(newDescription);
                
                gestionPret.updateBook(pret);
                JOptionPane.showMessageDialog(this, "Prêt mis à jour avec succès.");
                viewPrets(); // Actualiser la vue des prêts
            } else {
                JOptionPane.showMessageDialog(this, "Prêt non trouvé.");
            }
        }
    }

    public static void main(String[] args) {
        new PretsFrame();
    }
}
