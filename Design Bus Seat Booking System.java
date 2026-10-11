class BusBooking {
    int[][] seats;
    int totalTime = 0;
    int minTime = 0; // equal to totalSeats
    public BusBooking(int n) {
        seats = new int[n + 1][4];
    }
    
    public void toggle(String seat) {
        int sn = seat.charAt(0) - 'A';
        int row = 0;
        for(int i = 1; i < seat.length(); i++){
            row *= 10;
            row += seat.charAt(i) - '0';
        }

        if(seats[row][sn] != 0){
            totalTime -= seats[row][sn];
            minTime--;
            seats[row][sn] = 0;
        }
        else if((sn == 0 && seats[row][1] != 0) || (sn == 3 && seats[row][2] != 0)){
            totalTime += 3;
            minTime++;
            seats[row][sn] = 3;
        }
        else{
            totalTime++;
            minTime++;
            seats[row][sn] = 1;
        }
    }
    
    public int getTotalTime() {
        return totalTime;
    }
    
    public int getMinTime() {
        return minTime;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */