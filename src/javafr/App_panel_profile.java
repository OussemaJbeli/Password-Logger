
package javafr;

import java.awt.Choice;
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
import javax.swing.*;


public class App_panel_profile extends JPanel
{

    Base64.Encoder encod = Base64.getEncoder();
    
    ImageIcon tool = new ImageIcon("src\\icon\\tool.png");
    JLabel l1 = new JLabel(tool);
    //
    //logo animatio
    ImageIcon go = new ImageIcon("src\\icon\\go.png");
    ImageIcon fa = new ImageIcon("src\\icon\\fa.png");
    ImageIcon oth = new ImageIcon("src\\icon\\oth.png");
    
    JLabel l2 = new JLabel("Report Acount");
    JLabel l3 = new JLabel(go);
    JLabel l4 = new JLabel(fa);
    JLabel l5 = new JLabel(oth);
    //animation will
    private javafr.LiquidProgress liquidprogress1;
    private javafr.LiquidProgress liquidprogress2;
    private javafr.LiquidProgress liquidprogress3;
    
    //constrecteur
    ball ball = new ball();
    Timer tt = new Timer(1,ball);
    item I = new item();
    celect cc = new celect();
    action ac = new action();
    
    //change
    ImageIcon toolblack = new ImageIcon("src\\icon\\tool1.png");
    ImageIcon toolwhite= new ImageIcon("src\\icon\\tool2.png");

    JCheckBox userc = new JCheckBox("change username",toolblack);
    JCheckBox passc = new JCheckBox("change password",toolblack);
    JCheckBox imgc = new JCheckBox("change avatar",toolblack);
    JCheckBox sec = new JCheckBox("security question",toolblack);
    ButtonGroup G1 = new ButtonGroup();
    
    //user
    JButton ub1 = new JButton("change");
    JLabel ul1 = new JLabel("new Username");
    JTextField ut1 = new JTextField();
    //pass
    JButton pb1 = new JButton("change");
    JButton pb2 = new JButton("Forget Password");
    JLabel pl1 = new JLabel("old password");
    JLabel pl2 = new JLabel("new password");
    JLabel pl3 = new JLabel("new password");
    JTextField pt1 = new JTextField();
    JTextField pt2 = new JTextField();
    JTextField pt3 = new JTextField();
    //security
    JButton sb0 = new JButton("verify");
    JButton sb1 = new JButton("change");
    
    JLabel sl0 = new JLabel("verirfy password");
    JLabel sl1 = new JLabel("quation 1");
    JLabel sl2 = new JLabel("enswer");
    JLabel sl3 = new JLabel("quation 2");
    JLabel sl4 = new JLabel("enswer");
    
    JTextField st0 = new JTextField();
    JTextField st1 = new JTextField();
    JTextField st2 = new JTextField();
    
    Choice cc1 = new Choice();
        
    Choice cc2 = new Choice();
    
    //avatar
    
    JButton ba = new JButton("change");
    
        ImageIcon image1=new ImageIcon("image\\creat new\\avatar\\avatars\\1.png");
        ImageIcon image2=new ImageIcon("image\\creat new\\avatar\\avatars\\2.png");
        ImageIcon image3=new ImageIcon("image\\creat new\\avatar\\avatars\\4.png");
        
        ImageIcon image4=new ImageIcon("image\\creat new\\avatar\\avatars\\6.png");
        ImageIcon image5=new ImageIcon("image\\creat new\\avatar\\avatars\\7.png");
        ImageIcon image6=new ImageIcon("image\\creat new\\avatar\\avatars\\8.png");
       
        ImageIcon image7=new ImageIcon("image\\creat new\\avatar\\avatars\\10.png");
        ImageIcon image8=new ImageIcon("image\\creat new\\avatar\\avatars\\11.png");
        ImageIcon image9=new ImageIcon("image\\creat new\\avatar\\avatars\\12.png");

        ImageIcon image10=new ImageIcon("image\\creat new\\avatar\\avatars\\15.png");
        ImageIcon image11=new ImageIcon("image\\creat new\\avatar\\avatars\\16.png");

