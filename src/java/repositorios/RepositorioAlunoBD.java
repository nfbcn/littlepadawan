/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

/**
 *
 * @author Barbara
 */
import basicos.Aluno;
import dao.Dao;
import java.sql.*;

public class RepositorioAlunoBD extends Dao implements RepositorioAluno {
    
   @Override
        public void inserir(Aluno aluno){
        Connection con=null;
        PreparedStatement pstmt = null;
       // ResultSet rs = null;
        
        try {
            con = getConnection(false);
            pstmt = con.prepareStatement("INSERT INTO aluno(nome,matricula,senha) VALUES(?, ?, MD5(?))");
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2,aluno.getMatricula() );
            pstmt.setString(3,aluno.getSenha());
            pstmt.executeUpdate();
         //   rs=pstmt.getGeneratedKeys();
            
           // if(rs.next()){
             //   aluno.setId_aluno(rs.getInt(1));
            //}
            con.commit();
        }catch(SQLException ex){
            try{
                con.rollback();
            }catch(SQLException ex1){
                 throw new RuntimeException(ex1);
            }
             throw new RuntimeException(ex);
        }finally{
            try{
              /*  if(rs!=null){
                    rs.close();
                }
                */
                if(pstmt != null){
                    pstmt.close();
                }
                if(con!=null){
                    con.close();
                }
            }catch(SQLException ex){
                 throw new RuntimeException(ex);
            }
        }
    }
        

       public void remover(Aluno aluno){
           Connection con =null;
           PreparedStatement pstmt = null;
           //ResultSet rs = null;
           
           try{
               con = getConnection(false);
               pstmt = con.prepareStatement("DELETE FROM aluno WHERE ID_ALUNO = ?");
               pstmt.setLong(1, aluno.getId_aluno());
               pstmt.executeUpdate();
               con.commit();
           }catch(SQLException ex){
               try{
                   con.rollback();
               }catch(SQLException ex1){
                    throw new RuntimeException(ex1);
               }
                throw new RuntimeException(ex);
           }finally{
               try{
                   /*if(rs != null){
                       rs.close();
                   }*/
                   
                   if(pstmt!=null){
                       pstmt.close();
                   }
                   
                   if(con!=null){
                       con.close();
                   }
                   
               }catch(SQLException ex){
                    throw new RuntimeException(ex);
               }
           }
           
       }
       
       public void alterar(Aluno aluno){
           Connection con = null;
           PreparedStatement pstmt = null;
           ResultSet rs = null;
           
           try{
               con = getConnection(false);
               pstmt = con.prepareStatement("UPDATE aluno SET nome = ?,senha = ? WHERE id_aluno= ?");
               pstmt.setString(1, aluno.getNome());
               pstmt.setString(2, aluno.getSenha());
               pstmt.executeUpdate();
               con.commit();
           
           }catch (SQLException ex){
               try{
                   con.rollback();
               }catch (SQLException ex1){
                    throw new RuntimeException(ex1);
               }
                 throw new RuntimeException(ex);
           }finally{
               try{
                   if(rs != null){
                       rs.close();
                   }
                   
                   if(pstmt!=null){
                       pstmt.close();
                   }
                   
                   if(con!= null){
                       con.close();
                   }
               }catch(SQLException ex){
                    throw new RuntimeException(ex);
               }
           }
       }
       
       public Aluno procurarPorId(int id_aluno){
           Connection con= null;
           Statement stmt = null;
           ResultSet rs = null;
           Aluno aluno = null;
           
           try{
               con = getConnection(true);
               stmt = con.createStatement();
               rs=stmt.executeQuery("SELECT id_aluno,nome,matricula FROM aluno WHERE id_aluno = "+id_aluno);
               
               if(rs.next()){
                   aluno = new Aluno(rs.getString("nome"),rs.getInt("matricula"));
                   aluno.setId_aluno(rs.getInt("id_aluno"));
                   
               }
           }catch (SQLException ex){
               throw new RuntimeException(ex);
           }finally{
               try{
                   if(rs!=null){
                       rs.close();
                   }
                   if(stmt!= null){
                       stmt.close();
                   }
                   if(con!=null){
                       con.close();
                   }
               }catch (SQLException ex){
                   throw new RuntimeException(ex);
               }
           }
           return aluno;
       }

    @Override
    public Aluno autenticaAluno(String matricula, String senha) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Aluno aluno = null;

        try {
            con = getConnection(true);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT id_aluno,nome,matricula,"
                    + "senha FROM aluno "
                    + "WHERE matricula = '" + matricula
                    + "' AND senha = MD5(" + senha + ")");

            if (rs.next()) {
                aluno = new Aluno(rs.getString("nome"), rs.getString("matricula"), rs.getString("senha"));
                aluno.setId_aluno(rs.getInt("id_aluno"));

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return aluno;
    }
   
}
