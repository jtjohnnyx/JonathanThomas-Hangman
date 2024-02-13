package com.example.jonathanthomashangman2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.jonathanthomashangman2.databinding.ActivityMainBinding
import java.util.LinkedList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var letters: MutableList<ImageView>

    private val newhang = LinkedList(listOf(
        R.drawable.hang_empty3,
        R.drawable.hang_head,
        R.drawable.hang_body,
        R.drawable.hang_larm,
        R.drawable.hang_rarm,
        R.drawable.hang_lleg,
        R.drawable.hang_rleg))
    //hang.add(R.drawable.hang_head)
    //hang.add(R.drawable.hang_body)
    //hang.add(R.drawable.hang_larm)
    //hang.add(R.drawable.hang_rarm)
    //hang.add(R.drawable.hang_lleg)
    //hang.add(R.drawable.hang_rleg)

    private val wordBank = listOf(
        Word(R.string.word1, listOf('A', 'P', 'P', 'L', 'E'), LinkedList(),5),
        Word(R.string.word2, listOf('B', 'A', 'C', 'K', 'P','A','C','K'), LinkedList(),8),
        Word(R.string.word3, listOf('C', 'A', 'T'), LinkedList(),3))

    private var currentIndex = -1
    
    private var rem = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val wordId = wordBank[currentIndex].textResId
        //val ls = wordBank[currentIndex].ls
        //val length = wordBank[currentIndex].length
        //var rem = length
        //ar done = false
        disableButtons()

        binding.newgame?.setOnClickListener {
            var rand : Int
            do {
                rand = Random.nextInt(0, wordBank.size) // Generates a random number from 1 to 10
            } while (rand == currentIndex)
            currentIndex = rand
            //currentIndex += 1
            displayLetters(wordBank[currentIndex].length)
            enableButtons()
            rem = wordBank[currentIndex].length
            //Log.d("Remainder", "$rem")
            wordBank[currentIndex].hang = LinkedList(newhang)
            //Log.d("LL", newhang.toString())
            binding.instructions.text = getString(R.string.instr2)
            binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())
        }

        binding.buttonA?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'A') {
                    letters[i].setImageResource(R.drawable.bar_a)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonA!!.setImageResource(R.drawable.button_a_disabled_blue)
            binding.buttonA!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonB?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'B') {
                    letters[i].setImageResource(R.drawable.bar_b)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonB!!.setImageResource(R.drawable.button_b_disabled_blue)
            binding.buttonB!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonC?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'C') {
                    letters[i].setImageResource(R.drawable.bar_c)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonC!!.setImageResource(R.drawable.button_c_disabled_blue)
            binding.buttonC!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonD?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'D') {
                    letters[i].setImageResource(R.drawable.bar_d)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonD!!.setImageResource(R.drawable.button_d_disabled_blue)
            binding.buttonD!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonE?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'E') {
                    letters[i].setImageResource(R.drawable.bar_e)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonE!!.setImageResource(R.drawable.button_e_disabled_blue)
            binding.buttonE!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonF?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'F') {
                    letters[i].setImageResource(R.drawable.bar_f)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonF!!.setImageResource(R.drawable.button_f_disabled_blue)
            binding.buttonF!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonG?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'G') {
                    letters[i].setImageResource(R.drawable.bar_g)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonG!!.setImageResource(R.drawable.button_g_disabled_blue)
            binding.buttonG!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonH?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'H') {
                    letters[i].setImageResource(R.drawable.bar_h)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonH!!.setImageResource(R.drawable.button_h_disabled_blue)
            binding.buttonH!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonI?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'I') {
                    letters[i].setImageResource(R.drawable.bar_i)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonI!!.setImageResource(R.drawable.button_i_disabled_blue)
            binding.buttonI!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonJ?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'J') {
                    letters[i].setImageResource(R.drawable.bar_j)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonJ!!.setImageResource(R.drawable.button_j_disabled_blue)
            binding.buttonJ!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonK?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'K') {
                    letters[i].setImageResource(R.drawable.bar_k)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonK!!.setImageResource(R.drawable.button_k_disabled_blue)
            binding.buttonK!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonL?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'L') {
                    letters[i].setImageResource(R.drawable.bar_l)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonL!!.setImageResource(R.drawable.button_l_disabled_blue)
            binding.buttonL!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonM?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'M') {
                    letters[i].setImageResource(R.drawable.bar_m)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonM!!.setImageResource(R.drawable.button_m_disabled_blue)
            binding.buttonM!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonN?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'N') {
                    letters[i].setImageResource(R.drawable.bar_n)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonN!!.setImageResource(R.drawable.button_n_disabled_blue)
            binding.buttonN!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonO?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'O') {
                    letters[i].setImageResource(R.drawable.bar_o)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonO!!.setImageResource(R.drawable.button_o_disabled_blue)
            binding.buttonO!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonP?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'P') {
                    letters[i].setImageResource(R.drawable.bar_p)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonP!!.setImageResource(R.drawable.button_p_disabled_blue)
            binding.buttonP!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonQ?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'Q') {
                    letters[i].setImageResource(R.drawable.bar_q)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonQ!!.setImageResource(R.drawable.button_q_disabled_blue)
            binding.buttonQ!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonR?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'R') {
                    letters[i].setImageResource(R.drawable.bar_r)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonR!!.setImageResource(R.drawable.button_r_disabled_blue)
            binding.buttonR!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonS?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'S') {
                    letters[i].setImageResource(R.drawable.bar_s)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonS!!.setImageResource(R.drawable.button_s_disabled_blue)
            binding.buttonS!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonT?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'T') {
                    letters[i].setImageResource(R.drawable.bar_t)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonT!!.setImageResource(R.drawable.button_t_disabled_blue)
            binding.buttonT!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonU?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'U') {
                    letters[i].setImageResource(R.drawable.bar_u)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonU!!.setImageResource(R.drawable.button_u_disabled_blue)
            binding.buttonU!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonV?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'V') {
                    letters[i].setImageResource(R.drawable.bar_v)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonV!!.setImageResource(R.drawable.button_v_disabled_blue)
            binding.buttonV!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonW?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'W') {
                    letters[i].setImageResource(R.drawable.bar_w)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            //binding.buttonW!!.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.darker_gray)
            binding.buttonW!!.setImageResource(R.drawable.button_w_disabled_blue)
            binding.buttonW!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonX?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'X') {
                    letters[i].setImageResource(R.drawable.bar_x)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonX!!.setImageResource(R.drawable.button_x_disabled_blue)
            binding.buttonX!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonY?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'Y') {
                    letters[i].setImageResource(R.drawable.bar_y)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonY!!.setImageResource(R.drawable.button_y_disabled_blue)
            binding.buttonY!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

        binding.buttonZ?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[currentIndex].length) {
                if ( wordBank[currentIndex].ls[i] == 'Z') {
                    letters[i].setImageResource(R.drawable.bar_z)
                    found = true
                    rem -= 1
                }
            }
            if (!found)
                binding.hang?.setImageResource(wordBank[currentIndex].hang.poll())

            binding.buttonZ!!.setImageResource(R.drawable.button_z_disabled_blue)
            binding.buttonZ!!.isEnabled = false
            isDone(rem, wordBank[currentIndex].hang)

        }

    }

    private fun displayLetters(length: Int) {
        letters = mutableListOf()
        for (i in 1..9) {
            val letterId = resources.getIdentifier("letter$i", "id", packageName)
            val letterView = findViewById<ImageView>(letterId)
            if (letterView != null) {
                letters.add(letterView)
                letterView.setImageResource(R.drawable.bar4)
                if (i <= length)
                    letterView.visibility = View.VISIBLE
                else
                    letterView.visibility = View.INVISIBLE
            }
        }
    }

    private fun isDone(rem: Int, hang: LinkedList<Int>): Boolean {
        var instr = findViewById<TextView>(R.id.instructions)

        if (rem == 0) {
            instr.text = getString(R.string.instr3)
            disableButtons()
            return true
        }
        if (hang.size == 0) {
            instr.text = getString(R.string.instr4)
            disableButtons()
            return true
        }
        return false
    }
    
    private fun disableButtons() {
        for (char in 'A'..'Z') {
            val buttonId = resources.getIdentifier("button$char", "id", packageName)
            val imageId = resources.getIdentifier("button_${char.lowercaseChar()}_disabled_blue", "drawable", packageName)
            val buttonView = findViewById<ImageButton>(buttonId)
            if (buttonView != null) {
                //buttonView.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.darker_gray)
                buttonView.setImageResource(imageId)
                buttonView.isEnabled = false
            }
        }
    }

    private fun enableButtons() {
        for (char in 'A'..'Z') {
            val buttonId = resources.getIdentifier("button$char", "id", packageName)
            val imageId = resources.getIdentifier("button_${char.lowercaseChar()}_enabled_blue", "drawable", packageName)
            val buttonView = findViewById<ImageButton>(buttonId)
            if (buttonView != null) {
                buttonView.setImageResource(imageId)
                buttonView.isEnabled = true
            }
        }
    }

}