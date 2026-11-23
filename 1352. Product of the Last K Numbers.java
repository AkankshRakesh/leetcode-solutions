class ProductOfNumbers {
    ArrayList<Integer> prefixProd;
    public ProductOfNumbers() {
        prefixProd = new ArrayList<>();
        prefixProd.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            prefixProd = new ArrayList<>();
            prefixProd.add(1);
            return;
        }
        int size = prefixProd.size();
        prefixProd.add(prefixProd.get(size - 1) * num);
    }
    
    public int getProduct(int k) {
        int size = prefixProd.size();
        if(size <= k) return 0;

        return prefixProd.get(size - 1) / prefixProd.get(size - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */ c 