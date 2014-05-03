package bs.test;

import static org.junit.Assert.*;

import org.junit.Test;

import bs.controller.BSCalc;
import bs.model.InputParameters;
import bs.model.OutputOptionInfo;

public class BSTest {

	@Test
	public void testCalc() {

		// set up the input
		InputParameters input1 = new InputParameters(62.0, 60.0, 40 / 365.0,
				0.04, 0.32);

		// set up the expected output
		OutputOptionInfo exp1 = new OutputOptionInfo();

		exp1.setCallOptionPrice(3.86);
		exp1.setPutOptionPrice(1.6);

		exp1.setDeltaCall(0.6568);
		exp1.setGamma(0.0560);
		exp1.setThetaCall(-12.4930);
		exp1.setVega(7.5468);
		exp1.setRhoCall(4.040076646);

		exp1.setDeltaPut(-0.3432);
		exp1.setThetaPut(-10.1035);
		exp1.setRhoPut(-2.506505483);

		OutputOptionInfo act1 = BSCalc.calc(input1);

		assertEquals("callOptionPrice", exp1.getCallOptionPrice(),
				act1.getCallOptionPrice(), 0.01);
		assertEquals("putOptionPrice", exp1.getPutOptionPrice(),
				act1.getPutOptionPrice(), 0.01);

		assertEquals("deltaCall", exp1.getDeltaCall(), act1.getDeltaCall(),
				0.0001);
		assertEquals("deltaPut", exp1.getDeltaPut(), act1.getDeltaPut(), 0.0001);

		assertEquals("gamma", exp1.getGamma(), act1.getGamma(), 0.0001);

		assertEquals("thetaCall", exp1.getThetaCall(), act1.getThetaCall(),
				0.0001);
		assertEquals("thetaPut", exp1.getThetaPut(), act1.getThetaPut(), 0.0001);

		assertEquals("vega", exp1.getVega(), act1.getVega(), 0.0001);

		assertEquals("rhoCall", exp1.getRhoCall(), act1.getRhoCall(), 0.000001);
		assertEquals("rhoPut", exp1.getRhoPut(), act1.getRhoPut(), 0.000001);

		// set up the input
		InputParameters input2 = new InputParameters(42.5, 40.0, 30 / 365.0,
				0.03, 0.50);

		// set up the expected output
		OutputOptionInfo exp2 = new OutputOptionInfo();

		exp2.setCallOptionPrice(3.88);
		exp2.setPutOptionPrice(1.28);

		exp2.setDeltaCall(0.6956);
		exp2.setGamma(0.0574);
		exp2.setThetaCall(-13.7407);
		exp2.setVega(4.2642);
		exp2.setRhoCall(2.111170598);

		exp2.setDeltaPut(-0.3044);
		exp2.setThetaPut(-12.5437);
		exp2.setRhoPut(-1.168404035);

		OutputOptionInfo act2 = BSCalc.calc(input2);

		assertEquals("callOptionPrice", exp2.getCallOptionPrice(),
				act2.getCallOptionPrice(), 0.01);
		assertEquals("putOptionPrice", exp2.getPutOptionPrice(),
				act2.getPutOptionPrice(), 0.01);

		assertEquals("deltaCall", exp2.getDeltaCall(), act2.getDeltaCall(),
				0.0001);
		assertEquals("deltaPut", exp2.getDeltaPut(), act2.getDeltaPut(), 0.0001);

		assertEquals("gamma", exp2.getGamma(), act2.getGamma(), 0.0001);

		assertEquals("thetaCall", exp2.getThetaCall(), act2.getThetaCall(),
				0.0001);
		assertEquals("thetaPut", exp2.getThetaPut(), act2.getThetaPut(), 0.0001);

		assertEquals("vega", exp2.getVega(), act2.getVega(), 0.0001);

		assertEquals("rhoCall", exp2.getRhoCall(), act2.getRhoCall(), 0.000001);
		assertEquals("rhoPut", exp2.getRhoPut(), act2.getRhoPut(), 0.000001);

		// test hash

		InputParameters input3 = new InputParameters(62.0, 60.0, 40 / 365.0,
				0.04, 0.32);
		InputParameters input4 = new InputParameters(62.0, 60.0, 40 / 365.0,
				0.04, 0.32);
		assertEquals("hash", input3, input4);
		assertEquals("hash", input3.hashCode(), input4.hashCode());
	}
}
