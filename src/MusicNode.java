import java.util.ArrayList;


public class MusicNode {
	String year;
	String solo;
	String vocal;
	String length;
	String original;
	String tempo;
	String folk;
	String classical;
	String rhythm;
	String jazz;
	String rock;
	
	String [] features;
	static String [] featureNames;
	
	//
	static ArrayList<ArrayList<String>> featuresType;
	
	String hit;
	String predictHit;

	
	
	public MusicNode() {
		super();
	}

	public MusicNode(String year, String solo, String vocal, String length,
			String original, String tempo, String folk, String classical,
			String rhythm, String jazz, String rock, String hit) {
		super();
		this.year = year;
		this.solo = solo;
		this.vocal = vocal;
		this.length = length;
		this.original = original;
		this.tempo = tempo;
		this.folk = folk;
		this.classical = classical;
		this.rhythm = rhythm;
		this.jazz = jazz;
		this.rock = rock;
		this.hit = hit;
	}
	

	public static ArrayList<ArrayList<String>> getFeaturesType() {
		return featuresType;
	}

	public static void setFeaturesType(ArrayList<ArrayList<String>> featuresType) {
		MusicNode.featuresType = featuresType;
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

	public static void setFeatureNames(String[] fNames) {
		featureNames = fNames;
	}

	public String getPredictHit() {
		return predictHit;
	}

	public void setPredictHit(String predictHit) {
		this.predictHit = predictHit;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSolo() {
		return solo;
	}

	public void setSolo(String solo) {
		this.solo = solo;
	}

	public String getVocal() {
		return vocal;
	}

	public void setVocal(String vocal) {
		this.vocal = vocal;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getFolk() {
		return folk;
	}

	public void setFolk(String folk) {
		this.folk = folk;
	}

	public String getClassical() {
		return classical;
	}

	public void setClassical(String classical) {
		this.classical = classical;
	}

	public String getRhythm() {
		return rhythm;
	}

	public void setRhythm(String rhythm) {
		this.rhythm = rhythm;
	}

	public String getJazz() {
		return jazz;
	}

	public void setJazz(String jazz) {
		this.jazz = jazz;
	}

	public String getRock() {
		return rock;
	}

	public void setRock(String rock) {
		this.rock = rock;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("year:"+getYear()+" ");
		sb.append("solo:"+getSolo()+" ");
		sb.append("vocal:"+getVocal()+" ");
		sb.append("length:"+getLength()+" ");
		sb.append("original:"+getOriginal()+" ");
		sb.append("tempo:"+getTempo()+" ");
		sb.append("folk:"+getFolk()+" ");
		sb.append("classical:"+getClassical()+" ");
		sb.append("rhythm:"+getRhythm()+" ");
		sb.append("jazz:"+getJazz()+" ");
		sb.append("rock:"+getRock()+" ");
		
		sb.append("hit:"+getHit()+" ");
		sb.append("predictHit:"+getPredictHit());
		
		return sb.toString();
	}
	
}
