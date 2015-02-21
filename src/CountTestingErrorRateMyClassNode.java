import java.util.ArrayList;


public class CountTestingErrorRateMyClassNode {
public static double countTestingErrorRate( ArrayList<MyClass> myClassTrainingData, ArrayList<MyClass> myClassTestingData , ArrayList<Integer> indexListMyClass){
		
		if(indexListMyClass.size() == 3){
			
			int contradictPredictTestingMyClass = 0;
			for(MyClass tempNode: myClassTestingData){
				if(tempNode.getFeatures()[indexListMyClass.get(0)].equals(MyClass.getFeatureType().get(indexListMyClass.get(0)).get(0))){
					if(tempNode.getFeatures()[indexListMyClass.get(1)].equals(MyClass.getFeatureType().get(indexListMyClass.get(1)).get(0))){
						MyClass trainNode = new MyClass();
						for(MyClass temp:myClassTrainingData){
							if(temp.getFeatures()[indexListMyClass.get(0)].equals(MyClass.getFeatureType().get(indexListMyClass.get(0)).get(0))  &&  temp.getFeatures()[indexListMyClass.get(1)].equals(MyClass.getFeatureType().get(indexListMyClass.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingMyClass++;
						}				
					}
					else{
						MyClass trainNode = new MyClass();
						for(MyClass temp:myClassTrainingData){
							if(temp.getFeatures()[indexListMyClass.get(0)].equals(MyClass.getFeatureType().get(indexListMyClass.get(0)).get(0)) && temp.getFeatures()[indexListMyClass.get(1)].equals(MyClass.getFeatureType().get(indexListMyClass.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingMyClass++;
						}
					}
				}
				else{
					if(tempNode.getFeatures()[indexListMyClass.get(2)].equals(MyClass.getFeatureType().get(indexListMyClass.get(2)).get(0))){
						MyClass trainNode = new MyClass();
						for(MyClass temp:myClassTrainingData){
							if(temp.getFeatures()[indexListMyClass.get(0)].equals(MyClass.getFeatureType().get(indexListMyClass.get(0)).get(1)) && temp.getFeatures()[indexListMyClass.get(2)].equals(MyClass.getFeatureType().get(indexListMyClass.get(2)).get(0))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingMyClass++;
						}
					}
					else{
						MyClass trainNode = new MyClass();
						for(MyClass temp:myClassTrainingData){
							if(temp.getFeatures()[indexListMyClass.get(0)].equals(MyClass.getFeatureType().get(indexListMyClass.get(0)).get(1)) && temp.getFeatures()[indexListMyClass.get(2)].equals(MyClass.getFeatureType().get(indexListMyClass.get(2)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingMyClass++;
						}
					}
				}
			}
			
			double testingErrorMyClass = 1.0 * contradictPredictTestingMyClass / myClassTestingData.size();
			
			return testingErrorMyClass;
		}
		else{
			int contradictPredictTestingMyClass = 0;
			for(MyClass tempNode: myClassTestingData){
				if(tempNode.getFeatures()[indexListMyClass.get(0)].equals(MyClass.getFeatureType().get(indexListMyClass.get(0)).get(0))){
					if(tempNode.getFeatures()[indexListMyClass.get(1)].equals(MyClass.getFeatureType().get(indexListMyClass.get(1)).get(0))){
						MyClass trainNode = new MyClass();
						for(MyClass temp:myClassTrainingData){
							if(temp.getFeatures()[indexListMyClass.get(0)].equals(MyClass.getFeatureType().get(indexListMyClass.get(0)).get(0))  &&  temp.getFeatures()[indexListMyClass.get(1)].equals(MyClass.getFeatureType().get(indexListMyClass.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingMyClass++;
						}				
					}
					else{
						MyClass trainNode = new MyClass();
						for(MyClass temp:myClassTrainingData){
							if(temp.getFeatures()[indexListMyClass.get(0)].equals(MyClass.getFeatureType().get(indexListMyClass.get(0)).get(0)) && temp.getFeatures()[indexListMyClass.get(1)].equals(MyClass.getFeatureType().get(indexListMyClass.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingMyClass++;
						}
					}
				}
				else{
					if(tempNode.getFeatures()[indexListMyClass.get(1)].equals(MyClass.getFeatureType().get(indexListMyClass.get(1)).get(0))){
						MyClass trainNode = new MyClass();
						for(MyClass temp:myClassTrainingData){
							if(temp.getFeatures()[indexListMyClass.get(0)].equals(MyClass.getFeatureType().get(indexListMyClass.get(0)).get(1)) && temp.getFeatures()[indexListMyClass.get(1)].equals(MyClass.getFeatureType().get(indexListMyClass.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingMyClass++;
						}
					}
					else{
						MyClass trainNode = new MyClass();
						for(MyClass temp:myClassTrainingData){
							if(temp.getFeatures()[indexListMyClass.get(0)].equals(MyClass.getFeatureType().get(indexListMyClass.get(0)).get(1)) && temp.getFeatures()[indexListMyClass.get(1)].equals(MyClass.getFeatureType().get(indexListMyClass.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getLabel().equals(trainNode.getPredictLabel())){
							contradictPredictTestingMyClass++;
						}
					}
				}
			}
			
			double testingErrorMyClass = 1.0 * contradictPredictTestingMyClass / myClassTestingData.size();
			return testingErrorMyClass;
		}
	}
}
