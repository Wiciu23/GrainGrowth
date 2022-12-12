package com.witek.model;

import static com.witek.placeholder.Utility.cloneArray;

public class MacroStructure implements StructGrowthAble{

    protected int[][][] structure;
    private int[][][] newStructure;
    protected String neighbour_method;
    protected Grains grains;

    public void setStructure(int[][][] structure) {
        this.structure = structure;
    }

    @Override
    public int[][][] getStructure() {
        return structure;
    }

    public MacroStructure(int[][][] matrix1, String neighbour_method){
        this.structure = matrix1;
        //this.newStructure = Arrays.stream(matrix1).map(int[][]::clone).toArray(int[][][]::new);
        this.newStructure = cloneArray(matrix1);
        this.neighbour_method = neighbour_method;

    }

    @Override
    public int[][][] grow(){
        if(structure.length < 2){
            System.out.println("ERROR");
        }
            newStructure = oneStepStructure();
            swap(structure,newStructure);
            return structure;
    }

    protected int[][][] oneStepStructure(){
        grains = new Grains(structure,neighbour_method);
        return grains.oneStepGrowth();
    }

    void swap(int[][][] matrix1, int[][][] matrix2){
        for(int i = 0; i < matrix1.length; i++)
            for(int j = 0; j < matrix1.length; j++){
            System.arraycopy(matrix2[i][j], 0, matrix1[i][j], 0, matrix1.length);
        }
    }

}
