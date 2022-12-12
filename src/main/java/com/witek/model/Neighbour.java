package com.witek.model;

public interface Neighbour {
    int getGrainIdByNeighbours(int x, int y, int k);


    int[] getNeighbours(int x,int y,int z);
}
