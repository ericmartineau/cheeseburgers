package cheeseburgers

import cb.GameLocations
import cb.RoomItem

class BootStrap {

    def init = { servletContext ->
        def thread = Thread.start {
            for (; ;) {

                RoomItem.withTransaction {
                    def random = new Random().nextInt(5)
                    def item = ["Old Boot", "Gold Coin", "Bottle", "Wood Plank", "Cheeseburger"][random]
                    def room = GameLocations.locations[new Random().nextInt(GameLocations.locations.size())].name
                    println "Adding $item to $room"
                    new RoomItem(
                        qty: 1,
                        itemName: item,
                        room: room).save(failOnError:true)
                    sleep(60000*2)
                }
            }

        }
    }
    def destroy = {
    }
}
