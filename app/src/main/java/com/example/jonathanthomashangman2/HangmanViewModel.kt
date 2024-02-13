package com.example.jonathanthomashangman2

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import java.util.LinkedList
import kotlin.random.Random

private const val TAG = "HangmanViewModel"

class HangmanViewModel : ViewModel() {

    private var letters = mutableListOf(
        Letter(R.id.letter1, R.drawable.bar4),
        Letter(R.id.letter2, R.drawable.bar4),
        Letter(R.id.letter3, R.drawable.bar4),
        Letter(R.id.letter4, R.drawable.bar4),
        Letter(R.id.letter5, R.drawable.bar4),
        Letter(R.id.letter6, R.drawable.bar4),
        Letter(R.id.letter7, R.drawable.bar4),
        Letter(R.id.letter8, R.drawable.bar4),
        Letter(R.id.letter9, R.drawable.bar4)
      )

    private var buttons = mutableListOf(
        Button(R.id.buttonA, R.drawable.button_a_enabled_blue, true),
        Button(R.id.buttonB, R.drawable.button_b_enabled_blue, true),
        Button(R.id.buttonC, R.drawable.button_c_enabled_blue, true),
        Button(R.id.buttonD, R.drawable.button_d_enabled_blue, true),
        Button(R.id.buttonE, R.drawable.button_e_enabled_blue, true),
        Button(R.id.buttonF, R.drawable.button_f_enabled_blue, true),
        Button(R.id.buttonG, R.drawable.button_g_enabled_blue, true),
        Button(R.id.buttonH, R.drawable.button_h_enabled_blue, true),
        Button(R.id.buttonI, R.drawable.button_i_enabled_blue, true),
        Button(R.id.buttonJ, R.drawable.button_j_enabled_blue, true),
        Button(R.id.buttonK, R.drawable.button_k_enabled_blue, true),
        Button(R.id.buttonL, R.drawable.button_l_enabled_blue, true),
        Button(R.id.buttonM, R.drawable.button_m_enabled_blue, true),
        Button(R.id.buttonN, R.drawable.button_n_enabled_blue, true),
        Button(R.id.buttonO, R.drawable.button_o_enabled_blue, true),
        Button(R.id.buttonP, R.drawable.button_p_enabled_blue, true),
        Button(R.id.buttonQ, R.drawable.button_q_enabled_blue, true),
        Button(R.id.buttonR, R.drawable.button_r_enabled_blue, true),
        Button(R.id.buttonS, R.drawable.button_s_enabled_blue, true),
        Button(R.id.buttonT, R.drawable.button_t_enabled_blue, true),
        Button(R.id.buttonU, R.drawable.button_u_enabled_blue, true),
        Button(R.id.buttonV, R.drawable.button_v_enabled_blue, true),
        Button(R.id.buttonW, R.drawable.button_w_enabled_blue, true),
        Button(R.id.buttonX, R.drawable.button_x_enabled_blue, true),
        Button(R.id.buttonY, R.drawable.button_y_enabled_blue, true),
        Button(R.id.buttonZ, R.drawable.button_z_enabled_blue, true)
    )

    private val wordBank = listOf(
        Word(R.string.word1, listOf('A', 'P', 'P', 'L', 'E'),5),
        Word(R.string.word2, listOf('B', 'A', 'C', 'K', 'P','A','C','K'),8),
        Word(R.string.word3, listOf('C', 'A', 'T'),3))

    private var instructions = R.string.instr2

    private var currentWord = Random.nextInt(0, wordBank.size - 1)

    private var nextHang = 0

    private var rem = wordBank[currentWord].length

    val getInstr: Int
        get() = instructions

    fun setInstr(i: Int) {
        instructions = i
    }

    val getCurrentWord: Int
        get() = currentWord

    fun setWord(i: Int) {
        currentWord = i
    }

    val getRem: Int
        get() = rem

    fun setRem(i: Int) {
        rem = i
    }

    fun decrRem() {
        rem -= 1
    }

    fun getLetter(i : Int) : Letter {
        return letters[i]
    }

    fun setLetter(i : Int, image: Int) {
        letters[i].imageId = image
    }

    fun getButton(i: Int): Button {
        return buttons[i]
    }

    fun setButton(i : Int, image: Int, enable: Boolean) {
        buttons[i].imageId = image
        buttons[i].enabled = enable
    }

    val getNextHang: Int
        get() = nextHang

    fun resetHang() {
        nextHang = 0
    }

    fun incrHang() {
        nextHang += 1
    }

    fun resetLetters() {
        /*for (i in 0..8) {
            letters[i].imageId = R.drawable.bar4
        }*/
        letters = mutableListOf(
            Letter(R.id.letter1, R.drawable.bar4),
            Letter(R.id.letter2, R.drawable.bar4),
            Letter(R.id.letter3, R.drawable.bar4),
            Letter(R.id.letter4, R.drawable.bar4),
            Letter(R.id.letter5, R.drawable.bar4),
            Letter(R.id.letter6, R.drawable.bar4),
            Letter(R.id.letter7, R.drawable.bar4),
            Letter(R.id.letter8, R.drawable.bar4),
            Letter(R.id.letter9, R.drawable.bar4)
        )
    }

    fun resetButtons() {
        buttons = mutableListOf(
            Button(R.id.buttonA, R.drawable.button_a_enabled_blue, true),
            Button(R.id.buttonB, R.drawable.button_b_enabled_blue, true),
            Button(R.id.buttonC, R.drawable.button_c_enabled_blue, true),
            Button(R.id.buttonD, R.drawable.button_d_enabled_blue, true),
            Button(R.id.buttonE, R.drawable.button_e_enabled_blue, true),
            Button(R.id.buttonF, R.drawable.button_f_enabled_blue, true),
            Button(R.id.buttonG, R.drawable.button_g_enabled_blue, true),
            Button(R.id.buttonH, R.drawable.button_h_enabled_blue, true),
            Button(R.id.buttonI, R.drawable.button_i_enabled_blue, true),
            Button(R.id.buttonJ, R.drawable.button_j_enabled_blue, true),
            Button(R.id.buttonK, R.drawable.button_k_enabled_blue, true),
            Button(R.id.buttonL, R.drawable.button_l_enabled_blue, true),
            Button(R.id.buttonM, R.drawable.button_m_enabled_blue, true),
            Button(R.id.buttonN, R.drawable.button_n_enabled_blue, true),
            Button(R.id.buttonO, R.drawable.button_o_enabled_blue, true),
            Button(R.id.buttonP, R.drawable.button_p_enabled_blue, true),
            Button(R.id.buttonQ, R.drawable.button_q_enabled_blue, true),
            Button(R.id.buttonR, R.drawable.button_r_enabled_blue, true),
            Button(R.id.buttonS, R.drawable.button_s_enabled_blue, true),
            Button(R.id.buttonT, R.drawable.button_t_enabled_blue, true),
            Button(R.id.buttonU, R.drawable.button_u_enabled_blue, true),
            Button(R.id.buttonV, R.drawable.button_v_enabled_blue, true),
            Button(R.id.buttonW, R.drawable.button_w_enabled_blue, true),
            Button(R.id.buttonX, R.drawable.button_x_enabled_blue, true),
            Button(R.id.buttonY, R.drawable.button_y_enabled_blue, true),
            Button(R.id.buttonZ, R.drawable.button_z_enabled_blue, true)
        )
    }

}