package de.jaunikapauni.axnametags.listener;

import de.jaunikapauni.axnametags.AxNameTags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    AxNameTags reference;
    public PlayerJoinListener(AxNameTags reference){
        this.reference = reference;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        reference.setNameTag(e.getPlayer());
    }
}
