execute as @a if score @s use_rod matches 1.. if items entity @s weapon.mainhand fishing_rod[custom_data={stabshot:1b}] at @s run function nuke:orbital_strike_cannon/use_rod
execute as @a if score @s use_rod matches 1.. if items entity @s weapon.mainhand fishing_rod[custom_data={nukeshot:1b}] at @s run function nuke:orbital_strike_cannon/use_rod
execute as @a if score @s use_rod matches 1.. if items entity @s weapon.mainhand fishing_rod[custom_data={wolfshot:1b}] at @s run function nuke:orbital_strike_cannon/use_rod
scoreboard players set @a use_rod 0

execute as @e[type=block_display,tag=stabshot] run function nuke:orbital_strike_cannon/activate_shots/stab
execute as @e[type=block_display,tag=nukeshot] run function nuke:orbital_strike_cannon/activate_shots/nuke
execute as @e[type=block_display,tag=wolfshot] run function nuke:orbital_strike_cannon/activate_shots/wolf with storage nuke:uuid
