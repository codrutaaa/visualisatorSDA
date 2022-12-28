package visualisatorSDA;

import javax.swing.JFrame;

class TreeFrame extends JFrame {
	public TreeFrame(TreeNode root) {
		TreePanel treePanel = new TreePanel();
		treePanel.setRoot(root);
		add(treePanel);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
