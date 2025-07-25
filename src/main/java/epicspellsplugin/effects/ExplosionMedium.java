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
package epicspellsplugin.effects;

import epicspellsplugin.utils.DirectionalParticleCollection;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class ExplosionMedium {

    public ExplosionMedium(World world, Location location, boolean spawnFire){
        List<DirectionalParticleCollection> particles = new ArrayList<>();
        Vector velocity = new Vector();
        particles.add(new DirectionalParticleCollection(world, Particle.SMALL_FLAME, location, velocity, 80, 0.3));
        particles.add(new DirectionalParticleCollection(world, Particle.LARGE_SMOKE, location, velocity, 30, 0.3));
        particles.add(new DirectionalParticleCollection(world, Particle.SMOKE, location, velocity, 40, 0.3));
        particles.add(new DirectionalParticleCollection(world, Particle.CAMPFIRE_COSY_SMOKE, location, velocity, 40, 0.1));

        new RealisticExplosion(world, location, 5, particles, 0.2, spawnFire);
    }
}
