package ticTacToe;

import java.util.ArrayList;

public class Board {
	
	private ArrayList<Integer> board;
	
	public Board() {
		int i = 8;
		while (i >= 0){
			board.add(0);
		}
	}	
}
