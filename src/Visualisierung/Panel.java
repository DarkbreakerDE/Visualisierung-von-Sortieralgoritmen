package src.Visualisierung;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {
	private Rechteck[] listeAlt;
	private Rechteck[] listeNeu;
	private final int anzahlElemente;
	private int delay;
	private final Component[] empty;
	private int zahl1;
	private int zahl2;
	private final Timer timer;
	private String selectedsort;
	private final SteuerungPanel s ;
	private boolean play;
	
	public Panel(SteuerungPanel s) {
		super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		super.setBorder(new EmptyBorder(new Insets(30, 30, 30, 30)));
		//super.setBackground(Consts.BACKGROUNDCOLOR.getColor());
		super.setBackground(Color.black);
		super.setVisible(true);
		
		timer = new Timer(delay, this);
		anzahlElemente = 50;
		listeAlt = new Rechteck[anzahlElemente];
		listeNeu = new Rechteck[anzahlElemente];
		empty = new Component[anzahlElemente];
		play = false;
		this.s = s;

		listeErstellen();
		draw();
		}
	
	private void listeErstellen() {
		for (int i = 1; i<= anzahlElemente; i++) {
			listeAlt[i-1] = new Rechteck(i*5);
			empty[i-1] = Box.createRigidArea(new Dimension(5,0));
		}
		listeNeu = listeAlt;
		Random rand = new Random();
		for (int i = 0; i < anzahlElemente; i++) {
			int randomIndexToSwap = rand.nextInt(anzahlElemente);
			Rechteck temp = listeNeu[randomIndexToSwap];
			listeNeu[randomIndexToSwap] = listeNeu[i];
			listeNeu[i] = temp;
			
		}
		listeAlt = listeNeu;
	}
	
	private void draw() {
		delete();
		for (int i = 0; i < anzahlElemente; i++) {
			super.add(listeNeu[i]);
			//listeNeu[i].giveColor();
			super.add(empty[i]);
		}
		super.revalidate();
		super.repaint();
		listeAlt = listeNeu;
	}
	
	private void setColorGreen() {
		for(int i = 0; i < anzahlElemente; i++) {
			listeAlt[i].setImageGreen();
		}
	}
	
	private void delete() {
		for (int i = 0; i < anzahlElemente; i++) {
			super.remove(listeAlt[i]);
			super.remove(empty[i]);
		}
	}
	
	public Panel getSelf() {return this;}
	
	private void selectionsort(int o, int i) {
		listeNeu = listeAlt;
		setColorGreen();
		listeNeu[o].setImageRed();
		listeNeu[i].setImageRed();
		if (listeNeu[i].getValue() > listeNeu[o].getValue()) {
			Rechteck temp = listeNeu[i];
			listeNeu[i] = listeNeu[o];
			listeNeu[o] = temp;
		}
		draw();
	}
	
	public void Selectionsort() {
		zahl1 = 0;
		zahl2 = 0;
		play = true;
		selectedsort = "Selectionsort";
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (selectedsort != null) {
			switch (selectedsort) {
				case "Selectionsort" -> {
					int[] zahlen = getNumbersSelectionSort();
					System.out.println(zahlen[0] + " " + zahlen[1]);
					selectionsort(zahlen[0], zahlen[1]);
				}
				case "bubbleSort" -> {
					int zahlen1 = getNumbersBubbleSort();
					System.out.println(zahlen1);
					bubbleSort(zahlen1);
				}
			}
		}
	}
	
	private int[] getNumbersSelectionSort() {
		if (zahl2 < anzahlElemente-1) {
			zahl2++;
			return new int[]{zahl1, zahl2};
		} else if (zahl1 < anzahlElemente-1) {
			zahl1++;
			zahl2 = 0;
			return new int[]{zahl1, zahl2};
		} else {
			timer.stop();
			play = false;
			s.semaphor = false;
		}
		return new int[]{zahl1, zahl2};
	}

	public void reset() {
		try {
			delete();
		} catch (Exception e) {}
		listeErstellen();
		draw();
		s.semaphor = false;
	}

	public void beenden(){
		timer.stop();
		reset();
		selectedsort = null;
		s.semaphor = false;
	}
	public void pause(){
		if (!play){
			play = true;
			timer.start();
		} else {
			timer.stop();
			play = false;
		}
	}

	public void setSpeed(int i){
		delay = i;
		timer.setDelay(delay);
	}

	private void bubbleSort(int o){
		setColorGreen();
		listeNeu[o].setImageRed();
		if(listeNeu[o].getValue()>listeNeu[o+1].getValue()){
			Rechteck buffer = listeNeu[o];
			listeNeu[o] = listeNeu[o + 1];
			listeNeu[o + 1] = buffer;

		}
		draw();
	}
	public void BubbleSort(){
		zahl1 = anzahlElemente -1;
		zahl2 = 0;
		selectedsort = "bubbleSort";
		play = true;
		timer.start();
	}
	public int getNumbersBubbleSort(){
		if (zahl2 < zahl1-1) {
			zahl2++;
			return zahl2;
		} else if (zahl1 > 1) {
			zahl1--;
			zahl2 = 0;
			return zahl2;
		} else {
			timer.stop();
			play = false;
			s.semaphor = false;
		}
		return zahl2;
	}
}
