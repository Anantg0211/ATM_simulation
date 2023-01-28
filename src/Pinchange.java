import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Pinchange extends JFrame implements ActionListener {
    String pin;
    JPasswordField newpin;
    JButton okay;
    JButton cancel;
    Pinchange(String pin){
        this.pin = pin;
        setLayout(null);
        setResizable(false); // this disable the maximize button
        setBounds(300, 0, 900, 900);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        add(l);
        l.setBounds(0, 0, 900, 900);

        JLabel l1 = new JLabel("Enter the new pin : ");
        l.add(l1);
        l1.setBounds(250, 300, 400, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 17));
        l1.setForeground(Color.lightGray);

        newpin = new JPasswordField();
        l.add(newpin);
        newpin.setOpaque(false);
        newpin.setFont(new Font("Arial", Font.BOLD, 20));
        newpin.setBounds(280, 340, 100, 20);
        newpin.setForeground(Color.lightGray);

        okay = new JButton(">");
        l.add(okay);
        okay.addActionListener(this);
        okay.setBounds(90, 417, 55, 30);
        okay.setFont(new Font("Arial", Font.BOLD, 20));
        okay.setForeground(Color.black);
        okay.setBackground(Color.white);

        JLabel okayy = new JLabel("Yes");
        l.add(okayy);
        okayy.setBounds(160, 420, 100, 20);
        okayy.setForeground(Color.white);
        okayy.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel canc = new JLabel("Cancel");
        l.add(canc);
        canc.setBounds(440, 420, 100, 20);
        canc.setForeground(Color.white);
        canc.setFont(new Font("Arial", Font.BOLD, 20));

        cancel = new JButton("<");
        l.add(cancel);
        cancel.addActionListener(this);
        cancel.setBounds(530, 417, 55, 30);
        cancel.setFont(new Font("Arial", Font.BOLD, 20));
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.white);

        JButton ex1 = new JButton(">");
        l.add(ex1);
        ex1.setBounds(90, 452, 55, 30);
        ex1.setFont(new Font("Arial", Font.BOLD, 20));
        ex1.setForeground(Color.black);
        ex1.setBackground(Color.white);

        JButton ex2 = new JButton(">");
        l.add(ex2);
        ex2.setBounds(90, 487, 55, 30);
        ex2.setFont(new Font("Arial", Font.BOLD, 20));
        ex2.setForeground(Color.black);
        ex2.setBackground(Color.white);

        JButton ex3 = new JButton("<");
        l.add(ex3);
        ex3.setBounds(530, 452, 55, 30);
        ex3.setFont(new Font("Arial", Font.BOLD, 20));
        ex3.setForeground(Color.black);
        ex3.setBackground(Color.white);

        JButton ex4 = new JButton("<");
        l.add(ex4);
        ex4.setBounds(530, 487, 55, 30);
        ex4.setFont(new Font("Arial", Font.BOLD, 20));
        ex4.setForeground(Color.black);
        ex4.setBackground(Color.white);

        JButton ex7 = new JButton(">");
        l.add(ex7);
        ex7.setBounds(90, 520, 55, 30);
        ex7.setFont(new Font("Arial", Font.BOLD, 20));
        ex7.setForeground(Color.black);
        ex7.setBackground(Color.white);

        JButton ex8 = new JButton("<");
        l.add(ex8);
        ex8.setBounds(530, 520, 55, 30);
        ex8.setFont(new Font("Arial", Font.BOLD, 20));
        ex8.setForeground(Color.black);
        ex8.setBackground(Color.white);

        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
            new transact(pin).setVisible(true);
        }else{
            Connect c = new Connect();
            String np = newpin.getText();
            Date d = new Date();
            if(np.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a valid pin");
            }else{
                try {
                    String q1 = "update login set pinnumber = '"+np+"' where pinnumber = '"+pin+"';";
                    c.s.executeUpdate(q1);
                    String q2 = "update totalcash set pin = '"+np+"' where pin = '"+pin+"';";
                    c.s.executeUpdate(q2);
                    String q3 = "update transactions set pin = '"+np+"' where pin = '"+pin+"';";
                    c.s.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null, "Your pin has been changed successfully.");
                    setVisible(false);
                    new transact(np).setVisible(true);
                }catch (Exception ex){
                    System.out.println(ex);
                }
            }
        }
    }
    public static void main(String[] args) {
        new Pinchange("");
    }
}
