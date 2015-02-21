import java.util.ArrayList;


public class decisionTree {
	public static void main(String[] args) {
		String trainingDataName = args[0];
		String testingDataName = args[1];
		
		
		ArrayList<NormalNode> trainingData = new ArrayList<NormalNode>();
		ArrayList<NormalNode> testingData = new ArrayList<NormalNode>();
		
		trainingData = DataReaderWithoutPacketNormalNode.parse(trainingDataName);
		testingData = DataReaderWithoutPacketNormalNode.parse(testingDataName);
		
		
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		
		BuildDecisionTreeNormalNode.decisionTree(trainingData, indexList);
		
		int contradictPredictTrainingNormalNode = 0;
		
		for(NormalNode tempNode:trainingData){
			if( !tempNode.getLabel().equals(tempNode.getPredictLabel())){
				contradictPredictTrainingNormalNode++;
			}
		}
		
		double trainErrorNormalNode = 1.0 * contradictPredictTrainingNormalNode / trainingData.size();
		System.out.println("error(train) : "+trainErrorNormalNode);
		System.out.println("error(test):"+CountTestingErrorRateNormalNode.countTestingErrorRate(trainingData,testingData, indexList));
		
	}
}
