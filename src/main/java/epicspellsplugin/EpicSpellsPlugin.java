/*
 * Copyright (C) 2022 M0rica
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package epicspellsplugin;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import epicspellsplugin.spellcasting.Spellcaster;

/**
 *
 * @author M0rica
 */
public class EpicSpellsPlugin extends JavaPlugin{
    
    private Logger log;
    private BukkitScheduler scheduler;
    private Spellcaster spellcaster;

    @Override
    public void onEnable(){
        log = this.getLogger();
        spellcaster = new Spellcaster(log);
        
        scheduler = Bukkit.getScheduler();
        setup();
        
        log.info("Plugin enabled");
    }
    @Override
    public void onDisable(){
        log.info("Plugin disabled");
    }

    public Spellcaster getSpellcaster() { return spellcaster; }

    public void setup(){
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                spellcaster.tick();
            }
        }, 1, 1);
    }
}
