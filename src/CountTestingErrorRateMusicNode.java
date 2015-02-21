import java.util.ArrayList;


public class CountTestingErrorRateMusicNode {
	public static double countTestingErrorRate( ArrayList<MusicNode> musicTrainingData, ArrayList<MusicNode> musicTestingData , ArrayList<Integer> indexListMusicNode){
		if(indexListMusicNode.size() == 3){
			
			
			
			
			int contradictPredictTestingMusicNode = 0;
			
			for(MusicNode tempNode: musicTestingData){
				
				if(tempNode.getFeatures()[indexListMusicNode.get(0)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(0)).get(0))){
					if(tempNode.getFeatures()[indexListMusicNode.get(1)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(1)).get(0))){
						
						
						MusicNode trainNode = new MusicNode();
						for(MusicNode temp:musicTrainingData){
							if(temp.getFeatures()[indexListMusicNode.get(0)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(0)).get(0)) && temp.getFeatures()[indexListMusicNode.get(1)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getHit().equals(trainNode.getPredictHit())){
							contradictPredictTestingMusicNode++;
						}				
					}
					
					else{
						
						MusicNode trainNode = new MusicNode();
						for(MusicNode temp:musicTrainingData){
							if(temp.getFeatures()[indexListMusicNode.get(0)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(0)).get(0)) && temp.getFeatures()[indexListMusicNode.get(1)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getHit().equals(trainNode.getPredictHit())){
							contradictPredictTestingMusicNode++;
						}
					}
				}
				else{
					
					
					if(tempNode.getFeatures()[indexListMusicNode.get(2)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(2)).get(0))){
						
						MusicNode trainNode2 = new MusicNode();
						for(MusicNode temp:musicTrainingData){
							if(temp.getFeatures()[indexListMusicNode.get(0)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(0)).get(1)) && temp.getFeatures()[indexListMusicNode.get(2)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(2)).get(0))){
								trainNode2 = temp;
								break;
							}
						}
						if(!tempNode.getHit().equals(trainNode2.getPredictHit())){
							contradictPredictTestingMusicNode++;
						}
					}
					else{
						
						MusicNode trainNode = new MusicNode();
						for(MusicNode temp:musicTrainingData){
							if(temp.getFeatures()[indexListMusicNode.get(0)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(0)).get(1)) && temp.getFeatures()[indexListMusicNode.get(2)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(2)).get(1))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getHit().equals(trainNode.getPredictHit())){
							contradictPredictTestingMusicNode++;
						}
					}
				}
				
				
			}
			
			double testingErrorMusicNode = 1.0 * contradictPredictTestingMusicNode / musicTestingData.size();
			
			return testingErrorMusicNode;
		}
		else{
			int contradictPredictTestingMusicNode = 0;
			
			for(MusicNode tempNode: musicTestingData){
				if(tempNode.getFeatures()[indexListMusicNode.get(0)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(0)).get(0))){
					if(tempNode.getFeatures()[indexListMusicNode.get(1)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(1)).get(0))){
						MusicNode trainNode = new MusicNode();
						for(MusicNode temp:musicTrainingData){
							if(temp.getFeatures()[indexListMusicNode.get(0)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(0)).get(0)) && temp.getFeatures()[indexListMusicNode.get(1)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(1)).get(0))){
								trainNode = temp;
								break;
							}
						}
						if(!tempNode.getHit().equals(trainNode.getPredictHit())){
							contradictPredictTestingMusicNode++;
						}				
					}
					else{
						MusicNode trainNode = new MusicNode();
						for(MusicNode temp:musicTrainingData){
							if(temp.getFeatures()[indexListMusicNode.get(0)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(0)).get(0)) && temp.getFeatures()[indexListMusicNode.get(1)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(1)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getHit().equals(trainNode.getPredictHit())){
							contradictPredictTestingMusicNode++;
						}
					}
				}
				else{
					if(tempNode.getFeatures()[indexListMusicNode.get(2)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(2)).get(0))){
						MusicNode trainNode = new MusicNode();
						for(MusicNode temp:musicTrainingData){
							if(temp.getFeatures()[indexListMusicNode.get(0)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(0)).get(1)) && temp.getFeatures()[indexListMusicNode.get(2)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(2)).get(0))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getHit().equals(trainNode.getPredictHit())){
							contradictPredictTestingMusicNode++;
						}
					}
					else{
						MusicNode trainNode = new MusicNode();
						for(MusicNode temp:musicTrainingData){
							if(temp.getFeatures()[indexListMusicNode.get(0)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(0)).get(1)) && temp.getFeatures()[indexListMusicNode.get(2)].equals(MusicNode.getFeaturesType().get(indexListMusicNode.get(2)).get(1))){
								trainNode = temp;
								break;
							}
						}
						
						if(!tempNode.getHit().equals(trainNode.getPredictHit())){
							contradictPredictTestingMusicNode++;
						}
					}
				}
			}
			
			double testingErrorMusicNode = 1.0 * contradictPredictTestingMusicNode / musicTestingData.size();
			
			return testingErrorMusicNode;
		}
	}
}
