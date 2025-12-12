/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puentiw;

public class PretestResult {
    private User user;
    private Category category;
    private int score;
    private int total;

    public PretestResult(User user, Category category,
                         int score, int total) {
        this.user = user;
        this.category = category;
        this.score = score;
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public Category getCategory() {
        return category;
    }

    public int getScore() {
        return score;
    }

    public int getTotal() {
        return total;
    }
}
