package DS.implementations.fileSystemManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem4 {

    private abstract class Node {

        String name;

        Node(String name) {
            this.name = name;
        }

        abstract boolean isDirectory();
    }

    private class File extends Node {

        String content;

        File (String name) {
            super(name);
            this.content = " ";
        }

        @Override
        boolean isDirectory() {
            return false;
        }
    }

    private class Directory extends Node {

        Map<String, Node> children;

        Directory (String name) {
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
        boolean isDirectory() {
            return true;
        }
    }

    private Directory root;
    private Directory currenDirectory;

    public List<String> ls() {
        return new ArrayList<>(currenDirectory.children.keySet());
    }

    public void cd(String path) throws FileSystemException {
        Directory target = navigateTo(path);
        if (target != null) currenDirectory = target;
        else throw new FileSystemException("Path not found" + path);
    }

    public void createFile(String path) throws FileSystemException {
        createNode(path, false);
    }

    public void createDirectory(String path) throws FileSystemException {
        createNode(path, true);
    }

    private Directory navigateTo(String path) throws FileSystemException {
        if (path.isEmpty() || path.equals(".")) return currenDirectory;

        String[] parts = path.split("/");
        Node current = path.startsWith("/") ? root : currenDirectory;
        for (String part : parts) {
            if (part.equals(".") || part.isEmpty()) continue;
            if (part.equals("..")) {
                current = findParent(root, current);
            } else {
                if (current != null && current.isDirectory()) {
                    current = ((Directory) current).getNode(part);
                }
                if (current == null) throw new FileSystemException("Unknown subpart: " + part);
            }
        }

        return (Directory) current;
    }

    private Node findParent(Directory current, Node target) {
        if (current.children.containsValue(target)) return current;

        for (Node child : current.children.values()) {
            if (child.isDirectory()) {
                Node parent = findParent((Directory) child, target);
                if (parent != null) return parent;
            }
        }
        return null;
    }

    private void createNode(String path, boolean isDirectory) throws FileSystemException {
        int lastSlashIndex = path.lastIndexOf("/");
        String dirPath = path.substring(0, lastSlashIndex);
        String nodeName = path.substring(lastSlashIndex + 1);

        Directory targetDir = navigateTo(dirPath);
        if (targetDir.getNode(nodeName) != null) {
            System.out.println(isDirectory ? "Directory " : "File " + nodeName + " already exists");
        }
        if (isDirectory) {
            targetDir.addNode(new Directory(nodeName));
        } else {
            targetDir.addNode(new File(nodeName));
        }
    }

}
