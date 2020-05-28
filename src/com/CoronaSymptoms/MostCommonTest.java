package com.CoronaSymptoms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MostCommonTest {

	@Test
	void testMostCommon()
	{
		Result r = new Result();
		MostCommon mc = new MostCommon(r);
		boolean resultMC = mc.isAllChecked(true, false, true);
		assertEquals(false, resultMC);
	}

}
