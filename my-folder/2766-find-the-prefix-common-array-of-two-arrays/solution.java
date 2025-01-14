class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[] pref = new int[n];

        pref[0] = (A[0] == B[0]) ? 1 : 0;
        a[A[0]]++;
        b[B[0]]++;

        for(int i = 1; i < n; i++){
            int n1 = A[i];
            int n2 = B[i];
            a[n1]++;
            b[n2]++;

            pref[i] = pref[i - 1];


            if(n1 == n2){
                pref[i]++;
                continue;
            }


            if(a[n2] == 1){
                pref[i]++;
            }
            if(b[n1] == 1){
                pref[i]++;
            }

        }

        return pref;
    }
}
