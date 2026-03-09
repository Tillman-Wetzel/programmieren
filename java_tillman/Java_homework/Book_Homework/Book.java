package Java_homework.Book_Homework;

class Book {
    private String title;
    private String author;


    Book(String title, String author) {
        setAuthor(author);
        setTitle(title);
    }


    String getAuthor() {
        return author;
    }

    String getTitle() {
        return title;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setTitle(String title) {
        this.title = title;
    }
}
