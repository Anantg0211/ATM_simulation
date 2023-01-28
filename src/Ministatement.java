import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ministatement extends JFrame implements ActionListener {
    JButton okay ;
    Ministatement(String pin){
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setBounds(550, 200, 400, 400);

        JLabel ms = new JLabel("MINI STATEMENT !");
        add(ms);
        ms.setForeground(Color.black);
        ms.setBounds(100, 25, 300, 20);
        ms.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel pb = new JLabel("YOUR PERSONAL BANK");
        add(pb);
        pb.setForeground(Color.black);
        pb.setBounds(100, 50, 300, 20);
        pb.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel cn = new JLabel();
        add(cn);
        cn.setForeground(Color.black);
        cn.setFont(new Font("Arial", Font.BOLD, 12));
        cn.setBounds(30, 80, 300, 20);

        JLabel l =  new JLabel("S.No            Date                      Type        Amount");
        add(l);
        l.setBounds(30, 110, 400, 20);
        l.setFont(new Font("Arial", Font.BOLD, 15));
        l.setForeground(Color.black);

        Connect c = new Connect();
        try {
            String q = "select * from login where pinnumber = '"+pin+"'";
            ResultSet rs = c.s.executeQuery(q);
            while(rs.next()){
                String cnumber = rs.getString(2);
                cn.setText("Card Number : XXXXXXXXXXXX"+cnumber.substring(12));
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

        JLabel statements = new JLabel();
        add(statements);
        statements.setBounds(30, 110, 400, 200);

        try {
            String q = "select * from transactions where pin = '"+pin+"' order by date desc limit 5;";
            ResultSet rs = c.s.executeQuery(q);
            int t  = 1;
            while(rs.next()){
                String temp = Integer.toString(t);
                String s = temp+"." + "&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(2)+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(3)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(4);
                statements.setText(statements.getText() +"<html>"+ s+"<br><br><html>");
                t++;
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

        okay = new JButton("Okay");
        add(okay);
        okay.setBackground(Color.black);
        okay.setForeground(Color.white);
        okay.addActionListener(this);
        okay.setBounds(250, 320, 80, 20);
    }
    @Override
    public void actionPerformed(ActionEvent a){
        if(a.getSource() == okay){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Ministatement("");
    }
}
