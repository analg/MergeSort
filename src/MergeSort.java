import java.util.Arrays;

public class MergeSort implements SortI {
	@Override
	public void sort(int[] inOut) {
		int total = inOut.length;
		int[][] sub = new int[total][1];
		for (int i = 0; i < total; i++) {
			sub[i][0] = inOut[i];
		}
		int length = total;
		int halflength;
		while (length / 2 > 0) {
			halflength = (int)(Math.ceil((float)(length) / 2));
			for (int i = 0; i < halflength; i++) {
				sub[i] = (2 * i + 1 < length ? merge(sub[2 * i], sub[2 * i + 1]) : sub[2 * i]);
			}
			length = halflength;
		}
		if (total > 0) {
			System.arraycopy(sub[0], 0, inOut, 0, total);
		}
	}

	protected int[] merge(int[] left, int[] right) {
		int total = left.length + right.length;
		int[] combined = new int[total];
		int leftindex = 0;
		int rightindex = 0;
		for (int i = 0; i < total; i++) {
			if (leftindex < left.length && rightindex < right.length) {
				combined[i] = (left[leftindex] < right[rightindex] ? left[leftindex++] : right[rightindex++]);
			}
			else if (leftindex < left.length) {
				combined[i] = left[leftindex++];
			}
			else {
				combined[i] = right[rightindex++];
			}
		}
		return combined;
	}
}
