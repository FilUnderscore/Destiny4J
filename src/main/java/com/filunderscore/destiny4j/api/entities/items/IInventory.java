package com.filunderscore.destiny4j.api.entities.items;

public interface IInventory<ItemType extends IItem>
{
	ItemType[] getItems();
}