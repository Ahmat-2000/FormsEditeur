package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.observerPaterne.ModelListener;

/**
 *
 * @author 21912949
 */
public class RectangleView extends JPanel implements IView , ModelListener{
    public RectangleView(){
        setPreferredSize(new Dimension(40,40));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(null);
        System.out.println("getX() = "+getAlignmentX());
        System.out.println("gety() = "+getY());
        System.out.println("width = "+getWidth());
        System.out.println("height = "+getHeight());
    }
    @Override
    public void somethingHasChanged(Object source) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'somethingHasChanged'");
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

		g.drawRect( 0,0,20,20);
    }
    
}
