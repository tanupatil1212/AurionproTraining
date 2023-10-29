package com.aurionpro.model;

public enum Wood {
ALDER, INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR;
	
	public String toString() {
		switch(this) {
			case ALDER: return "Alder";
			case INDIAN_ROSEWOOD: return "Indian Rosewood";
			case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
			case MAHOGANY: return "Mahogany";
			case MAPLE: return "Maple";
			case COCOBOLO: return "Cocobolo";
			case CEDAR: return "Cedar";
			default: return "unspecified";
		}
	}
}
