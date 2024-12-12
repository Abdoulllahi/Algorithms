package DS.implementations.fileSystemManagement;

import java.util.*;

public class FileSystem2 {

    private abstract class Node {
        String name;
        abstract boolean isFile();

        Node(String name) {
            this.name = name;
        }
    }

    private class File extends Node {

        String content;

        File(String name) {
            super(name);
            this.content = "";
        }

        @Override
        boolean isFile() {
            return true;
        }
    }

    private class Directory extends Node {

        Map<String, Node> children;

        Directory(String name) {
            super(name);
            this.children = new HashMap<>();
        }

        void addNode(Node node) {
            children.put(node.name, node);
        }

        Node getNode(String name) {
            return children.get(name);
        }

        @Override
        boolean isFile() {
            return false;
        }
    }

    private Directory root;
    private Directory currentDirectory;

    public List<String> ls() {
        List<String> result = new ArrayList<>(currentDirectory.children.keySet());
        Collections.sort(result);
        return result;
    }

    public void cd(String path)  throws FileSystemException{
        Directory target = navigateTo(path);
        if (target != null) currentDirectory = target;
        else throw new FileSystemException("path not found " + path);
    }

    public void createFile(String path) throws FileSystemException {
        createNode(path, true);
    }

    public void createDirectory(String path) throws FileSystemException {
        createNode(path, false);
    }

    private Directory navigateTo(String path) throws FileSystemException{
        if (path.isEmpty()) return currentDirectory;

        String[] parts = path.split("/");
        Node current = path.startsWith("/") ? root : currentDirectory;
        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) current = findParent(root, current);
            else {
                if (!current.isFile()) {
                    current = ((Directory)current).getNode(part);
                }
                if (current == null) throw new FileSystemException("path Not found" + path);
            }
        }

        return (Directory) current;
    }

    private Directory findParent(Directory current, Node target) {
        if (current.children.containsValue(target)) return current;
        for (Node child : current.children.values()) {
            if (!child.isFile()) {
                Directory parent = findParent((Directory) child, target);
                if (parent != null) return parent;
            }

        }
        return null;
    }

    private void createNode(String path, boolean isFile) throws FileSystemException {
        int lastSlash = path.lastIndexOf("/");
        String dirPath = path.substring(0, lastSlash);
        String nodeName = path.substring(lastSlash + 1);

        Directory targetDir = navigateTo(dirPath);
        if (targetDir != null) {
            if (isFile) {
                targetDir.addNode(new File(nodeName));
            } else {
                targetDir.addNode(new Directory(nodeName));
            }
        } else throw new FileSystemException("Path not found");
    }
}
