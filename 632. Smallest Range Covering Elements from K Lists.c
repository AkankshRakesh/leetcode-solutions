#include <stdio.h>
#include <limits.h>
#include <stdlib.h>

typedef struct {
    int value;
    int listIdx;
    int elemIdx;
} HeapNode;

int compare(const void* a, const void* b) {
    return ((HeapNode*)a)->value - ((HeapNode*)b)->value;
}

void swap(HeapNode* a, HeapNode* b) {
    HeapNode temp = *a;
    *a = *b;
    *b = temp;
}

void heapify(HeapNode heap[], int n, int i) {
    int smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && compare(&heap[left], &heap[smallest]) < 0) {
        smallest = left;
    }

    if (right < n && compare(&heap[right], &heap[smallest]) < 0) {
        smallest = right;
    }

    if (smallest != i) {
        swap(&heap[i], &heap[smallest]);
        heapify(heap, n, smallest);
    }
}

void pushHeap(HeapNode heap[], int* n, HeapNode value) {
    heap[*n] = value;
    int i = *n;
    (*n)++;

    while (i != 0 && compare(&heap[i], &heap[(i - 1) / 2]) < 0) {
        swap(&heap[i], &heap[(i - 1) / 2]);
        i = (i - 1) / 2;
    }
}

HeapNode popHeap(HeapNode heap[], int* n) {
    HeapNode root = heap[0];
    heap[0] = heap[--(*n)];
    heapify(heap, *n, 0);
    return root;
}

int* smallestRange(int** nums, int numsSize, int* numsColSize, int* returnSize) {
    HeapNode* minHeap = (HeapNode*)malloc(numsSize * sizeof(HeapNode));
    int curMax = INT_MIN;
    int heapSize = 0;

    for (int i = 0; i < numsSize; i++) {
        HeapNode node = {nums[i][0], i, 0};
        pushHeap(minHeap, &heapSize, node);
        if (nums[i][0] > curMax) {
            curMax = nums[i][0];
        }
    }

    int* smallRange = (int*)malloc(2 * sizeof(int));
    smallRange[0] = 0;
    smallRange[1] = INT_MAX;

    while (heapSize > 0) {
        HeapNode curr = popHeap(minHeap, &heapSize);
        int curMin = curr.value, listIdx = curr.listIdx, elemIdx = curr.elemIdx;

        if ((curMax - curMin < smallRange[1] - smallRange[0]) ||
            (curMax - curMin == smallRange[1] - smallRange[0] && curMin < smallRange[0])) {
            smallRange[0] = curMin;
            smallRange[1] = curMax;
        }

        if (elemIdx + 1 < numsColSize[listIdx]) {
            int nextVal = nums[listIdx][elemIdx + 1];
            HeapNode nextNode = {nextVal, listIdx, elemIdx + 1};
            pushHeap(minHeap, &heapSize, nextNode);
            if (nextVal > curMax) {
                curMax = nextVal;
            }
        } else {
            break;
        }
    }

    *returnSize = 2;
    free(minHeap);
    return smallRange;
}
