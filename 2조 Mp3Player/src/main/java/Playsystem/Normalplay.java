/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaySystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 이유나
 */
public class Normalplay implements PlayHandler{
   
    private static BufferedReader BufferedReader;
    
  
    public void stop(){
        System.out.println("재생정지");
    }

    @Override
    public void play() {
        System.out.println("┌-----------------재생 리스트-----------------┐");
    
    }
}
        
