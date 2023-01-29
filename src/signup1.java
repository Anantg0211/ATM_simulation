import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class signup1 extends JFrame implements ActionListener {
    HashSet<Character> em = new HashSet<>();
    JButton next;
    JTextField ntextf;
    JTextField fntextf;
    JTextField mntextf;
    JTextField emailtf;
    JTextField addrtf;
    JTextField citytf;
    JTextField statetf;
    JTextField pintf;
    JDateChooser dobdc;
    JRadioButton gendm;
    JRadioButton gendf;
    JRadioButton single;
    JRadioButton married;
    JRadioButton divorced;

    Long randomno;
    signup1(){
        setLayout(null);
        setTitle("Registration Form");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        l.setBounds(30, 35, 100, 100);
        add(l);
        setIconImage(i1.getImage());
        setSize(600, 700);
        setVisible(true);
        setLocation(450, 70);
        getContentPane().setBackground(Color.white);

        Random ran = new Random();
        randomno = Math.abs(ran.nextLong()%9000L) + 1000L;
        JLabel formno = new JLabel("Application Form Number : " + randomno);
        add(formno);
        formno.setBounds(170, 30, 400, 70);
        formno.setFont(new Font("Arial", Font.BOLD, 25));

        JLabel additi2 = new JLabel("__________________________________");
        add(additi2);
        additi2.setBounds(170, 60, 400, 30);
        additi2.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel step1 = new JLabel("Step 1 : Personal Details");
        add(step1);
        step1.setBounds(210, 80, 400, 70);
        step1.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel additi1 = new JLabel("_____________________");
        add(additi1);
        additi1.setBounds(210, 105, 400, 30);
        additi1.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel name = new JLabel("Name : ");
        add(name);
        name.setBounds(80, 150, 100, 70);
        name.setFont(new Font("Arial", Font.BOLD, 18));

        ntextf = new JTextField();
        add(ntextf);
        ntextf.setBounds(250, 175, 250, 20);
        ntextf.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel fname = new JLabel("Father's Name : ");
        add(fname);
        fname.setBounds(80, 185, 150, 70);
        fname.setFont(new Font("Arial", Font.BOLD, 18));

        fntextf = new JTextField();
        add(fntextf);
        fntextf.setBounds(250, 210, 250, 20);
        fntextf.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel mname = new JLabel("Mother's Name : ");
        add(mname);
        mname.setBounds(80, 220, 150, 70);
        mname.setFont(new Font("Arial", Font.BOLD, 18));

        mntextf = new JTextField();
        add(mntextf);
        mntextf.setBounds(250, 245, 250, 20);
        mntextf.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel dob = new JLabel("Date of Birth : ");
        add(dob);
        dob.setBounds(80, 255, 150, 70);
        dob.setFont(new Font("Arial", Font.BOLD, 18));

        dobdc = new JDateChooser(); // this is a class of jclaender jar file
        add(dobdc);
        dobdc.setBounds(250, 280, 150, 20);

        JLabel gender = new JLabel("Gender : ");
        add(gender);
        gender.setBounds(80, 290, 150, 70);
        gender.setFont(new Font("Arial", Font.BOLD, 18));

        gendm = new JRadioButton("Male"); // radio button means options choosing butttons
        add(gendm);
        gendm.setBackground(Color.white);
        gendm.setBounds(250, 315, 60, 20);

        gendf = new JRadioButton("Female");
        add(gendf);
        gendf.setBackground(Color.white);
        gendf.setBounds(320, 315, 150, 20);

        ButtonGroup g = new ButtonGroup(); // this means you can choose any one button from the buttons present in this grp
        g.add(gendm);
        g.add(gendf);

        JLabel email = new JLabel("Email Address : ");
        add(email);
        email.setBounds(80, 325, 150, 70);
        email.setFont(new Font("Arial", Font.BOLD, 18));

        emailtf = new JTextField();
        add(emailtf);
        emailtf.setBounds(250, 350, 250, 20);
        emailtf.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel ms = new JLabel("Marital Status: ");
        add(ms);
        ms.setBounds(80, 360, 150, 70);
        ms.setFont(new Font("Arial", Font.BOLD, 18));

        single = new JRadioButton("Single");
        add(single);
        single.setBackground(Color.white);
        single.setBounds(250, 385, 70, 20);

        married = new JRadioButton("Married");
        add(married);
        married.setBackground(Color.white);
        married.setBounds(320, 385, 70, 20);

        divorced = new JRadioButton("Divorced");
        add(divorced);
        divorced.setBackground(Color.white);
        divorced.setBounds(395, 385, 80, 20);

        ButtonGroup s = new ButtonGroup();
        s.add(single);
        s.add(divorced);
        s.add(married);

        JLabel add = new JLabel("Address : ");
        add(add);
        add.setBounds(80, 395, 150, 70);
        add.setFont(new Font("Arial", Font.BOLD, 18));

        addrtf = new JTextField();
        add(addrtf);
        addrtf.setBounds(250, 420, 250, 20);
        addrtf.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel city = new JLabel("City : ");
        add(city);
        city.setBounds(80, 430, 150, 70);
        city.setFont(new Font("Arial", Font.BOLD, 18));

        citytf = new JTextField();
        add(citytf);
        citytf.setBounds(250, 455, 250, 20);
        citytf.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel state = new JLabel("State : ");
        add(state);
        state.setBounds(80, 465, 150, 70);
        state.setFont(new Font("Arial", Font.BOLD, 18));

        statetf = new JTextField();
        add(statetf);
        statetf.setBounds(250, 490, 250, 20);
        statetf.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel pin = new JLabel("Pin-Code : ");
        add(pin);
        pin.setBounds(80, 500, 150, 70);
        pin.setFont(new Font("Arial", Font.BOLD, 18));

        pintf = new JTextField();
        add(pintf);
        pintf.setBounds(250, 525, 250, 20);
        pintf.setFont(new Font("Arial", Font.BOLD, 16));

        next = new JButton("Next");
        add(next);
        next.addActionListener(this);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(340, 570, 80, 20);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String formno = ""+ randomno;
        String name = ntextf.getText(); // this is used to get a value from textfield
        String fname = fntextf.getText();
        String mname = mntextf.getText();
        String email = emailtf.getText();
        for(int i = 0; i < email.length(); i++){
            em.add(email.charAt(i));
        }
        String add = addrtf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pincode = pintf.getText();
        String dob = ((JTextField)(dobdc.getDateEditor().getUiComponent())).getText(); // this funct is to get date from datechooser class;
        String gender = "";
        if(gendm.isSelected()){ // this funct is to check which radio button is selected
            gender = "Male";
        }else if(gendf.isSelected()){
            gender = "Female";
        }
        String marrieds = "";
        if(single.isSelected()){
            marrieds = "Single";
        }else if(married.isSelected()){
            marrieds = "Married";
        }else if(divorced.isSelected()){
            marrieds = "Divored";
        }
        try {
            if(name.equals("")){ // these all conditions are to check whether none of the field is empty
                JOptionPane.showMessageDialog(null, "Please Enter Your Name");
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your Father Name");
            }
            else if(mname.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your Mother Name");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your Email");
            }
            else if(!em.contains('@') || !em.contains('.')){
                JOptionPane.showMessageDialog(null, "Please enter a valid email");
            }
            else if(add.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your Address");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your City");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your State");
            }
            else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your Pin-Code");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your DOB");
            }
            else if(gender.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your Gender");
            }
            else if(marrieds.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your Marital Status");
            }else{
                Connect c = new Connect(); // we have created an object of connection class to enter the data into table
                String Query = "insert into signup values ('"+formno+"', '"+name+"', '"+fname+"', '"+mname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marrieds+"', '"+add+"', '"+city+"', '"+state+"', '"+pincode+"');";
                // we are writing query above
                c.s.executeUpdate(Query); // here we are executing query
                setVisible(false);
                new signup2(formno).setVisible(true);
            }
        } catch (Exception ex){
            System.out.println(ex);
        }
    }

}
