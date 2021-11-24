package service.impl;

public class SerieNaoHabilitadaException extends IllegalArgumentException {
    public SerieNaoHabilitadaException() {
        super("\nSérie não habilitada no seu país!\n");
    }
}