package com.zclau.data_structure;

import java.util.Stack;

public class BinarySearchTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	static TreeNode insert(TreeNode root, int val) {

		if (root == null) {
			return new TreeNode(val);
		}

		if (val < root.val) {
			root.left = insert(root.left, val);
		} else if (val > root.val) {
			root.right = insert(root.right, val);
		} else {
			return root;
		}

		return root;
	}


	static int find(TreeNode root, int val) {
		if (root == null) {
			return -1;
		}

		while (root != null) {
			if (val < root.val) {
				root = root.left;
			} else if (val > root.val) {
				root = root.right;
			} else {
				return root.val;
			}
		}

		return -1;
	}

	/**
	 * 递归中序遍历
	 * @param root
	 */
	static void traverseInOrderRecursively(TreeNode root) {
		if (root == null) {
			return;
		}
		traverseInOrderRecursively(root.left);
		System.out.print(root.val + " ");
		traverseInOrderRecursively(root.right);
	}

	/**
	 * 非递归中序遍历
	 *
	 * 1) Create an empty stack S.
	 * 2) Initialize current node as root
	 * 3) Push the current node to S and set current = current->left until current is NULL
	 * 4) If current is NULL and stack is not empty then
	 *      a) Pop the top item from stack.
	 *      b) Print the popped item, set current = popped_item->right
	 *      c) Go to step 3.
	 * 5) If current is NULL and stack is empty then we are done.
	 */
	static void traverseInOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp;
		do {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			temp = stack.pop();
			System.out.print(temp.val + " ");
			root = temp.right;
		} while (root != null || !stack.isEmpty());
	}



	/**
	 * 递归前序遍历
	 */
	static void traversePreOrderRecursively(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traversePreOrderRecursively(root.left);
		traversePreOrderRecursively(root.right);
	}

	static void traversePreOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp;
		do {
			while (root != null) {
				System.out.print(root.val + " ");
				stack.push(root);
				root = root.left;
			}

			temp = stack.pop();
			root = temp.right;
		} while (root != null || !stack.isEmpty());
	}




	/**
	 * 递归后序遍历
	 */
	static void traversePostOrderRecursively(TreeNode root) {
		if (root == null) {
			return;
		}
		traversePostOrderRecursively(root.left);
		traversePostOrderRecursively(root.right);
		System.out.print(root.val + " ");
	}

	/**
	 * 非递归后序遍历
	 *
	 * 1.1 Create an empty stack
	 * 2.1 Do following while root is not NULL
	 *     a) Push root's right child and then root to stack.
	 *     b) Set root as root's left child.
	 * 2.2 Pop an item from stack and set it as root.
	 *     a) If the popped item has a right child and the right child
	 *        is at top of stack, then remove the right child from stack,
	 *        push the root back and set root as root's right child.
	 *     b) Else print root's data and set root as NULL.
	 * 2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
	 */
	static void traversePostOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp;
		do {
			while (root != null) {
				if (root.right != null) {
					stack.push(root.right);
				}
				stack.push(root);
				root = root.left;
			}


			root = stack.pop();
			if (root.right != null && !stack.empty() && root.right == stack.peek()) {
				temp = stack.pop();
				stack.push(root);
				root = temp;
			} else {
				System.out.print(root.val + " ");
				root = null;
			}
		} while (!stack.empty());
	}





	public static void main(String[] args) {
		TreeNode root = new TreeNode(50);
		insert(root, 30);
		insert(root, 80);
		insert(root, 20);
		insert(root, 40);
		insert(root, 70);
		insert(root, 90);

		System.out.println(find(root, 100));
		System.out.println(find(root, 50));
		System.out.println(find(root, 90));
	}


}
