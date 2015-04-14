# hbv401g-2015v-f1a
Fantasy Football simulator

# Setup
Choose a directory to use for the project. These instructions will assume you chose a directory called 'fantasy-football' in your home directory. Open up a shell and change to the directory you chose.

	$ cd ~
	$ mkdir fantasy-football
	$ cd fantasy-football

Clone this repository into a src folder and also clone the other group's repository into a directory of your choice.

	$ git clone git@github.com:nori/hbv401g-2015v-f1a.git .
	$ git clone git@github.com:birkz/fantasy-football.git src/is/hi/f2a
    $ gradle run


# Simulation
* The teams will be the top 10 teams in the Premiership when the game is started.
* Schedule games correctly
* Home team advantage

# Price system
* Based on performance

# Data/APIs
* http://www.football-data.org/soccerseasons/354/ranking
* http://fantasy.premierleague.com/web/api/elements/6/

# Player attributes
* TODO

# Point system
## Goals
1. Goalkeeper scores
2. Defender scores
3. Midfielder scores
4. Striker scores

## Assists
1. Goalkeeper assists
2. Everyone else

## Negative points
1. Red card
2. Own goal
3. Yellow card

## Other
1. Playtime
2. Clean sheet for goalkeepers
