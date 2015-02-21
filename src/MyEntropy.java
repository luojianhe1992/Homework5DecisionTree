
public class MyEntropy {
	
	public static double myEntropy(double p1, double p2){
		double result;
		if(p1 == 0){
			return p2 * myLog(2, 1.0/p2);
		}
		else if(p2 == 0){
			return p1 * myLog(2, 1.0/p1);
		}
		else{
			result = p1 * myLog(2, 1.0/p1) + p2 * myLog(2, 1.0/p2);
			return result;
		}
	}
	
	public static double myEntropy(double p1, double p2, double p3){
		double result;
		
		if(p1 == 0){
			return p2 * myLog(2, 1.0/p2);
		}
		else if(p2 == 0){
			return p1 * myLog(2, 1.0/p1);
		}
		else if(p3 == 0){
			return p3 * myLog(2, 1.0/p3);
		}
		else{
			result = p1 * myLog(2, 1.0/p1) + p2 * myLog(2, 1.0/p2) + p3 * myLog(2, 1.0/p3);
			return result;
		}
	}
	
	public static double myLog(double m, double n){
		double result;
		result = Math.log(n)/Math.log(m);
		return result;
	}
}
