class Conway
{
  int grid[][];
  int width;
  int height;
  public Conway(int width, int height){
    this.width = width;
    this.height = height;
    grid = new int[width+2][height+2];
    for(int i=0;i<width+2;i++){
      for(int j=0;j<height+2;j++){
        grid[i][j] = 0;
      }
    }
  }
  private int neighbours(int x,int y){
    int count=0;
    for(int i=x-1;i<=x+1;i++){
      for(int j=y-1;j<=y+1;j++){
        count += grid[i][j];
      }
    }
    count -= grid[x][y];
    return count;
  }

  private int newCell(int x, int y) {
    int cell = grid[x][y];
    int nb = neighbours(x,y);
    if(cell==1){
      if(nb < 2)
        return 0;
      if(nb < 4)
        return 1;
      else
        return 0;
      }
    if(cell==0) {
      if(nb == 3)
        return 1;
      else
        return 0;
      }
      return 0; //default
    }

  public Conway newGeneration() {
    Conway newGeneration = new Conway(width,height);
    for(int i=1;i<width+1;i++)
      for(int j=1;j<height+1;j++)
        newGeneration.grid[i][j] = newCell(i,j);
    return newGeneration;
  }

  public int getCell(int x,int y){
    if(x < width && y < height)
      return grid[1+x][1+y];
    else
      return 0;

  }

  public void setCell(int x, int y,int value){
    if( x < width && y < height)
    grid[1+x][1+y] = value;
  }

  public void toggleCell(int x,int y)
  {
    if(getCell(x,y) == 1)
      setCell(x,y,0);
    else
      setCell(x,y,1);

  }

/*
  public static void main(String[] args)
  {
    int width,height;
    Conway conway;
    System.out.println("Conway's game");
    width = Integer.parseInt(args[0]);
    height = Integer.parseInt(args[1]);
    conway = new Conway(width,height);
    conway = conway.newGeneration();




  }
*/
}
