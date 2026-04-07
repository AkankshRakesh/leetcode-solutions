class Robot {
    int w, h;
    int x = 0, y = 0;
    int dir = 0; 

    int[][] directions = {
        {1, 0},  
        {0, 1},  
        {-1, 0}, 
        {0, -1}  
    };

    public Robot(int width, int height) {
        w = width;
        h = height;
    }

    public void step(int num) {
        int cycle = 2 * (w + h - 2);
        num %= cycle;

        if (num == 0) num = cycle;

        while (num > 0) {
            int nx = x + directions[dir][0];
            int ny = y + directions[dir][1];

            if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                dir = (dir + 1) % 4; 
            } else {
                x = nx;
                y = ny;
                num--;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}