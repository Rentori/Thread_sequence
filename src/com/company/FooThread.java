package com.company;

class FooThread implements Runnable {
    String name;
    Foo foo;

    FooThread(Foo foo, String name) {
        this.foo = foo;
        this.name = name;
    }

    @Override
    public void run() {
        switch (name) {
            case "A" -> foo.first();
            case "B" -> foo.second();
            case "C" -> foo.third();
        }
    }
}
