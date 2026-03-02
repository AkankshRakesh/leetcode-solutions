class minHeap {

    ArrayList<Integer> heap;
    public minHeap() {
        heap = new ArrayList<>();
    }

    public void push(int x) {
        int index = heap.size();
        heap.add(x);
        
        while(index > 0 && heap.get(index) < heap.get((index - 1) / 2)){
            int temp = heap.get(index);
            heap.set(index, heap.get((index - 1) / 2));
            heap.set((index - 1) / 2, temp);
            
            index = (index - 1) / 2;
        }
    }

    public void pop() {
        if(heap.size() == 0) return;
        if(heap.size() == 1){
            heap.remove(0);
            return;
        }
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        
        int index = 0;
        while((2 * index + 1 < heap.size() && heap.get(2 * index + 1) < heap.get(index)) || (2 * index + 2 < heap.size() && heap.get(2 * index + 2) < heap.get(index))){
            if(2 * index + 2 < heap.size() && heap.get(2 * index + 2) < heap.get(2 * index + 1)){
                int temp = heap.get(index);
                heap.set(index, heap.get(2 * index + 2));
                heap.set(2 * index + 2, temp);
                index = 2 * index + 2;
            }
            else{
                int temp = heap.get(index);
                heap.set(index, heap.get(2 * index + 1));
                heap.set(2 * index + 1, temp);
                index = 2 * index + 1;
            }
        }
    }

    public int peek() {
        if(heap.size() == 0) return -1;
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }
}