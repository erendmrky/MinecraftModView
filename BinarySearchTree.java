package minecraftModView;

import java.util.ArrayList;

public class BinarySearchTree {
	private TreeNode root;
	private int size;
	
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	
	private TreeNode createNewNode(Mod mod) {
		return new TreeNode(mod);
	}
	
	public int getSize() {
		return size;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public boolean insert (Mod mod) {
		if(root == null)
			root = createNewNode(mod);
		else {
			TreeNode current = root;
			TreeNode parrent = null;
			
			while(current != null) {
				if(mod.getModList().getFirst().compareTo(current.getMod().getModList().getFirst()) < 0) {
					parrent = current;
					current = current.getLeft();
				}
				else if(mod.getModList().getFirst().compareTo(current.getMod().getModList().getFirst()) > 0) {
					parrent = current;
					current = current.getRight();
				}
				
				else {
					return false;
				}
			}
			
			if(mod.getModList().getFirst().compareTo(parrent.getMod().getModList().getFirst()) < 0){
				parrent.setLeft(createNewNode(mod));
			}
			else {
				parrent.setRight(createNewNode(mod));		
				}
		}
		size++;
		return true;
	}
	
	public boolean delete(Mod mod) {
		TreeNode current = root;
		TreeNode parent = null;
		
		while(current != null) {
			if(mod.getModList().getFirst().compareTo(current.getMod().getModList().getFirst()) < 0) {
				parent = current;
				current = current.getLeft();
			}
			else if(mod.getModList().getFirst().compareTo(current.getMod().getModList().getFirst()) > 0) {
				parent = current;
				current = current.getRight();
			}
			
			else {
				break;
			}
		}
		if(current == null) {
			return false;
		}
		if(current.getLeft() == null) {
			
			if(parent == null) {
				root = current.getRight();
			}
			
			else {
				if(mod.getModList().getFirst().compareTo(parent.getMod().getModList().getFirst()) < 0)
					parent.setLeft(current.getRight());
				else
					parent.setRight(current.getRight());
			}
		}
		
		else {
			TreeNode parentOfRightMost = current;
			TreeNode rightMost = current.getLeft();
			
			while(rightMost.getRight() != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.getRight();
			}
			
			current.setMod(rightMost.getMod());
			
			if(parentOfRightMost.getRight() == rightMost)
				parentOfRightMost.setRight(rightMost.getLeft());
			else
				parentOfRightMost.setLeft(rightMost.getLeft());
			
		}
		size--;
		return true;
	}
	
	public Mod search(String modName) {
		TreeNode current = root;
		
		while(current != null) {
			if(modName.compareTo(current.getMod().getModList().getFirst()) < 0)
				current = current.getLeft();
			else if(modName.compareTo(current.getMod().getModList().getFirst()) > 0)
				current = current.getRight();
			else 
				return current.getMod();
		}
		return null;
	}
	

	
	public ArrayList<String> inorder(TreeNode root) {
	    ArrayList<String> modList = new ArrayList<>();
	    inorderTraversal(root, modList);
	    return modList;
	}

	private void inorderTraversal(TreeNode root, ArrayList<String> modList) {
	    if (root == null)
	        return;
	    
	    inorderTraversal(root.getLeft(), modList);
	    modList.add(root.getMod().getModList().getFirst());
	    inorderTraversal(root.getRight(), modList);
	}
}
