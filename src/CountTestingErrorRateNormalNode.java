import java.util.ArrayList;


public class CountTestingErrorRateNormalNode {
	
	public static double countTestingErrorRate( ArrayList<NormalNode> normalNodeTrainingData, ArrayList<NormalNode> normalNodeTestingData , ArrayList<Integer> indexListNormalNode){
		
		if(indexListNormalNode.size() == 3){
			
			int contradictPredictTestingNormalNode = 0;
			for(NormalNode tempNode: normalNodeTestingData){
				if(tempNode.getFeatures()[indexListNormalNode.get(0)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(0)).get(0))){
					if(tempNode.getFeatures()[indexListNormalNode.get(1)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(1)).get(0))){
						NormalNode trainNode = new NormalNode();
						for(NormalNode temp:normalNodeTrainingData){
							if(temp.getFeatures()[indexListNormalNode.get(0)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(0)).get(0))  &&  temp.getFeatures()[indexListNormalNode.get(1)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingNormalNode++;
						}				
					}
					else{
						NormalNode trainNode = new NormalNode();
						for(NormalNode temp:normalNodeTrainingData){
							if(temp.getFeatures()[indexListNormalNode.get(0)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(0)).get(0)) && temp.getFeatures()[indexListNormalNode.get(1)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingNormalNode++;
						}
					}
				}
				else{
					if(tempNode.getFeatures()[indexListNormalNode.get(2)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(2)).get(0))){
						NormalNode trainNode = new NormalNode();
						for(NormalNode temp:normalNodeTrainingData){
							if(temp.getFeatures()[indexListNormalNode.get(0)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(0)).get(1)) && temp.getFeatures()[indexListNormalNode.get(2)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(2)).get(0))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingNormalNode++;
						}
					}
					else{
						NormalNode trainNode = new NormalNode();
						for(NormalNode temp:normalNodeTrainingData){
							if(temp.getFeatures()[indexListNormalNode.get(0)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(0)).get(1)) && temp.getFeatures()[indexListNormalNode.get(2)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(2)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingNormalNode++;
						}
					}
				}
			}
			
			double testingErrorNormalNode = 1.0 * contradictPredictTestingNormalNode / normalNodeTestingData.size();
			
			return testingErrorNormalNode;
		}
		else{
			int contradictPredictTestingNormalNode = 0;
			for(NormalNode tempNode: normalNodeTestingData){
				if(tempNode.getFeatures()[indexListNormalNode.get(0)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(0)).get(0))){
					if(tempNode.getFeatures()[indexListNormalNode.get(1)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(1)).get(0))){
						NormalNode trainNode = new NormalNode();
						for(NormalNode temp:normalNodeTrainingData){
							if(temp.getFeatures()[indexListNormalNode.get(0)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(0)).get(0))  &&  temp.getFeatures()[indexListNormalNode.get(1)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingNormalNode++;
						}				
					}
					else{
						NormalNode trainNode = new NormalNode();
						for(NormalNode temp:normalNodeTrainingData){
							if(temp.getFeatures()[indexListNormalNode.get(0)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(0)).get(0)) && temp.getFeatures()[indexListNormalNode.get(1)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingNormalNode++;
						}
					}
				}
				else{
					if(tempNode.getFeatures()[indexListNormalNode.get(1)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(1)).get(0))){
						NormalNode trainNode = new NormalNode();
						for(NormalNode temp:normalNodeTrainingData){
							if(temp.getFeatures()[indexListNormalNode.get(0)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(0)).get(1)) && temp.getFeatures()[indexListNormalNode.get(1)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingNormalNode++;
						}
					}
					else{
						NormalNode trainNode = new NormalNode();
						for(NormalNode temp:normalNodeTrainingData){
							if(temp.getFeatures()[indexListNormalNode.get(0)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(0)).get(1)) && temp.getFeatures()[indexListNormalNode.get(1)].equals(NormalNode.getFeaturesType().get(indexListNormalNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingNormalNode++;
						}
					}
				}
			}
			
			double testingErrorNormalNode = 1.0 * contradictPredictTestingNormalNode / normalNodeTestingData.size();
			
			return testingErrorNormalNode;
		}
		
	}
}
