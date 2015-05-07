/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import basicos.Resultado;
import dao.Dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nikolas
 */
public class RepositorioResultadoBD extends Dao implements RepositorioResultado{
    
    public void inserir(int id_aluno, String nome_aluno, float nota, float percentual, int acertos){
    
        Connection con=null;
        PreparedStatement pstmt = null;
       // ResultSet rs = null;
        
        try {
            con = getConnection(false);
            pstmt = con.prepareStatement("INSERT INTO resultado(id_aluno, nome_aluno ,nota,percentual,acertos) VALUES(?,?,?,?,?)");
            pstmt.setInt(1, id_aluno);
            pstmt.setString(2,nome_aluno);
            pstmt.setFloat(3,nota);
            pstmt.setFloat(4,percentual);
            pstmt.setInt(5,acertos);
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
    
        public ArrayList<Resultado> visualizarResultado (){
           Connection con= null;
           Statement stmt = null;
           ResultSet rs = null;
           Resultado result = null;
           ArrayList<Resultado> todos = new ArrayList<Resultado>();
           
           try{
               con = getConnection(true);
               stmt = con.createStatement();
               rs=stmt.executeQuery("SELECT * FROM resultado");
               
               while(rs.next()){
                   result = new Resultado(rs.getInt("id_aluno"),rs.getString("nome_aluno"),rs.getFloat("nota"),rs.getFloat("percentual"), rs.getInt("acertos"));
                  
                  
                   
                   todos.add(result);
                   
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
           return todos;
       }
    
}
