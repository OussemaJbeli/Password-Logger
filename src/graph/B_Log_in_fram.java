
package graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Base64;
import javax.swing.*;
public class B_Log_in_fram extends JFrame
{
    String user,password,password1,ID,ur,pr;
    
    JButton B1 =new JButton("log in");
    JButton B2 =new JButton("creat new");
    JButton B3 =new JButton("forget password");

    JTextField T1 = new JTextField();
    JTextField T2 = new JTextField();
    JPasswordField Pass = new JPasswordField();
    JLabel L1 = new JLabel("user name");
    JLabel L2 = new JLabel("password");
    JLabel L3 = new JLabel("Welcome to Password Saver");
    
    ImageIcon error = new ImageIcon("src\\icon\\error.png");
    JLabel UR = new JLabel("");
    JLabel URI = new JLabel(error);
    JLabel PRI= new JLabel(error);
    JLabel PR = new JLabel("");
    
    ImageIcon ph1 = new ImageIcon("image\\login\\log\\key7.jpg");
    ImageIcon ph2 = new ImageIcon("image\\login\\log\\avatar.png");
    JLabel L4 = new JLabel(ph2);
    JLabel L5 = new JLabel(ph1);
    JLabel L6 = new JLabel("Password Saver");
    JLabel L7 = new JLabel("new in Password Saver?");
    JLabel L8 = new JLabel("___________________or___________________");
    JCheckBox C1;
    act A = new act();
    itm I = new itm();
    
    
    java.sql.Connection con;
    java.sql.Statement statement;
    
    public B_Log_in_fram() throws HeadlessException 
    {
        setIconImage();
    }
    //connection
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

    public void frame ()
    {
        //creat Frame
        setSize(1000, 590);
        setTitle("Password Saver");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true); 

        
        B1.setBounds(95,420,180,40);
        B1.setBackground(new Color(0,153,255));
        B1.setForeground(Color.black);
        B1.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        
        B2.setBounds(222,520,70,20);
        B2.setBackground(new Color(0,153,255));
        B2.setForeground(new Color(51,51,255));
        B2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        B2.setOpaque(false);
        B2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        
        B3.setBounds(200,370,110,20);
        B3.setForeground(new Color(51,51,255));
        B3.setBackground(new Color(0,153,255));
        B3.setFont(new Font("Segoe UI", Font.BOLD, 12));
        B3.setOpaque(false);
        B3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        
        
        L1.setBounds(70,205,307,40);
        L1.setForeground(new Color(0,153,255));
        L1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        L2.setBounds(70,295,307,40);
        L2.setForeground(new Color(0,153,255));
        L2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        L3.setBounds(40,25,307,40);
        L3.setForeground(new Color(204,204,204));
        L3.setFont(new Font("Segoe UI", Font.ITALIC, 24));
        
        L4.setBounds(130,80,100,100);
        
        L6.setBounds(580,70,325,50);
        L6.setForeground(new Color(51,204,255));
        L6.setFont(new Font("Segoe Print", Font.BOLD, 36));
        
        L7.setBounds(80,520,150,20);
        L7.setForeground(Color.WHITE);
        
        L8.setBounds(60,480,250,20);
        L8.setForeground(Color.WHITE);
        L8.setFont(new Font("Segoe Print", Font.ITALIC, 14));
        
        UR.setBounds(100,262,307,40);
        UR.setForeground(Color.RED);
        UR.setFont(new Font("Segoe UI", Font.BOLD, 11));
        UR.setVisible(false);
        
        URI.setBounds(75,275,15,15);
        PRI.setBounds(75,369,15,15);
        URI.setVisible(false);
        PRI.setVisible(false);
        
        PR.setBounds(100,352,307,40);
        PR.setForeground(Color.RED);
        PR.setFont(new Font("Segoe UI", Font.BOLD, 11));
        PR.setVisible(false);
        
        T1.setBounds(70,240,225,30);
        T1.setOpaque(false);
        T1.setForeground(Color.white);
        T1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        
        
