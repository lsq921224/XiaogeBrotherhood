class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int Ay = A.length;
        int Ax = A[0].length;
        int Bx = B[0].length;
        int[][] res = new int[Ay][Bx];
        for (int j = 0; j < Ay; j++) {
            for (int i = 0; i < Bx; i++) { //not Ax careful!, example should be only one length match like 2*3 times 3*2
                for (int k = 0; k < Ax; k++) {
                    if (A[j][k] == 0 || B[k][i] == 0) continue;//better to do skip here to pass
                    res[j][i] += A[j][k] * B[k][i];
                }
            }
        }
        return res;
    }
}
