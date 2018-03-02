package random.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SuffixTree {

	public static void main(String[] args) {
		Set<String> a = new HashSet<String>();
		a.add("adeacdade");
		a.add("abcabxabcd");
		a.add("abcdefabxybcdmnabcdex");
		a.add("abcadak");
		a.add("dedododeodo");
		a.add("abcabxabcd");
		a.add("mississippi");
		a.add("banana");
		a.add("ooooooooo");

		/*
		 * a.forEach(s->{ s=s+"$";
		 * System.out.println("**********Suffix of "+s+" with length :"+s.length()+
		 * "*************"); buildSffixTree(s.toCharArray()); traversal(root,0,s); });
		 */

		buildSffixTree("dedododeodo$".toCharArray());
		traversal(root, 0, "dedododeodo$");

	}

	private static void traversal(SuffixNode root2, int count, String data) {
		if (root2.end.end == data.length() - 1) {
			System.out.println(data.substring(data.length() - count));
			return;
		}
		for (SuffixNode Node : root2.suffixNode) {
			if (Node != null) {
			//	System.out.println(Node.start+" "+Node.end.end);
				//if(Node.suffixLink !=null)
			//	System.out.println(+Node.suffixLink.start+" "+Node.suffixLink.end.end);
				int tempcount = count + Node.end.end - Node.start + 1;
				traversal(Node, tempcount, data);
			}
		}

	}

	static SuffixNode activeNode;
	static SuffixNode activeEdge = null;
	static int activeLength = 0;
	static int remaining = 0;
	static SuffixNode root;

	private static void buildSffixTree(char[] charArray) {
		End end = new End(-1);
		SuffixNode rootObj = new SuffixNode(0, new End(-1));
		activeNode = rootObj;
		activeLength = 0;
		remaining = 0;
		root = rootObj;
		activeEdge = root;
		for (int i = 0; i < charArray.length; i++) {
			remaining++;
			end.end++;
			SuffixNode lastCreatedNode = null;
			while (remaining > 0) {
				if (i > 0) {
					activeEdge = activeNode.suffixNode[charArray[activeEdge.start]];
				}
				System.out.println("Remaining:" + remaining + "  activeLength:" + activeLength + "  active Edge:"
						+ activeEdge.start + " Active Edge ENd:" + activeEdge.end.end + " active Node Start:"
						+ activeNode.start + " active Node end:" + activeNode.end.end);
				if (activeNode.suffixLink != null) {
					System.out.println(
							" AN SL St:" + activeNode.suffixLink.start + " ANSL end:" + activeNode.suffixLink.end.end);
				}
				Arrays.asList(activeNode.suffixNode).stream().filter(s -> {
					return s != null;
				}).forEach(s -> {
					System.out.println("AN Edges:" + s.start + " " + s.end.end);
				});
				Arrays.asList(activeEdge.suffixNode).stream().filter(s -> {
					return s != null;
				}).forEach(s -> {
					System.out.println("Edges of Edges:" + s.start + " " + s.end.end);
				});
				if (activeLength == 0) {

					if (root.suffixNode[charArray[i]] == null) {
						SuffixNode leafNode = new SuffixNode(i, end);
						root.suffixNode[charArray[i]] = leafNode;
						remaining--;
					} else {
						SuffixNode existing = root.suffixNode[charArray[i]];
						activeEdge = existing;
						activeLength++;
						break;
					}

				} else {

					if (activeEdge.start + activeLength <= activeEdge.end.end
							&& charArray[activeEdge.start + activeLength] == charArray[i]) {
						activeLength++;
						break;
					} else if (activeEdge.start + activeLength > activeEdge.end.end) {
						SuffixNode existing = activeEdge.suffixNode[charArray[i]];
						if (existing != null) {
							activeNode = activeEdge;
							activeEdge = existing;
							System.out.println(charArray[i] + " Breaking");
							//activeLength --;
							break;
						} else {
							int temp = activeLength - (activeEdge.end.end - activeEdge.start + 1);
							System.out.println("Char "+(i-temp));
							existing = activeEdge.suffixNode[charArray[i - temp]];
							if (existing != null) {
								activeNode = activeEdge;
								activeEdge = existing;
								activeLength = temp-1;
								continue;
							}else {
							System.out.println("May Not Happen !!!");
							SuffixNode newNode = new SuffixNode(i, end);
							activeEdge.suffixNode[charArray[i]] = newNode;
							if (lastCreatedNode != null) {
								lastCreatedNode.suffixLink = activeEdge;
							}
							lastCreatedNode = activeEdge;
							remaining--;
							}
						}

					} else {
						int temp = activeEdge.start;
						activeEdge.start = activeEdge.start + activeLength;
						SuffixNode internal = new SuffixNode(temp, new End(temp + activeLength - 1));
						System.out.println("Active Edge: start:" + activeEdge.start + " ,end:" + activeEdge.end.end);
						internal.suffixNode[charArray[activeEdge.start]] = activeEdge;
						System.out.println("Internal Edge: start:" + internal.start + " ,end:" + internal.end.end);
						activeNode.suffixNode[charArray[temp]] = internal;
						SuffixNode newNode = new SuffixNode(i, end);
						internal.suffixNode[charArray[i]] = newNode;
						activeEdge = internal;
						System.out.println("newNode Edge: start:" + newNode.start + " ,end:" + newNode.end.end);
						if (lastCreatedNode != null) {
							lastCreatedNode.suffixLink = internal;
							System.out.println(
									"Assign Suffix LInk to :" + lastCreatedNode.start + " as :" + internal.start);
						}
						internal.suffixLink = root;
						lastCreatedNode = internal;
						remaining--;
					}
					if (activeNode == root) {
						// System.out.println("Active Node is root");
						activeEdge = root.suffixNode[charArray[activeEdge.start + 1]];
						activeLength--;
					} else {
						System.out.println(" Change active node to "+activeNode.start+" "+activeNode.end.end+"::::"+activeNode.suffixLink.start+" "+activeNode.suffixLink.end.end);
						activeNode = activeNode.suffixLink;
					}

				}
			}
		}

	}

}

class End {
	int end;

	End(int end) {
		this.end = end;
	}
}

class SuffixNode {
	End end;
	int start;
	int index = -1;
	SuffixNode[] suffixNode = new SuffixNode[256];
	SuffixNode suffixLink;

	SuffixNode(int start, End end) {
		this.start = start;
		this.end = end;
	}

}
