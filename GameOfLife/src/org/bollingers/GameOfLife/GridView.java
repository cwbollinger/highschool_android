package org.bollingers.GameOfLife;

import android.graphics.*;
import android.app.*;
import android.view.*;

public class GridView extends View
{
  public boolean[][] grid;
  
  private int xSize;
  private int ySize;
  
  private int squareSize;
  
  Paint alive;
  Paint dead;
  
  boolean firstPass = true;
  
  public GridView(Activity a, int xSize, int ySize) {
	  super(a);
	  
  }
  
  private void initialize() {
	  this.xSize = this.getWidth();
	  this.ySize = this.getHeight();
	  squareSize = 10;
	  grid = new boolean[xSize][ySize];
	  randomizeGrid();
	  
	  alive = new Paint();
	  alive.setColor(Color.argb(100,0,255,0));
	  dead = new Paint();
	  dead.setColor(Color.argb(100,0,0,0));
  }
  
  
  public void randomizeGrid() {
	  double rand;
	  for(int x = 0; x < xSize; x++) {
		  for(int y = 0; y < ySize; y++) {
			  rand = Math.random();
			  if(rand < .5){
				  grid[x][y] = false;
			  } else {
				  grid[x][y] = true;
			  }
		  }
	  }
  }
  
  public void clearGrid() {
	  for(int x = 0; x < xSize; x++) {
		  for(int y = 0; y < ySize; y++) {
			  grid[x][y] = false;
		  }
	  }
  }
  
  public void updateGrid() {
	  int count = 0;
	  int up;
	  int right;
	  int down;
	  int left;
	  boolean[][] temp = new boolean[xSize][ySize];
	  for(int x = 0; x < xSize; x++) {
		  for(int y = 0; y < ySize; y++) {
			  count = 0;
			  up = y+1;
			  right = x+1;
			  down = y-1;
			  left = x-1;
			  
			  if(up > ySize-1) {
				  up = 0;
			  }
			  if(right > xSize-1) {
				  right = 0;
			  }
			  if(down < 0) {
				  down = ySize-1;
			  }
			  if(left < 0) {
				  left =  xSize-1;
			  }
			  
			  if(grid[x][up]) {
				  count++;
			  }
			  if(grid[right][up]) {
				  count++;
			  }
			  if(grid[right][y]) {
				  count++;
			  }
			  if(grid[right][down]) {
				  count++;
			  }
			  if(grid[x][down]) {
				  count++;
			  }
			  if(grid[left][down]) {
				  count++;
			  }
			  if(grid[left][y]) {
				  count++;
			  }
			  if(grid[left][up]) {
				  count++;
			  }
			  
			  if(count < 2) {
				  temp[x][y] = false;
			  } else if(count > 3) {
				  temp[x][y] = false;
			  } else if(count == 3) {
				  temp[x][y] = true;
			  } else {
				  temp[x][y] = grid[x][y];
			  }
		  }
	  }
	  grid = temp;
  }

  public void onDraw(Canvas c) {
	  if(firstPass) {
		  firstPass = false;
		  initialize();
	  }
	  c.drawText("Screen width equals:"+this.getWidth()+", xSize: "+xSize, 10, ySize*10+20, alive);
	  c.drawText("Screen height equals:"+this.getHeight()+", ySize: "+ySize, 10, ySize*10+40, alive);
	  c.drawRect(0, 0, xSize*squareSize, ySize*squareSize, dead);
	  for(int x = 0; x < xSize; x++) {
		  for(int y = 0; y < ySize; y++) {
			  if(grid[x][y]) {
				  c.drawRect((float)x*squareSize,(float)y*squareSize,
				  (float)(x+1)*squareSize,(float)(y+1)*squareSize, alive);
			  } 
		  }
	  }
	  
	  updateGrid();
	  invalidate();
	  
	  try {
		  Thread.sleep(100);
	  } catch(Exception e) {
		  System.err.println(e);
	  }
	  	  
  }

}
