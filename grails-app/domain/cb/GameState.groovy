package cb

class GameState {

    String location
    int money
    int health
    GameUser user

    List<BagItem> bagItems

    static hasMany = [bagItems:BagItem]

    static constraints = {
    }
}
