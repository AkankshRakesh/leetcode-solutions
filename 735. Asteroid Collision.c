void deleteVal(int* arr, int* n, int i) {
    for (int j = i; j < *n - 1; j++) {
        arr[j] = arr[j + 1];
    }
    (*n)--;
}

void collision(int* arr, int* n, int l, int r) {
    for (int i = r; i > l; i--) {
        if (arr[i] < 0 && arr[i - 1] > 0) {
            if (-arr[i] > arr[i - 1]) {
                deleteVal(arr, n, i - 1);
            } else if (-arr[i] == arr[i - 1]) {
                deleteVal(arr, n, i);
                deleteVal(arr, n, i - 1);
                return;
            } else {
                deleteVal(arr, n, i);
                return;
            }
        }
    }
}

int* asteroidCollision(int* asteroids, int n, int* returnSize) {
    int* result = (int*)malloc(n * sizeof(int));
    int resultSize = n;
    for (int i = 0; i < n; i++) {
        result[i] = asteroids[i];
    }

    int i = 1;
    while (i < resultSize) {
        if (result[i] < 0 && result[i - 1] > 0) {
            collision(result, &resultSize, i - 1, i);
            if (i > 1) {
                i--; // recheck the previous element after a collision
            }
        } else {
            i++;
        }
    }

    *returnSize = resultSize;
    return result;
}