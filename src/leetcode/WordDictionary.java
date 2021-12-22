package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 211. Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class WordDictionary {
    static class Node {
        private final Node[] children = new Node[26];
        private String val;

    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }

            node = node.children[c - 'a'];
        }
        node.val = word;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int depth, Node node) {
        if (depth == word.length()) {
            return node.val != null;
        }

        if (word.charAt(depth) != '.') {
            return (node.children[word.charAt(depth) - 'a'] != null && dfs(word, depth+1, node.children[word.charAt(depth) - 'a']));

        } else {
            for (int i=0; i<node.children.length; i++) {
                if (node.children[i] != null && dfs(word, depth+1, node.children[i])) {
                    return true;
                }
            }

        }

        return false;
    }

    @Test
    void test() {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");

        Assertions.assertThat(obj.search("pad")).isFalse();
        Assertions.assertThat(obj.search("bad")).isTrue();
        Assertions.assertThat(obj.search(".ad")).isTrue();
        Assertions.assertThat(obj.search("b")).isFalse();
    }
}
