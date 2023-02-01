
package graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class E_About_fram extends JFrame
{
    
    JLabel L1 = new JLabel("About");
    JLabel L2 = new JLabel("Password Logger");
    JLabel L3 = new JLabel("Software version 2.1.0");
    ImageIcon image=new ImageIcon("image\\logo\\PasswordRecorder_logo2.png");
    JLabel L4 = new JLabel(image);
    JPanel p = new JPanel();
   
    public void ab()
    {
        setIconImage();
         //about fram
        setSize(450, 350);
        setTitle("Password Logger");
        setLocation(500,175);
        setResizable(false);
        setVisible(true);   
        
        
        L1.setBounds(190,50,225,30);
        L1.setFont(new Font("atilic",Font.BOLD,25));
        L2.setBounds(160,210,225,30);
        L2.setFont(new Font("atilic",Font.BOLD,15));
        L3.setBounds(170,240,225,30);
        L3.setFont(new Font("atilic",Font.BOLD,10));
        L4.setBounds(170,85,100,100);
        
        L1.setForeground(Color.white);
        L2.setForeground(Color.white);
        L3.setForeground(Color.white);
        p.setBackground(Color.DARK_GRAY);
        p.setLayout(null);

        p.add(L1);p.add(L2);p.add(L3);p.add(L4);
        
        this.add(p);


        
       
    }
    private void setIconImage() 
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PasswordRecorder_logo.png")));
    }

   
}
