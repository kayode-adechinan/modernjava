package com.tips.modernjava.demos;

import java.util.function.Function;
import java.util.function.UnaryOperator;



abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}






public class TextEditor {

    public static void main(String[] args) {

        // First processing object
        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;

        //Second processing object
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");

        // Compose the two functions resulting in a chain of operations.
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);

        String result2 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result2);

    }
}