    JCheckBox a1a=new JCheckBox(image1);
    JCheckBox a2a=new JCheckBox(image2);
    JCheckBox a3a=new JCheckBox(image3);
    JCheckBox a4a=new JCheckBox(image4);
    JCheckBox a5a=new JCheckBox(image5);
    JCheckBox a6a=new JCheckBox(image6);
    JCheckBox a7a=new JCheckBox(image7);
    JCheckBox a8a=new JCheckBox(image8);
    JCheckBox a9a=new JCheckBox(image9);
    JCheckBox a10a=new JCheckBox(image10);
    JCheckBox a11a=new JCheckBox(image11);
    ButtonGroup G = new ButtonGroup();
    //profile bloque
    JLabel L5 = new JLabel();
    JLabel L1 = new JLabel("user");
    JLabel L2 ;
    
    
    //value
    int indx2=0;
    int deference2;
    int x,y,xw,yh,xo,yo,xow,yoh;
    boolean over,selected,overAV;
    static String path,user,password,ID,user1,avv;    
    
    java.sql.Connection con;
    java.sql.Statement statement;
    
    public App_panel_profile(String u,String p,String d)  
    {
        this.user=u;
        this.password=p;
        this.ID=d;
        
    }

    
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
    
    public void animation1(int perg)
    {

        liquidprogress1 = new javafr.LiquidProgress();
        liquidprogress1.setBackground(new java.awt.Color(51,255,255));
        liquidprogress1.setForeground(new java.awt.Color(42, 161, 233));
        liquidprogress1.setValue(perg);
        liquidprogress1.setAnimateColor(new java.awt.Color(204,255,255));
        liquidprogress1.setBorderColor(new java.awt.Color(42, 161, 233));
        liquidprogress1.setBorderSize(8);
        liquidprogress1.setSpaceSize(10);
        liquidprogress1.setBounds(362, 75, 175, 170);

        this.add(liquidprogress1);
    }
    public void animation2(int perf)
    {

        liquidprogress2 = new javafr.LiquidProgress();
        liquidprogress2.setBackground(new java.awt.Color(153,51,255));
        liquidprogress2.setForeground(Color.BLACK);
        liquidprogress2.setValue(perf);
        liquidprogress2.setAnimateColor(new java.awt.Color(255, 204, 255));
        liquidprogress2.setBorderColor(new java.awt.Color(102,0,153));
        liquidprogress2.setBorderSize(8);
        liquidprogress2.setSpaceSize(10);
        liquidprogress2.setBounds(612, 75, 175, 170);

        this.add(liquidprogress2);
    }
    public void animation3(int pero)
    {

        liquidprogress3 = new javafr.LiquidProgress();
        liquidprogress3.setBackground(new java.awt.Color(51, 255, 51));
        liquidprogress3.setForeground(new java.awt.Color(0, 153, 0));
        liquidprogress3.setValue(pero);
        liquidprogress3.setAnimateColor(new java.awt.Color(204, 255, 204));
        liquidprogress3.setBorderColor(new java.awt.Color(0, 153, 0));
        liquidprogress3.setBorderSize(8);
        liquidprogress3.setSpaceSize(10);
        liquidprogress3.setBounds(862, 75, 175, 170);
 
        this.add(liquidprogress3);
    }
    
    public void changeuser(boolean t1) 
    {           
        ub1.setBounds(360,640,100,30);
        ub1.setBackground(Color.blue);
        ub1.setForeground(Color.white);
        ub1.setOpaque(false);
        ub1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        ub1.setVisible(t1);
        ub1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        ut1.setBounds(300,500,225,30);
        ut1.setOpaque(false);
        ut1.setForeground(Color.white);
        ut1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        ut1.setVisible(t1);

        ul1.setBounds(300,450,307,40);
        ul1.setForeground(Color.WHITE);
        ul1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ul1.setVisible(t1);
        
        this.add(ub1);
        
        this.add(ut1);
        
        this.add(ul1);
        
        
        
        
    }
    
