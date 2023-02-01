
package graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class C_Help_fram extends JFrame
{
        Base64.Decoder decod = Base64.getDecoder();
    
    boolean found=false;
    Ab P1 = new Ab();
    JPanel P = new JPanel();
    ImageIcon ph1 = new ImageIcon("image\\search\\icon.png");
    ImageIcon ph2 = new ImageIcon("image\\search\\fund.png");
    ImageIcon ph3 = new ImageIcon("image\\search\\not.png");
    ImageIcon ph4 = new ImageIcon("image\\search\\1.jpg");
    JButton B1 =new JButton("",ph1);
    JButton B2 =new JButton("verifie");
    JLabel L1 = new JLabel(ph4);
    JLabel L2 = new JLabel(ph2);
    JLabel L3 = new JLabel(ph3);
    JLabel L4 = new JLabel("user name");
    JLabel L5 = new JLabel("");
    JLabel L6 = new JLabel("");
    JLabel L7 = new JLabel("");;

    JTextField T1 = new JTextField();
    JTextField T2 = new JTextField();
    JTextField T3 = new JTextField();
    String u,user,password1,password,Q1,Q2,E1,E2,user1;
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
    public void found(boolean found)
    {
        T2.setBounds(310,400,225,30);
        T2.setVisible(found);
        T3.setBounds(310,460,225,30);
        T3.setVisible(found);
        
        B2.setBounds(340,520,160,30);
        B2.setVisible(found);
        B2.setBackground(new Color(0,153,255));
        B2.setForeground(Color.black);
        B2.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        
        L5.setBounds(310,430,400,40);
        L5.setForeground(Color.black);
        L5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        L5.setVisible(found);
        L6.setBounds(310,370,400,40);
        L6.setForeground(Color.black);
        L6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        L6.setVisible(found);
        
        L7.setText("hellow "+user1);
        L7.setBounds(140,320,400,40);
        L7.setForeground(Color.green);
        L7.setFont(new Font("Segoe UI", Font.BOLD, 24));
        
        L2.setBounds(10,340,185,220);
        L2.setVisible(found);
        
        P.add(L2);P.add(L6);P.add(L5);
        P.add(T3);P.add(T2);
        P.add(B2);
    }
    public void not(boolean not)
    {
        
        L3.setBounds(20,320,185,220);
        L3.setVisible(not);
        L7.setText("user not found !!");
        L7.setBounds(210,430,400,40);
        L7.setForeground(Color.red);
        L7.setFont(new Font("Segoe UI", Font.BOLD, 28));
        
        P.add(L3);
        
    }
    public void help()
    {
        found(false);
        not(false);
        setIconImage();
        //help frame
        setSize(600, 600);
        setTitle("Password_Recorder");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);   
           
        
        P.setBackground(Color.white);
        P.setLayout(null);
        
        B1.setBounds(200,35,60,50);
        B1.setForeground(new Color(51,51,255));
        B1.setBackground(new Color(0,153,255));
        B1.setFont(new Font("Segoe UI", Font.BOLD, 12));
        B1.setOpaque(false);
        B1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        
        
        L1.setBounds(210,0,375,300);
        
        L4.setBounds(30,15,150,40);
        L4.setForeground(new Color(0,153,255));
        L4.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        L7.setBounds(310,350,300,40);
        L7.setText("enswer to the folowing quation");
        L7.setForeground(new Color(0,153,255));
        L7.setFont(new Font("Segoe UI", Font.BOLD, 14));
        L7.setVisible(false);
        
        T1.setBounds(30,50,225,30);
        T1.setOpaque(false);
        T1.setForeground(Color.black);
        T1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        
        P.add(L2);P.add(L3);
        P.add(B1);      
        P.add(L1);P.add(L4);P.add(L7);    
        P.add(T1);P.add(T2);P.add(T3);
        this.add(P);
        
        B1.addActionListener(P1);
        B2.addActionListener(P1);

        
    }
    private void setIconImage() 
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PasswordRecorder_logo.png")));
    }
    private class Ab implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)  
        {

            //verification
            

            if(e.getSource()==B1)
                
            {
                
                u=T1.getText();
                try 
                {
                    
                    connection();
                    //read
                    ResultSet resultSet = statement.executeQuery("select * from users`users` where nom = '"+u+"'");
                    while(resultSet.next())
                    {
                        String nom = resultSet.getString("nom");
                        user1=nom;
                    }
                }
                catch (Exception ex) 
                {
                    System.out.println("find eurreur");
      
                }
                if(user1 == null)
                {
                    found(false);
                    not(true);
                    
                    L7.setVisible(true);
                }
                else
                {
                 
                    try 
                    {
                        connection();

                            ResultSet resultSet = statement.executeQuery("select password,Q1,EN1,Q2,EN2 from users where nom = '"+user1+"'");
                            while(resultSet.next())
                            {
                                String password2 = resultSet.getString("password");
                                String Q11 = resultSet.getString("Q1");
                                String S11 = resultSet.getString("EN1");
                                String Q21 = resultSet.getString("Q2");
                                String S21 = resultSet.getString("EN2");
                              
                                byte[] n1 = decod.decode(Q11);
                                String QU1 = new String(n1);
                                byte[] n2 = decod.decode(S11);
                                String EN1 = new String(n2);
                                byte[] n3 = decod.decode(Q21);
                                String QU2 = new String(n3);
                                byte[] n4 = decod.decode(S21);
                                String EN2 = new String(n4);

                                Q1=QU1;
                                Q2=QU2;
                                E1=EN1;
                                E2=EN2;
                                password1=password2;


                            }

                        L6.setText(Q1);
                        L5.setText(Q2);
                        

                    }
                     catch (SQLException ex) {
                        Logger.getLogger(C_Help_fram.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    L7.setVisible(true);
                    not(false);
                    found(true);
                
                }
                
            }
            if(e.getSource()==B2)
            {
                String L1 = T2.getText().toString();
                String L2 = T3.getText().toString();
                Base64.Decoder decod = Base64.getDecoder();
                byte[] n = decod.decode(password1);
                password = new String(n);
                if((L1.equals(E1))&&(L2.equals(E2)))
                {
                    JOptionPane.showMessageDialog(null,user1+"\nyour password :: "+password);
                    T2.setText("");
                    T3.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"    incorrect answers");
                    T3.setText("");
                    T2.setText("");
                }   
               
            }

        }

    } 
    
}
