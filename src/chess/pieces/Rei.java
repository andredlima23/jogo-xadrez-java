package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rei extends ChessPiece {

	public Rei(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
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
		
		return mat;
	}

}
