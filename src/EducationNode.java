import java.util.ArrayList;


public class EducationNode {
	String M1;
	String M2;
	String M3;
	String M4;
	String M5;
	String P1;
	String P2;
	String P3;
	String P4;
	String F;
	
	String [] features;
	static String [] featureNames;
	
	static ArrayList<ArrayList<String>> featuresType;
	
	String grade;
	String predictGrade;
	

	public EducationNode() {
		super();
	}

	public EducationNode(String m1, String m2, String m3, String m4, String m5,
			String p1, String p2, String p3, String p4, String f, String grade) {
		super();
		M1 = m1;
		M2 = m2;
		M3 = m3;
		M4 = m4;
		M5 = m5;
		P1 = p1;
		P2 = p2;
		P3 = p3;
		P4 = p4;
		F = f;
		this.grade = grade;
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
		EducationNode.featureNames = featureNames;
	}

	public static ArrayList<ArrayList<String>> getFeaturesType() {
		return featuresType;
	}

	public static void setFeaturesType(ArrayList<ArrayList<String>> featuresType) {
		EducationNode.featuresType = featuresType;
	}

	public String getPredictGrade() {
		return predictGrade;
	}

	public void setPredictGrade(String predictGrade) {
		this.predictGrade = predictGrade;
	}

	public String getM1() {
		return M1;
	}

	public void setM1(String m1) {
		M1 = m1;
	}

	public String getM2() {
		return M2;
	}

	public void setM2(String m2) {
		M2 = m2;
	}

	public String getM3() {
		return M3;
	}

	public void setM3(String m3) {
		M3 = m3;
	}

	public String getM4() {
		return M4;
	}

	public void setM4(String m4) {
		M4 = m4;
	}

	public String getM5() {
		return M5;
	}

	public void setM5(String m5) {
		M5 = m5;
	}

	public String getP1() {
		return P1;
	}

	public void setP1(String p1) {
		P1 = p1;
	}

	public String getP2() {
		return P2;
	}

	public void setP2(String p2) {
		P2 = p2;
	}

	public String getP3() {
		return P3;
	}

	public void setP3(String p3) {
		P3 = p3;
	}

	public String getP4() {
		return P4;
	}

	public void setP4(String p4) {
		P4 = p4;
	}

	public String getF() {
		return F;
	}

	public void setF(String f) {
		F = f;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("M1:"+getM1()+" ");
		sb.append("M2:"+getM2()+" ");
		sb.append("M3:"+getM3()+" ");
		sb.append("M4:"+getM4()+" ");
		sb.append("M5:"+getM5()+" ");
		sb.append("P1:"+getP1()+" ");
		sb.append("P2:"+getP2()+" ");
		sb.append("P3:"+getP3()+" ");
		sb.append("P4:"+getP4()+" ");
		sb.append("F:"+getF()+" ");
		
		sb.append("grade:"+getGrade());
		
		return sb.toString();
	}
	
}
