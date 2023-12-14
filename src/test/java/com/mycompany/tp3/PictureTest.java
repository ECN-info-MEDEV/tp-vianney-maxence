/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.tp3;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;

/**
 *
 * @author viann
 */
public class PictureTest {
    
    public PictureTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("* PictureJUnit5Test: @BeforeClass method");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("* PictureJUnit5Test: @AfterClass method");
    }

    /**
     * Test of setLargeur method, of class Picture.
     */
    @Test
    public void testSetLargeur() {
        System.out.println("setLargeur");
        int largeur = 0;
        Picture instance = new Picture();
        instance.setLargeur(largeur);
        assertEquals(largeur,instance.getLargeur());
    }

    /**
     * Test of setHauteur method, of class Picture.
     */
    @Test
    public void testSetHauteur() {
        System.out.println("setHauteur");
        int hauteur = 0;
        Picture instance = new Picture();
        instance.setHauteur(hauteur);
        assertEquals(hauteur,instance.getHauteur());
    }

    /**
     * Test of setPixels method, of class Picture.
     */
    @Test
    public void testSetPixels() {
        System.out.println("setPixels");
        int[][] pixels = {{0,0},{0,0}};
        Picture instance = new Picture(2,2);
        instance.setPixels(pixels);
        instance.setPixels(pixels);
        assertEquals(pixels,instance.getPixels());
    }

    /**
     * Test of setPixel method, of class Picture.
     */
    @Test
    public void testSetPixel() {
        System.out.println("setPixel");
        int i = 0;
        int j = 0;
        int x = 1;
        Picture instance = new Picture();
        instance.setPixel(i, j, 1);
        assertEquals(x,instance.getPixels()[i][j]);
    }

    /**
     * Test of getLargeur method, of class Picture.
     */
    @Test
    public void testGetLargeur() {
        System.out.println("getLargeur");
        int expResult = 2;
        Picture instance = new Picture(2,2);
        int result = instance.getLargeur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHauteur method, of class Picture.
     */
    @Test
    public void testGetHauteur() {
        System.out.println("getHauteur");
        int expResult = 2;
        Picture instance = new Picture(2,2);
        int result = instance.getHauteur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPixels method, of class Picture.
     */
    @Test
    public void testGetPixels() {
        System.out.println("getPixels");
        Picture instance = new Picture(2,2);
        int[][] expResult =new int[][] {{0,0},{0,0}};
        int[][] result = instance.getPixels();
        System.out.println(instance.getPixels()[0][0]);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of write method, of class Picture.
     */
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void testWrite() {
        System.out.println("write");
        String nomFichier = "";
        Picture instance = new Picture();
        instance.write(nomFichier);
    }

    /**
     * Test of read method, of class Picture.
     */
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void testRead() throws Exception {
        System.out.println("read");
        String filePath = "..\\ImagesTestPgm\\test_do_not_touch.pgm";
        Picture instance = new Picture();
        instance.read(filePath);
    }

    /**
     * Test of agrandissement method, of class Picture.
     */
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void testAgrandissement() {
        System.out.println("agrandissement");
        Picture instance = new Picture();
        Picture expResult = null;
        Picture result = instance.agrandissement();
        assertEquals(expResult, result);
    }

    /**
     * Test of reduction method, of class Picture.
     */
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void testReduction() {
        System.out.println("reduction");
        Picture instance = new Picture();
        Picture expResult = null;
        Picture result = instance.reduction();
        assertEquals(expResult, result);
    }

    
}
