package random.programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SuffixTreeNew {

	public static void main(String[] args) {
		Set<String> a = new HashSet<String>();
		a.add("adeacdade");
		a.add("aeaeaeae");
		a.add("abcabxabcd");
		a.add("abcdefabxybcdmnabcdex");
		a.add("abcadak");
		a.add("dedododeodo");
		a.add("abcabxabcd");
		a.add("mississippi");
		a.add("banana");
		a.add("ooooooooo");
		a.add("GEEKSFORGEEKS");
		a.add("ABCDEFG");
		a.add("abcpqrabpqpq");
		a.add("ATCGATCGA");
		a.add("abcdabcdabcd");
		a.forEach(s -> {
			s = s + "$";
			System.out.println("**********Suffix of " + s + " with length :" + s.length() + "*************");
			NewSuffixNode root = buildSuffixTree(s.toCharArray());
			List<String> longest = new ArrayList<String>();
			longest.add(Character.valueOf(s.charAt(0)).toString());
			int maxRepLong = traversal(root, 0, s, longest);
			longest.forEach(System.out::println);
		});

	}

	private static int traversal(NewSuffixNode root, int count, String data, List<String> longest) {
		if (root.end.end == data.length() - 1) {
			 System.out.println(data.substring(data.length() - count));
			return 1;
		} else {
			String temp = longest.get(0);
			if (count > temp.length()) {
				longest.clear();
				longest.add(data.substring(root.end.end - count + 1, root.end.end + 1));
			}
			if (count == temp.length()) {
				longest.add(data.substring(root.end.end - count + 1, root.end.end + 1));
			}
		}
		int maxRep = 0;
		StringBuilder longestRept = new StringBuilder();
		for (NewSuffixNode edge : root.edges) {
			if (edge != null) {
				int tempcount = count + edge.end.end - edge.start + 1;
				if (root.end.end != -1) {
					maxRep = maxRep + traversal(edge, tempcount, data, longest);
				} else {
					int temp = traversal(edge, tempcount, data, longest);
					String edgeString = data.substring(edge.start, edge.end.end + 1);
					if (temp != 1 && temp > maxRep) {
						longestRept = new StringBuilder(edgeString);
						maxRep = temp;
					} else if (temp != 1 && temp == maxRep) {
						if (edgeString.length() > longestRept.length()) {
							longestRept = new StringBuilder(edgeString);
						} else if (edgeString.length() == longestRept.length()) {
							longestRept.append("," + edgeString);
						}
					}
				}
			}
		}
		if (root.end.end == -1)
			System.out.println(longestRept.toString()+"-"+maxRep);
		return maxRep;

	}

	private static NewSuffixNode buildSuffixTree(char[] charArray) {
		NewSuffixNode root = new NewSuffixNode(0, new NewEnd(-1));
		Active active = new Active();
		active.activeNode = root;
		for (int i = 0; i < charArray.length; i++) {
			active.remaining++;
			active.globalEnd.end++;
			buildSuffix(i, active, charArray, root);
		}
		return root;
	}

	private static void buildSuffix(int i, Active active, char[] chars, NewSuffixNode root) {
		NewSuffixNode lastCreatedNode = null;
		while (active.remaining > 0) {
			if (active.activeLength == 0) {
				if (root.edges[chars[i]] != null) {
					active.activeEdgeStart = root.edges[chars[i]].start;
					active.activeNode = root;
					active.activeLength++;
					break;
				} else {
					NewSuffixNode newSuffixNode = new NewSuffixNode(i, active.globalEnd);
					root.edges[chars[i]] = newSuffixNode;
					active.remaining--;
				}
			} else {
				int status = validateAndAdjustPosition(active, i, chars);
				NewSuffixNode activeEdge = active.activeNode.edges[chars[active.activeEdgeStart]];
				NewSuffixNode internalNode = null;
				if (status == 1) {
					NewSuffixNode newSuffixNode = new NewSuffixNode(i, active.globalEnd);
					activeEdge.edges[chars[i]] = newSuffixNode;
					active.remaining--;
					internalNode = activeEdge;
					if (lastCreatedNode != null) {
						lastCreatedNode.suffixLink = internalNode;
					}

				} else if (status == 2) {
					if (lastCreatedNode != null) {
						lastCreatedNode.suffixLink = active.activeNode;
					}
					break;
				} else {
					char nextChar = chars[activeEdge.start + active.activeLength];
					if (nextChar == chars[i]) {
						active.activeLength++;
						break;
					} else {
						internalNode = new NewSuffixNode(activeEdge.start,
								new NewEnd(activeEdge.start + active.activeLength - 1));
						internalNode.suffixLink = root;
						active.activeNode.edges[chars[activeEdge.start]] = internalNode;

						activeEdge.start = internalNode.end.end + 1;
						internalNode.edges[chars[activeEdge.start]] = activeEdge;

						NewSuffixNode leafNode = new NewSuffixNode(i, active.globalEnd);
						internalNode.edges[chars[i]] = leafNode;
						active.remaining--;
						if (lastCreatedNode != null) {
							lastCreatedNode.suffixLink = internalNode;
						}
						lastCreatedNode = internalNode;

					}
				}

				if (active.activeNode != root) {
					active.activeNode = active.activeNode.suffixLink;
				} else {
					active.activeEdgeStart = active.activeEdgeStart + 1;
					active.activeLength--;
				}
			}
		}

	}

	private static int validateAndAdjustPosition(Active active, int i, char[] chars) {
		NewSuffixNode edge = active.activeNode.edges[chars[active.activeEdgeStart]];
		active.activeEdgeStart = edge.start;
		int edgeLength = calculateEdgeLength(edge.start, edge.end.end);
		if (edgeLength - 1 >= active.activeLength) {
			return 0;
		} else if (edgeLength == active.activeLength) {
			if (edge.edges[chars[i]] != null) {
				active.activeEdgeStart = edge.edges[chars[i]].start;
				active.activeNode = edge;
				active.activeLength = 1;
				return 2;
			}
			return 1;
		} else {
			int diff = active.activeLength - edgeLength;
			NewSuffixNode existing = edge.edges[chars[i - diff]];
			active.activeEdgeStart = existing.start;
			active.activeNode = edge;
			active.activeLength = diff;
			return validateAndAdjustPosition(active, i, chars);
		}
	}

	private static int calculateEdgeLength(int start, int end) {

		return end - start + 1;
	}
}

class Active {
	int activeEdgeStart = -1;
	int remaining = 0;
	NewSuffixNode activeNode;
	int activeLength = 0;
	NewEnd globalEnd = new NewEnd(-1);

}

class NewEnd {
	int end;

	NewEnd(int end) {
		this.end = end;
	}
}

class NewSuffixNode {
	int start;
	NewEnd end;
	NewSuffixNode suffixLink;
	NewSuffixNode[] edges = new NewSuffixNode[256];
	int startIndex = -1;

	public NewSuffixNode(int start, NewEnd end) {
		this.start = start;
		this.end = end;
	}

}
