package com.br.uni.financeiro;
import java.sql.*;

public class AlunosPendentes {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/financeiro";

   static final String USER = "root";
   static final String PASS = "root";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
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
         
        
         String nome = rs.getString("nome");
         String cpf = rs.getString("cpf");
         int matricula  = rs.getInt("matricula");
         String curso = rs.getString("curso");
         String situacao = rs.getString("situacao");

         System.out.print("Nome: " + nome);
         System.out.print(", CPF: " + cpf);
         System.out.print(", Matricula: " + matricula);
         System.out.print(", Curso: " + curso);
         System.out.println(", Situcao: " + situacao);
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
}
}