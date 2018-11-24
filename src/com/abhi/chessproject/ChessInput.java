package com.abhi.chessproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"/chessInput"},description="Welcome Servlet")
public class ChessInput extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter writer=null;
		try {
			writer=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String name=request.getParameter("userName");
		String noOfQueens=request.getParameter("noOfQueens");
		Boolean flag=Boolean.parseBoolean(request.getParameter("noOfSolutions"));
		
		System.out.println(name+"  !!!"+ flag+"  ");
		NQueensImpl nQueenSolver=new NQueensImpl(Integer.parseInt(noOfQueens));
		NQueensDTO nQueenSolution=nQueenSolver.solveNQ(flag);
		System.out.println(nQueenSolution.toString());
		writer.println(nQueenSolution.toString());
		writer.close();
		//nQueenSolution.toString();
		
		
		
	}
}
