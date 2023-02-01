package graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class D_chouse_Pic_fornew extends JFrame
{
    
    Creat V = new Creat();
    JPanel p = new JPanel();
    JLabel L1;
    JLabel L2;
    JLabel L3;
    JLabel L4;
    JButton b = new JButton("next");
    JRadioButton a1 = new JRadioButton();
    JRadioButton a2 = new JRadioButton();
    JRadioButton a3 = new JRadioButton();
    JRadioButton a4 = new JRadioButton();
    JRadioButton a5 = new JRadioButton();
    JRadioButton a6 = new JRadioButton();
    JRadioButton a7 = new JRadioButton();
    JRadioButton a8 = new JRadioButton();
    JRadioButton a9 = new JRadioButton();
    JRadioButton a10 = new JRadioButton();
    JRadioButton a11 = new JRadioButton();
    JRadioButton a12 = new JRadioButton();
    JRadioButton a13 = new JRadioButton();
    JRadioButton a14 = new JRadioButton();
    JRadioButton a15 = new JRadioButton();
    JRadioButton a16 = new JRadioButton();
    ButtonGroup R = new ButtonGroup();
    JLabel l = new JLabel("pleas select an avatar");
    String a,user;
    java.sql.Connection con;
    java.sql.Statement statement;
    public void connection()
    {
        try {
                    con = DriverManager.getConnection("jdbc:sqlite:data.db");
                    statement = con.createStatement();
        } catch (Exception e) {
        }
    }
    public D_chouse_Pic_fornew(String u)
    {
        setIconImage();
        this.user=u;
        setSize(535,800);
        setTitle("Password_Recorder");
        setLocation(525,0);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        p.setLayout(null);
        p.setBackground(Color.white);
        ImageIcon image1=new ImageIcon("image\\creat new\\avatar\\1.jpg");
        L1= new JLabel(image1);
        L1.setBounds(-90,50,700,150);
        ImageIcon image2=new ImageIcon("image\\creat new\\avatar\\2.jpg");
        L2= new JLabel(image2);
        L2.setBounds(-90,200,700,150);
        ImageIcon image3=new ImageIcon("image\\creat new\\avatar\\4.jpg");
        L3= new JLabel(image3);
        L3.setBounds(-90,350,700,150);
        ImageIcon image4=new ImageIcon("image\\creat new\\avatar\\3.jpg");
        L4= new JLabel(image4);
        L4.setBounds(-90,500,700,150);
        b.setBounds(210,680,100,30);
        b.setBackground(Color.black);
        b.setForeground(Color.blue);
        a1.setBounds(70,190,17,15);
        a1.setBackground(Color.white);
        a2.setBounds(190,190,17,15);
        a2.setBackground(Color.white);
        a3.setBounds(310,190,17,15);
        a3.setBackground(Color.white);
        a4.setBounds(430,190,17,15);
        a4.setBackground(Color.white);
        a5.setBounds(70,340,17,15);
        a5.setBackground(Color.white);
        a6.setBounds(190,340,17,15);
        a6.setBackground(Color.white);
        a7.setBounds(310,340,17,15);
        a7.setBackground(Color.white);
        a8.setBounds(430,340,17,15);
        a8.setBackground(Color.white);
        a9.setBounds(70,490,17,15);
        a9.setBackground(Color.white);
        a10.setBounds(190,490,17,15);
        a10.setBackground(Color.white);
        a11.setBounds(310,490,17,15);
        a11.setBackground(Color.white);
        a12.setBounds(430,490,17,15);
        a12.setBackground(Color.white);
        a13.setBounds(70,640,17,15);
        a13.setBackground(Color.white);
        a14.setBounds(190,640,17,15);
        a14.setBackground(Color.white);
        a15.setBounds(310,640,17,15);
        a15.setBackground(Color.white);
        a16.setBounds(430,640,17,15);
        a16.setBackground(Color.white);
        
        l.setBounds(150,20,500,30);
        l.setForeground(Color.black);
        l.setFont(new Font("atilic",Font.BOLD,20));
        
        R.add(a1);R.add(a2);R.add(a3);R.add(a4);R.add(a5);R.add(a6);R.add(a7);R.add(a8);
        R.add(a9);R.add(a10);R.add(a11);R.add(a12);R.add(a13);R.add(a14);R.add(a15);R.add(a16);
        p.add(b);
        p.add(L1);p.add(L2);p.add(L3);p.add(L4);
        p.add(a1);p.add(a2);p.add(a3);p.add(a4);p.add(a5);p.add(a6);p.add(a7);p.add(a8);
        p.add(a10);p.add(a12);p.add(a13);p.add(a14);p.add(a15);p.add(a16);p.add(a9);p.add(a11);
        p.add(l);
        
        this.add(p);
    
        b.addActionListener(V);
        a1.addActionListener(V);
        a2.addActionListener(V);
        a3.addActionListener(V);
        a4.addActionListener(V);
        a5.addActionListener(V);
        a6.addActionListener(V);
        a7.addActionListener(V);
        a8.addActionListener(V);
        a10.addActionListener(V);
        a12.addActionListener(V);
        a13.addActionListener(V);
        a14.addActionListener(V);
        a15.addActionListener(V);
        a16.addActionListener(V);
        a9.addActionListener(V);
        a11.addActionListener(V);
    }

    private void setIconImage() 
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PasswordRecorder_logo.png")));
    }
        

    class Creat implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try
            {
                if(e.getSource()==b)
                {

                    setVisible(false);
                    
                    connection();
                    String sql="UPDATE `users` SET `path`='"+a+"' WHERE `nom` = '"+user+"'";

                    //create
                    statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"creation seccesful");
                }
                if(e.getSource()==a1)
                {
                    a="1.png";                   
                }
                if(e.getSource()==a2)
                {
                    a="2.png";   
                }
                if(e.getSource()==a3)
                {
                    a="3.png";   
                }
                if(e.getSource()==a4)
                {
                    a="4.png";   
                }
                if(e.getSource()==a5)
                {
                   a="5.png";   
                }
                if(e.getSource()==a6)
                {
                    a="6.png";   
                }
                if(e.getSource()==a7)
                {
                    a="7.png";   
                }
                if(e.getSource()==a8)
                {
                    a="8.png";   
                }
                if(e.getSource()==a9)
                {
                    a="9.png";   
                }
                if(e.getSource()==a10)
                {
                    a="10.png";   
                }
                if(e.getSource()==a11)
                {
                    a="11.png";   
                }
                if(e.getSource()==a12)
                {
                    a="12.png";   
                }
                if(e.getSource()==a13)
                {
                    a="13.png";   
                }
                if(e.getSource()==a14)
                {
                    a="14.png";   
                }
                if(e.getSource()==a15)
                {
                    a="15.png";   
                }
                if(e.getSource()==a16)
                {
                    a="16.png";   
                }
            }
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(null,"Error");
            }
            
            
            
            
        }
            
        
        
        
        
        
        
        
        
        
    }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
}
