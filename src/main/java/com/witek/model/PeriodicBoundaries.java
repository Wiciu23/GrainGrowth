package com.witek.model;

public class PeriodicBoundaries implements Condition{
    private int[][][] mesh;

    public PeriodicBoundaries(int[][][] mesh) {
        this.mesh = mesh;
    }

    @Override
    public int[][][] setBoundaries() {
        for(int i = 0; i < mesh.length; i++){
            for(int j = 0; j < mesh.length; j++)
                for(int k = 0; k < mesh.length; k++){
                    if(i == 0) mesh[i][j][k] = mesh[mesh.length-2][j][k];
                    if(i == mesh.length-1) mesh[i][j][k] = mesh[1][j][k];
                    if(j == 0) mesh[i][j][k] = mesh[i][mesh.length-2][k];
                    if(j == mesh.length-1) mesh[i][j][k] = mesh[i][1][k];
                    if(k == 0) mesh[i][j][k] = mesh[i][i][mesh.length-2];
                    if(k == mesh.length-1) mesh[i][j][k] =  mesh[i][j][1];
            }
        }
        return mesh;
    }
}
