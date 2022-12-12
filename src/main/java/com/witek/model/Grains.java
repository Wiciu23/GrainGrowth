package com.witek.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

import static com.witek.placeholder.Utility.cloneArray;

public class Grains {
    final protected int[][][] grains;
    final private int[][][] newGrains;
    final protected Neighbour neighbours;

    public Grains(int[][][] grains, String neighbourMethod) {
        this.grains = grains;
        //this.newGrains = Arrays.stream(grains).map(int[][]::clone).toArray(int[][][]::new);
        this.newGrains = cloneArray(grains);

        if(neighbourMethod == "Moore"){
            this.neighbours = new Moore(grains);}
        else {
            this.neighbours = new Neuman(grains);}

    }

    public int[][][] oneStepGrowth(){
        for(int i = 1 ; i < grains.length -1 ; i++){
            for(int j = 1 ; j < grains.length-1 ; j++)
                for(int k = 1 ; k < grains.length-1; k++){
                    if(grainHasNotBeenSet(i,j,k)){
                        setNewGrains(i,j,k);
                    }
            }
        }
        return newGrains;
    }

    protected void setNewGrains(int x, int y, int k){
        newGrains[x][y][k] = neighbours.getGrainIdByNeighbours(x,y,k);
    }


    protected boolean grainHasNotBeenSet(int x, int y, int k) {
        return grains[x][y][k] == 0;
    }

}
