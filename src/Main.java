public class Main {
    public static void main(String[] args) {
        Pizza margaritaEspecial = Pizza.Builder.margaritaBuilder()
                .setExtraQueso(true)
                .build();

        System.out.println("1. Margarita con extra queso:");
        System.out.println(margaritaEspecial);
        System.out.println();

        //adfadasgf
        Pizza pepperoniSuave = Pizza.Builder.pepperoniBuilder()
                .setSalsa("tomate")
                .build();

        System.out.println("2. Pepperoni sin picante:");
        System.out.println(pepperoniSuave);
        System.out.println();

        Pizza vegetarianaConJamon = Pizza.Builder.vegetarianaBuilder()
                .addIngrediente("jamón")

                .build();

        System.out.println("3. Vegetariana con jamón:");
        System.out.println(vegetarianaConJamon);
        System.out.println();
//dwadawadawdw
        Pizza personalizada = new Pizza.Builder()
                .setMasa("pan")
                .setSalsa("barbacoa")
                .setQueso("cheddar")
                .addIngrediente("pollo")
                .setTamaño(40)
                .build();

        System.out.println("4. Pizza personalizada:");
        System.out.println(personalizada);
    }
}