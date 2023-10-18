package Screens;

import Data.Archive;
import Data.Storage;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateArchive implements Screen {
    Scanner in = new Scanner(System.in);
    Storage storage;

    public CreateArchive(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void render() {
        System.out.println("Сейчас будет создан архив!");
    }

    @Override
    public Screen waitNewScreen() {
        String name = "";

        while (name.isEmpty()) {
            System.out.println("Введите имя: ");
            name = in.nextLine();

            if (name.isEmpty()) {
                System.out.println("Имя не может быть пустым");
            }
        }

        storage.add(new Archive(name, new ArrayList<>()));

        return new ArchiveList(storage);
    }
}
