import java.util.*;

public class Battleship {

  private String[][] board = new String[10][10]; 

  public Battleship(){
    for(int r = 0; r < board.length; r++){
      for(int c = 0; c < board[0].length; c++){
        board[r][c] = "X";
      }
    }
  }

  

  public String toString(){
    String b = "";
    for(String[] r: board){
      for(String c: r){
        b += "[" + c + "]";
      }
      b += "\n";
    }
    return b;
  }

  public void placeShipOnBoard(){
    int chance = (int)(Math.random() * 2) + 1; 
    if(chance == 1){
    int c = (int)(Math.random() * 10);
    int r = (int) (Math.random() * 6);
    for(int i = r; i < r + 5; i++){
        
        board[i][c] = "S"; 
    }
        
    }
    else if(chance == 2){
       // apply the same changes above to this portion
        int r = (int)(Math.random() * 10);
        int c = (int) (Math.random() * 6);
        for(int i = c; i < c + 5; i++){
        board[r][i] = "S";
    }
    }
  }

  public boolean hitMyShip(int r, int c){
    if(board[r][c].equals("S")){
      board[r][c] = "H";  
      return true;
    }
    else{
      return false;
    }
  }
  /*
       This is too complicated.  The ship is sunk when there are five hits; that would be five H's.
       Process each element and count the number of H's.
       int counter = 0;
       for(String[] row : board)  // for each row on the board
         {8
           for(String location : row)  // for each location on the row
            {
               if(location.equals("H"))
                 counter++;
            }
         }
       return counter == 5;  
  */
  public boolean sunkMyShip(){
           int counter = 0;
       for(String[] row : board)  // for each row on the board
         {
           for(String location : row)  // for each location on the row
            {
               if(location.equals("H"))
                 counter++;
            }
         }
       return counter == 5;  
  }

  public static Scanner kbr = new Scanner(System.in);

  public static void main(String[] args) {
    Battleship first = new Battleship();
    first.placeShipOnBoard();
    System.out.println(first.toString());

    
    while(!first.sunkMyShip())
     {
        System.out.println("Enter a row: ");
        int row = kbr.nextInt() - 1;
        System.out.println("Enter a column: ");
        int col = kbr.nextInt() - 1;
        if(first.hitMyShip(row, col) == true){
          System.out.println("You hit my ship");
          System.out.println(first.toString());
        } 
       else{
          System.out.println("You missed");         
       }
     }
        System.out.println(first.sunkMyShip() + "\n" + "You sunk the ship");
    


  }
}
