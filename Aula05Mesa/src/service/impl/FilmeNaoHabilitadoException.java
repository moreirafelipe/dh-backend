package service.impl;

public class FilmeNaoHabilitadoException extends IllegalArgumentException{
    public FilmeNaoHabilitadoException() {
        super("\nFilme não habilitado no seu país!\n");
    }
}
