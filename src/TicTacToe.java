/**
*
* @author Daniel Toader
*/
import java.util.*;

public class TicTacToe {
  public static void main(String [] args) {
    Scanner input = new Scanner(System.in);
    intro();
    play(input);
  }

  public static void intro() {
    System.out.println("Let's play tic-tac-toe!");
    System.out.println("You will need two players.");
  }

  public static void play(Scanner input) {
    int[][] board = new int[3][3];
    boolean win = false;
    int turn = 0;
    int player = 1;
    while (!win) {
      printBoard(board);
      boolean played = false;
      while (!played) {
        played = getPosition(input, board, player);
      }
      turn++;
      if (turn == 9) {
        break; // draw
      }
      win = checkWin(board, player);
      player = playerSwap(player);
    }
    player = playerSwap(player);
    printBoard(board);
    if (win) {
      System.out.println("Player " + player + " has won!");
    } else {
      System.out.println("The game was a draw.");
    }
  }

  public static boolean checkWin(int[][] board, int player) {
    // check rows
    int player1;
    int player2;
    for (int i = 0; i < board.length; i++) {
      player1 = 0;
      player2 = 0;
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 1) {
          player1++;
        } else if (board[i][j] == 2) {
          player2++;
        }
      }
      if (player1 == 3 || player2 == 3) {
        return true;
      }
    }
    // check columns
    for (int i = 0; i < board.length; i++) {
      player1 = 0;
      player2 = 0;
      for (int j = 0; j < board.length; j++) {
        if (board[j][i] == 1) {
          player1++;
        } else if (board[j][i] == 2) {
          player2++;
        }
      }
      if (player1 == 3 || player2 == 3) {
        return true;
      }
    }
    // check diagonals
    player1 = 0;
    player2 = 0;
    if (board[0][0] == 1) {
      player1++;
    } else if (board[0][0] == 2) {
      player2++;
    }
    if (board[1][1] == 1) {
      player1++;
    } else if (board[1][1] == 2) {
      player2++;
    }
    if (board[2][2] == 1) {
      player1++;
    } else if (board[2][2] == 2) {
      player2++;
    }
    if (player1 == 3 || player2 == 3) {
      return true;
    }
    player1 = 0;
    player2 = 0;
    if (board[0][2] == 1) {
      player1++;
    } else if (board[0][2] == 2) {
      player2++;
    }
    if (board[1][1] == 1) {
      player1++;
    } else if (board[1][1] == 2) {
      player2++;
    }
    if (board[2][0] == 1) {
      player1++;
    } else if (board[2][0] == 2) {
      player2++;
    }
    if (player1 == 3 || player2 == 3) {
      return true;
    } else {
      return false;
    }
  }

  public static int playerSwap(int player) {
    if (player == 1) {
      player = 2;
    } else {
      player = 1;
    }
    return player;
  }

  public static boolean getPosition(Scanner input, int[][] board, int player) {
    int row = -1;
    while (row < 0 || row > 2) {
      System.out.print("Player " + player + ", enter row between 1 and "
      + "3: ");
      while (!input.hasNextInt()) {
        System.out.println("must be an integer between 1 and 3. ");
        System.out.print("Enter row: ");
      }
      row = input.nextInt() - 1;
    }
    int column = -1;
    while (column < 0 || column > 2) {
      System.out.print("Player " + player + ", enter column between 1 and"
      + " 3: ");
      while (!input.hasNextInt()) {
        System.out.println("must be an integer between 1 and 3. ");
        System.out.print("Enter column: ");
      }
      column = input.nextInt() - 1;
    }
    if (board[row][column] == 0) {
      board[row][column] = player;
      return true;
    } else {
      System.out.println("Position has already been played. Try again.");
      return false;
    }
  }

  public static void printBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 0) {
          System.out.print(" ");
        } else if (board[i][j] == 1) {
          System.out.print("x");
        } else {
          System.out.print("o");
        }
        if (j < board.length - 1) {
          System.out.print("|");
        }
      }
      System.out.println();
      if (i < board.length - 1) {
        System.out.println("-+-+-");
      }
    }
  }
}
