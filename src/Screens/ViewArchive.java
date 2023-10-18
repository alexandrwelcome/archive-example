package Screens;

import Data.Archive;
import Data.Storage;

import java.util.Scanner;

public class ViewArchive implements Screen {
    Scanner in = new Scanner(System.in);
    Archive archive;
    Storage storage;

    public ViewArchive(Archive archive, Storage storage) {
        this.archive = archive;
        this.storage = storage;
    }

    @Override
    public void render() {
        System.out.printf("Показываем архив %s\n", archive.name());
    }

    @Override
    public Screen waitNewScreen() {
        in.nextLine();
        return null;
    }
}
