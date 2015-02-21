import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;







import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class TrainingDataReaderMusicNode {
	//parse training data
		public static ArrayList<MusicNode> parse(String path) {
			return parse(path, 1, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 11);
		}
		
		//override function
		public static ArrayList<MusicNode> parse(String path, int skipline, int[] featureColumnIndex, int labelColumn) {
			
			//using a ArrayList<KnnNode> to store the training data
			ArrayList<MusicNode> result = new ArrayList<MusicNode>();

			//initialize the InputStream
			InputStream stream = TrainingDataReaderMusicNode.class.getClassLoader().getResourceAsStream(path);
			
			//define a CSVParser
			CSVParser parse;
			
			//
			List<CSVRecord> records = null;
			try {
				parse = CSVFormat.EXCEL.parse(new InputStreamReader(stream, "ISO-8859-1"));
				records = parse.getRecords();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//
			ArrayList<HashSet<String>> attributeValuesList = new ArrayList<HashSet<String>>();
			for(int i = 0;i<featureColumnIndex.length;i++){
				attributeValuesList.add(new HashSet<String>());
			}

			for (CSVRecord record : records) {
				if (record.getRecordNumber() <= skipline){
					String [] featureNames = new String[featureColumnIndex.length];
					for(int i=0;i<featureNames.length;i++){
						String name = record.get(featureColumnIndex[i]);
						featureNames[i] = name;
					}
					MusicNode.setFeatureNames(featureNames);
					continue;
				}
				String[] features = new String[featureColumnIndex.length];

				for (int i = 0; i < featureColumnIndex.length; i++) {
					String feature = record.get(featureColumnIndex[i]);
					features[i] = feature;
				}
				
				MusicNode tempNode = new MusicNode();
				tempNode.setYear(features[0]);
				tempNode.setSolo(features[1]);
				tempNode.setVocal(features[2]);
				tempNode.setLength(features[3]);
				tempNode.setOriginal(features[4]);
				tempNode.setTempo(features[5]);
				tempNode.setFolk(features[6]);
				tempNode.setClassical(features[7]);
				tempNode.setRhythm(features[8]);
				tempNode.setJazz(features[9]);
				tempNode.setRock(features[10]);
				
				//
				for(int i = 0;i<featureColumnIndex.length;i++){
					attributeValuesList.get(i).add(features[i]);
				}
				
				tempNode.setFeatures(features);
				
				tempNode.setHit(record.get(labelColumn));
				result.add(tempNode);
				
			}
			
			//
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
			MusicNode.setFeaturesType(tempList);
			
			return result;
		}
		
		//parse testing data
		public static ArrayList<MusicNode> parseTestingData(String path){
			return parseTestingData(path, 0, new int []{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		}
		
		public static ArrayList<MusicNode> parseTestingData(String path, int skipline, int[]featureColumnIndex){
					
			//using a ArrayList<KnnNode> to store the training data
			ArrayList<MusicNode> result = new ArrayList<MusicNode>();

			//initialize the InputStream
			InputStream stream = TrainingDataReaderMusicNode.class.getClassLoader().getResourceAsStream(path);
					

			//define a CSVParser
			CSVParser parse;
					
			//
			List<CSVRecord> records = null;
			try {
				parse = CSVFormat.EXCEL.parse(new InputStreamReader(stream, "ISO-8859-1"));
				records = parse.getRecords();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			for (CSVRecord record : records) {
				if (record.getRecordNumber() <= skipline){
					String [] featureNames = new String[featureColumnIndex.length];
					for(int i=0;i<featureNames.length;i++){
						String name = record.get(featureColumnIndex[i]);
						featureNames[i] = name;
					}
					ExampleNode.setFeatureNames(featureNames);
					continue;
				}
				String[] features = new String[featureColumnIndex.length];
				for (int i = 0; i < featureColumnIndex.length; i++) {
					String feature = record.get(featureColumnIndex[i]);
					features[i] = feature;
				}
				
				MusicNode tempNode = new MusicNode();
				tempNode.setYear(features[0]);
				tempNode.setSolo(features[1]);
				tempNode.setVocal(features[2]);
				tempNode.setLength(features[3]);
				tempNode.setOriginal(features[4]);
				tempNode.setTempo(features[5]);
				tempNode.setFolk(features[6]);
				tempNode.setClassical(features[7]);
				tempNode.setRhythm(features[8]);
				tempNode.setJazz(features[9]);
				tempNode.setRock(features[10]);
				
				result.add(tempNode);
			}
			return result;
		}
}
