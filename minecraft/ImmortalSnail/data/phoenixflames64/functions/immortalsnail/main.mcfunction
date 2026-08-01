##
 # main.mcfunction
 # immortalsnail
 #
 # Created by PhoenixFlames64.
##

bossbar set minecraft:distancetosnail players @a
bossbar set minecraft:timeuntilsnail players @a

execute if stopwatch minecraft:timeuntilsnail 0..120 store result bossbar minecraft:timeuntilsnail value run stopwatch query minecraft:timeuntilsnail
