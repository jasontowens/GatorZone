package board;

public class Tile {
	public Edge l, r, t, b, m;
        
	public Tile(Edge r, Edge t, Edge l, Edge b, Edge m){
                this.l=l;
		this.r=r;
		this.t=t;
		this.b=b;
		this.m=m;
	}
	public Tile(int r, int t, int l, int b, int m){
		this.l=new Edge(l);
		this.r=new Edge(r);
		this.t=new Edge(t);
		this.b=new Edge(b);
		this.m=new Edge(m);
	}
        
	public void rotate(){
		Edge temp = t;
		t = r;
		r = b;
		b = l;
		l = temp;
	}

}
