import java.util.ArrayList;


public class inspect {

	public static void main(String[] args) {
		
		String TrainingDataName = args[0];
		
		ArrayList<NormalNode> TrainingData = new ArrayList<NormalNode>();
		
		
		TrainingData = DataReaderWithoutPacketNormalNode.parse(TrainingDataName);
		
		//
		int countYes = 0;
		int countNo = 0;
		
		for(NormalNode tempNode : TrainingData){
			if(tempNode.getLabel().equals(NormalNode.getFeaturesType().get(NormalNode.getFeaturesType().size() - 1).get(0))){
				countYes++;
			}
			else{
				countNo++;
			}
		}
		
		double p1 = 1.0*countYes/(countYes + countNo);
		double p2 = 1.0*countNo/(countYes + countNo);
	
		
		
		System.out.println("entropy: "+String.format("%.3f", MyEntropy.myEntropy(p1, p2)));
		
		if(countYes > countNo){
			System.out.println("error: "+1.0*countNo/TrainingData.size());
		}
		else{
			System.out.println("error: "+1.0*countYes/TrainingData.size());
		}
		
		
	}
}
