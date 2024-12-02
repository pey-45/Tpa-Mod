package tpapey;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import tpapey.commands.DefaultTpaManager;
import tpapey.commands.TpaSender;

public class TpaPey implements ModInitializer {
	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTED.register(server -> DefaultTpaManager.loadData());
		ServerLifecycleEvents.SERVER_STOPPING.register(server -> DefaultTpaManager.saveData());

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
				TpaSender.registerCommands(dispatcher));
	}
}
