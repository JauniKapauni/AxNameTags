package de.jaunikapauni.axnametags;

import de.jaunikapauni.axnametags.listener.PlayerJoinListener;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public final class AxNameTags extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void setNameTag(Player p){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("below_name", "dummy", PlaceholderAPI.setPlaceholders(p, getConfig().getString("value")));
        objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective.getScore(p.getName()).setScore(1);
        p.setScoreboard(scoreboard);
    }
}
