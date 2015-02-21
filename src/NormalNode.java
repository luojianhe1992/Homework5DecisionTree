import java.util.ArrayList;


public class NormalNode {
	String [] features;
	static String [] featureNames;
	
	//
	static ArrayList<ArrayList<String>> featuresType;
	
	String label;
	String predictLabel;
	
	public NormalNode() {
		super();
	}

	public NormalNode(String[] features, String label, String predictLabel) {
		super();
		this.features = features;
		this.label = label;
		this.predictLabel = predictLabel;
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
		NormalNode.featureNames = featureNames;
	}

	public static ArrayList<ArrayList<String>> getFeaturesType() {
		return featuresType;
	}

	public static void setFeaturesType(ArrayList<ArrayList<String>> featuresType) {
		NormalNode.featuresType = featuresType;
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
		sb.append("features: ");
		for(int i=0;i<features.length;i++){
			sb.append(getFeatures()[i]+", ");
		}
		sb.append("label: "+label);
		return sb.toString();
	}
}
