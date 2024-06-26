package net.frostbyte.skipservercheck;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkipServerMovementCheck implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("skipservercheck");

	@Override
	public void onInitialize() {
		LOGGER.info("Server Movement Check Disabled");
	}
}