package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtilTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	private StringUtil stringUtil;

	@BeforeEach
	void setUp() {
		stringUtil = new StringUtil();
	}

	@Test
	void testTruncateInFirst2Position() {

		assertEquals("SD", stringUtil.trancateInFirst2Position("AASD"));

		assertEquals("SD", stringUtil.trancateInFirst2Position("ASSD"));
		

		assertEquals("SDwe", stringUtil.trancateInFirst2Position("SDWe"));
		assertEquals("SDE", stringUtil.trancateInFirst2Position("SADE"));
	}

	@Test
	void testAreFirstAndLastTwoCharactersTheSame() {

		assertTrue(stringUtil.areFirstAndLastTwoCharactersTheSame("ABCDAB"));

//		assertFalse(stringUtil.areFirstAndLastTwoCharactersTheSame("ABCDXY"));
//
//		assertTrue(stringUtil.areFirstAndLastTwoCharactersTheSame("ABA"));
//
//		assertTrue(stringUtil.areFirstAndLastTwoCharactersTheSame("AA"));
//
//		assertFalse(stringUtil.areFirstAndLastTwoCharactersTheSame("A"));
//
//		assertFalse(stringUtil.areFirstAndLastTwoCharactersTheSame(null));
//
//		assertFalse(stringUtil.areFirstAndLastTwoCharactersTheSame(""));
	}

}
