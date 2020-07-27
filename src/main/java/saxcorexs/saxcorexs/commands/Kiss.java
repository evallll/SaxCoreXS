package saxcorexs.saxcorexs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import saxcorexs.saxcorexs.SaxCoreXS;

public class Kiss implements CommandExecutor {
    Plugin plugin = JavaPlugin.getPlugin(SaxCoreXS.class);
    FileConfiguration config = plugin.getConfig();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
                Player s = (Player) sender;
                if (args.length == 0) {
                    s.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + config.getString("Prefix") + ChatColor.DARK_GRAY + "] " + ChatColor.BOLD + ChatColor.RED + "Please specify a player, /kiss <player>");
                    return true;
                }
            if (args[0].equalsIgnoreCase("@all")) {
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + s.getName() + ChatColor.LIGHT_PURPLE + " gives " + ChatColor.GOLD + "everyone"  + ChatColor.LIGHT_PURPLE + " a kiss.");
                return true;
            }
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    s.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + config.getString("Prefix") + ChatColor.DARK_GRAY + "] " + ChatColor.BOLD + ChatColor.RED + "That player is not online.");
                    return true;
                }
                if (target.getName().equals(s.getName())) {
                    s.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + config.getString("Prefix") + ChatColor.DARK_GRAY + "] " + ChatColor.BOLD + ChatColor.RED + "Invalid usage. You can't kiss yourself");
                } else {
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + s.getName() + ChatColor.LIGHT_PURPLE + " gives " + ChatColor.GOLD + target.getName() + ChatColor.LIGHT_PURPLE + " a kiss.");
                }
            }
        return false;
    }
}


