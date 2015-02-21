import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class BuildDecisionTreeExample {
	//build up the decision tree
		public static void decisionTree(ArrayList<ExampleNode> example1TrainingData, ArrayList<Integer> indexListExampleNode){
			
			int featureSize = example1TrainingData.get(0).getFeatures().length;
			
			boolean [] availableAttribute = new boolean [featureSize];
			
			for(int i=0;i<featureSize;i++){
				availableAttribute[i] = true;
			}
			
			decisionTree(example1TrainingData, featureSize, 0, availableAttribute, indexListExampleNode);
		}
		
		public static void decisionTree(ArrayList<ExampleNode> example1TrainingData, int featureSize, int depth, boolean [] availableAttribute, ArrayList<Integer> indexListExampleNode){
			
			
			//the stop condition
			if(depth >= 2){
				//according to the countYesFinal and countNoFinal to make the prediction of the hit
				int countYesFinal = 0;
				int countNoFinal = 0;
				for(ExampleNode temp : example1TrainingData){
					if(temp.getHit().equals("yes")){
						countYesFinal++;
					}
					else{
						countNoFinal++;
					}
					if(countYesFinal > countNoFinal){
						for(ExampleNode nodeTemp : example1TrainingData){
							nodeTemp.setPreditHit("yes");
						}
					}
					else{
						for(ExampleNode nodeTemp : example1TrainingData){
							nodeTemp.setPreditHit("no");
						}
					}
				}
				return;
			}
			
			int countYes = 0;
			int countNo = 0;
			
			//count the number of countYes and countNo
			for(ExampleNode tempNode: example1TrainingData){
				if(tempNode.getHit().equals("yes")){
					countYes++;
				}
				else{
					countNo++;
				}
			}
			
			//use double array to store the mutualInformation
			double [] mutualInformation = new double[availableAttribute.length];
			
			for(int i=0;i<mutualInformation.length;i++){
				if(availableAttribute[i] == true){
					mutualInformation[i] = helper(example1TrainingData, i);
				}
			}
			
			//find out the max in the array mutualInformation
			double maxMutualInformation = mutualInformation[0];
			int indexMax = 0;
			for(int i=0;i<mutualInformation.length;i++){
				if(mutualInformation[i] > maxMutualInformation){
					maxMutualInformation = mutualInformation[i];
					indexMax = i;
				}
			}
			
			//the gain function too small
			if(mutualInformation[indexMax] < 0.1){
				int countYesFinal = 0;
				int countNoFinal = 0;
				for(ExampleNode temp : example1TrainingData){
					if(temp.getHit().equals("yes")){
						countYesFinal++;
					}
					else{
						countNoFinal++;
					}
					if(countYesFinal > countNoFinal){
						for(ExampleNode nodeTemp : example1TrainingData){
							nodeTemp.setPreditHit("yes");
						}
					}
					else{
						for(ExampleNode nodeTemp : example1TrainingData){
							nodeTemp.setPreditHit("no");
						}
					}
				}
				return;
			}
			
			indexListExampleNode.add(indexMax);
//			indexListExampleNode.add(depth);
			
			availableAttribute[indexMax] = false;
			
			//use HashSet to figure out the size of the attribute, the attributeSize
			HashSet<String> attributeSet = new HashSet<String>();
			for(ExampleNode tempNode : example1TrainingData){
				attributeSet.add(tempNode.getFeatures()[indexMax]);
			}
					
			int attributeSize = attributeSet.size();
			
			//pop out the the attributeString from the HashSet
			String [] attributeString = new String[attributeSet.size()];
			int counter = 0;
			Iterator<String> it = attributeSet.iterator();
			while(it.hasNext()){
				attributeString[counter] = it.next();
				counter++;
			}
			
			//design a exampleNodeList to store different type of exampleNode
			ArrayList<ArrayList<ExampleNode>> exampleNodeList = new ArrayList<ArrayList<ExampleNode>>();
					
			//
			for(int i = 0 ; i<attributeSize;i++){
				exampleNodeList.add(new ArrayList<ExampleNode>());
			}
					
			for(ExampleNode tempNode : example1TrainingData){
				for(int i=0;i<attributeString.length;i++){
					if(tempNode.getFeatures()[indexMax].equals(attributeString[i])){
						exampleNodeList.get(i).add(tempNode);
					}
				}
			}
			
			
			if(depth == 0){
				System.out.println("["+countYes+"+"+"/"+countNo+"-"+"]");
			}
			
			//invoke the recursive function
			for(int i=0;i<exampleNodeList.size();i++){
				int countYesNext = 0;
				int countNoNext = 0;
				for(ExampleNode tempNode : exampleNodeList.get(i)){
					if(tempNode.getHit().equals("yes")){
						countYesNext++;
					}
					else{
						countNoNext++;
					}
				}
				if(depth < 2){
					for(int j=0;j<depth;j++){
						System.out.print("| ");
					}
					System.out.print(ExampleNode.getFeatureNames()[indexMax]+" = "+attributeString[i]+": ");
					System.out.println("["+countYesNext+"+"+"/"+countNoNext+"-"+"]");
				}
				
				//cloning process
				ArrayList<ExampleNode> clone = new ArrayList<ExampleNode>();
				
				for(int j=0;j<exampleNodeList.get(i).size();j++){
					clone.add(exampleNodeList.get(i).get(j));
				}
				
				//use clone
				boolean [] availableAttributeClone = availableAttribute.clone();
				
				decisionTree(exampleNodeList.get(i), featureSize, depth + 1, availableAttributeClone, indexListExampleNode);
			}
		}
		
		//to calculate the mutual information, just like the gain() function
		public static double helper(ArrayList<ExampleNode> exampleNodeDataSet, int attributeIndex){
			int countYes = 0;
			int countNo = 0;
			
			int attributeSize;
			
			//figure out the countYes and countNo
			for(ExampleNode tempNode:exampleNodeDataSet){
				if(tempNode.getHit().equals("yes")){
					countYes++;
				}
				else{
					countNo++;
				}
			}
			
			//use HashSet to figure out the size of the attribute, the attributeSize
			HashSet<String> attributeSet = new HashSet<String>();
			for(ExampleNode tempNode : exampleNodeDataSet){
				attributeSet.add(tempNode.getFeatures()[attributeIndex]);
			}
			
			attributeSize = attributeSet.size();
			
			//pop out the the attributeString from the HashSet
			String [] attributeString = new String[attributeSet.size()];
			int counter = 0;
			Iterator<String> it = attributeSet.iterator();
			while(it.hasNext()){
				attributeString[counter] = it.next();
				counter++;
			}

			//design a exampleNodeList to store different type of exampleNode
			ArrayList<ArrayList<ExampleNode>> exampleNodeList = new ArrayList<ArrayList<ExampleNode>>();
			
			//
			for(int i = 0 ; i<attributeSize;i++){
				exampleNodeList.add(new ArrayList<ExampleNode>());
			}
			
			for(ExampleNode tempNode : exampleNodeDataSet){
				for(int i=0;i<attributeString.length;i++){
					if(tempNode.getFeatures()[attributeIndex].equals(attributeString[i])){
						exampleNodeList.get(i).add(tempNode);
					}
				}
			}
			
			//print out
			
			double hEntropy;
			
			double pYes = 1.0*countYes/exampleNodeDataSet.size();
			double pNo = 1.0*countNo/exampleNodeDataSet.size();
			
			hEntropy = MyEntropy.myEntropy(pYes, pNo);

			double tempResult = 0;
			
			for(int i=0;i<attributeSize;i++){
				ArrayList<ExampleNode> tempNodeList = new ArrayList<ExampleNode>();
				tempNodeList = exampleNodeList.get(i);
				
				int countYesInAttribute = 0;
				int countNoInAttribute = 0;
				
				
				for(ExampleNode tempNode:tempNodeList){
					if(tempNode.getHit().equals("yes")){
						countYesInAttribute++;
					}
					else{
						countNoInAttribute++;
					}
				}
				
				double pYesInAttribute = 1.0 * countYesInAttribute/(countYesInAttribute+countNoInAttribute);
				double pNoInAttribute = 1.0 * countNoInAttribute/(countYesInAttribute+countNoInAttribute);

				double tempHEntropy = MyEntropy.myEntropy(pYesInAttribute,pNoInAttribute);
				
				tempResult += tempHEntropy * (1.0 * tempNodeList.size() / exampleNodeDataSet.size());

			}
			
			double finalResult;
			
			finalResult = hEntropy - tempResult;

			return finalResult;
		}
		
		public static int findMax(double [] mutualInformation){
			double max;
			int indexMax;
			
			max = mutualInformation[0];
			indexMax = 0;
			
			for(int i=0;i<mutualInformation.length;i++){
				if(mutualInformation[i] > max){
					max = mutualInformation[i];
					indexMax = i;
				}
			}
			return indexMax;
		}
}
