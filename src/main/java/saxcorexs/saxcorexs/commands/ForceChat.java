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

public class ForceChat implements CommandExecutor {
    Plugin plugin = JavaPlugin.getPlugin(SaxCoreXS.class);
    FileConfiguration config = plugin.getConfig();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player s = (Player) sender;
                if (!s.hasPermission("saxcorexs.forcechat")) {
                    s.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + config.getString("Prefix") + ChatColor.DARK_GRAY + "] " + ChatColor.BOLD + ChatColor.RED + "No permission to use this command.");
                    return true;
                }
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (target == null) {
                        s.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + config.getString("Prefix") + ChatColor.DARK_GRAY + "] " + ChatColor.BOLD + ChatColor.RED + "That player is not online.");
                        return true;
                    }
                    if (args.length == 1) {
                        s.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + config.getString("Prefix") + ChatColor.DARK_GRAY + "] " + ChatColor.BOLD + ChatColor.RED + "Please specify a message, /forcechat " + target.getName() + " <message>");
                        return true;
                    }
                    StringBuilder msg = new StringBuilder(args[1]);
                    for (int arg = 2; arg < args.length; arg++) {
                        msg.append(" ").append(args[arg]);
                    }
                    String m = msg.toString();
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "Forcing " + target.getName() + " to say " + ChatColor.RED + "'" + msg + ChatColor.RED + "'");
                    target.chat(m);
                }
        return false;
    }
}
