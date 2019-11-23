package loopturn.vaulttabprefix.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class SimpleTeam implements ITeam {

	private Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
	private Player p;
	private String group;
	private String subgroup;
	private String prefix;
	private String suffix;
	
	public SimpleTeam(IGroup group) {
		this.p = group.getPlayer();
		this.group = group.getGroup();
		this.subgroup = group.getSubGroup();
		this.prefix = group.getPrefix();
		this.suffix = group.getSuffix();
	}
	
	public void setTeam() {
		if(scoreboard.getTeam(group+subgroup) == null) {
			scoreboard.registerNewTeam(group+subgroup);
		}
		
		Team team = scoreboard.getTeam(group+subgroup);
		team.setPrefix(ChatColor.translateAlternateColorCodes('&', prefix));
		team.setSuffix(ChatColor.translateAlternateColorCodes('&', suffix));
		team.addEntry(p.getName());
	}

}
