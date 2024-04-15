import java.io.*;
import java.util.List;

public interface FamilyTreeFileManager {
    void saveFamilyTree(String filename, List<Human> family);
    List<Human> loadFamilyTree(String filename);
}