
package javafr;

import java.awt.Toolkit;
import javax.swing.JFrame;


public class App_frame extends JFrame
{
    String user,password,ID;
    public void frame(String u,String p,String d)
    {
        setIconImage();
        this.user=u;
        this.password=p;
        this.ID=d;
        App_panel Dp = new App_panel(user,password,ID);
        Dp.bb();
        setSize(1305, 750);
        setTitle("Password Logger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        this.add(Dp);
        
    }
    private void setIconImage() 
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PasswordRecorder_logo.png")));
    }
    
}
