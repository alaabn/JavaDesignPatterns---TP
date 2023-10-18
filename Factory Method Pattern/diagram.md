```mermaid

classDiagram

class FactoryMethodPattern {
  +main()
}

class Forme {
  <<interface>>
  +dessiner()
}

class FormeFactoryImpl {
  +creerForme(String type)
}

class FormeFactory {
  <<interface>>
  +creerForme(String type)
}

class Cercle {
  +dessiner()
}

class Carre {
  +dessiner()
}

class Triangle {
  +dessiner()
}

Forme <|.. Cercle
Forme <|.. Carre
Forme <|.. Triangle
FormeFactory <|.. FormeFactoryImpl
Forme <-- FormeFactory : creation
FactoryMethodPattern --> FormeFactoryImpl : demande