package Board;

public class Edge {
	//1 = Lake
	//2 = Jungle
	//3 = game-trail
	
	int edgeType;
        
	public Edge(int type){
		edgeType = type;		
	}
        
        public int getEdge(){
            return edgeType;
        }
	
}
