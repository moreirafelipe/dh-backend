package service;

import model.Documento;

public interface IDocumentoService {

    public abstract Documento buscarDocumento(String url, String email);

}
