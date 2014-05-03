package bs.controller;

import bs.model.InputParameters;
import bs.model.OutputOptionInfo;

public class BSCalc {

	/**
	 * normal distribution function
	 */
	private static double norm(double x) {
		return (1.0 / Math.sqrt(2 * Math.PI)) * Math.exp(-0.5 * x * x);
	}

	/**
	 * cumulative distribution function of the standard normal distribution
	 */
	private static double normC(double x) {
		// constants
		double a1 = 0.254829592;
		double a2 = -0.284496736;
		double a3 = 1.421413741;
		double a4 = -1.453152027;
		double a5 = 1.061405429;
		double p = 0.3275911;

		// Save the sign of x
		int sign = 1;
		if (x < 0)
			sign = -1;
		x = Math.abs(x) / Math.sqrt(2.0);

		// A&S formula 7.1.26
		double t = 1.0 / (1.0 + p * x);
		double y = 1.0 - (((((a5 * t + a4) * t) + a3) * t + a2) * t + a1) * t
				* Math.exp(-x * x);

		return 0.5 * (1.0 + sign * y);
	}

	/**
	 * Black-Scholes Model calculations
	 */
	public static OutputOptionInfo calc(InputParameters params) {
		OutputOptionInfo out = new OutputOptionInfo();

		double timeSqrt = Math.sqrt(params.getTime());

		// call option price
		double d1 = (Math.log(params.getSpotPrice() / params.getStrike()) + params
				.getRate() * params.getTime())
				/ (params.getVolatility() * timeSqrt)
				+ 0.5
				* params.getVolatility() * timeSqrt;
		double d2 = d1 - params.getVolatility() * timeSqrt;

		double normCd1 = normC(d1);
		double normCd2 = normC(d2);

		// Discounting rate
		double disc = Math.exp(-params.getRate() * params.getTime());

		out.setCallOptionPrice(normCd1 * params.getSpotPrice() - normCd2
				* params.getStrike() * disc);

		// put option price
		out.setPutOptionPrice(out.getCallOptionPrice() - params.getSpotPrice()
				+ params.getStrike() * disc);

		// call option delta
		out.setDeltaCall(normCd1);

		// put option delta
		out.setDeltaPut(out.getDeltaCall() - 1);

		double normd1 = norm(d1);

		// gamma
		out.setGamma(normd1
				/ (params.getSpotPrice() * params.getVolatility() * timeSqrt));

		// vega
		out.setVega(params.getSpotPrice() * timeSqrt * normd1);

		// call option theta
		out.setThetaCall(-(params.getSpotPrice() * params.getVolatility() * normd1)
				/ (2 * timeSqrt)
				- params.getRate()
				* params.getStrike()
				* disc
				* normC(d2));

		// put option theta
		out.setThetaPut(-(params.getSpotPrice() * params.getVolatility() * normd1)
				/ (2 * timeSqrt)
				+ params.getRate()
				* params.getStrike()
				* disc
				* normC(-d2));

		// call option rho
		out.setRhoCall(params.getStrike() * params.getTime() * disc * normC(d2));

		// put option rho
		out.setRhoPut(-params.getStrike() * params.getTime() * disc
				* normC(-d2));

		return out;
	}
}
