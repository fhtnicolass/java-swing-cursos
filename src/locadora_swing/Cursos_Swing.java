/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package locadora_swing;

import java.util.ArrayList;
//import model.daoCurso;
import model.Curso;
import view.CursosView;
/**
 *
 * @author humberto
 */
public class Cursos_Swing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("OK");
        // DaoCursos daoCursos = new DaoCursos();
        //ArrayList<Curso > cursos = daoCursos.buscarTodos(); 
        for(Curso v : cursos){
            System.out.println(v.getNome() + " | " + v.getVagas());
        }
        
        new VeiculoView().setVisible(true);
    }
    
}
