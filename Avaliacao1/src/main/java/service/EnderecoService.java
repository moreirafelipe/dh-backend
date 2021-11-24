package service;

import dao.IDao;
import model.Endereco;

public class EnderecoService {
    private IDao<Endereco> enderecoDao;

    public EnderecoService(IDao<Endereco> enderecoDao){
        this.enderecoDao = enderecoDao;
    }
    public Endereco salvar(Endereco endereco){
        return enderecoDao.salvar(endereco);
    }

}
