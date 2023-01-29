import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;

public class transact extends JFrame implements ActionListener {
    String pinnum;
    JButton cwithdrawl;
    JButton changepin;
    JButton minis;
    JButton cdeposit;
    JButton checkbalance;
    JButton fastc;
    JButton ex;
    transact(String pino){
        this.pinnum= pino;
        setLayout(null);
        setBounds(300, 0, 900, 900);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        add(l);
        l.setBounds(0, 0, 900, 900);

        JLabel wu = new JLabel("Welcome User !");
        l.add(wu);
        wu.setBounds(220, 300, 300, 30);
        wu.setFont(new Font("Arial", Font.BOLD, 30));
        wu.setForeground(Color.LIGHT_GRAY);

        JLabel desc = new JLabel("Please select your transaction..");
        l.add(desc);
        desc.setBounds(190, 340, 300, 30);
        desc.setFont(new Font("Arial", Font.BOLD, 20));
        desc.setForeground(Color.LIGHT_GRAY);

        JLabel withdraw = new JLabel("Cash Withdraw");
        l.add(withdraw);
        withdraw.setBounds(160, 420, 142, 25);
        withdraw.setFont(new Font("Arial", Font.BOLD, 18));
        withdraw.setForeground(Color.white);

        cwithdrawl = new JButton(">");
        l.add(cwithdrawl);
        cwithdrawl.addActionListener(this);
        cwithdrawl.setBounds(90, 417, 55, 30);
        cwithdrawl.setFont(new Font("Arial", Font.BOLD, 20));
        cwithdrawl.setForeground(Color.black);
        cwithdrawl.setBackground(Color.white);

        JLabel ministatement = new JLabel("   Mini Statement");
        l.add(ministatement);
        ministatement.setBounds(355, 420, 155, 25);
        ministatement.setFont(new Font("Arial", Font.BOLD, 18));
        ministatement.setForeground(Color.white);

        minis = new JButton("<");
        l.add(minis);
        minis.addActionListener(this);
        minis.setBounds(530, 417, 55, 30);
        minis.setFont(new Font("Arial", Font.BOLD, 20));
        minis.setForeground(Color.black);
        minis.setBackground(Color.white);

        JLabel deposit = new JLabel("Deposit");
        l.add(deposit);
        deposit.setBounds(160, 455, 142, 25);
        deposit.setFont(new Font("Arial", Font.BOLD, 18));
        deposit.setForeground(Color.white);

        cdeposit = new JButton(">");
        l.add(cdeposit);
        cdeposit.addActionListener(this);
        cdeposit.setBounds(90, 452, 55, 30);
        cdeposit.setFont(new Font("Arial", Font.BOLD, 20));
        cdeposit.setForeground(Color.black);
        cdeposit.setBackground(Color.white);

        JLabel checkb = new JLabel("Account balance");
        l.add(checkb);
        checkb.setBounds(355, 455, 155, 25);
        checkb.setFont(new Font("Arial", Font.BOLD, 18));
        checkb.setForeground(Color.white);

        checkbalance = new JButton("<");
        l.add(checkbalance);
        checkbalance.addActionListener(this);
        checkbalance.setBounds(530, 452, 55, 30);
        checkbalance.setFont(new Font("Arial", Font.BOLD, 20));
        checkbalance.setForeground(Color.black);
        checkbalance.setBackground(Color.white);

        JLabel changep = new JLabel("Change Pin");
        l.add(changep);
        changep.setBounds(160, 490, 142, 25);
        changep.setFont(new Font("Arial", Font.BOLD, 18));
        changep.setForeground(Color.white);

        changepin = new JButton(">");
        l.add(changepin);
        changepin.addActionListener(this);
        changepin.setBounds(90, 487, 55, 30);
        changepin.setFont(new Font("Arial", Font.BOLD, 20));
        changepin.setForeground(Color.black);
        changepin.setBackground(Color.white);

        JLabel fc = new JLabel("            Fast Cash");
        l.add(fc);
        fc.setBounds(355, 490, 155, 25);
        fc.setFont(new Font("Arial", Font.BOLD, 18));
        fc.setForeground(Color.white);

        fastc = new JButton("<");
        l.add(fastc);
        fastc.addActionListener(this);
        fastc.setBounds(530, 487, 55, 30);
        fastc.setFont(new Font("Arial", Font.BOLD, 20));
        fastc.setForeground(Color.black);
        fastc.setBackground(Color.white);

        JLabel exit = new JLabel("Exit");
        l.add(exit);
        exit.setBounds(160, 525, 142, 25);
        exit.setFont(new Font("Arial", Font.BOLD, 18));
        exit.setForeground(Color.white);

        ex = new JButton(">");
        l.add(ex);
        ex.addActionListener(this);
        ex.setBounds(90, 520, 55, 30);
        ex.setFont(new Font("Arial", Font.BOLD, 20));
        ex.setForeground(Color.black);
        ex.setBackground(Color.white);

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
        if(ae.getSource() == ex){
            setVisible(false);
            new Login().setVisible(true);
        }else if(ae.getSource() == cwithdrawl){
            setVisible(false);
            new withdrawl(pinnum).setVisible(true);
        }else if(ae.getSource() == changepin){
            setVisible(false);
            new Pinchange(pinnum).setVisible(true);
        }else if(ae.getSource() == minis){
            new Ministatement(pinnum).setVisible(true);
        }else if(ae.getSource() == cdeposit){
            setVisible(false);
            new Deposit(pinnum).setVisible(true);
        }else if(ae.getSource() == fastc){
            setVisible(false);
            new Fastcash(pinnum).setVisible(true);
        }else if(ae.getSource() == checkbalance){
            Connect c = new Connect();
            try {
               String s = "select amount from totalcash where pin = '"+pinnum+"';";
               ResultSet rs = c.s.executeQuery(s);
               String amount = "";
               while(rs.next()){
                   amount = rs.getString(1);
               }
               JOptionPane.showMessageDialog(null, "your remaining balance is Rs "+amount);
            }catch (Exception ex){
                System.out.println(ex);
            }
        }
    }

}
