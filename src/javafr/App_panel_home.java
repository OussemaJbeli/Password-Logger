
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
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;


public class App_panel_home extends JPanel
{
    Base64.Decoder decod = Base64.getDecoder();
    Base64.Encoder encod = Base64.getEncoder();
    //cards
    card1 C1 = new card1();

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    ImageIcon gp = new ImageIcon("src\\icon\\google.png");
    ImageIcon fp = new ImageIcon("src\\icon\\face.png");
    ImageIcon op = new ImageIcon("src\\icon\\other.png");
    
    
    //select edite dlete add
    ImageIcon gen_edit1 = new ImageIcon("src\\icon\\edite.png");
    ImageIcon gen_edit2 = new ImageIcon("src\\icon\\edite_inv.png");
    ImageIcon add = new ImageIcon("src\\icon\\add.png");
    ImageIcon mod = new ImageIcon("src\\icon\\modify.png");
    ImageIcon del = new ImageIcon("src\\icon\\delete.png");
    
    JCheckBox c1 = new JCheckBox("add",add);
    JCheckBox c2 = new JCheckBox("edite",mod);
    JCheckBox c3 = new JCheckBox("delete",del);
    JCheckBox c4 = new JCheckBox("",gen_edit1);
 
    ButtonGroup G1 = new ButtonGroup();
    
    
    //element add
    JButton b1 = new JButton("add");
    JButton b2 = new JButton("save");
    JButton b3 = new JButton("delete");
    
    JTextField T1 = new JTextField();
    JTextField T2 = new JTextField();
    JTextField T3 = new JTextField();
    JTextField T4 = new JTextField();
    JTextField T5 = new JTextField();
    
    JLabel al1=new JLabel("type");
    JLabel al2=new JLabel("user");
    JLabel al3=new JLabel("e_mail");
    JLabel al4=new JLabel("password");
    JLabel al5=new JLabel("phone");
    JLabel al8=new JLabel("");
    JLabel al9=new JLabel("");
    
    ImageIcon pub = new ImageIcon("src\\icon\\pob.png");
    ImageIcon dial = new ImageIcon("src\\icon\\dialog2.png");
    
    JLabel al6=new JLabel(pub);
    JLabel al7=new JLabel(dial);
    
    
    //table
    JScrollPane scrollPane;
    JTable table;
    String [][] data;
    String [] columnNames1;
    int length=0;
    
    action Ac = new action();
    item it = new item();
    ball ball = new ball();
    Timer tt = new Timer(1,ball);
    
    //variabuls

    int indx1=0,indx2=0;
    int deference1,deference2;
    int x,y,xw,yh;
    boolean adde=false,edit=false,over,over1,cardpressC1=true,cardpressC2,cardpressC3;
    String user,password,ID;
    public App_panel_home(String u,String p,String d)  
    {
        this.user=u;
        this.password=p;
        this.ID=d;

    }
    
    //coonection
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
    //create google
    public void creatego()
    {
        try 
        {
        connection();
        String sql="create table google\n" +
                    "(ID_local integer primary key AutoIncrement,\n" +
                    "ID integer,\n" +
                    "user varchar(25),\n" +
                    "password varchar(50),\n" +
                    "e_mail varchar(50),\n" +
                    "type varchar(25),\n" +
                    "nom varchar(25),\n" +
                    "phone varchar(25),\n" +
                    "date_of_last_modification  varchar(100),\n" +
                    "CONSTRAINT fk_google1 FOREIGN KEY (ID) REFERENCES users(ID),\n" +
                    "CONSTRAINT fk_google2 FOREIGN KEY (nom) REFERENCES users(nom)\n" +
                    ");";
        statement.executeUpdate(sql);
        }
        catch (Exception ex) 
        {

        }
    }
    //create faceboock
    public void createface()
    {
        try 
        {
        connection();
        String sql="create table facebook\n" +
                    "(ID_local integer primary key AutoIncrement,\n" +
                    "ID integer,\n" +
                    "user varchar(25),\n" +
                    "password varchar(50),\n" +
                    "e_mail varchar(50),\n" +
                    "e_mail_saver varchar(50),\n" +
                    "nom varchar(25),\n" +
                    "phone varchar(25),\n" +
                    "date_of_last_modification  varchar(100),\n" +
                    "CONSTRAINT fk_face1 FOREIGN KEY (ID) REFERENCES users(ID),\n" +
                    "CONSTRAINT fk_face2 FOREIGN KEY (nom) REFERENCES users(nom)\n" +
                    ");";
        statement.executeUpdate(sql);
        }
        catch (Exception ex) 
        {

        }
    }
    //create other
    public void createoth()
    {
        try 
        {
        connection();
        String sql="create table other\n" +
                    "(ID_local integer primary key AutoIncrement,\n" +
                    "ID integer,\n" +
                    "user varchar(25),\n" +
                    "password varchar(50),\n" +
                    "e_mail varchar(50),\n" +
                    "type varchar(25),\n" +
                    "nom varchar(25),\n" +
                    "phone varchar(25),\n" +
                    "date_of_last_modification  varchar(100),\n" +
                    "CONSTRAINT fk_other1 FOREIGN KEY (ID) REFERENCES users(ID),\n" +
                    "CONSTRAINT fk_other2 FOREIGN KEY (nom) REFERENCES users(nom)\n" +
                    ");";
        statement.executeUpdate(sql);
        }
        catch (Exception ex) 
        {

        }
    }
    public void cardg()
    {
              try 
                {
                connection();
                creatego();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT count(user) from google WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        int cunt = resultSet.getInt("COUNT(user)");
                        l8=new JLabel(""+cunt);
                    }
                } 
                catch (Exception e) 
                {
                }
        l1=new JLabel(gp);
        l4=new JLabel("");
        l7=new JLabel("Total acount :");
        
