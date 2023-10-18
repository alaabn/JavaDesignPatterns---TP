interface Personnage {
    void utiliseArmeAttaque(Arme arme);

    void utiliseArmeDefense(Arme arme);
}

interface Arme {
    void utilise();
}

class Heros implements Personnage {
    @Override
    public void utiliseArmeAttaque(Arme arme) {
        arme.utilise();
    }

    @Override
    public void utiliseArmeDefense(Arme arme) {
        arme.utilise();
    }
}

class EpeeMagique implements Arme {
    @Override
    public void utilise() {
        System.out.println("Attaque avec l'épée magique");
    }
}

class Bouclier implements Arme {
    @Override
    public void utilise() {
        System.out.println("Défendre avec bouclier");
    }
}

class Boss implements Personnage {
    @Override
    public void utiliseArmeAttaque(Arme arme) {
        arme.utilise();
    }

    @Override
    public void utiliseArmeDefense(Arme arme) {
        arme.utilise();
    }
}

class Hache implements Arme {
    @Override
    public void utilise() {
        System.out.println("Attaque avec la hache");
    }
}

interface FabriqueObjetsJeux {
    Personnage creerPersonnage();

    Arme creerArmeAttaque();

    Arme creerArmeDefense();
}

class FabriqueHeros implements FabriqueObjetsJeux {
    @Override
    public Personnage creerPersonnage() {
        return new Heros();
    }

    @Override
    public Arme creerArmeAttaque() {
        return new EpeeMagique();
    }

    @Override
    public Arme creerArmeDefense() {
        return new Bouclier();
    }
}

class FabriqueBosss implements FabriqueObjetsJeux {
    @Override
    public Personnage creerPersonnage() {
        return new Boss();
    }

    @Override
    public Arme creerArmeAttaque() {
        return new Hache();
    }

    @Override
    public Arme creerArmeDefense() {
        return new Bouclier();
    }
}

public class AbsractFactoryPattern {
    public static void main(String[] args) {
        FabriqueObjetsJeux fabriqueHeros = new FabriqueHeros();
        Personnage hero = fabriqueHeros.creerPersonnage();
        Arme epee = fabriqueHeros.creerArmeAttaque();
        Arme bouclierHeros = fabriqueHeros.creerArmeDefense();

        FabriqueObjetsJeux fabriqueBoss = new FabriqueBosss();
        Personnage boss = fabriqueBoss.creerPersonnage();
        Arme hache = fabriqueBoss.creerArmeAttaque();
        Arme bouclierBoss = fabriqueBoss.creerArmeDefense();

        hero.utiliseArmeAttaque(epee);
        boss.utiliseArmeDefense(bouclierBoss);

        boss.utiliseArmeAttaque(hache);
        hero.utiliseArmeDefense(bouclierHeros);

    }

}
