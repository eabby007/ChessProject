package com.abhi.chessproject;

public class NQueensImpl {

	private Integer noOfQueens;
	
	public NQueensImpl(Integer n) {
		noOfQueens=n;
	}
	
	
	private void saveBoard(Byte chess[][],NQueensDTO obj) {
		
		Byte[][] temp=new Byte[chess.length][chess.length];
		for(int i=0;i<chess.length;i++) {
			for(int j=0;j<chess.length;j++) {
				temp[i][j]=chess[i][j];
			}
		}
		obj.getBoards().add(temp);
		obj.setNoOfSolutions(obj.getNoOfSolutions()+1);
	}
	
	
	public NQueensDTO solveNQ(boolean oneSolution) {
		Byte chess[][]=new Byte[noOfQueens][noOfQueens];
		NQueensDTO nQueensDTO =new NQueensDTO();
		resetBoard(chess);
		
		if(!solveNQUtil(chess,0,oneSolution,nQueensDTO)) {
			return null;
		}
		return nQueensDTO;
		
		
	}


	private boolean solveNQUtil(Byte[][] chess, Integer col,boolean oneSolution,NQueensDTO obj) {
		
		if(col>=chess.length) {
			saveBoard(chess,obj);
			return true;
		}
		boolean flag=false;
		for(int i=0;i<chess.length;i++) {
			if(isSafe(chess,i,col)) {
				chess[i][col]=1;
				
				if(oneSolution) {
					if(solveNQUtil(chess,col+1,oneSolution,obj))
						return true;
				}else {//all solutions
					flag=solveNQUtil(chess,col+1,oneSolution,obj)|| flag;
				}
				chess[i][col]=0; //backTrack
			}
		}
		if(oneSolution) 
			return false;
		else
			return flag;
	}


	private boolean isSafe(Byte[][] chess, int row, Integer col) {
		
		int i,j;
		for(i=0;i<col;i++) {
			if(chess[row][i]==1)
				return false;
		}
		
		for(i=row,j=col;i>=0 &&j>=0;i--,j--) {
			if(chess[i][j]==1)
				return false;
		}
		
		for(i=row,j=col;i<chess.length && j>=0;i++,j--) {
			if(chess[i][j]==1)
				return false;
		}
		
		return true;
	}


	private void resetBoard(Byte[][] chess) {
		for(int i=0;i<chess.length;i++) {
			for(int j=0;j<chess.length;j++) {
				chess[i][j]=0;
			}
		}
		
	}
	
	
}
