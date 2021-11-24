package service;

import java.util.Date;

public class RegistroVacinaProxy implements IRegistro{


    @Override
    public void vacinar(Object[] informacoes) {
        if(!comprovarData((Date)(informacoes[1]))) {

        }
    }

    public boolean comprovarData(Date data) {
        return data.after(new Date());
    }
}
