/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package locadora_swing;

import java.util.ArrayList;
import model.DaoCursos;
import model.Curso;
import view.CursoView;
/**
 *
 * @author humberto
 */
public class Locadora_Swing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("OK");
        DaoCursos daoVeiculo = new DaoCursos();
        ArrayList<Curso> cursos = daoVeiculo.buscarTodos();
        for(Curso v : cursos){
            System.out.println(v.getNome()+ " | " + v.getTipo());
        }
        
        new CursoView().setVisible(true);
    }
    
}
