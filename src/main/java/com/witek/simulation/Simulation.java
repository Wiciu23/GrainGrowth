package com.witek.simulation;

import com.witek.model.*;

import java.util.Random;

public abstract class Simulation {
    protected int[][][] matrix;
    protected StructGrowthAble structure;
    protected int seeds;
    Condition condition;
    protected Stoper times;

    public Simulation(int[][][] matrix, String boundary_condition, String neighbour_method, int seeds, Stoper times) {
        this.times = times;
        this.times.preparationStart();
        this.matrix = matrix;
        this.seeds = seeds;
        if(boundary_condition.equals("Absorb")){
            condition = new AbsorbBoundaries(matrix);
        }else {
            condition = new PeriodicBoundaries(matrix);
        }
        this.structure = newMacroStructure(matrix, neighbour_method);
        //this.structure = new MacroStructure(matrix, neighbour_method);
        this.times.preparationStop();
    }

    public int[][][] getMatrix() {
        return matrix;
    }


    public Simulation(int width, int height, int depth, String neighbour_method, String boundary_condition) {
        this.matrix = new int[width][height][depth];
        this.structure = newMacroStructure(matrix, neighbour_method);
    }

    MacroStructure newMacroStructure(int[][][] matrix, String neighbour_method) {
        return new MacroStructure(matrix,neighbour_method);
    }

    public void run(){
        generateRandomSeeds();
        for(int i = 0; i <= matrix.length; i++){
            matrix = condition.setBoundaries();
            matrix = structure.grow();
        }
    }
    private void generateRandomSeeds() {
        Random random = new Random();
        for (int i = 0; i < seeds ; i++){
            int x = random.nextInt(matrix.length-2)+1;
            int y = random.nextInt(matrix.length-2)+1;
            int z = random.nextInt(matrix.length-2)+1;
            int seedId = random.nextInt(170)+10;
            matrix[x][y][z] = seedId;
        }
    }
}
