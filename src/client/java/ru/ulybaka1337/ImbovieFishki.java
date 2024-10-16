package ru.ulybaka1337;

import ru.ulybaka1337.commands.ExampleCommand;
import ru.ulybaka1337.hud.ExampleHudElement;
import ru.ulybaka1337.modules.CloseGUIWIthoutPacket;
import ru.ulybaka1337.modules.ExampleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thunder.hack.api.IAddon;
import thunder.hack.features.cmd.Command;
import thunder.hack.features.hud.HudElement;
import thunder.hack.features.modules.Module;

import java.util.Arrays;
import java.util.List;

public class ImbovieFishki implements IAddon {
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		LOGGER.info("IMBOVIEFISHKI has initialized");
	}

	@Override
	public List<Module> getModules() {
		// Return a list of your modules here
		return Arrays.asList(new CloseGUIWIthoutPacket());
	}

	@Override
	public List<Command> getCommands() {
		return null;
	}

	@Override
	public List<HudElement> getHudElements() {
		return null;
	}

	@Override
	public String getPackage() {
		return "ru.ulybaka1337";
	}

	@Override
	public String getName() {
		return "Imboviefishki";
	}

	@Override
	public String getAuthor() {
		return "ulybaka1337";
	}

	@Override
	public String getRepo() {
		return "https://github.com/ulybaka1337/imboviefishki";
	}

	@Override
	public String getVersion() {
		return "1.0.0";
	}
}