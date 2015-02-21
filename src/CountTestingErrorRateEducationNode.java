import java.util.ArrayList;


public class CountTestingErrorRateEducationNode {
	public static double countTestingErrorRate( ArrayList<EducationNode> educationTrainingData, ArrayList<EducationNode> educationTestingData , ArrayList<Integer> indexListEducationNode){
		
		if(indexListEducationNode.size() == 3){
			int contradictPredictTestingEducationNode = 0;
			
			for(EducationNode tempNode: educationTestingData){
				if(tempNode.getFeatures()[indexListEducationNode.get(0)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(0)).get(0))){
					if(tempNode.getFeatures()[indexListEducationNode.get(1)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(1)).get(0))){
						EducationNode trainNode = new EducationNode();
						for(EducationNode temp:educationTrainingData){
							if(temp.getFeatures()[indexListEducationNode.get(0)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(0)).get(0)) && temp.getFeatures()[indexListEducationNode.get(1)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getGrade().equals(trainNode.getPredictGrade())){
							contradictPredictTestingEducationNode++;
						}				
					}
					else{
						EducationNode trainNode = new EducationNode();
						for(EducationNode temp:educationTrainingData){
							if(temp.getFeatures()[indexListEducationNode.get(0)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(0)).get(0)) && temp.getFeatures()[indexListEducationNode.get(1)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getGrade().equals(trainNode.getPredictGrade())){
							contradictPredictTestingEducationNode++;
						}
					}
				}
				else{
					if(tempNode.getFeatures()[indexListEducationNode.get(2)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(2)).get(0))){
						EducationNode trainNode = new EducationNode();
						for(EducationNode temp:educationTrainingData){
							if(temp.getFeatures()[indexListEducationNode.get(0)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(0)).get(1)) && temp.getFeatures()[indexListEducationNode.get(2)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(2)).get(0))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getGrade().equals(trainNode.getPredictGrade())){
							contradictPredictTestingEducationNode++;
						}
					}
					else{
						EducationNode trainNode = new EducationNode();
						for(EducationNode temp:educationTrainingData){
							if(temp.getFeatures()[indexListEducationNode.get(0)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(0)).get(1)) && temp.getFeatures()[indexListEducationNode.get(2)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(2)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getGrade().equals(trainNode.getPredictGrade())){
							contradictPredictTestingEducationNode++;
						}
					}
				}
			}
			
			double testingErrorEducationNode = 1.0 * contradictPredictTestingEducationNode / educationTestingData.size();
			
			return testingErrorEducationNode;
		}
		else{
			int contradictPredictTestingEducationNode = 0;
			
			for(EducationNode tempNode: educationTestingData){
				if(tempNode.getFeatures()[indexListEducationNode.get(0)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(0)).get(0))){
					if(tempNode.getFeatures()[indexListEducationNode.get(1)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(1)).get(0))){
						EducationNode trainNode = new EducationNode();
						for(EducationNode temp:educationTrainingData){
							if(temp.getFeatures()[indexListEducationNode.get(0)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(0)).get(0)) && temp.getFeatures()[indexListEducationNode.get(1)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getGrade().equals(trainNode.getPredictGrade())){
							contradictPredictTestingEducationNode++;
						}				
					}
					else{
						EducationNode trainNode = new EducationNode();
						for(EducationNode temp:educationTrainingData){
							if(temp.getFeatures()[indexListEducationNode.get(0)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(0)).get(0)) && temp.getFeatures()[indexListEducationNode.get(1)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getGrade().equals(trainNode.getPredictGrade())){
							contradictPredictTestingEducationNode++;
						}
					}
				}
				else{
					if(tempNode.getFeatures()[indexListEducationNode.get(1)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(1)).get(0))){
						EducationNode trainNode = new EducationNode();
						for(EducationNode temp:educationTrainingData){
							if(temp.getFeatures()[indexListEducationNode.get(0)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(0)).get(1)) && temp.getFeatures()[indexListEducationNode.get(1)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getGrade().equals(trainNode.getPredictGrade())){
							contradictPredictTestingEducationNode++;
						}
					}
					else{
						EducationNode trainNode = new EducationNode();
						for(EducationNode temp:educationTrainingData){
							if(temp.getFeatures()[indexListEducationNode.get(0)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(0)).get(1)) && temp.getFeatures()[indexListEducationNode.get(1)].equals(EducationNode.getFeaturesType().get(indexListEducationNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getGrade().equals(trainNode.getPredictGrade())){
							contradictPredictTestingEducationNode++;
						}
					}
				}
			}
			
			double testingErrorEducationNode = 1.0 * contradictPredictTestingEducationNode / educationTestingData.size();
			
			return testingErrorEducationNode;
		}
		
		
	}
}
