package Data;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    List<Archive> archives = new ArrayList<>();

    public List<Archive> getArchives() {
        return archives;
    }

    public void add(Archive archive) {
        archives.add(archive);
    }
}
