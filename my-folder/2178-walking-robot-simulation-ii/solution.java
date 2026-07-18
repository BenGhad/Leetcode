class Robot {
    int w;
    int h;
    String dir;
    int x = 0;
    int y = 0;

    public Robot(int width, int height) {
        w = width;
        h = height;
        dir = "East";
    }

    public void step(int num) {
        int loopah = 2 * (w - 1) + 2 * (h - 1);

        num %= loopah;
        if(num == 0) num = loopah;
        // js walk 

        while(num > 0){
            switch (dir) {
                case "East" -> {
                int available = w - 1 - x;

                if (num <= available) {
                    x += num;
                    num = 0;
                } else {
                    x = w - 1;
                    num -= available;
                    dir = "North";
                }
            }

            case "North" -> {
                int available = h - 1 - y;

                if (num <= available) {
                    y += num;
                    num = 0;
                } else {
                    y = h - 1;
                    num -= available;
                    dir = "West";
                }
            }

            case "West" -> {
                int available = x;

                if (num <= available) {
                    x -= num;
                    num = 0;
                } else {
                    x = 0;
                    num -= available;
                    dir = "South";
                }
            }

            case "South" -> {
                int available = y;

                if (num <= available) {
                    y -= num;
                    num = 0;
                } else {
                    y = 0;
                    num -= available;
                    dir = "East";
                }
            }
        }
        }
    }

    public int[] getPos() {
        return new int[] { x, y };
    }

    public String getDir() {
        return dir;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
