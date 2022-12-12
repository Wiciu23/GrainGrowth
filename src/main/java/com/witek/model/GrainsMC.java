package com.witek.model;
import java.util.ArrayList;
import java.util.Collections;

public class GrainsMC {

    private ArrayList<int[]> indexes;
    private int[][][] grains;
    private Neighbour neighbours;

    public GrainsMC(int[][][] grains,String neighbourMethod) {
        this.grains = grains;
        this.indexes = setIndexes();
        if(neighbourMethod == "Moore"){
            this.neighbours = new Moore(grains);}
        else {
            this.neighbours = new Neuman(grains);}
    }

    public int[][][] oneStepGrowth(){
        Collections.shuffle(indexes);
        for (int[] index: indexes){
            grains[index[0]][index[1]][index[2]] = getGrainIdByEnergy(index[0],index[1],index[2]);
        }
        return grains;
    }

    private ArrayList<int[]> setIndexes(){
        ArrayList<int[]> indexes = new ArrayList<int[]>();
        for(int i = 1; i < this.grains.length-1 ; i++){
            for(int j = 1 ; j < this.grains.length-1 ; j++){
                for (int k = 1 ; k < this.grains.length-1 ; k++){
                    indexes.add(new int[] {i,j,k});
                }
            }
        }
        return indexes;
    }

    private int getGrainIdByEnergy(int x, int y, int z){
            int[] neighbours;

            neighbours = this.neighbours.getNeighbours(x,y,z);
            int centerId = grains[x][y][z];
            return determineIdByEnergy(neighbours,centerId);
    }

    private int determineIdByEnergy(int[] neighbours, int centerId) {

        int max = neighbours.length-1;
        int randomIndex = (int) (Math.random()*max);
        int centerEnergy = 0;
        int otherRandomEnergy = 0;
        int randomNeighbour = neighbours[randomIndex];

        for (int id:
             neighbours) {
            if(id == centerId) centerEnergy++;
            if(id == randomNeighbour) otherRandomEnergy++;
        }
        if(otherRandomEnergy>centerEnergy){
            return randomNeighbour;
        }else{
            return centerId;
        }
    }
}
