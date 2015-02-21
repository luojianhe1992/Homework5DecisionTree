import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class BuildDecisionTreeMyClass {
	public static void decisionTree(ArrayList<MyClass> myClassTrainingData, ArrayList<Integer> indexListMyClass){
		
		int featureSize = myClassTrainingData.get(0).getFeatures().length;
		
		boolean [] availableAttribute = new boolean [featureSize];
		
		for(int i=0;i<featureSize;i++){
			availableAttribute[i] = true;
		}
		decisionTree(myClassTrainingData, featureSize, 0, availableAttribute, indexListMyClass);
	}
	
	public static void decisionTree(ArrayList<MyClass> myClassTrainingData, int featureSize, int depth, boolean [] availableAttribute, ArrayList<Integer> indexListMyClass){
		
		//the stop condition
		if(depth >= 2){
			//according to the countYesFinal and countNoFinal to make the prediction of the hit
			int countYesFinal = 0;
			int countNoFinal = 0;
			for(MyClass temp : myClassTrainingData){
				if(temp.getLabel().equals("yes")){
					countYesFinal++;
				}
				else{
					countNoFinal++;
				}
				if(countYesFinal > countNoFinal){
					for(MyClass nodeTemp : myClassTrainingData){
						nodeTemp.setPredictLabel("yes");
					}
				}
				else{
					for(MyClass nodeTemp : myClassTrainingData){
						nodeTemp.setPredictLabel("no");
					}
				}
			}
			return;
		}
		
		int countYes = 0;
		int countNo = 0;
		
		//count the number of countYes and countNo
		for(MyClass tempNode: myClassTrainingData){
			if(tempNode.getLabel().equals("yes")){
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
				mutualInformation[i] = helper(myClassTrainingData, i);
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
			for(MyClass temp : myClassTrainingData){
				if(temp.getLabel().equals("yes")){
					countYesFinal++;
				}
				else{
					countNoFinal++;
				}
				if(countYesFinal > countNoFinal){
					for(MyClass nodeTemp : myClassTrainingData){
						nodeTemp.setPredictLabel("yes");
					}
				}
				else{
					for(MyClass nodeTemp : myClassTrainingData){
						nodeTemp.setPredictLabel("no");
					}
				}
			}
			return;
		}
		
		indexListMyClass.add(indexMax);
		
		availableAttribute[indexMax] = false;
		
		//use HashSet to figure out the size of the attribute, the attributeSize
		HashSet<String> attributeSet = new HashSet<String>();
		for(MyClass tempNode : myClassTrainingData){
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
		
		//design a MyClassList to store different type of MyClass
		ArrayList<ArrayList<MyClass>> MyClassList = new ArrayList<ArrayList<MyClass>>();
				
		//
		for(int i = 0 ; i<attributeSize;i++){
			MyClassList.add(new ArrayList<MyClass>());
		}
				
		for(MyClass tempNode : myClassTrainingData){
			for(int i=0;i<attributeString.length;i++){
				if(tempNode.getFeatures()[indexMax].equals(attributeString[i])){
					MyClassList.get(i).add(tempNode);
				}
			}
		}
		
		if(depth == 0){
			System.out.println("["+countYes+"+"+"/"+countNo+"-"+"]");
		}
		
		//invoke the recursive function
		for(int i=0;i<MyClassList.size();i++){
			int countYesNext = 0;
			int countNoNext = 0;
			for(MyClass tempNode : MyClassList.get(i)){
				if(tempNode.getLabel().equals("yes")){
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
				System.out.print(MyClass.getFeatureNames()[indexMax]+" = "+attributeString[i]+": ");
				System.out.println("["+countYesNext+"+"+"/"+countNoNext+"-"+"]");
			}
			
			//cloning process
			ArrayList<MyClass> clone = new ArrayList<MyClass>();
			
			for(int j=0;j<MyClassList.get(i).size();j++){
				clone.add(MyClassList.get(i).get(j));
			}
			
			//use clone
			boolean [] availableAttributeClone = availableAttribute.clone();
			
			decisionTree(MyClassList.get(i), featureSize, depth + 1, availableAttributeClone, indexListMyClass);
		}
	}
	
	//to calculate the mutual information, just like the gain() function
	public static double helper(ArrayList<MyClass> MyClassDataSet, int attributeIndex){
		int countYes = 0;
		int countNo = 0;
		
		int attributeSize;
		
		//figure out the countYes and countNo
		for(MyClass tempNode:MyClassDataSet){
			if(tempNode.getLabel().equals("yes")){
				countYes++;
			}
			else{
				countNo++;
			}
		}
		
		//use HashSet to figure out the size of the attribute, the attributeSize
		HashSet<String> attributeSet = new HashSet<String>();
		for(MyClass tempNode : MyClassDataSet){
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

		//design a MyClassList to store different type of MyClass
		ArrayList<ArrayList<MyClass>> MyClassList = new ArrayList<ArrayList<MyClass>>();
		
		//
		for(int i = 0 ; i<attributeSize;i++){
			MyClassList.add(new ArrayList<MyClass>());
		}
		
		for(MyClass tempNode : MyClassDataSet){
			for(int i=0;i<attributeString.length;i++){
				if(tempNode.getFeatures()[attributeIndex].equals(attributeString[i])){
					MyClassList.get(i).add(tempNode);
				}
			}
		}
		
		//print out
		
		double hEntropy;
		
		double pYes = 1.0*countYes/MyClassDataSet.size();
		double pNo = 1.0*countNo/MyClassDataSet.size();
		
		hEntropy = MyEntropy.myEntropy(pYes, pNo);

		double tempResult = 0;
		
		for(int i=0;i<attributeSize;i++){
			ArrayList<MyClass> tempNodeList = new ArrayList<MyClass>();
			tempNodeList = MyClassList.get(i);
			
			int countYesInAttribute = 0;
			int countNoInAttribute = 0;
			
			
			for(MyClass tempNode:tempNodeList){
				if(tempNode.getLabel().equals("yes")){
					countYesInAttribute++;
				}
				else{
					countNoInAttribute++;
				}
			}
			
			double pYesInAttribute = 1.0 * countYesInAttribute/(countYesInAttribute+countNoInAttribute);
			double pNoInAttribute = 1.0 * countNoInAttribute/(countYesInAttribute+countNoInAttribute);

			double tempHEntropy = MyEntropy.myEntropy(pYesInAttribute,pNoInAttribute);
			
			tempResult += tempHEntropy * (1.0 * tempNodeList.size() / MyClassDataSet.size());

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
