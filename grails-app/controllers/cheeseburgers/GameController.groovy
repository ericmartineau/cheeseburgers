package cheeseburgers

import cb.BagItem
import cb.Direction
import cb.GameState
import cb.GameUser
import cb.RoomItem

class GameController {

  def gameService

  def move(Long id, String direction) {
    GameUser user = GameUser.get(id)
    def gameState = GameState.findByUser(user)
    def paths = gameService.getPaths(gameState.location)
    def newLocation = paths.find { it.direction.name() == direction }
    if (newLocation == null) {
      throw new Exception("You just fell off the universe")
    }
    gameState.location = newLocation.to.name
    gameState.save(failOnError: true)

    redirect(action: "index", id: id)
  }

  def pickUp(Long id, Long roomItemId) {
    GameUser user = GameUser.get(id)
    def gameState = GameState.findByUser(user)

    def roomItem = RoomItem.get(roomItemId)
    if (gameState.bagItems?.find { it.itemName == roomItem.itemName }) {
      gameState.bagItems?.find { it.itemName == roomItem.itemName }?.qty += 1
    } else {
      gameState.bagItems << new BagItem(qty: 1, itemName: roomItem.itemName)
    }

    gameState.save(failOnError: true)

    if (roomItem.qty <= 1) {
      roomItem.delete()
    } else {
      roomItem.qty = roomItem.qty - 1
      roomItem.save(failOnError: true)
    }

    redirect(action: "index", id: id)
  }

  def junkyard(Long id) {
    [gypsy: new Random().nextInt(3) == 2]
  }

  def drop(Long id, String item) {
    GameUser user = GameUser.get(id)
    def gameState = GameState.findByUser(user)

    String location = gameState.location
    def existingRoomtItem = RoomItem.findByRoomAndItemName(location, item)
    if (existingRoomtItem == null) {
      new RoomItem(room: location, itemName: item, qty: 1).save(failOnError: true)
    } else {
      existingRoomtItem.qty++
      existingRoomtItem.save(failOnError: true)
    }

    def bagItem = gameState.bagItems?.find { it.itemName == item }
    if (bagItem.qty <= 1) {
      gameState.removeFromBagItems(bagItem)
      bagItem.delete(failOnError: true)
    } else {
      bagItem.qty--
      bagItem.save(failOnError: true)
    }

    redirect(action: "index", id: id)
  }

  def destroy(Long id, String item) {
    GameUser user = GameUser.get(id)
    def gameState = GameState.findByUser(user)

    def bagItem = gameState.bagItems?.find { it.itemName == item }
    if (bagItem.qty <= 1) {
      gameState.removeFromBagItems(bagItem)
      bagItem.delete(failOnError: true)
    } else {
      bagItem.qty--
      bagItem.save(failOnError: true)
    }

    redirect(action: "index", id: id)
  }

  def index(Long id) {
    GameUser user = GameUser.get(id)
    def gameState = GameState.findByUser(user)
    if (gameState == null) {
      gameState = new GameState()
      gameState.money = 200
      gameState.location = "alleyway"
      gameState.user = user
      def bagItems = []
      bagItems << new BagItem(qty: 1, itemName: "Bottle")
      gameState.bagItems = bagItems
      gameState.save(failOnError: true)
    }
    def location = gameService.findLocation(gameState.location)
    def paths = gameService.getPaths(gameState.location)
    def items = RoomItem.findAllByRoom(gameState.location)
    def otherUsers = GameState.findAllByLocationAndUserNotEqual(gameState.location, user)
    return [user: user, gameState: gameState, location: location, paths: paths, items: items, otherUsers: otherUsers]
  }

  def attack(Long id, Long attackUserId) {
    GameUser user = GameUser.get(id)
    def gameState = GameState.findByUser(user)

    def attackUser = GameUser.get(attackUserId)
    def attackGameState = GameState.findByUser(attackUser)

    if (attackGameState.location == gameState.location) {
      double attacker = new Random().nextInt(99) + 10
      double defender = new Random().nextInt(99)

      if (attacker > defender) {
        attackGameState.health -= Math.min(20, attacker - defender)
        attackGameState.save(failOnError: true)
      } else {
        gameState.health -= Math.min(30, defender - attacker)
        gameState.save(failOnError: true)
      }
    }

    redirect(action: "index", id: id)
  }
}
