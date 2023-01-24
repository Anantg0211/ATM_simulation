import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class withdrawl extends JFrame implements ActionListener {
    String pin;
    withdrawl(String pin){
        this.pin = pin;

    }
    @Override
    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String[] args) {
        new withdrawl("");
    }
}
