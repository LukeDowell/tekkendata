package org.badgrades.tekkendata

import lombok.Builder
import java.time.LocalDateTime
import java.util.*

@Builder
data class Player(
    val id: UUID = UUID.randomUUID(), // The player's unique id
    val name: String = "" // The player's name
)

@Builder
data class Match(
    val id: UUID = UUID.randomUUID(),
    val p1: Pair<Player, String>, // Player one, pair of player and character name
    val p2: Pair<Player, String>, // Player two, pair of player and character name
    val startTime: LocalDateTime, // The time the match started
    val endTime: LocalDateTime, // The time the match ended
    val winner: Pair<Player, String> // The winner of the match, pair of player and character name
)

@Builder
data class Move(
    val command: String, // Input command
    val type: MoveType?, // Type of attack (LOW, MID, SPECIAL-MID, HIGH, UNBLOCKABLE)
    val startupFrames: Int, // Number of frames until the move is active
    val framesOnBlock: Int?, // Frame advantage / disadvantage on block (can be negative)
    val framesOnHit: Int?, // Frame advantage / disadvantage on hit (can be negative)
    val framesOnCounter: Int?, // Frame advantage / disadvantage on counter hit (can be negative)
    val activeFrame: Int?, // Number of frames for which the move is active
    val track: String?, // The move's tracking ability C-S, S being the best / homing
    val totalFrames: Int?, // The total number of frames in the move
    val recovery: Int?, // The number of frames before the attacker can act
    val opponentRecovery: Int?, // The number of frames before the defender can act
    val notes: String? // Additional move properties
)

enum class MoveType { THROW, LOW, SPECIAL_MID, MID, HIGH }