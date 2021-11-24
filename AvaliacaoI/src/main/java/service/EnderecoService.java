package service;

import dao.IDao;
import model.Endereco;
import model.Paciente;

public class EnderecoService {
    private IDao<Endereco> enderecoDao;

    public EnderecoService(IDao<Endereco> enderecoIDao) {this.enderecoDao = enderecoIDao;}
    public Endereco adicionar(Endereco endereco) {return enderecoDao.adicionar(endereco);}
}
