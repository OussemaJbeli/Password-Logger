
package javafr;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class App_Frame_logout extends JFrame
{
    String user,password,ID;
    public void frame(String u,String p,String d)
    {
        this.user=u;
        this.password=p;
        this.ID=d;
        setIconImage();
        App_panel_Logout Dp = new App_panel_Logout(user,password,ID);
        Dp.logout();
        setSize(1020, 595);
        setTitle("Password Logger");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        this.add(Dp);
        
    }
    private void setIconImage() 
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PasswordRecorder_logo.png")));
    }
}
