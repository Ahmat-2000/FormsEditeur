package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SideContainer extends JPanel{
    public SideContainer(){
        setPreferredSize(new Dimension(200,0));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
}
