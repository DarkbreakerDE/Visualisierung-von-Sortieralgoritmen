package src.Visualisierung;

import javax.swing.*;
import java.awt.*;

public class Rechteck extends JLabel{
	private final int hight;
	private final int WIDTH;
	private final String PATH_GREEN;
	private final String PATH_RED;
	private String aktuellerPfad;

	public Rechteck(int hight) {
		 this.hight = hight;
		 WIDTH= 9;
		 PATH_GREEN = "Green Balken.png";
		 PATH_RED = "RedBalken.png";
		 aktuellerPfad = PATH_GREEN;
		 setIcon();
		 super.setAlignmentY(BOTTOM_ALIGNMENT);
	}
	
	public void setIcon() {
		ImageIcon icon = new ImageIcon(aktuellerPfad);
		Image image = icon.getImage();
		image = image.getScaledInstance(WIDTH, hight, Image.SCALE_SMOOTH);
		icon.setImage(image);
		super.setIcon(icon);
	}
	
	public void setImageGreen() {
		aktuellerPfad = PATH_GREEN;
		setIcon();
		super.revalidate();
		super.repaint();
	}
	
	public void setImageRed() {
		aktuellerPfad = PATH_RED;
		setIcon();
		super.revalidate();
		super.repaint();
	}
	
	public int getValue() {
		return hight;
	}
}
