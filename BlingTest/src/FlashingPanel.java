import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FlashingPanel extends JPanel {
	private int count;
	private Timer animator;
	
	public FlashingPanel() {
		setPreferredSize(new Dimension(100,40));
		setBackground(Color.black);
	}
	
	public void addNotify() {
		super.addNotify();
		animator = new Timer(300, animatorTask);
		animator.start();
	}
	
	public void paintComponent(Graphics g) {
         super.paintComponent(g);
		count++;
		if (count % 2 == 0) {
			g.setColor(Color.red);
		} else {
			g.setColor(Color.blue);
		}
		g.drawString("Game Over", (getWidth() / 2) - 30, getHeight() /2);
	}

	private ActionListener animatorTask = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	};
	public static void main(String[] args) {
		JFrame frame = new JFrame("BlinkLabel");
	   // final BlinkLabel bl = new BlinkLabel("I'm blinking!");
	
	    frame.getContentPane().setLayout(new java.awt.FlowLayout());
	   // frame.getContentPane().add(bl);
	    FlashingPanel fp=new FlashingPanel();
	    frame.add(fp);
	    
	    JButton b = new JButton("toogle blink");
	   
	   // frame.getContentPane().add(b);
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
}