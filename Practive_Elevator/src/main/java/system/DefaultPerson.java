package system;

import java.util.concurrent.ThreadLocalRandom;

public class DefaultPerson implements Person{
    private static final int MaxFloor = 30;
    private static final int MinFloor = 1;

    private final int currentFloor;
    private final int destinationFloor;
    private final MoveWay destinationMove;

    public DefaultPerson() {
        currentFloor = ThreadLocalRandom.current().nextInt(MinFloor + 1, MaxFloor + 1);
        destinationFloor = ThreadLocalRandom.current().nextInt(MinFloor, MaxFloor + 1);

        destinationMove = directionDetermination(currentFloor, destinationFloor);
    }

    public MoveWay directionDetermination(int currentFloor, int destinationFloor){
        if(currentFloor < destinationFloor)
            return MoveWay.UP;

        return MoveWay.DOWN;
    }

    @Override
    public void callElevator(ElevatorRepeater elevatorRepeater) {
        elevatorRepeater.setCall(this.destinationMove, this.currentFloor);
    }

    @Override
    public void onElevator(Elevator elevator) {

    }

    @Override
    public void offElevator(Elevator elevator) {

    }
}
