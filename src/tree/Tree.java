package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Node {

	Node left, right;
	int data;

	public Node(int data) {
		this.data = data;
	}

	public void insert(int value) {
		if (value < data) {
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new Node(value);
			} else {
				right.insert(value);
			}
		}

	}

	public boolean contains(int value) {

		if (value == data) {
			return true;
		} else if (value < data) {
			if (left == null) {
				return false;
			} else {
				return left.contains(value);
			}
		} else {
			if (right == null) {
				return false;
			} else {
				return right.contains(value);
			}

		}

	}

	public void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}
		System.out.print(data + " ");

		if (right != null) {
			right.printInOrder();
		}

	}

	public void printpreOrder() {
		System.out.print(data + " ");

		if (left != null) {
			left.printpreOrder();
		}

		if (right != null) {
			right.printpreOrder();
		}

	}

	public void printpostOrder() {
		if (left != null) {
			left.printpostOrder();
		}

		if (right != null) {
			right.printpostOrder();
		}

		System.out.print(data + " ");

	}

	public void depthFirst(Node root) {

		Stack<Node> stack = new Stack<>();

		stack.push(root);

		while (stack.size() > 0) {

			Node current = stack.pop();

			System.out.print(current.data + " ");

			if (current.right != null) {
				stack.push(current.right);
			}

			if (current.left != null) {
				stack.push(current.left);
			}

		}

		/// System.out.println(stack);

	}

	public void printIIterativenOrder(Node n) {

		if (n == null)
			return;

		Stack<Node> stack = new Stack<>();

		Node current = n;

		while (current != null || stack.size() > 0) {

			while (current != null) {
				/*
				 * place pointer to a tree node on the stack before traversing the node's left
				 * subtree
				 */
				stack.push(current);
				current = current.left;
			}

			/* Current must be NULL at this point */
			current = stack.pop();

			System.out.print(current.data + " ");

			/*
			 * we have visited the node and its left subtree. Now, it's right subtree's turn
			 */
			current = current.right;

		}

		System.out.println(stack);

	}

	public void printIIterativePreOrder(Node n) {

		if (n == null)
			return;

		Stack<Node> stack = new Stack<>();

		stack.add(n);

		Node curr;

		while (stack.size() > 0) {

			curr = stack.pop();
			System.out.print(curr.data + " ");

			if (curr.right != null)
				stack.add(curr.right);
			if (curr.left != null)
				stack.add(curr.left);

		}

		System.out.println(stack);

	}

	boolean checkBST(Node root) {

		/*
		 * boolean bool = true;
		 * 
		 * while (root != null && root.left != null) { if (!(root.left.data < root.data
		 * && root.left.data == root.data )) { System.out.println(root.left.data + " > "
		 * + root.data); bool = false; break; } if (root.left != null) root = root.left;
		 * }
		 * 
		 * while (root != null && root.right != null) { if (!(root.right.data >
		 * root.data)) { System.out.println(root.right.data + " > " + root.data); bool =
		 * false; break; } if (root.right != null) root = root.right; }
		 * 
		 * System.out.println(bool); return bool;
		 */

		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	boolean checkBST(Node root, int min, int max) {
		if (root == null)
			return true;

		if (root.data <= min || root.data >= max)
			return false;

		return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);

	}

	public static Node lca(Node root, int v1, int v2) {
		// Write your code here.
		// Decide if you have to call rekursively
		// Samller than both
		if (root.data < v1 && root.data < v2) {
			System.out.print("l");
			return lca(root.right, v1, v2);
		}
		// Bigger than both
		if (root.data > v1 && root.data > v2) {
			System.out.print("r");
			return lca(root.left, v1, v2);
		}

		// Else solution already found
		return root;

	}

	public static Node construct(int start, int end, int[] preorder, AtomicInteger pIndex, Map<Integer, Integer> map) {
		// base case
		if (start > end) {
			return null;
		}

		// The next element in `preorder[]` will be the root node of subtree
		// formed by sequence represented by `inorder[start, end]`
		Node root = new Node(preorder[pIndex.getAndIncrement()]);

		// get the root node index in sequence `inorder[]` to determine the
		// left and right subtree boundary
		int index = map.get(root.data);

		// recursively construct the left subtree
		root.left = construct(start, index - 1, preorder, pIndex, map);

		// recursively construct the right subtree
		root.right = construct(index + 1, end, preorder, pIndex, map);

		// return current node
		return root;
	}

	public Node construct(int[] inorder, int[] preorder) {

		// create a map to efficiently find the index of any element in
		// a given inorder sequence
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		// `pIndex` stores the index of the next unprocessed node in a preorder
		// sequence. We start with the root node (present at 0th index).
		AtomicInteger pIndex = new AtomicInteger(0);

		return construct(0, inorder.length - 1, preorder, pIndex, map);
	}

	Node construct_tree_iteratively(int[] inorder, int[] preorder) {
		int preIndex = 0, inIndex = 0, flag = 0;
		Stack<Node> st = new Stack<>();

		Node root = new Node(preorder[preIndex]);
		++preIndex;
		st.push(root);
		Node prev = root;

		while (preIndex < preorder.length) {
			if (!st.empty() && inorder[inIndex] == st.peek().data) {
				prev = st.pop();
				++inIndex;
				flag = 1;
			} else {
				Node node = new Node(preorder[preIndex]);
				if (flag == 0) {
					prev.left = node;
					prev = prev.left;
				} else {
					prev.right = node;
					prev = prev.right;
					flag = 0;
				}
				st.push(node);
				++preIndex;
			}
		}
		return root;
	}

	Node construct_tree_iterat(int[] inorder, int[] postorder) {
		int postIndex = postorder.length - 1, inIndex = inorder.length - 1, flag = 0;
		Stack<Node> st = new Stack<>();

		Node root = new Node(postorder[postIndex]);
		--postIndex;
		st.push(root);
		Node prev = root;

		while (postIndex >= 0) {
			if (!st.empty() && inorder[inIndex] == st.peek().data) {
				prev = st.pop();
				--inIndex;
				flag = 1;
			} else {
				Node node = new Node(postorder[postIndex]);
				if (flag == 0) {
					prev.right = node;
					prev = prev.right;
				} else {
					prev.left = node;
					prev = prev.left;
					flag = 0;
				}
				st.push(node);
				--postIndex;
			}
		}
		return root;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	public void breadthFirst(Node node) {
		// TODO Auto-generated method stub

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			System.out.print(current.data + " ");

			if (current.left != null) {
				queue.add(current.left);
			}

			if (current.right != null) {
				queue.add(current.right);
			}
		}

	}

	public int rootLeafSum(Node node) {
		// TODO Auto-generated method stub

		if (node.left == null && node.right == null) {
			return node.data;
		}

		int one = 0, two = 0;
		if (node.left != null) {
			one = rootLeafSum(node.left);
		}

		if (node.right != null) {
			two = rootLeafSum(node.right);
		}

		System.out.println(one + "   " + two);

		int max = Math.max(one, two);

		System.out.println(max);

		return node.data + max;

	}

	ArrayList<Integer> rightView(Node root) {
		// add code here.
		if (root == null) {
			return null;
		}

		Queue<Node> queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

//			System.out.print(node.data + " ");
			for (int i = 0; i < queue.size(); i++) {
				Node node = queue.remove();

				if (i == 0)
					list.add(node.data);

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return list;
	}

	void left_view(Node node, AtomicInteger maxlevel, int level) {
		if (node == null)
			return;
		if (maxlevel.get() < level) {
			System.out.print(node.data + " ");
			maxlevel.set(level);
		}
		left_view(node.left, maxlevel, level + 1);
		left_view(node.right, maxlevel, level + 1);
	}

	void right_view(Node node, AtomicInteger maxlevel, int level) {
		if (node == null)
			return;
		if (maxlevel.get() < level) {
			System.out.print(node.data + " ");
			maxlevel.set(level);
		}
		right_view(node.right, maxlevel, level + 1);
		right_view(node.left, maxlevel, level + 1);
	}

	public void printIIterativePostOrder(Node node) {
		// TODO Auto-generated method stub

		if (node == null)
			return;

		Node curr;

		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		stack1.add(node);

		while (!stack1.empty()) {
			curr = stack1.pop();
			stack2.add(curr);

			if (curr.left != null) {
				stack1.add(curr.left);
			}

			if (curr.right != null) {
				stack1.add(curr.right);
			}
		}

		while (!stack2.empty()) {
			System.out.print(stack2.pop().data + " ");
		}

	}

	public void printIIterativeOneStackPostOrder(Node node) {
		// TODO Auto-generated method stub
		Stack<Node> stack = new Stack<>();
		Node current = node;
		Node prev = null;

		while (current != null || !(stack.isEmpty())) {
			if (current != null) {
				stack.add(current);
				current = current.left;
			} else {
				current = stack.peek();
				if (current.right == null || current.right == prev) {
					System.out.print(current.data + " ");
					stack.pop();
					prev = current;
					current = null;
				} else {
					current = current.right;
				}
			}

		}

	}

	int height(Node node) {
		if (node == null)
			return -1;
		int lheight = height(node.left);
		int rheight = height(node.right);
		return Math.max(lheight, rheight) + 1;
	}

	void print_level(Node node, int level) {
		if (node == null)
			return;
		else if (level == 0)
			System.out.print(node.data + " ");
		else if (level > 0) {
			print_level(node.left, level - 1);
			print_level(node.right, level - 1);
		}
	}

	void levelorder_traversal(Node root) {
		// System.out.print(height(root) + " ");
		for (int level = 0; level <= height(root); level++)
			print_level(root, level);
	}

	void morris_inorder_traversal(Node root) {
		Node curr = root;

		while (curr != null) {
			if (curr.left == null) {
				System.out.print(curr.data + " ");
				curr = curr.right;
			} else {
				// Find the inorder predecessor of current
				Node predecessor = curr.left;
				while (predecessor.right != null && predecessor.right != curr) {
					predecessor = predecessor.right;
				}

				// Make current as the right child of its inorder predecessor
				if (predecessor.right == null) {
					predecessor.right = curr;
					curr = curr.left;
				}

				// Revert the changes, fix the right child of predecessor
				else {
					predecessor.right = null;
					System.out.print(curr.data + " ");
					curr = curr.right;
				}
			}
		}
	}

	void morris_preorder_traversal(Node root) {
		Node curr = root;

		while (curr != null) {
			if (curr.left == null) {
				System.out.print(curr.data + " ");
				curr = curr.right;
			} else {
				// Find the inorder predecessor of current
				Node predecessor = curr.left;
				while (predecessor.right != null && predecessor.right != curr) {
					predecessor = predecessor.right;
				}

				// Make current as the right child of its inorder predecessor
				if (predecessor.right == null) {
					predecessor.right = curr;
					System.out.print(curr.data + " ");
					curr = curr.left;
				}

				// Revert the changes, fix the right child of predecessor
				else {
					predecessor.right = null;
					curr = curr.right;
				}
			}
		}
	}

	void print_level(Node node, int level, boolean ltr) {
		if (node == null)
			return;
		else if (level == 0)
			System.out.print(node.data + " ");
		else if (level > 0) {
			if (ltr) {
				print_level(node.left, level - 1, ltr);
				print_level(node.right, level - 1, ltr);
			} else {
				print_level(node.right, level - 1, ltr);
				print_level(node.left, level - 1, ltr);
			}
		}
	}

	void zigzag_levelorder_traversal_recursion(Node root) {
		boolean ltr = false;
		for (int level = 0; level <= height(root); level++) {
			print_level(root, level, ltr);
			ltr = !ltr;
		}
	}

	// Recursive function to construct a binary tree from a given
	// inorder and postorder traversals
	public static Node constructPI(int start, int end, int[] postorder, AtomicInteger pIndex,
			Map<Integer, Integer> map) {
		// base case
		if (start > end) {
			return null;
		}

		// Consider the next item from the end of a given postorder sequence.
		// This value would be the root node of a subtree formed by sequence
		// inorder[start, end].
		Node root = new Node(postorder[pIndex.getAndDecrement()]);

		// search the current node index in inorder sequence to determine
		// the boundary of the left and right subtree of the current node
		int index = map.get(root.data);

		// recursively construct the right subtree
		root.right = construct(index + 1, end, postorder, pIndex, map);

		// recursively construct the left subtree
		root.left = construct(start, index - 1, postorder, pIndex, map);

		// return the root node
		return root;
	}

	// Construct a binary tree from inorder and postorder traversals.
	// This function assumes that the input is valid, i.e., given
	// inorder and postorder sequences forming a binary tree.

	public Node constructInorderPostOrder(int[] inorder, int[] postorder) {
		// TODO Auto-generated method stub
		// get size
		int n = inorder.length;

		// map is used to efficiently find the index of any element in
		// a given inorder sequence
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(inorder[i], i);
		}

		// `pIndex` stores the index of the next unprocessed node from the end
		// of the postorder sequence
		AtomicInteger pIndex = new AtomicInteger(n - 1);
		return construct(0, n - 1, postorder, pIndex, map);
	}

	// Recursive function to construct a binary tree from a given inorder and
	// level order traversals
	public static Node buildTree(int[] inorder, int start, int end, Map<Integer, Integer> map) {
		// base case
		if (start > end) {
			return null;
		}

		// find the root node index in sequence `inorder[]` to determine the
		// left and right subtree boundary
		int index = start;
		for (int j = start + 1; j <= end; j++) {
			// Find node with minimum index in level order traversal.
			// That would be the root node of the sequence inorder[start, end]
			if (map.get(inorder[j]) < map.get(inorder[index])) {
				index = j;
			}
		}

		// construct the root node
		Node root = new Node(inorder[index]);

		// recursively construct the left subtree
		root.left = buildTree(inorder, start, index - 1, map);

		// recursively construct the right subtree
		root.right = buildTree(inorder, index + 1, end, map);

		// return the root node
		return root;
	}

	// Construct a binary tree from inorder and level order traversals
	public static Node buildTree(int[] in, int[] level) {
		// create a map to efficiently find the index of an element in a
		// level order sequence
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(level[i], i);
		}

		// construct the tree and return it
		return buildTree(in, 0, in.length - 1, map);
	}

	int heights(Node node, AtomicInteger i) {
		if (node == null)
			return -1;
		int lheight = heights(node.left, i);
		int rheight = heights(node.right, i);
		int max = Math.max(i.get(), lheight + rheight + 2);
		i.set(max);
		return Math.max(lheight, rheight) + 1;
	}

}

