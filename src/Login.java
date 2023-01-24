import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// this is a class for creating a login page and also this is the main class
public class Login extends JFrame implements ActionListener { //here we are extending jframe to enable the function of java inbuild frame
    JButton login;
    JButton clear;
    JButton register;
    JTextField cn;
    JPasswordField pn;

    // we have created these buttons globally so that we can use them outside the constructor as we have to check their action performed on these buttons which is determined by actionperformed function
    Login(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); // here we are fetching our image from our package
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // this is a class object of awt package
        ImageIcon i3 = new ImageIcon(i2); // this imageicon is again created bcoz jlabel does not accept direct image it accepts imageicon bcoz imageicon and jlabel both are of javax swing package but Image is of awt package
        JLabel label = new JLabel(i3); // this is an object of javax swing package
        label.setBounds(70, 20, 100, 100); // this is to set image inside the frame ie from left of frame, from top of frame, width and height of frame
        setLayout(null); // this function is used to remove the default layout of the label ie default is center and there is no  use of setbounds if you do not enable setlayout null
        getContentPane().setBackground(Color.white); // this is used to background color of frame
        add(label); // this add function is used to add image to our frame
        setIconImage(i1.getImage()); // here we are creating icon of out frame
        setTitle("AUTOMATED TELLER MACHINE"); // here we are giving title to our frame
        setSize(700, 400); // here we are giving size to our frame ie 700 length and 400 height
        setVisible(true); // here we are ensuring that our frame is visible on screen
        setLocation(400, 210); // here we are ensuring dimensions ie 400 from left of the screen nd 210 from top of screen
        JLabel text = new JLabel("WELCOME TO ATM"); // this is nothing just a label or say heading
        add(text);
        text.setBounds(250, 20, 400, 100);
        text.setFont(new Font("Arial", Font.BOLD, 35)); // type of font, bold and size of font, these 3 param are passed to setfont func

        JLabel additi2 = new JLabel("_____________________________");
        add(additi2);
        additi2.setBounds(250, 70, 400, 30);
        additi2.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel cardNumber = new JLabel("Card Number : ");
        add(cardNumber);
        cardNumber.setBounds(100, 150, 200, 30);
        cardNumber.setFont(new Font("Arial", Font.BOLD, 25));

        cn = new JTextField(); // this is nothing just adding a box to write something
        add(cn);
        cn.setFont(new Font("Arial", Font.BOLD, 14));
        cn.setBounds(330, 150, 200, 30);
        cn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel Pin = new JLabel("Pin : ");
        add(Pin);
        Pin.setBounds(100, 190, 100, 30);
        Pin.setFont(new Font("Arial", Font.BOLD, 25));

        pn = new JPasswordField();
        add(pn);
        pn.setBounds(330, 190, 200, 30);
        pn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        login = new JButton("Login");
        login.addActionListener(this);
        add(login);
        login.setBounds(345, 250, 80, 20);
        login.setBackground(Color.black);
        login.setForeground(Color.white);

        clear = new JButton("Clear");
        add(clear);
        clear.addActionListener(this);
        clear.setBounds(435, 250, 80, 20);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);

        register = new JButton("Register");
        add(register);
        register.addActionListener(this);
        register.setBounds(375, 280, 100, 20);
        register.setBackground(Color.black);
        register.setForeground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String cnum = cn.getText();
            String pnum = pn.getText();
            if(cnum.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter card number");
            }else if(pnum.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter pin number");
            }else{
                try {
                    Connect c = new Connect();
                    String q = "select cardnumber from login where cardnumber = '"+ cnum+"'";
                    ResultSet rs = c.s.executeQuery(q);
                    if(rs.next()){
                        try {
                            String q1 = "select pinnumber from login where pinnumber = '"+pnum+"'";
                            ResultSet pin = c.s.executeQuery(q1);
                            if(pin.next()){
                                setVisible(false);
                                new transact(pnum).setVisible(true);
                            }else{
                                JOptionPane.showMessageDialog(null, "Invalid card or pin number");
                            }
                        }catch (Exception exx){
                            System.out.println(exx);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Card number or pin number");
                    }
                }catch (Exception ex){
                    System.out.println(ex);
                }
            }
        }else if(e.getSource() == clear){
            cn.setText("");
            pn.setText("");
        }else if(e.getSource() == register){
            setVisible(false);
            new signup1().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login(); // here we are creating new object of login class so that on executing we get a frame on screen
    }


}
