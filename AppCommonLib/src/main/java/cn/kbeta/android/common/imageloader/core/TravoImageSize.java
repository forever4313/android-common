package cn.kbeta.android.common.imageloader.core;

/**
 * @author:kevin dong
 * @date:2016/03/01
 * @email:dk-26@163.com
 */
public class TravoImageSize {
    private static final int TO_STRING_MAX_LENGHT = 9; // "9999x9999".length()
    private static final String SEPARATOR = "x";

    private final int width;
    private final int height;

    public TravoImageSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public TravoImageSize(int width, int height, int rotation) {
        if (rotation % 180 == 0) {
            this.width = width;
            this.height = height;
        } else {
            this.width = height;
            this.height = width;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Scales down dimensions in <b>sampleSize</b> times. Returns new object.
     */
    public TravoImageSize scaleDown(int sampleSize) {
        return new TravoImageSize(width / sampleSize, height / sampleSize);
    }

    /**
     * Scales dimensions according to incoming scale. Returns new object.
     */
    public TravoImageSize scale(float scale) {
        return new TravoImageSize((int) (width * scale), (int) (height * scale));
    }

    @Override
    public String toString() {
        return new StringBuilder(TO_STRING_MAX_LENGHT).append(width).append(SEPARATOR).append(height).toString();
    }
}
