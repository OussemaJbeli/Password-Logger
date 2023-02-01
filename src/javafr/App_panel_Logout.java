
package javafr;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class App_panel_Logout extends JPanel
{
    itm i = new itm();
    action Ac = new action();
    
    ImageIcon backG = new ImageIcon("src\\icon\\LogDEL.jpg");
    JLabel back = new JLabel(backG);
    
    ImageIcon ph1 = new ImageIcon("image\\creat new\\1\\2.png");
    ImageIcon ph2 = new ImageIcon("image\\creat new\\1\\4.png");
    JButton b1 = new JButton(ph1);
    JButton b2 = new JButton(ph2);
    JButton b3 = new JButton("Logout");
    JCheckBox C1 ;
    JTextField T1 = new JTextField();
    JPasswordField p = new JPasswordField();

    JLabel L8 = new JLabel("____DELETING ACCOUNT____");
    JLabel L1 = new JLabel("This app will automatically lock");
    JLabel L2 = new JLabel("verifi password");
    JLabel L3 = new JLabel("your account when you close it,");
    JLabel L6 = new JLabel("but if you log out, you will");
    JLabel L7 = new JLabel("lose all your data");

    boolean delete=false;
    String ID,user,password;
    
    java.sql.Connection con;
    java.sql.Statement statement;
    
    public void connection()
    {
        try {
                    con = DriverManager.getConnection("jdbc:sqlite:data.db");
                    statement = con.createStatement();
        } catch (Exception e) 
        {
            
        }
    }
    public App_panel_Logout(String u,String p,String d) 
    {
        this.user=u;
        this.password=p;
        this.ID=d;
    }
    public void pan1(boolean vis)
    {
        
       
                
        L1.setBounds(100,150,307,40);
        L1.setForeground(Color.white);
        L1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        L1.setVisible(vis);
        
        L3.setBounds(100,180,307,40);
        L3.setForeground(Color.white);
        L3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        L3.setVisible(vis);
        
        L6.setBounds(120,210,307,40);
        L6.setForeground(Color.white);
        L6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        L6.setVisible(vis);
        
        L7.setBounds(140,240,307,40);
        L7.setForeground(Color.red);
        L7.setFont(new Font("Segoe UI", Font.BOLD, 16));
        L7.setVisible(vis);
        
        L8.setBounds(95,100,307,40);
        L8.setForeground(Color.white);
        L8.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        L8.setVisible(vis);

        b1.setBounds(195, 440, 50, 50);
        b1.setForeground(new Color(51,51,255));
        b1.setBackground(Color.white);
        b1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        b1.setVisible(vis);
        
        
        
    }
    public void pan2(boolean vis)
    {
        delete=vis;
        L2.setBounds(120,140,307,40);
        L2.setForeground(Color.WHITE);
        L2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        L2.setVisible(true);
        L2.setVisible(vis);
        
        T1.setBounds(100,210,200,30);
        T1.setOpaque(false);
        T1.setForeground(Color.white);
        T1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        T1.setVisible(vis);
        
        
        
        p.setBounds(100,210,200,30);
        p.setOpaque(false);
        p.setForeground(Color.white);
        p.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        p.setVisible(vis);
        
        b2.setBounds(70, 440, 50, 50);
        b2.setVisible(false);
        b2.setForeground(new Color(51,51,255));
        b2.setBackground(new Color(0,153,255));
        b2.setOpaque(false);
        b2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        b2.setVisible(vis);
        
        b3.setBounds(250,450,100,40);
        b3.setVisible(true);
        b3.setBackground(new Color(0,153,255));
        b3.setForeground(Color.white);
        b3.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        b3.setOpaque(false);
        b3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.blue));
        b3.setVisible(vis);
        
        
        
    }
    public void logout()
    {
        
        setSize(1020, 595);
        setOpaque(false);
        setLayout(null); 
        
        pan1(true);
        pan2(false);
        
        back.setBounds(350, 0, 655, 560);

        ImageIcon eye1 = new ImageIcon("image\\login\\eye\\open.png");
        C1 = new JCheckBox("",eye1);
        C1.setBounds(300,210,50,30);
        C1.setOpaque(false);
        C1.setVisible(false);
        C1.setIcon(eye1);
        
        
        this.add(back);
        this.add(C1);
        this.add(b2);this.add(b3);this.add(p);this.add(C1);this.add(T1);this.add(L2);
        this.add(L1);this.add(L3);this.add(L6);this.add(L7);       
        this.add(L8);this.add(b1);
        b1.addActionListener(Ac);
        b2.addActionListener(Ac);
        b3.addActionListener(Ac);
        C1.addItemListener(i);
        
    }
    protected void paintComponent(Graphics grphcs) 
    {
        Graphics2D G1 = (Graphics2D) grphcs;
        G1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint g3 = new GradientPaint(10, 10, Color.decode("#eaafc8"), 0, getHeight(), Color.decode("#654ea3"));//google
        
        
        G1.setColor(Color.WHITE);
        G1.fill3DRect(0, 0, this.getWidth(), this.getHeight(), true);
        
        G1.setPaint(g3);
        G1.fillRoundRect(60 ,50, 300, 350, 15, 15);
        if(delete)
        {
        GradientPaint g4 = new GradientPaint(10, 10, Color.decode("#BB377D"), 0, getHeight(), Color.decode("#FBD3E9"));//google
        G1.setPaint(g4);
        G1.fillRoundRect(240 ,450, 120, 40, 15, 15);
        }
    }
    private class action implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {

            if(e.getSource()==b1) 
            {
                pan1(false);
                pan2(true);
                C1.setVisible(true);
            }
            if(e.getSource()==b2) 
            {
                pan1(true);
                pan2(false);
                C1.setVisible(false);
            }
            if(e.getSource()==b3) 
            {
                String ll;
                if(C1.isSelected())    
                    ll =T1.getText().toString();
                else
                    ll =p.getText().toString();
                
                if(ll.equals(password))
                {
                            try 
                            {
                                connection();
                                String sql1="DELETE FROM `users` where `ID` = '"+ID+"'";
                                statement.executeUpdate(sql1);
                                String sql2="DELETE FROM `facebook` where `ID` = '"+ID+"'";
                                statement.executeUpdate(sql2);
                                String sql3="DELETE FROM `google` where `ID` = '"+ID+"'";
                                statement.executeUpdate(sql3);
                                String sql4="DELETE FROM `other` where `ID` = '"+ID+"'";
                                statement.executeUpdate(sql4);
                            } catch (SQLException ex) 
                            {
                                System.out.println(ex.getMessage());
                            }
                            System.exit(0);
                }
                else
                    JOptionPane.showMessageDialog(null, "wronge password");
                            
            }
        }
    }
    
     class itm implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e) 
        {
            if(C1.isSelected())
            {
                String L = p.getText().toString();
                T1.setText(L);
                T1.setVisible(true);
                p.setVisible(false);
                ImageIcon eye1 = new ImageIcon("image\\login\\eye\\open.png");
                C1.setIcon(eye1);
                System.out.println("selected");
            }
            else
            {
                String L = T1.getText().toString();
                p.setText(L);
                p.setVisible(true);
                T1.setVisible(false);
                ImageIcon eye1 = new ImageIcon("image\\login\\eye\\close.png");
                C1.setIcon(eye1);
                System.out.println("not");
            }   
        }
    }  
}
