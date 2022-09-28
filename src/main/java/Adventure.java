public class Adventure {
    Map map;
    Player player;

    public Adventure(){
        map = new Map();
        map.createMap();
        player = new Player();
        player.setCurrentRoom(map.getRoom1());
    }

}
