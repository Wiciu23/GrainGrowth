package com.witek.model;

public class AbsorbBoundaries implements Condition{

    private int[][][] mesh;

    public AbsorbBoundaries(int[][][] mesh) {
        this.mesh = mesh;
    }

    @Override
    public int[][][] setBoundaries() {
        for(int i = 0; i < mesh.length; i++){
            for(int j = 0; j < mesh.length; j++)
                for(int k = 0; k < mesh.length; k++){
                    if(i == 0) mesh[i][j][k] = 0;
                    if(j == 0) mesh[i][j][k] = 0;
                    if(k == 0) mesh[i][j][k] = 0;
                    if(i == mesh.length-1 ) mesh[i][j][k] = 0;
                    if(j == mesh.length-1 ) mesh[i][j][k] = 0;
                    if(k == mesh.length-1 ) mesh[i][j][k] = 0;
            }
        }
        return mesh;
    }
}
