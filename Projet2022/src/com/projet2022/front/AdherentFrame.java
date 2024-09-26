package com.projet2022.front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import projet2022.GestionAdherant;
import projet2022.Adherent;


public class AdherentFrame extends JFrame {
    
    private JPanel mainPanel; // Panneau principal avec CardLayout

    public AdherentFrame() {
        setTitle("Gestion des Adhérents");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création du panneau principal avec CardLayout
        mainPanel = new JPanel(new CardLayout());
        mainPanel.add(createWelcomePanel(), "Welcome");
        mainPanel.add(createAddAdherentPanel(), "AddAdherent");
        mainPanel.add(createUpdateAdherentPanel(), "UpdateAdherent");
        mainPanel.add(createListAdherentPanel(), "ListAdherent");
        mainPanel.add(createDeleteAdherentPanel(), "DeleteAdherent");

        // Panneau de gauche pour le menu
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.decode("#34495E"));

        JButton addAdherentButton = new JButton("Ajouter Adhérent");
        JButton updateAdherentButton = new JButton("Mettre à jour Adhérent");
        JButton listAdherentButton = new JButton("Lister Adhérents");
        JButton deleteAdherentButton = new JButton("Supprimer Adhérent");

        // Action pour les boutons du menu
        addAdherentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel("AddAdherent");
            }
        });

        updateAdherentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel("UpdateAdherent");
            }
        });

        listAdherentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel("ListAdherent");
            }
        });

        deleteAdherentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel("DeleteAdherent");
            }
        });

        leftPanel.add(addAdherentButton);
        leftPanel.add(updateAdherentButton);
        leftPanel.add(listAdherentButton);
        leftPanel.add(deleteAdherentButton);

        // Ajouter le panneau gauche et le panneau principal à la fenêtre
        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    // Méthode pour changer de panneau
    private void showPanel(String panelName) {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, panelName);
    }

    // Panneau de bienvenue
    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#ECF0F1"));
        panel.add(new JLabel("Bienvenue dans la gestion des adhérents!"));
        return panel;
    }

// Panneau pour ajouter un adhérent
private JPanel createAddAdherentPanel() {
    final JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(9, 2)); // Modifier le nombre de lignes à 9 pour inclure tous les champs
    panel.setBackground(Color.decode("#ECF0F1"));

    final JTextField idField = new JTextField(); // Declare as final
    final JTextField cinField = new JTextField(); // Declare as final
    final JTextField lastNameField = new JTextField(); // Declare as final
    final JTextField firstNameField = new JTextField(); // Declare as final
    final JTextField phoneField = new JTextField(); // Declare as final
    final JTextField addressField = new JTextField(); // Declare as final
    final JTextField faculteField = new JTextField(); // Declare as final
    final JTextField vacationField = new JTextField(); // Declare as final
    final JTextField niveauField = new JTextField(); // Declare as final

    panel.add(new JLabel("ID Adhérent:"));
    panel.add(idField);
    panel.add(new JLabel("CIN:"));
    panel.add(cinField);
    panel.add(new JLabel("Nom:"));
    panel.add(lastNameField);
    panel.add(new JLabel("Prénom:"));
    panel.add(firstNameField);
    panel.add(new JLabel("Téléphone:"));
    panel.add(phoneField);
    panel.add(new JLabel("Adresse:"));
    panel.add(addressField);
    panel.add(new JLabel("Faculté:"));
    panel.add(faculteField);
    panel.add(new JLabel("Vacation:"));
    panel.add(vacationField);
    panel.add(new JLabel("Niveau:"));
    panel.add(niveauField);

    JButton addButton = new JButton("Ajouter");
    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logique pour ajouter un adhérent ici
            String id = idField.getText();
            String cin = cinField.getText();
            String lastName = lastNameField.getText();
            String firstName = firstNameField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();
            String faculte = faculteField.getText();
            String vacation = vacationField.getText();
            String niveau = niveauField.getText();

            // Créer une instance de GestionAdherant
            GestionAdherant gestionAdherant = new GestionAdherant();
            Adherent newAdherent = new Adherent(id, cin, lastName, firstName, phone, address, faculte, vacation, niveau);
            
            // Ajouter l'adhérent à la base de données
            gestionAdherant.addAdherant(newAdherent);
            
            // Afficher un message de succès
            JOptionPane.showMessageDialog(panel, "Adhérent ajouté avec succès!");
            
            // Réinitialiser les champs après l'ajout
            idField.setText("");
            cinField.setText("");
            lastNameField.setText("");
            firstNameField.setText("");
            phoneField.setText("");
            addressField.setText("");
            faculteField.setText("");
            vacationField.setText("");
            niveauField.setText("");
        }
    });

    panel.add(addButton);
    return panel;
}

