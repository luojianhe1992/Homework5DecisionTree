import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class BuildDecisionTreeEducation {
	
	public static void decisionTree(ArrayList<EducationNode> educationNodeTrainingData, ArrayList<Integer> indexList){
		
		int featureSize = educationNodeTrainingData.get(0).getFeatures().length;
		
		boolean [] availableAttribute = new boolean [featureSize];
		
		for(int i=0;i<featureSize;i++){
			availableAttribute[i] = true;
		}
		
		decisionTree(educationNodeTrainingData, featureSize, 0, availableAttribute, indexList);
	}
	
	public static void decisionTree(ArrayList<EducationNode> educationNodeTrainingData, int featureSize, int depth, boolean [] availableAttribute, ArrayList<Integer> indexList){
		
		//the stop condition
		if(depth >= 2){
			//according to the countYesFinal and countNoFinal to make the prediction of the hit
			int countYesFinal = 0;
			int countNoFinal = 0;
			
			for(EducationNode temp : educationNodeTrainingData){
				if(temp.getGrade().equals("A")){
					countYesFinal++;
				}
				else{
					countNoFinal++;
				}
				if(countYesFinal > countNoFinal){
					for(EducationNode nodeTemp : educationNodeTrainingData){
						nodeTemp.setPredictGrade("A");
					}
				}
				else{
					for(EducationNode nodeTemp : educationNodeTrainingData){
						nodeTemp.setPredictGrade("notA");
					}
				}
			}
			return;
		}
		
		int countYes = 0;
		int countNo = 0;
		
		//count the number of countYes and countNo
		for(EducationNode tempNode: educationNodeTrainingData){
			if(tempNode.getGrade().equals("A")){
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
				mutualInformation[i] = helper(educationNodeTrainingData, i);
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
			//according to the countYesFinal and countNoFinal to make the prediction of the hit
			int countYesFinal = 0;
			int countNoFinal = 0;
			
			for(EducationNode temp : educationNodeTrainingData){
				if(temp.getGrade().equals("A")){
					countYesFinal++;
				}
				else{
					countNoFinal++;
				}
				if(countYesFinal > countNoFinal){
					for(EducationNode nodeTemp : educationNodeTrainingData){
						nodeTemp.setPredictGrade("A");
					}
				}
				else{
					for(EducationNode nodeTemp : educationNodeTrainingData){
						nodeTemp.setPredictGrade("notA");
					}
				}
			}
			return;
		}
		
		//
		indexList.add(indexMax);
//		indexList.add(depth);
		
		availableAttribute[indexMax] = false;
		
		
		//use HashSet to figure out the size of the attribute, the attributeSize
		HashSet<String> attributeSet = new HashSet<String>();
		for(EducationNode tempNode : educationNodeTrainingData){
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
		ArrayList<ArrayList<EducationNode>> educationNodeList = new ArrayList<ArrayList<EducationNode>>();
				
		//
		for(int i = 0 ; i<attributeSize;i++){
			educationNodeList.add(new ArrayList<EducationNode>());
		}
				
		for(EducationNode tempNode : educationNodeTrainingData){
			for(int i=0;i<attributeString.length;i++){
				if(tempNode.getFeatures()[indexMax].equals(attributeString[i])){
					educationNodeList.get(i).add(tempNode);
				}
			}
		}
		
		if(depth == 0){
			System.out.println("["+countYes+"+"+"/"+countNo+"-"+"]");
		}
		
		for(int i=0;i<educationNodeList.size();i++){
			
			int countYesNext = 0;
			int countNoNext = 0;
			for(EducationNode tempNode : educationNodeList.get(i)){
				if(tempNode.getGrade().equals("A")){
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
				System.out.print(EducationNode.getFeatureNames()[indexMax]+" = "+attributeString[i]+": ");
				System.out.println("["+countYesNext+"+"+"/"+countNoNext+"-"+"]");
			}
			
			//use clone
			boolean [] availableAttributeClone = availableAttribute.clone();
			
			decisionTree(educationNodeList.get(i), featureSize, depth + 1, availableAttributeClone, indexList);
		}
	}
	
	//to calculate the mutual information, just like the gain() function
	public static double helper(ArrayList<EducationNode> educationNodeDataSet, int attributeIndex){
		int countYes = 0;
		int countNo = 0;
		
		int attributeSize;
		
		for(EducationNode tempNode : educationNodeDataSet){
			if(tempNode.getGrade().equals("A")){
				countYes++;
			}
			else{
				countNo++;
			}
		}
		
		//use HashSet to figure out the size of the attribute, the attributeSize
		HashSet<String> attributeSet = new HashSet<String>();
		for(EducationNode tempNode : educationNodeDataSet){
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

		ArrayList<ArrayList<EducationNode>> educationNodeList = new ArrayList<ArrayList<EducationNode>>();
		
		//
		for(int i = 0 ; i<attributeSize;i++){
			educationNodeList.add(new ArrayList<EducationNode>());
		}
		
		for(EducationNode tempNode : educationNodeDataSet){
			for(int i=0;i<attributeString.length;i++){
				if(tempNode.getFeatures()[attributeIndex].equals(attributeString[i])){
					educationNodeList.get(i).add(tempNode);
				}
			}
		}
		
		double hEntropy;
		
		double pYes = 1.0*countYes/educationNodeDataSet.size();
		double pNo = 1.0*countNo/educationNodeDataSet.size();
		
		hEntropy = MyEntropy.myEntropy(pYes, pNo);

		double tempResult = 0;
		
		for(int i=0;i<attributeSize;i++){
			ArrayList<EducationNode> tempNodeList = new ArrayList<EducationNode>();
			tempNodeList = educationNodeList.get(i);
			
			int countYesInAttribute = 0;
			int countNoInAttribute = 0;
			
			
			for(EducationNode tempNode:tempNodeList){
				if(tempNode.getGrade().equals("A")){
					countYesInAttribute++;
				}
				else{
					countNoInAttribute++;
				}
			}
			
			double pYesInAttribute = 1.0 * countYesInAttribute/(countYesInAttribute+countNoInAttribute);
			double pNoInAttribute = 1.0 * countNoInAttribute/(countYesInAttribute+countNoInAttribute);

			double tempHEntropy = MyEntropy.myEntropy(pYesInAttribute,pNoInAttribute);
			
			tempResult += tempHEntropy * (1.0 * tempNodeList.size() / educationNodeDataSet.size());
		}
		
		double finalResult;
		
		finalResult = hEntropy - tempResult;
		return finalResult;
	}
}
