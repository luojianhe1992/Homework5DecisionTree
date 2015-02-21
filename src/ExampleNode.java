import java.util.ArrayList;


public class ExampleNode {
	String love;
	String debut;
	
	String [] features;
	static String [] featureNames;
	
	//
	static ArrayList<ArrayList<String>> featuresType;
	
	String hit;
	String preditHit;

	public ExampleNode() {
		super();
	}
	
	public ExampleNode(String[] features) {
		super();
		this.features = features;
	}

	public ExampleNode(String love, String debut, String hit) {
		super();
		this.love = love;
		this.debut = debut;
		this.hit = hit;
	}
	
	public static ArrayList<ArrayList<String>> getFeaturesType() {
		return featuresType;
	}

	public static void setFeaturesType(ArrayList<ArrayList<String>> featuresType) {
		ExampleNode.featuresType = featuresType;
	}

	//
	public static String[] getFeatureNames() {
		return featureNames;
	}

	//
	public static void setFeatureNames(String[] fNames) {
		featureNames = fNames;
	}

	public String getLove() {
		return love;
	}

	public void setLove(String love) {
		this.love = love;
	}

	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}
	
	public String[] getFeatures() {
		return features;
	}

	public void setFeatures(String[] features) {
		this.features = features;
	}
	
	

	public String getPreditHit() {
		return preditHit;
	}

	public void setPreditHit(String preditHit) {
		this.preditHit = preditHit;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("love:"+getLove()+" ");
		sb.append("debut:"+getDebut()+" ");
		
		sb.append("hit:"+getHit()+" ");
		sb.append("predictHit:"+getPreditHit());
		return sb.toString();
	}
	
}
