import java.util.LinkedList;
import java.util.Queue;

/**
 * @author vinayaka
 *
 */
public class Solution {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			this.val = x;
			left = right = null;
		}
	}

	public static String levelOrderTraversal(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		StringBuilder nodeList = new StringBuilder();
		TreeNode childNotPresent = new TreeNode(0);
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				nodeList.append(node.val);
				if (node.val == 0 || (node.left == null && node.right == null))
					continue;
				if (node.left != null) {
					queue.offer(node.left);
				} else {
					queue.offer(childNotPresent);
				}
				if (node.right != null) {
					queue.offer(node.right);
				} else {
					queue.offer(childNotPresent);
				}
			}

		}
		return nodeList.toString();
	}

	public static TreeNode buildTree(char[] arr, int i) {
		TreeNode node = null;
		if (i < arr.length) {
			char ch = arr[i];
			if (ch != '0') {
				node = new TreeNode(ch - '0');
				node.left = buildTree(arr, (2 * i) + 1);
				node.right = buildTree(arr, (2 * i) + 2);
			}
		}
		return node;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode root1 = new TreeNode(4);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(9);
		TreeNode root4 = new TreeNode(7);
		TreeNode root5 = new TreeNode(8);

		root.left = root1;
		root.right = root4;
		root1.right = root3;
		root1.left = root2;
		root4.right = root5;

		String s = levelOrderTraversal(root);
		TreeNode root23 = buildTree(s.toCharArray(), 0);
		System.out.println(levelOrderTraversal(root23));

	}
}
