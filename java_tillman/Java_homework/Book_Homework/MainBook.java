package Java_homework.Book_Homework;

class MainBook {
    static void main(String[] args) {
        Book Erebos = new Book("Erebos", "Ursula Poznanski");
        
        System.out.println(Erebos.getTitle());
        System.err.println("von: " + Erebos.getAuthor());

        Erebos.setTitle("Worrier Cats: Mondlose Nacht");
        Erebos.setAuthor("Jacob Spanier");

        System.out.println(Erebos.getTitle());
        System.err.println("von: " + Erebos.getAuthor());

        

    }
}
