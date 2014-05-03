import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

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
    DecimalFormat df = new DecimalFormat("#.##");
    JTextField distanceFld = new JTextField(20);
    JTextField diameterFld = new JTextField(20);
    JTextField iniSpeedFld  = new JTextField(20);
    JTextField heightFld  = new JTextField(20);
    JLabel distanceLbl = new JLabel("Distance (m)");
    JLabel diameterLbl  = new JLabel("Diameter (m)");
    JLabel iniSpeedLbl  = new JLabel("Initial Speed (m/s)");
    JLabel heightLbl = new JLabel("Height (m)");
    JButton calculateBtn = new JButton("Calculate");
    JTextArea outputTA ;
    JScrollPane scrollPane;
    JButton clearBtn = new JButton("Clear");

    String imgURI="./img/arc.png";
    public ThrowForm(){
        super("Throw Form");
        distanceFld.setText("20");
        diameterFld.setText("2");
        iniSpeedFld.setText("20");
        heightFld.setText("10");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel p = new JPanel(new SpringLayout());
        JPanel p0 = new JPanel(new FlowLayout());
        JPanel p1 = new JPanel(new FlowLayout());
        p.setPreferredSize(new Dimension(500, 120));
        super.setIconImage(new ImageIcon(imgURI).getImage());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        outputTA = new JTextArea(10,20);
        scrollPane = new JScrollPane(outputTA);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(450, 110));
        calculateBtn.setVisible(true);
        p.add(distanceLbl);
        p.add(distanceFld);
        p.add(diameterLbl);
        p.add(diameterFld);
        p.add(iniSpeedLbl);
        p.add(iniSpeedFld);
        p.add(heightLbl);
        p.add(heightFld);
        add(p);
        SpringUtilities.makeGrid(p,
                4, 2, //rows, cols
                5, 5, //initialX, initialY
                5, 5);//xPad, yPad
        p0.add(scrollPane, outputTA);
        p1.add(calculateBtn);
        p1.add(clearBtn);
        add(p0);
        add(p1);
        this.setSize(new Dimension(500, 400));
        calculateBtn.addActionListener(this);
        clearBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if (source == this.clearBtn){
            outputTA.setText("");
        }

        if (source == this.calculateBtn){
            outputTA.setText("");
            Throw calcThrow = new Throw(Double.parseDouble(distanceFld.getText()),Double.parseDouble(diameterFld.getText()),
                  Double.parseDouble(iniSpeedFld.getText()));
            double smAngle = calcThrow.computeSmallestAngle();
            double lrgAngle =  calcThrow.computeLargestAngle();
            double throwHeight =  calcThrow.computeHeight();
            double ceilingHeight = Double.parseDouble(heightFld.getText());
            boolean hitsCeiling = false;

            if (ceilingHeight <= throwHeight){
               hitsCeiling = true;
            }
            outputTA.setText("Optimal Angle      " + df.format(calcThrow.computeOptimalAngle()) + "\u00b0 \n" +
                    "Range of acceptable angles is from " + df.format(smAngle) + "\u00b0 to " + df.format(lrgAngle) + "\u00b0 \n" +
                    "The maximum height of the ball is " + df.format(throwHeight) + "m.\n" +
                    "Will the ball hit the ceiling? " + String.valueOf(hitsCeiling) + "\n");
            if (hitsCeiling){
                while (hitsCeiling){
                    calcThrow.initSpeed = calcThrow.initSpeed + .1;
                    throwHeight =  calcThrow.computeHeight();
                    outputTA.append("Trying v0 " + df.format(calcThrow.initSpeed) + " m/s, theta " + df.format(calcThrow.computeOptimalAngle()) + "\u00b0. " +
                            "Max height  " + df.format(throwHeight) + "m\n");
                    if (ceilingHeight > throwHeight){
                        hitsCeiling = false;
                    }
                }
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
