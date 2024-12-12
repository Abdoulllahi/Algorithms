package DS.implementations.fileSystemManagement;

import java.util.*;

public class FileSystem3 {

    private abstract class Node {

        String name;
        abstract boolean isDirectory();

        Node (String name) {
            this.name = name;
        }
    }

    private class File extends Node {

        String content;

        File (String name) {
            super(name);
            this.content = "";
        }

        @Override
        boolean isDirectory() {
            return false;
        }
    }

    private class Directory extends Node {

        Map<String, Node> children;

        Directory(String name) {
            super(name);
            children = new HashMap<>();
        }

        void addNode(Node node) {
            children.put(node.name, node);
        }

        Node getNode(String name) {
            return children.get(name);
        }

        @Override
        boolean isDirectory() {
            return true;
        }
    }

    private Directory root;
    private Directory currentDirectory;

    FileSystem3() {
        root = new Directory("/");
        this.currentDirectory = root;
    }

    public List<String> ls() {
        List<String> result = new ArrayList(currentDirectory.children.values());
        Collections.sort(result);
        return result;
    }

    public void cd(String path) throws FileSystemException{
        Directory target = navigateTo(path);
        if (target != null) currentDirectory = target;
        else throw new FileSystemException("Path not found: " + path);

    }

    public void createFile(String path) throws FileSystemException {
        createNode(path, false);
    }

    public void createDirectory(String path) throws FileSystemException {
        createNode(path, true);
    }

    private void createNode(String path, boolean isDirectory) throws FileSystemException {
        int lastSlashIndex = path.lastIndexOf("/");
        String dirTarget = path.substring(0, lastSlashIndex);
        String nodeName = path.substring(lastSlashIndex + 1);

        Directory targetDirectory = navigateTo(dirTarget);

        if (targetDirectory != null) {
            if (targetDirectory.getNode(nodeName) != null) {
                throw new FileSystemException(isDirectory ? "Directory " : "File " + "already exists");
            }
            if (isDirectory) {
                targetDirectory.addNode(new Directory(nodeName));
            } else targetDirectory.addNode(new File(nodeName));
        } else throw new FileSystemException("Couldn't find the path" + path);
    }

    private Directory navigateTo(String path) throws FileSystemException {
        if (path.isEmpty()) return currentDirectory;
        String[] parts = path.split("/");
        Node current = path.startsWith("/") ? root : currentDirectory;

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) current = findParent(root, current);
            else {
                if (current.isDirectory()) {
                    current = ((Directory) current).getNode(part);
                }
                if (current == null) throw new FileSystemException("Path not found");

            }
        }

        return (Directory) current;
    }

    private Directory findParent(Directory current, Node target) {
        if (current.children.containsValue(target)) return current;
        for (Node child : current.children.values()) {
            if (child.isDirectory()) {
                Directory parent = findParent((Directory) child, target);
                if (parent != null) return parent;
            }
        }
        return null;
    }
}
