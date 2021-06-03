package May2021GoogLeetcode;

public class _0208ImplementTrie_PrefixTree {

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
	}

	static class Trie {
		
	}

}
