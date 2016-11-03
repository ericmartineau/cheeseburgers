package cb

/**
 * Created by ericm on 11/2/16.
 */
class GameLocations {
  static def locations = [
      new GameLocation(name: "alleyway", label: "Alleyway"),
      new GameLocation(name: "cathedral", label: "Cathedral"),
      new GameLocation(name: "creepy_cabin", label: "Creepy Cabin"),
      new GameLocation(name: "creepy_village", label: "Creepy Village"),
      new GameLocation(name: "junkyard", label: "Junkyard"),
      new GameLocation(name: "old_port", label: "Old Shipyard"),
      new GameLocation(name: "snow_tower", label: "Snow Tower")
  ]

  static def paths = [
      new GamePath(from: findLocation("alleyway"), to: findLocation("cathedral"), direction: Direction.Left),
      new GamePath(from: findLocation("cathedral"), to: findLocation("creepy_cabin"), direction: Direction.Left),
      new GamePath(from: findLocation("creepy_cabin"), to: findLocation("creepy_village"), direction: Direction.Left),
      new GamePath(from: findLocation("creepy_village"), to: findLocation("junkyard"), direction: Direction.Left),
      new GamePath(from: findLocation("junkyard"), to: findLocation("old_port"), direction: Direction.Left),
      new GamePath(from: findLocation("old_port"), to: findLocation("snow_tower"), direction: Direction.Left),
      new GamePath(from: findLocation("snow_tower"), to: findLocation("alleyway"), direction: Direction.Left)
  ]

  public static GameLocation findLocation(String location) {
    locations?.find {it.name == location}
  }

  public static Collection<GamePath> findPaths(String location) {
    def allPaths = []
    allPaths.addAll(paths)
    paths?.each{
      allPaths.add(new GamePath(from:it.to, to:it.from, direction: it.direction.opposite))
    }
    allPaths.findAll{it.from.name == location}
  }
}
