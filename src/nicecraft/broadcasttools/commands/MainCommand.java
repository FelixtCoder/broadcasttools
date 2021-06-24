package nicecraft.broadcasttools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import nicecraft.broadcasttools.BroadcastTools;

public class MainCommand implements CommandExecutor {

	private BroadcastTools plugin;
	
	public MainCommand (BroadcastTools plugin) {
		this.plugin = plugin;
	}


	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		FileConfiguration config = plugin.getConfig();
		if(!(sender instanceof Player)) {
			// Consola
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("reload")) {
					plugin.reloadConfig();
					Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('%', "%eConfiguracion recargada %2Correctamente"));
				return true;
				} else {
					if(config.getString("Config.alertas-desde-consola") == "no") {
						Bukkit.getConsoleSender().sendMessage(plugin.name+ChatColor.DARK_RED+" No se puede ejecutar este tipo de comando desde la consola!");
						Bukkit.getConsoleSender().sendMessage(plugin.name+ChatColor.GRAY+" Se puede configugar desde config.yml");
						return true;
					} else {
						if(args[0].equalsIgnoreCase("twitch")) {
							// Alerta
						return true;
						} else if(args[0].equalsIgnoreCase("youtube")) {
							
							
						return true;
						}
					}
				}
				return true;
			} else {
				Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"<-------------------->");
				Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"/twitch <link>");
				Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"/youtube <link>");
				Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"<-------------------->");
				return false;
			}
		} else {
			Player player = (Player) sender;
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("reload")) {
					if(player.isPermissionSet("bct.admin") || player.isOp()) {
						plugin.reloadConfig();
						player.sendMessage(ChatColor.translateAlternateColorCodes('%', "%eConfiguracion recargada %2Correctamente"));
					}
				return true;
				} 
				else if(args[0].equalsIgnoreCase("help")) {
					if(player.isPermissionSet("bct.help") || player.isPermissionSet("bct.admin") || player.isOp()) {
						player.sendMessage(ChatColor.AQUA+"<-------------------->");
						//player.sendMessage(ChatColor.AQUA+"/aviso <mensaje>");
						player.sendMessage(ChatColor.AQUA+"/twitch <link>");
						player.sendMessage(ChatColor.AQUA+"/youtube <link>");
						player.sendMessage(ChatColor.AQUA+"<-------------------->");
					}
				return true;
				}
				else {
					player.sendMessage(plugin.name+ChatColor.RED+" Ese comando no existe use:"+ChatColor.GOLD+" /btc help"+ChatColor.RED+" para saber que comandos hay!");
					return true;
				}

			} else {
				player.sendMessage(plugin.name+ChatColor.translateAlternateColorCodes('&', " &cUtilice &6&l/bct help &cpara saber conocer mas comandos"));
				return true;
			}
		}
	}
	
	
	

}
