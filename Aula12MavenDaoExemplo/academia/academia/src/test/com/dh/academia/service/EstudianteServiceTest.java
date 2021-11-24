package test.com.dh.academia.service;

import main.com.dh.academia.dao.ConfiguracionJDBC;
import main.com.dh.academia.dao.IDao;
import main.com.dh.academia.dao.impl.EstudianteDaoEnMemoria;
import main.com.dh.academia.dao.impl.EstudianteDaoH2;
import main.com.dh.academia.model.Estudiante;
import main.com.dh.academia.service.EstudianteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class EstudianteServiceTest {

    private IDao<Estudiante> estudianteDaoEnMemoria = new EstudianteDaoEnMemoria(new ArrayList());
    private IDao<Estudiante> estudianteDaoH2 = new EstudianteDaoH2(new ConfiguracionJDBC());
    private EstudianteService estudianteService = new EstudianteService();


    @Before
    public void cargarEstudiantesCambiandoImplementacionDAO() {
        estudianteService.setEstudianteDao(estudianteDaoEnMemoria);
        estudianteService.guardarEstudiante(new Estudiante("1", "EstudianteUno", "ApellidoUno"));
        estudianteService.setEstudianteDao(estudianteDaoH2);
        estudianteService.guardarEstudiante(new Estudiante("2", "EstudianteDos", "ApellidoDos"));


    }
    @Test
    public void buscarEstudiantesCambiandoImplementacionDAO(){
        estudianteService.setEstudianteDao(estudianteDaoEnMemoria);
        Estudiante estudiante = estudianteService.buscar("1");
        Assert.assertEquals(estudiante.getId(),"1");
        Assert.assertEquals(estudiante.getNombre(),"EstudianteUno");
        Assert.assertEquals(estudiante.getApellido(),"ApellidoUno");
        estudianteService.setEstudianteDao(estudianteDaoH2);
        estudiante = estudianteService.buscar("2");
        Assert.assertEquals(estudiante.getId(),"2");
        Assert.assertEquals(estudiante.getNombre(),"EstudianteDos");
        Assert.assertEquals(estudiante.getApellido(),"ApellidoDos");

    }



}
