package com.example.dkt2.viewmodel

class ScoreViewModel(finalScore: Int) : BaseViewModel(){

    fun getScore(finalScore: Int): String {
        return "ViewModel is working! Your score is " + finalScore
    }
}