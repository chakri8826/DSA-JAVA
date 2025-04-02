class B3Search2dMat2{
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=0,c=matrix[0].length-1;
        while(r<=matrix.length-1 && c>=0){
            if(matrix[r][c]>target) c--;
            else if(matrix[r][c]<target)r++;
            else return true;
        }
        return false;
    }
}
