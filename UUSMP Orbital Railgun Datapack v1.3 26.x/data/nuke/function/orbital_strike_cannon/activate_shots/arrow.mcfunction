execute as @e[type=block_display,tag=arrowshot] run scoreboard players add @s arrowshot_timer 1
execute as @e[type=block_display,tag=arrowshot,scores={arrowshot_timer=20..}] at @s run function nuke:orbital_strike_cannon/arrowshot
execute as @e[type=block_display,tag=arrowshot,scores={arrowshot_timer=20..}] run kill @s