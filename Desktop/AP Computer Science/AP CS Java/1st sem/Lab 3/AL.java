import java.awt.*;
import java.awt.event.*;

public class AL extends Frame implements WindowListener,ActionListener  
        {        
            //instance variables
        TextField text = new TextField(20);
        Button b;
        Button c;
        private int numClicks = 0;

        public static void main(String[] args) {
            //calls constructor to set up a window
                AL myWindow = new AL("My first window");
                myWindow.setSize(350,400);
                myWindow.setVisible(true);
        }

        public AL(String title) {

                super(title);
                setLayout(new FlowLayout());
                addWindowListener(this);
                //adding a few buttons to your window
                b = new Button("Click me");
                add(b);
                c = new Button("boo ya");
                add(c);
                add(text);
                b.addActionListener(this);
        }

        //what happens when you click on the button
        public void actionPerformed(ActionEvent e) {
                numClicks++;
                text.setText("Button Clicked " + numClicks + " times");
        }

        //what happens when the window is closed
        public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        }

        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

}