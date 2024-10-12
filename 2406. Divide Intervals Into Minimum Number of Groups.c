int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int minGroups(int** intervals, int intervalsSize, int* intervalsColSize) {
    int* start = (int*)malloc(intervalsSize * sizeof(int));
    int* end = (int*)malloc(intervalsSize * sizeof(int));
    
    for (int i = 0; i < intervalsSize; i++) {
        start[i] = intervals[i][0];
        end[i] = intervals[i][1];
    }
    
    qsort(start, intervalsSize, sizeof(int), compare);
    qsort(end, intervalsSize, sizeof(int), compare);
    
    int endptr = 0, ans = 0;
    
    for (int i = 0; i < intervalsSize; i++) {
        if (start[i] > end[endptr]) {
            endptr++;
        } else {
            ans++;
        }
    }
    
    free(start);
    free(end);
    
    return ans;
}