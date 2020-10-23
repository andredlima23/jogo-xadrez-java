package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Rei extends ChessPiece {

	private ChessMatch chessMatch;

	public Rei(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Torre && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);

		// Posições possíveis acima do rei
		p.setValues(position.getLinha() - 1, position.getColuna());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Posições possíveis abaixo do rei
		p.setValues(position.getLinha() + 1, position.getColuna());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Posições possíveis a esquerda do rei
		p.setValues(position.getLinha(), position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Posições possíveis a direita do rei
		p.setValues(position.getLinha(), position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Posições possíveis a noroeste do rei
		p.setValues(position.getLinha() - 1, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Posições possíveis a nordeste do rei
		p.setValues(position.getLinha() - 1, position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Posições possíveis a sudoeste do rei
		p.setValues(position.getLinha() + 1, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Posições possíveis a sudeste do rei
		p.setValues(position.getLinha() + 1, position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// #Movimento especial Roque
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #Movimento especial Roque Pequeno
			Position posT1 = new Position(position.getLinha(), position.getColuna() + 3);
			if (testRookCastling(posT1)) {
				Position p1 = new Position(position.getLinha(), position.getColuna() + 1);
				Position p2 = new Position(position.getLinha(), position.getColuna() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getLinha()][position.getColuna() + 2] = true;
				}
			}

			// #Movimento especial Roque Grande
			Position posT2 = new Position(position.getLinha(), position.getColuna() - 4);
			if (testRookCastling(posT2)) {
				Position p1 = new Position(position.getLinha(), position.getColuna() - 1);
				Position p2 = new Position(position.getLinha(), position.getColuna() - 2);
				Position p3 = new Position(position.getLinha(), position.getColuna() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getLinha()][position.getColuna() - 2] = true;
				}
			}
		}

		return mat;
	}

}
