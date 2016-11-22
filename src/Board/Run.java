class Run {
    public static void main(String[] args) {
    	Coordinates coor = new Coordinates();
    	Tiles tile = new Tiles(1,1,2,1,0);
        tile.setCoor(71, 71);
        coor.addTile(tile);
        Tiles tile2;
    	while(tile.x != 0 ){
            tile2 = new Tiles(2,1,2,1,0);
            tile.setLeft(tile2, coor);
            tile=tile2;
    	}
        System.out.println(coor);
    }
}
