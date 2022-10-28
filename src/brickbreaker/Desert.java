/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



//DIFFICULT
public class Desert extends JPanel implements KeyListener, ActionListener {
    
    private boolean play = false;
		private int score = 0;
		
		private int totalBricks = 70;
		
		private Timer timer;
		private int delay=8;
		
		private int playerX = 400;
		
		private int ballposX = 120;
		private int ballposY = 350;
                
		private int ballXdir = -2;
		private int ballYdir = -3;
		
		private Map_Generator map;
		
		private int block1Y = 250; 
		private int block1X = 40; 
                
                private int block2Y = 300; 
		private int block2X = 290; 
                
		
                
                
                
                
		public Desert()
		{		
			map = new Map_Generator(7, 10);
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
                        timer=new Timer(delay,this);
			timer.start();
		}
		
		public void paint(Graphics b)
		{    		
                    // background
                    Image img= Toolkit.getDefaultToolkit().getImage("C:\\Users\\{Core2duo\\Desktop\\ABELLA_233_P2_EXAMINATION\\desert.jpg");
                    play= true;
                    super.paintComponent(b);
                    b.drawImage(img,0,0, null);
                
                    setVisible(true);
                    
                    
                    
			// drawing map
			map.draw((Graphics2D) b);
			
			// borders
			b.setColor(Color.black);
			b.fillRect(0, 0, 3, 592);
			b.fillRect(0, 0, 692, 3);
			b.fillRect(691, 0, 3, 592);
			
                        
                         
                        
                        
			// the scores 		
			b.setColor(Color.white);
			b.setFont(new Font("serif",Font.BOLD, 25));
			b.drawString(""+score, 590,30);
			
			// the paddle
			b.setColor(Color.green);
			b.fillRect(playerX, 550, 100, 8);
			
			// the ball
			b.setColor(Color.yellow);
			b.fillOval(ballposX, ballposY, 15, 15);
			
			
			if(!play) {
                            play=false;
			b.drawString("Press left (<) or right (>) arrow key \n to start", 120, 450);
			 b.setFont(new Font("serif",Font.BOLD, 20));
                         b.setColor(Color.green);
                         b.drawString("Press (M) Menu", 300, 500);
			 b.setFont(new Font("serif",Font.BOLD, 20));
                          
			}
			
			
			// when you won the game
			if(totalBricks <= 0)
			{
				 play = false;
                         ballXdir = 0;
	     		 ballYdir = 0;
	             b.setColor(Color.green);
	             b.setFont(new Font("serif",Font.BOLD, 30));
	             b.drawString("You Won", 270,300);
	             b.drawString("Scores: "+score, 275,350);
	             b.setColor(Color.green);
	             b.setFont(new Font("serif",Font.BOLD, 20));           
	             b.drawString("Press (Enter) to Restart", 240,400); 
	             
	             b.setColor(Color.red);
	             b.drawString("Press (E) to Exit", 260, 450);
			}
			
			// when you lose the game
			if(ballposY > 570)
	        {
				 play = false;
	             ballXdir = 0;
	     		 ballYdir = 0;
	             b.setColor(Color.RED);
	             b.setFont(new Font("serif",Font.BOLD, 30));
	             b.drawString("Game Over!", 270,350);
	             b.drawString("Scores: "+score, 275,400);
	             
	            b.setFont(new Font("serif",Font.BOLD, 20)); 
	             b.setColor(Color.green);
	             b.drawString("Press (Enter) to Restart", 240,450); 
	             b.setColor(Color.RED);
	             b.drawString("Press (E) to Quit Game", 230, 480);
	        }
	                
	                
	                
	              
			
			b.dispose();
			
			
			
		}
                
	
                //once ma press ang Enter
		public void keyPressed(KeyEvent e) 
		{
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{        
				if(playerX >= 600)
				{
					playerX = 600;
				}
				else
				{
					moveRight();
				}
	        }
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{          
				if(playerX < 10)
				{
					playerX = 10;
				}
				else
				{
					moveLeft();
				}
	        }		
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{          
				if(!play)
				{
	                             
                                        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{        
				if(playerX >= 600)
				{
					playerX = 600;
				}
				else
				{
					moveRight();
				}
	        }
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{          
				if(playerX < 10)
				{
					playerX = 10;
				}
				else
				{
					moveLeft();
				}
	        }		
					ballposX = 120;
					ballposY = 350;
					ballXdir = -2;
					ballYdir = -3;
					playerX = 400;
					score = 0;
					totalBricks = 70;
					map = new Map_Generator(7, 10);
					
					repaint();
				}
	        }		
	                
	                
	                if (e.getKeyCode() == KeyEvent.VK_E)
			{          
	                	
	                    if(!play){
	                 play= false;
                         
                          System.exit(0);
                         
        
                
                
				     
	                        }
	                    
	        }		
	                
                        if (e.getKeyCode() == KeyEvent.VK_M)
			{          
	                	
	                    if(!play){
                                play=false;
	                       Menu3 jf2= new Menu3();
                               jf2.show();
                             
				     
	                        }
	                    
	        }		
                        
	                

		}

		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
		
		public void moveRight()
		{
			play = true;
			playerX+=45;	
		}
		
		public void moveLeft()
		
		{
			play = true;
			playerX-=45;	 	
		}
		
	        
	        //method para sa bola
		public void actionPerformed(ActionEvent e) 
		{
			timer.start();
			if(play)
			{			
				if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 30, 8)))
				{
					ballYdir = -ballYdir;
					ballXdir = -3;
				}
				else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 70, 550, 30, 8)))
				{
					ballYdir = -ballYdir;
					ballXdir = ballXdir + 2;
				}
				else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 30, 550, 40, 8)))
				{
					ballYdir = -ballYdir;
				}
                                
                    
                                //-------------------------------------------------------------------------------------------------------------- 
                                
			
                                
                                
                                
                                
                                
				// check map collision with the ball		
				A: for(int i = 0; i<map.map.length; i++)
				{
					for(int j =0; j<map.map[0].length; j++)
					{				
						if(map.map[i][j] > 0)
						{
							//scores++;
							int brickX = j * map.brickWidth + 80;
							int brickY = i * map.brickHeight + 50;
							int brickWidth = map.brickWidth;
							int brickHeight = map.brickHeight;
							
							Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);					
							Rectangle ballRect = new Rectangle(ballposX, ballposY, 15, 15);
                                                        Rectangle brickRect = rect;
							
							if(ballRect.intersects(brickRect))
							{					
								map.setBrickValue(0, i, j);
								score+=5;	
								totalBricks--;
								
								// when ball hit right or left of brick
								if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width)	
								{
									ballXdir = -ballXdir;
								}
								// when ball hits top or bottom of brick
								else
								{
									ballYdir = -ballYdir;				
								}
								
								break A;
							}
						}
					}
				}
				
				ballposX += ballXdir;
				ballposY += ballYdir;
				
				if(ballposX < 0)
				{
					ballXdir = -ballXdir;
				}
				if(ballposY < 0)
				{
					ballYdir = -ballYdir;
				}
				if(ballposX > 670)
				{
					ballXdir = -ballXdir;
				}		
				
				repaint();		
			}
		}

    
                                 }
                        
                

    

    
                
    
    
    