//    // Panneau pour mettre à jour un adhérent
//    private JPanel createUpdateAdherentPanel() {
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.decode("#ECF0F1"));
//        panel.add(new JLabel("Fonction de mise à jour des adhérents (à implémenter)"));
//        return panel;
//    }
// Panneau pour mettre à jour un adhérent
private JPanel createUpdateAdherentPanel() {
    final JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(10, 2)); // 10 rows to include all fields and buttons
    panel.setBackground(Color.decode("#ECF0F1"));

    // Fields for entering adherent information
    final JTextField idField = new JTextField();
    final JTextField cinField = new JTextField();
    final JTextField lastNameField = new JTextField();
    final JTextField firstNameField = new JTextField();
    final JTextField phoneField = new JTextField();
    final JTextField addressField = new JTextField();
    final JTextField faculteField = new JTextField();
    final JTextField vacationField = new JTextField();
    final JTextField niveauField = new JTextField();

    // Add labels and fields to the panel
    panel.add(new JLabel("ID Adhérent:"));
    panel.add(idField);
    panel.add(new JLabel("CIN:"));
    panel.add(cinField);
    panel.add(new JLabel("Nom:"));
    panel.add(lastNameField);
    panel.add(new JLabel("Prénom:"));
    panel.add(firstNameField);
    panel.add(new JLabel("Téléphone:"));
    panel.add(phoneField);
    panel.add(new JLabel("Adresse:"));
    panel.add(addressField);
    panel.add(new JLabel("Faculté:"));
    panel.add(faculteField);
    panel.add(new JLabel("Vacation:"));
    panel.add(vacationField);
    panel.add(new JLabel("Niveau:"));
    panel.add(niveauField);

    // Update button
    JButton updateButton = new JButton("Mettre à jour");
    updateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logique pour mettre à jour l'adhérent ici
            String id = idField.getText();
            String cin = cinField.getText();
            String lastName = lastNameField.getText();
            String firstName = firstNameField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();
            String faculte = faculteField.getText();
            String vacation = vacationField.getText();
            String niveau = niveauField.getText();

            // Créer une instance de GestionAdherant
            GestionAdherant gestionAdherant = new GestionAdherant();
            Adherent updatedAdherent = new Adherent(id, cin, lastName, firstName, phone, address, faculte, vacation, niveau);
            
            try {
                // Mettre à jour l'adhérent dans la base de données
                gestionAdherant.updateAdherant(updatedAdherent); // Assurez-vous que cette méthode est correctement implémentée

                // Afficher un message de succès
                JOptionPane.showMessageDialog(panel, "Adhérent mis à jour avec succès!");
            } catch (Exception ex) {
                // Afficher un message d'erreur
                JOptionPane.showMessageDialog(panel, "Erreur lors de la mise à jour de l'adhérent: " + ex.getMessage());
            }
            
            // Réinitialiser les champs après l'ajout
            idField.setText("");
            cinField.setText("");
            lastNameField.setText("");
            firstNameField.setText("");
            phoneField.setText("");
            addressField.setText("");
            faculteField.setText("");
            vacationField.setText("");
            niveauField.setText("");
        }
    });

    panel.add(updateButton);
    return panel;
}


