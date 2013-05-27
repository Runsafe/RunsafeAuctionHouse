package no.runsafe.auctionhouse;

import no.runsafe.auctionhouse.commands.NewAuction;
import no.runsafe.auctionhouse.database.AuctionsRepository;
import no.runsafe.framework.RunsafeConfigurablePlugin;

public class Plugin extends RunsafeConfigurablePlugin
{
	@Override
	protected void PluginSetup()
	{
		// Core
		this.addComponent(AuctionWindowManager.class);
		this.addComponent(AuctionHandler.class);

		// Commands
		this.addComponent(NewAuction.class);

		// Database
		this.addComponent(AuctionsRepository.class);
	}
}
