package com.witek.simulation;
import com.witek.model.*;

import java.util.Random;

public class SimulationAC extends Simulation{


    public SimulationAC(int[][][] matrix, String boundary_condition, String neighbour_method, int seeds, Stoper times) {
        super(matrix, boundary_condition, neighbour_method, seeds, times);
    }

    public SimulationAC(int width, int height, int depth, String neighbour_method, String boundary_condition) {
        super(width, height, depth, neighbour_method, boundary_condition);
    }

}
