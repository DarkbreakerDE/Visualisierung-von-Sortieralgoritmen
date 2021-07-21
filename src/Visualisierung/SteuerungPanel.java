package src.Visualisierung;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SteuerungPanel extends JPanel implements ActionListener{
	private final Panel p;
	private final JSlider slider;
	public boolean semaphor;

	public SteuerungPanel() {
		super.setBackground(Consts.BACKGROUNDCOLOR);
		super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		super.setBorder(new EmptyBorder(new Insets(30, 20, 30, 30)));

		//super.setSize(new Dimension(200, 300));
		semaphor = false;
		p = new Panel();
		p.setVisible(true);
		
		JLabel l = new JLabel("Sortieralgorithmus");
		l.setVisible(true);
		this.add(l);
		
		JLabel l2 = new JLabel("Auswählen:");
		l2.setVisible(true);
		this.add(l2);
		
		this.add(Box.createRigidArea(new Dimension(20,20)));
		
		JButton s1 = new JButton();
		s1.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		s1.setText("Selection Sort");
		s1.setMinimumSize(new Dimension(200,200));
		s1.addActionListener(this);
		this.add(s1);
		
		this.add(Box.createRigidArea(new Dimension(10,10)));

		JButton s4 = new JButton();
		s4.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		s4.setText("Bubble Sort");
		s4.setMinimumSize(new Dimension(200,200));
		s4.addActionListener(this);
		this.add(s4);

		this.add(Box.createRigidArea(new Dimension(10,10)));

		JButton s3 = new JButton();
		s3.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		s3.setText("Pause");
		s3.setMinimumSize(new Dimension(50,50));
		s3.addActionListener(this);
		this.add(s3);

		this.add(Box.createRigidArea(new Dimension(10,10)));

		JButton s2 = new JButton();
		s2.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		s2.setText("Reset");
		s2.setMinimumSize(new Dimension(50,50));
		s2.addActionListener(this);
		this.add(s2);

		this.add(Box.createRigidArea(new Dimension(10,10)));

		slider = new JSlider(0,0, 200, 40);
		slider.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		slider.setMinimumSize(new Dimension(50,50));
		slider.setBackground(new Color(0x4d4d4d));
		slider.addChangeListener(e -> p.setSpeed(slider.getValue()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Reset" -> {
				if (!semaphor) {
					semaphor = true;
					p.reset();
				} else {
					p.beenden();
				}
				System.out.println("Reset");
			}
			case "Selection Sort" -> {
				if (!semaphor) {
					semaphor = true;
					p.Selectionsort(this);
				}
				System.out.println("Selectionsort");
			}
			case "Pause" -> p.pause();
			case "Bubble Sort" -> {
				if (!semaphor) {
					semaphor = true;
					p.BubbleSort(this);
				}
				System.out.println("Bubblesort");
			}
		}
	}
	
	public Panel getPanel() {
		return p.getSelf();
	}

	public JSlider getSlider(){return slider;}
	
}

