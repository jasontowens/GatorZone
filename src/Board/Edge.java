package Board;

public class Edge {
	//1 = Lake
	//2 = Jungle
	//3 = game-trail
	
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
        
        public int getEdge(){
            return edgeType;
        }
	
}
