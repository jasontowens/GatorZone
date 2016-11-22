
public class Tiles {
	public Tiles left, bottom, top, right;
	public Edge l, r, t, b, m;
	public int x, y;
	
	public Tiles(Edge r, Edge t, Edge l, Edge b, Edge m){
		this.l=l;
		this.r=r;
		this.t=t;
		this.b=b;
		this.m=m;
	}
	public Tiles(int r, int t, int l, int b, int m){
		this.l=new Edge(l);
		this.r=new Edge(r);
		this.t=new Edge(t);
		this.b=new Edge(b);
		this.m=new Edge(m);
	}
	public void setCoor(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public void setLeft(Tiles left, Coordinates coor){
		if (coor.checkValidMove(x-1, y, left)){
			this.left = left;
			this.left.setCoor(x-1, y);
			coor.addTile(x-1, y, left);
		}
		else{
			System.out.println("Not a valid move.");
		}
	}
	public void setRight(Tiles right, Coordinates coor){
		if (coor.checkValidMove(x+1, y, right)){
			this.right = right;
			this.right.setCoor(x+1, y);
			coor.addTile(x+1, y, right);
		}
		else{
			System.out.println("Not a valid move.");
		}
	}
	public void setTop(Tiles top, Coordinates coor){ 
		if (coor.checkValidMove(x, y+1, top)){
			this.top = top;
			this.top.setCoor(x, y+1);
			coor.addTile(x, y+1, top);
		}
		else{
			System.out.println("Not a valid move.");
		}
	}
	public void setBottom(Tiles bottom, Coordinates coor){
		if (coor.checkValidMove(x, y-1, bottom)){
			this.bottom = bottom;
			this.bottom.setCoor(x, y-1);
			coor.addTile(x, y-1, bottom);
		}
		else{
			System.out.println("Not a valid move.");
		}
	}
	public void rotate(){
		Edge temp = t;
		t = r;
		r = b;
		b = l;
		l = temp;
	}

}
