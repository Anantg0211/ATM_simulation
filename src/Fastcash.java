import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    String pin;
    JButton hundred;
    JButton fiveh;
    JButton thousand;
    JButton twothous;
    JButton fivethous;
    JButton tenthous;
    JButton cancel;
    Fastcash(String pin){
        this.pin = pin;
        setLayout(null);
        setBounds(300, 0, 900, 900);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        add(l);
        l.setBounds(0, 0, 900, 900);

        JLabel amount = new JLabel("Select the amount :");
        l.add(amount);
        amount.setBounds(220, 300, 300, 30);
        amount.setFont(new Font("Arial", Font.BOLD, 25));
        amount.setForeground(Color.LIGHT_GRAY);

        JLabel hund = new JLabel("Rs 100");
        l.add(hund);
        hund.setBounds(160, 420, 142, 25);
        hund.setFont(new Font("Arial", Font.BOLD, 18));
        hund.setForeground(Color.white);

        hundred = new JButton(">");
        l.add(hundred);
        hundred.addActionListener(this);
        hundred.setBounds(90, 417, 55, 30);
        hundred.setFont(new Font("Arial", Font.BOLD, 20));
        hundred.setForeground(Color.black);
        hundred.setBackground(Color.white);

        JLabel fivehund = new JLabel("Rs 500");
        l.add(fivehund);
        fivehund.setBounds(455, 420, 155, 25);
        fivehund.setFont(new Font("Arial", Font.BOLD, 18));
        fivehund.setForeground(Color.white);

        fiveh = new JButton("<");
        l.add(fiveh);
        fiveh.addActionListener(this);
        fiveh.setBounds(530, 417, 55, 30);
        fiveh.setFont(new Font("Arial", Font.BOLD, 20));
        fiveh.setForeground(Color.black);
        fiveh.setBackground(Color.white);

        JLabel thou = new JLabel("Rs 1,000");
        l.add(thou);
        thou.setBounds(160, 455, 142, 25);
        thou.setFont(new Font("Arial", Font.BOLD, 18));
        thou.setForeground(Color.white);

        thousand = new JButton(">");
        l.add(thousand);
        thousand.addActionListener(this);
        thousand.setBounds(90, 452, 55, 30);
        thousand.setFont(new Font("Arial", Font.BOLD, 20));
        thousand.setForeground(Color.black);
        thousand.setBackground(Color.white);

        JLabel twoth = new JLabel("Rs 2,000");
        l.add(twoth);
        twoth.setBounds(440, 455, 155, 25);
        twoth.setFont(new Font("Arial", Font.BOLD, 18));
        twoth.setForeground(Color.white);

        twothous = new JButton("<");
        l.add(twothous);
        twothous.addActionListener(this);
        twothous.setBounds(530, 452, 55, 30);
        twothous.setFont(new Font("Arial", Font.BOLD, 20));
        twothous.setForeground(Color.black);
        twothous.setBackground(Color.white);

        JLabel ft = new JLabel("Rs 5,000");
        l.add(ft);
        ft.setBounds(160, 490, 142, 25);
        ft.setFont(new Font("Arial", Font.BOLD, 18));
        ft.setForeground(Color.white);

        fivethous = new JButton(">");
        l.add(fivethous);
        fivethous.addActionListener(this);
        fivethous.setBounds(90, 487, 55, 30);
        fivethous.setFont(new Font("Arial", Font.BOLD, 20));
        fivethous.setForeground(Color.black);
        fivethous.setBackground(Color.white);

        JLabel tt = new JLabel("Rs 10,000");
        l.add(tt);
        tt.setBounds(430, 490, 155, 25);
        tt.setFont(new Font("Arial", Font.BOLD, 18));
        tt.setForeground(Color.white);

        tenthous = new JButton("<");
        l.add(tenthous);
        tenthous.addActionListener(this);
        tenthous.setBounds(530, 487, 55, 30);
        tenthous.setFont(new Font("Arial", Font.BOLD, 20));
        tenthous.setForeground(Color.black);
        tenthous.setBackground(Color.white);

        JLabel exit = new JLabel("cancel");
        l.add(exit);
        exit.setBounds(160, 525, 142, 25);
        exit.setFont(new Font("Arial", Font.BOLD, 18));
        exit.setForeground(Color.white);

        cancel = new JButton(">");
        l.add(cancel);
        cancel.addActionListener(this);
        cancel.setBounds(90, 520, 55, 30);
        cancel.setFont(new Font("Arial", Font.BOLD, 20));
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.white);

        JButton extra = new JButton("<");
        l.add(extra);
        extra.setBounds(530, 520, 55, 30);
        extra.setFont(new Font("Arial", Font.BOLD, 20));
        extra.setForeground(Color.black);
        extra.setBackground(Color.white);

        setUndecorated(true); // this function is to remove the upper control panel of frame
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        Connect c = new Connect();
        Date d = new Date();
        if(ae.getSource() == cancel){
            setVisible(false);
            new transact(pin).setVisible(true);
        }else if(ae.getSource() == hundred){
            try {
                String q1 = "select amount from totalcash where pin = '"+pin+"';";
                ResultSet rs = c.s.executeQuery(q1);
                String prevam = "";
                while(rs.next()){
                    prevam = rs.getString(1);
                }
                int t1 = Integer.parseInt(prevam);
                if(t1 < 100){
                    JOptionPane.showMessageDialog(null, "your account does not have enough credit");
                }else{
                    int na = t1-100;
                    String newa = Integer.toString(na);
                    String q = "update totalcash set amount = '"+newa+"' where pin = '"+pin+"';";
                    c.s.executeUpdate(q);
                    String q2 = "insert into transactions values('"+pin+"', '"+d+"', 'withdrawal', '100');";
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "transaction successfull");
                    setVisible(false);
                    new transact(pin).setVisible(true);
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        }else if(ae.getSource() == fiveh){
            try {
                String q1 = "select amount from totalcash where pin = '"+pin+"';";
                ResultSet rs = c.s.executeQuery(q1);
                String prevam = "";
                while(rs.next()){
                    prevam = rs.getString(1);
                }
                int t1 = Integer.parseInt(prevam);
                if(t1 < 500){
                    JOptionPane.showMessageDialog(null, "your account does not have enough credit");
                }else{
                    int na = t1-500;
                    String newa = Integer.toString(na);
                    String q = "update totalcash set amount = '"+newa+"' where pin = '"+pin+"';";
                    c.s.executeUpdate(q);
                    String q2 = "insert into transactions values('"+pin+"', '"+d+"', 'withdrawal', '500');";
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "transaction successfull");
                    setVisible(false);
                    new transact(pin).setVisible(true);
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        }else if(ae.getSource() == thousand){
            try {
                String q1 = "select amount from totalcash where pin = '"+pin+"';";
                ResultSet rs = c.s.executeQuery(q1);
                String prevam = "";
                while(rs.next()){
                    prevam = rs.getString(1);
                }
                int t1 = Integer.parseInt(prevam);
                if(t1 < 1000){
                    JOptionPane.showMessageDialog(null, "your account does not have enough credit");
                }else{
                    int na = t1-1000;
                    String newa = Integer.toString(na);
                    String q = "update totalcash set amount = '"+newa+"' where pin = '"+pin+"';";
                    c.s.executeUpdate(q);
                    String q2 = "insert into transactions values('"+pin+"', '"+d+"', 'withdrawal', '1000');";
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "transaction successfull");
                    setVisible(false);
                    new transact(pin).setVisible(true);
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        }else if (ae.getSource() == twothous){
            try {
                String q1 = "select amount from totalcash where pin = '"+pin+"';";
                ResultSet rs = c.s.executeQuery(q1);
                String prevam = "";
                while(rs.next()){
                    prevam = rs.getString(1);
                }
                int t1 = Integer.parseInt(prevam);
                if(t1 < 2000){
                    JOptionPane.showMessageDialog(null, "your account does not have enough credit");
                }else{
                    int na = t1-2000;
                    String newa = Integer.toString(na);
                    String q = "update totalcash set amount = '"+newa+"' where pin = '"+pin+"';";
                    c.s.executeUpdate(q);
                    String q2 = "insert into transactions values('"+pin+"', '"+d+"', 'withdrawal', '2000');";
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "transaction successfull");
                    setVisible(false);
                    new transact(pin).setVisible(true);
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        }else if(ae.getSource() == fivethous){
            try {
                String q1 = "select amount from totalcash where pin = '"+pin+"';";
                ResultSet rs = c.s.executeQuery(q1);
                String prevam = "";
                while(rs.next()){
                    prevam = rs.getString(1);
                }
                int t1 = Integer.parseInt(prevam);
                if(t1 < 5000){
                    JOptionPane.showMessageDialog(null, "your account does not have enough credit");
                }else{
                    int na = t1-5000;
                    String newa = Integer.toString(na);
                    String q = "update totalcash set amount = '"+newa+"' where pin = '"+pin+"';";
                    c.s.executeUpdate(q);
                    String q2 = "insert into transactions values('"+pin+"', '"+d+"', 'withdrawal', '5000');";
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "transaction successfull");
                    setVisible(false);
                    new transact(pin).setVisible(true);
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        }else{
            try {
                String q1 = "select amount from totalcash where pin = '"+pin+"';";
                ResultSet rs = c.s.executeQuery(q1);
                String prevam = "";
                while(rs.next()){
                    prevam = rs.getString(1);
                }
                int t1 = Integer.parseInt(prevam);
                if(t1 < 10000){
                    JOptionPane.showMessageDialog(null, "your account does not have enough credit");
                }else{
                    int na = t1-10000;
                    String newa = Integer.toString(na);
                    String q = "update totalcash set amount = '"+newa+"' where pin = '"+pin+"';";
                    c.s.executeUpdate(q);
                    String q2 = "insert into transactions values('"+pin+"', '"+d+"', 'withdrawal', '10000');";
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "transaction successfull");
                    setVisible(false);
                    new transact(pin).setVisible(true);
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        }
    }

}
