package Screens;

import Data.Storage;

import java.util.Scanner;

public class About implements Screen {
    Scanner in = new Scanner(System.in);
    Storage storage;

    public About(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void render() {
        System.out.println("Приложение по курсу Яндекса 2023 год");
    }

    @Override
    public Screen waitNewScreen() {
        return new Menu(storage);
    }
}
