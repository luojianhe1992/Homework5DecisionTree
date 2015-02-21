import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class DataReaderWithoutPacketNormalNode {
	public static ArrayList<NormalNode> parse(String path) {
		
		//using a ArrayList<KnnNode> to store the training data
		ArrayList<NormalNode> result = new ArrayList<NormalNode>();

		//initialize the InputStream
		InputStream stream = DataReaderWithoutPacketNormalNode.class.getClassLoader().getResourceAsStream(path);
		
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(stream));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		String line = null;
		
		try {
			String[] split = br.readLine().split(",");
			int len = split.length - 1;
			
			String [] featureNames = new String[len];
			for(int i=0;i<featureNames.length;i++){
				String name = split[i];
				featureNames[i] = name;
			}
			NormalNode.setFeatureNames(featureNames);
			
			
			ArrayList<HashSet<String>> attributeValuesList = new ArrayList<HashSet<String>>();
			for(int i = 0;i<len + 1;i++){
				attributeValuesList.add(new HashSet<String>());
			}
			
			// read the line one by one
			while ((line = br.readLine()) != null) {

				// split
				split = line.split(",");
				
				String[] features = new String[len];
				for(int i=0;i<len;i++){
					features[i] = split[i];
				}
				
				NormalNode tempNode = new NormalNode();
				tempNode.setFeatures(features);
				
				//
				for(int i = 0;i<len;i++){
					attributeValuesList.get(i).add(split[i]);
				}
				
				//add the label
				attributeValuesList.get(len).add(split[len]);
				
				
				tempNode.setLabel(split[len]);
				
				result.add(tempNode);
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
			NormalNode.setFeaturesType(tempList);
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
