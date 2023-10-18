interface Forme {
    void dessiner();
}

class Cercle implements Forme {
    public void dessiner() {
        System.out.println("Cercle ⬤");
    }
}

class Carre implements Forme {
    public void dessiner() {
        System.out.println("Carré ⬛");
    }
}

class Triangle implements Forme {
    public void dessiner() {
        System.out.println("Triangle ⛰");
    }
}

interface FormeFactory {
    Forme creerForme(String type);
}

class FormeFactoryImpl implements FormeFactory {

    public Forme creerForme(String type) {
        if (type.equalsIgnoreCase("CERCLE")) {
            return new Cercle();
        } else if (type.equalsIgnoreCase("CARRE")) {
            return new Carre();
        } else if (type.equalsIgnoreCase("TRIANGLE")) {
            return new Triangle();
        }

        throw new IllegalArgumentException("Type inconnu");
    }

}

public class FactoryMethodPattern {
    public static void main(String[] agrs) {
        FormeFactory factory = new FormeFactoryImpl();

        Forme cercle = factory.creerForme("cercle");
        cercle.dessiner();

        Forme square = factory.creerForme("carre");
        square.dessiner();

        Forme triangle = factory.creerForme("triangle");
        triangle.dessiner();
    }
}