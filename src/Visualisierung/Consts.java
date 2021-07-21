package src.Visualisierung;

import java.awt.*;

public enum Consts {
	BACKGROUNDCOLOR(0xA8a8b8); //0x53575B 0x95959b

	private final int i;
	Consts(int i) {
		this.i = i;
	}
	public Color getColor() {
		return new Color(i);
	}
	
}
