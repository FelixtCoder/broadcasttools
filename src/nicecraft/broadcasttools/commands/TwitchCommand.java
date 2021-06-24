package nicecraft.broadcasttools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import nicecraft.broadcasttools.BroadcastTools;

public class TwitchCommand implements CommandExecutor {
	private BroadcastTools plugin;
	
	public TwitchCommand (BroadcastTools plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		FileConfiguration config = plugin.getConfig();
		if(!(sender instanceof Player)) {
			
			
		return false;
		} else {
			Player player = (Player) sender;
			if(args.length > 0) {
				if(player.isPermissionSet("bct.twitch") || player.isPermissionSet("bct.admin") || player.isOp()) {
					String message = config.getString("Config.aviso-twitch").replaceAll("%link%", args[0]);
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
					return true;
				} else {
					String error_message = config.getString("Config.error-message");
					player.sendMessage(plugin.name+" "+ChatColor.translateAlternateColorCodes('&', error_message));
					return false;
				}
			} else {
				player.sendMessage(plugin.name+ChatColor.RED+" Lo sentimos pero este comando no existe");
				return false;
			}
		}
	}
}
