package Screens;

import Data.Storage;

import java.util.Scanner;

public class Menu implements Screen {
    Scanner in = new Scanner(System.in);
    Storage storage;

    public Menu(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void render() {
        System.out.println("0. Список архивов");
        System.out.println("1. О программе");
        System.out.println("2. Выход");
    }

    @Override
    public Screen waitNewScreen() {
        String input = in.nextLine();

        if (input.equals("0")) {
            return new ArchiveList(storage);
        }

        if (input.equals("1")) {
            return new About(storage);
        }

        return null;
    }
}
