package Exceptions;

//unchecked
public class PalavraNaoEncontradaException extends RuntimeException {
    public PalavraNaoEncontradaException(String message) {
        super(message);
    }

}
