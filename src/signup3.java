import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener {
    String formnum;
    JRadioButton savingacc;
    JRadioButton currentacc;
    JRadioButton fixedacc;
    JRadioButton recurracc;

    JCheckBox ATM;
    JCheckBox chequebook;
    JCheckBox passbook;
    JCheckBox sms_onlineser;
    JCheckBox netbank;
    JCheckBox declare;

    JButton register;
    JButton cancel;
    signup3(String formno){
        this.formnum = formno;
        setLayout(null);
        setVisible(true);
        setBounds(450, 70, 600, 700);
        setTitle("Registration Form");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        l.setBounds(40, 35, 100, 100);
        add(l);
        getContentPane().setBackground(Color.white);
        setIconImage(i1.getImage());

        JLabel addaccdet = new JLabel("Step 3 : Account Details");
        add(addaccdet);
        addaccdet.setFont(new Font("Arial", Font.BOLD, 30));
        addaccdet.setBounds(170, 55, 400, 70);

        JLabel additi2 = new JLabel("_______________________________");
        add(additi2);
        additi2.setBounds(170, 90, 400, 30);
        additi2.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel accty = new JLabel("Account Type :");
        add(accty);
        accty.setBounds(70, 180, 150, 30);
        accty.setFont(new Font("Arial", Font.BOLD, 20));

        savingacc = new JRadioButton("Savings Account");
        add(savingacc);
        savingacc.setBounds(230, 185, 150, 20);
        savingacc.setBackground(Color.white);

        currentacc = new JRadioButton("Current Account");
        add(currentacc);
        currentacc.setBounds(390, 185, 150, 20);
        currentacc.setBackground(Color.white);

        fixedacc = new JRadioButton("Fixed Deposit");
        add(fixedacc);
        fixedacc.setBounds(230, 210, 150, 20);
        fixedacc.setBackground(Color.white);

        recurracc = new JRadioButton("Recurring Deposit");
        add(recurracc);
        recurracc.setBounds(390, 210, 150, 20);
        recurracc.setBackground(Color.white);

        ButtonGroup bg = new ButtonGroup();
        bg.add(savingacc);
        bg.add(currentacc);
        bg.add(fixedacc);
        bg.add(recurracc);

        JLabel cardno = new JLabel("Card Number :");
        add(cardno);
        cardno.setBounds(70, 250, 150, 30);
        cardno.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel additi = new JLabel("(Your 16 digit card number)");
        add(additi);
        additi.setBounds(70, 270, 300, 30);
        additi.setFont(new Font("Arial", Font.BOLD, 10));

        JLabel cn = new JLabel("XXXX-XXXX-XXXX-XXXX");
        add(cn);
        cn.setFont(new Font("Arial", Font.BOLD, 20));
        cn.setBounds(230, 260, 300, 20);

        JLabel pinno = new JLabel("Pin No :");
        add(pinno);
        pinno.setBounds(70, 310, 150, 30);
        pinno.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel additi1 = new JLabel("(Your 4 digit Password)");
        add(additi1);
        additi1.setBounds(70, 330, 300, 30);
        additi1.setFont(new Font("Arial", Font.BOLD, 10));

        JLabel pn = new JLabel("XXXX");
        add(pn);
        pn.setFont(new Font("Arial", Font.BOLD, 20));
        pn.setBounds(230, 320, 300, 20);

        JLabel servicesre = new JLabel("Services Required : ");
        add(servicesre);
        servicesre.setBounds(70, 370, 200, 30);
        servicesre.setFont(new Font("Arial", Font.BOLD, 20));

        ATM = new JCheckBox("ATM Card");
        add(ATM);
        ATM.setBounds(70, 415, 150, 20);
        ATM.setBackground(Color.white);

        netbank = new JCheckBox("Net Banking");
        add(netbank);
        netbank.setBounds(230, 415, 150, 20);
        netbank.setBackground(Color.white);

        sms_onlineser = new JCheckBox("SMS / EMAIL Alerts");
        add(sms_onlineser);
        sms_onlineser.setBounds(390, 415, 150, 20);
        sms_onlineser.setBackground(Color.white);

        passbook = new JCheckBox("PassBook");
        add(passbook);
        passbook.setBounds(70, 440, 150, 20);
        passbook.setBackground(Color.white);

        chequebook = new JCheckBox("Chequebook");
        add(chequebook);
        chequebook.setBounds(230, 440, 150, 20);
        chequebook.setBackground(Color.white);

        JLabel note = new JLabel("Note : Above services may apply Annual charges !");
        add(note);
        note.setBounds(75, 465, 300, 20);
        note.setFont(new Font("Arial", Font.BOLD, 10));

        declare = new JCheckBox("I hereby declare that above given information is true to the best of my knowledge.");
        add(declare);
        declare.setBounds(60, 510, 500, 20);
        declare.setFont(new Font("Arial", Font.BOLD, 12));
        declare.setBackground(Color.white);

        cancel = new JButton("Cancel");
        add(cancel);
        cancel.addActionListener(this);
        cancel.setBounds(210, 560, 80, 20);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);

        register = new JButton("Submit");
        add(register);
        register.addActionListener(this);
        register.setBounds(310, 560, 80, 20);
        register.setBackground(Color.black);
        register.setForeground(Color.white);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == register){
            String accounttype = "";
            if(savingacc.isSelected()){
                accounttype = "Savings Account";
            }else if(currentacc.isSelected()){
                accounttype = "Current Account";
            }else if(fixedacc.isSelected()){
                accounttype = "Fixed Deposit Account";
            }else{
                accounttype = "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardn = "" + Math.abs(random.nextLong() % 90000000L + 5410342800000000L);
            String pinn = "" + Math.abs(random.nextLong() % 9000L + 1000L);
            String servicesrequired = "";
            if(ATM.isSelected()){
                servicesrequired += " ATM,";
            }
            if(netbank.isSelected()){
                servicesrequired += " Net Banking,";
            }
            if(chequebook.isSelected()){
                servicesrequired += " checquebook,";
            }
            if(sms_onlineser.isSelected()){
                servicesrequired += " SMS & EMAIL Alerts,";
            }
            if(passbook.isSelected()){
                servicesrequired += " passbook";
            }
            try {
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "Please select account type");
                }else if(!declare.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please declare");
                }else{
                    JOptionPane.showMessageDialog(null, "your card number :" +cardn+"\n your pin number : "+pinn);
                    Connect c = new Connect();
                    String q1 = "insert into signupthree values('"+formnum+"', '"+accounttype+"', '"+cardn+"', '"+pinn+"', '"+servicesrequired+"');";
                    String q2 = "insert into login values('"+formnum+"', '"+cardn+"', '"+pinn+"');";
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    String q3 = "insert into totalcash values('"+pinn+"', '500');";
                    c.s.executeUpdate(q3);
                    setVisible(false);
                    new Login().setVisible(true);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            int n = JOptionPane.showConfirmDialog(null, "Do you really want to cancel ?", "Warning", JOptionPane.YES_NO_OPTION);
            if(n == 0){ // n == 0 means you have chosen yes to exit in option dialogue box
                Connect c = new Connect();
                String q1 = "delete from signuptwo where formno = '"+formnum+"';";
                String q2 = "delete from signup where formno = '"+formnum+"';";
                try {
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                }catch (Exception ex){
                    System.out.println(ex);
                }
                setVisible(false);
                new Login().setVisible(true);
            }
        }
    }
    public static void main(String[] args) {
        new signup3("");
    }
}
