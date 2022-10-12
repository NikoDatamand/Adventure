public class Adventure {
    private Map map;
    private Player player;

    public Adventure(){
        map = new Map();
        map.createMap();
        player = new Player(100);
        player.setCurrentRoom(map.getStartRoom());
    }

    public Player getPlayer() {
        return player;
    }

    public Map getMap(){
        return map;
    }

    public boolean goNorth(){
        return player.goNorth();
    }

    public boolean goSouth(){
        return player.goSouth();
    }

    public boolean goEast(){
        return player.goEast();
    }

    public boolean goWest(){
        return player.goWest();
    }

}
