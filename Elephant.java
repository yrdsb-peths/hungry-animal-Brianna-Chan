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
