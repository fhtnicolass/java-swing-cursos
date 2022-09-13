package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Curso;


public class CursosTableModel extends AbstractTableModel{
    public static final int COL_CODIGO = 0;
    public static final int COL_NOME = 1;
    public static final int COL_TIPO = 2;
    public static final int COL_SUPERVISOR = 3;
    public static final int COL_VAGAS = 4;
    public static final int COL_DURACAO = 5;
    public static final int COL_MENSALIDADE = 6;
    
    
    public ArrayList<Curso> listaCursos;
    
    public CursosTableModel(ArrayList<Curso> alVeiculos){
        this.listaCursos = alVeiculos;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
        Curso v = listaCursos.get(linha);
        if(coluna == COL_CODIGO){return v.getCodigo();}
        if(coluna == COL_NOME){return v.getNome();}
        if(coluna == COL_TIPO){return v.getTipo();}
        if(coluna == COL_SUPERVISOR){return v.getSupervisor();}
        if(coluna == COL_VAGAS){return v.getVagas();}
        if(coluna == COL_DURACAO){return v.getDuracao();}
        if(coluna == COL_MENSALIDADE){return v.getMensalidade();}
        return "";
    }
    
    @Override
    public int getColumnCount(){
        return 7;
    }
    
    @Override
    public int getRowCount(){
        return listaCursos.size();
    }
    
    @Override
    public String getColumnName(int coluna){
        if(coluna == COL_CODIGO){return "CODIGO";}
        if(coluna == COL_NOME){return "NOME";}
        if(coluna == COL_TIPO){return "TIPO";}
        if(coluna == COL_SUPERVISOR){return "SUPERVISOR";}
        if(coluna == COL_VAGAS){return "VAGAS";}
        if(coluna == COL_DURACAO){return "DURACAO";}
        if(coluna == COL_MENSALIDADE){return "MENSALIDADE";}
        return "";        
    }
}
