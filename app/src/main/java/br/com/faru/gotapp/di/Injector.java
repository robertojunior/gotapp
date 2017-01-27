package br.com.faru.gotapp.di;

import br.com.faru.gotapp.di.component.GOTComponent;

public class Injector {
    private static Injector instance = new Injector();
    private static GOTComponent component;

    public static Injector getInstance() {
        return instance;
    }

    private Injector() {
    }

    public static void initialize(GOTComponent gotComponent) {
        component = gotComponent;
    }

    public static GOTComponent getComponent() {
        if (component != null) {
            return component;
        } else {
            throw new IllegalArgumentException("Impossible to get the component instance. This class must be initialized before");
        }
    }
}
