import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class DataReaderWithoutPacketMyClassNode {
	public static ArrayList<MyClass> parse(String path) {
		return parse(path, 1, new int[] { 0, 1, 2, 3, 4, 5}, 6);
	}
	
	//override function
	public static ArrayList<MyClass> parse(String path, int skipline, int[] featureColumnIndex, int labelColumn) {
		
		//using a ArrayList<KnnNode> to store the training data
		ArrayList<MyClass> result = new ArrayList<MyClass>();

		//initialize the InputStream
		InputStream stream = DataReaderWithoutPacketMyClassNode.class.getClassLoader().getResourceAsStream(path);
		
		
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
					
					MyClass.setFeatureNames(featureNames);
					
					counter++;
					
					continue;
				}
				// split
				String[] split = line.split(",");

				MyClass tempNode = new MyClass();
				tempNode.setFeatures(split);
				
				//
				for(int i = 0;i<featureColumnIndex.length;i++){
					attributeValuesList.get(i).add(split[i]);
				}
				
				String [] features = new String [featureColumnIndex.length];
				for(int i=0;i<featureColumnIndex.length;i++){
					features[i] = split[i];
				}
				//
				tempNode.setFeatures(features);
				
				tempNode.setLabel(split[labelColumn]);
				
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
			MyClass.setFeatureType(tempList);
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
