package com.witek.model;
import com.witek.placeholder.Utility;
import java.util.ArrayList;

public class Moore implements Neighbour{
    private int[][][] matrix;

    public Moore(int[][][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public int getGrainIdByNeighbours(int x, int y, int k) {
        return getMostPopularId(x,y,k);
    }

    private int getMostPopularId(int i, int j, int k) {
        int[] neighbours;
        neighbours = getNeighbours(i,j,k);
        return Utility.mostFrequent(neighbours);
    }

    //BRAKUJE CENTRALNEGO SASIADA NA K+1 I K-1
    @Override
    public int[] getNeighbours(int i, int j, int k) {
        ArrayList<Integer> neighbours = new ArrayList<>();
        if(matrix[i-1][j][k-1] != 0) neighbours.add(matrix[i-1][j][k-1]);
        if(matrix[i-1][j-1][k-1] != 0) neighbours.add(matrix[i-1][j-1][k-1]);
        if(matrix[i+1][j][k-1] != 0) neighbours.add(matrix[i+1][j][k-1]);
        if(matrix[i+1][j+1][k-1] != 0) neighbours.add(matrix[i+1][j+1][k-1]);
        if(matrix[i][j-1][k-1] != 0) neighbours.add(matrix[i][j-1][k-1]);
        if(matrix[i+1][j-1][k-1] != 0) neighbours.add(matrix[i+1][j-1][k-1]);
        if(matrix[i][j+1][k-1] != 0) neighbours.add(matrix[i][j+1][k-1]);
        if(matrix[i+1][j-1][k-1] != 0) neighbours.add(matrix[i+1][j-1][k-1]);

        if(matrix[i-1][j][k] != 0) neighbours.add(matrix[i-1][j][k]);
        if(matrix[i-1][j-1][k] != 0) neighbours.add(matrix[i-1][j-1][k]);
        if(matrix[i+1][j][k] != 0) neighbours.add(matrix[i+1][j][k]);
        if(matrix[i+1][j+1][k] != 0) neighbours.add(matrix[i+1][j+1][k]);
        if(matrix[i][j-1][k] != 0) neighbours.add(matrix[i][j-1][k]);
        if(matrix[i+1][j-1][k] != 0) neighbours.add(matrix[i+1][j-1][k]);
        if(matrix[i][j+1][k] != 0) neighbours.add(matrix[i][j+1][k]);
        if(matrix[i+1][j-1][k] != 0) neighbours.add(matrix[i+1][j-1][k]);

        if(matrix[i-1][j][k+1] != 0) neighbours.add(matrix[i-1][j][k+1]);
        if(matrix[i-1][j-1][k+1] != 0) neighbours.add(matrix[i-1][j-1][k+1]);
        if(matrix[i+1][j][k+1] != 0) neighbours.add(matrix[i+1][j][k+1]);
        if(matrix[i+1][j+1][k+1] != 0) neighbours.add(matrix[i+1][j+1][k+1]);
        if(matrix[i][j-1][k+1] != 0) neighbours.add(matrix[i][j-1][k+1]);
        if(matrix[i+1][j-1][k+1] != 0) neighbours.add(matrix[i+1][j-1][k+1]);
        if(matrix[i][j+1][k+1] != 0) neighbours.add(matrix[i][j+1][k+1]);
        if(matrix[i+1][j-1][k+1] != 0) neighbours.add(matrix[i+1][j-1][k+1]);
        return neighbours.stream().mapToInt(item -> item).toArray();
    }


}