//    // Panneau pour lister les adhérents
//    private JPanel createListAdherentPanel() {
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.decode("#ECF0F1"));
//        panel.add(new JLabel("Fonction de liste des adhérents (à implémenter)"));
//        return panel;
//    }
// Panneau pour lister les adhérents
// Panneau pour lister les adhérents
private JPanel createListAdherentPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout()); // Use BorderLayout for better layout management
    panel.setBackground(Color.decode("#ECF0F1"));

    // Title Label
    JLabel titleLabel = new JLabel("Liste des Adhérents", JLabel.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
    panel.add(titleLabel, BorderLayout.NORTH);

    // Table to display adherents
    String[] columnNames = {"ID", "CIN", "Nom", "Prénom", "Téléphone", "Adresse", "Faculté", "Vacation", "Niveau"};
    final DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    JTable adherentTable = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(adherentTable);
    
    // Fetch and populate adherents from GestionAdherant
    final GestionAdherant gestionAdherant = new GestionAdherant();
    ArrayList<Adherent> adherents = gestionAdherant.getAllAdherant(); // Changed to ArrayList

    for (Adherent adherent : adherents) {
        Object[] rowData = {
            adherent.getId(),
            adherent.getCin(),
            adherent.getLastName(),
            adherent.getFirstName(),
            adherent.getPhone(),
            adherent.getAddress(),
            adherent.getFaculte(),
            adherent.getVacation(),
            adherent.getNiveau()
        };
        tableModel.addRow(rowData);
    }

    // Add table to the panel
    panel.add(scrollPane, BorderLayout.CENTER);

    // Button to refresh the list (optional)
    JButton refreshButton = new JButton("Rafraîchir la liste");
    refreshButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear current table data
            tableModel.setRowCount(0);
            // Re-fetch adherents and update the table
            ArrayList<Adherent> updatedAdherents = gestionAdherant.getAllAdherant(); // Changed to ArrayList
            for (Adherent adherent : updatedAdherents) {
                Object[] rowData = {
                    adherent.getId(),
                    adherent.getCin(),
                    adherent.getLastName(),
                    adherent.getFirstName(),
                    adherent.getPhone(),
                    adherent.getAddress(),
                    adherent.getFaculte(),
                    adherent.getVacation(),
                    adherent.getNiveau()
                };
                tableModel.addRow(rowData);
            }
        }
    });

    panel.add(refreshButton, BorderLayout.SOUTH); // Add the refresh button at the bottom

    return panel;
}


    // Panneau pour supprimer un adhérent
//    private JPanel createDeleteAdherentPanel() {
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.decode("#ECF0F1"));
//        panel.add(new JLabel("Fonction de suppression des adhérents (à implémenter)"));
//        return panel;
//    }
// Panneau pour cacher un adhérent
private JPanel createDeleteAdherentPanel() {
    final JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2)); // Layout for inputs and buttons
    panel.setBackground(Color.decode("#ECF0F1"));

    final JTextField idField = new JTextField();

    panel.add(new JLabel("ID Adhérent:"));
    panel.add(idField);

    JButton hideButton = new JButton("Cacher Adhérent");
    hideButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = idField.getText();
            GestionAdherant gestionAdherant = new GestionAdherant();
            boolean success = gestionAdherant.deleteAdherant(id); // Call the new method

            if (success) {
                JOptionPane.showMessageDialog(panel, "Adhérent caché avec succès!");
            } else {
                JOptionPane.showMessageDialog(panel, "Échec de la mise à jour de l'adhérent.");
            }

            // Clear the input field after the operation
            idField.setText("");
        }
    });

    panel.add(hideButton);
    return panel;
}


    // Méthode main pour tester la fenêtre
    public static void main(String[] args) {
        new AdherentFrame();
    }
}
