package Context;

import Strategy.GamePointStrategy;
import Strategy.PGamePoint;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<PointLog> pointLogs = new ArrayList<>();
    private GamePointStrategy strategy;

    public User(){
        this.strategy = new PGamePoint.NormalPGamePoint();
    }

    public User(GamePointStrategy strategy){
        this.strategy = strategy;
    }

    public void appendPoint(int point){
        pointLogs.add(new PointLog(point, this.strategy.getCalcPoint(point)));
    }

    public void printPointHistory(){
        for(PointLog log : pointLogs)
            log.printLog();
    }

    public void setStrategy(GamePointStrategy strategy) {
        this.strategy = strategy;
    }

    public static class PointLog{
        private final LocalDateTime pointAppendTime;
        private final int originPoint;
        private final int point;

        public PointLog(int originPoint, int point){
            this.pointAppendTime = LocalDateTime.now();
            this.originPoint = originPoint;
            this.point = point;
        }

        public void printLog(){
            String logTime = pointAppendTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println(logTime + " " + point + " " + originPoint);
        }
    }
}
