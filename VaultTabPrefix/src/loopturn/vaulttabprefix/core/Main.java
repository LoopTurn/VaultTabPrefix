package loopturn.vaulttabprefix.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new OnJoin(), this);
		setupChat();
		Bukkit.getConsoleSender().sendMessage("[VaultTabPrefix] plugin enabled!");
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("[VaultTabPrefix] plugin disabled!");
	}
	
	private Chat chat;
	
	private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
	
	public Chat getChat() {
		return chat;
	}

}
