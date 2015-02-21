import java.util.ArrayList;


public class CountTestingErrorRateExampleNode {
	public static double countTestingErrorRate( ArrayList<ExampleNode> exampleTrainingData, ArrayList<ExampleNode> exampleTestingData , ArrayList<Integer> indexListExampleNode){
		
		if(indexListExampleNode.size() == 3){
			
			int contradictPredictTestingExampleNode = 0;
			for(ExampleNode tempNode: exampleTestingData){
				if(tempNode.getFeatures()[indexListExampleNode.get(0)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(0)).get(0))){
					if(tempNode.getFeatures()[indexListExampleNode.get(1)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(1)).get(0))){
						ExampleNode trainNode = new ExampleNode();
						for(ExampleNode temp:exampleTrainingData){
							if(temp.getFeatures()[indexListExampleNode.get(0)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(0)).get(0))  &&  temp.getFeatures()[indexListExampleNode.get(1)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getHit().equals(trainNode.getPreditHit())){
							contradictPredictTestingExampleNode++;
						}				
					}
					else{
						ExampleNode trainNode = new ExampleNode();
						for(ExampleNode temp:exampleTrainingData){
							if(temp.getFeatures()[indexListExampleNode.get(0)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(0)).get(0)) && temp.getFeatures()[indexListExampleNode.get(1)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getHit().equals(trainNode.getPreditHit())){
							contradictPredictTestingExampleNode++;
						}
					}
				}
				else{
					if(tempNode.getFeatures()[indexListExampleNode.get(2)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(2)).get(0))){
						ExampleNode trainNode = new ExampleNode();
						for(ExampleNode temp:exampleTrainingData){
							if(temp.getFeatures()[indexListExampleNode.get(0)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(0)).get(1)) && temp.getFeatures()[indexListExampleNode.get(2)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(2)).get(0))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getHit().equals(trainNode.getPreditHit())){
							contradictPredictTestingExampleNode++;
						}
					}
					else{
						ExampleNode trainNode = new ExampleNode();
						for(ExampleNode temp:exampleTrainingData){
							if(temp.getFeatures()[indexListExampleNode.get(0)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(0)).get(1)) && temp.getFeatures()[indexListExampleNode.get(2)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(2)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getHit().equals(trainNode.getPreditHit())){
							contradictPredictTestingExampleNode++;
						}
					}
				}
			}
			
			double testingErrorExampleNode = 1.0 * contradictPredictTestingExampleNode / exampleTestingData.size();
			
			return testingErrorExampleNode;
		}
		else{
			int contradictPredictTestingExampleNode = 0;
			for(ExampleNode tempNode: exampleTestingData){
				if(tempNode.getFeatures()[indexListExampleNode.get(0)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(0)).get(0))){
					if(tempNode.getFeatures()[indexListExampleNode.get(1)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(1)).get(0))){
						ExampleNode trainNode = new ExampleNode();
						for(ExampleNode temp:exampleTrainingData){
							if(temp.getFeatures()[indexListExampleNode.get(0)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(0)).get(0))  &&  temp.getFeatures()[indexListExampleNode.get(1)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getHit().equals(trainNode.getPreditHit())){
							contradictPredictTestingExampleNode++;
						}				
					}
					else{
						ExampleNode trainNode = new ExampleNode();
						for(ExampleNode temp:exampleTrainingData){
							if(temp.getFeatures()[indexListExampleNode.get(0)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(0)).get(0)) && temp.getFeatures()[indexListExampleNode.get(1)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getHit().equals(trainNode.getPreditHit())){
							contradictPredictTestingExampleNode++;
						}
					}
				}
				else{
					if(tempNode.getFeatures()[indexListExampleNode.get(1)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(1)).get(0))){
						ExampleNode trainNode = new ExampleNode();
						for(ExampleNode temp:exampleTrainingData){
							if(temp.getFeatures()[indexListExampleNode.get(0)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(0)).get(1)) && temp.getFeatures()[indexListExampleNode.get(1)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getHit().equals(trainNode.getPreditHit())){
							contradictPredictTestingExampleNode++;
						}
					}
					else{
						ExampleNode trainNode = new ExampleNode();
						for(ExampleNode temp:exampleTrainingData){
							if(temp.getFeatures()[indexListExampleNode.get(0)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(0)).get(1)) && temp.getFeatures()[indexListExampleNode.get(1)].equals(ExampleNode.getFeaturesType().get(indexListExampleNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getHit().equals(trainNode.getPreditHit())){
							contradictPredictTestingExampleNode++;
						}
					}
				}
			}
			
			double testingErrorExampleNode = 1.0 * contradictPredictTestingExampleNode / exampleTestingData.size();
			
			return testingErrorExampleNode;
		}
		
	}
}
