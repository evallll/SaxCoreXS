package saxcorexs.saxcorexs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import saxcorexs.saxcorexs.SaxCoreXS;

public class SuperSmite implements CommandExecutor {
    Plugin plugin = JavaPlugin.getPlugin(SaxCoreXS.class);
    FileConfiguration config = plugin.getConfig();
    @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (sender instanceof Player) {
                Player s = (Player) sender;
                if (!s.hasPermission(config.getString("SuperSmite"))) {
                    s.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + config.getString("Prefix") + ChatColor.DARK_GRAY + "] " + ChatColor.BOLD + ChatColor.RED + "No permission to use this command.");
                    return true;
                }
                if (args.length == 0) {
                    s.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + config.getString("Prefix") + ChatColor.DARK_GRAY + "] " + ChatColor.BOLD + ChatColor.RED + "Please specify a player, /supersmite <player>");
                    return true;
                }
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    s.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + config.getString("Prefix") + ChatColor.DARK_GRAY + "] " + ChatColor.BOLD + ChatColor.RED + "That player is not online.");
                    return true;
                }
                if (target.hasPermission(config.getString("SuperSmiteImmune"))) {
                    s.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + config.getString("Prefix") + ChatColor.DARK_GRAY + "] " + ChatColor.BOLD + ChatColor.RED + "That player is immune.");
                    return true;
                }
                
                Location location = target.getLocation();
                if (s.hasPermission(config.getString("SuperSmite"))) {
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + s.getName() + ChatColor.RED + " is swinging the russian supersmite hammer over " + ChatColor.GOLD + target.getName());
                    target.chat("Oh no! " + s.getName() + " will turn me into a burnt mcdonalds french fry!");
                    for (int i = 1; i <= 20; i++) {
                        target.getLocation().getWorld().strikeLightning(location);
                    }
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + s.getName() + ChatColor.RED + " has supersmitten " + ChatColor.GOLD + target.getName());
                    s.sendMessage(ChatColor.RED + "You've made a burnt mcdonalds french fry out of " + ChatColor.GOLD + target.getName());
                    target.sendMessage(ChatColor.RED + "You've been turned into a burnt mcdonalds french fry by " + ChatColor.GOLD + s.getName());
                    target.setHealth(0);
                }
            }
            return false;
        }
    }
