package org.example.sandbox.trees.binarysearchtree;


import org.example.sandbox.trees.ElementNotFoundException;
import org.example.sandbox.trees.Tree;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private BinaryTreeNode<T> root;
    private int count;
    // flag used during delete to detect if an element was actually removed
    private boolean deletedFlag = false;

    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }

    @Override
    public boolean create() {

        this.root = new BinaryTreeNode<>();
        this.count = 0;

        return true;
    }

    @Override
    public T insert(T element) {

        if (element == null) return null;

        T insertedElement = null;
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(element);
            insertedElement = root.element;
            this.count++;
        } else {
            insertedElement = insertInto(element, root);
            if (insertedElement != null) this.count++;
        }
        return insertedElement;
    }

    private T insertInto(T element, BinaryTreeNode<T> node) {

        if (node == null) return null;

        // if this node is an empty/sentinel node, place element here
        if (node.element == null) {
            node.element = element;
            node.left = new BinaryTreeNode<>();
            node.right = new BinaryTreeNode<>();
            return node.element;
        }

        int cmp = element.compareTo(node.element);
        if (cmp < 0) {
            return insertInto(element, node.left);
        } else {
            return insertInto(element, node.right);
        }
    }

    @Override
    public T search(T targetElement) throws ElementNotFoundException {

        BinaryTreeNode<T> target = findNode(targetElement, root);

        if (target == null || target.getElement() == null) {
            throw new ElementNotFoundException(this.getClass()
                                                   .getCanonicalName());
        }

        return (target.getElement());
    }

    private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) {
        if (next == null || next.getElement() == null) return null;

        if (next.getElement().equals(targetElement)) return next;

        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());

        if (temp == null) temp = findNode(targetElement, next.getRight());

        return temp;
    }

    @Override
    public boolean delete(T data) {

        if (this.root == null) return false;
        deletedFlag = false;
        this.root = deleteNode(this.root, data);
        if (deletedFlag && this.count > 0) this.count--;
        return deletedFlag;
    }

    private BinaryTreeNode<T> deleteNode(BinaryTreeNode<T> node, T data) {

        if (node == null || node.element == null) return node;

        int cmp = data.compareTo(node.element);

        if (cmp < 0) {
            node.left = deleteNode(node.getLeft(), data);
        } else if (cmp > 0) {
            node.right = deleteNode(node.getRight(), data);
        } else {
            // found node to delete
            deletedFlag = true;

            boolean leftEmpty = (node.getLeft() == null || node.getLeft().getElement() == null);
            boolean rightEmpty = (node.getRight() == null || node.getRight().getElement() == null);

            // node with no leaf nodes
            if (leftEmpty && rightEmpty) {
                // return an empty sentinel node
                return new BinaryTreeNode<>();
            } else if (leftEmpty) {

                // node with one node (no left node)
                return node.getRight();
            } else if (rightEmpty) {

                // node with one node (no right node)
                return node.getLeft();
            } else {

                // nodes with two nodes
                // search for min number in right sub tree
                T minValue = minValue(node.right);
                node.element = minValue;
                node.right = deleteNode(node.right, minValue);
            }
        }

        return node;
    }

    private T minValue(BinaryTreeNode<T> node) {

        if (node == null) return null;
        while (node.getLeft() != null && node.getLeft().getElement() != null) {
            node = node.getLeft();
        }
        return node.getElement();
    }


    @Override
    public boolean contains(T targetElement) {
        boolean containsElement = false;

        try {
            containsElement = search(targetElement) != null;
        } catch (ElementNotFoundException e) {
            // don't print repeatedly to stderr; just return false
            containsElement = false;
        }
        return containsElement;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        return iteratorLevelOrder();
    }

    public Iterator<T> iteratorPreOrder() {

        Queue<T> tempList = new LinkedList<>();
        preOrder(root, tempList);

        return tempList.iterator();
    }

    private void preOrder(BinaryTreeNode<T> node, Queue<T> tempList) {
        // ROOT LEFT RIGHT
        if (node == null || node.element == null) return;
        tempList.add(node.element);
        preOrder(node.left, tempList);
        preOrder(node.right, tempList);
    }

    public Iterator<T> iteratorInOrder() {

        Queue<T> tempList = new LinkedList<>();
        inOrder(root, tempList);

        return tempList.iterator();
    }

    private void inOrder(BinaryTreeNode<T> node, Queue<T> tempList) {
        // LEFT ROOT RIGHT
        if (node == null || node.element == null) return;
        inOrder(node.left, tempList);
        tempList.add(node.element);
        inOrder(node.right, tempList);
    }

    public Iterator<T> iteratorPostOrder() {

        Queue<T> tempList = new LinkedList<>();
        postOrder(root, tempList);

        return tempList.iterator();
    }

    private void postOrder(BinaryTreeNode<T> node, Queue<T> tempList) {
        // LEFT RIGHT ROOT
        if (node == null || node.element == null) return;
        postOrder(node.left, tempList);
        postOrder(node.right, tempList);
        tempList.add(node.element);
    }

    public Iterator<T> iteratorLevelOrder() {

        Queue<T> tempList = new LinkedList<>();
        levelOrder(root, tempList);

        return tempList.iterator();
    }

    private void levelOrder(BinaryTreeNode<T> node, Queue<T> tempList) {

        if (node == null || node.element == null) return;

        // temporary node queue
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        // while there are nodes to process...
        while (!queue.isEmpty()) {

            // store node value
            BinaryTreeNode<T> tempNode = queue.poll();
            if (tempNode == null) continue;
            if (tempNode.element != null) tempList.add(tempNode.element);

            // store left child if not null and not empty sentinel
            if (tempNode.left != null && tempNode.left.element != null) {
                queue.add(tempNode.left);
            }

            // store right child if not null and not empty sentinel
            if (tempNode.right != null && tempNode.right.element != null) {
                queue.add(tempNode.right);
            }

        }
    }

    private Iterator<BinaryTreeNode<T>> insertionIterator() {

        Queue<BinaryTreeNode<T>> tempList = new LinkedList<>();
        levelOrderInsertionIterator(root, tempList);

        return tempList.iterator();
    }

    private void levelOrderInsertionIterator(BinaryTreeNode<T> node, Queue<BinaryTreeNode<T>> tempList) {

        if (node == null || node.element == null) return;

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            BinaryTreeNode<T> tempNode = queue.poll();
            if (tempNode == null) continue;
            if (tempNode.element != null) tempList.add(tempNode);

            if (tempNode.left != null && tempNode.left.element != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null && tempNode.right.element != null) {
                queue.add(tempNode.right);
            }

        }
    }

    public void printTopDownTree() {

        List<List<String>> lines = new ArrayList<>();
        List<BinaryTreeNode<T>> level = new ArrayList<>();
        List<BinaryTreeNode<T>> next = new ArrayList<>();

        level.add(this.root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();

            nn = 0;

            for (BinaryTreeNode<T> n : level) {

                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa;
                    if (n.getElement() != null) {
                        aa = n.getElement()
                              .toString();
                    } else {
                        aa = "null";
                    }
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null && n.getLeft().getElement() != null) nn++;
                    if (n.getRight() != null && n.getRight().getElement() != null) nn++;

                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<BinaryTreeNode<T>> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perPiece = lines.get(lines.size() - 1)
                            .size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perPiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '|' : '|';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '|';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perPiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "-");
                        }
                        System.out.print(j % 2 == 0 ? "|" : "|");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "-" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perPiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perPiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perPiece /= 2;
        }
    }

    private static class BinaryTreeNode<S> {

        BinaryTreeNode<S> left;
        BinaryTreeNode<S> right;
        S element;

        BinaryTreeNode() {
            this.element = null;
            this.left = null;
            this.right = null;
        }

        BinaryTreeNode(S element) {
            this.element = element;
            this.left = new BinaryTreeNode<>();
            this.right = new BinaryTreeNode<>();
        }

        S getElement() {
            return element;
        }

        BinaryTreeNode<S> getLeft() {
            return left;
        }

        BinaryTreeNode<S> getRight() {
            return right;
        }

    }

}