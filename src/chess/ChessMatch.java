package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.Rei;
import chess.pieces.Torre;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] matrix = new ChessPiece[board.getLinhas()][board.getColunas()];
		for (int i = 0; i < board.getLinhas(); i++) {
			for (int j = 0; j < board.getColunas(); j++) {
				matrix[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
  
		return matrix;
	}
	
	private void initialSetup() {
		board.placePiece(new Torre(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new Rei(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new Rei(board, Color.WHITE), new Position(7, 4));
	}

}
