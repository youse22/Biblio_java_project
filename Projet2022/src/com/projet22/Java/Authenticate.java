/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet22.Java;
import java.awt.*;    
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Marie-Vonise LORDEUS
 */
public class Authenticate{
    private JButton loginButton;
    
    public static void main(String[] args) {
        final JFrame frame = new JFrame("JFrame Example");  
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        //teks kap afiche nan tet la
        JLabel labelTet = new JLabel("BLIBLIOTHEQUE DE L'UNIVERSITER DE LA RENAISSANCE DHAITI");
        // Create a font with the desired size and style
        Font labelTetFont = new Font("Arial", Font.BOLD, 40);
        labelTet.setForeground(Color.WHITE);
        labelTet.setFont(labelTetFont);
        labelTet.setBackground(Color.decode("#000066"));
        labelTet.setBounds(35, 35, 1300, 60);
        
        JLabel labelTet1 = new JLabel("BURH");
        labelTet1.setForeground(Color.WHITE);
        labelTet1.setFont(labelTetFont);
        labelTet1.setBackground(Color.decode("#000066"));
        labelTet1.setBounds(600, 85, 1300, 60);
        
        JPanel panel = new JPanel();
        final JPanel panel1 = new JPanel();
        panel.setBounds(450, 250, 450, 250);    
        panel.setBackground(Color.decode("#000066"));
       
        // Create a font with the desired size and style
        Font labelFont = new Font("Arial", Font.BOLD, 24);
        
        JLabel auth = new JLabel("Veillez vous connecter");
        auth.setForeground(Color.WHITE);
        auth.setFont(labelFont);
        auth.setBounds(100, 25, 300, 20);
        
        JLabel label1 = new JLabel("Username");
        //label username font
        Font labelUser = new Font("Arial", Font.BOLD, 17);
        label1.setFont(labelUser);
        label1.setForeground(Color.WHITE);
        label1.setBounds(10, 70, 100, 10);
        
        JLabel label2 = new JLabel("Password");
        //label username font
        Font labelPass = new Font("Arial", Font.BOLD, 17);
        label2.setFont(labelPass);
        label2.setForeground(Color.decode("#ffffff"));
        label2.setBounds(10, 110, 100, 10);
        
        final JTextField text = new JTextField();
        text.setBounds(100, 68, 250, 20);
        
        final JPasswordField text1 = new JPasswordField();
        text1.setBounds(100, 108, 250, 20);
        
        JButton saveButton = new JButton("Login");
        saveButton.setForeground(Color.WHITE);
        saveButton.setBackground(Color.DARK_GRAY);
        saveButton.setFont(labelFont);
        saveButton.setBounds(100, 170, 250, 30);
        
        panel.add(auth);
        
        panel.add(label1);
        panel.add(label2);
        
        panel.add(text);
        panel.add(text1);
        
        panel.add(saveButton);
        panel.setLayout(null);
        
        frame.add(labelTet);
        frame.add(labelTet1);
        frame.add(panel);
        
        frame.setLayout(null);
        
        frame.setPreferredSize(screenSize); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        frame.pack();
        frame.getContentPane().setBackground(Color.decode("#00004d"));
        frame.setVisible(true);
        
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer le texte du JTextField
                String texte = text.getText();
                String texte1 = text1.getText();
                // Faire quelque chose avec le texte récupéré
                
                if(texte.equalsIgnoreCase("marx") & texte1.equalsIgnoreCase("admin")){
                    System.out.println("Marx");
                    frame. setContentPane(panel1);
                    frame.revalidate();
                }else{
                    System.out.println("CharMax");
                }
            }
        });
        
    }
}
