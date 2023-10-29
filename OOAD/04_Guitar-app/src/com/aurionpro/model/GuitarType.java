package com.aurionpro.model;

public enum GuitarType {
ACOUSTIC, ELECTRIC;
	
	public String toString() {
		switch(this) {
			case ACOUSTIC: return "Acoustic";
			case ELECTRIC: return "Electric";
			default: return "unspecified";
		}
	}
}
