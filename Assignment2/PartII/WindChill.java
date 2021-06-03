public class WindChill {
	public static double windChill(double t, double v) {
		//w = 35.74 + 0.6215 t + (0.4275 t - 35.75) v0.16
		double w;
		w = 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v,0.16);
		return w;
	}
	public static void main(String[] args) {
		double temp = 22;
		double windSpeed = 15;
		double windChillTemp;
		windChillTemp = windChill(temp, windSpeed);
		// if the wind chill is valid:
		if ((-50 <= temp)&&(temp <= 50)&&(3 <= windSpeed)&&(windSpeed <= 110)) {
			System.out.println("For a temperature of " + temp +	" with wind speed of " + windSpeed + ", the wind chill is " + windChillTemp);
		}
		// if the wind chill is not valid:
		else
		System.out.println("Cannot calculate a valid wind chill for this temperate and/or wind speed");
	}
}