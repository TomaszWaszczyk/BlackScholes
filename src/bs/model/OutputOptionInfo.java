package bs.model;

public class OutputOptionInfo {
	@Override
	public boolean equals(Object obj) {
		OutputOptionInfo other = (OutputOptionInfo) obj;
		if (other.callOptionPrice == callOptionPrice
				&& other.putOptionPrice == putOptionPrice
				&& other.deltaCall == deltaCall && other.deltaPut == deltaPut
				&& other.gamma == gamma && other.vega == vega
				&& other.thetaCall == thetaCall && other.thetaPut == thetaPut
				&& other.rhoCall == rhoCall && other.rhoPut == rhoPut) {
			return true;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		int res;
		res = Double.valueOf(this.callOptionPrice).hashCode();
		res ^= Double.valueOf(this.putOptionPrice).hashCode();
		res ^= Double.valueOf(this.deltaCall).hashCode();
		res ^= Double.valueOf(this.deltaPut).hashCode();
		res ^= Double.valueOf(this.gamma).hashCode();
		res ^= Double.valueOf(this.vega).hashCode();
		res ^= Double.valueOf(this.thetaCall).hashCode();
		res ^= Double.valueOf(this.thetaPut).hashCode();
		res ^= Double.valueOf(this.rhoCall).hashCode();
		res ^= Double.valueOf(this.rhoPut).hashCode();
		return res;
	}

	// call and put price
	private double callOptionPrice;
	private double putOptionPrice;

	// greeks
	private double deltaCall;
	private double deltaPut;

	private double gamma;

	private double vega;

	private double thetaCall;
	private double thetaPut;

	private double rhoCall;
	private double rhoPut;

	public double getCallOptionPrice() {
		return callOptionPrice;
	}

	public void setCallOptionPrice(double callOptionPrice) {
		this.callOptionPrice = callOptionPrice;
	}

	public double getPutOptionPrice() {
		return putOptionPrice;
	}

	public void setPutOptionPrice(double putOptionPrice) {
		this.putOptionPrice = putOptionPrice;
	}

	public double getDeltaCall() {
		return deltaCall;
	}

	public void setDeltaCall(double deltaCall) {
		this.deltaCall = deltaCall;
	}

	public double getDeltaPut() {
		return deltaPut;
	}

	public void setDeltaPut(double deltaPut) {
		this.deltaPut = deltaPut;
	}

	public double getGamma() {
		return gamma;
	}

	public void setGamma(double gamma) {
		this.gamma = gamma;
	}

	public double getVega() {
		return vega;
	}

	public void setVega(double vega) {
		this.vega = vega;
	}

	public double getThetaCall() {
		return thetaCall;
	}

	public void setThetaCall(double thetaCall) {
		this.thetaCall = thetaCall;
	}

	public double getThetaPut() {
		return thetaPut;
	}

	public void setThetaPut(double thetaPut) {
		this.thetaPut = thetaPut;
	}

	public double getRhoCall() {
		return rhoCall;
	}

	public void setRhoCall(double rhoCall) {
		this.rhoCall = rhoCall;
	}

	public double getRhoPut() {
		return rhoPut;
	}

	public void setRhoPut(double rhoPut) {
		this.rhoPut = rhoPut;
	}
}
