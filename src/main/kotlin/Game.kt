import java.util.*

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

// The will get the game to choose an option
// which is one of "Rock", "Paper", or "Scissors" at random.
fun getGameChoice(optionsParam: Array<String>) =
        optionsParam [ (Math.random() * optionsParam.size).toInt() ]

// This will ask the user to enter their choice.
// This will also make sure the user enters a valid choice
// and if they haven't, it will keep asking them until they do.
fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
//    Loop until the user enters a valid choice
    while (!isValidChoice) {
//        Ask the user for their choice
        print("Please enter one of the following:")
        for (item in optionsParam) print(" $item")
        println(".")
//        Read the user input
        val userInput = readLine()?.replaceFirstChar {
                                        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
//        Validate the user input
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
//        If the choice is invalid, inform the user
        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

// This will figure out whether the user won or lost, or whether
// the result is a tie and will then print the result.
fun printResult(userChoice: String, gameChoice: String) {
    //    Figure out the result
    val result: String = if (userChoice == gameChoice) "Tie!"
    else if ( (userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper") ) "You win!"
    else "You lose!"
//    Print the result
    println("You chose $userChoice. I chose $gameChoice. $result")
}