class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max = (dimensions[0][0] * dimensions[0][0]) + (dimensions[0][1] * dimensions[0][1]);
        int index = 0;  
        System.out.println(max);
        for(int i = 1; i < dimensions.length; i++){
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            
            int diagLength = (l * l) + (w * w);
            if(diagLength > max){
                index = i;
                max = diagLength;
            }
            else if(diagLength == max){
                if(l * w > dimensions[index][0] * dimensions[index][1]){
                    index = i;
                }
            }
        }
        System.out.println(max);
        return dimensions[index][0] * dimensions[index][1];
    }
}