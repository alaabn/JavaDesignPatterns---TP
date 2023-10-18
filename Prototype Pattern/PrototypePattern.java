import java.util.HashMap;
import java.util.Map;

interface Prototype {
    Document clone();
}

class Document implements Prototype {
    private String title;
    private String contenu;
    private Map<String, String> modifications;

    public Document(String title, String contenu) {
        this.title = title;
        this.contenu = contenu;
        this.modifications = new HashMap<>();
    }

    public Document(Document doc) {
        this.title = doc.title;
        this.contenu = doc.contenu;
        this.modifications = doc.modifications;
    }

    public String getModif(String key) {
        return modifications.get(key);
    }

    public Map<String, String> getModifs() {
        return modifications;
    }

    public void setModif(String key, String value) {
        modifications.put(key, value);
    }

    @Override
    public Document clone() {
        return new Document(this);
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        Document document1 = new Document("doc1", "contenu1");
        document1.setModif("modif1", "fichier1");

        Document document2 = document1.clone();
        document2.setModif("modif2", "fichier2");

        System.out.println(document2.getModifs());
    }
}