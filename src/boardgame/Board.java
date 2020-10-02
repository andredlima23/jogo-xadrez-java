package boardgame;

public class Board {

	private int linhas;
	private int colunas;
	private Piece[][] pieces;

	public Board(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pieces = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public Piece piece(int linha, int coluna) {
		return pieces[linha][coluna];
	}

	public Piece piece(Position position) {
		return pieces[position.getLinha()][position.getColuna()];
	}

}
