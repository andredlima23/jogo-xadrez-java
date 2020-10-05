package chess;

import boardgame.Board;
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
	
	private void placeNewPiece(char coluna, int linha, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(coluna, linha).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Torre(board, Color.WHITE));
		placeNewPiece('e', 8, new Rei(board, Color.BLACK));
		placeNewPiece('e', 1, new Rei(board, Color.WHITE));
	}

}
