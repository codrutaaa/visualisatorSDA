package visualisatorSDA;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

// The TreePanel class extends JPanel and is responsible for drawing the tree.
class TreePanel extends JPanel {
  private TreeNode root;
  private int radius = 20;
  private int vGap = 50;

  public void setRoot(TreeNode root) {
    this.root = root;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (root != null) {
      drawTree(g, root, getWidth() / 2, 30, getWidth() / 4);
    }
  }

  private void drawTree(Graphics g, TreeNode root, int x, int y, int hGap) {
    g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
    g.drawString(String.valueOf(root.value), x - 6, y + 4);

    if (root.left != null) {
      connectLeftChild(g, x - hGap, y + vGap, x, y);
      drawTree(g, root.left, x - hGap, y + vGap, hGap / 2);
    }

    if (root.right != null) {
      connectRightChild(g, x + hGap, y + vGap, x, y);
      drawTree(g, root.right, x + hGap, y + vGap, hGap / 2);
    }
  }

  private void connectLeftChild(Graphics g, int x1, int y1, int x2, int y2) {
    double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
    int x11 = (int)(x1 + radius * (x2 - x1) / d);
    int y11 = (int)(y1 - radius * vGap / d);
    int x21 = (int)(x2 - radius * (x2 - x1) / d);
    int y21 = (int)(y2 + radius * vGap / d);
    g.drawLine(x11, y11, x21, y21);
  }

  private void connectRightChild(Graphics g, int x1, int y1, int x2, int y2) {
    double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
    int x11 = (int)(x1 - radius * (x1 - x2) / d);
    int y11 = (int)(y1 - radius * vGap / d);
    int x21 = (int)(x2 + radius * (x1 - x2) / d);
    int y21 = (int)(y2 + radius * vGap / d);
    g.drawLine(x11, y11, x21, y21);
    }

    @Override
    public Dimension getPreferredSize() {
    return new Dimension(200, 200);
    }
    }

