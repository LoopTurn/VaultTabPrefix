package loopturn.vaulttabprefix.core;

import org.bukkit.entity.Player;

import net.milkbowl.vault.chat.Chat;

public class VaultGroup implements IGroup {
	
	private Chat chat = Main.getPlugin(Main.class).getChat();
	private Player p;
	private String group;
	private String[] groups;
	private String prefix;
	private String suffix;
	private String subgroup;
	
	public VaultGroup(Player p) {
		this.p = p;
		this.groups = chat.getPlayerGroups(p);
		this.group = groups[0];
		this.prefix = getGroupPrefix();
		this.suffix = getGroupSuffix();
	}
	
	private String getGroupPrefix() {
		String ix = "";
		
		for(int i=0; i<groups.length; i++) {
			String ix2 = chat.getGroupPrefix(p.getWorld(), groups[i]);
			if(ix2 != "") {
				ix = ix2;
				break;
			}
		}
		return ix;
	}
	
	private String getGroupSuffix() {
		String ix = "";
		
		for(int i=0; i<groups.length; i++) {
			String ix2 = chat.getGroupSuffix(p.getWorld(), groups[i]);
			if(ix2 != "") {
				ix = ix2;
				subgroup = groups[i];
				break;
			}
		}
		return ix;
	}
	
	public String getGroup() {
		return group;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getSuffix() {
		return suffix;
	}
	
	public Player getPlayer() {
		return p;
	}
	
	public String getSubGroup() {
		return subgroup;
	}
}