//A Pair class
class Pair<U, V> {
	public final U first; // first field of a pair
	public final V second; // second field of a pair

	// Constructs a new Pair with specified values
	private Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}

	// Factory method for creating a Typed Pair immutable instance
	public static <U, V> Pair<U, V> of(U a, V b) {
		// calls private constructor
		return new Pair<>(a, b);
	}
}

public class Tree {

	public static void printTop(Node root, int dist, int level, Map<Integer, Pair<Integer, Integer>> map) {
// base case: empty tree
		if (root == null) {
			return;
		}
// if the current level is less than the maximum level seen so far
// for the same horizontal distance, or if the horizontal distance
// is seen for the first time, update the map
		if (!map.containsKey(dist) || level < map.get(dist).second) {
// update value and level for current distance
			map.put(dist, Pair.of(root.data, level));
		}

// recur for the left subtree by decreasing horizontal distance and
// increasing level by 1
		printTop(root.left, dist - 1, level + 1, map);

// recur for the right subtree by increasing both level and
// horizontal distance by 1
		printTop(root.right, dist + 1, level + 1, map);
	}

// Function to print the top view of a given binary tree
	public static void printTop(Node root) {
// create a `TreeMap` where
// key —> relative horizontal distance of the node from the root node, and
// value —> pair containing the node's value and its level
		Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();

// perform preorder traversal on the tree and fill the map
		printTop(root, 0, 0, map);

// traverse the `TreeMap` and print the top view
		for (Pair<Integer, Integer> it : map.values()) {
			System.out.print(it.first + " ");
		}
	}

