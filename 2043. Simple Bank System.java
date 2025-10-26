class Bank {
    long[] balance;
    int n;
    public Bank(long[] balance) {
        this.balance = balance;
        n = balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        int acc1 = account1 - 1;
        int acc2 = account2 - 1;
        if(acc1 >= n || acc2 >= n || balance[acc1] < money) return false;

        balance[acc1] -= money;
        balance[acc2] += money;

        return true;
    }
    
    public boolean deposit(int account, long money) {
        int acc = account - 1;
        if(acc >= n) return false;

        balance[acc] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        int acc = account - 1;
        if(acc >= n || balance[acc] < money) return false;

        balance[acc] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */