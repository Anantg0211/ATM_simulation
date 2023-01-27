import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener {
    String pin;
    JTextField amount;
    JButton okay;
    JButton cancel;
    withdrawl(String pin){
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

        JLabel l1 = new JLabel("Enter the amount you want to withdraw : ");
        l.add(l1);
        l1.setBounds(170, 300, 400, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 17));
        l1.setForeground(Color.lightGray);

        JLabel l2 = new JLabel("Rs : ");
        l.add(l2);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setBounds(230, 340, 50, 20);
        l2.setForeground(Color.lightGray);

        amount = new JTextField();
        l.add(amount);
        amount.setOpaque(false);
        amount.setFont(new Font("Arial", Font.BOLD, 20));
        amount.setBounds(280, 340, 150, 20);
        amount.setForeground(Color.lightGray);

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

        okay = new JButton(">");
        l.add(okay);
        okay.addActionListener(this);
        okay.setBounds(90, 417, 55, 30);
        okay.setFont(new Font("Arial", Font.BOLD, 20));
        okay.setForeground(Color.black);
        okay.setBackground(Color.white);

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
            new Login().setVisible(true);
        }else{
            String am = amount.getText();
            Date d = new Date();
            Connect c = new Connect();
            if(am.equals("")){
                JOptionPane.showMessageDialog(null, "please enter the amount");
            }else{
                try {
                    String q1 = "select amount from totalcash where pin = '"+pin+"';";
                    String prevamount = "";
                    ResultSet rs = c.s.executeQuery(q1);
                    while(rs.next()){
                        prevamount = rs.getString(2);
                    }
                    if(Integer.parseInt(am) > Integer.parseInt(prevamount)){
                        JOptionPane.showMessageDialog(null, "not have enough credit");
                    }else{
                        String q = "insert into transactions values('"+pin+"', '"+d+"', 'withdrawl', '"+am+"');";
                        c.s.executeUpdate(q);
                        int t1 = Integer.parseInt(prevamount);
                        int t2 = Integer.parseInt(am);
                        int total = t1-t2;
                        String totalamo = Integer.toString(total);
                        String q3 = "update totalcash set amount = '"+totalamo+"' where pin = '"+pin+"';";
                        c.s.executeUpdate(q3);
                        JOptionPane.showMessageDialog(null, "Withdrawal done successfully");
                        setVisible(false);
                        new Login().setVisible(true);
                    }
                }catch (Exception ex){
                    System.out.println(ex);
                }
            }
        }
    }
    public static void main(String[] args) {
        new withdrawl("");
    }
}
