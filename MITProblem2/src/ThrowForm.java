import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import layout.SpringUtilities;

/**
 * Created by paulmaddock on 3/30/14.
 */
public class ThrowForm extends JFrame implements WindowListener, ActionListener {
    /**
     * Your program should prompt the user for the following inputs:
     *- distance,d, from thrower’s hand to the center of the basket (in meters)
     *- diameter of the basket (in meters)
     *- initial ball speed v0(in meters/second)
     *- height of the ceiling from the basket (in meters)
     */
    JTextField distanceFld = new JTextField(20);
    JTextField diameterFld = new JTextField(20);
    JTextField iniSpeedFld  = new JTextField(20);
    JTextField heightFld  = new JTextField(20);
    JLabel distanceLbl = new JLabel("Distance");
    JLabel diameterLbl  = new JLabel("Diameter");
    JLabel iniSpeedLbl  = new JLabel("Initial Speed");
    JLabel heightLbl = new JLabel("Height");
    JButton calculateButton = new JButton("Calculate");
    JTextArea outputTA ;
    JScrollPane scrollPane;
    JButton clearBtn = new JButton("Clear");

    String imgURI="./img/arc.png";
    public ThrowForm(){
        super("Throw Form");
        setLayout(new FlowLayout());
        JPanel p = new JPanel(new SpringLayout());
        JPanel p0 = new JPanel(new FlowLayout());
        p.setPreferredSize(new Dimension(500, 120));
        super.setIconImage(new ImageIcon(imgURI).getImage());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        outputTA = new JTextArea(10,20);
        scrollPane = new JScrollPane(outputTA);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(450, 110));
        p.add(distanceLbl);
        p.add(distanceFld);
        p.add(diameterLbl);
        p.add(diameterFld);
        p.add(iniSpeedLbl);
        p.add(iniSpeedFld);
        p.add(heightLbl);
        p.add(heightFld);
        p.add(calculateButton);
        p.add(clearBtn);
        add(p);
        SpringUtilities.makeGrid(p,
                5, 2, //rows, cols
                5, 5, //initialX, initialY
                5, 5);//xPad, yPad
        p0.add(scrollPane, outputTA);
        add(p0);
        this.setSize(new Dimension(500, 400));
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if (source == clearBtn){
            outputTA.setText("");
        }

        if (source == calculateButton){
            Throw calcThrow = new Throw(Double.parseDouble(distanceFld.getText()),Double.parseDouble(diameterFld.getText()),
                    Double.parseDouble(iniSpeedFld.getText()),Double.parseDouble(heightFld.getText()));
            outputTA.setText("Optimal Angle      " + calcThrow.computeOptimalAngle() + " degrees \n" +
                    "Range of acceptable angles is from " + calcThrow.computeSmallestAngle() + " degrees to " + calcThrow.computeLargestAngle() + " degrees" +
                    "The maximum height of the ball is " + calcThrow.computeHeight() + "." +
                    "Will the ball hit the ceiling? " + String.valueOf(calcThrow.hitsCeiling()));
            if (calcThrow.hitsCeiling()){

            }

        }

    }

    public void windowClosing(WindowEvent e) {

    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }
}
