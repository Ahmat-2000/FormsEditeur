package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Screen extends JFrame{
    
    public Screen(ViewFormContainer viewContainer, Header header){
        setTitle("Projet annuel");
        setIconImage(new ImageIcon("images/icon.png").getImage());
        setSize(800,800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel frame = (JPanel) this.getContentPane();
        frame.add(header,BorderLayout.NORTH);
        frame.add(viewContainer,BorderLayout.CENTER);
    }

}
