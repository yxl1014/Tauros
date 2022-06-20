package yxl.demo.y2022.m6.d20;


/**
 * MySelf
 */
public class RangeModule {
    private int pis = 1;
    private long[] map;

    public RangeModule() {
        this.map = new long[pis];
        for (int i = 0; i < pis; i++)
            this.map[i] = 0L;
    }

    public void addRange(int left, int right) {
        int mi = right / 64;
        if (mi >= pis)
            resizeMap(mi + 1);
        for (int i = left; i < right; i++)
            setMap(i);
    }

    private void resizeMap(int mi) {
        long[] temp = this.map;
        int newPis = this.pis;
        while (newPis <= mi)
            newPis = newPis << 1;
        this.map = new long[newPis];
        this.pis = newPis;
        System.arraycopy(temp, 0, this.map, 0, temp.length);
    }

    public boolean queryRange(int left, int right) {
        int mi = right / 64;
        if (mi >= pis)
            resizeMap(mi + 1);
        for (int i = left; i < right; i++)
            if (!isRange(i))
                return false;
        return true;
    }

    public void removeRange(int left, int right) {
        int mi = right / 64;
        if (mi >= pis)
            resizeMap(mi + 1);
        for (int i = left; i < right; i++)
            detMap(i);
    }

    private void setMap(int index) {
        int mi = index / 64;
        int ii = index - mi * 64;
        this.map[mi] = this.map[mi] | (0x1L << ii);
    }

    private void detMap(int index) {
        int mi = index / 64;
        int ii = index - mi * 64;
        this.map[mi] = this.map[mi] & ~(0x1L << ii);
    }

    private boolean isRange(int index) {
        int mi = index / 64;
        int ii = index - mi * 64;
        return ((this.map[mi] >> ii) & 0x1L) == 1;
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(1, 2);
        System.out.println(rangeModule.queryRange(100, 1000));

    }
}