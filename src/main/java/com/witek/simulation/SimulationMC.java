package com.witek.simulation;
import com.witek.model.*;

public class SimulationMC extends Simulation{

    private int epochs;

    public SimulationMC(int[][][] matrix, String boundary_condition, String neighbour_method, int seeds, Stoper times, int epochs) {
        super(matrix, boundary_condition, neighbour_method, seeds, times);
        this.epochs = epochs;
    }

    public SimulationMC(int width, int height, int depth, String neighbour_method, String boundary_condition) {
        super(width, height, depth, neighbour_method, boundary_condition);
    }

    @Override
    MacroStructure newMacroStructure(int[][][] matrix, String neighbour_method) {
        return new MacroStructureMC(matrix,neighbour_method);
    }
    @Override
    public void run(){
        for(int i = 0; i < epochs; i++){
            matrix = condition.setBoundaries();
            MacroStructureMC structureMC = (MacroStructureMC) super.structure;
            matrix = structureMC.grow();
        }
    }

}
