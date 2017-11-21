// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// For example,
// Given board =
//
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

class Solution {
    public boolean exist(char[][] board, String word) {
      if (board.length == 0) return false;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          if (backtrack("", board, word, i, j)) {
              return true;
          }
        }
      }
      return false;
    }

    private boolean backtrack(String result, char[][] board, String word, int i, int j) {
      if (i >= board.length || i < 0) return false;
      if (j >= board[0].length || j < 0) return false;
      if (result.length() >= word.length()) return false;
      if (board[i][j] != word.charAt(result.length())) return false;
      if (board[i][j] == '#') return false;
      char oldValue = board[i][j];
      String newWord = result + board[i][j];
      // This is quite necessary to prevent to have a loop in the backtracking process
      board[i][j] = '#';

      if (newWord.equals(word)) {
          return true;
      }
      boolean b = backtrack(newWord, board, word, i + 1, j) ||
             backtrack(newWord, board, word, i, j + 1) ||
             backtrack(newWord, board, word, i - 1, j) ||
             backtrack(newWord, board, word, i, j - 1);
      board[i][j] = oldValue;
      return b;
    }
}