    public void changepass(boolean t1) 
    {
                   
        pb1.setBounds(360,640,100,30);
        pb1.setForeground(Color.WHITE);
        pb1.setBackground(new Color(0,153,255));
        pb1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        pb1.setOpaque(false);
        pb1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        pb1.setVisible(t1);
        
        pb2.setBounds(410,470,110,20);
        pb2.setForeground(Color.blue);
        pb2.setBackground(new Color(0,153,255));
        pb2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        pb2.setOpaque(false);
        pb2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        pb2.setVisible(t1);
       
        pt1.setBounds(300,440,225,30);
        pt1.setOpaque(false);
        pt1.setForeground(Color.white);
        pt1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        pt1.setVisible(t1);
        
        pt2.setBounds(300,520,225,30);
        pt2.setOpaque(false);
        pt2.setForeground(Color.white);
        pt2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        pt2.setVisible(t1);
        
        pt3.setBounds(300,590,225,30);
        pt3.setOpaque(false);
        pt3.setForeground(Color.white);
        pt3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        pt3.setVisible(t1);
        
        pl1.setBounds(300,410,307,30);
        pl1.setForeground(Color.WHITE);
        pl1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pl1.setVisible(t1);
        
        pl2.setBounds(300,490,307,30);
        pl2.setForeground(Color.WHITE);
        pl2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pl2.setVisible(t1);
        
        pl3.setBounds(300,560,307,30);
        pl3.setForeground(Color.WHITE);
        pl3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pl3.setVisible(t1);

        
        
        this.add(pb1);this.add(pb2);
        
        this.add(pt1);this.add(pt2);this.add(pt3);
        
        this.add(pl1);this.add(pl2);this.add(pl3);
        
        

        
        
    }
    public void changeav(boolean t1)
    {

       
        ba.setBounds(360,640,100,30);
        ba.setBackground(Color.blue);
        ba.setForeground(Color.white);
        ba.setOpaque(false);
        ba.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        ba.setFont(new Font("Segoe UI", Font.BOLD, 18));
        ba.setVisible(t1);
        
        a1a.setBounds(50, 410, 110, 110);
        a1a.setVisible(t1);
        a2a.setBounds(170, 410, 110, 110);
        a2a.setVisible(t1);
        a3a.setBounds(285, 410, 110, 110);
        a3a.setVisible(t1);
        a4a.setBounds(400, 410, 110, 110);
        a4a.setVisible(t1);
        a5a.setBounds(515, 410, 110, 110);
        a5a.setVisible(t1);
        a6a.setBounds(630, 410, 110, 110);
        a6a.setVisible(t1);
        a7a.setBounds(105, 515, 110, 110);
        a7a.setVisible(t1);
        a8a.setBounds(225, 515, 110, 110);
        a8a.setVisible(t1);
        a9a.setBounds(340, 515, 110, 110);
        a9a.setVisible(t1);
        a10a.setBounds(455, 515, 110, 110);
        a10a.setVisible(t1);
        a11a.setBounds(570, 515, 110, 110);
        a11a.setVisible(t1);
        
        a1a.setOpaque(false);
        a2a.setOpaque(false);
        a3a.setOpaque(false);
        a4a.setOpaque(false);
        a5a.setOpaque(false);
        a6a.setOpaque(false);
        a7a.setOpaque(false);
        a8a.setOpaque(false);
        a9a.setOpaque(false);
        a10a.setOpaque(false);
        a11a.setOpaque(false);
        
        G.add(a1a);G.add(a2a);G.add(a3a);G.add(a4a);G.add(a5a);G.add(a6a);G.add(a7a);G.add(a8a);
        G.add(a10a);G.add(a9a);G.add(a11a);
        
        this.add(a1a);this.add(a2a);this.add(a3a);this.add(a4a);this.add(a5a);this.add(a6a);this.add(a7a);this.add(a8a);
        this.add(a10a);this.add(a9a);this.add(a11a);
        
        this.add(ba);
        
        

        
    }
    public void securiry(boolean t1,boolean t2)
    {
        //verif pass
        sb0.setBounds(360,640,100,30);
        sb0.setBackground(Color.blue);
        sb0.setForeground(Color.white);
        sb0.setOpaque(false);
        sb0.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        sb0.setVisible(t2);
        sb0.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        st0.setBounds(300,500,225,30);
        st0.setOpaque(false);
        st0.setForeground(Color.white);
        st0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        st0.setVisible(t2);

        sl0.setBounds(300,450,307,40);
        sl0.setForeground(Color.WHITE);
        sl0.setFont(new Font("Segoe UI", Font.BOLD, 14));
        sl0.setVisible(t2);
        
        //quation
        
        sb1.setBounds(360,640,100,30);
        sb1.setBackground(Color.blue);
        sb1.setForeground(Color.white);
        sb1.setOpaque(false);
        sb1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        sb1.setVisible(t1);
        sb1.setFont(new Font("Segoe UI", Font.BOLD, 18));
       
        
        cc1.setBounds(100,480,250,50);
        cc1.setForeground((Color.white));
        cc1.setBackground(Color.darkGray);
        cc1.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        cc1.setVisible(t1);
        
        
        cc2.setBounds(450,480,250,50);
        cc2.setForeground((Color.white));
        cc2.setBackground(Color.darkGray);
        cc2.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        cc2.setVisible(t1);
        
        st1.setBounds(100,560,250,30);
        st1.setVisible(t1);
        st1.setOpaque(false);
        st1.setForeground(Color.white);
        st1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        
        st2.setBounds(450,560,250,30);
        st2.setVisible(t1);
        st2.setOpaque(false);
        st2.setForeground(Color.white);
        st2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.WHITE));
        
        sl1.setBounds(100,450,307,30);
        sl1.setForeground(Color.WHITE);
        sl1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        sl1.setVisible(t1);
        
        sl2.setBounds(100,530,307,30);
        sl2.setForeground(Color.WHITE);
        sl2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        sl2.setVisible(t1);
        
        sl3.setBounds(450,450,307,30);
        sl3.setForeground(Color.WHITE);
        sl3.setVisible(t1);
        sl3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        sl4.setBounds(450,530,307,30);
        sl4.setVisible(t1);
        sl4.setForeground(Color.WHITE);
        sl4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        
        this.add(sb0);this.add(sb1);
        
        this.add(cc1);this.add(cc2);
        
        this.add(st0);this.add(st1);this.add(st2);
        
        this.add(sl0);this.add(sl1);this.add(sl2);this.add(sl3);this.add(sl4);
    }

    public void photo ()
    {
        connection();
        try
        {
            ResultSet resultSet = statement.executeQuery("select ID,path from users where nom = '"+user+"'");
            while(resultSet.next())
            {
                path = resultSet.getString("path");
                avv=path;
                ID = resultSet.getString("ID");
            }
        }
        catch(Exception e)
        {
        }
                           
        ImageIcon ii = new ImageIcon("image\\creat new\\avatar\\avatars\\"+path);
        L5 = new JLabel(ii);
        L5.setBounds(110 ,45, 100, 100);
        
        L1.setBounds(140 ,170, 100, 30);
        L1.setForeground(Color.lightGray);
        L1.setFont(new Font("Segoe UI", Font.HANGING_BASELINE, 20));

        L2=new JLabel(user);
        L2.setBounds(120 ,200, 300, 30);
        L2.setForeground(Color.white);
        L2.setFont(new Font("Segoe UI", Font.HANGING_BASELINE, 22));
        
        this.add(L5);this.add(L1);this.add(L2);
        
    }
    public void profile(int g,int f,int o)
    {
        setSize(1105, 750);
        setOpaque(false);
        setLayout(null);
        
        changeuser(false);
        changepass(false);
        changeav(false);
        securiry(false,false);
        photo();
        
        cc1.add("What is your father name?");
        cc1.add("What is your mather name?");
        cc1.add("What is your first school name?");
        cc1.add("Where are you borne?");
        cc1.add("What is your pet name?");
        cc1.add("What is the first film you watched?");
        
        cc2.add("What is your father name?");
        cc2.add("What is your mather name?");
        cc2.add("What is your first school name?");
        cc2.add("Where are you borne?");
        cc2.add("What is your pet name?");
        cc2.add("What is the first film you watched?");
        
        userc.setOpaque(false);
        userc.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        userc.setForeground(Color.black);
        userc.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        
        
        passc.setOpaque(false);
        passc.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        passc.setForeground(Color.black);
        passc.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        
        
        imgc.setOpaque(false);
        imgc.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        imgc.setForeground(Color.black);
        imgc.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        
        sec.setOpaque(false);
        sec.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
        sec.setForeground(Color.black);
        sec.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        
        userc.setBounds(30, 365, 170, 40);
        passc.setBounds(210, 365, 170, 40);
        imgc.setBounds(390, 365, 170, 40);
        sec.setBounds(570, 365, 170, 40);
        
        l1.setBounds(770,385, 300, 300);
        
        l2.setBounds(330,10, 200, 40);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        
        l3.setBounds(395,250, 100, 60);
        
        l4.setBounds(655,250, 100, 60);
        
        l5.setBounds(905,250, 100, 60);

        
        
        G1.add(userc);G1.add(passc);G1.add(imgc);G1.add(sec);
        
        this.add(userc);this.add(passc);this.add(imgc);this.add(sec);
        
        this.add(l1);this.add(l2);this.add(l3);this.add(l4);this.add(l5);
        
        
        
        animation1(g);
        animation2(f);
        animation3(o);
        
        userc.addItemListener(I);
        passc.addItemListener(I);
        imgc.addItemListener(I);
        sec.addItemListener(I);
        
        a1a.addItemListener(I);
        a2a.addItemListener(I);
        a3a.addItemListener(I);
        a4a.addItemListener(I);
        a5a.addItemListener(I);
        a6a.addItemListener(I);
        a7a.addItemListener(I);
        a8a.addItemListener(I);
        a9a.addItemListener(I);
        a10a.addItemListener(I);
        a11a.addItemListener(I);
 
        userc.addMouseListener(cc);
        passc.addMouseListener(cc);
        imgc.addMouseListener(cc);
        sec.addMouseListener(cc);
        a1a.addMouseListener(cc);
        a2a.addMouseListener(cc);
        a3a.addMouseListener(cc);
        a4a.addMouseListener(cc);
        a5a.addMouseListener(cc);
        a6a.addMouseListener(cc);
        a7a.addMouseListener(cc);
        a8a.addMouseListener(cc);
        a9a.addMouseListener(cc);
        a10a.addMouseListener(cc);
        a11a.addMouseListener(cc);
        
        ub1.addActionListener(ac);
        pb1.addActionListener(ac);
        pb2.addActionListener(ac);
        ba.addActionListener(ac);
        sb0.addActionListener(ac);
        sb1.addActionListener(ac);
    }
    public class celect implements MouseListener
    {
        public void mouseClicked(MouseEvent e) 
        {
            
            
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
            if(e.getSource()==userc)
            {
                over=true;
                x=userc.getX();
                y=userc.getY();
                xw=userc.getWidth();
                yh=userc.getHeight();
            }
            if(e.getSource()==passc)
            {
                over=true;
                x=passc.getX();
                y=passc.getY();
                xw=passc.getWidth();
                yh=passc.getHeight();
            }
            if(e.getSource()==imgc)
            {
                over=true;
                x=imgc.getX();
                y=imgc.getY();
                xw=imgc.getWidth();
                yh=imgc.getHeight();
            }
             if(e.getSource()==sec)
            {
                over=true;
                x=sec.getX();
                y=sec.getY();
                xw=sec.getWidth();
                yh=sec.getHeight();
            }
            if(e.getSource()==a1a)
                    {
                      
                        overAV=true;
                        xo=a1a.getX();
                        yo=a1a.getY();
                        xow=a1a.getWidth();
                        yoh=a1a.getHeight();
                    }
                    if(e.getSource()==a2a)
                    {
                        overAV=true;
                        xo=a2a.getX();
                        yo=a2a.getY();
                        xow=a2a.getWidth();
                        yoh=a2a.getHeight();
                    }
                    if(e.getSource()==a3a)
                    {
                        overAV=true;
                        xo=a3a.getX();
                        yo=a3a.getY();  
                        xow=a3a.getWidth();
                        yoh=a3a.getHeight();
                    }
                    if(e.getSource()==a4a)
                    {
                        overAV=true;
                        xo=a4a.getX();
                        yo=a4a.getY();    
                        xow=a4a.getWidth();
                        yoh=a4a.getHeight();
                    }
                    if(e.getSource()==a5a)
                    {
                       overAV=true;
                        xo=a5a.getX();
                        yo=a5a.getY();   
                        xow=a5a.getWidth();
                        yoh=a5a.getHeight();
                    }
                    if(e.getSource()==a6a)
                    {
                        overAV=true;
                        xo=a6a.getX();
                        yo=a6a.getY();    
                        xow=a6a.getWidth();
                        yoh=a6a.getHeight();
                    }
                    if(e.getSource()==a7a)
                    {
                        overAV=true;
                        xo=a7a.getX();
                        yo=a7a.getY();    
                        xow=a7a.getWidth();
                        yoh=a7a.getHeight();
                    }
                    if(e.getSource()==a8a)
                    {
                        overAV=true;
                        xo=a8a.getX();
                        yo=a8a.getY();    
                        xow=a8a.getWidth();
                        yoh=a8a.getHeight();
                    }
                    if(e.getSource()==a9a)
                    {
                        overAV=true;
                        xo=a9a.getX();
                        yo=a9a.getY();   
                        xow=a9a.getWidth();
                        yoh=a9a.getHeight();
                    }
                    if(e.getSource()==a10a)
                    {
                        overAV=true;
                        xo=a10a.getX();
                        yo=a10a.getY();   
                        xow=a10a.getWidth();
                        yoh=a10a.getHeight();
                    }
                    if(e.getSource()==a11a)
                    {
                        overAV=true;
                        xo=a11a.getX();
                        yo=a11a.getY();    
                        xow=a11a.getWidth();
                        yoh=a11a.getHeight();
                    }

        }
        @Override
        public void mouseExited(MouseEvent e)
        {
            if(e.getSource()==userc)
            {
                over=false;
            }
            if(e.getSource()==passc)
            {
                over=false;
            }
            if(e.getSource()==imgc)
            {
                over=false;
            }
            if(e.getSource()==sec)
            {
                over=false;
            }
            if(a1a.isSelected())
                    {
                      
                        overAV=false;                   
                    }
                    if(a2a.isSelected())
                    {
                        overAV=false;     
                    }
                    if(a3a.isSelected())
                    {
                        overAV=false;     
                    }
                    if(a4a.isSelected())
                    {
                        overAV=false;    
                    }
                    if(a5a.isSelected())
                    {
                       overAV=false;    
                    }
                    if(a6a.isSelected())
                    {
                        overAV=false;    
                    }
                    if(a7a.isSelected())
                    {
                        overAV=false;  
                    }
                    if(a8a.isSelected())
                    {
                        overAV=false;    
                    }
                    if(a9a.isSelected())
                    {
                        overAV=false;    
                    }
                    if(a10a.isSelected())
                    {
                        overAV=false;     
                    }
                    if(a11a.isSelected())
                    {
                        overAV=false;   
                    }
        }
            
        
    }
    private class item implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e) 
        {
            if(userc.isSelected()) 
            {
                userc.setIcon(toolwhite);
                userc.setForeground(Color.white);
                over=false;
                selected=true;
                changeuser(true);
            }
            else
            {
                userc.setIcon(toolblack);
                userc.setForeground(Color.black);
                changeuser(false);
            }
            if(passc.isSelected()) 
            {
                passc.setIcon(toolwhite);
                passc.setForeground(Color.white);
                over=false;
                selected=true;
                changepass(true);
            }
            else
            {
                passc.setIcon(toolblack);
                passc.setForeground(Color.black);
                changepass(false);
            }
            if(imgc.isSelected()) 
            {
                imgc.setIcon(toolwhite);
                imgc.setForeground(Color.white);
                over=false;
                selected=true;
                changeav(true);
            }
            else
            {
                imgc.setIcon(toolblack);
                imgc.setForeground(Color.black);
                changeav(false);
            }
            if(sec.isSelected()) 
            {
                sec.setIcon(toolwhite);
                sec.setForeground(Color.white);
                over=false;
                selected=true;
                securiry(false,true);
            }
            else
            {
                sec.setIcon(toolblack);
                sec.setForeground(Color.black);
                securiry(false,false);
            }
                    if(a1a.isSelected())
                    {
                      
                        avv="1.png";                   
                    }
                    if(a2a.isSelected())
                    {
                        avv="2.png";   
                    }
                    if(a3a.isSelected())
                    {
                        avv="4.png";   
                    }
                    if(a4a.isSelected())
                    {
                        avv="6.png";   
                    }
                    if(a5a.isSelected())
                    {
                       avv="7.png";   
                    }
                    if(a6a.isSelected())
                    {
                        avv="8.png";   
                    }
                    if(a7a.isSelected())
                    {
                        avv="10.png";   
                    }
                    if(a8a.isSelected())
                    {
                        avv="11.png";   
                    }
                    if(a9a.isSelected())
                    {
                        avv="12.png";   
                    }
                    if(a10a.isSelected())
                    {
                        avv="15.png";   
                    }
                    if(a11a.isSelected())
                    {
                        avv="16.png";   
                    }

        }
    }
    
    private class ball implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(selected)
            {
                if (indx2<280)
                {
                    deference2=29;   
                }
                else
                {
                    deference2=0;       
                }
            }
            
            indx2+=deference2;
            repaint();

        }
    }
    protected void paintComponent(Graphics grphcs) 
    {
        Graphics2D G1 = (Graphics2D) grphcs;
        G1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint g1 = new GradientPaint(0, 0, Color.decode("#493240"), 0, getHeight(), Color.decode("#FF0099"));
        G1.setPaint(g1);
        G1.fillRoundRect(10 ,10, 300, 335, 25, 25);
        G1.fillRoundRect(320 ,10, 760, 335, 25, 25);
        G1.fillRoundRect(10 ,355, 1070, 350, 25, 25);

        
        G1.setColor(Color.white);
        G1.fillOval(105 ,40, 110, 110);
        
       
        
        tt.start();
        
        GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#E100FF"), 0, getHeight(), Color.decode("#7F00FF"));//google
        G1.setPaint(g3);
        
        if(indx2 >40)
        {
            G1.fillRoundRect(15 ,405, 750, indx2, 25, 25);
            G1.setColor(Color.blue);
            G1.fillRoundRect(360 ,350+indx2, 100, 40, 25, 25);
        }
        G1.setColor(Color.GRAY);
        G1.fillRoundRect(350,70, 200,250 , 25, 25);
        G1.fillRoundRect(600,70, 200,250 , 25, 25);
        G1.fillRoundRect(850,70, 200,250 , 25, 25);
        G1.setColor(new Color(255, 220, 189, 242));
        
        G1.fillRoundRect(360,250, 180,60 , 25, 25);
        G1.fillRoundRect(610,250, 180,60 , 25, 25);
        G1.fillRoundRect(860,250, 180,60 , 25, 25);

        G1.fillRoundRect(30,365, 170,40 , 25, 25);
        G1.fillRoundRect(210 ,365,170 , 40, 25, 25);
        G1.fillRoundRect(390 ,365, 170,40, 25, 25);
        G1.fillRoundRect(570, 365, 170, 40, 25, 25);
                    
        if(sec.isSelected())
        {
            G1.setPaint(g3);
            G1.fillRoundRect(570,365, 170,40 , 25, 25);
        }
        if(userc.isSelected())
        {
            G1.setPaint(g3);
            G1.fillRoundRect(30,365, 170,40 , 25, 25);
        }
        if(passc.isSelected())
        {
            G1.setPaint(g3);
            
            G1.fillRoundRect(210 ,365,170 , 40, 25, 25);
        }
        if(imgc.isSelected())
        {
            G1.setPaint(g3);
            G1.fillRoundRect(390 ,365, 170,40, 25, 25);
            G1.setColor(Color.white);
            G1.fillOval(50, 410, 110, 110);
            G1.fillOval(170, 410, 110, 110);
            G1.fillOval(285, 410, 110, 110);
            G1.fillOval(400, 410, 110, 110);
            G1.fillOval(515, 410, 110, 110);
            G1.fillOval(630, 410, 110, 110);
            
            G1.fillOval(105, 515, 110, 110);
            G1.fillOval(225, 515, 110, 110);
            G1.fillOval(340, 515, 110, 110);
            G1.fillOval(455, 515, 110, 110);
            G1.fillOval(570, 515, 110, 110);
            
            
        }
        GradientPaint g4 = new GradientPaint(0, 0, Color.decode("#F27121"), 0, getHeight(), Color.decode("#E94057"));//google
            G1.setPaint(g4);

        if(over)
        {
            G1.setColor(new Color(193, 117, 214, 255));
            G1.fillRoundRect(x,y,xw,yh, 15, 15);
        }
        
        if(imgc.isSelected())
        {
            if(overAV)
            {
                G1.setColor(new Color(193, 117, 214, 255));
                G1.fillOval(xo,yo,xow,yoh);
            }
            if(a1a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a1a.getX(),a1a.getY(),120,120);
            }
            if(a2a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a2a.getX(),a2a.getY(),120,120);
            }
            if(a3a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a3a.getX(),a3a.getY(),120,120);
            }
            if(a4a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a4a.getX(),a4a.getY(),120,120);
            }
            if(a5a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a5a.getX(),a5a.getY(),120,120);
            }
            if(a6a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a6a.getX(),a6a.getY(),120,120);
            }if(a7a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a7a.getX(),a7a.getY(),120,120);
            }if(a8a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a8a.getX(),a8a.getY(),120,120);
            }if(a9a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a9a.getX(),a9a.getY(),120,120);
            }
            if(a10a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a10a.getX(),a10a.getY(),120,120);
            }
            if(a11a.isSelected())
            {
                G1.setColor(Color.CYAN);
                G1.fillOval(a11a.getX(),a11a.getY(),120,120);
            }
            
        }
        
        
        
        
        
        
        super.paintChildren(grphcs);
    
    }
    private class action implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            //username
            if(e.getSource()==ub1) 
            {
                        String LL2=ut1.getText().toString();
                        try 
                        {

                            connection();
                            //read
                            ResultSet resultSet = statement.executeQuery("select * from users where nom = '"+LL2+"'");
                            while(resultSet.next())
                            {
                                String nom = resultSet.getString("nom");
                                user1=nom;
                            }
                        }
                        catch (Exception ex) 
                        {


                        }
                        
                        if(LL2.equals(user))
                        {
                             JOptionPane.showMessageDialog(null,"this is the same name");
                        }
                        else if(LL2.equals(user1) )
                        {
                            JOptionPane.showMessageDialog(null,"username is already existe \nchouse an ather");
                        }
                        else if(LL2.length()==0)
                        {    
                             JOptionPane.showMessageDialog(null,"empti name?");     
                        }
                        else if(LL2.length()>12)
                        {    
                             JOptionPane.showMessageDialog(null,"username very lenge\ntry again");     
                        }
                        else 
                        {   

                            
                            
                            try 
                            {
                                connection();
                                String sql1="UPDATE `users` SET `nom`='"+LL2+"' where `ID` = '"+ID+"'";
                                statement.executeUpdate(sql1);
                                String sql2="UPDATE `facebook` SET `nom`='"+LL2+"' where `ID` = '"+ID+"'";
                                statement.executeUpdate(sql2);
                                String sql3="UPDATE `google` SET `nom`='"+LL2+"' where `ID` = '"+ID+"'";
                                statement.executeUpdate(sql3);
                                String sql4="UPDATE `other` SET `nom`='"+LL2+"' where `ID` = '"+ID+"'";
                                statement.executeUpdate(sql4);                                
                            }
                            catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }

                            user = LL2;
                            L2.setText(user);
                            ut1.setText("");
                            
                            
                     }
                
            }
            
            //password
            if(e.getSource()==pb1) 
            {
                

                        String LL1=pt1.getText();
                        String LL2=pt2.getText();
                        String LL3=pt3.getText();

                        if(LL1.equals(password) )
                        {
                            if(LL2.equals(LL3))
                            {   
                                if(LL2.length()==0)
                                {
                                    JOptionPane.showMessageDialog(null,"new password impti\ncreat again");
                                }
                                else if(LL2.length()<8 )
                                {
                                    JOptionPane.showMessageDialog(null,"the new password must contain at least 8 characters \ncreat again");
                                }
                                else
                                {

                                    try 
                                    {
                                        Base64.Encoder encod = Base64.getEncoder();
                                        //coder pass
                                        String password2 = encod.encodeToString(LL2.getBytes());
                                        connection();
                                        String sql1="UPDATE `users` SET `password`='"+password2+"' where `ID` = '"+ID+"'";
                                        statement.executeUpdate(sql1);
                                        password = LL2;
                                        JOptionPane.showMessageDialog(null, "change succesful");
                                       
                                        pt1.setText("");
                                        pt2.setText("");
                                        pt3.setText("");
                                        
                                    }
                                    catch (Exception ex) 
                                    {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"password incompatible\ncreat again");
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"old password incorrect");
                        }

                    
            }
            
            //avatar
            if(e.getSource()==ba) 
            {
                         try 
                        {
                                     
                            connection();
                            String sql1="UPDATE `users` SET `path`='"+avv+"' where `ID` = '"+ID+"'";
                            statement.executeUpdate(sql1);
                        }
                        catch (Exception ex) 
                        {
                            ex.printStackTrace();
                        }
                        L5.setVisible(false);
                        photo();                        
            }
            
            //forgett pass
            if(e.getSource()==pb2) 
            {            
            graph.C_Help_fram h= new graph.C_Help_fram();
            h.help();
            }
            //sec quation
            if(e.getSource()==sb0) 
            {            
                String l1=st0.getText().toString();
                if(l1.equals(password))
                {
                    securiry(true, false);
                }
                else
                    JOptionPane.showMessageDialog(null, "wronge password");
            }
            if(e.getSource()==sb1)
            {
                String R1=cc1.getSelectedItem();
                String R2=st1.getText().toString();
                String R3=cc2.getSelectedItem();
                String R4=st2.getText().toString();
               
                            String RR1 = encod.encodeToString(R1.getBytes());
                            String RR2 = encod.encodeToString(R2.getBytes());
                            String RR3 = encod.encodeToString(R3.getBytes());
                            String RR4 = encod.encodeToString(R4.getBytes());
                
                                    try 
                                    {      
                                        connection();
                                        String sql1="UPDATE `users` SET `Q1`='"+RR1+"', `EN1`='"+RR2+"', `Q2`='"+RR3+"', `EN2`='"+RR4+"' where `ID` ="+ID+";";
                                        statement.executeUpdate(sql1); 
                                        JOptionPane.showMessageDialog(null, "change succesful");
                                        st1.setText("");
                                        st2.setText("");
                                        App_panel a = new App_panel(user, password, ID);
                                    }
                                    catch (Exception ex) 
                                    {
                                        ex.printStackTrace();
                                    }
            }
        }
    }
}
