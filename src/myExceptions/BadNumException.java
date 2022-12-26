package myExceptions;

public class BadNumException extends Exception {
    private String s="Недопустимое кол-во эл-ов";

    @Override
    public String toString(){
        return s;
    }
}
