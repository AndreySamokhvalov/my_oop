package scr;
import java.io.*;

public class FileHandler implements Writable, Serializable {

    private String fileName;

    public FileHandler() {
        this.fileName = "familyTree.dat";
    }

    public void setFilename(String fileName) {
        this.fileName = fileName;
    }

    

  // сохранение в файл
    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            System.out.printf("Изменения сохранены в файл %s\n", fileName);
            oos.writeObject(serializable);
        } catch (Exception ex) {
            System.out.println("Ошибка сохранения файла!");
            System.out.println(ex.getMessage());
        }
    }

// чтение файла
    @Override
    public FamilyTree read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree) ois.readObject();
        } catch (Exception ex) {
            System.out.println("Ошибка чтения файла!");
            System.out.println(ex.getMessage());
        }
        return null;
    }


}