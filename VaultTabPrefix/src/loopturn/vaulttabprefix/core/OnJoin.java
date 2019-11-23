package loopturn.vaulttabprefix.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		PlayerData pd = new PlayerData();
		VaultGroup vg = new VaultGroup(e.getPlayer());
		SimpleTeam st = new SimpleTeam(vg);
		st.setTeam();
	}

}
