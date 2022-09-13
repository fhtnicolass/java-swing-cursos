package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoCursos {
    private Connection conn;
    private Statement st;

    private void conectar(){
        try {
            this.conn = GerenciadorConexao.pegarConexao();
            st = conn.createStatement();
        } catch (ClassNotFoundException e1) {
            System.out.println(e1.getMessage());
        }catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    private void desconectar(){
        try {
            st.close();
            conn.close();
        }catch (SQLException e) {
            System.out.println("Erro ao fechar a conexao: " 
                + e.getMessage());
        }        
    }

    public boolean inserir(Curso v){
        boolean resultado = false;
        try {
            this.conectar();
	    String comando = "INSERT INTO cursos(codigo, nome, supervisor, tipo, vagas, duracao, mensalidade) VALUES (NULL, '" 
                            + v.getNome() + "', '" + v.getSupervisor()
                            + "', '" + v.getTipo()+ "', " + v.getVagas()
                            + ", "+ v.getDuracao() + ", " + v.getMensalidade() + " );";
                            
            
            
            System.out.println(comando);
            st.executeUpdate(comando);
            resultado = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o registro: " 
                + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    public ArrayList<Curso> buscarTodos(){
        ArrayList<Curso> resultados = new ArrayList<Curso>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("select * from cursos order by nome;");
            while(rs.next()){
                Curso v = new Curso();
                v.setCodigo(rs.getInt("codigo"));
                v.setNome(rs.getString("nome"));
                v.setSupervisor(rs.getString("supervisor"));
                v.setTipo(rs.getString("tipo"));
                v.setVagas(rs.getInt("vagas"));
                v.setMensalidade(rs.getDouble("mensalidade"));
                v.setDuracao(rs.getInt("duracao"));
                resultados.add(v);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return resultados;
    }

    public ArrayList<Curso> buscarTodosFiltro(String campo, String filtro){
        ArrayList<Curso> resultados = new ArrayList<Curso>();
        
        if(!campo.equals("nome") && !campo.equals("tipo")){
            return resultados;
        }
        
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * from cursos "
                + " WHERE " + campo + " like '%" + filtro + "%'"
                + " order by nome;");
                  
            while(rs.next()){
                Curso v = new Curso();
                v.setCodigo(rs.getInt("codigo"));
                v.setNome(rs.getString("nome"));
                v.setSupervisor(rs.getString("supervisor"));
                v.setTipo(rs.getString("tipo"));
                v.setVagas(rs.getInt("vagas"));
                v.setMensalidade(rs.getDouble("mensalidade"));
                v.setDuracao(rs.getInt("duracao"));
                resultados.add(v);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return resultados;
    }
    
    public int excluir(int cod){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "delete from cursos where codigo = "
                + cod + ";";
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    } 

    public Curso consultar(int cod){
        Curso v = null;
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("select * from cursos "
                + " where codigo = " + cod + ";");
            if(rs.next()){
                v = new Curso();
                v.setCodigo(rs.getInt("codigo"));
                v.setNome(rs.getString("nome"));
                v.setSupervisor(rs.getString("supervisor"));
                v.setTipo(rs.getString("tipo"));
                v.setVagas(rs.getInt("vagas"));
                v.setMensalidade(rs.getDouble("mensalidade"));
                v.setDuracao(rs.getInt("duracao"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return v;
    }  
    
    public int alterar(Curso v){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "update cursos set nome = '"
            + v.getNome()+ "', supervisor = '" + v.getSupervisor()
            + "', tipo = '" + v.getTipo()+ "', vagas = " + v.getVagas()
            + ", duracao = " + v.getDuracao()+ ", mensalidade = " + v.getMensalidade()
            + " where codigo = " + v.getCodigo() + ";";
            
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return qtde;  
    }
}
