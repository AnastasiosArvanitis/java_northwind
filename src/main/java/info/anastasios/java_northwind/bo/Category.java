package info.anastasios.java_northwind.bo;

public class Category {

    private int categoryId;
    private String categoryName;
    private String description;

    public Category() {}

    public Category( String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public Category(int categoryId, String categoryName, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }
}
