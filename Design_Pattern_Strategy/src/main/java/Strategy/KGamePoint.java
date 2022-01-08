package Strategy;

public class KGamePoint {
    public static class NormalKGamePoint implements GamePointStrategy{
        @Override
        public int getCalcPoint(int point) {
            return 100;
        }
    }
}
