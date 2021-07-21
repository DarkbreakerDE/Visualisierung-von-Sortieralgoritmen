package src.Visualisierung;

import javax.swing.*;
import java.awt.*;


public class Main {

	public static void main(String[] args){
		ImageIcon icon = new ImageIcon("Logo JHG.png");
		
		JFrame f = new JFrame("Visualisierung von Sortieralgorithemen");
		f.setBackground(Consts.BACKGROUNDCOLOR);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(200,100, 1100, 600);
		f.setIconImage(icon.getImage());
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(1150, 600));
		
		SteuerungPanel stp = new SteuerungPanel();
		stp.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.add(stp.getPanel());
		
		panel.setBackground(Consts.BACKGROUNDCOLOR);
		panel.setVisible(true);
		f.add(panel, BorderLayout.CENTER);
		f.add(stp, BorderLayout.LINE_END);
		f.add(stp.getSlider(), BorderLayout.PAGE_END);
		f.setVisible(true);
	}
}
