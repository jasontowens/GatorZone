public class Edge {
	
	//1 = Lake
	//2 = Jungle
	//3 = game-trail
	//4 = den
	
	int edgeType;
	boolean hasMeeple;
	boolean hasDeer;
	boolean hasBuff;
	boolean hasBoar;
	public Edge(int type){
		hasMeeple = false;
		edgeType = type;		
	}
	public void placeMeeple(){
		hasMeeple = true;
	}
	public void removeMeeple(){
		if (hasMeeple) {
			hasMeeple = false;
		}
		else{
			System.out.println("No Meeple to remove");
		}
	}	
	
}
