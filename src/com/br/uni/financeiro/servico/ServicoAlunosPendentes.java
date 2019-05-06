package com.br.uni.financeiro.servico;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.br.uni.financeiro.interfaceservico.IServicoAlunosPendentes;
import com.br.uni.financeiro.principal.Aluno;

public class ServicoAlunosPendentes extends UnicastRemoteObject implements IServicoAlunosPendentes {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/financeiro";

	static final String USER = "root";
	static final String PASS = "root";
	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServicoAlunosPendentes() throws RemoteException {
		super();
	}

	@Override
	public List<Aluno> listaAlunosComPendencias() throws RemoteException {
		
		   Connection conn = null;
		   Statement stmt = null;
		   List<Aluno> alunos = new ArrayList<>();
		   
		   try{
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connectando ao banco...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = " SELECT al.nome, al.cpf, al.matricula, al.curso, msl.numero_parcela , msl.vencimento ,msl.situacao "+
		    		  " FROM alunos as al INNER JOIN mensalidades as msl ON al.idalunos = msl.aluno_id "+
		    		  " WHERE msl.situacao = 'VENCIDA' ";
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		        
		    	 Aluno aluno = new Aluno();
		    	 
		         aluno.setNome( rs.getString("nome"));
		         aluno.setCpf(rs.getString("cpf"));
		         aluno.setMatricula(rs.getInt("matricula"));
		         String curso = rs.getString("curso");
		         String situacao = rs.getString("situacao");
		         
		         alunos.add(aluno);

		         /*System.out.print("Nome: " + nome);
		         System.out.print(", CPF: " + cpf);
		         System.out.print(", Matricula: " + matricula);
		         System.out.print(", Curso: " + curso);
		         System.out.println(", Situcao: " + situacao);*/
		      }
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		   
		   return alunos;
	}

}
