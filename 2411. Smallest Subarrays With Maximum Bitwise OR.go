func smallestSubarrays(nums []int) []int {
	n := len(nums)
	pos := make([]int, 31)
	for i := range pos {
		pos[i] = -1
	}
	ans := make([]int, n)
	for i := n - 1; i >= 0; i-- {
		j := i
		for bit := 0; bit < 31; bit++ {
			if (nums[i] & (1 << bit)) == 0 {
				if pos[bit] != -1 {
					j = max(j, pos[bit])
				}
			} else {
				pos[bit] = i
			}
		}
		ans[i] = j - i + 1
	}
	return ans
}