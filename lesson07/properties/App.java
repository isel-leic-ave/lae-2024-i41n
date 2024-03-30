//class Person {
//    private String name;
//
//    public Person(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}


public class App {
    public static void main(String[] args) {
        Person1 p = new Person1("Maria");
        System.out.println(p.getName());

        Person p1 = new Person("Maria");
        System.out.println(p1.getName());

        p.setName("Manuela");
        p1.setName("Joana");
    }
}