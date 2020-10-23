package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Cavalo extends ChessPiece {

	public Cavalo(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "C";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		
		Position p = new Position(0, 0);
		
		
		p.setValues(position.getLinha() - 1, position.getColuna() - 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;	
		}
		
		
		p.setValues(position.getLinha() - 2, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
		mat[p.getLinha()][p.getColuna()] = true;	
		}
		
		
		p.setValues(position.getLinha() - 2, position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
		mat[p.getLinha()][p.getColuna()] = true;	
		}
		
		
		p.setValues(position.getLinha() - 1, position.getColuna() + 2);
		if (getBoard().positionExists(p) && canMove(p)) {
		mat[p.getLinha()][p.getColuna()] = true;	
		}
		
		
		p.setValues(position.getLinha() + 1, position.getColuna() + 2);
		if (getBoard().positionExists(p) && canMove(p)) {
		mat[p.getLinha()][p.getColuna()] = true;	
		}
		
		
		p.setValues(position.getLinha() + 2, position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
		mat[p.getLinha()][p.getColuna()] = true;	
		}
		
		
		p.setValues(position.getLinha() + 2, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
		mat[p.getLinha()][p.getColuna()] = true;	
		}
		
		
		p.setValues(position.getLinha() + 1, position.getColuna() - 2);
		if (getBoard().positionExists(p) && canMove(p)) {
		mat[p.getLinha()][p.getColuna()] = true;	
		}
		
		return mat;
	}

}
