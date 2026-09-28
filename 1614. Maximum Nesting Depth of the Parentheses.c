int maxDepth(char* s) {
    int max = 0;
    int len = strlen(s);
    int c = 0;
    for(int i = 0; i < len; i++){
        if(s[i] == '('){
            c++;
            printf("tis run");
        }
        else if(s[i] == ')'){
            c--;
        }
        if(c > max){
            max = c;
        }
    }
    return max;
}