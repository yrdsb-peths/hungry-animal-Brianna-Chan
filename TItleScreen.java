import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author Brianna Chan 
 * @version September 2024
 */
public class TItleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
    /**
     * Constructor for objects of class TItleScreen.
     * 
     */
    public TItleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, 251, 130);
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act()
    {
        //start game if space bar pressed
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,468,134);
        elephant.setLocation(459,117);
        Label label = new Label("Press <space > to start", 40);
        addObject(label,290,246);
        Label label2 = new Label("Used \u2190 and \u2192 to Move", 40);
        addObject(label2,294,197);

    }
}
