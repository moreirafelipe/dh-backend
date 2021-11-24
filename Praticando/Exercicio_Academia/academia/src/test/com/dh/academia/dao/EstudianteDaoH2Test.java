package test.com.dh.academia.dao;

import main.com.dh.academia.dao.ConfiguracionJDBC;
import main.com.dh.academia.dao.IDao;
import main.com.dh.academia.dao.impl.EstudianteDaoH2;
import main.com.dh.academia.model.Estudiante;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
@RunWith(JUnit4.class)
public class EstudianteDaoH2Test {
    private  static IDao<Estudiante> estudianteDao = new EstudianteDaoH2(new ConfiguracionJDBC());

    @BeforeClass
    public static void cargarEstudiantes() {
        estudianteDao.guardar(new Estudiante("1", "EstudianteUno", "ApellidoUno"));
        estudianteDao.guardar(new Estudiante("2", "EstudianteDos", "ApellidoDos"));
        estudianteDao.guardar(new Estudiante("3", "EstudianteTres", "ApellidoTres"));
        estudianteDao.guardar(new Estudiante("4", "EstudianteCuatro", "ApellidoCuatro"));
    }

    @Test
    public  void guardarYBuscarEstudiantesTest() {
        estudianteDao.guardar(new Estudiante("5", "Tomas", "Pereyra"));
        Estudiante estudiante = estudianteDao.buscar("5");
        Assert.assertNotNull(estudiante);
        Assert.assertEquals(estudiante.getNombre(), "Tomas");

    }

    @Test
    public  void traerTodosLosEstudiantesTest() {
        List<Estudiante> estudiantes = estudianteDao.buscarTodos();
        Assert.assertEquals(estudiantes.size(), 5);
    }

    @Test
    public void eliminarEstudianteTest() {
        estudianteDao.eliminar("1");
        Assert.assertEquals(estudianteDao.buscar("1"),null);


    }


}
