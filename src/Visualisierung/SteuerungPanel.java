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

		semaphor = false;
		p = new Panel(this);
		p.setVisible(true);
		
		JLabel lSortieralgorithmus = new JLabel("Sortieralgorithmus");
		lSortieralgorithmus.setVisible(true);
		this.add(lSortieralgorithmus);
		
		JLabel lAuswaehlen = new JLabel("Auswählen:");
		lAuswaehlen.setVisible(true);
		this.add(lAuswaehlen);
		
		this.add(Box.createRigidArea(new Dimension(20,20)));
		
		JButton btnSelectionsort = new JButton();
		btnSelectionsort.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		btnSelectionsort.setText("Selection Sort");
		btnSelectionsort.setMinimumSize(new Dimension(200,200));
		btnSelectionsort.addActionListener(this);
		btnSelectionsort.setForeground(Consts.BACKGROUNDCOLORSLIDER);
		this.add(btnSelectionsort);
		
		this.add(Box.createRigidArea(new Dimension(10,10)));

		JButton btnBubblesort = new JButton();
		btnBubblesort.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		btnBubblesort.setText("Bubble Sort");
		btnBubblesort.setMinimumSize(new Dimension(200,200));
		btnBubblesort.addActionListener(this);
		this.add(btnBubblesort);

		this.add(Box.createRigidArea(new Dimension(10,10)));

		JButton btnPause = new JButton();
		btnPause.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		btnPause.setText("Pause");
		btnPause.setMinimumSize(new Dimension(50,50));
		btnPause.addActionListener(this);
		this.add(btnPause);

		this.add(Box.createRigidArea(new Dimension(10,10)));

		JButton btnReset = new JButton();
		btnReset.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		btnReset.setText("Reset");
		btnReset.setMinimumSize(new Dimension(50,50));
		btnReset.addActionListener(this);
		this.add(btnReset);

		this.add(Box.createRigidArea(new Dimension(10,10)));

		slider = new JSlider(0,0, 200, 40);
		slider.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		slider.setMinimumSize(new Dimension(50,50));
		slider.setBackground(Consts.BACKGROUNDCOLORSLIDER);
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
					p.Selectionsort();
				}
				System.out.println("Selectionsort");
			}
			case "Pause" -> p.pause();
			case "Bubble Sort" -> {
				if (!semaphor) {
					semaphor = true;
					p.BubbleSort();
				}
				System.out.println("Bubblesort");
			}
		}
	}
	
	public Panel getPanel() {return p.getSelf();}

	public JSlider getSlider(){return slider;}
}

