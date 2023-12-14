/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp3;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Logger;



/**
 *
 * @author viann
 */
public class Picture {
    
    private int largeur;
    private int hauteur;
    public final int max=255;
    private int[][] pixels;
    private static final Logger LOG = Logger.getLogger(Picture.class.getName());

    public Picture(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.pixels = new int[largeur][hauteur];
    }

    public Picture() {
        largeur=1;
        hauteur=1;
        pixels=new int[largeur][hauteur];
    }
    
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setPixels(int[][] pixels) {
        this.pixels = pixels;
    }
    
    public void setPixel(int i,int j,int x){
        pixels[i][j]=x;
    }
    
    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int[][] getPixels() {
        return pixels;
    }

    public int getMax() {
        return max;
    }
    
     public void write(String nomFichier) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nomFichier));
         try {
            // En-tête PGM
            bw.write("P2\n");
            bw.write("#\n");
            bw.write(largeur + "  " + hauteur + "\n");
            bw.write(max + "\n");

            // Données de l'image
            for (int i = 0; i < hauteur; i++) {
                for (int j = 0; j < largeur; j++) {
                    bw.write(pixels[i][j] + "  ");
                    if (j%12==11){
                        bw.write("\n");
                    }
                }
                bw.write("\n");
            }
            System.out.println("L'image PGM a été écrite avec succès.");
        } finally {
            bw.close();
        }
    }


    public void read(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        // Lecture de l'en-tête du fichier PGM
        try{
            String head = br.readLine();
            StringTokenizer shlass = new StringTokenizer(head, " ");
            if (!shlass.nextToken().equals("P2")) {
                throw new IOException("Le fichier PGM doit commencer par P2.");
            }

            // Ignorer les commentaires
            String line=br.readLine();
            while (line.startsWith("#")){
                line = br.readLine();
            }

            // Lire les dimensions de l'image
            StringTokenizer shlasser = new StringTokenizer(line, " ");
            int width = Integer.parseInt(shlasser.nextToken());
            int height = Integer.parseInt(shlasser.nextToken());
            this.setHauteur(height);
            this.setLargeur(width);

            // Lire la valeur maximale de gris (ignorée pour l'instant)
            String maxiGris = br.readLine();


            // Lire les données de l'image
            pixels = new int[height][width];
            int i=0;
            int j=0;
            String ligne = br.readLine();
            while (ligne!=null){
                StringTokenizer decoupe = new StringTokenizer(ligne, " ");
                while (decoupe.hasMoreTokens()){
                    pixels[i][j]=Integer.parseInt(decoupe.nextToken());
                    j+=1;
                    if (j==width){
                        j=0;
                        i+=1;
                    }
                }
                ligne = br.readLine();
            }
        }
        finally{
            br.close();
        }
    }
    
    public Picture agrandissement(){
        Picture grand=new Picture();
        grand.hauteur=this.hauteur*2-1;
        grand.largeur=this.largeur*2-1;
        grand.pixels=new int[grand.hauteur][grand.largeur];
        for (int i=0;i<grand.hauteur;i++){
            for (int j = 0; j < grand.largeur; j++) {
                if(i%2==0){
                    if (j%2==0) {
                        grand.pixels[i][j]=this.pixels[i/2][j/2];
                    }else{
                        grand.pixels[i][j]=(this.pixels[i/2][j/2]+this.pixels[i/2][(j+1)/2])/2;
                    }
                }else{
                    if (j%2==0){
                        grand.pixels[i][j]=(this.pixels[i/2][j/2]+this.pixels[(i+1)/2][j/2])/2;
                    }else{
                        grand.pixels[i][j]=(this.pixels[i/2][j/2]+this.pixels[(i+1)/2][j/2]+this.pixels[(i+1)/2][(j+1)/2]+this.pixels[i/2][(j+1)/2])/4;
                    }
                }
            }
        }
        return grand;
    }
    
    public Picture reduction(){
        Picture grand=new Picture();
        grand.hauteur=this.hauteur/2;
        grand.largeur=this.largeur/2;
        grand.pixels=new int[grand.hauteur][grand.largeur];
        for (int i=0;i<grand.hauteur;i++){
            for (int j = 0; j < grand.largeur; j++) {
                grand.pixels[i][j]=(this.pixels[i*2][j*2]+this.pixels[i*2+1][j*2]+this.pixels[i*2+1][j*2+1]+this.pixels[i*2][j*2+1])/4;
            }
        }
        return grand;
    }
}