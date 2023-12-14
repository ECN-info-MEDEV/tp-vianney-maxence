/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp3;

/**
 *
 * @author viann
 */
public class TP31 {
    public static void main(String[] args) {
        Picture pic=new Picture(10,10);
        String nomFichier="..\\ImagesTestPgm\\degrade1.pgm";
        int l=70;
        pic.setHauteur(l);
        pic.setLargeur(l);
        pic.setPixels(new int[l][l]);
        for (int i=0;i<pic.getHauteur();i++){
            for (int j=0;j<pic.getLargeur(); j++) {
                pic.setPixel(i,j,i*pic.max/(l));
            }
        }
        pic.write(nomFichier);
    }
}
