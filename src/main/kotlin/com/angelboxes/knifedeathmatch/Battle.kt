package com.angelboxes.knifedeathmatch

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Battle {

    var player1: Player
    var player2: Player

    constructor(player1: Player, player2: Player) {
        this.player1 = player1
        this.player2 = player2
    }

    fun start() {
        var battleOn = true;
        runBlocking {
            coroutineScope {
                launch(CoroutineName("player-${player1.getPlayerId()}")) {
                    while (battleOn) {
                        if (!player1.isKO() && player1.isStanding()) {
                            player1.executeRandomCommand(player2)
                        } else if (player1.isKO()) {
                            battleOn = false
                            println("Player 1 Lost, Player 2 Wins")
                        }
                    }
                }
                launch(CoroutineName("player-${player2.getPlayerId()}")) {
                    while (battleOn) {
                        if (!player2.isKO() && player2.isStanding()) {
                            player2.executeRandomCommand(player1)
                        } else if (player1.isKO()) {
                            battleOn = false
                            println("Player 2 Lost, Player 1 Wins")
                        }
                    }
                }
            }

        }

    }

}