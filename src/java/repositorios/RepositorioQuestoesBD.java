/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

/**
 *
 * @author nikolas
 */
import dao.Dao;
import basicos.Questoes;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class RepositorioQuestoesBD extends Dao implements RepositorioQuestoes {

    @Override
    public void inserir(Questoes q) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            con = getConnection(false);
            pstmt = con.prepareStatement("INSERT INTO questoes(disciplina,assunto,tipo,peso,enunciado,alternativaCorreta,alternativa1,alternativa2,alternativa3,alternativa4)values(?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, q.getDisciplina());
            pstmt.setString(2, q.getAssunto());
            pstmt.setInt(3, q.getTipo());
            pstmt.setFloat(4, q.getPeso());
            pstmt.setString(5, q.getEnunciado());
            pstmt.setString(6, q.getAlternativaCorreta());
            pstmt.setString(7, q.getAlternativa1());
            pstmt.setString(8, q.getAlternativa2());
            pstmt.setString(9, q.getAlternativa3());
            pstmt.setString(10, q.getAlternativa4());

            pstmt.executeUpdate();

            con.commit();

        } catch (SQLException exInserir) {
            //  exInserir.printStackTrace();
            throw new RuntimeException(exInserir);

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException exInserir2) {
                throw new RuntimeException(exInserir2);
            }
        }

    }

    public void remover(Questoes q) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection(false);
            pstmt = con.prepareStatement("DELETE FROM questoes WHERE id = ?");
            pstmt.setInt(1, q.getId());
            pstmt.execute();
            con.commit();
        } catch (SQLException exRemover) {
            throw new RuntimeException(exRemover);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException exRemover2) {
                throw new RuntimeException(exRemover2);
            }

        }


    }

    public void alterar(Questoes q) {
        Connection con = null;
        PreparedStatement pstmt = null;
        System.out.println("Disci" + q.getDisciplina()
                + "Assunto" + q.getAssunto()
                + "Peso " + q.getPeso()
                + "Enunciado " + q.getEnunciado()
                + "Cod " + q.getId());
        try {
            con = getConnection(false);
            pstmt = con.prepareStatement("UPDATE questoes SET disciplina = ?, assunto = ?, tipo = ?, peso = ?, enunciado = ?, alternativaCorreta = ?, alternativa1 = ?, alternativa2 = ?, alternativa3 = ?, alternativa4 = ? WHERE id = ?");
            pstmt.setString(1, q.getDisciplina());
            pstmt.setString(2, q.getAssunto());
            pstmt.setInt(3, q.getTipo());
            pstmt.setFloat(4, q.getPeso());
            pstmt.setString(5, q.getEnunciado());
            pstmt.setString(6, q.getAlternativaCorreta());
            pstmt.setString(7, q.getAlternativa1());
            pstmt.setString(8, q.getAlternativa2());
            pstmt.setString(9, q.getAlternativa3());
            pstmt.setString(10, q.getAlternativa4());
            pstmt.setInt(11, q.getId());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException exAlterar) {
            exAlterar.printStackTrace();
            throw new RuntimeException(exAlterar);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException exAlterar2) {
                throw new RuntimeException(exAlterar2);
            }

        }


    }

    public Questoes procurarPorCodigo(int codigoQuestao) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Questoes q = null;

        try {
            con = getConnection(true);
            pstmt = con.prepareStatement("SELECT *FROM questoes WHERE id = ?");
            pstmt.setInt(1, codigoQuestao);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                q = new Questoes(rs.getString("disciplina"), rs.getString("assunto"), rs.getInt("tipo"), rs.getFloat("peso"), rs.getString("enunciado"), rs.getString("alternativaCorreta"), rs.getString("alternativa1"), rs.getString("alternativa2"), rs.getString("alternativa3"), rs.getString("alternativa4"));
                q.setId(rs.getInt("id"));
            }


        } catch (SQLException exProcurarPorId) {
            throw new RuntimeException(exProcurarPorId);
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

            } catch (SQLException exProcurarPorId2) {
                throw new RuntimeException(exProcurarPorId2);
            }

        }


        return q;
    }

    public Collection<Questoes> listarTodos() {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Questoes q = null;
        List<Questoes> todasQuestoes = new ArrayList<Questoes>();

        try {
            con = getConnection(true);
            pstmt = con.prepareStatement("SELECT * FROM questoes ORDER BY disciplina,assunto");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                q = new Questoes(rs.getString("disciplina"), rs.getString("assunto"), rs.getInt("tipo"), rs.getFloat("peso"), rs.getString("enunciado"), rs.getString("alternativaCorreta"), rs.getString("alternativa1"), rs.getString("alternativa2"), rs.getString("alternativa3"), rs.getString("alternativa4"));
                q.setId(rs.getInt("id"));
                todasQuestoes.add(q);
            }
        } catch (SQLException exListarTodos) {
            throw new RuntimeException(exListarTodos);
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
            } catch (SQLException exListarTodos2) {
                throw new RuntimeException(exListarTodos2);
            }

        }
        return todasQuestoes;
    }

    public ArrayList<String> listarTodasDisciplinas() {


        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String disciplina = null;
        ArrayList<String> todasDisciplinas = new ArrayList<String>();

        try {
            con = getConnection(true);
            pstmt = con.prepareStatement("SELECT DISTINCT disciplina FROM questoes");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                disciplina = rs.getString("disciplina");
                // q.setId(rs.getInt("id"));
                todasDisciplinas.add(disciplina);
            }
        } catch (SQLException exListarTodos) {
            throw new RuntimeException(exListarTodos);
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
            } catch (SQLException exListarTodos2) {
                throw new RuntimeException(exListarTodos2);
            }

        }
        return todasDisciplinas;

    }

    public Collection<String> listarTodosAssuntos() {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String assunto = null;
        Collection<String> todosAssuntos = new ArrayList<String>();

        try {
            con = getConnection(true);
            pstmt = con.prepareStatement("SELECT DISTINCT assunto FROM questoes");
            rs = pstmt.executeQuery();

            while (rs.next()) {
               assunto =  rs.getString("assunto");
                //q.setId(rs.getInt("id"));
                todosAssuntos.add(assunto);
            }
        } catch (SQLException exListarTodos) {
            throw new RuntimeException(exListarTodos);
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
            } catch (SQLException exListarTodos2) {
                throw new RuntimeException(exListarTodos2);
            }

        }
        return todosAssuntos;

    }

    public Collection<Questoes> listarQuestoesPorAssunto(String assuntoEscolhido) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Questoes q = null;
        List<Questoes> questoesPorAssunto = new ArrayList<Questoes>();

        try {
            con = getConnection(true);
            pstmt = con.prepareStatement("SELECT * FROM questoes WHERE assunto = ? ");
            pstmt.setString(1, assuntoEscolhido);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                q = new Questoes(rs.getString("disciplina"), rs.getString("assunto"), rs.getInt("tipo"), rs.getFloat("peso"), rs.getString("enunciado"), rs.getString("alternativaCorreta"), rs.getString("alternativa1"), rs.getString("alternativa2"), rs.getString("alternativa3"), rs.getString("alternativa4"));
                q.setId(rs.getInt("id"));
                questoesPorAssunto.add(q);
            }
        } catch (SQLException exListarTodos) {
            throw new RuntimeException(exListarTodos);
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
            } catch (SQLException exListarTodos2) {
                throw new RuntimeException(exListarTodos2);
            }

        }
        return questoesPorAssunto;
    }
    public Collection<Questoes> listarQuestoesPorDisciplina(String disciplinaEscolhida) {
    
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Questoes q = null;
        List<Questoes> questoesPorDisciplina = new ArrayList<Questoes>();

        try {
            con = getConnection(true);
            pstmt = con.prepareStatement("SELECT * FROM questoes WHERE disciplina = ? ");
            pstmt.setString(1,disciplinaEscolhida);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                q = new Questoes(rs.getString("disciplina"), rs.getString("assunto"), rs.getInt("tipo"), rs.getFloat("peso"), rs.getString("enunciado"), rs.getString("alternativaCorreta"), rs.getString("alternativa1"), rs.getString("alternativa2"), rs.getString("alternativa3"), rs.getString("alternativa4"));
                q.setId(rs.getInt("id"));
                questoesPorDisciplina.add(q);
            }
        } catch (SQLException exListarTodos) {
            throw new RuntimeException(exListarTodos);
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
            } catch (SQLException exListarTodos2) {
                throw new RuntimeException(exListarTodos2);
            }

        }
        return questoesPorDisciplina;
    
    
    }

}

