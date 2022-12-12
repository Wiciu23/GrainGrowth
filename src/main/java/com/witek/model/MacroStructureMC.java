package com.witek.model;

public class MacroStructureMC extends MacroStructure{
    private GrainsMC grains;

    public MacroStructureMC(int[][][] matrix1, String neighbour_method) {
        super(matrix1, neighbour_method);
    }

    @Override
    public int[][][] getStructure() {
        //grains = new GrainsMC(structure,neighbour_method);
         //grains.oneStepGrowth();
         return structure;
    }

    @Override
    protected int[][][] oneStepStructure() {
        grains = new GrainsMC(structure,neighbour_method);
        return grains.oneStepGrowth();
    }
}
