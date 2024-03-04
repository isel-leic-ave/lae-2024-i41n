
public class App {
    public static void main(String[] args) {
        perTypeMethod(); // <=> App.perTypeMethod();

        new App().otherInstanceMethod();
        System.out.println("App without package");
    }

    public void perInstanceMethod() {}

    public void otherInstanceMethod() {
        perInstanceMethod(); // <=> this.perInstanceMethod()
    }

    public static void perTypeMethod() {}
}
