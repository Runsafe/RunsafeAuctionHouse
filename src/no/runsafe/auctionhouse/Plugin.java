package no.runsafe.auctionhouse;

import no.runsafe.auctionhouse.commands.NewAuction;
import no.runsafe.auctionhouse.database.AuctionsRepository;
import no.runsafe.framework.RunsafeConfigurablePlugin;
import no.runsafe.framework.features.Commands;
import no.runsafe.framework.features.Database;
import no.runsafe.framework.features.Events;

public class Plugin extends RunsafeConfigurablePlugin
{
	@Override
	protected void PluginSetup()
	{
		// Framework features
		addComponent(Commands.class);
		addComponent(Database.class);
		addComponent(Events.class);

		// Core
		this.addComponent(AuctionWindowManager.class);
		this.addComponent(AuctionHandler.class);

		// Commands
		this.addComponent(NewAuction.class);

		// Database
		this.addComponent(AuctionsRepository.class);
	}
}
