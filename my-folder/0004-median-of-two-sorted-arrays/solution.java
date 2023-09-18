import java.util.ArrayList;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> myList= new ArrayList<>();
        //Make a new array:

        while(i < nums1.length && j < nums2.length){
            if (nums1[i] <= nums2[j]){
                myList.add(nums1[i]);
                i++;
            } else {
                myList.add(nums2[j]);
                j++;
            }
        }

        while (i < nums1.length) {
            myList.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            myList.add(nums2[j]);
            j++;
        }


        //Find median
        double len = myList.size();
        double median;
        if(len % 2 == 0){
            int i1 = (int)len / 2 - 1;
            int i2 = i1 + 1;
            median = (myList.get(i1) + myList.get(i2)) / 2.0;
        } else {
            median = myList.get((int)len / 2);
        }
        
        
        
        return median;
    }
}