        l1.setBounds(10 ,25, 150, 120);
        l4.setBounds(10 ,10, 350, 150);
        
        l7.setBounds(150 ,110, 110, 30);
        l7.setForeground(Color.WHITE);
        l7.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        
        l8.setBounds(250 ,110, 100, 30);
        l8.setForeground(Color.WHITE);
        l8.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        
        this.add(l1);this.add(l4);this.add(l7);this.add(l8);
        
        
    }
    public void cardf()
    {
        try 
                {
                connection();
                createface();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT count(user) from facebook WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        int cunt = resultSet.getInt("COUNT(user)");
                        l10=new JLabel(""+cunt);
                    }
                } 
                catch (Exception e) 
                {
                }
        l2=new JLabel(fp);
        l5=new JLabel("");
        l9=new JLabel("Total acount :");

        int i=0;
        l2.setBounds(370 ,25, 150, 120);
        l5.setBounds(370 ,10, 350, 150);
        l9.setBounds(510 ,110, 110, 30);
        l9.setForeground(Color.WHITE);
        l9.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        
        l10.setBounds(610 ,110, 100, 30);
        l10.setForeground(Color.WHITE);
        l10.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        this.add(l2);this.add(l5);this.add(l9);this.add(l10);
        
        
    }
    public void cardo()
    {
        try 
                {
                connection();
                    createoth();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT count(user) from other WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        int cunt = resultSet.getInt("COUNT(user)");
                        l12=new JLabel(""+cunt);
                    }
                } 
                catch (Exception e) 
                {
                }
        l3=new JLabel(op);
        l6=new JLabel("");
        l11=new JLabel("Total acount :");

        l3.setBounds(730 ,25, 150, 120);
        l6.setBounds(730 ,10, 350, 150);
        l11.setBounds(870 ,110, 110, 30);
        l11.setForeground(Color.WHITE);
        l11.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        
        l12.setBounds(970 ,110, 100, 30);
        l12.setForeground(Color.WHITE);
        l12.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        this.add(l3);this.add(l6);this.add(l11);this.add(l12);
        
    }
    public void table(String taille)
    {

        if(taille.equals("max"))
        {

            //data
            if(cardpressC1)
            {
                //heder
                columnNames1 = new String[7];
                columnNames1[0]="ID";
                columnNames1[1]="type";
                columnNames1[2]="user";
                columnNames1[3]="e-mail";
                columnNames1[4]="password";
                columnNames1[5]="phone";
                columnNames1[6]="date of last modification";
                try 
                {
                connection();
                creatego();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT count(user) from google WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        int cunt = resultSet.getInt("COUNT(user)");
                        length=cunt;
                        if(cunt==0)
                        {
                            cunt++;
                        }
                        data = new String[cunt][7];
                        
                    }
                } 
                catch (Exception e) 
                {
                }
                int colNum=0;
                
                try 
                {
                    
                    connection();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT `ID_local`,`type`, `user`, `e_mail`, `password`, `phone`, `date_of_last_modification` FROM `google` WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
       
                        String IDe = resultSet.getString("ID_local");
                        String typee = resultSet.getString("type");
                        String usere = resultSet.getString("user");
                        String mail = resultSet.getString("e_mail");
                        String password1 = resultSet.getString("password");
                        String telephone = resultSet.getString("phone");
                        String date = resultSet.getString("date_of_last_modification");
                        //decode
                        byte[] n = decod.decode(password1);
                        String password2 = new String(n);
                                data[colNum][0]=IDe;
                                data[colNum][1]=typee;
                                data[colNum][2]=usere;
                                data[colNum][3]=mail;
                                data[colNum][4]=password2;
                                data[colNum][5]=telephone;
                                data[colNum][6]=date;
                                
                            colNum++;
                    }
                }
                catch (SQLException ex) 
                {
                }
                
            }
            if(cardpressC2)
            {
                //heder
                columnNames1 = new String[7];
                columnNames1[0]="ID";
                columnNames1[1]="user";
                columnNames1[2]="e-mail";
                columnNames1[3]="password";
                columnNames1[4]="e-mail saver";
                columnNames1[5]="phone Number";
                columnNames1[6]="date of last modification ";
            
                try 
                {
                connection();
                createface();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT count(user) from facebook WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        int cunt = resultSet.getInt("COUNT(user)");
                        length=cunt;
                        if(cunt==0)
                        {
                            cunt++;
                        }
                        data = new String[cunt][7];
                    }
                } 
                catch (Exception e) 
                {
                }
                int colNum=0;
                
                try 
                {
                    
                    connection();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT `ID_local`,`user`, `e_mail`, `password`, `e_mail_saver`, `phone`, `date_of_last_modification` FROM `facebook` WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        String IDe = resultSet.getString("ID_local");
                        String typee = resultSet.getString("user");
                        String usere = resultSet.getString("e_mail");
                        String mail = resultSet.getString("password");
                        String password1 = resultSet.getString("e_mail_saver");
                        String telephone = resultSet.getString("phone");
                        String date = resultSet.getString("date_of_last_modification");
                        
                        byte[] n = decod.decode(password1);
                        String password2 = new String(n);
                                data[colNum][0]=IDe;
                                data[colNum][1]=typee;
                                data[colNum][2]=usere;
                                data[colNum][3]=mail;
                                data[colNum][4]=password2;
                                data[colNum][5]=telephone;
                                data[colNum][6]=date;

                            colNum++;
                    }
                }
                catch (SQLException ex) 
                {
                }
                
            }
            if(cardpressC3)
            {
                //heder
                columnNames1 = new String[7];
                columnNames1[0]="ID";
                columnNames1[1]="type";
                columnNames1[2]="user";
                columnNames1[3]="e-mail";
                columnNames1[4]="password";
                columnNames1[5]="phone";
                columnNames1[6]="date of last modification";
                try 
                {
                connection();
                createoth();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT count(user) from other WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        int cunt = resultSet.getInt("COUNT(user)");
                        length=cunt;
                        if(cunt==0)
                        {
                            cunt++;
                        }
                        data = new String[cunt][7];
                    }
                } 
                catch (Exception e) 
                {
                }
                int colNum=0;
                               
                try 
                {
                    
                    connection();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT `ID_local`,`type`, `user`, `e_mail`, `password`, `phone`, `date_of_last_modification` FROM `other` WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        String IDe = resultSet.getString("ID_local");
                        String typee = resultSet.getString("type");
                        String usere = resultSet.getString("user");
                        String mail = resultSet.getString("e_mail");
                        String password1 = resultSet.getString("password");
                        String telephone = resultSet.getString("phone");
                        String date = resultSet.getString("date_of_last_modification");
                        
                        byte[] n = decod.decode(password1);
                        String password2 = new String(n);
                        
                                data[colNum][0]=IDe;
                                data[colNum][1]=typee;
                                data[colNum][2]=usere;
                                data[colNum][3]=mail;
                                data[colNum][4]=password2;
                                data[colNum][5]=telephone;
                                data[colNum][6]=date;

                            colNum++;
                    }
                }
                catch (SQLException ex) 
                {
                }
                
            }

                table = new JTable(data, columnNames1);
                table.setVisible(true);
                table.setRowHeight(50);
                table.setFont(new Font("atilic",Font.BOLD,12)); 
                
                
                JTableHeader head = table.getTableHeader();
                head.setForeground(Color.white);
                head.setBackground(new Color(242, 22, 239, 255));
                head.setFont(new Font("t",Font.BOLD,20));

                TableColumn col20=table.getColumnModel().getColumn(0);
                TableColumn col21=table.getColumnModel().getColumn(1);
                TableColumn col22=table.getColumnModel().getColumn(2);
                TableColumn col23=table.getColumnModel().getColumn(3);
                TableColumn col24=table.getColumnModel().getColumn(4);
                TableColumn col25=table.getColumnModel().getColumn(5);
                TableColumn col26=table.getColumnModel().getColumn(6);
                
                col20.setPreferredWidth(60);
                col21.setPreferredWidth(130);
                col22.setPreferredWidth(130);
                col23.setPreferredWidth(220);
                col24.setPreferredWidth(180);
                col25.setPreferredWidth(180);
                col26.setPreferredWidth(260);

                scrollPane = new JScrollPane(table);
                scrollPane.setVisible(true);
                scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
                scrollPane.getViewport().setBackground(Color.WHITE);
                scrollPane.setBounds(15, 250, 1060, 440);
        }
        else 
        {
            
            if(cardpressC1)
            {
                columnNames1 = new String[6];
                columnNames1[0]="ID";
                columnNames1[1]="type";
                columnNames1[2]="user";
                columnNames1[3]="e-mail";
                columnNames1[4]="password";
                columnNames1[5]="phone";
                try 
                {
                connection();
                creatego();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT count(user) from google WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        int cunt = resultSet.getInt("COUNT(user)");
                        length=cunt;
                        if(cunt==0)
                        {
                            cunt++;
                        }
                        data = new String[cunt][6];
                    }
                } 
                catch (Exception e) 
                {
                }
                int colNum=0;
                
                try 
                {
                    
                    connection();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT `ID_local`,`type`, `user`, `e_mail`, `password`, `phone` FROM `google` WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {

                        String ID = resultSet.getString("ID_local");
                        String typee = resultSet.getString("type");
                        String usere = resultSet.getString("user");
                        String mail = resultSet.getString("e_mail");
                        String password1 = resultSet.getString("password");
                        String telephone = resultSet.getString("phone");
                        byte[] n = decod.decode(password1);
                        String password2 = new String(n);
                        
                                data[colNum][0]=ID;
                                data[colNum][1]=typee;
                                data[colNum][2]=usere;
                                data[colNum][3]=mail;
                                data[colNum][4]=password2;
                                data[colNum][5]=telephone;

                            colNum++;
                    }
                }
                catch (SQLException ex) 
                {
                }
                
            }
            if(cardpressC2)
            {
                columnNames1 = new String[6];
                columnNames1[0]="ID";
                columnNames1[1]="user";
                columnNames1[2]="e-mail";
                columnNames1[3]="password";
                columnNames1[4]="e-mail saver";
                columnNames1[5]="phone";
                try 
                {
                connection();
                createface();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT count(user) from facebook WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        int cunt = resultSet.getInt("COUNT(user)");
                        length=cunt;
                        if(cunt==0)
                        {
                            cunt++;
                        }
                        data = new String[cunt][6];
                    }
                } 
                catch (Exception e) 
                {
                }
                int colNum=0;
                
                try 
                {
                    
                    connection();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT `ID_local`,`user`, `e_mail`, `password`, `e_mail_saver`, `phone` FROM `facebook` WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {

                        String ID = resultSet.getString("ID_local");
                        String usere = resultSet.getString("user");
                        String email = resultSet.getString("e_mail");
                        String password1 = resultSet.getString("password");
                        String mail = resultSet.getString("e_mail_saver");
                        String telephone = resultSet.getString("phone");

                        byte[] n = decod.decode(password1);
                        String password2 = new String(n);
                        
                                data[colNum][0]=ID;
                                data[colNum][1]=usere;
                                data[colNum][2]=email;
                                data[colNum][3]=password2;
                                data[colNum][4]=mail;
                                data[colNum][5]=telephone;

                            colNum++;
                    }
                }
                catch (SQLException ex) 
                {
                }
                
            }
            if(cardpressC3)
            {
                columnNames1 = new String[6];
                columnNames1[0]="ID";
                columnNames1[1]="type";
                columnNames1[2]="user";
                columnNames1[3]="e-mail";
                columnNames1[4]="password";
                columnNames1[5]="phone";
                try 
                {
                connection();
                createoth();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT count(user) from other WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {
                        int cunt = resultSet.getInt("COUNT(user)");
                        length=cunt;
                        if(cunt==0)
                        {
                            cunt++;
                        }
                        data = new String[cunt][6];
                    }
                } 
                catch (Exception e) 
                {
                }
                int colNum=0;
                
                try 
                {
                    
                    connection();
                    //read
                    ResultSet resultSet = statement.executeQuery("SELECT `ID_local`,`type`, `user`, `e_mail`, `password`, `phone` FROM `other` WHERE nom='"+user+"'");
                    while(resultSet.next())
                    {

                        String ID = resultSet.getString("ID_local");
                        String typee = resultSet.getString("type");
                        String usere = resultSet.getString("user");
                        String mail = resultSet.getString("e_mail");
                        String password1 = resultSet.getString("password");
                        String telephone = resultSet.getString("phone");
                        
                        byte[] n = decod.decode(password1);
                        String password2 = new String(n);
                        
                                data[colNum][0]=ID;
                                data[colNum][1]=typee;
                                data[colNum][2]=usere;
                                data[colNum][3]=mail;
                                data[colNum][4]=password2;
                                data[colNum][5]=telephone;


                            colNum++;
                    }
                }
                catch (SQLException ex) 
                {
                }
                
            }
                
                
                table = new JTable(data, columnNames1);
                table.setVisible(true);
                table.setRowHeight(50);
                table.setFont(new Font("atilic",Font.BOLD,12)); 
                
                
                JTableHeader head = table.getTableHeader();
                head.setForeground(Color.white);
                head.setBackground(new Color(242, 22, 239, 255));
                head.setFont(new Font("t",Font.BOLD,20));

                TableColumn col21=table.getColumnModel().getColumn(0);
                TableColumn col22=table.getColumnModel().getColumn(1);
                TableColumn col23=table.getColumnModel().getColumn(2);
                TableColumn col24=table.getColumnModel().getColumn(3);
                TableColumn col25=table.getColumnModel().getColumn(4);
                TableColumn col26=table.getColumnModel().getColumn(5);

                
                col21.setPreferredWidth(30);
                col22.setPreferredWidth(140);
                col23.setPreferredWidth(150);
                col24.setPreferredWidth(210);
                col25.setPreferredWidth(160);
                col26.setPreferredWidth(150);
                
                scrollPane = new JScrollPane(table);
                scrollPane.setVisible(true);
                scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
                scrollPane.getViewport().setBackground(Color.WHITE);
                scrollPane.setBounds(15, 250, 740, 440);
        }
        if(length==0)
            table.setGridColor(Color.white);
        else
            table.setGridColor(Color.gray);
        
        this.add(scrollPane);
                table.addMouseListener(C1);
        
    }
    public void pan1(boolean vis,boolean mod1,boolean mod2,boolean mod3)
            
    {
        
        T1.setBounds(790,265,225,30);
        T1.setOpaque(false);
        T1.setForeground(Color.white);
        T1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        T1.setVisible(vis);
        
        T2.setBounds(790,325,225,30);
        T2.setVisible(false);
        T2.setOpaque(false);
        T2.setForeground(Color.white);
        T2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        T2.setVisible(vis);
        
        T3.setBounds(790,385,225,30);
        T3.setVisible(false);
        T3.setOpaque(false);
        T3.setForeground(Color.white);
        T3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        T3.setVisible(vis);
        
        T4.setBounds(790,445,225,30);
        T4.setVisible(false);
        T4.setOpaque(false);
        T4.setForeground(Color.white);
        T4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        T4.setVisible(vis);
        
        T5.setBounds(790,505,225,30);
        T5.setVisible(false);
        T5.setOpaque(false);
        T5.setForeground(Color.white);
        T5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        T5.setVisible(vis);
        //add
        al1.setBounds(780,230,307,40);
        al1.setForeground(Color.WHITE);
        al1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        al1.setVisible(vis);
        
        al2.setBounds(780,290,307,40);
        al2.setForeground(Color.WHITE);
        al2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        al2.setVisible(vis);
        
        al3.setBounds(780,350,307,40);
        al3.setForeground(Color.WHITE);
        al3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        al3.setVisible(vis);
        
        al4.setBounds(780,410,307,40);
        al4.setForeground(Color.WHITE);
        al4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        al4.setVisible(vis);
        
        al5.setBounds(780,470,307,40);
        al5.setForeground(Color.WHITE);
        al5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        al5.setVisible(vis);
        //edite

       
        
        
        al6.setBounds(900,440,150,150);
        al6.setVisible(mod3);
        
        al7.setBounds(780,220,250,250);
        al7.setVisible(mod3);
        
        al8.setBounds(30,50,200,40);
        al8.setForeground(Color.black);
        al8.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        al8.setVisible(mod3);
        
        al9.setBounds(100,80,150,40);
        al9.setForeground(Color.red);
        al9.setFont(new Font("Segoe UI", Font.BOLD, 16));
        al9.setVisible(mod3);
        
        b1.setBounds(850, 570, 100, 50);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(0,153,255));
        b1.setOpaque(false);
        b1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        b1.setVisible(mod1);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        b2.setBounds(850, 570, 100, 50);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(0,153,255));
        b2.setOpaque(false);
        b2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        b2.setVisible(mod2);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        b3.setBounds(850, 570, 100, 50);
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(0,153,255));
        b3.setOpaque(false);
        b3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        b3.setVisible(mod3);
        b3.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        
        this.add(T1);this.add(T2);this.add(T3);this.add(T4);this.add(T5);
        this.add(al1);this.add(al2);this.add(al3);this.add(al4);this.add(al5);this.add(al6);this.add(al7);al7.add(al8);al7.add(al9);
        this.add(b1);this.add(b2);this.add(b3);
        
        
    }
    
    
    public void home()
    {
        
        setSize(1105, 750);
        setOpaque(false);
        setLayout(null);     
        
        pan1(false,false,false,false);
        cardg();
        cardf();
        cardo();
        table("max");
        
        
        c1.setBounds(770, 190, 80, 30);
        c1.setBackground(Color.darkGray);
        c1.setVisible(true);
        c1.setOpaque(false);
        c1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        c1.setForeground(Color.black);
        c1.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        
        c2.setBounds(860, 190, 80, 30);
        c2.setBackground(Color.darkGray);
        c2.setVisible(true);
        c2.setOpaque(false);
        c2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        c2.setForeground(Color.black);
        c2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        
        c3.setBounds(950, 190, 80, 30);
        c3.setBackground(Color.darkGray);
        c3.setVisible(true);
        c3.setOpaque(false);
        c3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        c3.setForeground(Color.black);
        c3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        
        c4.setBounds(1040, 190, 70, 30);
        c4.setBackground(Color.darkGray);
        c4.setVisible(true);
        c4.setOpaque(false);
        c4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(true);
                    
        l13=new JLabel("Acounts Table_______");
        l13.setBounds(15 ,180, 200, 30);
        l13.setForeground(Color.gray);
        l13.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        G1.add(c1);G1.add(c2);G1.add(c3);
        
        this.add(c1);this.add(c2);this.add(c3);this.add(c4);
                
        this.add(l13);
         
        c1.addItemListener(it);
        c2.addItemListener(it);
        c3.addItemListener(it);
        c4.addItemListener(it);
        
        c1.addMouseListener(C1);
        c2.addMouseListener(C1);
        c3.addMouseListener(C1);
        l6.addMouseListener(C1); 
        l5.addMouseListener(C1);
        l4.addMouseListener(C1);
        
        b1.addActionListener(Ac);
        b2.addActionListener(Ac);
        b3.addActionListener(Ac);

    }


    
    public class card1 implements MouseListener
    {
        public void mouseClicked(MouseEvent e) 
        {
            if(e.getSource()==table)
            {
                
                if(c2.isSelected())
                {
                    T1.setText((String) table.getValueAt(table.getSelectedRow(), 1));
                    T2.setText((String) table.getValueAt(table.getSelectedRow(), 2));
                    T3.setText((String) table.getValueAt(table.getSelectedRow(), 3));
                    T4.setText((String) table.getValueAt(table.getSelectedRow(),4));
                    T5.setText((String) table.getValueAt(table.getSelectedRow(), 5));
                }
                if(c3.isSelected())
                {
                    table.setSelectionBackground(Color.red);
                    table.setSelectionForeground(Color.white);
                    al8.setText("you went to delete user");
                    if(cardpressC1)
                    {
                        
                        al9.setText((String) table.getValueAt(table.getSelectedRow(), 2));
                    }
                    if(cardpressC2)
                    {
                        al9.setText((String) table.getValueAt(table.getSelectedRow(), 3));
                    }
                    if(cardpressC3)
                    {
                        al9.setText((String) table.getValueAt(table.getSelectedRow(), 1));
                    }
                    
 
                }
            }
            
            if(e.getSource()==l4)
            {
                cardpressC1=true;
                cardpressC2=false;
                cardpressC3=false;
                scrollPane.setVisible(false);

                al1.setText("type");
                al2.setText("user");
                al3.setText("e_mail");
                al4.setText("password");
                al5.setText("phone");
                            
                if(edit==true)
                {
                    if(c1.isSelected())
                    {

                        table("min");
                        adde=true;
                        pan1(true,true,false,false);
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("");
                        T5.setText("");
                        
                    }

                    else if(c2.isSelected())
                    {
                        table("min");
                        adde=true;
                        pan1(true,false,true,false);
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("");
                        T5.setText("");
                       
                    }

                    else if(c3.isSelected())
                    {

                        pan1(false,false,false,true);
                        table("min");
                        adde=true;
                        al9.setText("");
                        al8.setText("");
                    }
                    else
                        c4.setSelected(false);
                }
                else
                    table("max");
            }
            if(e.getSource()==l5)
            {
                cardpressC1=false;
                cardpressC2=true;
                cardpressC3=false;
                scrollPane.setVisible(false);
                
                al1.setText("user");
                al2.setText("e-mail");
                al3.setText("password");
                al4.setText("e-mail saver");
                al5.setText("phone");
                            
                if(edit==true)
                {
                    if(c1.isSelected())
                    {
                        table("min");
                        adde=true;
                        pan1(true,true,false,false);
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("");
                        T5.setText("");
                    }

                    else if(c2.isSelected())
                    {
                        table("min");
                        adde=true;
                        pan1(true,false,true,false);
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("");
                        T5.setText("");
                    }

                    else if(c3.isSelected())
                    {
                        pan1(false,false,false,true);
                        table("min");
                        adde=true;
                        al9.setText("");
                        al8.setText("");
                    }
                    else
                        c4.setSelected(false);
                }
                else
                    table("max");

            }
            if(e.getSource()==l6)
            {
                cardpressC1=false;
                cardpressC2=false;
                cardpressC3=true;
                scrollPane.setVisible(false);
                
                al1.setText("type");
                al2.setText("user");
                al3.setText("e_mail");
                al4.setText("password");
                al5.setText("phone");
                
                if(edit==true)
                {
                    if(c1.isSelected())
                    {
                        scrollPane.setVisible(false);
                        table("min");
                        adde=true;
                        pan1(true,true,false,false);
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("");
                        T5.setText("");

                    }

                    else if(c2.isSelected())
                    {
                        scrollPane.setVisible(false);
                        table("min");
                        adde=true;
                        pan1(true,false,true,false);
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("");
                        T5.setText("");
    
                    }

                    else if(c3.isSelected())
                    {
                        scrollPane.setVisible(false);
                        pan1(false,false,false,true);
                        table("min");
                        adde=true;
                        al9.setText("");
                        al8.setText("");
                    }
                    else
                        c4.setSelected(false);
                }
                else
                    table("max");
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
                c1.setForeground(Color.WHITE);
            }
            if(e.getSource()==c2)
            {
                over=true;
                x=c2.getX();
                y=c2.getY();
                xw=c2.getWidth();
                yh=c2.getHeight();
                c2.setForeground(Color.WHITE);
            }
            if(e.getSource()==c3)
            {
                over=true;
                x=c3.getX();
                y=c3.getY();
                xw=c3.getWidth();
                yh=c3.getHeight();
                c3.setForeground(Color.WHITE);
            }
            if(e.getSource()==l4)
            {
                over1=true;
                x=l4.getX();
                y=l4.getY();
                xw=l4.getWidth();
                yh=l4.getHeight();

            }
            if(e.getSource()==l5)
            {
                over1=true;
                x=l5.getX();
                y=l5.getY();
                xw=l5.getWidth();
                yh=l5.getHeight();

            }
            if(e.getSource()==l6)
            {
                over1=true;
                x=l6.getX();
                y=l6.getY();
                xw=l6.getWidth();
                yh=l6.getHeight();

            }
        }
        @Override
        public void mouseExited(MouseEvent e)
        {
            if(e.getSource()==c1)
            {
                over=false;
                c1.setForeground(Color.black);
            }
            if(e.getSource()==c2)
            {
                over=false;
                c2.setForeground(Color.black);
            }
            if(e.getSource()==c3)
            {
                over=false;
                c3.setForeground(Color.black);
            }
            if(e.getSource()==l4)
            {
                over1=false;
            }
            if(e.getSource()==l5)
            {
                over1=false;

            }
            if(e.getSource()==l6)
            {
                over1=false;

            }

        }
            
        
    }

    private class item implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e) 
        {
            if(c4.isSelected()) 
            {
            c4.setIcon(gen_edit2);
            edit=true;
                    if(c1.isSelected())
                    {
                        scrollPane.setVisible(false);
                        table("min");
                        adde=true;
                        pan1(true,true,false,false);
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("");
                        T5.setText("");

                        

                    }

                    if(c2.isSelected())
                    {
                        scrollPane.setVisible(false);
                        table("min");
                        adde=true;
                        pan1(true,false,true,false);
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("");
                        T5.setText("");
                        
    
                    }

                    if(c3.isSelected())
                    {
                        scrollPane.setVisible(false);
                        pan1(false,false,false,true);
                        table("min");
                        adde=true;
                        al8.setText("");
                        al9.setText("");
                    }  
                
            }
            else
            {
                c4.setIcon(gen_edit1);
                edit=false;
                adde=false;
                scrollPane.setVisible(false);
                table("max");
                pan1(edit,edit,edit,edit);

            }
            
        }
    }
    private class action implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {

            //add
            if(e.getSource()==b1) 
            {
                        int o=0,o1=0,o2=0;
                        String s1,s2,s3,s4,s5,s6=(format("%tc",currentTimeMillis()));
                        s1=T1.getText().toString();
                        s2=T2.getText().toString();
                        s3=T3.getText().toString();
                        s4=T4.getText().toString();
                        s5=T5.getText().toString();
                        if(s1.length()==0)
                        {
                            s1="null";
                        }
                        if(s2.length()==0)
                        {
                            s2="null";
                        }
                        if(s3.length()==0)
                        {
                            s3="null";
                        }
                        if(s4.length()==0)
                        {
                            s4="null";
                        }
                        if(s5.length()==0)
                        {
                            s5="null";
                        }

                        
                        
                        if(cardpressC1)
                        {

                            try {
                                String password2 = encod.encodeToString(s4.getBytes());
                                connection();
                                String sql="INSERT INTO `google`(`ID`,`nom`, `type`, `user`, `e_mail`, `password`, `phone`, `date_of_last_modification`) VALUES ('"+ID+"','"+user+"','"+s1+"','"+s2+"','"+s3+"','"+password2+"','"+s5+"','"+s6+"')";                  
                                statement.executeUpdate(sql);
                            } catch (SQLException ex) {
                                Logger.getLogger(App_panel_home.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            } 
                            
                        
                        else if(cardpressC2)
                        {
                            try {
                                String password2 = encod.encodeToString(s3.getBytes());
                                connection();
                                String sql="INSERT INTO `facebook`(`ID`,`nom`, `user`, `e_mail`, `password`, `e_mail_saver`, `phone`, `date_of_last_modification`) VALUES ('"+ID+"','"+user+"','"+s1+"','"+s2+"','"+password2+"','"+s4+"','"+s5+"','"+s6+"')";  
                                statement.executeUpdate(sql);
                            } catch (SQLException ex) {
                                Logger.getLogger(App_panel_home.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        else if(cardpressC3)
                        {

                            try {
                                String password2 = encod.encodeToString(s4.getBytes());
                                connection();
                                String sql="INSERT INTO `other`(`ID`, `nom`, `type`, `user`, `e_mail`, `password`, `phone`, `date_of_last_modification`) VALUES ('"+ID+"','"+user+"','"+s1+"','"+s2+"','"+s3+"','"+password2+"','"+s5+"','"+s6+"')"; 
                                statement.executeUpdate(sql);
                            } catch (SQLException ex) {
                                Logger.getLogger(App_panel_home.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("");
                        T5.setText("");
                        scrollPane.setVisible(false);
                        table("min");
            }
            
            //edite
            if(e.getSource()==b2) 
            {
                            String s6,s0,s1,s2,s3,s4,s5= (format("%tc",currentTimeMillis()));
                            s0=T1.getText();
                            s1=T2.getText();
                            s2=T3.getText();
                            s3=T4.getText();
                            s4=T5.getText();
                            s6=(table.getValueAt(table.getSelectedRow(),0).toString());

                        if(cardpressC1)
                        {
                            try 
                            {
                                connection();
                                String password2 = encod.encodeToString(s3.getBytes());
                                String sql="UPDATE `google` SET `type`='"+s0+"',`user`='"+s1+"',`e_mail`='"+s2+"',`password`='"+password2+"',`phone`='"+s4+"',`date_of_last_modification`='"+s5+"' WHERE nom ='"+user+"' AND `ID_local`='"+s6+"'";
                                statement.executeUpdate(sql);
                            }
                            catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }
                        }
                        else if(cardpressC2)
                        {
                          
                            try 
                            {
                                connection();
                                String password2 = encod.encodeToString(s2.getBytes());
                                String sql="UPDATE `facebook` SET `user`='"+s0+"',`e_mail`='"+s1+"',`password`='"+password2+"',`e_mail_saver`='"+s3+"',`phone`='"+s4+"',`date_of_last_modification`='"+s5+"' WHERE nom ='"+user+"' AND `ID_local`='"+s6+"'";
                                statement.executeUpdate(sql);

                            }
                            catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }

                        }
                        else if(cardpressC3)
                        {
                            try 
                            {
                                connection(); 
                                String password2 = encod.encodeToString(s3.getBytes());
                                String sql="UPDATE `other` SET `type`='"+s0+"',`user`='"+s1+"',`e_mail`='"+s2+"',`password`='"+password2+"',`phone`='"+s4+"',`date_of_last_modification`='"+s5+"' WHERE nom ='"+user+"' AND `ID_local`='"+s6+"'";
                                statement.executeUpdate(sql);
                            }
                            catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }
                        }
                        
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("");
                        T5.setText("");
                        scrollPane.setVisible(false);
                        table("min");            
            }
            
            //delet
            if(e.getSource()==b3)
            { 
                        
                        String s0=(table.getValueAt(table.getSelectedRow(),0).toString());
                        if(cardpressC1)
                        {
                            try 
                            {
                                connection();
                                String sql="DELETE FROM `google` WHERE (nom = '"+user+"') AND (ID_local='"+s0+"')";
                                statement.executeUpdate(sql);

                            }
                            catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }
                            
                        }
                        
                        else if(cardpressC2)
                        {
                            try 
                            {
                                connection();
                                String sql="DELETE FROM `facebook` WHERE (nom = '"+user+"') AND (ID_local='"+s0+"')";
                                statement.executeUpdate(sql);

                            }
                            catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }
                        }
                        
                        else if(cardpressC3)
                        {
                            try 
                            {
                                connection();
                                String sql="DELETE FROM `other` WHERE (nom = '"+user+"') AND (ID_local='"+s0+"')";
                                statement.executeUpdate(sql);

                                
                            }
                            catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }
                        }
                        al8.setText("");
                        al9.setText("");
                        scrollPane.setVisible(false);
                        table("min");     
            }
            
        }
    }
    private class ball implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(adde==true)
            {
                if (indx1<470)
                {
                    deference1=15;   
                }
                else
                {
                    deference1=0; 
                    
                }   

            }
            if(adde==false)
            {
                if (indx1>0)
                {
                    deference1=-15;   
                }
                else
                {
                    deference1=0;   
                }    
            }
            if(edit==true)
            {
                if (indx2<300)
                {
                    deference2=15;   
                }
                else
                {
                    deference2=0;   
                } 
                
            }
            if(edit==false)
            {
                
                if (indx2>0)
                {
                    deference2=-15;   
                }
                else
                {
                    deference2=0;   
                }    
            }
            indx1+=deference1;
            indx2+=deference2;
            repaint();

        }
    }
    protected void paintComponent(Graphics grphcs) {
        Graphics2D G1 = (Graphics2D) grphcs;
        G1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#E100FF"), 0, getHeight(), Color.decode("#7F00FF"));//google
        G1.setPaint(g3);
        G1.fillRoundRect(10 ,10, 350, 150, 15, 15);

        G1.fillRoundRect(370, 10, 350, 150, 15, 15);
        
        G1.fillRoundRect(730, 10, 350, 150, 15, 15);

        G1.setColor(Color.white);
        G1.fillRoundRect(10, 170, 1070, 530, 15, 15);
        
        if(edit==true)
        {
            
            if(over)
            {
                G1.setColor(new Color(255, 220, 189, 242));
                G1.fillRoundRect(x,y,xw,yh, 15, 15);
            }
            GradientPaint g2 = new GradientPaint(0, 0, Color.decode("#b91d73"), 0, getHeight(), Color.decode("#f953c6"));
            G1.setPaint(g2);
            if (c2.isSelected()) 
            {
                G1.fillRoundRect(c2.getX(),c2.getY(),c2.getWidth(),c2.getHeight(), 15, 15);
            } 
            if (c3.isSelected()) 
            {

                G1.fillRoundRect(c3.getX(),c3.getY(),c3.getWidth(),c3.getHeight(), 15, 15);
            }
            if (c1.isSelected()) 
            {
                G1.fillRoundRect(c1.getX(),c1.getY(),c1.getWidth(),c1.getHeight(), 15, 15);
            }
                
        }
        if(over1)
                {
                    G1.setColor(new Color(255, 255, 255, 80));
                    G1.fillRoundRect(x,y,xw,yh, 15, 15);
                }
        if(cardpressC1)
        {
                G1.setColor(new Color(255, 220, 189, 242));
                G1.fillRoundRect(10, 10, 350, 150, 15, 15);
        }
        if(cardpressC2)
        {
                G1.setColor(new Color(255, 220, 189, 242));
                G1.fillRoundRect(370, 10, 350, 150, 15, 15);
        }
        if(cardpressC3)
        {
                G1.setColor(new Color(255, 220, 189, 242));
                G1.fillRoundRect(730, 10, 350, 150, 15, 15);
        }
        
        tt.start();
        GradientPaint g5;
        g5 = new GradientPaint(0, 0, Color.decode("#493240"), 0, getHeight(), Color.decode("#FF0099"));
        G1.setPaint(g5);
        
        G1.fillOval(1035, 178, 45, 45);
        
        if(indx2 >40)
        {
            G1.fillRoundRect(1060-indx2, 218, indx2, 5, 15, 15);
            if(indx2==300)
            {
                    c1.setVisible(edit);
                    c2.setVisible(edit);
                    c3.setVisible(edit);
                    if(indx1 >40)
                    {
                        G1.fillRoundRect(760, 223, 300, indx1, 15, 15);
                        if(indx1>450)
                            G1.setColor(Color.cyan);
                            G1.fillRoundRect(850, 575, 100, 40,15,15);
                    }
            }
            else
            {
                    c1.setVisible(false);
                    c2.setVisible(false);
                    c3.setVisible(false);
            }
        }
        

        
        super.paintChildren(grphcs);
    }
}
