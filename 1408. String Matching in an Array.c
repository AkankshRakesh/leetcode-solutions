int myCmp(const void* a, const void* b) {
    const char* s1 = *(const char**)a;
    const char* s2 = *(const char**)b;
    int len1 = strlen(s1);
    int len2 = strlen(s2);

    if (len1 == len2) {
        return strcmp(s1, s2); 
    }
    return len1 - len2; 
}
char** stringMatching(char** words, int wordsSize, int* returnSize) {
    qsort(words, wordsSize, sizeof(char*), myCmp);

    char** ans = (char**)malloc(wordsSize * sizeof(char*));
    *returnSize = 0;

    for (int i = 0; i < wordsSize; i++) {
        for (int j = i + 1; j < wordsSize; j++) {
            if (strstr(words[j], words[i]) != NULL) { 
                ans[(*returnSize)++] = words[i];
                break;
            }
        }
    }

    return ans;
}