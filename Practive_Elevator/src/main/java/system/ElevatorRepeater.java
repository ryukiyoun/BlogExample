package system;

public interface ElevatorRepeater {
    void setCall(MoveWay destinationMove, int currentFloor);
    boolean orderElevator();
}
