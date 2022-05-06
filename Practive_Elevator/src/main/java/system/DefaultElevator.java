package system;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DefaultElevator implements Elevator{
    private static final int MinFloor = 1;

    private PriorityQueue<Integer> task;

    private MoveWay currentMoveType;
    private Integer currentFloor;

    public DefaultElevator(){
        task = new PriorityQueue<>();

        currentFloor = MinFloor;
        currentMoveType = MoveWay.UP;
    }

    @Override
    public void addTask(int currentFloor) {
        task.add(currentFloor);
    }

    @Override
    public void moveElevator() {
        while(!task.isEmpty()) {
            System.out.println("엘리베이터 이동 중...");

            this.currentFloor = task.peek();
            this.arriveElevator();
            task.remove(currentFloor);
        }

        this.currentMoveType = switchMoveType();
        switchTaskComparator();
    }

    @Override
    public void arriveElevator() {
        System.out.println("엘리베이터 " + this.currentFloor + "층 도착");
    }

    @Override
    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public MoveWay getCurrentMoveType() {
        return currentMoveType;
    }

    public MoveWay switchMoveType(){
        if(this.currentMoveType.equals(MoveWay.UP)) {
            return MoveWay.DOWN;
        }

        return MoveWay.UP;
    }

    public void switchTaskComparator(){
        PriorityQueue<Integer> temp = task;
        if(this.currentMoveType.equals(MoveWay.UP))
            task = new PriorityQueue<>(Comparator.reverseOrder());

        task = new PriorityQueue<>();

        copyTask(temp);
    }

    public void copyTask(PriorityQueue<Integer> temp){
        while(!temp.isEmpty())
            task.add(temp.poll());
    }
}
