execute as @e[type=block_display,tag=wolfshot] run scoreboard players add @s wolfshot_timer 1
$execute as @e[type=block_display,tag=wolfshot,scores={wolfshot_timer=20..}] as @p[tag=$(UUID)] at @s run function nuke:orbital_strike_cannon/wolfshot with storage nuke:uuid
execute as @e[type=block_display,tag=wolfshot,scores={wolfshot_timer=20..}] run kill @s
