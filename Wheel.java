
/**
 * Write a description of class Wheel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Wheel
{
    private Rectangle body;
    private int position;
    private Circle symbolShape;
    private String symbol;
    private boolean visible;

    /**
     * Constructor for objects of class Wheel
     */
    public Wheel()
    {
        body = new Rectangle();
        body.changeSize(100,50);
        body.moveVertical(85);
        body.changeColor("yellow");
        
        symbolShape = new Circle();
        symbolShape.changeSize(30);
        symbolShape.moveHorizontal(60);
        symbolShape.moveVertical(120);
        
        
        
        symbol = null;
        visible = false;
        position = 1;
    }
    public void makeVisible()
    {
        body.makeVisible();
        
        if (symbol != null){
            symbolShape.makeVisible();
        }
        
        visible = true;
    }
    public void makeInvisible()
    {
        body.makeInvisible();
        symbolShape.makeInvisible();
        visible = false;
    }

    public void setPosition(int newPosition)
    {
        int distance = (newPosition -   position)*60;
        body.moveHorizontal(distance);
        symbolShape.moveHorizontal(distance);
        position=newPosition;   
    }   
    public void setSymbol(String newSymbol)
    {
        symbol = newSymbol;
        symbolShape.changeColor(newSymbol);
        
        if (visible){
            symbolShape.makeVisible();
        }
    }
    }
