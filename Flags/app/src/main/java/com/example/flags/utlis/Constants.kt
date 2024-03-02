package com.example.flags.utlis

import com.example.flags.R
import com.example.flags.model.Questions

object Constants {

    const val UserName = "Username"
    const val total_questions = "total_questions"
    const val score = "Correct answers"
    fun getQuestions():MutableList<Questions>{
        val questions= mutableListOf<Questions>()

        val quest1= Questions(1,"What country does this flag belong?",
            R.drawable.afghanistan,"India","Iran","Afghanistan","Pakistan",
            3
        )
        questions.add(quest1)
        // Åland Islands
        val quest2 = Questions(2, "What country does this flag belong?",
            R.drawable._land_islands, "Sweden", "Åland Islands", "Norway", "Denmark",
            2
        )
        questions.add(quest2)

        // Albania
        val quest3 = Questions(3, "What country does this flag belong?",
            R.drawable.albania, "Greece", "Macedonia", "Montenegro", "Albania",
            4
        )
        questions.add(quest3)

        // Algeria
        val quest4 = Questions(4, "What country does this flag belong?",
            R.drawable.algeria, "Morocco", "Tunisia", "Algeria", "Libya",
            3
        )
        questions.add(quest4)

        // American Samoa
        val quest5 = Questions(5, "What territory does this flag represent?",
            R.drawable.american_samoa, "Hawaii", "Puerto Rico", "Guam", "American Samoa",
            4
        )
        questions.add(quest5)

        // Andorra
        val quest6 = Questions(6, "What country does this flag belong?",
            R.drawable.andorra, "Spain", "Andorra", "Portugal", "France",
            2
        )
        questions.add(quest6)

        // Angola
        val quest7 = Questions(7, "What country does this flag belong?",
            R.drawable.angola, "Namibia", "Congo", "Angola", "Zambia",
            3
        )
        questions.add(quest7)

        // Anguilla
        val quest8 = Questions(8, "What territory does this flag represent?",
            R.drawable.anguilla, "Bahamas", "Bermuda", "Anguilla", "Cayman Islands",
            3
        )
        questions.add(quest8)

        // Antarctica
        val quest9 = Questions(9, "Which continent does this flag represent?",
            R.drawable.antarctica, "Asia", "Europe", "Antarctica", "Australia",
            3
        )
        questions.add(quest9)

        // Antigua and Barbuda
        val quest10 = Questions(10, "What country does this flag belong?",
            R.drawable.antigua_and_barbuda, "Barbados", "Antigua and Barbuda", "Saint Kitts and Nevis", "Dominica",
            2
        )
        questions.add(quest10)


        return questions
    }
}