package system;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DefaultElevatorRepeater implements ElevatorRepeater{
    private final Elevator elevator;
    private PriorityQueue<Integer> upCalls;
    private PriorityQueue<Integer> downCalls;

    public DefaultElevatorRepeater(Elevator elevator){
        this.elevator = elevator;
        upCalls = new PriorityQueue<>();
        downCalls = new PriorityQueue<>(Comparator.reverseOrder());
    }

    @Override
    public void setCall(MoveWay destinationMove, int currentFloor) {
        if(destinationMove.equals(MoveWay.UP)) {
            upCalls.add(currentFloor);
            return;
        }

        downCalls.add(currentFloor);
    }

    @Override
    public boolean orderElevator() {
        if(upCalls.isEmpty() && downCalls.isEmpty())
            return false;

        MoveWay elevatorCurrentMoveType = elevator.getCurrentMoveType();
        int elevatorCurrentFloor = elevator.getCurrentFloor();

        if (elevatorCurrentMoveType.equals(MoveWay.UP)) {
            while (!upCalls.isEmpty() && elevatorCurrentFloor < upCalls.peek())
                elevator.addTask(upCalls.poll());
        }

        while (!downCalls.isEmpty() && elevatorCurrentFloor > downCalls.peek())
            elevator.addTask(downCalls.poll());

        elevator.moveElevator();

        return true;
    }
}
