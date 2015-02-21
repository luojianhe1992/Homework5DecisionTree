import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class DataReaderWithoutPacketEducationNode {
	public static ArrayList<EducationNode> parse(String path) {
		return parse(path, 1, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10);
	}
	
	//override function
	public static ArrayList<EducationNode> parse(String path, int skipline, int[] featureColumnIndex, int labelColumn) {
		
		//using a ArrayList<KnnNode> to store the training data
		ArrayList<EducationNode> result = new ArrayList<EducationNode>();

		//initialize the InputStream
		InputStream stream = DataReaderWithoutPacketEducationNode.class.getClassLoader().getResourceAsStream(path);
		
		
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new InputStreamReader(stream));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		String line = null;

		int counter = 0;
		
		try {
			
			ArrayList<HashSet<String>> attributeValuesList = new ArrayList<HashSet<String>>();
			for(int i = 0;i<featureColumnIndex.length;i++){
				attributeValuesList.add(new HashSet<String>());
			}
			
			// read the line one by one
			while ((line = br.readLine()) != null) {

				if(counter == 0){
					String[] split = line.split(",");
					String [] featureNames = new String[featureColumnIndex.length];
					for(int i=0;i<featureNames.length;i++){
						String name = split[featureColumnIndex[i]];
						featureNames[i] = name;
					}
					
					EducationNode.setFeatureNames(featureNames);
					
					counter++;
					
					continue;
				}
				// split
				String[] split = line.split(",");

				
				EducationNode tempNode = new EducationNode();
				
				String [] features = new String [split.length - 1];
				for(int i =0; i<split.length - 1;i++){
					features[i] = split[i];
				}
				tempNode.setFeatures(features);
				
				tempNode.setM1(split[0]);
				tempNode.setM2(split[1]);
				tempNode.setM3(split[2]);
				tempNode.setM4(split[3]);
				tempNode.setM5(split[4]);
				tempNode.setP1(split[5]);
				tempNode.setP2(split[6]);
				tempNode.setP3(split[7]);
				tempNode.setP4(split[8]);
				tempNode.setF(split[9]);
				
				//
				for(int i = 0;i<featureColumnIndex.length;i++){
					attributeValuesList.get(i).add(split[i]);
				}
				
				tempNode.setGrade(split[labelColumn]);
				
				result.add(tempNode);
				
				counter++;
			}
			
			ArrayList<ArrayList<String>> tempList = new ArrayList<ArrayList<String>>();
			for(int i = 0;i<attributeValuesList.size();i++){
				tempList.add(new ArrayList<String>());
			}
			for(int i = 0;i<attributeValuesList.size();i++){
				Iterator<String> it = attributeValuesList.get(i).iterator();
				while(it.hasNext()){
					tempList.get(i).add(it.next());
				}
			}
			EducationNode.setFeaturesType(tempList);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		// close the bufferedreader
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
