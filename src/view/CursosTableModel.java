package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Curso;

/**
 *
 * @author humberto
 */
public class CursosTableModel extends AbstractTableModel{
    public static final int COL_CODIGO = 0;
    public static final int COL_MARCA = 1;
    public static final int COL_MODELO = 2;
    public static final int COL_CHASSI = 3;
    public static final int COL_ANO = 4;
    
    public ArrayList<Cursos> listaVeiculos;
    
    public CursosTableModel(ArrayList<Veiculo> alVeiculos){
        this.listaVeiculos = alVeiculos;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
        Veiculo v = listaVeiculos.get(linha);
        if(coluna == COL_CODIGO){return v.getCodigo();}
        if(coluna == COL_MARCA){return v.getMarca();}
        if(coluna == COL_MODELO){return v.getModelo();}
        if(coluna == COL_CHASSI){return v.getChassi();}
        if(coluna == COL_ANO){return v.getAno();}
        return "";
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public int getRowCount(){
        return listaVeiculos.size();
    }
    
    @Override
    public String getColumnName(int coluna){
        if(coluna == COL_CODIGO){return "Código";}
        if(coluna == COL_MARCA){return "Marca";}
        if(coluna == COL_MODELO){return "Modelo";}
        if(coluna == COL_CHASSI){return "Chassi";}
        if(coluna == COL_ANO){return "Ano";}
        return "";        
    }
}
