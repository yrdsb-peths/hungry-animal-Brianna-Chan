import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Brianna Chan
 * @version September 2024
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idle = new GreenfootImage[8];
    
    /**
     * Constructor
     */
    public Elephant()
    {
        for(int i = 0; i < 8; i++)
        {
            idle[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idle[i].scale(70,70);
        }
        setImage(idle[0]);
    }
    
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        
        //remove apple and spawn new one if elephant eats it
        eat();
        
        //animate elephant
        animateElephant();
    }
    
    /**
     * Eat the apple and spawn new apple if apple is eaten
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            
            //cast back world elephant class lives in to call methods in world class
            MyWorld world = (MyWorld) getWorld();
            
            //casll createApple and increaseScore classes
            world.createApple();
            world.increaseScore();
            
            elephantSound.play();
        }
    }
}
