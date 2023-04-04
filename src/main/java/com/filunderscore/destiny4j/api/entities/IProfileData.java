package com.filunderscore.destiny4j.api.entities;

import java.util.Date;

import com.filunderscore.destiny4j.api.entities.items.ICurrencyItem;
import com.filunderscore.destiny4j.api.entities.items.IInventory;
import com.filunderscore.destiny4j.api.entities.items.IItem;
import com.filunderscore.destiny4j.api.entities.vendors.IVendorReceipt;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IProfileData 
{
	Date getResponseMintedTimestamp();
	Date getSecondaryComponentsMintedTimestamp();
	
	IRestRequest<IVendorReceipt[]> getVendorReceipts();
	IRestRequest<IInventory<IItem>> getProfileInventory();
	
	IRestRequest<IInventory<ICurrencyItem>> getProfileCurrencyInventory();
	
}