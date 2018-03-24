package minecraftschurli.mfm.util.misc;

public class Pair<L, R> extends org.apache.commons.lang3.tuple.Pair<L, R> {
    private L left;
    private R right;

    public Pair(final L left, final R right) {
        super();
        this.left = left;
        this.right = right;
    }


    @Override
    public L getLeft() {
        return left;
    }

    @Override
    public R getRight() {
        return right;
    }

    @Override
    public R setValue(R value) {
        return null;
    }
}
