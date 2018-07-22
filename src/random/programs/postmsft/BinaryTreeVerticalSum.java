package random.programs.postmsft;

/**
 * 
 * @author rajaram
 *
 *         <a href="https://www.youtube.com/watch?v=il_t1WVLNxk"/>
 */
public class BinaryTreeVerticalSum {

	public static void main(String[] args) {
	}

	private static Tree buildTree(int[] vals) {
		Tree root = new Tree();
		Tree ctNode = root;
		int st = 0;
		while (st < vals.length) {
			build(vals, st, ctNode);
			st++;
			if (ctNode.r != null)
				st ++;
		}
		return root;
	}

	private static Tree build(int[] vals, int st, Tree root) {
		if (st < vals.length) {
			root.l = new Tree();
			root.l.val = vals[st];
			st++;
		}
		if (st < vals.length) {
			root.r = new Tree();
			root.r.val = vals[st];
			st++;
		}
		return root;
	}

	private static class Tree {
		private Tree l;
		private Tree r;
		private int val;
	}
}
