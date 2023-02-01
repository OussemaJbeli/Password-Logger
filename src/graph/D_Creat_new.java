
package graph;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Base64;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class D_Creat_new extends JFrame
{

    cc V = new cc();
    String user1=null;
    act y = new act();
    JPanel P1 = new JPanel();
    JPanel P2 = new JPanel();
    JPanel P3 = new JPanel();
    Choice cc1 = new Choice();
    Choice cc2 = new Choice();
    ImageIcon ph1 = new ImageIcon("image\\creat new\\1\\2.png");
    ImageIcon ph2 = new ImageIcon("image\\creat new\\1\\4.png");
    JButton b1 = new JButton(ph1);
    JButton b2 = new JButton(ph2);
    JButton b3 = new JButton("creat");
    JCheckBox C1 ;
    JTextField T1 = new JTextField();
    JTextField T2 = new JTextField();
    JTextField T3 = new JTextField();
    JPasswordField p2 = new JPasswordField();
    JPasswordField p3 = new JPasswordField();
    JTextField T4 = new JTextField();
    JTextField T5 = new JTextField();
    JLabel L8 = new JLabel("____CREATE NEW ACCOUNT____");
    JLabel L1 = new JLabel("user name");
    JLabel userEr = new JLabel("");
    JLabel L2 = new JLabel("password");
    JLabel L3 = new JLabel("confirm password");
    JLabel passEr1 = new JLabel("");
    JLabel passEr2 = new JLabel("");
    JLabel L6 = new JLabel("____Security question____");
    JLabel L7 = new JLabel("Please remember the answer to your security question.\nit can helpe you retrieve your password in case \nyou forget it.");
    JLabel L9 = new JLabel("quation 1");
    JLabel L10 = new JLabel("enswer");
    JLabel L11 = new JLabel("quation 2");
    JLabel L12 = new JLabel("enswer");
    JLabel En1 = new JLabel("");
    JLabel En2 = new JLabel("");
    ImageIcon image=new ImageIcon("image\\creat new\\1\\3.png");
    JLabel L5= new JLabel(image);
    String UID;
    
    JLabel L0 ;
    
    String LL1,LL2,LL3,K1,K2,K3,K4,K5,K6,R1,R2,R3,R4,userer,passer1,passer2,en1,en2;
    String user,password;
    boolean chek = false;
    int i;
    
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
    //creation de tableau
    public void create()
    {
        try 
        {
        connection();
        String sql="create table users\n" +
                    "(ID integer primary key AutoIncrement,\n" +
                    "nom varchar(25),\n" +
                    "password varchar(50),\n" +
                    "path varchar(25),\n" +
                    "Q1 varchar(50),\n" +
                    "Q2 varchar(50),\n" +
                    "EN1 varchar(50),\n" +
                    "EN2 varchar(50)\n" +
                    ");";
        statement.executeUpdate(sql);
        }
        catch (Exception ex) 
        {

        }
    }
    void photo(String h)
    {
            ImageIcon ph3 = new ImageIcon("image\\creat new\\1\\"+h);
            L0 = new JLabel(ph3);
            L0.setBounds(0, -30, 570, 590);
            L0.setBackground(Color.white);
            L0.setVisible(true);
            
                    
            P3.add(L0);
    }
    public void pan1()
    {
        
        T1.setBounds(120,210,225,30);
        T1.setOpaque(false);
        T1.setForeground(Color.black);
        T1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(153,0,255)));
        
        T2.setBounds(120,290,225,30);
        T2.setVisible(false);
        T2.setOpaque(false);
        T2.setForeground(Color.black);
        T2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(153,0,255)));
        
        T3.setBounds(120,370,225,30);
        T3.setVisible(false);
        T3.setOpaque(false);
        T3.setForeground(Color.black);
        T3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(153,0,255)));
        
        p2.setBounds(120,290,225,30);
        p2.setVisible(true);
        p2.setOpaque(false);
        p2.setForeground(Color.black);
        p2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(153,0,255)));
        
        p3.setBounds(120,370,225,30);
        p3.setVisible(true);
        p3.setOpaque(false);
        p3.setForeground(Color.black);
        p3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(153,0,255)));
        
        
        L1.setBounds(120,170,307,40);
        L1.setForeground(new Color(153,0,255));
        L1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        userEr.setBounds(120,225,307,40);
        userEr.setForeground(Color.RED);
        userEr.setFont(new Font("Segoe UI", Font.BOLD, 11));
        userEr.setVisible(false);
        
        L2.setBounds(120,250,307,40);
        L2.setForeground(new Color(153,0,255));
        L2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        L3.setBounds(120,330,307,40);
        L3.setForeground(new Color(153,0,255));
        L3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        passEr1.setBounds(120,305,307,40);
        passEr1.setForeground(Color.RED);
        passEr1.setFont(new Font("Segoe UI", Font.BOLD, 11));
        passEr1.setVisible(false);
        
        passEr2.setBounds(120,385,307,40);
        passEr2.setForeground(Color.RED);
        passEr2.setFont(new Font("Segoe UI", Font.BOLD, 11));
        passEr2.setVisible(false);
        
        L8.setBounds(95,130,307,40);
        L8.setForeground(new Color(153,0,255));
        L8.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        
        L5.setBounds(170,20,100,100);
        
        b1.setBounds(195, 440, 50, 50);
        b1.setForeground(new Color(51,51,255));
        b1.setBackground(new Color(0,153,255));
        b1.setOpaque(false);
        b1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        
        ImageIcon eye1 = new ImageIcon("image\\creat new\\eye\\2.png");
        C1 = new JCheckBox("",eye1);
        C1.setBounds(345,290,50,30);
        C1.setOpaque(false);
        C1.setVisible(true);
        C1.setIcon(eye1);
        
        
        P1.add(C1);
    }
    public void pan2()
    {
        L7.setBounds(60,100,307,40);
        L7.setForeground(new Color(0,52,255));
        L7.setFont(new Font("Segoe UI", Font.BOLD, 14));
        L7.setVisible(true);
        
        L6.setVisible(true);
        L6.setBounds(100,50,307,40);
        L6.setForeground(new Color(153,0,255));
        L6.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        
        b2.setBounds(70, 440, 50, 50);
        b2.setVisible(true);
        b2.setForeground(new Color(51,51,255));
        b2.setBackground(new Color(0,153,255));
        b2.setOpaque(false);
        b2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        
        b3.setBounds(250,450,100,40);
        b3.setVisible(true);
        b3.setBackground(new Color(0,153,255));
        b3.setForeground(Color.black);
        b3.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        
        cc1.setBounds(80,180,250,50);
        cc1.setForeground(new Color(0,52,255));
        cc1.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        cc1.setVisible(true);
        cc1.add("What is your father name?");
        cc1.add("What is your mather name?");
        cc1.add("What is your first school name?");
        cc1.add("Where are you borne?");
        cc1.add("What is your pet name?");
        cc1.add("What is the first film you watched?");
        
        cc2.setBounds(80,310,250,50);
        cc2.setForeground(new Color(0,52,255));
        cc2.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        cc2.setVisible(true);
        cc2.add("What is your father name?");
        cc2.add("What is your mather name?");
        cc2.add("What is your first school name?");
        cc2.add("Where are you borne?");
        cc2.add("What is your pet name?");
        cc2.add("What is the first film you watched?");
        
        T4.setBounds(80,230,250,30);
        T4.setVisible(true);
        T4.setOpaque(false);
        T4.setForeground(Color.black);
        T4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(153,0,255)));
        
        T5.setBounds(80,360,250,30);
        T5.setVisible(true);
        T5.setOpaque(false);
        T5.setForeground(Color.black);
        T5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(153,0,255)));
        
        En1.setBounds(80,250,307,30);
        En1.setForeground(Color.RED);
        En1.setFont(new Font("Segoe UI", Font.BOLD, 11));
        En1.setVisible(false);
        
        En2.setBounds(80,380,307,30);
        En2.setForeground(Color.RED);
        En2.setFont(new Font("Segoe UI", Font.BOLD, 11));
        En2.setVisible(false);
        
        L9.setBounds(80,150,307,30);
        L9.setForeground(new Color(153,0,255));
        L9.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        L10.setBounds(80,200,307,30);
        L10.setForeground(new Color(153,0,255));
        L10.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        L11.setBounds(80,280,307,30);
        L11.setForeground(new Color(153,0,255));
        L11.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        L12.setBounds(80,330,307,30);
        L12.setForeground(new Color(153,0,255));
        L12.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }
    D_Creat_new()
    {
        
        //creat Frame
        setSize(1020, 575);
        setTitle("Password Logger");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        pan1();
        pan2();
        photo("1.jpg");
    
        P1.setVisible(true);
        P1.setLayout(null);
        P1.setBounds(0, 0, 450, 590);
        P1.setBackground(Color.white);
        

        P3.setVisible(true);
        P3.setLayout(null);
        P3.setBounds(450, 0, 570, 590);
        P3.setBackground(Color.red);
     

        P2.setBounds(0, 0, 450, 590);
        P2.setBackground(Color.white);
        P2.setVisible(false);
        P2.setLayout(null);
        
        
        
        
        
        
        
        
        
        P1.add(b1);
        P1.add(T1);P1.add(T2);P1.add(T3);
        P1.add(p2);P1.add(p3);
        P1.add(L1);P1.add(L2);P1.add(L3);P1.add(L5);P1.add(L8);
        P1.add(C1);
        P1.add(userEr);P1.add(passEr1);P1.add(passEr2);
        
        P2.add(b2);P2.add(b3);
        P2.add(L6);P2.add(L7);P2.add(L9);P2.add(L10);P2.add(L11);P2.add(L12);
        P2.add(cc1);P2.add(cc2);
        P2.add(T4);P2.add(T5);
        P2.add(En1);P2.add(En2);
        
        
        P3.add(L0);
        
        this.add(P3);
        this.add(P1);
        this.add(P2);
        
        b1.addActionListener(y);
        b2.addActionListener(y);
        b3.addActionListener(y);
        
        C1.addItemListener(V);
        
    }

    class act implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {

            if(e.getSource()== b1)
            {
                        LL1=T1.getText().toString();
                        //
                        if(chek==true)
                        {
                            LL2=T2.getText().toString();
                            LL3=T3.getText().toString();
                        }
                        else
                        {
                            LL2 =p2.getText().toString();
                            LL3 =p3.getText().toString();
                        }
                        //
                        if(LL1.length()==0 )
                        {
                            userer="user empty";
                        }
                        else if(LL1.equals(user1) )
                        {
                            userer="User already used";
                        }
                        else if(LL1.length()>12 )
                        {
                            userer="User very long";
                        }
                        else
                        {
                            userer="";
                        }
                        //
                        if(LL2.length()==0 )
                        {
                            passer1="Password empty";
                        }
                        else if(LL2.length()<8 )
                        {
                            passer1="the password must contain at least 8 characters";
                        }
                        else
                        {
                            passer1="";
                        }
                        //
                        if((!LL2.equals(LL3))&&(passer1.length()==0) )
                        {
                            passer2="The password is not compatible";
                        }
                        else
                        {
                            passer2="";
                        }
                        //
                        if((userer.length()==0)&&(passer2.length()==0)&&(passer1.length()==0))
                        {
                            P1.setVisible(false);
                            P2.setVisible(true);
                            L0.setVisible(false);
                            photo("6.jpg");
                            System.out.println();
                        }
                        userEr.setVisible(true);
                        passEr1.setVisible(true);
                        passEr2.setVisible(true);
                        userEr.setText(userer);
                        passEr1.setText(passer1);
                        passEr2.setText(passer2);
            }
            if(e.getSource()== b2)
            {
                P2.setVisible(false);
                P1.setVisible(true);
                L0.setVisible(false);
                photo("1.jpg"); 
            }
            //creat
            if(e.getSource()==b3)
            {
                
                R1=cc1.getSelectedItem();
                R2=T4.getText().toString();
                R3=cc2.getSelectedItem();
                R4=T5.getText().toString();
                
                

                try 
                {
                    
                    connection();
                    create();
                    //read
                    ResultSet resultSet = statement.executeQuery("select * from users where nom = '"+LL1+"'");
                    while(resultSet.next())
                    {
                        String nom = resultSet.getString("nom");
                        user1=nom;
                    }
                }
                catch (Exception ex) {
      
                }
                        //
                        if(R2.length()==0 )
                        {
                            en1="select a question from the list";
                        }
                        else
                        {
                            en1="";
                        }
                        //
                        if(R4.length()==0 )
                        {
                            en2="select a question from the list";
                        }
                        else
                        {
                            en2="";
                        }
                        //
                        if((en1.length()==0)&&(en2.length()==0))
                        {
                            setVisible(false);
                          
                                    
                            user=LL1;
                            password=LL2;
                            
                            
                            Base64.Encoder encod = Base64.getEncoder();
                            //coder pass
                            String password2 = encod.encodeToString(password.getBytes());
                            String RR1 = encod.encodeToString(R1.getBytes());
                            String RR2 = encod.encodeToString(R2.getBytes());
                            String RR3 = encod.encodeToString(R3.getBytes());
                            String RR4 = encod.encodeToString(R4.getBytes());
                            try 
                            {
                                connection();
                                String sql="INSERT INTO `users`(`nom`, `password`, `Q1`, `EN1`, `Q2`, `EN2`) VALUES ('"+user+"','"+password2+"','"+RR1+"','"+RR2+"','"+RR3+"','"+RR4+"')";
                                //create

                                statement.executeUpdate(sql);
                            } 
                            catch (Exception ex) 
                            {
                                JOptionPane.showMessageDialog(null,"Error 1 "+ex.getMessage());
                            }
     
                            D_chouse_Pic_fornew ch = new D_chouse_Pic_fornew(user);
                        }
                        En1.setVisible(true);
                        En2.setVisible(true);

                        En1.setText(en1);
                        En2.setText(en2);

            }       
        }        
    }
    
 
class cc implements ItemListener
{
    @Override
        public void itemStateChanged(ItemEvent e)
        {
            
            if(C1.isSelected())
                {
                    
                    String L2 = p2.getText().toString();
                    T2.setText(L2);
                    p2.setVisible(false);
                    T2.setVisible(true);
                    String L3 = p3.getText().toString();
                    T3.setText(L3);
                    p3.setVisible(false);
                    T3.setVisible(true);
                    chek=true;
                    ImageIcon eye1 = new ImageIcon("image\\creat new\\eye\\1.png");
                    C1.setIcon(eye1);
                }
                else
                {
                    String L2 = T2.getText().toString();
                    p2.setText(L2);
                    p2.setVisible(true);
                    T2.setVisible(false);
                    String L3 = T3.getText().toString();
                    p3.setText(L3);
                    p3.setVisible(true);
                    T3.setVisible(false);
                    chek=false;
                    ImageIcon eye1 = new ImageIcon("image\\creat new\\eye\\2.png");
                    C1.setIcon(eye1);
                }   
        }
    }
}    

