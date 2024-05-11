package minecraftModView;

public class TreeNode {
	private Mod mod;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(Mod mod) {
		this.mod = mod;
		this.left = null;
		this.right = null;
	}

	public Mod getMod() {
		return mod;
	}

	public void setMod(Mod mod) {
		this.mod = mod;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
}