import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class signup2 extends JFrame implements ActionListener {
    String[] relgvalues = {"Please Select", "Hindu", "Muslim", "Sikh", "Christian", "Others"};
    String[] categvalues = {"Please Select", "UR", "OBC", "SC", "ST"};
    String[] eduvalues = {"Please Select", "Graduated", "Non Graduate", "Post Graduate", "Doctorate"};
    String[] incomevalues = {"Please Select", "Less than 2 lacs", "Less than 5 lacs", "Less than 8 lacs", "Above 8 lacs"};
    String[] occuvalues = {"Please Select", "Salaried", "Self employed", "Business", "not employed"};
    JComboBox relegion; // jcombobox is used to make a option function like a drop -down menu and in this we have to pass a array of values
    JComboBox category;
    JComboBox education;
    JComboBox occupation;
    JComboBox income;
    JTextField adhar;
    JTextField pan;
    JRadioButton yes;
    JRadioButton no;
    JButton next;
    String formnum ;
    signup2(String formno){
        this.formnum = formno;
        setLayout(null);
        setVisible(true);
        setBounds(450, 70, 600, 700);
        getContentPane().setBackground(Color.white);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        setTitle("Registratin Form");
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        add(l);
        l.setBounds(40, 35, 100, 100);
        setIconImage(i1.getImage());

        JLabel adddet = new JLabel("Step 2 : Additional Details");
        add(adddet);
        adddet.setBounds(170, 55, 400, 70);
        adddet.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel additi2 = new JLabel("__________________________________");
        add(additi2);
        additi2.setBounds(170, 90, 400, 30);
        additi2.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel relg = new JLabel("Religion : ");
        add(relg);
        relg.setBounds(80, 150, 100, 70);
        relg.setFont(new Font("Arial", Font.BOLD, 20));

        relegion = new JComboBox(relgvalues);
        add(relegion);
        relegion.setBounds(280, 175, 200, 20);
        relegion.setBackground(Color.white);

        JLabel categ = new JLabel("Category : ");
        add(categ);
        categ.setBounds(80, 190, 110, 70);
        categ.setFont(new Font("Arial", Font.BOLD, 20));

        category = new JComboBox(categvalues);
        add(category);
        category.setBounds(280, 215, 200, 20);
        category.setBackground(Color.white);

        JLabel eq = new JLabel("Educational");
        add(eq);
        eq.setBounds(80, 230, 130, 70);
        eq.setFont(new Font("Arial", Font.BOLD, 20));

        education = new JComboBox(eduvalues);
        add(education);
        education.setBounds(280, 260, 200, 20);
        education.setBackground(Color.white);

        JLabel q = new JLabel("Qualification : ");
        add(q);
        q.setBounds(80, 250, 140, 70);
        q.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel occu = new JLabel("Occupation : ");
        add(occu);
        occu.setBounds(80, 290, 130, 70);
        occu.setFont(new Font("Arial", Font.BOLD, 20));

        occupation = new JComboBox(occuvalues);
        add(occupation);
        occupation.setBounds(280, 315, 200, 20);
        occupation.setBackground(Color.white);

        JLabel an = new JLabel("Aadhar No : ");
        add(an);
        an.setBounds(80, 330, 130, 70);
        an.setFont(new Font("Arial", Font.BOLD, 20));

        adhar = new JTextField();
        add(adhar);
        adhar.setBounds(280, 355, 260, 25);
        adhar.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel pn = new JLabel("PAN No. : ");
        add(pn);
        pn.setBounds(80, 370, 130, 70);
        pn.setFont(new Font("Arial", Font.BOLD, 20));

        pan = new JTextField();
        add(pan);
        pan.setBounds(280, 395, 260, 25);
        pan.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel sc = new JLabel("Senior Citizen : ");
        add(sc);
        sc.setBounds(80, 410, 150, 70);
        sc.setFont(new Font("Arial", Font.BOLD, 20));

        yes = new JRadioButton("Yes");
        add(yes);
        yes.setBounds(280, 435, 100, 20);
        yes.setBackground(Color.white);

        no = new JRadioButton("No");
        add(no);
        no.setBounds(380, 435, 100, 20);
        no.setBackground(Color.white);

        ButtonGroup bg = new ButtonGroup();
        bg.add(yes);
        bg.add(no);

        JLabel in = new JLabel("Income : ");
        add(in);
        in.setBounds(80, 450, 130, 70);
        in.setFont(new Font("Arial", Font.BOLD, 20));

        income = new JComboBox(incomevalues);
        add(income);
        income.setBounds(280, 480, 200, 20);
        income.setBackground(Color.white);

        next = new JButton("Next");
        add(next);
        next.addActionListener(this);
        next.setBounds(330, 525, 100, 20);
        next.setForeground(Color.white);
        next.setBackground(Color.black);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String relg = (String) relegion.getSelectedItem();
        String categ = (String)category.getSelectedItem();
        String edu = (String)education.getSelectedItem();
        String occu = (String)occupation.getSelectedItem();
        String inc = (String)income.getSelectedItem();
        String adhr = adhar.getText();
        String panno = pan.getText();
        String age = "";
        if(yes.isSelected()){
            age = "Yes";
        }else{
            age = "No";
        }
        try {
            Connect c1 = new Connect();
            String q = "select * from signuptwo where adhar_no = '"+adhr+"'";
            ResultSet rs = c1.s.executeQuery(q); // here we are checking whether column exists or not
            if(rs.next()){ // resultset means like a pointer which points towards the row of concerned query
                try {
                    Connect c2 = new Connect();
                    String q1 = "delete from signup where formno = '"+formnum+"';";
                    c2.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Adhar already exists.");
                    setVisible(false);
                    new Login().setVisible(true);
                }catch (Exception ex){
                    System.out.println(ex);
                }
            }
            else if(relg.equals("Please Select")){
                JOptionPane.showMessageDialog(null, "Please select your relegion");
            }else if(categ.equals("Please Select")){
                JOptionPane.showMessageDialog(null, "Please select your category");
            }else if(edu.equals("Please Select")){
                JOptionPane.showMessageDialog(null, "Please select your education level");
            }else if(occu.equals("Please Select")){
                JOptionPane.showMessageDialog(null, "Please select your occupation");
            }else if(inc.equals("Please Select")){
                JOptionPane.showMessageDialog(null, "Please select your income");
            }else if(adhr.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your adhar number");
            }else if(panno.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your pan number");
            }else if(age.equals("")){
                JOptionPane.showMessageDialog(null, "Please select your age");
            }else{
                Connect c = new Connect();
                String Query = "insert into signuptwo values ('"+formnum+"', '"+relg+"', '"+categ+"', '"+edu+"', '"+occu+"', '"+inc+"', '"+adhr+"', '"+panno+"', '"+age+"');";
                // we are writing query above
                c.s.executeUpdate(Query);
                setVisible(false);
                new signup3(formnum).setVisible(true);
            }
        }catch (Exception ae){
            System.out.println(ae);
        }
    }

}
