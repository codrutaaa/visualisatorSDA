package visualisatorSDA;

import java.util.Scanner;

public class TreeVisualizationExampleWithInput {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Read the number of nodes from the console.
    System.out.print("Enter number of nodes: ");
    int numNodes = scanner.nextInt();

    // Read the root node value from the console.
    System.out.print("Enter root node value: ");
    int rootValue = scanner.nextInt();

    // Create the root node.
    TreeNode root = new TreeNode(rootValue);

    // Add the remaining nodes to the tree.
    for (int i = 1; i < numNodes; i++) {
      System.out.print("Enter node value: ");
      int value = scanner.nextInt();
      addNode(root, value);
    }

    // Create a frame to display the tree.
    TreeFrame frame = new TreeFrame(root);
    frame.setVisible(true);
  }

  // Adds a node with the specified value to the tree.
  public static void addNode(TreeNode root, int value) {
    if (value < root.value) {
      if (root.left == null) {
        root.left = new TreeNode(value);
      } else {
        addNode(root.left, value);
      }
    } else {
      if (root.right == null) {
        root.right = new TreeNode(value);
      } else {
        addNode(root.right, value);
      }
    }
  }
}
