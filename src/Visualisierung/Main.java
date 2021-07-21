package src.Visualisierung;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		ImageIcon icon = new ImageIcon("Logo JHG.png");
		
		JFrame f = new JFrame("Visualisierung von Sortieralgorithemen");
		f.setBackground(Color.yellow); //TODO Farbe 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(200,100, 1100, 600);
		f.setIconImage(icon.getImage());
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(1150, 600));
		
		//JPanel jp = new JPanel();
		//jp.setBackground(Color.GRAY);
		//jp.setPreferredSize(new Dimension(150,150));
		
		//f.add(new JLabel("HAllo"));
		//f.add(jp,BorderLayout.WEST);
		
		
		SteuerungPanel stp = new SteuerungPanel();
		stp.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.add(stp.getPanel());
		
		panel.setBackground(Consts.BACKGROUNDCOLOR.getColor());
		panel.setVisible(true);
		f.add(panel, BorderLayout.CENTER);
		//f.add(p1, BorderLayout.PAGE_END);
		f.add(stp, BorderLayout.LINE_END);
		//SteuerungPanel sp = new SteuerungPanel();
		//f.add(new JLabel(new ImageIcon("Green Balken.png")));#
		f.add(stp.getSlider(), BorderLayout.PAGE_END);
		f.setVisible(true);
		
	}

}
