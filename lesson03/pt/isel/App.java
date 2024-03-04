package pt.isel;


//import pt.isel.common.Person;
public class App {
    public static void main(String[] args) {

        //Person p = new Person();
        perTypeMethod(); // <=> App.perTypeMethod();

        new App().otherInstanceMethod();
        System.out.println("App from package pt.isel");
    }

    public void perInstanceMethod() {}

    public void otherInstanceMethod() {
        perInstanceMethod(); // <=> this.perInstanceMethod()
    }

    public static void perTypeMethod() {}
}
