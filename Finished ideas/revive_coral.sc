__on_player_right_clicks_block (player, item_tuple,hand, block,face,hitvec) -> (
	l(item, count, nbt) = item_tuple || l('None', 0, null);
	position=pos(block);
	types=l('brain','bubble','fire','horn','tube');
	block=block-'dead_'-'_coral_block';
	if(item=='potion'&& types ~ block != null && nbt:'Potion' == 'minecraft:water',
		set(position,block+'_coral_block');
		gamemode=query(player,'gamemode');
		if(gamemode!='creative',
			inventory_set(player,query(player,'selected_slot'),1,'glass_bottle');
		);
	);
);