package org.badgrades.tekkendata

import java.io.File
import java.util.*

object MatchParser {

    fun parseFrameData(file: File) : Unit {
        val scanner = Scanner(file)
    }

    fun parseMatches(file: File) : Unit {
        val scanner = Scanner(file)
        val matches: MutableList<RawMatch> = mutableListOf()

        while (scanner.hasNext()) {
            val input = scanner.next().split("|")

            val rawMatch = RawMatch(
                    input[0].replace(" ", ""),
                    input[1].replace(" ", ""),
                    input[2],
                    input[4],
                    input[5].replace(" ", ""),
                    input[6].replace(" ", ""),
                    input[7].replace(" ", "")
            )

            matches.add(rawMatch)
        }

        matches.forEach(::println)
    }
}

data class RawMatch(
        val result: String,
        val playerOneName: String,
        val playerOneCharacter: String,
        val playerTwoName: String,
        val playerTwoCharacter: String,
        val runningTotal: String,
        val matchDate: String
)