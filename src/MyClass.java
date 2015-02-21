import java.util.ArrayList;

public class MyClass {
	
	//features or attributes
	String [] features;
	
	static String [] featureNames = new String [] {"buying","maint","doors","person","boot", "safety"};
	static String labelName = "class";
	
	static ArrayList<ArrayList<String>> featureType;
	
	//label
	String label;
	String predictLabel;

	
	//constructor function
	public MyClass() {
		super();
		
	}
	

	public MyClass(String[] features) {
		super();
		this.features = features;
		
	}

	public static void initializeFeatureType(){
		ArrayList<String> buyingList = new ArrayList<String>();
		buyingList.add("expensive");
		buyingList.add("cheap");
		
		ArrayList<String> maintList = new ArrayList<String>();
		maintList.add("high");
		maintList.add("low");
		
		ArrayList<String> doorsList = new ArrayList<String>();
		doorsList.add("Two");
		doorsList.add("MoreThanTwo");
		
		ArrayList<String> personList = new ArrayList<String>();
		personList.add("Two");
		personList.add("MoreThanTwo");
		
		ArrayList<String> bootList = new ArrayList<String>();
		bootList.add("small");
		bootList.add("large");
		
		ArrayList<String> safetyList = new ArrayList<String>();
		safetyList.add("low");
		safetyList.add("high");
		
		ArrayList<String> classList = new ArrayList<String>();
		classList.add("yes");
		classList.add("no");
		
		featureType.add(buyingList);
		featureType.add(maintList);
		featureType.add(doorsList);
		featureType.add(personList);
		featureType.add(bootList);
		featureType.add(safetyList);
		featureType.add(classList);
	}



	public String[] getFeatures() {
		return features;
	}


	public void setFeatures(String[] features) {
		this.features = features;
	}


	public static String[] getFeatureNames() {
		return featureNames;
	}


	public static void setFeatureNames(String[] featureNames) {
		MyClass.featureNames = featureNames;
	}


	public static String getLabelName() {
		return labelName;
	}


	public static void setLabelName(String labelName) {
		MyClass.labelName = labelName;
	}


	public static ArrayList<ArrayList<String>> getFeatureType() {
		return featureType;
	}


	public static void setFeatureType(ArrayList<ArrayList<String>> featureType) {
		MyClass.featureType = featureType;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getPredictLabel() {
		return predictLabel;
	}


	public void setPredictLabel(String predictLabel) {
		this.predictLabel = predictLabel;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<getFeatures().length;i++){
			sb.append(this.getFeatures()[i]+",");
		}
		sb.append(getLabel());
		
		return sb.toString();
	}

}
