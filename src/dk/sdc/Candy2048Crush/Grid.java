package dk.sdc.Candy2048Crush;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.util.ArrayList;

/**
 * Created by sdc on 7/15/14.
 */


public class Grid extends FrameLayout{
    ArrayList<Tile> tileList = new ArrayList<Tile>();

    public Grid(Context context) {
        this(context, null);
    }

    public Grid(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Grid(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addView(new Tile(this,1,1,2));
    }


    /**
     * Checks if a tile is adjacent to another
     * @param tile1 First tile
     * @param tile2 Second tile
     * @return Returns true if tiles are adjacent
     */
    public boolean isAdjacentTile(Tile tile1, Tile tile2) {
        if((Math.abs(tile1.getxPos()-tile2.getxPos()) == 1 && tile1.getyPos() == tile2.getyPos()) || (Math.abs(tile1.getyPos()-tile2.getyPos()) == 1 && tile1.getxPos() == tile2.getxPos())) {
            return true;
        }
        return false;
    }

    /**
     * Gets the tile from the grid at the x and y coordinates
     * @param x
     * @param y
     * @return Returns the tile found. If no tile is found will return a tile with a value of -1
     */
    public Tile getTileAt(int x, int y) {
        for(int i = 0; i < tileList.size(); i++) {
            Tile temp = tileList.get(i);
            if(temp.getxPos() == x && temp.getyPos() == y) {
                return tileList.get(i);
            }
        }

        return new Tile(null,-1,-1,-1);
    }

    /**
     * Goes through all tiles and detects selected ones
     * @return a list of selected tiles
     */
    public ArrayList<Tile> selectedTiles(){
        ArrayList<Tile> selectedTile = new ArrayList<Tile>();
        for (int i = 0; i< tileList.size(); i++){
            Tile temp = tileList.get(i);
            if (temp.isSelected()) {
                selectedTile.add(tileList.get(i));
            }
        }
        return selectedTile;
    }

    /**
     * Deselects all tiles
     */
    public void deselectAll() {
        for (int i = 0; i<tileList.size(); i++){
            Tile temp = tileList.get(i);
            temp.setSelected(false);
        }
    }
}
