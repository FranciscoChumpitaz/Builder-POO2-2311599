import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pizza {
    private final String masa;
    private final String salsa;
    private final String queso;
    private final List<String> ingredientes;
    private final boolean extraQueso;
    private final boolean glutenFree;
    private final int tamaño;

    private Pizza(Builder builder) {
        this.masa = builder.masa;
        this.salsa = builder.salsa;
        this.queso = builder.queso;
        this.ingredientes = new ArrayList<>(builder.ingredientes);
        this.extraQueso = builder.extraQueso;
        this.glutenFree = builder.glutenFree;
        this.tamaño = builder.tamaño;
    }

    public String getMasa() { return masa; }
    public String getSalsa() { return salsa; }
    public String getQueso() { return queso; }
    public List<String> getIngredientes() { return new ArrayList<>(ingredientes); }
    public boolean isExtraQueso() { return extraQueso; }
    public boolean isGlutenFree() { return glutenFree; }
    public int getTamaño() { return tamaño; }

    @Override
    public String toString() {
        return "Pizza{" +
                "masa='" + masa + '\'' +
                ", salsa='" + salsa + '\'' +
                ", queso='" + queso + '\'' +
                ", ingredientes=" + ingredientes +
                ", extraQueso=" + extraQueso +
                ", glutenFree=" + glutenFree +
                ", tamaño=" + tamaño +
                '}';
    }

    public static class Builder {
        private String masa;
        private String salsa;
        private String queso;
        private List<String> ingredientes = new ArrayList<>();
        private boolean extraQueso = false;
        private boolean glutenFree = false;
        private int tamaño = 30;

        public Builder setMasa(String masa) {
            this.masa = Objects.requireNonNull(masa);
            return this;
        }

        public Builder setSalsa(String salsa) {
            this.salsa = Objects.requireNonNull(salsa);
            return this;
        }

        public Builder setQueso(String queso) {
            this.queso = Objects.requireNonNull(queso);
            return this;
        }

        public Builder addIngrediente(String ingrediente) {
            this.ingredientes.add(Objects.requireNonNull(ingrediente));
            return this;
        }

        public Builder setExtraQueso(boolean extraQueso) {
            this.extraQueso = extraQueso;
            return this;
        }

        public Builder setGlutenFree(boolean glutenFree) {
            this.glutenFree = glutenFree;
            return this;
        }

        public Builder setTamaño(int tamaño) {
            if (tamaño <= 0) throw new IllegalArgumentException("Tamaño debe ser positivo");
            this.tamaño = tamaño;
            return this;
        }

        public Pizza build() {
            if (masa == null || salsa == null || queso == null) {
                throw new IllegalStateException("Masa, salsa y queso son requeridos");
            }
            return new Pizza(this);
        }

        public static Builder margaritaBuilder() {
            return new Builder()
                    .setMasa("fina")
                    .setSalsa("tomate")
                    .setQueso("mozzarella")
                    .addIngrediente("albahaca");
        }

        public static Builder pepperoniBuilder() {
            return new Builder()
                    .setMasa("tradicional")
                    .setSalsa("picante")
                    .setQueso("mozzarella")
                    .addIngrediente("pepperoni")
                    .addIngrediente("pepperoni");
        }

        public static Builder vegetarianaBuilder() {
            return new Builder()
                    .setMasa("integral")
                    .setSalsa("pesto")
                    .setQueso("mozzarella")
                    .addIngrediente("pimientos")
                    .addIngrediente("cebolla")
                    .addIngrediente("champiñones")
                    .addIngrediente("aceitunas");
        }
    }
}