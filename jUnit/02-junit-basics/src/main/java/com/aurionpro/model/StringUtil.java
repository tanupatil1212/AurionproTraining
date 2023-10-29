package com.aurionpro.model;

public class StringUtil {

	public String trancateInFirst2Position(String str) {
		if (str == null || str.length() < 2) {
			return str;
		} else {
			return str.substring(0, 2);
		}

	}

	public boolean areFirstAndLastTwoCharactersTheSame(String str) {
		return false;
	}

}
