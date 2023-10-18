import Screens.Menu;
import Screens.Screen;
import Data.Storage;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Screen current = new Menu(storage);

        while (current != null) {
            current.render();
            current = current.waitNewScreen();
        }
    }
}