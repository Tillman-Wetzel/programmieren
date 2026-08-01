execute as @e[type=block_display,tag=stabshot] run scoreboard players add @s stabshot_timer 1
execute as @e[type=block_display,tag=stabshot,scores={stabshot_timer=20..}] at @s run function nuke:orbital_strike_cannon/stabshot
execute as @e[type=block_display,tag=stabshot,scores={stabshot_timer=20..}] run kill @s