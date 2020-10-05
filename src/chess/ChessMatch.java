package chess;

import boardgame.Board;
import boardgame.Piece;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition(); 
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove (Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("Não há peça na posição inicial!");
		}
	}

	private void placeNewPiece(char coluna, int linha, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(coluna, linha).toPosition());
	}

	private void initialSetup() {
		placeNewPiece('c', 1, new Torre(board, Color.WHITE));
		placeNewPiece('c', 2, new Torre(board, Color.WHITE));
		placeNewPiece('d', 2, new Torre(board, Color.WHITE));
		placeNewPiece('e', 2, new Torre(board, Color.WHITE));
		placeNewPiece('e', 1, new Torre(board, Color.WHITE));
		placeNewPiece('d', 1, new Rei(board, Color.WHITE));

		placeNewPiece('c', 7, new Torre(board, Color.BLACK));
		placeNewPiece('c', 8, new Torre(board, Color.BLACK));
		placeNewPiece('d', 7, new Torre(board, Color.BLACK));
		placeNewPiece('e', 7, new Torre(board, Color.BLACK));
		placeNewPiece('e', 8, new Torre(board, Color.BLACK));
		placeNewPiece('d', 8, new Rei(board, Color.BLACK));
	}

}
