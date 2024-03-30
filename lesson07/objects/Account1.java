public class Account1 {
    private static class Companion {
        public int instanceCount = 0;
        public static Companion INSTANCE = new Companion();
        private Companion() {}
    }
    //private static int instanceCount = 0;

    public Account1() {
        Companion.INSTANCE.instanceCount++;
    }

    public static int getInstanceCount() {
        return Companion.INSTANCE.instanceCount;
    }
}
