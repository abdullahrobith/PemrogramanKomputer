package latihangrafik;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class tugas {

    public static void main(String[] args) throws IOException {
        // Membuat folder Root
        File rootFolder = new File("C:\\Users\\User\\Root");
        rootFolder.mkdir();
        
        // Membuat file 'project.conf' di dalam folder 'Root'
        File projectFile = new File(rootFolder, "project.conf");
        createFile(projectFile);
        
        // Membuat file 'manifest.mf' di dalam folder 'Root'
        File manifestFile = new File(rootFolder, "manifest.mf");
        createFile(manifestFile);
        
        // Membuat folder "classes" di dalam folder "Root"
        File classesFolder = new File(rootFolder, "classes");
        classesFolder.mkdir();
        
        // Membuat file 'Test.java' dan 'TestImpl.java' di dalam folder 'classes'
        File testJavaFile = new File(classesFolder, "Test.java");
        createFile(testJavaFile);
        
        try (FileWriter FW = new FileWriter(testJavaFile)) {
            FW.write("public class test{}");
        }
        
        File testImplJavaFile = new File(classesFolder, "TestImpl.java");
        createFile(testImplJavaFile);
        
        // Membuat folder "template" di dalam folder Root
        File templateFolder = new File(rootFolder, "template");
        templateFolder.mkdir();
        
        // Membuat file 'enter.txt' dan 'exit.txt' di dalam folder 'template'
        File enterTextFile = new File(templateFolder, "enter.txt");
        createFile(enterTextFile);
        
        //ISI TEXT
        File exitTextFile = new File(templateFolder, "exit.txt");
        createFile(exitTextFile);
        
        // Memindahkan file 'project.conf' ke dalam folder 'template'
        File movedProjectFile = new File(templateFolder, "project.conf");
        projectFile.renameTo(movedProjectFile);
        
        // Menghapus file 'Test.java' dari folder 'classes'
        testJavaFile.delete();
        
        //Menghapus folder Root
        if (rootFolder.delete()) {
            System.out.println("Folder Root berhasil dihapus.");
        } else {
            System.out.println("Terjadi kesalahan saat menghapus folder Root.");
        }
    }

    // Fungsi untuk membuat file jika belum ada
    private static void createFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("File '" + file.getName() + "' berhasil dibuat!");
            } else {
                System.out.println("File '" + file.getName() + "' sudah ada.");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membuat file '" + file.getName() + "'.");
        }
    }
}
