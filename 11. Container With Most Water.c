int min(a,b){
    if(a > b){
        return b;
    }
    else{
        return a;
    }
}
int max(a,b){
    if(a > b){
        return a;
    }
    else{
        return b;
    }
}
int maxArea(int* height, int heightSize) {
    int right = heightSize - 1;
    int left = 0;
    int ans = 0;
    while(left <= right){
        int x = min(height[left],height[right])*(right-left);
        if(x > ans){
            ans = x;
        }
        if(height[left]>height[right]){
            right--;
        }
        else{
            left++;
        }
    }
    return ans;
}