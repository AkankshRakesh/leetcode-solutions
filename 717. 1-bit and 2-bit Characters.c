bool isOneBitCharacter(int* bits, int len) {
    int i = 0;
    while(i < len - 1){
        if(bits[i] == 1){
            i += 2;
        }
        else{
            i++;
        }
    }
    return i == len - 1;
}