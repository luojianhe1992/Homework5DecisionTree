import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class decisionTreeTemp {
	public static void main(String[] args) {
		
		
		//processing the ExampleNode
		
		String example1TrainingDataName = args[0];
		String example2TrainingDataName = args[1];
		
		ArrayList<ExampleNode> example1TrainingData = new ArrayList<ExampleNode>();
		ArrayList<ExampleNode> example2TrainingData = new ArrayList<ExampleNode>();
		
		/*
		example1TrainingData = TrainingDataReaderExampleNode.parse(example1TrainingDataName);
		example2TrainingData = TrainingDataReaderExampleNode.parse(example2TrainingDataName);
		*/
		
		example1TrainingData = DataReaderWithoutPacketExampleNode.parse(example1TrainingDataName);
		example2TrainingData = DataReaderWithoutPacketExampleNode.parse(example2TrainingDataName);
		
		
		//training the tree ExampleNode
		ArrayList<Integer> indexListExampleNode1 = new ArrayList<Integer>();
		
		BuildDecisionTreeExample.decisionTree(example1TrainingData, indexListExampleNode1);
		
		int contradictPredictTraining = 0;
		for(ExampleNode tempNode:example1TrainingData){
			if( !tempNode.getHit().equals(tempNode.getPreditHit())){
				contradictPredictTraining++;
			}
		}
		double trainError = 1.0 * contradictPredictTraining/example1TrainingData.size();
		System.out.println("error(train):"+trainError);
		System.out.println("error(test):"+CountTestingErrorRateExampleNode.countTestingErrorRate(example1TrainingData,example2TrainingData, indexListExampleNode1));
		
		/*
		
		ArrayList<Integer> indexListExampleNode2 = new ArrayList<Integer>();
		
		//invoke the function to build decision tree
		BuildDecisionTreeExample.decisionTree(example2TrainingData, indexListExampleNode2);
		
		
		int contradictPredictTraining2 = 0;
		
		for(ExampleNode tempNode:example2TrainingData){
			if( !tempNode.getHit().equals(tempNode.getPreditHit())){
				contradictPredictTraining2++;
			}
		}
				
		double trainError2 = 1.0 * contradictPredictTraining2/example2TrainingData.size();
		
		System.out.println("error(train):"+trainError2);
		System.out.println("error(test):"+CountTestingErrorRateExampleNode.countTestingErrorRate(example2TrainingData,example1TrainingData, indexListExampleNode2));
		
		*/
		
		/*
		//processing the music training data Music Node
		//the process of reading data
		String musicTrainingDataName = "music_train.csv";
		String musicTestingDataName = "music_test.csv";
				
		ArrayList<MusicNode> musicTrainingData = new ArrayList<MusicNode>();
		ArrayList<MusicNode> musicTestingData = new ArrayList<MusicNode>();
				
//		musicTrainingData = TrainingDataReaderMusicNode.parse(musicTrainingDataName);
//		musicTestingData = TrainingDataReaderMusicNode.parse(musicTestingDataName);
				
		musicTrainingData = DataReaderWithoutPacketMusicNode.parse(musicTrainingDataName);
		musicTestingData = DataReaderWithoutPacketMusicNode.parse(musicTestingDataName);
		
		ArrayList<Integer> indexListMusicNode = new ArrayList<Integer>();
		
		BuildDecisionTreeMusic.decisionTree(musicTrainingData, indexListMusicNode);
		
		int contradictPredictTrainingMusicNode = 0;
		
		for(MusicNode tempNode:musicTrainingData){
			if( !tempNode.getHit().equals(tempNode.getPredictHit())){
				contradictPredictTrainingMusicNode++;
			}
		}
		
		double trainErrorMusicNode = 1.0 * contradictPredictTrainingMusicNode / musicTrainingData.size();
		
		System.out.println("error(train) : "+trainErrorMusicNode);
		System.out.println("error(test):"+CountTestingErrorRateMusicNode.countTestingErrorRate(musicTrainingData,musicTestingData, indexListMusicNode));
		*/
		
		
		/*
		//processing the education training data
		
		String educationTrainingDataName = "education_train.csv";
		String educationTestingDataName = "education_test.csv";
		
		ArrayList<EducationNode> educationTrainingData = new ArrayList<EducationNode>();
		ArrayList<EducationNode> educationTestingData = new ArrayList<EducationNode>();
		
		
//		educationTrainingData = TrainingDataReaderEducationNode.parse(educationTrainingDataName);
//		educationTestingData = TrainingDataReaderEducationNode.parse(educationTestingDataName);
		
		educationTrainingData = DataReaderWithoutPacketEducationNode.parse(educationTrainingDataName);
		educationTestingData = DataReaderWithoutPacketEducationNode.parse(educationTestingDataName);
		
		ArrayList<Integer> indexListEducationNode = new ArrayList<Integer>();
		
		BuildDecisionTreeEducation.decisionTree(educationTrainingData, indexListEducationNode);
		
		int contradictPredictTrainingEducationNode = 0;
		
		for(EducationNode tempNode:educationTrainingData){
			if( !tempNode.getGrade().equals(tempNode.getPredictGrade())){
				contradictPredictTrainingEducationNode++;
			}
		}
		
		double trainErrorEducationNode = 1.0 * contradictPredictTrainingEducationNode / educationTrainingData.size();
		System.out.println("error(train) : "+trainErrorEducationNode);
		System.out.println("error(test):"+CountTestingErrorRateEducationNode.countTestingErrorRate(educationTrainingData,educationTestingData, indexListEducationNode));
		*/
		
		System.out.println("************************");
		
		String trainingDataName = "music_train.csv";
		String testingDataName = "music_test.csv";
		
		
		ArrayList<NormalNode> trainingData = new ArrayList<NormalNode>();
		ArrayList<NormalNode> testingData = new ArrayList<NormalNode>();
		
		trainingData = DataReaderWithoutPacketNormalNode.parse(trainingDataName);
		testingData = DataReaderWithoutPacketNormalNode.parse(testingDataName);
		
		System.out.println("trainingData :" + trainingData);
		System.out.println("testingData :" + testingData);
		
		System.out.println(NormalNode.getFeaturesType());
		
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		
		BuildDecisionTreeNormalNode.decisionTree(trainingData, indexList);
		
		int contradictPredictTrainingNormalNode = 0;
		
		for(NormalNode tempNode:trainingData){
			if( !tempNode.getLabel().equals(tempNode.getPredictLabel())){
				contradictPredictTrainingNormalNode++;
			}
		}
		
		double trainErrorNormalNode = 1.0 * contradictPredictTrainingNormalNode / trainingData.size();
		System.out.println("error(train) : "+trainErrorNormalNode);
		System.out.println("error(test):"+CountTestingErrorRateNormalNode.countTestingErrorRate(trainingData,testingData, indexList));
		
		
		
		
	}
	
	public static void myClassDecisionTree(String trainFile, String testFile){
		
		//processing the MyClass Node
		String myClassTrainingDataName = trainFile;
		String myClassTestingDataName = testFile;
		
		ArrayList<MyClass> myClassTrainingData = new ArrayList<MyClass>();
		ArrayList<MyClass> myClassTestingData = new ArrayList<MyClass>();
		
		myClassTrainingData = DataReaderWithoutPacketMyClassNode.parse(myClassTrainingDataName);
		myClassTestingData = DataReaderWithoutPacketMyClassNode.parse(myClassTestingDataName);
		
		System.out.println(myClassTrainingData);
		System.out.println(myClassTestingDataName);
		
		
		ArrayList<Integer> indexListMyClass = new ArrayList<Integer>();
				
		BuildDecisionTreeMyClass.decisionTree(myClassTrainingData, indexListMyClass);
		
		int contradictPredictTrainingMyClass = 0;
		
		for(MyClass tempNode:myClassTrainingData){
			if( !tempNode.getLabel().equals(tempNode.getPredictLabel())){
				contradictPredictTrainingMyClass++;
			}
		}
		
		double trainErrorMyClass = 1.0 * contradictPredictTrainingMyClass / myClassTrainingData.size();
		
		System.out.println("error(train) : "+trainErrorMyClass);
		System.out.println("error(test) : " + CountTestingErrorRateMyClassNode.countTestingErrorRate(myClassTrainingData, myClassTestingData, indexListMyClass));
	
	
		
		
		
		
	}
	
}