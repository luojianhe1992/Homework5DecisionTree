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


public class TrainingDataReaderMyClassNode {
	public static ArrayList<MyClass> parse(String path) {
		
		return parse(path, 1, new int[] { 0, 1, 2, 3, 4, 5}, 6);
	}
	
	//override function
	public static ArrayList<MyClass> parse(String path, int skipline, int[] featureColumnIndex, int labelColumn) {
		
		//using a ArrayList<KnnNode> to store the training data
		ArrayList<MyClass> result = new ArrayList<MyClass>();

		//initialize the InputStream
		InputStream stream = TrainingDataReaderMyClassNode.class.getClassLoader().getResourceAsStream(path);
		
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
				continue;
			}
			String[] features = new String[featureColumnIndex.length];

			for (int i = 0; i < featureColumnIndex.length; i++) {
				String feature = record.get(featureColumnIndex[i]);
				features[i] = feature;
			}
			
			MyClass tempNode = new MyClass(features);
			
			tempNode.setLabel(record.get(labelColumn));
			
			result.add(tempNode);
		}
		
		
		return result;
	}
	
	//parse testing data
	public static ArrayList<MyClass> parseTestingData(String path){
		return parseTestingData(path, 0, new int []{ 0, 1});
	}
	
	public static ArrayList<MyClass> parseTestingData(String path, int skipline, int[]featureColumnIndex){
				
		//using a ArrayList<KnnNode> to store the training data
		ArrayList<MyClass> result = new ArrayList<MyClass>();

		//initialize the InputStream
		InputStream stream = TrainingDataReaderMyClassNode.class.getClassLoader().getResourceAsStream(path);
				

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
			if (record.getRecordNumber() <= skipline)
				continue;
			String[] features = new String[featureColumnIndex.length];
			for (int i = 0; i < featureColumnIndex.length; i++) {
				String feature = record.get(featureColumnIndex[i]);
				features[i] = feature;
			}
			
			MyClass tempNode = new MyClass();
			
			tempNode.setFeatures(features);
			
			result.add(tempNode);
		}
		return result;
	}
}
