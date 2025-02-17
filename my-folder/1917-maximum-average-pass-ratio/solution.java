class Solution {
    class ClassRoom {
        int pass;
        int total;
        double gain;

        public ClassRoom(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.gain = calcGain();
        }

        private double calcGain() {
            return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
        }

        public void addStudent() {
            pass++;
            total++;
            gain = calcGain();
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassRoom> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.gain, a.gain);
        });

        for (int[] classroom : classes) {
            ClassRoom skibidiRoom = new ClassRoom(classroom[0], classroom[1]);
            pq.offer(skibidiRoom);
        }

        while (!pq.isEmpty() && extraStudents > 0) {
            ClassRoom classroom = pq.poll();
            classroom.addStudent();
            pq.offer(classroom);
            extraStudents--;
        }

        double passFail = 0;
        while(!pq.isEmpty()){
            ClassRoom ohioSkibidiRizzler = pq.poll();
            passFail += (double) ohioSkibidiRizzler.pass / ohioSkibidiRizzler.total;
        }
        return passFail / classes.length;

    }
}
