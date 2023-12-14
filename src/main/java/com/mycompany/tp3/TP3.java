/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp3;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author viann
 */
public class TP3 {

    public static void main(String[] args) throws IOException {
        Picture pic=new Picture();

        String nomFichier = "..\\ImagesTestPGM\\baboon.pgm";
        pic.read(nomFichier);
        /*Random rand = new Random();
        System.out.println(pic.getHauteur());
        System.out.println(pic.getLargeur());
        System.out.println(pic.getMax());
        for (int i = 0; i < pic.getHauteur(); i++) {
            for (int j = 0; j < pic.getLargeur(); j++) {
                int test = pic.getPixels()[i][j];
                if (test!=0){
                    System.out.println(test);
                }
                
            }
            
        }*/
        Picture truc=pic.reduction();
        String nomEcriture="..\\ImagesTestPgm\\bebeBaboon.pgm";
        truc.write(nomEcriture);
/*String nomFichier="..\\ImagesTestPgm\\degrade.pgm";
        int l=70;
        pic.setHauteur(l);
        pic.setLargeur(l);
        pic.setPixels(new int[l][l]);
        for (int i=0;i<pic.getHauteur();i++){
            for (int j=0;j<pic.getLargeur(); j++) {
                pic.setPixel(i,j,(i+j)*pic.max/(2*l));
                System.out.println(pic.getPixels()[i][j]);
            }
        }
        pic.write(nomFichier);
*/
    }
}
