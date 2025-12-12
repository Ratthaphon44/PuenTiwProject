/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puentiw;

public class Document {
    private int id;
    private Category category;
    private String title;
    private String filePath;

    public Document(int id, Category category,
                    String title, String filePath) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.filePath = filePath;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getFilePath() {
        return filePath;
    }
}