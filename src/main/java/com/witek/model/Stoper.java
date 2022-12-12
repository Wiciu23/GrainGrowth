package com.witek.model;

import java.time.Duration;
import java.time.Instant;

public class Stoper {
    private Instant simulation_start;
    private Instant simulation_stop;
    private Instant preparation_start;
    private Instant preparation_stop;
    private Instant saving_start;
    private Instant saving_stop;

    private float simulation_time;
    private float preparation_time;
    private float saving_time;


    public void simulationStart(){
        simulation_start = Instant.now();
    }

    public void preparationStart(){
        preparation_start = Instant.now();
    }

    public void savingStart(){
        saving_start = Instant.now();
    }

    public void simulationStop(){
        simulation_time = Duration.between(simulation_start,Instant.now()).toMillis()/1000f;
    }

    public void preparationStop(){
        preparation_time = Duration.between(preparation_start,Instant.now()).toMillis()/1000f;
    }

    public void savingStop(){
        saving_time = Duration.between(saving_start,Instant.now()).toMillis()/1000f;
    }

    public double getSimulation_time() {
        return simulation_time;
    }

    public double getPreparation_time() {
        return preparation_time;
    }

    public double getSaving_time() {
        return saving_time;
    }
}
