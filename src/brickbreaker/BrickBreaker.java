/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class BrickBreaker {
  
    public static void main(String[] args) {
        
                 
        
                    JFrame obj=new JFrame();
		Game_Play gamePlay = new Game_Play();
		  
                
                
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Brick Breaker Game");		
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
                
               
                   
                
               
    }

    
    
        }
    

                


