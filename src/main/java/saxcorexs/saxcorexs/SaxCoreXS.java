package saxcorexs.saxcorexs;

import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import saxcorexs.saxcorexs.commands.*;

public final class SaxCoreXS extends JavaPlugin {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        config.addDefault("Server name", "Your Server Name Here");
        config.addDefault("Prefix", "§bSaxCoreXS");
        config.addDefault("ForceChat", "saxcorexs.forcechat");
        config.addDefault("SuperSmite", "saxcorexs.supersmite");
        config.options().copyDefaults(false);
        this.getCommand("helloworld").setExecutor((CommandExecutor) new HelloWorld());
        this.getCommand("forcechat").setExecutor((CommandExecutor) new ForceChat());
        this.getCommand("supersmite").setExecutor((CommandExecutor) new SuperSmite());
        this.getCommand("fart").setExecutor((CommandExecutor) new Fart());
        this.getCommand("hug").setExecutor((CommandExecutor) new Hug());
        this.getCommand("kiss").setExecutor((CommandExecutor) new Kiss());
        this.getCommand("owo").setExecutor((CommandExecutor) new OwO());
        getLogger().info("The server name is currently: " + config.getString("Server name"));
        getLogger().info("The prefix is currently: " + config.getString("Prefix"));

    }
    @Override
    public void onDisable() {
        saveDefaultConfig();
        getLogger().info("SaxCoreX has been disabled, if you did not disable the plugin a bug may be in the plugin. Contact Saxbot Development on github if this problem persists.");
    }
}
