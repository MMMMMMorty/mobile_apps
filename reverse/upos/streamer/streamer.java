package streamer;

import java.io.PrintStream;

/* loaded from: classes2.dex */
public class streamer {
    private boolean[] lfsr;
    private int tap;

    public static void main(String[] args) {
    }

    public streamer() {
        this("01101000010", 8);
    }

    public streamer(String seed, int tap) {
        this.lfsr = new boolean[seed.length()];
        this.tap = (seed.length() - 1) - tap;
        for (int i = 0; i < seed.length(); i++) {
            if (seed.charAt(i) == '0') {
                this.lfsr[i] = false;
            } else {
                this.lfsr[i] = true;
            }
        }
    }

    public int step() {
        boolean[] zArr;
        boolean[] zArr2 = this.lfsr;
        boolean newBit = zArr2[this.tap] ^ zArr2[0];
        int i = 0;
        while (true) {
            zArr = this.lfsr;
            if (i >= zArr.length - 1) {
                break;
            }
            zArr[i] = zArr[i + 1];
            i++;
        }
        int i2 = zArr.length;
        zArr[i2 - 1] = newBit;
        return !newBit ? 0 : 1;
    }

    public int g2() {
        int val = 0;
        for (int i = 0; i < 16; i++) {
            val |= step() << i;
        }
        return val;
    }

    public int generate(int k) {
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp = (temp * 2) + step();
        }
        return temp;
    }

    public String toString() {
        String representation = "";
        for (int i = 0; i < this.lfsr.length; i++) {
            representation = representation + (this.lfsr[i] ? 1 : 0);
        }
        return representation;
    }
}