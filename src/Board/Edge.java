package board;

public class Edge {
	
	//1 = Lake
	//2 = Jungle
	//3 = game-trail
	//4 = den
	
	int edgeType;
	boolean hasTiger;
	boolean hasDeer;
	boolean hasBuff;
	boolean hasBoar;
        
	public Edge(int type){
		hasTiger = false;
		edgeType = type;		
	}
	public void placeTiger(){
		hasTiger = true;
	}
	public void removeTiger(){
		if (hasTiger) {
			hasTiger = false;
		}
		else{
			System.out.println("No Tiger to Remove!");
		}
	}	
	
}
