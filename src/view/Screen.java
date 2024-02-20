/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author 21912949
 */
public class Screen extends JFrame{
    
    public Screen(ViewContainer viewContainer, SideContainer sideContainer, Header header){
        setTitle("Projet annuel");
        setIconImage(new ImageIcon("icon.png").getImage());
        setSize(800,800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        JSeparator vertical = new JSeparator(SwingConstants.VERTICAL);
        JSeparator horizontal = new JSeparator(SwingConstants.HORIZONTAL);

        JPanel frame = (JPanel) this.getContentPane();
        frame.add(header,BorderLayout.NORTH);
        frame.add(horizontal);
        frame.add(sideContainer,BorderLayout.EAST);
        frame.add(vertical);
        frame.add(viewContainer,BorderLayout.CENTER);
    }

}
