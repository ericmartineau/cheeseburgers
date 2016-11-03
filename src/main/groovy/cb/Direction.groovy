package cb

/**
 * Created by ericm on 11/2/16.
 */
enum Direction {

  Up(Down),
  Down(Up),
  Left(Right),
  Right(Left),
  Forward(Back),
  Back(Forward)

  Direction(Direction opposite) {
    this.opposite = opposite
  }

  Direction getOpposite() {
    [Up: Down,
     Down: Up,
     Left: Right,
     Right: Left,
     Forward: Back,
     Back: Forward][this.name()]
  }

  Direction opposite
}
