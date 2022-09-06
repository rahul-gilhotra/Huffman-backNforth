package MISC;

import java.util.*;

public class Huffman
{
    private Node root;
    public String encode(String text)
    {
        char[] ch = text.toCharArray();

        PriorityQueue<Node> q = countFrequencies(ch);

        root = createTree(q);

        Map<Character, String> codemap = createCodeMap();
        StringBuilder data = new StringBuilder();

        for (char c : ch) data.append(codemap.get(c)+"");

        return data.toString();
    }

    PriorityQueue<Node> countFrequencies(char[] letters)
    {
        Map<Character, Node> count = new HashMap<>();
        for (char ch : letters)
        {
            if (!count.containsKey(ch)) count.put(ch, new Node(ch));
            count.get(ch).add();
        }
        return new PriorityQueue<>(count.values());
    }

    Node createTree(PriorityQueue<Node> nodes)
    {
        while (true)
        {
            Node node1 = nodes.poll();
            Node node2 = nodes.poll();

            Node parent = new Node(node1, node2);

            if (nodes.isEmpty()) return parent;

            nodes.add(parent);
        }
    }
    Map<Character, String> createCodeMap() {
        Map<Character, String> result = new TreeMap<>();
        root.fillCodeMap(result, "");
        return result;
    }
    public String decode(String data) {
        Node current = root;

        StringBuilder result = new StringBuilder();
        for (char ch : data.toCharArray()) {
            if (ch == '0') {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

            if (current.isLeaf()) {
                result.append(current.getSymbol());
                current = root;
            }
        }
        return result.toString();
    }
}
