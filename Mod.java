package minecraftModView;

import java.util.LinkedList;

public class Mod {
private LinkedList<String> modList;
	
	public Mod(String modName,String modFeatures, String modDescription, String modLink, String modSize, BinarySearchTree searchTree) {
		modList = new LinkedList<String>();
		modList.add(modName);
		modList.add(modFeatures);
		modList.add(modDescription);
		modList.add(modLink);
		modList.add(modSize);
		searchTree.insert(this);
	}

	public LinkedList<String> getModList() {
		return modList;
	}

	public void setModList(LinkedList<String> modList) {
		this.modList = modList;
	}
}
