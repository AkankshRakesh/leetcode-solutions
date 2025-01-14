int* findThePrefixCommonArray(int* A, int ASize, int* B, int BSize, int* returnSize) {
    int numA[51] = {0};
    int numB[51] = {0};
    int* ans = (int*)malloc(sizeof(int) * ASize);

    int matchedYet = 0;
    for (int i = 0; i < ASize && i < BSize; i++) {
        numA[A[i]]++;
        if (numA[A[i]] == numB[A[i]]) {
            matchedYet++;
        }

        numB[B[i]]++;
        if (numA[B[i]] == numB[B[i]]) {
            matchedYet++;
        }

        ans[i] = matchedYet;
    }

    *returnSize = ASize; 
    return ans;
}