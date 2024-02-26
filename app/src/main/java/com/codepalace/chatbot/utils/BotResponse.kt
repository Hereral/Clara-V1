package com.codepalace.chatbot.utils

import com.codepalace.chatbot.utils.Constants.OPEN_GOOGLE
import com.codepalace.chatbot.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message = _message.lowercase(Locale.getDefault()) //_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve")  -> {
                val equation: String = message.substringAfterLast("solve") //String?
                return try {
                    val answer = SolveMath.solveMath(equation) //(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //Hello
            message.contains("hi") || message.contains("hoy") || message.contains("hey") -> {
                when (random) {
                    0 -> "Hello"
                    1 -> "Sup!"
                    2 -> "Yo?"
                    else -> "error" }
            }

            //Java
            message.contains("java") || message.contains("what is Java") || message.contains("java programming") -> {
                when (random) {
                    0 -> "Java is a popular programming language.\n" +
                    "\n" +
                "Java is used to develop mobile apps, web apps, desktop apps, games and much more."
                    1 -> "Developed by Sun Microsystems in 1995, Java is a highly popular, object-oriented programming language. This platform independent programming language is utilized for Android development, web development, artificial intelligence, cloud applications, and much more."
                    2 -> "Java is a programming language and a platform. Java is a high level, robust, object-oriented and secure programming language.\n" +
                            "\n" +
                            "Java was developed by Sun Microsystems (which is now the subsidiary of Oracle) in the year 1995. James Gosling is known as the father of Java. Before Java, its name was Oak. Since Oak was already a registered company, so James Gosling and his team changed the name from Oak to Java."
                    else -> "error" }
            }

            message.contains("class") || message.contains("Java class") || message.contains("what is class") -> {
                when (random) {
                    0 -> "class is blahb lah."
                    1 -> "e"
                    2 -> "class is blahb lah."
                    else -> "error" }
            }

            message.contains("class example") || message.contains("example of classes") || message.contains("classes example") -> {
                when (random) {
                    0 -> "example."
                    1 -> "exam,plee"
                    2 -> "exam"
                    else -> "error" }
            }



            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}