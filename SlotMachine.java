
/**
 * Simular una maquina tragamonedas.
 * 
 * @author (RodriguezR-VargasC) 
 * @version (1.0 22/08/2026)
 */
import java.util.ArrayList;
public class SlotMachine
{
    private Rectangle body;
    private boolean visible;
    private ArrayList<Wheel> wheels;
    private ArrayList<String> symbols;
    public SlotMachine()
    {
        body = new Rectangle();
        body.changeSize(220,250);
        body.moveHorizontal(-40);
        body.moveVertical(30);
        body.changeColor("black");
        
        wheels = new ArrayList<Wheel>();
        symbols = new ArrayList<String>();
        visible = false;
        
    }
    public void addWheel(int pos)
    {
        int position = adjustedAddPosition(pos);
        Wheel wheel = new Wheel();
        
        wheels.add(position - 1, wheel);
        arrangeWheels();
        
        if (visible){
            wheel.makeVisible(); 
        }
        
    }
    private void arrangeWheels()
    {
        for (int i = 0; i < wheels.size(); i++){
            wheels.get(i).setPosition(i + 1);
        }
    }
    private int adjustedAddPosition(int pos)
    {
        if (pos < 1){
            return 1;
        }
        if (pos > wheels.size()+1){
            return wheels.size() +1;
        }
        return pos;
        }
    public void delWheel(int pos)
    {
        if (wheels.size() > 0){
            int position =adjustedWheelPosition(pos);
            
            Wheel wheel = wheels.get(position-1);
            wheel.makeInvisible();
            
            wheels.remove  (position - 1);
            
            arrangeWheels();
        }
    }
    private int adjustedWheelPosition(int pos)
    {
        if(pos < 1){
                return 1;
        }
        if (pos > wheels.size()){
            return wheels.size();
        }
        return pos;
    }
    public void addSymbol(int pos, String color)
    {
        if (!symbols.contains(color)){
        int position = adjustedSymbolAddPosition(pos);
        symbols.add(position - 1, color);
        }
    }
    private int adjustedSymbolAddPosition(int pos)
    {
        if (pos < 1){
            return 1;
        }
        if (pos >symbols.size() +1 ){
            return symbols.size() + 1;
        }
        return pos;
    }
    public void delSymbol(String symbol)
    {
        symbols.remove(symbol);
    }
    public void placeSymbol(int wheel, String symbol)
    {
        if (!wheels.isEmpty() && symbols.contains(symbol)){
            int position = adjustedWheelPosition(wheel);
            wheels.get(position -1).setSymbol(symbol);
        }
    }
    public void spin(int wheel)
    {
    }
    public void spin()
    {
    }
    public String[] symbols()
    {
        return symbols.toArray(new String[0]);
    }
    public int distinctSymbols()
    {
        return 0;
    }
    public String[] configuration()
    {
        return new String[0];
    }
    
    public boolean isJackpot()
    {
        return false;
    }
    
    public void makeVisible()
    {    
        body.makeVisible();
        
        for (Wheel wheel : wheels) {
            wheel.makeVisible();
        }
        
        visible = true;
    }
    
    public void makeInvisible()
    {
        body.makeInvisible();
        
        for (Wheel wheel : wheels){
            wheel.makeVisible();
        }
        visible = false;
    }
    public void exit()
    {
    }
      
    public boolean ok()
    {
        return false;
    }
    }
