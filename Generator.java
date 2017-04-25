public class Fractal{
  int max_iterations = 7;
  private int starting_x_squared;
  private int starting_y_squared;
  private int[][] mat;
  int width;
  int height;
  int threshold;

  public Fractal(int width, int height, int threshold, int starting_x, int starting_y){
    max_iterations = 7;
    starting_x_squared = starting_x*starting_y-(starting_y*starting_y);
    starting_y_squared = 2*starting_x*starting_y;
    mat = new int[width][height];
    this.threshold = threshold;
    this.height = height;
    this.width = width;
  }

  public int[][] gen(){
    for(int row = 0; row<height; row++){
      for(int col = 0; col<width; col++){
        int n = 1;

        int ca = col-(int)width/2;
        int cb = row-(int)height/2;

        int a = (col-(int)width/2)+starting_x_squared;
        int b = (row-(int)height/2)+starting_y_squared;

        if(mod(a, b) >= threshold){
         mat[row][col] = n;
         continue;
        }

        while(n<max_iterations){
          int aa = a*a;
          int bb = -(b*b);
          b = 2*a*b;
          a = aa+bb;
          a+=ca;
          b+=cb;
          n++;
          if(mod(a, b) >= threshold){
            mat[row][col] = n;
            break;
          }
        }
      }
    }
    return mat;
  }

  private int mod(int a, int b){
    return(Math.sqrt(a*a + b*b));
  }

}
