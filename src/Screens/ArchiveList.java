package Screens;

import Data.Archive;
import Data.Storage;

import java.util.*;

public class ArchiveList implements Screen {
    Scanner in = new Scanner(System.in);
    Storage storage;
    Map<Integer,String> menu = new LinkedHashMap<>();

    Integer createIndex = 0; // номер пункта создания
    Integer exitIndex = 0; // номер пункта выхода

    public ArchiveList(Storage storage) {
        this.storage = storage;

        int index = 0;

        for (Data.Archive archive: storage.getArchives()) {
            index++;
            menu.put(index, archive.name());
        }

        createIndex = ++index;
        exitIndex = ++index;

        menu.put(createIndex, "Создать архив");
        menu.put(exitIndex, "Назад");
    }

    @Override
    public void render() {
        System.out.println("Список архивов");

        int i = 1;

        if (storage.getArchives().isEmpty()) {
            System.out.println("> список пуст");
        }

        for (Map.Entry<Integer, String> menuItem : menu.entrySet()) {
            System.out.printf("%d. %s\n", menuItem.getKey(), menuItem.getValue());
        }
    }

    @Override
    public Screen waitNewScreen() {
        String input = in.nextLine();

        if (input.equals(createIndex.toString())) {
            return new CreateArchive(storage);
        }

        if (input.equals(exitIndex.toString())) {
            return new Menu(storage);
        }

        // TODO сделать проверку на индекс
        int numberOfArchive = Integer.parseInt(input);
        Archive archive = storage.getArchives().get(numberOfArchive);

        return new ViewArchive(archive, storage);
    }
}
