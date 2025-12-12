/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puentiw;

public class Event {
    private int id;
    private String date;
    private Category category;
    private String title;
    private String detail;

    public Event(int id, String date, Category category,
                 String title, String detail) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.title = title;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }
}
