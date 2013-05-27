package no.runsafe.auctionhouse;

import no.runsafe.auctionhouse.commands.NewAuction;
import no.runsafe.auctionhouse.database.AuctionsRepository;
import no.runsafe.framework.RunsafePlugin;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		// Core
		this.addComponent(AuctionWindowManager.class);
		this.addComponent(AuctionHandler.class);

		// Commands
		this.addComponent(NewAuction.class);

		// Science
		// Database
		this.addComponent(AuctionsRepository.class);
	}
}
