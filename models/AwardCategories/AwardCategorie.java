package models.AwardCategories;

public class AwardCategorie {
    private String nome;
    private int ticketsNeeded;
    private int categoryItems;

    public AwardCategorie(String nome, int ticketsNeeded, int categoryItems) {
        this.nome = nome;
        this.ticketsNeeded = ticketsNeeded;
        this.categoryItems = categoryItems;
    }

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getTicketsNeeded() {
        return ticketsNeeded;
    }
    public void setTicketsNeeded(int ticketsNeeded) {
        this.ticketsNeeded = ticketsNeeded;
    }
    public int getCategoryItems() {
        return categoryItems;
    }
    public void setCategoryItems(int categoryItems) {
        this.categoryItems = categoryItems;
    }
}
