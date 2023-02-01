
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Base64;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class App_panel extends JPanel
{

    
    
    celect c = new celect();
    act a = new act();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    
    ImageIcon hom = new ImageIcon("src\\icon\\home.png");
    ImageIcon prof = new ImageIcon("src\\icon\\profile.png");
    ImageIcon logout = new ImageIcon("src\\icon\\logout.png");
    
    JCheckBox c1 = new JCheckBox("Home",hom);
    JCheckBox c2 = new JCheckBox("Profile",prof);
    JButton c3 = new JButton("Logout",logout);
    
    ButtonGroup G1 = new ButtonGroup();
    
    JLabel l1 = new JLabel("Password");
    JLabel l2 = new JLabel("Saver");
    ImageIcon logo = new ImageIcon("src\\icon\\2_1.png");
    JLabel l3 = new JLabel(logo);

    item it = new item();

    
    //variabuls

    boolean over;
    String user,password,ID;
    int x,y,xw,yh;
    int perg,perf,pero;
    double TOTAL,totalg,totalf,totalo;
    
    java.sql.Connection con;
    java.sql.Statement statement;
    public void connection()
    {
        try 
        {
            con = DriverManager.getConnection("jdbc:sqlite:data.db");
            statement = con.createStatement();
        } 
        catch (Exception e) 
        {
            
        }
    }
    public App_panel(String u,String p,String d)  
    {
        this.user=u;
        this.password=p;
        this.ID=d;
        
    }
    
    public void TOTALcount()
    {
        connection();
        try
        {
            ResultSet resultSet = statement.executeQuery("select COUNT(*) from google where nom = '"+user+"'");
            while(resultSet.next())
            {
                totalg = resultSet.getInt("COUNT(*)");
            }
        }
        catch(Exception e)
        {
        }
        connection();
        try
        {
            ResultSet resultSet = statement.executeQuery("select COUNT(*) from facebook where nom = '"+user+"'");
            while(resultSet.next())
            {
                totalf = resultSet.getInt("COUNT(*)");
            }
        }
        catch(Exception e)
        {
        }
        connection();
        try
        {
            ResultSet resultSet = statement.executeQuery("select COUNT(*) from other where nom = '"+user+"'");
            while(resultSet.next())
            {
                totalo = resultSet.getInt("COUNT(*)");
            }
        }
        catch(Exception e)
        {
        }
        TOTAL=totalg+totalf+totalo;
        double g = (totalg/TOTAL)*100;
        double f = (totalf/TOTAL)*100;
        double o = (totalo/TOTAL)*100;
        perg = (int) g;
        perf = (int) f;
        pero = (int) o;
        
    }
    
    App_panel_home home ;
    App_panel_profile profile;

    public void bb()
    {

        setLayout(null);
        TOTALcount();
        home = new App_panel_home(user,password,ID);
        profile= new App_panel_profile(user,password,ID);
        
        home.home();
        profile.profile(perg,perf,pero);
        
        p1.setBounds(200, 0, 1105, 750);
        p1.setVisible(true);
        p1.setLayout(null);
        
        p2.setBounds(200, 0, 1105, 750);
        p2.setVisible(false);
        p2.setLayout(null);
        
        p1.add(home);
        p2.add(profile);
        
        c1.setBounds(10, 200, 180, 30);
        c1.setBackground(Color.darkGray);
        c1.setVisible(true);
        c1.setOpaque(false);
        c1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.blue));
        c1.setSelected(true);
        c1.setForeground(Color.white);
        c1.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        
        c2.setBounds(10, 240, 180, 30);
        c2.setBackground(Color.darkGray);
        c2.setVisible(true);
        c2.setOpaque(false);
        c2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.blue));
        c2.setForeground(Color.white);
        c2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        
        c3.setBounds(10, 650, 180, 30);
        c3.setBackground(Color.darkGray);
        c3.setVisible(true);
        c3.setOpaque(false);
        c3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.blue));
        c3.setForeground(Color.white);
        c3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        

        l1.setBounds(95 ,10, 100, 40);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Segoe UI", Font.ITALIC, 24));
        

        l2.setBounds(85 ,40, 100, 40);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Segoe UI", Font.ITALIC, 24));
        
        l3.setBounds(10 ,5, 75, 75);
        
        G1.add(c1);G1.add(c2);G1.add(c3);
        
        this.add(c1);this.add(c2);this.add(c3);
        
        this.add(l1);this.add(l2);this.add(l3);
        
        this.add(p1);
        this.add(p2);


        
        c1.addItemListener(it);
        c2.addItemListener(it);
        c3.addActionListener(a);
        
        c1.addMouseListener(c);
        c2.addMouseListener(c);
        c3.addMouseListener(c);
        l3.addMouseListener(c);
        
    }
    

    public class celect implements MouseListener
    {
        public void mouseClicked(MouseEvent e) 
        {
            if(e.getSource()==l3)
            {
                graph.E_About_fram ab = new graph.E_About_fram();
                ab.ab();
            }
            
        }
        
        @Override
        public void mousePressed(MouseEvent e) 
        {
            
        }
        @Override
        public void mouseReleased(MouseEvent e) 
        {
            
        }
        @Override
        public void mouseEntered(MouseEvent e) 
        {
            if(e.getSource()==c1)
            {
                over=true;
                x=c1.getX();
                y=c1.getY();
                xw=c1.getWidth();
                yh=c1.getHeight();
            }
            if(e.getSource()==c2)
            {
                over=true;
                x=c2.getX();
                y=c2.getY();
                xw=c2.getWidth();
                yh=c2.getHeight();
            }
            if(e.getSource()==c3)
            {
                over=true;
                x=c3.getX();
                y=c3.getY();
                xw=c3.getWidth();
                yh=c3.getHeight();
            }


        }
        @Override
        public void mouseExited(MouseEvent e)
        {
            if(e.getSource()==c1)
            {
                over=false;
            }
            if(e.getSource()==c2)
            {
                over=false;
            }
            if(e.getSource()==c3)
            {
                over=false;
            }
        }
            
        
    }
    private class item implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e) 
        {
              
            if(c1.isSelected())
            {
                
                connection();
                try
                {
                    ResultSet resultSet = statement.executeQuery("select nom,password from users where ID = '"+ID+"'");
                    while(resultSet.next())
                    {
                        user = resultSet.getString("nom");
                        String p = resultSet.getString("password");
                        Base64.Decoder decod = Base64.getDecoder();
                        byte[] n = decod.decode(p);
                        password = new String(n);
                    }
                }
                catch(Exception ex)
                {
                   
                }
                App_panel_home home= new App_panel_home(user,password,ID);  
                home.home();
                p2.setVisible(false);
                p1.removeAll();
                p1.add(home);
                p1.repaint();
                p1.revalidate();
                p1.setVisible(true);
                
                

            }
            if(c2.isSelected())
            {
                p1.setVisible(false);
                p2.removeAll(); 
                p2.repaint();
                p2.revalidate();
                TOTALcount();
                App_panel_profile profile= new App_panel_profile(user,password,ID);
                profile.profile(perg,perf,pero);
                p2.add(profile);
                p2.setVisible(true);

            }

        }
    }
    private class act implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()==c3) 
            {
                connection();
                try
                {
                    ResultSet resultSet = statement.executeQuery("select nom,password from users where ID = '"+ID+"'");
                    while(resultSet.next())
                    {
                        user = resultSet.getString("nom");
                        String p = resultSet.getString("password");
                        
                        Base64.Decoder decod = Base64.getDecoder();
                        byte[] n = decod.decode(p);
                        password = new String(n);
                    }
                }
                catch(Exception ex)
                {  
                }
                App_Frame_logout logout = new App_Frame_logout();
                logout.frame(user,password,ID);
                
            }
        }
    }

    protected void paintComponent(Graphics grphcs) {
        
        Graphics2D G1 = (Graphics2D) grphcs;
       
        G1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        GradientPaint g1 = new GradientPaint(0, 0, Color.decode("#4A00E0"), 0, getHeight(), Color.decode("#8E2DE2"));
        G1.setPaint(g1);
        G1.fillRoundRect(0, 0, 200, getHeight(), 15, 15);
        
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (c1.isSelected()) 
        {
            g2.setColor(new Color(255, 255, 255, 155));
            g2.fillRoundRect(c1.getX(),c1.getY(),c1.getWidth(),c1.getHeight(), 15, 15);
        } 
        if (c2.isSelected()) 
        {
            g2.setColor(new Color(255, 255, 255, 155));
            g2.fillRoundRect(c2.getX(),c2.getY(),c2.getWidth(),c2.getHeight(), 15, 15);
        } 
        if (c3.isSelected()) 
        {
            g2.setColor(new Color(255, 255, 255, 155));
            g2.fillRoundRect(c3.getX(),c3.getY(),c3.getWidth(),c3.getHeight(), 15, 15);
        } 
        if(over)
        {
            g2.setColor(new Color(255, 255, 255, 50));
            g2.fillRoundRect(x,y,xw,yh, 15, 15);
        }
        super.paintChildren(grphcs);
    }
    
}
