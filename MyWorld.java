import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World our hero lives in
 * 
 * @author Brianna Chan
 * @version September 2024
 */
public class MyWorld extends World
{
    public int score;
    Label scoreLabel;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //create elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300,300);
        
        //create a label
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
    
    /**
     * End game and draw 'game over'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple,x, y);
    }
}
