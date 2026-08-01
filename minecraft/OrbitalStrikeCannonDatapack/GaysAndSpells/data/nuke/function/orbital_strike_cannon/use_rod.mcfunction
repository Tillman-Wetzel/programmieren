execute store result storage nuke:uuid UUID int 1 run data get entity @s UUID[0] 1
execute if items entity @s weapon.mainhand fishing_rod run scoreboard players reset @s raycast_limit

execute if items entity @s weapon.mainhand fishing_rod[custom_data={wolfshot:1b}] run playsound item.shield.break player @a[distance=..10] ~ ~ ~ 30 1
execute if items entity @s weapon.mainhand fishing_rod[custom_data={arrowshot:1b}] run playsound item.shield.break player @a[distance=..10] ~ ~ ~ 30 1

execute if items entity @s weapon.mainhand fishing_rod[custom_data={wolfshot:1b}] anchored eyes run function nuke:orbital_strike_cannon/raycast/wolfshot/hit with storage nuke:uuid
execute if items entity @s weapon.mainhand fishing_rod[custom_data={arrowshot:1b}] anchored eyes run function nuke:orbital_strike_cannon/raycast/arrowshot/raycast

execute if items entity @s weapon.mainhand fishing_rod[custom_data={wolfshot:1b}] run item replace entity @s weapon.mainhand with air
execute if items entity @s weapon.mainhand fishing_rod[custom_data={arrowshot:1b}] run item replace entity @s weapon.mainhand with air