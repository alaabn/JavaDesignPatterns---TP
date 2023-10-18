class Rapport {
    private final String title;
    private final String entete;
    private final String content;
    private final String[] images;

    Rapport(String title, String entete, String content, String[] images) {
        this.title = title;
        this.entete = entete;
        this.content = content;
        this.images = images;
    }

    String RapportToString() {
        return this.title;
    }
}

class RapportBuilder {
    private String title;
    private String entete;
    private String content;
    private String[] images;

    public RapportBuilder title(String title) {
        this.title = title;
        return this;
    }

    public RapportBuilder entete(String entete) {
        this.entete = entete;
        return this;
    }

    public RapportBuilder content(String content) {
        this.content = content;
        return this;
    }

    public RapportBuilder images(String[] images) {
        this.images = images;
        return this;
    }

    public Rapport build() {
        return new Rapport(title, entete, content, images);
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        RapportBuilder rapportBuilder = new RapportBuilder();

        String[] imgs = { "image URL" };

        // rapport 1
        rapportBuilder.title("Stage")
                .entete("Rapport Stage")
                .content("Contenu du Raport")
                .images(imgs);
        Rapport rapportDeStage = rapportBuilder.build();

        // rapport 2
        rapportBuilder.title("Stage PFE")
                .entete("Rapport Stage PFE")
                .content("Contenu du Raport")
                .images(imgs);
        Rapport rapportPFE = rapportBuilder.build();

        System.out.println(rapportDeStage.RapportToString());
        System.out.println(rapportPFE.RapportToString());
    }
}