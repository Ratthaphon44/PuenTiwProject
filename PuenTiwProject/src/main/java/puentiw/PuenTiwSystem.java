/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puentiw;

import java.util.ArrayList;

public class PuenTiwSystem {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<Document> documents = new ArrayList<>();
    private ArrayList<PretestQuestion> questions = new ArrayList<>();
    private ArrayList<PretestResult> results = new ArrayList<>();

    private User currentUser = null;
    private int nextUserId = 1;
    private int nextDocId = 1;

    public PuenTiwSystem() {
        initSampleData();
    }

    private void initSampleData() {
        Category math = new Category(1, "Math");
        Category sci  = new Category(2, "Science");
        Category eng  = new Category(3, "English");
        Category gen  = new Category(4, "General");

        categories.add(math);
        categories.add(sci);
        categories.add(eng);
        categories.add(gen);

        events.add(new Event(1, "2025-12-10", math,
                "Basic calculus tutoring",
                "Tutoring on limits, derivatives, and integrals for first-year students"));
        events.add(new Event(2, "2025-12-10", eng,
                "Basic grammar tutoring",
                "Basic tenses + sentence structure"));
        events.add(new Event(3, "2025-12-12", sci,
                "Tutoring physics: forces",
                "Free body diagrams and force formulas"));

        documents.add(new Document(nextDocId++, math,
                "Calculus summary PDF", "math_calculus.pdf"));
        documents.add(new Document(nextDocId++, eng,
                "Grammar Exercise 1", "eng_grammar1.pdf"));
        documents.add(new Document(nextDocId++, gen,
                "Midterm exam preparation guide", "general_exam.pdf"));

        questions.add(new PretestQuestion(
                1, math,
                "2 + 3 = ?",
                "4", "5", "6", "7", 'B'));

        questions.add(new PretestQuestion(
                2, math,
                "What is the derivative of x²?",
                "2x", "x", "x^2", "1", 'A'));

        questions.add(new PretestQuestion(
                3, math,
                "What is the integral of 1 dx?",
                "0", "1", "x + C", "2x", 'C'));
    }

    public void registerUser(String name, String email, String password) {
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                throw new IllegalArgumentException("This email is already in use.");
            }
        }
        User user = new User(nextUserId++, name, email, password);
        users.add(user);
    }

    public boolean login(String email, String password) {
        for (User u : users) {
            if (u.getEmail().equals(email) && u.checkPassword(password)) {
                currentUser = u;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public Category findCategoryById(int id) {
        for (Category c : categories) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public ArrayList<Event> getEventsByDate(String date) {
        ArrayList<Event> list = new ArrayList<>();
        for (Event e : events) {
            if (e.getDate().equals(date)) {
                list.add(e);
            }
        }
        return list;
    }

    public Event findEventById(int id) {
        for (Event e : events) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public String joinEvent(int eventId, String note) {
        if (currentUser == null) {
            return "Please log in first.";
        }
        Event e = findEventById(eventId);
        if (e == null) {
            return "This activity was not found.";
        }
        return "Record activity participation: " + e.getTitle()
                + "\nAdditional message: " + note;
    }

    public ArrayList<Document> getDocumentsByCategory(int categoryId) {
        ArrayList<Document> list = new ArrayList<>();
        for (Document d : documents) {
            if (d.getCategory().getId() == categoryId) {
                list.add(d);
            }
        }
        return list;
    }

    public void uploadDocument(Category cat, String title, String filePath) {
        documents.add(new Document(nextDocId++, cat, title, filePath));
    }

    public ArrayList<PretestQuestion> getQuestionsByCategory(int categoryId) {
        ArrayList<PretestQuestion> list = new ArrayList<>();
        for (PretestQuestion q : questions) {
            if (q.getCategory().getId() == categoryId) {
                list.add(q);
            }
        }
        return list;
    }

    public PretestResult savePretestResult(Category category,
                                           int score, int total) {
        if (currentUser == null) {
            return null;
        }
        PretestResult r = new PretestResult(currentUser, category, score, total);
        results.add(r);
        return r;
    }

    public ArrayList<PretestResult> getResultsForCurrentUser() {
        ArrayList<PretestResult> list = new ArrayList<>();
        if (currentUser == null) return list;

        for (PretestResult r : results) {
            if (r.getUser().getId() == currentUser.getId()) {
                list.add(r);
            }
        }
        return list;
    }
}