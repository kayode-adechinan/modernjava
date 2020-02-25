package com.tips.modernjava.demos;


import java.util.function.Consumer;

class Resource {
    private Resource() {
        System.out.println("resource created");
    }

    public Resource op1() {
        System.out.println("op1 called....");
        return this;
    }

    public Resource op2() {
        System.out.println("op2 called...");
        return this;
    }

    private void close() {
        System.out.println("finalize called....");
    }

    public static void use(Consumer<Resource> block) {
        Resource resource = new Resource();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }
}



public class FreeResource {




    public static void main(String[] args) {


        Resource.use(resource ->
                resource.op1()
                        .op2());



    }


}
