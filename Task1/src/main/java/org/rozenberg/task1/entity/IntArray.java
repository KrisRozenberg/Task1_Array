package org.rozenberg.task1.entity;

import java.util.Arrays;

public class IntArray {
    private int[] data;

    public IntArray(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public int[] getData() {
        return Arrays.copyOf(this.data, this.data.length);
    }

    public void setData(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int value: data) {
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }
}
