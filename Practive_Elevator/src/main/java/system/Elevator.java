package system;

public interface Elevator {
    void addTask(int currentFloor);
    void moveElevator();
    void arriveElevator();
    int getCurrentFloor();
    MoveWay getCurrentMoveType();
}
