package view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Screen extends JFrame{
    
    public Screen(ViewFormContainer viewContainer, Header header){
        setTitle("Projet annuel");
        setIconImage(new ImageIcon("images"+File.separator+"icon.png").getImage());
        setSize(800,800);
        //setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(header, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel frame = (JPanel) this.getContentPane();
        frame.add(scroll,BorderLayout.NORTH);
        frame.add(viewContainer,BorderLayout.CENTER);
    }

}
