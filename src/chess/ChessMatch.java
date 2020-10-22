package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Rei;
import chess.pieces.Torre;

public class ChessMatch {
	
	private int turn;
	private Color currentPlayer;
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
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
	
	public boolean [][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition(); 
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		nextTurn();
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
			throw new ChessException("Nao ha peca na posicao inicial!");
		}
		if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("A peca escolhida nao e sua.");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("Nao existem movimentos possiveis para esta peca!");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("A peca escolhida nao pode se mover para a posicao de destino.");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
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
