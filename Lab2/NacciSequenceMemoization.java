import java.util.HashMap;

public class NacciSequenceMemoization {
    private int[] sequence;
    private HashMap<Integer, Integer> hashSequence;
    private boolean fillControl = true;

    public NacciSequenceMemoization() {
        hashSequence = new HashMap<>();
    }

    public void fillBase(int sequenceDegree, int k) {
        sequence = new int[k + 1];
        for (int i = 0; i < sequenceDegree - 1; i++) {
            sequence[i] = 0;
        }
        sequence[sequenceDegree - 1] = 1;

        // Initialize hashSequence with the initial values
        for (int i = 0; i < sequenceDegree; i++) {
            hashSequence.put(i, sequence[i]);
        }
    }

    public int[] calculateNacci(int sequenceDegree, int k) {
        if (fillControl) {
            this.fillBase(sequenceDegree, k);
            fillControl = false;
        }
    
        if (k < sequenceDegree) {
            return sequence;
        }
    
        for (int i = sequenceDegree; i <= k; i++) {
            if (hashSequence.containsKey(i)) {
                sequence[i] = hashSequence.get(i);
            } else {
                int result = 0;
                for (int j = 1; j <= sequenceDegree; j++) {
                    result += sequence[i - j];
                }
                sequence[i] = result;
                hashSequence.put(i, result);
            }
        }
    
        return sequence;
    }
    

    public static int[] calculateNonMemoizedNacci(int k, int sequenceDegree) {
        int[] sequence = new int[k + 1];
        for (int i = 0; i < sequenceDegree - 1; i++) {
            sequence[i] = 0;
        }
        sequence[sequenceDegree - 1] = 1;
        for (int i = sequenceDegree; i <= k; i++) {
            int result = 0;
            for (int j = 1; j <= sequenceDegree; j++) {
                result += sequence[i - j];
            }
            sequence[i] = result;
        }
        return sequence;
    }

    public int getValueFromHash(int n) {
        return hashSequence.get(n);
    }
}
