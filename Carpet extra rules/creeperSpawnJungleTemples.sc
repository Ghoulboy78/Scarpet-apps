//Carpet rule
//By: Ghoulboy

import('func_lib','__in_volume','__distance');

__config()->m(l('scope','global'));

__on_tick()->(
    for(filter(entity_selector('@e'),_~'category'=='monster'&&_~'type'!='creeper'),
        m=_;
        l(x,y,z)=pos(m);
        if(query(m,'has_tag','player_nearby'),
            if(p=filter(entity_area('players',x,y,z,24,24,24),__distance(pos(_),pos(m),'euclidean')<=24),
                modify(m,'tag','player_nearby');
                return()
            );
            box_1 = structures(x,y,z):'jungle_temple':0;
            box_2 = structures(x,y,z):'jungle_temple':1;
            if(__in_volume(box_1,box_2,__block_pos(m)),
                spawn('creeper',pos(m));
                modify(m,'remove')
            )
        )
    )
)