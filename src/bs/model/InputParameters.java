package bs.model;

public class InputParameters {

	@Override
	public boolean equals(Object obj) {
		InputParameters other = (InputParameters) obj;
		if (other.spotPrice == spotPrice && other.strike == strike
				&& other.time == time && other.rate == rate
				&& other.volatility == volatility) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int res;
		res = Double.valueOf(this.spotPrice).hashCode();
		res ^= Double.valueOf(this.strike).hashCode();
		res ^= Double.valueOf(this.time).hashCode();
		res ^= Double.valueOf(this.rate).hashCode();
		res ^= Double.valueOf(this.volatility).hashCode();

		return res;
	}

	/**
	 * time to maturity in years (e.g. 30/365)
	 */
	private double time;

	/**
	 * spot price of the underlying asset
	 */
	private double spotPrice;

	/**
	 * strike price
	 */
	private double strike;

	/**
	 * risk free rate (annual rate)
	 */
	private double rate;

	/**
	 * volatility of returns of the underlying asset
	 */
	private double volatility;

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getSpotPrice() {
		return spotPrice;
	}

	public void setSpotPrice(double spotPrice) {
		this.spotPrice = spotPrice;
	}

	public double getStrike() {
		return strike;
	}

	public void setStrike(double strike) {
		this.strike = strike;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getVolatility() {
		return volatility;
	}

	public void setVolatility(double volatility) {
		this.volatility = volatility;
	}

	public InputParameters(double spotPrice, double strike, double time,
			double rate, double volatility) {
		this.spotPrice = spotPrice;
		this.strike = strike;
		this.time = time;
		this.rate = rate;
		this.volatility = volatility;
	}
}
