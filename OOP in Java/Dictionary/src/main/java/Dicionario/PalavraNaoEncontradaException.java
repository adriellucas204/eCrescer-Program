package Dicionario;

public class PalavraNaoEncontradaException extends RuntimeException {
    public PalavraNaoEncontradaException(String message) {
        super(message);
    }
}
