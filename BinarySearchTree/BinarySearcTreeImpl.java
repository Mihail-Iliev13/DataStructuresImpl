
public class BinarySearcTreeImpl<Integer> {

  TreeNode<Integer> root;


  public void add( int value){

    if (root == null) {
      root = new TreeNode<Integer>(value);
      root.parent = null;
    } else {
      TreeNode current = root;

      while (true) {

        if (value < current.value) {
          if (current.left == null) {
            current.left = new TreeNode(value);
            current.left.parent = current;
            break;
          } else {
            current = current.left;
          }
        } else {
          if (current.right == null) {
            current.right = new TreeNode(value);
            current.right.parent = current;
            break;
          } else {
            current = current.right;
          }
        }
      }
    }
  }

  public int getValue(int value) {

    TreeNode current = root;

    while (current != null) {
      int currValue = current.value;
      if (currValue == value) {
        return value;
      } else {
        if (value < currValue) {
          current = current.left;
        } else {
          current = current.right;
        }
      }
    }

    return -1;

  }

  private TreeNode getNode(int value) {

    TreeNode current = root;

    while (current != null) {
      int currValue = current.value;
      if (currValue == value) {
        return current;
      } else {
        if (value < currValue) {
          current = current.left;
        } else {
          current = current.right;
        }
      }
    }

    return null;
  }

  public void printTree(){
    traverseTree(root);
    System.out.println();
  }

  private void traverseTree(TreeNode node) {
    if (node.left != null) {
      traverseTree(node.left);
    }

    System.out.print(node.value + " ");

    if(node.right != null) {
      traverseTree(node.right);
    }
  }

  public boolean contains (int value) {
    TreeNode current = root;

    while (current != null) {
      int currValue = current.value;
      if (currValue == value) {
        return true;
      } else {
        if (value < currValue) {
          current = current.left;
        } else {
          current = current.right;
        }
      }
    }

    return false;
  }

  public void delete (int value) {

    TreeNode nodeToBeDeleted = getNode(value);

    if (nodeToBeDeleted != null) {
      TreeNode replacement = findReplacementNode(nodeToBeDeleted);

      if (replacement == null) {
        if (nodeToBeDeleted.parent != null && nodeToBeDeleted.parent.right != null
                && nodeToBeDeleted.parent.right.value == nodeToBeDeleted.value) {
          nodeToBeDeleted.parent.right = null;
        } else {
          if (nodeToBeDeleted.parent != null) {
            nodeToBeDeleted.parent.left = null;
          }
        }
        return;
      }

      if (replacement.parent.right != null && replacement.parent.right == replacement) {
        replacement.parent.right = null;
      } else if (replacement.parent.left != null && replacement.parent.left == replacement) {
        replacement.parent.left = null;
      }

      if (nodeToBeDeleted.right != null && replacement != nodeToBeDeleted.right) {
        nodeToBeDeleted.right.parent = replacement;
        replacement.right = nodeToBeDeleted.right;
      }

      if (nodeToBeDeleted.left != null && replacement != nodeToBeDeleted.left) {
        nodeToBeDeleted.left.parent = replacement;
        replacement.left = nodeToBeDeleted.left;
      }

      if (nodeToBeDeleted == root){
        root = replacement;
        root.parent = null;
      }

      if (nodeToBeDeleted.parent != null && nodeToBeDeleted.parent.left != null
              && nodeToBeDeleted == nodeToBeDeleted.parent.left) {
        nodeToBeDeleted.parent.left = replacement;
      }

      if (nodeToBeDeleted.parent != null && nodeToBeDeleted.parent.right != null
              && nodeToBeDeleted == nodeToBeDeleted.parent.right) {
        nodeToBeDeleted.parent.right = replacement;
      }

      replacement.parent = nodeToBeDeleted.parent;
      nodeToBeDeleted = null;
    }
  }

  private TreeNode findReplacementNode(TreeNode nodeToBeDeleted) {
    TreeNode start;
    boolean isLeft = false;

    if (nodeToBeDeleted.left != null) {
      start = nodeToBeDeleted.left;
      isLeft = true;
    } else if (nodeToBeDeleted.right != null){
      start = nodeToBeDeleted.right;
    } else {
      return null;
    }

    if (isLeft) {
      return findMaxLessThan(start);
    } else {
      return findMinBiggerThan(start);
    }
  }

  private TreeNode findMinBiggerThan(TreeNode node) {

    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  private TreeNode findMaxLessThan(TreeNode node) {

    while (node.right != null) {
      node = node.right;
    }

    return node;
  }

  class TreeNode<Integer>{
    int value;
    TreeNode right;
    TreeNode left;
    TreeNode parent;

    TreeNode(int value){

      this.value = value;
      this.right = null;
      this.left = null;

    }
  }
}
