package minecraftModView;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree searchTree = new BinarySearchTree();
		
		Mod mod1 = new Mod("pixelmon", "New Mobs, New gameplay, New items and more.","Changes minecraft into Pokemon" ,"reforged.gg/", "455MB",searchTree);
		Mod mod2 = new Mod("jei", "In-game item list","JEI is an item and recipe viewing mod for Minecraft, built from the ground up for stability and performance." , "www.curseforge.com/minecraft/mc-mods/jei", "1.04MB",searchTree);
		Mod mod3 = new Mod("optifine", "FPS boost,Support for Shaders and more.","OptiFine is a Minecraft optimization mod." , "optifine.net/home", "6MB",searchTree);
		Mod mod4 = new Mod("geckolib", " 30+ easings,concurrent animation support and more.","GeckoLib is an animation engine for Minecraft Mods" , "www.curseforge.com/minecraft/mc-mods/geckolib", "539.45 KB",searchTree);
		Mod mod5 = new Mod("rlcraft", "New Mobs, Harder minecraft and more.","A mod created by combining many mods" , "www.curseforge.com/minecraft/modpacks/rlcraft", "20MB",searchTree);
		Mod mod6 = new Mod("the lost cities", "New structures, New blocks and more", "A mod that allows you to spawn in the abandoned city.", "www.curseforge.com/minecraft/mc-mods/the-lost-cities", "10MB", searchTree);
		Mod mod7 = new Mod("create", "New tools, New blocks and more", " Create, a mod offering a variety of tools and blocks for Building, Decoration and Aesthetic Automation.", "www.curseforge.com/minecraft/mc-mods/the-lost-cities", "14.27MB", searchTree);
		Mod mod8 = new Mod("creativecore", "Gui-Api, Platform independent loader and more", "Fixes the problem of having to restart your client when your Session invalidates", "www.curseforge.com/minecraft/mc-mods/creativecore", "10MB", searchTree);
		Mod mod9 = new Mod("reauth", "Session indicator at the top and more", "Fixes the Problem of having to restart your Client when your Session is invalid", "www.curseforge.com/minecraft/mc-mods/the-lost-cities", "10MB", searchTree);
		Mod mod10 = new Mod("minetogether", "Friend lists, Global / Group chat, Direct messages and more", "MineTogether is a platform that also contains a multiplayer enhancement mod.", "www.curseforge.com/minecraft/mc-mods/creeperhost-minetogether", "10MB", searchTree);
		
		
		McModViewFrame mainFrame = new McModViewFrame(searchTree);
	}
}
