    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

/**
 *
 * @author Barbara
 */
import basicos.Professor;
import dao.Dao;
import java.sql.*;

public class RepositorioProfessorBD extends Dao implements RepositorioProfessor {

    public void inserir(Professor prof) {
        Connection con = null;
        PreparedStatement pstmt = null;
        //   ResultSet rs = null;

        try {
            con = getConnection(false);
            pstmt = con.prepareStatement("INSERT INTO professor (nome,disciplina,siape,senha) VALUES(?, ?, ?, MD5(?))");
            pstmt.setString(1, prof.getNome());
            pstmt.setString(2, prof.getDisciplina());
            pstmt.setInt(3, prof.getSiape());
            pstmt.setString(4, prof.getSenha());
            pstmt.executeUpdate();
            //     rs=pstmt.getGeneratedKeys();

            //   if(rs.next()){
            //     prof.setId_professor(rs.getInt(1));
            //}
            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
            throw new RuntimeException(ex);
        } finally {
            try {
                /*if(rs!=null){
                 rs.close();
                 }*/
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void remover(Professor prof) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection(false);
            pstmt = con.prepareStatement("DELETE FROM professor WHERE id_professor = ?");
            pstmt.setLong(1, prof.getId_professor());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
            throw new RuntimeException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void alterar(Professor prof) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection(false);
            pstmt = con.prepareStatement("UPDATE professor SET nome = ?,disciplina = ?,senha = MD5(?) WHERE id_professor = ?");
            pstmt.setString(1, prof.getNome());
            pstmt.setString(2, prof.getDisciplina());
            pstmt.setString(3, prof.getSenha());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
            throw new RuntimeException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public Professor procurarPorId(int id_professor) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Professor prof = null;

        try {
            con = getConnection(true);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT id_professor,nome,disciplina,siape FROM professor WHERE id_professor = " + id_professor);

            if (rs.next()) {
                prof = new Professor(rs.getString("nome"), rs.getString("disciplina"), rs.getInt("siape"));
                prof.setId_professor(rs.getInt("id_professor"));

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
        return prof;
    }

    @Override
    public Professor procurarPorSiape(int siape) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Professor prof = null;

        try {
            con = getConnection(true);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT id_professor,nome,disciplina,siape,senha FROM professor WHERE siape = " + siape);

            if (rs.next()) {
                prof = new Professor(rs.getString("nome"), rs.getString("disciplina"), rs.getInt("siape"), rs.getString("senha"));
                prof.setId_professor(rs.getInt("id_professor"));

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
        return prof;
    }

    @Override
    public Professor autenticaProfessor(int siape, String senha) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Professor prof = null;

        try {
            con = getConnection(true);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT id_professor,nome,disciplina,"
                    + "siape,senha FROM professor "
                    + "WHERE siape = " + siape
                    + " AND senha = MD5(" + senha + ")");

            if (rs.next()) {
                prof = new Professor(rs.getString("nome"), rs.getString("disciplina"), rs.getInt("siape"));
                prof.setId_professor(rs.getInt("id_professor"));

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
        return prof;
    }
}
