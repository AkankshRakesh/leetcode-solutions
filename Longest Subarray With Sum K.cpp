/*
    Time Complexity: O( N )
    Space Complexity: O( 1 )

    where N is the size of array 'A'.
*/
int longestSubarrayWithSumK(vector < int > a, long long k) {

    int n = a.size();

    // maxLength is used to store the maximum 
    // length of a subarray whose sum = 'k'
    int maxLength = 0;

    // start and end are the starting 
    // and the ending indices of our current
    // subarray
    int start = 0, end = -1;
    long long currentSum = 0;

    // Iterating over 'a'
    while (start < n) {

        // Increasing the right end
        // till our sum <= ?k? or we 
        // are not out of bounds
        while ((end + 1 < n) && (currentSum + a[end + 1] <= k)) {
            currentSum += a[end + 1];
            ++end;
        }

        // We have found a subarray with the
        //  required sum.
        if (currentSum == k) {
            maxLength = max(maxLength, end - start + 1);
        }

        // Shifting the start index
        currentSum -= a[start];
        ++start;
    }

    return maxLength;
}