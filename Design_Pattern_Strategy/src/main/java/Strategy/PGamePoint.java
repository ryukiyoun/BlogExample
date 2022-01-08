package Strategy;

public class PGamePoint {
    public static class NormalPGamePoint implements GamePointStrategy{
        @Override
        public int getCalcPoint(int point) {
            return point;
        }
    }

    public static class JumboPGamePoint implements GamePointStrategy{
        @Override
        public int getCalcPoint(int point) {
            return point * 2;
        }
    }
}
