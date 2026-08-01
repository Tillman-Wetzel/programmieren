execute as @e[type=block_display,tag=nukeshot] run scoreboard players add @s nukeshot_timer 1
execute as @e[type=block_display,tag=nukeshot,scores={nukeshot_timer=20..}] at @s run function nuke:orbital_strike_cannon/nukeshot
execute as @e[type=block_display,tag=nukeshot,scores={nukeshot_timer=20..}] run kill @s