package system;

public interface Person {
    void callElevator(ElevatorRepeater elevatorRepeater);
    void onElevator(Elevator elevator);
    void offElevator(Elevator elevator);
}
