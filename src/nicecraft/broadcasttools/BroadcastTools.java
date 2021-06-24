package nicecraft.broadcasttools;

import org.bukkit.plugin.java.JavaPlugin;

import nicecraft.broadcasttools.commands.MainCommand;
import nicecraft.broadcasttools.commands.TwitchCommand;
import nicecraft.broadcasttools.commands.YoutubeCommand;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;

public class BroadcastTools extends JavaPlugin {

	public String pathConfig;
	PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();
	public String name = ChatColor.GRAY+"["+ChatColor.GOLD+pdffile.getName()+ChatColor.GRAY+"]";
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"<-------------------------------------------------------------------->");
		Bukkit.getConsoleSender().sendMessage(name+ChatColor.translateAlternateColorCodes('&', " &aPlugin encendido..."));
		Bukkit.getConsoleSender().sendMessage(name+ChatColor.translateAlternateColorCodes('&', " &5Creado para &6&lvodkapvp.life&5. &8~ &4&lReinadoRojo"));
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"<-------------------------------------------------------------------->");
		commandRegister();
		registerConfig();
	}
	
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"<-------------------------------------------------------------------->");
		Bukkit.getConsoleSender().sendMessage(name+ChatColor.translateAlternateColorCodes('&', " &aPlugin apagado!"));
		Bukkit.getConsoleSender().sendMessage(name+ChatColor.translateAlternateColorCodes('&', " &5adios..."));
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"<-------------------------------------------------------------------->");
	}
	
	public void commandRegister() {
		this.getCommand("broadcasttools").setExecutor(new MainCommand(this));
		this.getCommand("bct").setExecutor(new MainCommand(this));
		this.getCommand("twitch").setExecutor(new TwitchCommand(this));
		this.getCommand("youtube").setExecutor(new YoutubeCommand(this));
	}
	
	public void registerConfig() {
		File config = new File(this.getDataFolder(),"config.yml");
		pathConfig = config.getPath();
		if(!config.exists()) {
			this.getConfig().options().copyDefaults(true);
			saveConfig();
		}
	}
}
