package DS.implementations.fileSystemManagement;

public class Main {

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        try {
            System.out.println("Create files and directories:");
            fs.createFile("/file1");
            fs.createDirectory("/dir1");
            fs.createFile("/dir1/file2");
            fs.createFile("/dir1/file3");
            fs.createDirectory("/dir2");

            System.out.println("\nList current directory:");
            System.out.println(fs.ls()); // [dir1, dir2, file1]

            System.out.println("\nChange directory to /dir1:");
            fs.cd("/dir1");

            System.out.println("\nList current directory:");
            System.out.println(fs.ls()); // [file2, file3]

            System.out.println("\nChange directory to /:");
            fs.cd("/");

            System.out.println("\nList current directory:");
            System.out.println(fs.ls()); // [dir1, dir2, file1]
        } catch (FileSystemException e) {
            System.err.println(e.getMessage());
        }
    }
}
