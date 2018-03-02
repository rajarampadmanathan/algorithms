package random.programs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 
 * @author Rajaram
 *
 */
public class Tire {

	private char value;
	private boolean end;
	private Tire[] childrens = new Tire[128];

	public Tire(char value, boolean end) {
		this.value = value;
		this.end = end;
	}

	public Tire(char cs) {
		this(cs, false);
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public Tire[] getChildrens() {
		return childrens;
	}

	public void setChildrens(Tire[] childrens) {
		this.childrens = childrens;
	}

	public static void main(String[] args) {

		String s = "Banana";
		Tire root = getRoot();
		root.buildTire(s.toCharArray());
		root.buildTire("Build".toCharArray());
		root.buildTire("Bank".toCharArray());
		root.buildTire("Ban".toCharArray());
		root.buildTire("Baloon".toCharArray());
		root.buildTire("Umberlla".toCharArray());
		// printTire(root);
		System.out.println(root.search("ba".toCharArray()));
		System.out.println(root.search("Baloo".toCharArray()));
		System.out.println(root.search("baloon".toCharArray()));
		System.out.println(root.search("Baloon".toCharArray()));
		System.out.println(root.search("Ban".toCharArray()));
		System.out.println(root.search("Um".toCharArray()));
		System.out.println(root.search("lla".toCharArray()));
	}

	private boolean search(char[] charArray) {
		Tire currentNode = this;
		int i = 0;
		while (currentNode != null && i < charArray.length) {
			if (currentNode.getChildrens()[charArray[i]] != null) {
				currentNode = currentNode.getChildrens()[charArray[i]];
				i++;
			} else {
				return false;
			}

		}
		
		if(currentNode !=null && currentNode.isEnd()) {
			return true;
		}

		return false;
	}

	static LinkedList<Tire> queue = new LinkedList<Tire>();

	@Deprecated
	private static void printTire(Tire currentNode) {
		queue.add(new Tire('|'));
		do {
			if (currentNode.getValue() == '|') {
				System.out.println();
				continue;
			}
			for (Tire child : currentNode.getChildrens()) {
				if (child != null) {
					System.out.print(child.getValue() + "\t");
					queue.offer(child);
				}
			}
			queue.add(new Tire('|'));
		} while ((currentNode = queue.poll()) != null && !currentNode.isEnd());

	}

	private void buildTire(char[] cs) {
		Tire currentNode = this;
		for (int i = 0; i < cs.length; i++) {
			if (currentNode.getChildrens()[cs[i]] != null) {
				currentNode = currentNode.getChildrens()[cs[i]];
			} else {
				Tire newNode = new Tire(cs[i]);
				currentNode.getChildrens()[cs[i]] = newNode;
				currentNode = newNode;
			}
		}
		currentNode.setEnd(true);

	}

	private static Tire getRoot() {
		return new Tire('$');
	}

}
