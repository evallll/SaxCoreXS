package saxcorexs.saxcorexs.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fart implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player s = (Player) sender;
            s.sendMessage(ChatColor.RED + "You made a fart, it was so stinky...");
            Bukkit.getServer().broadcastMessage(ChatColor.GOLD + s.getName() + ChatColor.RED + " made a stinky fart.");

            s.setHealth(0);
            Bukkit.getServer().broadcastMessage("R.I.P " + ChatColor.GOLD + s.getName() + ChatColor.RESET + " died due to a stinky fart.");
                     }
        return false;
        }
}