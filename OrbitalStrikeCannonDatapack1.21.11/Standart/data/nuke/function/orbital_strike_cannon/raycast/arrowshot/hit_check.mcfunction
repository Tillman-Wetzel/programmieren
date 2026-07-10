# HIT BLOCK
execute unless block ~ ~ ~ air run summon block_display ~ ~ ~ {Tags:["arrowshot"]}
execute unless block ~ ~ ~ air run return 0

# MAX RANGE
execute if score @s raycast_limit matches 180.. run summon block_display ~ ~ ~ {Tags:["arrowshot"]}
execute if score @s raycast_limit matches 180.. run return 0

# CONTINUE
scoreboard players add @s raycast_limit 1
execute positioned ^ ^ ^0.8 run function nuke:orbital_strike_cannon/raycast/arrowshot/hit_check
