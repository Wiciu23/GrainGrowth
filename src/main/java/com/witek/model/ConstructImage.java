package com.witek.model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConstructImage{
    private int[][] PixelArray;
    int width;
    int height;
    BufferedImage image;


    public ConstructImage(int[][] pixelArray) {
        this.PixelArray = pixelArray;
        this.width = pixelArray.length;
        this.height = pixelArray.length;
        this.image = generateImage();


    }

    private BufferedImage generateImage(){
        BufferedImage bufferImage2=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                int Pixel=PixelArray[x][y]<<16 | PixelArray[x][y] << 8 | PixelArray[x][y];
                bufferImage2.setRGB(x, y,Pixel);
            }
        }
    return bufferImage2;
    }

    public void saveImage() throws IOException {
        File outputfile = new File("E:\\Studia_WIMIP\\semestr2\\metody_dyskretne\\Image.jpg");
        ImageIO.write(image, "jpg", outputfile);
    }

    public void displayImage(final String windowTitle) {
        new JFrame(windowTitle) {
            {
                final JLabel label = new JLabel("", new ImageIcon(image), 0);
                add(label);
                pack();
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setVisible(true);
            }
        };
    }
}



