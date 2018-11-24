package com.abhi.chessproject;

import java.util.List;
import java.util.ArrayList;

public class NQueensDTO {

	Integer noOfSolutions;
	List<Byte[][]> boards;
	
	
	public NQueensDTO() {
		noOfSolutions=0;
		boards=new ArrayList<>();
	}
	
	public Integer getNoOfSolutions() {
		return noOfSolutions;
	}
	public void setNoOfSolutions(Integer noOfSolutions) {
		this.noOfSolutions = noOfSolutions;
	}
	public List<Byte[][]> getBoards() {
		return boards;
	}
	public void setBoards(List<Byte[][]> boards) {
		this.boards = boards;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Total No. Of Solutions are : ")
		.append(noOfSolutions.toString())
		.append(".\n");
		
		for(int i=0;i<boards.size();i++) {
			Byte[][] chess=boards.get(i);
			for(int x=0;x<chess.length;x++) {
				sb.append("**");
			}
			sb.append("\n");
			for(int j=0;j<chess.length;j++) {
				for(int k=0;k<chess.length;k++) {
					sb.append(chess[j][k].toString())
					.append(" ");
				}
				sb.append("\n");
			}
			for(int x=0;x<chess.length;x++) {
				sb.append("**");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
