##
 # reset.mcfunction
 # immortalsnail
 #
 # Created by PhoenixFlames64.
##

stopwatch create timeuntilsnail
stopwatch restart minecraft:timeuntilsnail

bossbar add timeuntilsnail "The Immortal Snail is coming in _ seconds"
bossbar set minecraft:timeuntilsnail color yellow
bossbar add distancetosnail "The Immortal Snail is _ blocks away from you."
bossbar set minecraft:distancetosnail color red

bossbar set minecraft:timeuntilsnail visible true
bossbar set minecraft:distancetosnail visible false