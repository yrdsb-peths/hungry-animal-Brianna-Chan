import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Brianna Chan
 * @version September 2024
 */
public class Elephant extends Actor
{
    //new elephant sound
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    
    //arrays for different directions elepehant is facing
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    //direction elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Constructor
     */
    public Elephant()
    {
        //for loop for number of frames in spritesheet
        for(int i = 0; i < idleRight.length; i++)
        {
            //run through idle elephant images and resize
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(70,70);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(70,70);
        }
        
        animationTimer.mark();
        
        //initial elephant image
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(4);
            facing = "right";
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
