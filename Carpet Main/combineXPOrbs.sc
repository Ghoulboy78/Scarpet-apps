//Inspired by carpet rule
//By: Ghoulboy

__command()->null;

global_merge_radius = 0.5;//the radius around which to search for nearby xp orbs. By default set to 0.5 so it will collide, but can be increased
global_merge_speed = 50;//the speed (in ticks) at which merges occur. 50 (default) means that orbs will merge evry 50 ticks. Values less than 1 will still means evry tick, as you can't go faster than that.

change_merge_radius(radius)->global_merge_radius=radius;//Making it more customizable

change_merge_speed(speed)->global_merge_speed=speed;//Making it more customizable

__on_tick()->(
    for(entity_selector('@e[type=experience_orb]'),
        if(_~'age'<global_merge_speed,continue(),orb1=_);
        [x1,y1,z1]=pos(orb1);
        orb2=first(entity_area('experience_orb',x1,y1,z1,global_merge_radius,global_merge_radius,global_merge_radius),_!=orb1 && _~'age'>=global_merge_speed);
        if(orb2,
            s=spawn('experience_orb',(pos(orb1)+pos(orb2))/2,str('{Age:0,Value:%s}',orb1~'nbt':'Value'+orb2~'nbt':'Value'));
            modify(orb1,'remove');
            modify(orb2,'remove')
        )
    )
)
