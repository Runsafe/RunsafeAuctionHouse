package no.runsafe.auctionhouse.database;

import no.runsafe.auctionhouse.Auction;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.database.IDatabase;
import no.runsafe.framework.api.database.Repository;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AuctionsRepository extends Repository
{
	public AuctionsRepository(IDatabase database, IServer server)
	{
		this.database = database;
		this.server = server;
	}

	public String getTableName()
	{
		return "auctions";
	}

	public void storeAuction(Auction auction)
	{
		RunsafeInventory holder = server.createInventory(null, 9);
		holder.addItems(auction.getItem());

		int[] currentBid = auction.getCurrentBid();
		int[] buyoutBid = auction.getBuyoutPrice();

		this.database.Execute(
			"INSERT INTO auctions (" +
				"owner," +
				"item," +
				"ends," +
				"lowCurrentBid," +
				"medCurrentBid," +
				"highCurrentBid," +
				"lowBuyout," +
				"medBuyout," +
				"highBuyout)" +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
			auction.getPlayer().getName(),
			holder.serialize(),
			auction.getEnding(),
			currentBid[0],
			currentBid[1],
			currentBid[2],
			buyoutBid[0],
			buyoutBid[1],
			buyoutBid[2]
		);
	}

	@Override
	public HashMap<Integer, List<String>> getSchemaUpdateQueries()
	{
		HashMap<Integer, List<String>> versions = new HashMap<Integer, List<String>>();
		ArrayList<String> sql = new ArrayList<String>();

		sql.add(
			"CREATE TABLE `auctions` (" +
				"`ID` int(10) NOT NULL AUTO_INCREMENT," +
				"`owner` varchar(50) NOT NULL," +
				"`item` longtext," +
				"`ends` DATETIME," +
				"`lowCurrentBid` int(4) NOT NULL DEFAULT '0'," +
				"`medCurrentBid` int(4) NOT NULL DEFAULT '0'," +
				"`highCurrentBid` int(4) NOT NULL DEFAULT '0'," +
				"`lowBuyout` int(4) NOT NULL DEFAULT '0'," +
				"`medBuyout` int(4) NOT NULL DEFAULT '0'," +
				"`highBuyout` int(4) NOT NULL DEFAULT '0'," +
				"PRIMARY KEY (`ID`)" +
				")"
		);

		versions.put(1, sql);
		return versions;
	}

	IDatabase database;
	private final IServer server;
}