	// Recursive function to perform preorder traversal on the tree and fill the map.
    // Here, the node has `dist` horizontal distance from the tree's root,
    // and the `level` represents the node's level.
 
    public static void printBottom(Node root, int dist, int level,
                                Map<Integer, Pair<Integer, Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // if the current level is more than or equal to the maximum level seen so far
        // for the same horizontal distance or horizontal distance is seen for
        // the first time, update the map
 
        if (!map.containsKey(dist) || level > map.get(dist).second)
        {
            // update value and level for the current distance
            map.put(dist, Pair.of(root.data, level));
        }
 
        // recur for the left subtree by decreasing horizontal distance and
        // increasing level by 1
        printBottom(root.left, dist - 1, level + 1, map);
 
        // recur for the right subtree by increasing both level and
        // horizontal distance by 1
        printBottom(root.right, dist + 1, level + 1, map);
    }
 
    // Function to print the bottom view of a given binary tree
    public static void printBottom(Node root)
    {
        /* Create a `TreeMap` where
        key —> relative horizontal distance of the node from the root node, and
        value —> pair containing the node's value and its level */
 
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
 
        // perform preorder traversal on the tree and fill the map
        printBottom(root, 0, 0, map);
 
        // traverse the `TreeMap` and print the bottom view
        for (Pair<Integer, Integer> it: map.values()) {
            System.out.print(it.first + " ");
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(4);

		node.insert(2);
		node.insert(3);
		node.insert(1);
		node.insert(7);
		node.insert(6);
		node.insert(8);
//		node.insert(9);

		/*
		 * for(int i=2; i<10; i++) { node.insert(i); }
		 */

		// System.out.print(node.checkBST(node));

		// node.lca(node, 1, 7);

		/*
		 * Consider below tree 1 / \ / \ 2 3 / / \ / / \ 4 5 6 / \ / \ 7 8
		 */

		int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
		int[] preorder = { 1, 2, 4, 3, 5, 7, 8, 6 };

		node.construct(inorder, preorder);

		int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1 };

//		Node root = node.constructInorderPostOrder(inorder, postorder);

		// int[] inorders = { 4, 2, 5, 1, 6, 3, 7 };
		// int[] level = { 1, 2, 3, 4, 5, 6, 7 };

		// node.buildTree(inorders, level);

		AtomicInteger i = new AtomicInteger(0);

		node.heights(node, i);

		System.out.println("The max diameter is " + i.get());

		System.out.print("Left View : ");

		AtomicInteger maxlevel = new AtomicInteger(-1);

		AtomicInteger maxlevels = new AtomicInteger(-1);

		node.left_view(node, maxlevel, 0);

		System.out.print("Right View : ");

		node.right_view(node, maxlevels, 0);

		System.out.print("\n");

		System.out.print("Top View : ");

	//	printTop(node);

		System.out.print("\n");

		System.out.print("Bottom View : ");

		printBottom(node);

		System.out.print("\n");

		// traverse the constructed tree
		System.out.print("Inorder : ");
		node.printInOrder();

		System.out.print("\n");

		System.out.print("Preorder : ");

		node.printpreOrder();

		System.out.print("\n");

		System.out.print("Postorder : ");

		node.printpostOrder();

		System.out.print("\n");

		System.out.print("Inorder Iteratively : ");

		node.printIIterativenOrder(node);

		System.out.print("Preorder Iteratively : ");

		node.printIIterativePreOrder(node);

		System.out.print("Postorder Iteratively : ");

		node.printIIterativePostOrder(node);

		System.out.print("\n");

		System.out.print("Postorder Iteratively : ");

		node.printIIterativeOneStackPostOrder(node);

		System.out.print("\n");

		System.out.print("levelorder_traversal : ");

		node.levelorder_traversal(node);

		System.out.print("\n");

		System.out.print("Morris In order: ");

		node.morris_inorder_traversal(node);

		System.out.print("\n");

		System.out.print("Morris Preorder: ");

		node.morris_preorder_traversal(node);

		System.out.print("\n");

		System.out.print("ZIG ZAG traversal: ");

		node.zigzag_levelorder_traversal_recursion(node);

		System.out.print("\n");

		System.out.print("DFS : ");

		node.depthFirst(node);

		System.out.print("\n");

		System.out.print("BFS : ");

		node.breadthFirst(node);

		System.out.print("\n");

		System.out.print("ROOT TO LEAF SUM : ");

		System.out.println(node.rootLeafSum(node));

		// System.out.print("\nPostorder : ");
		// postorderTraversal(root);

	}
}
