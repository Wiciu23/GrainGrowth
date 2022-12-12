package com.witek;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.witek.model.ConstructImage;
import com.witek.model.Stoper;
import com.witek.placeholder.Configuration;
import com.witek.simulation.Simulation;
import com.witek.simulation.SimulationAC;
import com.witek.simulation.SimulationMC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("E:\\Studia_WIMIP\\semestr2\\metody_dyskretne\\Configuration.xml");
        XmlMapper xmlMapper = new XmlMapper();
        Configuration configuration = null;
        try {
            configuration = xmlMapper.readValue(file, Configuration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String boundaryCondition = configuration.getBoundary();
        String neighboorHood = configuration.getNeighborhood();
        int size = configuration.getSize();
        int[][][] tabela3d = new int[size][size][size];
        int[][][] structure;
        int seeds = configuration.getSeeds();
        int epochs = configuration.getEpochs();
        String method = configuration.getMethod();
        Stoper times_ac = new Stoper();
        Stoper times_mc = new Stoper();
        Simulation symulacja = new SimulationAC(tabela3d,boundaryCondition,neighboorHood, seeds, times_ac);

        times_ac.simulationStart();

        symulacja.run();
        times_ac.simulationStop();

        Simulation symulacja1 = symulacja;
        structure = symulacja1.getMatrix();

        if(method.equals("MC")) {
            times_mc.simulationStart();
            Simulation symulacja_mc = new SimulationMC(structure,boundaryCondition,neighboorHood,seeds,times_mc,epochs);
            symulacja_mc.run();
            times_mc.simulationStop();
            structure = symulacja_mc.getMatrix();
        }


        BufferedWriter writer = new BufferedWriter(new FileWriter("dane.txt"));
        times_ac.savingStart();
        for(int i = 0; i < tabela3d.length ; i++){
            for(int j = 0; j < tabela3d.length ; j++){
                for(int k = 0; k < tabela3d.length ; k++){
                    writer.write(i + " " + j + " " + k + " " + structure[i][j][k] + "\n");
                }
            }
        }

        times_ac.savingStop();

        ConstructImage image = new ConstructImage(structure[tabela3d.length/2]);
        try {
            image.saveImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String time_ac = ("Preparing AC time : " + times_ac.getPreparation_time()+"\n"+
                           "Simulation AC time : " + times_ac.getSimulation_time() +"\n"+
                           "Saving time : " + times_ac.getSaving_time());
        System.out.println(time_ac);

        if(method.equals("MC")) {
            String time_mc = ("Preparing MC time : " + times_mc.getPreparation_time() + "\n" +
                              "Simulation MC time : " + times_mc.getSimulation_time() + "\n" +
                              "Saving time : " + times_ac.getSaving_time());
            System.out.println(time_mc);

        }
        BufferedWriter time_writer = new BufferedWriter(new FileWriter("czasy.txt"));

        if(configuration.isDisplay()){
            image.displayImage("Grains");
        }

    }
}