        T2.setBounds(70,330,225,30);
        T2.setForeground(Color.white);
        T2.setOpaque(false);
        T2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        
        Pass.setBounds(70,330,225,30);
        Pass.setBackground(Color.darkGray);
        Pass.setForeground(Color.white);
        Pass.setOpaque(false);
        Pass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        
        ImageIcon eye1 = new ImageIcon("image\\login\\eye\\close.png");
        C1 = new JCheckBox("",eye1);
        C1.setBounds(295,330,50,20);
        C1.setOpaque(false);
        C1.setVisible(true);
        C1.setIcon(eye1);
        
        L5.add(T1);L5.add(Pass);
        
        L5.add(T2);
        
        L5.add(C1);
        
        L5.add(L1);L5.add(L2);L5.add(L3);L5.add(L4);L5.add(L6);L5.add(L7);L5.add(L8);
        
        L5.add(UR);L5.add(PR);L5.add(URI);L5.add(PRI);
        
        L5.add(B1);L5.add(B2);L5.add(B3);
        
        this.add(L5);
        
        C1.addItemListener(I);
        B1.addActionListener(A);
        B2.addActionListener(A);
        B3.addActionListener(A);
      
    }
    boolean check = false;

    private void setIconImage() 
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PasswordRecorder_logo.png")));
    }
    private class act implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            boolean g=true;
            //log in
            if(e.getSource()== B1)
            {
                //
                    user=null;
                    password=null;
                    String LL1 = T1.getText().toString();
                    Icon icon;
                    String LL2;
                    if(check==true)
                        {
                            LL2 = T2.getText().toString();
                        }
                    else
                        {
                            LL2 = Pass.getText().toString();;
                        }
                //
                     try 
                        {

                            connection();
                            //read
                            ResultSet resultSet = statement.executeQuery("select ID,nom,password from users where nom = '"+LL1+"'");
                            while(resultSet.next())
                            {
                                String id=resultSet.getString("ID");
                                String nom1 = resultSet.getString("nom");
                                String password2 = resultSet.getString("password");
                                user =nom1;
                                
                                password1=password2;
                                ID=id;
                            }
                            Base64.Decoder decod = Base64.getDecoder();
                            byte[] n = decod.decode(password1);
                            password = new String(n);
                        }
                        catch (Exception ex)
                        {

                            
                        }
                     
                        //
                        if(LL1.length()==0 )
                        {
                            ur="user empty";
                            URI.setVisible(true);
                        }
                        else if(user==null)
                        {
                            ur="user not found";
                            URI.setVisible(true);
                        }
                        else
                        {
                            ur="";
                            URI.setVisible(false);
                            
                            //
                            if(LL2.length()==0 )
                            {
                                pr="password empty";
                                PRI.setVisible(true);
                            }
                            else if(!(password.equals(LL2)))
                            {
                                pr="password incorrect";
                                PRI.setVisible(true);
                            }
                            else
                            {
                                pr="";
                                PRI.setVisible(false);
                            }
                        }

                        //
                        if((LL1.equals(user))&&(LL2.equals(password)))
                        {
                            
                                
                                javafr.App_frame A = new javafr.App_frame();
                                A.frame(user, password, ID);
                                setVisible(false);
                        }
                        UR.setVisible(true);
                        PR.setVisible(true);
                        UR.setText(ur);
                        PR.setText(pr);
                  

            }
            //new user
            if(e.getSource()==B2)
            {
                D_Creat_new C = new D_Creat_new();
                
            }
            
            //help
            if(e.getSource()== B3)
            {
                C_Help_fram H = new C_Help_fram();
                H.help();
                
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
                String TT2="";
                char[] L = Pass.getPassword();
                for(int i=0;i<L.length;i++)
                {
                    TT2 = TT2+""+L[i]; 
                }
                T2.setText(TT2);
                Pass.setVisible(false);
                T2.setVisible(true);
                check = true;
                ImageIcon eye1 = new ImageIcon("image\\login\\eye\\open.png");
                C1.setIcon(eye1);
            }
            else
            {
                String L = T2.getText().toString();
                Pass.setText(L);
                Pass.setVisible(true);
                T2.setVisible(false);
                check = false;
                ImageIcon eye1 = new ImageIcon("image\\login\\eye\\close.png");
                C1.setIcon(eye1);
            }   
        }
    }   
}
