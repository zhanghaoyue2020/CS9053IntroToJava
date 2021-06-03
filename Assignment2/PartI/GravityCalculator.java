public class GravityCalculator {
	public static double calculatePosition(double initialVelocity, double fallingTime, double initialPosition) {
		double a = -9.81;
		double finalPosition;
		finalPosition = 0.5 * a * fallingTime * fallingTime + initialVelocity * fallingTime + initialPosition  ;
		return finalPosition;
	}
	public static void main(String[] args) {
		double initialVelocity = 0;
		double fallingTime = 10;
		double initialPosition = 0;
		double finalPosition = calculatePosition(initialVelocity, fallingTime, initialPosition);
		System.out.println("The object's position after " + fallingTime +" seconds is " + finalPosition + " m.");
	}
}