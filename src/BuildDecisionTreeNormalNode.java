import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class BuildDecisionTreeNormalNode {
	public static void decisionTree(ArrayList<NormalNode> normalNodeTrainingData, ArrayList<Integer> indexListNormalNode){
		
		//
		int featureSize = normalNodeTrainingData.get(0).getFeatures().length;
		
		//
		boolean [] availableAttribute = new boolean [featureSize];
		
		for(int i=0;i<featureSize;i++){
			availableAttribute[i] = true;
		}
		decisionTree(normalNodeTrainingData, featureSize, 0, availableAttribute, indexListNormalNode);
	}
	
	public static void decisionTree(ArrayList<NormalNode> normalNodeTrainingData, int featureSize, int depth, boolean [] availableAttribute, ArrayList<Integer> indexListNormalNode){
		
		//the stop condition
		if(depth >= 2){
			//according to the countYesFinal and countNoFinal to make the prediction of the hit
			int countYesFinal = 0;
			int countNoFinal = 0;
			for(NormalNode temp : normalNodeTrainingData){
				//
				if(temp.getLabel().equals(NormalNode.getFeaturesType().get(featureSize).get(0))){
					countYesFinal++;

					
				}
				else{
					countNoFinal++;
				}
				
				if(countYesFinal > countNoFinal){
					for(NormalNode nodeTemp : normalNodeTrainingData){
						nodeTemp.setPredictLabel(NormalNode.getFeaturesType().get(featureSize).get(0));
					}
				}
				else{
					for(NormalNode nodeTemp : normalNodeTrainingData){
						nodeTemp.setPredictLabel(NormalNode.getFeaturesType().get(featureSize).get(1));
					}
				}
			}
			return;
		}
		
		int countYes = 0;
		int countNo = 0;
		
		//count the number of countYes and countNo
		for(NormalNode tempNode: normalNodeTrainingData){
			if(tempNode.getLabel().equals(NormalNode.getFeaturesType().get(featureSize).get(0))){
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
				mutualInformation[i] = helper(normalNodeTrainingData, i);
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
			for(NormalNode temp : normalNodeTrainingData){
				if(temp.getLabel().equals(NormalNode.getFeaturesType().get(featureSize).get(0))){
					countYesFinal++;
				}
				else{
					countNoFinal++;
				}
				if(countYesFinal > countNoFinal){
					for(NormalNode nodeTemp : normalNodeTrainingData){
						nodeTemp.setPredictLabel(NormalNode.getFeaturesType().get(featureSize).get(0));
					}
				}
				else{
					for(NormalNode nodeTemp : normalNodeTrainingData){
						nodeTemp.setPredictLabel(NormalNode.getFeaturesType().get(featureSize).get(1));
					}
				}
			}
			return;
		}
		
		indexListNormalNode.add(indexMax);
//		indexListNormalNode.add(depth);
		
		availableAttribute[indexMax] = false;
		
		//use HashSet to figure out the size of the attribute, the attributeSize
		HashSet<String> attributeSet = new HashSet<String>();
		for(NormalNode tempNode : normalNodeTrainingData){
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
		
		//design a NormalNodeList to store different type of NormalNode
		ArrayList<ArrayList<NormalNode>> NormalNodeList = new ArrayList<ArrayList<NormalNode>>();
				
		//
		for(int i = 0 ; i<attributeSize;i++){
			NormalNodeList.add(new ArrayList<NormalNode>());
		}
				
		for(NormalNode tempNode : normalNodeTrainingData){
			for(int i=0;i<attributeString.length;i++){
				if(tempNode.getFeatures()[indexMax].equals(attributeString[i])){
					NormalNodeList.get(i).add(tempNode);
				}
			}
		}
		
		
		if(depth == 0){
			System.out.println("["+countYes+"+"+"/"+countNo+"-"+"]");
		}
		
		//invoke the recursive function
		for(int i=0;i<NormalNodeList.size();i++){
			int countYesNext = 0;
			int countNoNext = 0;
			for(NormalNode tempNode : NormalNodeList.get(i)){
				if(tempNode.getLabel().equals(NormalNode.getFeaturesType().get(featureSize).get(0))){
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
				System.out.print(NormalNode.getFeatureNames()[indexMax]+" = "+attributeString[i]+": ");
				System.out.println("["+countYesNext+"+"+"/"+countNoNext+"-"+"]");
			}
			
			//cloning process
			ArrayList<NormalNode> clone = new ArrayList<NormalNode>();
			
			for(int j=0;j<NormalNodeList.get(i).size();j++){
				clone.add(NormalNodeList.get(i).get(j));
			}
			
			//use clone
			boolean [] availableAttributeClone = availableAttribute.clone();
			
			decisionTree(NormalNodeList.get(i), featureSize, depth + 1, availableAttributeClone, indexListNormalNode);
		}
	}
	
	//to calculate the mutual information, just like the gain() function
	public static double helper(ArrayList<NormalNode> NormalNodeDataSet, int attributeIndex){
		int countYes = 0;
		int countNo = 0;
		
		int attributeSize;
		
		//figure out the countYes and countNo
		for(NormalNode tempNode:NormalNodeDataSet){
			if(tempNode.getLabel().equals(NormalNode.getFeaturesType().get(NormalNode.getFeaturesType().size() - 1).get(0))){
				countYes++;
			}
			else{
				countNo++;
			}
		}
		
		//use HashSet to figure out the size of the attribute, the attributeSize
		HashSet<String> attributeSet = new HashSet<String>();
		for(NormalNode tempNode : NormalNodeDataSet){
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

		//design a NormalNodeList to store different type of NormalNode
		ArrayList<ArrayList<NormalNode>> NormalNodeList = new ArrayList<ArrayList<NormalNode>>();
		
		//
		for(int i = 0 ; i<attributeSize;i++){
			NormalNodeList.add(new ArrayList<NormalNode>());
		}
		
		for(NormalNode tempNode : NormalNodeDataSet){
			for(int i=0;i<attributeString.length;i++){
				if(tempNode.getFeatures()[attributeIndex].equals(attributeString[i])){
					NormalNodeList.get(i).add(tempNode);
				}
			}
		}
		
		//print out
		
		double hEntropy;
		
		double pYes = 1.0*countYes/NormalNodeDataSet.size();
		double pNo = 1.0*countNo/NormalNodeDataSet.size();
		
		hEntropy = MyEntropy.myEntropy(pYes, pNo);

		double tempResult = 0;
		
		for(int i=0;i<attributeSize;i++){
			ArrayList<NormalNode> tempNodeList = new ArrayList<NormalNode>();
			tempNodeList = NormalNodeList.get(i);
			
			int countYesInAttribute = 0;
			int countNoInAttribute = 0;
			
			
			for(NormalNode tempNode:tempNodeList){
				if(tempNode.getLabel().equals(NormalNode.getFeaturesType().get(NormalNode.getFeaturesType().size() - 1).get(0))){
					countYesInAttribute++;
				}
				else{
					countNoInAttribute++;
				}
			}
			
			double pYesInAttribute = 1.0 * countYesInAttribute/(countYesInAttribute+countNoInAttribute);
			double pNoInAttribute = 1.0 * countNoInAttribute/(countYesInAttribute+countNoInAttribute);

			double tempHEntropy = MyEntropy.myEntropy(pYesInAttribute,pNoInAttribute);
			
			tempResult += tempHEntropy * (1.0 * tempNodeList.size() / NormalNodeDataSet.size());

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
