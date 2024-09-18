import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        
        Double[] digObjects = new Double[n];
        
        for (int i = 0; i < n; i++) {
            digObjects[i] = (double) nums[i];
        }
//I FUCKING HATE COMPARATORS
        Arrays.sort(digObjects, new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                double ab = combineNumbers(a, b);
                double ba = combineNumbers(b, a);
                return Double.compare(ba, ab);  // Sort in descending order
            }
        });

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < digObjects.length; i++) {
            str.append(digObjects[i].intValue());
        }

        if (str.charAt(0) == '0') {
            return "0";
        }
        
        return str.toString();
    }
    
    private double combineNumbers(double a, double b) {
        int bDigits = (int) Math.floor(Math.log10(b == 0 ? 1 : b)) + 1; // Avoid log10(0) error
        return a * Math.pow(10, bDigits) + b;
    }
}

