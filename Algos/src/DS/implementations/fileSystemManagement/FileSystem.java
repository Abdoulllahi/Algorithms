package DS.implementations.fileSystemManagement;

import java.util.*;

public class FileSystem {

    abstract class Node {

        private String name;

        public void setName(String name) {
            this.name = name;
        }


        Node(String name) {
            this.name = name;
        }

        abstract boolean isDirectory();
    }

    class File extends Node {

        String content;

        File(String name) {
            super(name);
            this.content = "";
        }

        @Override
        boolean isDirectory() {
            return false;
        }
    }

    class Directory extends Node {

        Map<String, Node> children;

        Directory(String name) {
            super(name);
            children = new HashMap<>();
        }

        @Override
        boolean isDirectory() {
            return true;
        }

        void addNode(Node node) {
            children.put(node.name, node);

        }

        Node getNode(String name) {
            return children.get(name);
        }

    }

    private Directory root;
    private Directory currentDir;

    public FileSystem() {
        root = new Directory("/");
        currentDir = root;
    }

    public List<String> ls() {
        List<String> result = new ArrayList<>(currentDir.children.keySet());
        Collections.sort(result);
        return result;
    }

    public void cd(String path) throws FileSystemException{
        Directory target = navigateTo(path);
        if (target != null ) currentDir = target;
        else throw new FileSystemException("Path not found " + path);
    }

    public void createFile(String path) throws FileSystemException {
        createNode(path, true);
    }

    public void createDirectory(String path) throws FileSystemException {
        createNode(path, false);
    }

    private Directory navigateTo(String path) throws FileSystemException {
        if (path.isEmpty()) return currentDir;

        String[] parts = path.split("/");
        Node current = path.startsWith("/") ? root : currentDir;
        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) {
                current = findParent(root, current);
            } else {
                if (current != null && current.isDirectory()) {
                    current = ((Directory) current).getNode(part);
                }
                if (current == null) {
                    throw new FileSystemException("Invalid path " + path);
                }
            }
        }

        return (Directory) current;

    }

    private Node findParent(Directory current, Node target) {
        if (current.children.containsValue(target)) return current;
        for (Node child : current.children.values()) {
            Node parent = findParent((Directory) child, target);
            if (parent != null) return parent;
        }
        return null;
    }

    private void createNode(String path, boolean isFile) throws FileSystemException {
        int lastSlash = path.lastIndexOf("/");
        String dirPath = path.substring(0, lastSlash);
        String nodeName = path.substring(lastSlash + 1);

        Directory targetDir = navigateTo(dirPath);

        if (targetDir != null) {
            if (targetDir.getNode(nodeName) != null) {
                throw new FileSystemException(isFile ? "File " : "Directory " + nodeName + " already exists");
            }
            if (isFile) {
                targetDir.addNode(new File(nodeName));
            } else {
                targetDir.addNode(new Directory(nodeName));
            }

        } else throw new FileSystemException("Invalid Directory" + dirPath);
    }
}
